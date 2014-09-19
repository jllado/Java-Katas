package katas.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzGame {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    public List<String> resultsPlayBy(int i) {
        List<String> results = new ArrayList<String>();
        for (int index = 1; index <= i; index++) {
            results.add(fizzBuzz.getWord(index));
        }
        return results;
    }

}