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

    boolean isStrike(String roll) {
        return "X".equals(roll);
    }

    boolean isSpare(String roll) {
        return "/".equals(roll);
    }

    boolean isSpare(String[] frame) {
        return isSpare(frame[1]);
    }

    boolean isStrike(String[] frame) {
        return isStrike(frame[0]);
    }

    int spareScoreOf(String[] frame) {
        return 10 + scoreOf(getExtraRoll(frame, 1));
    }

    int strikeScoreOf(String[] frame) {
        return 10 + scoreOf(getExtraRoll(frame, 0)) + scoreOf(getExtraRoll(frame, 1));
    }

    String getExtraRoll(String[] frame, int extraRoll) {
        return frame[1 + extraRoll];
    }
}
