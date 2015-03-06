package katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
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
        if (isStrike(rolls, roll) || isSpare(rolls, roll)) {
            return roll + (isSpare(rolls, roll) ? 2 : 1);
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
            if (isStrike(frame)) {
                score += 10 + scoreOf(getExtraRoll(frame, 0)) + scoreOf(getExtraRoll(frame, 1));
                continue;
            }
            if (isSpare(frame)) {
                score += 10 + scoreOf(getExtraRoll(frame, 1));
                continue;
            }
            score += scoreOf(frame[(0)]) + scoreOf(frame[1]);

        }
        return score;
    }

    private boolean isSpare(String[] frame) {
        return isSpare(frame, 0);
    }

    private boolean isStrike(String[] frame) {
        return isStrike(frame, 0);
    }

    private String getExtraRoll(String[] frame, int extraRoll) {
        return frame[1 + extraRoll];
    }

    private int scoreOf(String roll) {
        if ("-".equals(roll)) {
            return 0;
        }
        if ("X".equals(roll)) {
            return 10;
        }
        return Integer.valueOf(roll);
    }

    private boolean isSpare(String[] game, int rolls) {
        return "/".equals(game[rolls + 1]);
    }
    private boolean isSpare(int roll) {
        return isSpare(rolls, roll);
    }

    private boolean isStrike(String[] game, int rolls) {
        return "X".equals(game[rolls]);
    }

    private boolean isStrike(int roll) {
        return "X".equals(rolls[roll]);
    }
}
