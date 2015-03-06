package katas.bowling;

public class Roll {

    private static final String SPARE = "/";
    private static final String STRIKE = "X";
    private String value;

    public Roll(String value) {
        this.value = value;
    }

    public boolean isSpare() {
        return SPARE.equals(value);
    }

    public boolean isStrike() {
        return STRIKE.equals(value);
    }

}
