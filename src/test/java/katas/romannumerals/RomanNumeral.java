package katas.romannumerals;

import java.util.Arrays;
import java.util.List;

public class RomanNumeral {
    public enum Value {
        M(1000), C(100), X(10), V(5), I(1);

        private final int digit;

        Value(int i) {
            this.digit = i;
        }

        public static List<Value> getValues() {
            return Arrays.asList(values());
        }

        public int getDigit() {
            return digit;
        }

        public Value getPreviousValue() {
            for (Value previousValue : Value.getValues()) {
                if (previousValue.getDigit() < this.getDigit() && !String.valueOf(previousValue.getDigit()).contains("5")) {
                    return previousValue;
                }
            }
            return Value.I;
        }

    }
    private final int digit;

    public RomanNumeral(int digit) {
        this.digit = digit;
    }

    public String getValue() {
        String romanNumeral = "";
        int remainDigit = digit;
        for (Value value : Value.getValues()) {
            while (remainDigit / value.getDigit() > 0) {
                romanNumeral += value.toString();
                remainDigit -= value.getDigit();
            }
            if (remainDigit > 0 && remainDigit / (value.getDigit() - value.getPreviousValue().getDigit()) > 0) {
                romanNumeral += value.getPreviousValue() + value.toString();
                remainDigit -= (value.getDigit() - value.getPreviousValue().getDigit());
            }
        }
        return romanNumeral.toString();
    }

}
