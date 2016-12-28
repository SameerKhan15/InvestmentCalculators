# InvestmentCalculators
This is an investment 'buy'/'not buy' decision evaluation calculator for US TIPs (United States Treasury Inflation Protected Securities).

The tool takes in the following variables as its input:

a) Bond Coupon - The yearly interest rate payable on the bond's inflation adjusted principal amount.

b) Bond Maturity Year - Year in which the bond matures.

c) Bond Maturity Month - Month in which the bond matures.

d) Bond Maturity Day - Day on which the bond matures.

e) Inflation Rate - Expected (yearly) inflation rate. Since this is a forward looking projection, its should be a ballpark estimate.

f) Bond Purchase Amount - This is the bond price (purchase price for the security). The bond purchase amount will likely be either higher or lower than the Par Value (bond's actual value). If bond purchase amount is greater than the par value, there is a premium associated with the purchase. If the bond purchase amount is less than the par value, the bond is being offered at a discount. 

g) Bond Par Value - The actual dollar value associated with the bond.

h) TIPs held in Tax deferred account boolean flag - Whether the TIP be held in 401k etc or a non-tax deferred/advantage account

i) Top Marginal Tax rate - only appicable if the TIP be held in non tax advantage account.

The outputs are:

a) Coupon Interest Total Earnings - Total dollar value of the interest earnings (determined by the coupon rate) over the life time of the bond.

b) Inflation adjusted Par Value - This is the amount you will get from Treasury upon TIP maturity.

c) Inflation adjusted Premium Value - This is the inflation adjusted dollar value (at the time of TIP maturity) of the premium paid at the time of the TIP purchase. Note that this amount would be 0 for cases where the bond was purchased at a discount.

d) Total Tax on gains - Total tax due/paid, over the life time of the bond

e) Cost Coverage Delta - Difference between ('Coupon Interest Total Earnings' Plus 'Any discount availed on bond purchase') AND 'Total Tax Paid' Plus 'Inflation adjusted premium paid (if any) upon the bond purchase' 

f) Simple Interest Yearly Rate of Return (after factoring in the 'Cost Coverage Delta') - This is the yearly net return achieved on the investment, after accounting for all the "cost" associated with the investment. 

Some notes on TIPs:

a) Bond price will usually be higher for bonds with high coupon rates. However, the outcome of whether a given price structure (Bond price, Coupon rate, Time to maturity etc) is a positive deal or not is a function of 1) premium being paid, 2) the coupon being promised and 3) inflation rate (which would be a prediction at the time of TIP purchase evaluation).

b) TIPS never fall below their par value.

c) When TIPs mature, the investor gets a principal payment equal to the inflation-adjusted face value at that time.

d) Taxes on TIPs returns are due each year, both on coupon payments and the increase in principal amount reflecting inflation, even though the Treasury does not pay out the increase until maturity. This is only applicable for TIPs being held in non Tax advantage (example: 401k etc) accounts.

