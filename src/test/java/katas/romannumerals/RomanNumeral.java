package katas.romannumerals;

public class RomanNumeral {
    private final int digit;

    public RomanNumeral(int digit) {
        this.digit = digit;
    }

    public String getValue() {
        String romanNumeral = "";
        int remainDigit = digit;
        if (remainDigit == 4) {
            return "IV";
        }
        if (remainDigit == 10) {
            return "X";
        }
        while (remainDigit > 0) {
            if (remainDigit == 5) {
                romanNumeral = "V" + romanNumeral;
                remainDigit -= 5;
                continue;
            }
            romanNumeral += "I";
            remainDigit--;
        }
        return romanNumeral.toString();
    }
}
