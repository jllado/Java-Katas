package katas.bowling;

public class Roll {

    private static final String SPARE = "/";
    private static final String STRIKE = "X";
    private static final String ZERO = "-";
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


    public int score() {
        if (isZero()) {
            return 0;
        }
        if (isStrike()) {
            return 10;
        }
        return Integer.valueOf(value);
    }

    private boolean isZero() {
        return ZERO.equals(value);
    }

}
