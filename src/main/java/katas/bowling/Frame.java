package katas.bowling;

public class Frame {

    private Roll[] rolls;

    public Frame(Roll[] rolls) {
        this.rolls = rolls;
    }

    private boolean isSpare() {
        return rolls[1].isSpare();
    }

    public int score() {
        if (isSpare()) {
            return 10 + rolls[2].score();
        }
        return totalScore();
    }

    private int totalScore() {
        int score = 0;
        for (Roll roll : rolls) {
            score += roll.score();
        }
        return score;
    }
}
