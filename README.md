# InvestmentCalculators
This is a (simple) investment 'buy'/'not buy' evaluation calculator for US TIPs (United States Treasury Inflation Protected Securities).

The tool takes in the following variables as its input:

a) Bond Coupon - The yearly interest rate payable on the bond's inflation adjusted principal amount. 

b) Time-to-Maturity (months) - Self explanatory. Time till maturity.

c) Inflation Rate - Expected (yearly) inflation rate. Since this is a forward looking projection, its should be a ballpark estimate (a best guess). 

d) Bond Purchase Amount - This is the bond price (purchase price for the security). The bond price will likely be higher than the Par Value (bond's actual value). The difference between the two is the premium you will pay to purchase the TIP security. Bond price = asking price * inflation factor. 

e) TIPs held in Tax deferred account boolean flag - Whether the TIP be held in 401k etc or non tax deferred account

f) Top Marginal Tax rate - only appicable if the TIP be held in non tax advantage account. 

The outputs are:

a) Dollar value of the amount re-couped towards the paid premium. 

b) Inflation adjusted premium value. This is the inflation adjusted dollar value (at the time of TIP maturity) of the premium paid at the time of the TIP purchase. 

c) Inflation adjusted Par Value of the TIP. This is the amount you will get from Treasury upon TIP maturity. 

d) Return on paid premium - A +/- precentage quantifying gain/loss on the premium paid. 

e) Total Tax on gains

Some notes on TIPs:

a) Bond price will usually be higher for bonds with high coupon rates. However, the outcome of whether a given price structure (Bond price, Coupon rate, Time to maturity etc) is a positive deal or not is a function of 1) premium being paid, 2) the coupon being promised and 3) inflation rate (which would be a prediction at the time of TIP purchase evaluation). 

b) TIPS never fall below their par value.

c) When TIPs mature, the investor gets a principal payment equal to the inflation-adjusted face value at that time. 

d) Taxes on TIPs returns are due each year, both on coupon payments and the increase in principal amount reflecting inflation, even though the Treasury does not pay out the increase until maturity. This is only applicable for TIPs being held in non Tax advantage (example: 401k etc) accounts.  

