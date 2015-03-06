package katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String[] rolls;

    public Game(String[] strings) {
        this.rolls = strings;
    }

    private List<Frame> frames() {
        List<Frame> frames = new ArrayList<>();
        int roll = 0;
        while (roll < rolls.length) {
            if (isStrike(rolls[roll]) || isSpare(roll)) {
                frames.add(strikeOrSpareFrame(roll));
                roll = getNextRoll(roll, rolls[roll]);
                continue;
            }
            frames.add(frame(roll));
            roll += getNextRoll(roll, rolls[roll]);
        }
        return frames;
    }

    private int getNextRoll(int rollNumber, String roll) {
        if (isLastFrame(rollNumber)) {
            return rollNumber + 3;
        }
        if (isStrike(roll) || isSpare(rollNumber)) {
            return rollNumber + (isSpare(rollNumber) ? 2 : 1);
        }
        return 2;
    }

    private boolean isLastFrame(int roll) {
        return roll + 3 == rolls.length;
    }

    private Frame frame(int roll) {
        return new Frame(new String[]{rolls[roll], rolls[roll + 1]});
    }

    private Frame strikeOrSpareFrame(int roll) {
        return new Frame(new String[]{rolls[roll], rolls[roll + 1], rolls[roll + 2]});
    }

    public int score() {
        int score = 0;
        for (Frame frame : frames()) {
            score += frame.score();
        }
        return score;
    }

    private boolean isSpare(int roll) {
        return Frame.isSpare(rolls[roll + 1]);
    }


    private boolean isStrike(String roll) {
        return Frame.isStrike(roll);
    }

}
