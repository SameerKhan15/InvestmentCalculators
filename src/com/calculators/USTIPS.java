package com.calculators;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;

public class USTIPS 
{	
	public static void main(String args[])
	{
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(System.getProperty("user.dir") + "/config/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Configure Inputs
		double bondCoupon = Double.valueOf(props.getProperty("BondCoupon"));
		int maturityYear = Integer.valueOf(props.getProperty("BondMaturityYear"));
		int maturityMonth = Integer.valueOf(props.getProperty("BondMaturityMonth"));
		int maturityDay = Integer.valueOf(props.getProperty("BondMaturityDay"));			
		double expectedInflationRate = Double.valueOf(props.getProperty("ExplectedInflationRate"));
		double bondPurchaseAmount = Double.valueOf(props.getProperty("BondPurchaseAmount"));
		double bondParVal = Double.valueOf(props.getProperty("BondParValue"));
		boolean tipsInTaxDeferredAccount = Boolean.getBoolean(props.getProperty("BondHeldInTaxAdvantageAccount"));
		double topMarginalTaxRate = Double.valueOf(props.getProperty("TopMarginalTaxRate")); 
		
		int timeToMaturityInMonths = Util.getNumMonthsTillMaturity(maturityYear, maturityMonth, maturityDay);
		double totalTaxPaid = 0;
		double totalCouponInterestEarnings = 0;
		double inflationAdjustedParVal = bondParVal;
		double paidPremiumAmount = bondPurchaseAmount - bondParVal;
		double inflationAdjustedPaidPremiumVal = 0;
		
		if(paidPremiumAmount > 0)
		{
			inflationAdjustedPaidPremiumVal = paidPremiumAmount;
		}
		
		double deltaBtwParAndPurchaseAmount = bondParVal - bondPurchaseAmount;
		
		for(int a = 0 ; a < timeToMaturityInMonths ; a++)
		{
			inflationAdjustedPaidPremiumVal = inflationAdjustedPaidPremiumVal + (inflationAdjustedPaidPremiumVal * ((expectedInflationRate/12)/100));
			
			if(!tipsInTaxDeferredAccount)
			{
				totalTaxPaid = totalTaxPaid + (topMarginalTaxRate / 100) * ((inflationAdjustedParVal * ((expectedInflationRate/12)/100)) + 
						(inflationAdjustedParVal * ((bondCoupon/12)/100)));
			}
			
			inflationAdjustedParVal = inflationAdjustedParVal + (inflationAdjustedParVal * ((expectedInflationRate/12)/100));
			totalCouponInterestEarnings = totalCouponInterestEarnings + (inflationAdjustedParVal * ((bondCoupon/12)/100));
		}
		
		totalCouponInterestEarnings = Math.round(totalCouponInterestEarnings);
		inflationAdjustedParVal = Math.round(inflationAdjustedParVal);
		inflationAdjustedPaidPremiumVal = Math.round(inflationAdjustedPaidPremiumVal);
		double bondCostCoverageDelta = 0;
		
		if(deltaBtwParAndPurchaseAmount > 0)
		{
			bondCostCoverageDelta = (totalCouponInterestEarnings + deltaBtwParAndPurchaseAmount) - (totalTaxPaid);
		}else
		{
			bondCostCoverageDelta = totalCouponInterestEarnings - (totalTaxPaid + inflationAdjustedPaidPremiumVal);
		}
		
		double yearlySimpleInterestAPR = ((((inflationAdjustedParVal - bondParVal) + (bondCostCoverageDelta)) / bondParVal) / (timeToMaturityInMonths / 12)) * 100;
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		
		System.out.println("[Coupon Interest Total Earnings] $"+totalCouponInterestEarnings);
		System.out.println("[Inflation adjusted par value] $"+inflationAdjustedParVal);
		System.out.println("[Inflation adjusted premium value] $"+inflationAdjustedPaidPremiumVal);
		System.out.println("[Total Tax on gains] $"+Math.round(totalTaxPaid));
		System.out.println("[Cost Coverage Delta] $"+Math.round(bondCostCoverageDelta));
		System.out.println("[Simple Interest Yearly Rate of Return (Post Tax)] "+numberFormat.format(yearlySimpleInterestAPR)+"%");		
	}
}