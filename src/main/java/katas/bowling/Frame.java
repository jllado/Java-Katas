package katas.bowling;

public class Frame {

    private Roll[] tries;

    public Frame(Roll[] rolls) {
        this.tries = rolls;
    }

    private boolean isSpare() {
        return tries[1].isSpare();
    }

    private boolean isStrike() {
        return tries[0].isStrike();
    }

    private int spareScoreOf() {
        return 10 + getExtraRoll(tries, 1).score();
    }

    private int strikeScoreOf() {
        return 10 + getExtraRoll(tries, 0).score() + getExtraRoll(tries, 1).score();
    }

    private Roll getExtraRoll(Roll[] frame, int extraRoll) {
        return frame[1 + extraRoll];
    }

    public int score() {
        if (isStrike()) {
            return strikeScoreOf();
        }
        if (isSpare()) {
            return  spareScoreOf();
        }

        return tries[(0)].score() + tries[1].score();
    }
}
