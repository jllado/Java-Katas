package katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public Game() {
    }

    List<String[]> getFramesFrom(String[] game) {
        List<String[]> frames = new ArrayList<String[]>();
        int roll = 0;
        while (roll < game.length) {
            if (isStrike(game, roll) || isSpare(game, roll)) {
                frames.add(getStrikeOrSpareFrame(game, roll));
                roll = getNextRoll(game, roll);
                continue;
            }
            frames.add(getFrame(game, roll));
            roll += getNextRoll(game, roll);
        }
        return frames;
    }

    int getNextRoll(String[] game, int rolls) {
        if (isLastFrame(game, rolls)) {
            return rolls + 3;
        }
        if (isStrike(game, rolls) || isSpare(game, rolls)) {
            return rolls + (isSpare(game, rolls) ? 2 : 1);
        }
        return 2;
    }

    boolean isSpare(String[] game, int rolls) {
        return "/".equals(game[rolls + 1]);
    }

    boolean isStrike(String[] game, int rolls) {
        return "X".equals(game[rolls]);
    }

    boolean isLastFrame(String[] game, int rolls) {
        return rolls + 3 == game.length;
    }

    String[] getFrame(String[] game, int rolls) {
        return new String[]{game[rolls], game[rolls + 1]};
    }

    String[] getStrikeOrSpareFrame(String[] game, int rolls) {
        return new String[]{game[rolls], game[rolls + 1], game[rolls + 2]};
    }

    int scoreOf(String[] game) {
        int score = 0;
        for (String[] frame : getFramesFrom(game)) {
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

    boolean isSpare(String[] frame) {
        return isSpare(frame, 0);
    }

    boolean isStrike(String[] frame) {
        return isStrike(frame, 0);
    }

    String getExtraRoll(String[] game, int extraRoll) {
        return game[1 + extraRoll];
    }

    int scoreOf(String roll) {
        if ("-".equals(roll)) {
            return 0;
        }
        if ("X".equals(roll)) {
            return 10;
        }
        return Integer.valueOf(roll);
    }
}
