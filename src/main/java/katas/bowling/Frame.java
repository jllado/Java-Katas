package katas.bowling;

public class Frame {

    private Roll[] rolls;

    public Frame(Roll[] rolls) {
        this.rolls = rolls;
    }

    private boolean isSpare() {
        return rolls[1].isSpare();
    }

    private boolean isStrike() {
        return rolls[0].isStrike();
    }

    public int score() {
        if (isStrike()) {
            return 10 + rolls[1].score() + rolls[2].score();
        }
        if (isSpare()) {
            return 10 + rolls[2].score();
        }

        return rolls[(0)].score() + rolls[1].score();
    }
}
