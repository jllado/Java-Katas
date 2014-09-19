package katas.fizzbuzz;

public class RuleFizzBuzz implements Rule {

    @Override
    public boolean check(int number) {
        Number ruleNumber = new Number(number);
        return ruleNumber.isDivisibleBy(3) && ruleNumber.isDivisibleBy(5);
    }

    @Override
    public String action() {
        return "FizzBuzz";
    }

}
