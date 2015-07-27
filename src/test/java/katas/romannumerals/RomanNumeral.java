package katas.romannumerals;

public class RomanNumeral {
    private final int digit;

    public RomanNumeral(int digit) {
        this.digit = digit;
    }

    public String getValue() {
        String romanNumeral = "";
        int remainDigit = digit;
        while (remainDigit > 0) {
            if (remainDigit / 10 > 0) {
                romanNumeral += "X";
                remainDigit -= 10;
                continue;
            }
            if (remainDigit / 5 > 0) {
                romanNumeral += "V";
                remainDigit -= 5;
                continue;
            }
            if (remainDigit == 4) {
                romanNumeral += "IV";
                remainDigit -= 4;
                continue;
            }
            romanNumeral += "I";
            remainDigit--;
        }
        return romanNumeral.toString();
    }
}
