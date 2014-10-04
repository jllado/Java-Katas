package katas.codebreaker;


public class ColorCodeValidator {

    private String colorsCode = "";

    private static final String RESULT_MATCH_COLOR_AND_POSITION = "X";
    private static final String RESULT_MATCH_COLOR = "*";

    public ColorCodeValidator(String colorsCode) {
        this.colorsCode = colorsCode;
    }

    public String getMatches(String colorsCodeToCheck) {
        MatcherResult colorsAndPositionMatches = getColorsAndPositionMatches(colorsCodeToCheck);
        MatcherResult colorsMatches = getColorMatches(
                colorsAndPositionMatches.getMismatchedColorsCode(),
                colorsAndPositionMatches.getColorsCodeToCheckThatMismatched());

        return colorsAndPositionMatches.getResult() + colorsMatches.getResult();
    }

    public Boolean isValid(String colorsCodeToCheck) {
        return matchAllTheColorsAndPosition(colorsCodeToCheck);
    }

    private MatcherResult getColorsAndPositionMatches(String colorsCodeToCheck) {
        StringBuilder result = new StringBuilder();
        StringBuilder mismatchedColorsCode = new StringBuilder();
        StringBuilder colorsCodeToCheckThatMismatched = new StringBuilder();
        for (int position = 0; position < colorsCodeToCheck.length(); position++) {
            if (matchesTheColorAndPosition(colorsCodeToCheck, position)) {
                result.append(RESULT_MATCH_COLOR_AND_POSITION);
            } else {
                mismatchedColorsCode.append(this.colorsCode.charAt(position));
                colorsCodeToCheckThatMismatched.append(colorsCodeToCheck.charAt(position));
            }
        }
        return new MatcherResult(result.toString(), mismatchedColorsCode.toString(), colorsCodeToCheckThatMismatched.toString());
    }

    private boolean matchesTheColorAndPosition(String code, int i) {
        return this.colorsCode.charAt(i) == code.charAt(i);
    }

    private MatcherResult getColorMatches(String colorsCode, String colorsCodeToCheck) {
        StringBuilder result = new StringBuilder();
        String mismatchedColorsCode = colorsCode;
        for (char color : colorsCodeToCheck.toCharArray()) {
            if (containsColor(color, mismatchedColorsCode)) {
                result.append(RESULT_MATCH_COLOR);
                mismatchedColorsCode = removeColor(mismatchedColorsCode, color);
            }
        }
        return new MatcherResult(result.toString(), mismatchedColorsCode);
    }

    private boolean containsColor(char color, String colorsCode) {
        return colorsCode.contains(String.valueOf(color));
    }

    private String removeColor(String colorsCode, char color) {
        int firstColorPosition = colorsCode.indexOf(String.valueOf(color));
        return new StringBuilder(colorsCode).deleteCharAt(firstColorPosition).toString();
    }

    private Boolean matchAllTheColorsAndPosition(String colorsCodeToCheck) {
        return validResult().equals(getMatches(colorsCodeToCheck));
    }

    private String validResult() {
        StringBuilder validMatchers = new StringBuilder();
        for (int i = 0; i < this.colorsCode.length(); i++) {
            validMatchers.append("X");
        }
        return validMatchers.toString();
    }

}