package katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Roll roll = new Roll();
    private String[] rolls;

    public Game(String[] strings) {
        this.rolls = strings;
    }

    private List<Frame> frames() {
        List<Frame> frames = new ArrayList<>();
        int roll = 0;
        while (roll < rolls.length) {
            String firstRoll = rolls[roll];
            String secondRoll = rolls[roll + 1];
            if (this.roll.isStrike(firstRoll) || this.roll.isSpare(secondRoll)) {
                frames.add(strikeOrSpareFrame(roll));
                roll = getNextRoll(roll, firstRoll, secondRoll);
                continue;
            }
            frames.add(frame(roll));
            roll += getNextRoll(roll, firstRoll, secondRoll);
        }
        return frames;
    }

    private int getNextRoll(int rollNumber, String firstRoll, String secondRoll) {
        if (isLastFrame(rollNumber)) {
            return rollNumber + 3;
        }
        if (roll.isStrike(firstRoll) || roll.isSpare(secondRoll)) {
            return rollNumber + (roll.isSpare(secondRoll) ? 2 : 1);
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

    private boolean isSpare(String roll) {
        return this.roll.isSpare(roll);
    }


    private boolean isStrike(String roll) {
        return this.roll.isStrike(roll);
    }

}
