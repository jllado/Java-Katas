package katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Frame frame = new Frame();
    private String[] rolls;

    public Game(String[] strings) {
        this.rolls = strings;
    }

    private List<String[]> getFrames() {
        List<String[]> frames = new ArrayList<>();
        int roll = 0;
        while (roll < rolls.length) {
            if (isStrike(roll) || isSpare(roll)) {
                frames.add(getStrikeOrSpareFrame(roll));
                roll = getNextRoll(roll);
                continue;
            }
            frames.add(getFrame(roll));
            roll += getNextRoll(roll);
        }
        return frames;
    }

    private int getNextRoll(int roll) {
        if (isLastFrame(roll)) {
            return roll + 3;
        }
        if (isStrike(roll) || isSpare(roll)) {
            return roll + (isSpare(roll) ? 2 : 1);
        }
        return 2;
    }

    private boolean isLastFrame(int roll) {
        return roll + 3 == rolls.length;
    }

    private String[] getFrame(int roll) {
        return new String[]{rolls[roll], rolls[roll + 1]};
    }

    private String[] getStrikeOrSpareFrame(int roll) {
        return new String[]{rolls[roll], rolls[roll + 1], rolls[roll + 2]};
    }

    public int score() {
        int score = 0;
        for (String[] frame : getFrames()) {
            if (this.frame.isStrike(frame)) {
                score += this.frame.strikeScoreOf(frame);
                continue;
            }
            if (this.frame.isSpare(frame)) {
                score += this.frame.spareScoreOf(frame);
                continue;
            }
            score += this.frame.scoreOf(frame[(0)]) + this.frame.scoreOf(frame[1]);

        }
        return score;
    }

    private boolean isSpare(int roll) {
        return this.frame.isSpare(rolls[roll + 1]);
    }


    private boolean isStrike(int roll) {
        return this.frame.isStrike(rolls[roll]);
    }

}
