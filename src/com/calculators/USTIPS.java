package com.calculators;

public class USTIPS 
{
	private class I
	{
		
	}
	public static void main(String args[])
	{
		//Inputs: 1) bond coupon, 2) bond time to maturity (in months)
			//	  3) expected yearly inflation rate, 4) total amount paid for the purchase
		    //    5) bond(s) amount
		//Outputs: 1) Return on premium (Input# 4 - Input# 5) as percentage, 2) Actual $$ value of the premium investment
		    //     3) Inflation adjusted value of the premium investment, given Input# 3 
		
		//Configure Inputs
		double bondCoupon = 1.18737;
		int timeToMaturityInMonths = 126;
		double inflationRate = 1;
		double bondPurchaseAmount = 29864;
		double bondParVal = 20000;
		boolean tipsInTaxDeferredAccount = false;
		double topMarginalTaxRate = 35; //In Percentage
		
		double totalTaxDue = 0;
		double couponInterestEarning = 0;
		double inflationAdjustedParVal = bondParVal;
		double paidPremiumAmount = bondPurchaseAmount - bondParVal;
		double inflationAdjustedPaidPremiumVal = paidPremiumAmount;
		
		for(int a = 0 ; a < timeToMaturityInMonths ; a++)
		{
			inflationAdjustedPaidPremiumVal = inflationAdjustedPaidPremiumVal + (inflationAdjustedPaidPremiumVal * ((inflationRate/12)/100));
			
			if(!tipsInTaxDeferredAccount)
			{
				totalTaxDue = totalTaxDue + (topMarginalTaxRate / 100) * ((inflationAdjustedParVal * ((inflationRate/12)/100)) + 
						(inflationAdjustedParVal * ((bondCoupon/12)/100)));
			}
			
			inflationAdjustedParVal = inflationAdjustedParVal + (inflationAdjustedParVal * ((inflationRate/12)/100));
			couponInterestEarning = couponInterestEarning + (inflationAdjustedParVal * ((bondCoupon/12)/100));
		}
		
		couponInterestEarning = Math.round(couponInterestEarning);
		inflationAdjustedParVal = Math.round(inflationAdjustedParVal);
		inflationAdjustedPaidPremiumVal = Math.round(inflationAdjustedPaidPremiumVal);
		double returnOnPremiumPaid = Math.round(((couponInterestEarning - inflationAdjustedPaidPremiumVal) / inflationAdjustedPaidPremiumVal)*100);
		
		System.out.println("[Actual $$ val of the amount recouped towards premium] "+couponInterestEarning);
		System.out.println("[Inflation adjusted par value] "+inflationAdjustedParVal);
		System.out.println("[Inflation adjusted premium value] "+inflationAdjustedPaidPremiumVal);
		System.out.println("[Return on paid premium] "+returnOnPremiumPaid);
		System.out.print("[Total Tax on gains] "+Math.round(totalTaxDue));
	}
}