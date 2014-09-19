package katas.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    List<Rule> rules = new ArrayList<Rule>();

    public FizzBuzz() {
        rules.add(new RuleFizzBuzz());
        rules.add(new RuleFizz());
        rules.add(new RuleBuzz());
    }

    public String getWord(int i) {
        for (Rule rule : rules) {
            if (rule.check(i)) {
                return rule.action();
            }
        }
        return String.valueOf(i);
    }

}