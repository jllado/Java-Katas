package katas.bowling;

public class Frame {

    private String[] tries;

    public Frame() {
    }

    public Frame(String[] rolls) {
        this.tries = rolls;
    }

    int scoreOf(String roll) {
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

    boolean isSpare() {
        return isSpare(tries[1]);
    }

    boolean isStrike() {
        return isStrike(tries[0]);
    }

    int spareScoreOf() {
        return 10 + scoreOf(getExtraRoll(tries, 1));
    }

    int strikeScoreOf() {
        return 10 + scoreOf(getExtraRoll(tries, 0)) + scoreOf(getExtraRoll(tries, 1));
    }

    String getExtraRoll(String[] frame, int extraRoll) {
        return frame[1 + extraRoll];
    }

    public int score() {
        return scoreOf(tries[(0)]) + scoreOf(tries[1]);
    }
}
