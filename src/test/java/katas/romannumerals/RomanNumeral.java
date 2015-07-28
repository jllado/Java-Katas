package katas.romannumerals;

import java.util.Arrays;
import java.util.List;

public class RomanNumeral {
    public enum Symbol {
        M(1000), C(100), X(10), V(5), I(1);

        private final int digit;

        Symbol(int digit) {
            this.digit = digit;
        }

        public static List<Symbol> getSymbols() {
            return Arrays.asList(values());
        }

        public int getDigit() {
            return digit;
        }

        public Symbol getPreviousValue() {
            for (Symbol symbol : Symbol.getSymbols()) {
                if (symbol.getDigit() < this.getDigit() && symbol.hasNotFive()) {
                    return symbol;
                }
            }
            return Symbol.I;
        }

        private boolean hasNotFive() {
            return !String.valueOf(this.getDigit()).contains("5");
        }


        public int getPreviousDigit() {
            return this.getDigit() - this.getPreviousValue().getDigit();
        }


    }
    private final int digit;

    public RomanNumeral(int digit) {
        this.digit = digit;
    }

    public String getValue() {
        String romanNumeral = "";
        int remainDigit = digit;
        for (Symbol symbol : Symbol.getSymbols()) {
            while (remainDigit / symbol.getDigit() > 0) {
                romanNumeral += symbol;
                remainDigit -= symbol.getDigit();
            }
            if (remainDigit > 0 && remainDigit / (symbol.getPreviousDigit()) > 0) {
                romanNumeral += symbol.getPreviousValue() + symbol.toString();
                remainDigit -= symbol.getPreviousDigit();
            }
        }
        return romanNumeral.toString();
    }

}
