package katas.fizzbuzz;

public class Number {

    private int number;

    public Number(int number) {
        this.number = number;

    }

    public boolean isDivisibleBy(int i) {
        return this.number % i == 0;
    }

}