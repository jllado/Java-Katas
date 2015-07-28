package katas.romannumerals;

import java.util.Arrays;
import java.util.List;

public class RomanNumeral {
    public enum Value {
        X(10), V(5), I(1);

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
    }
    private final int digit;

    public RomanNumeral(int digit) {
        this.digit = digit;
    }

    public String getValue() {
        String romanNumeral = "";
        int remainDigit = digit;
        for (Value value : Value.getValues()) {
            if (remainDigit != 0 && remainDigit == value.getDigit() - 1) {
                romanNumeral += "I" + value.toString();
                remainDigit -= (value.getDigit() - 1);
                continue;
            }
            while (remainDigit / value.getDigit() > 0) {
                romanNumeral += value.toString();
                remainDigit -= value.getDigit();
            }
        }
        return romanNumeral.toString();
    }
}
