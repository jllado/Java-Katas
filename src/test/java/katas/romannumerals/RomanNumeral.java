package katas.romannumerals;

public class RomanNumeral {
    private final int digit;

    public RomanNumeral(int digit) {
        this.digit = digit;
    }

    public String getValue() {
        if (digit == 5) {
            return "V";
        }
        if (digit == 4) {
            return "IV";
        }
        StringBuilder romanNumeral = new StringBuilder();
        for (int j = 0; j < digit; j++) {
            romanNumeral.append("I");
        }
        return romanNumeral.toString();
    }
}
