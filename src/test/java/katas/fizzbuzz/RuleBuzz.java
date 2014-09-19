package katas.fizzbuzz;

public class RuleBuzz implements Rule {

    @Override
    public boolean check(int number) {
        return new Number(number).isDivisibleBy(5);
    }

    @Override
    public String action() {
        return "Buzz";
    }

}
