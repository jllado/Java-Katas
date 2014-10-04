package kata.codebreaker;

public class MatcherResult {

    private String result;
    private String mismatchedColorsCode;
    private String colorsCodeToCheckThatMismatched;

    public MatcherResult(
            String result,
            String mismatchedColorsCode,
            String colorsCodeToCheckThatMismatched) {
        this(result, colorsCodeToCheckThatMismatched);
        this.mismatchedColorsCode = mismatchedColorsCode;
    }

    public MatcherResult(String result, String colorsCodeToCheckThatMismatched) {
        this.result = result;
        this.colorsCodeToCheckThatMismatched = colorsCodeToCheckThatMismatched;
    }

    public String getResult() {
        return result;
    }

    public String getMismatchedColorsCode() {
        return mismatchedColorsCode;
    }

    public String getColorsCodeToCheckThatMismatched() {
        return colorsCodeToCheckThatMismatched;
    }

}
