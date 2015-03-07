package katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int FRAME_LENGHT = 2;
    private static final int LAST_FRAME_MAX_LENGHT = 3;
    private static final int STRIKE_FRAME_LENGHT = 1;
    private String[] rolls;

    public Game(String[] strings) {
        this.rolls = strings;
    }

    private List<Frame> frames() {
        List<Frame> frames = new ArrayList<>();
        int roll = 0;
        while (roll < rolls.length) {
            frames.add(frame(roll));
            roll = nextRoll(roll);
        }
        return frames;
    }

    private int nextRoll(int roll) {
        Roll firstRoll = new Roll(rolls[roll]);
        Roll secondRoll = new Roll(rolls[roll + 1]);
        if (isLastFrame(roll)) {
            return roll + LAST_FRAME_MAX_LENGHT;
        }
        if (firstRoll.isStrike() || secondRoll.isSpare()) {
            return roll + (secondRoll.isSpare() ? FRAME_LENGHT : STRIKE_FRAME_LENGHT);
        }
        return roll + FRAME_LENGHT;
    }

    private boolean isLastFrame(int roll) {
        return roll + 3 == rolls.length;
    }

    private Frame frame(int roll) {
        Roll firstRoll = new Roll(rolls[roll]);
        Roll secondRoll = new Roll(rolls[roll + 1]);
        if (firstRoll.isStrike()) {
            Roll thirdRoll = new Roll(rolls[roll + 2]);
            return new StrikeFrame(new Roll[]{firstRoll, secondRoll, thirdRoll});
        }
        if (secondRoll.isSpare()) {
            Roll thirdRoll = new Roll(rolls[roll + 2]);
            return new SpareFrame(new Roll[]{firstRoll, secondRoll, thirdRoll});
        }
        return new DefaultFrame(new Roll[]{firstRoll, secondRoll});
    }

    public int score() {
        int score = 0;
        for (Frame frame : frames()) {
            score += frame.score();
        }
        return score;
    }

}
