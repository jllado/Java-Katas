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
            Roll firstRoll = new Roll(rolls[roll]);
            Roll secondRoll = new Roll(rolls[roll + 1]);
            if (firstRoll.isStrike() || secondRoll.isSpare()) {
                frames.add(strikeOrSpareFrame(roll));
                roll = getNextRoll(roll, firstRoll, secondRoll);
                continue;
            }
            frames.add(frame(roll));
            roll += getNextRoll(roll, firstRoll, secondRoll);
        }
        return frames;
    }

    private int getNextRoll(int rollNumber, Roll firstRoll, Roll secondRoll) {
        if (isLastFrame(rollNumber)) {
            return rollNumber + 3;
        }
        if (firstRoll.isStrike() || secondRoll.isSpare()) {
            return rollNumber + (secondRoll.isSpare() ? 2 : 1);
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

}
