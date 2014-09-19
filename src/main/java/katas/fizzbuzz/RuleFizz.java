package katas.fizzbuzz;

public class RuleFizz implements Rule {

    @Override
    public boolean check(int number) {
        return new Number(number).isDivisibleBy(3);
    }

    @Override
    public String action() {
        return "Fizz";
    }

}
