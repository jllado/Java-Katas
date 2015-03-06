package katas.bowling;

public class Frame {

    private String[] tries;

    public Frame(String[] rolls) {
        this.tries = rolls;
    }

    private int scoreOf(String roll) {
        if ("-".equals(roll)) {
            return 0;
        }
        if ("X".equals(roll)) {
            return 10;
        }
        return Integer.valueOf(roll);
    }

    public static boolean isStrike(String roll) {
        return "X".equals(roll);
    }

    public static boolean isSpare(String roll) {
        return "/".equals(roll);
    }

    private boolean isSpare() {
        return isSpare(tries[1]);
    }

    private boolean isStrike() {
        return isStrike(tries[0]);
    }

    private int spareScoreOf() {
        return 10 + scoreOf(getExtraRoll(tries, 1));
    }

    private int strikeScoreOf() {
        return 10 + scoreOf(getExtraRoll(tries, 0)) + scoreOf(getExtraRoll(tries, 1));
    }

    private String getExtraRoll(String[] frame, int extraRoll) {
        return frame[1 + extraRoll];
    }

    public int score() {
        if (isStrike()) {
            return strikeScoreOf();
        }
        if (isSpare()) {
            return  spareScoreOf();
        }

        return scoreOf(tries[(0)]) + scoreOf(tries[1]);
    }
}
