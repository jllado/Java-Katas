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

        public Symbol getPreviousSymbol() {
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


        private int getPreviousDigit() {
            return this.getDigit() - this.getPreviousSymbol().getDigit();
        }

        public boolean isPreviousDivisibleBy(int remainDigit) {
            return areDivisible(remainDigit, this.getPreviousDigit());
        }


        public boolean isDivisibleBy(int remainDigit) {
            return areDivisible(remainDigit, this.getDigit());
        }

        private boolean areDivisible(int firstDigit, int secondDigit) {
            return firstDigit / secondDigit > 0;
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
            while (symbol.isDivisibleBy(remainDigit)) {
                romanNumeral += symbol;
                remainDigit -= symbol.getDigit();
            }
            if (remainDigit > 0 && symbol.isPreviousDivisibleBy(remainDigit)) {
                romanNumeral += symbol.getPreviousSymbol() + symbol.toString();
                remainDigit -= symbol.getPreviousDigit();
            }
        }
        return romanNumeral.toString();
    }

}
