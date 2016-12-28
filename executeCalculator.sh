#!/bin/bash
echo "$*"
export InvestmentCalculators_HOME=/Users/sameer.khan/Documents/workspace/InvestmentCalculators
echo $InvestmentCalculators_HOME
java -Xmx1024m -cp $InvestmentCalculators_HOME/lib/calculator.jar -Duser.dir=$InvestmentCalculators_HOME com.calculators.USTIPS
