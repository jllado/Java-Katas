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
            frames.add(frame(roll));
            roll = getNextRoll(roll);
        }
        return frames;
    }

    private int getNextRoll(int roll) {
        Roll firstRoll = new Roll(rolls[roll]);
        Roll secondRoll = new Roll(rolls[roll + 1]);
        if (isLastFrame(roll)) {
            return roll + 3;
        }
        if (firstRoll.isStrike() || secondRoll.isSpare()) {
            return roll + (secondRoll.isSpare() ? 2 : 1);
        }
        return roll + 2;
    }

    private boolean isLastFrame(int roll) {
        return roll + 3 == rolls.length;
    }

    private Frame frame(int roll) {
        Roll firstRoll = new Roll(rolls[roll]);
        Roll secondRoll = new Roll(rolls[roll + 1]);
        if (firstRoll.isStrike() || secondRoll.isSpare()) {
            return new Frame(new Roll[]{firstRoll, secondRoll, new Roll(rolls[roll + 2])});
        }
        return new Frame(new Roll[]{firstRoll, secondRoll});
    }

    public int score() {
        int score = 0;
        for (Frame frame : frames()) {
            score += frame.score();
        }
        return score;
    }

}
