package katas.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by jllado on 16/02/15.
 */
public class BowlingGameTest {
    @Test
    public void get_score_given_one_roll() throws Exception {
        assertThat(scoreOf("1"), is(1));
        assertThat(scoreOf("2"), is(2));
        assertThat(scoreOf("-"), is(0));
        assertThat(scoreOf("X"), is(10));
    }

    @Test
    public void get_score_given_game_with_one_frame() throws Exception {
        assertThat(scoreOf(new String[]{"1", "-"}), is(1));
    }

    @Test
    public void get_score_given_game_with_two_frames() throws Exception {
        assertThat(scoreOf(new String[]{"1", "-", "2", "3"}), is(6));
    }

    @Test
    public void get_score_given_game_with_three_frames() throws Exception {
        assertThat(scoreOf(new String[]{"1", "-", "2", "3", "1", "1"}), is(8));
    }

    @Test
    public void get_score_given_game_with_one_spare_frame() throws Exception {
        assertThat(scoreOf(new String[]{"1", "/", "2"}), is(12));
        assertThat(scoreOf(new String[]{"1", "/", "2", "1"}), is(15));
        assertThat(scoreOf(new String[]{"1", "2", "2", "/", "3"}), is(16));
        assertThat(scoreOf(new String[]{"1", "/", "2", "1", "3", "4"}), is(22));
    }

    @Test
    public void get_score_given_game_with_one_strike_frame() throws Exception {
        assertThat(scoreOf(new String[]{"X", "1", "2"}), is(13));
        assertThat(scoreOf(new String[]{"X", "2", "2"}), is(14));
        assertThat(scoreOf(new String[]{"1", "2", "X", "3", "4"}), is(20));
        assertThat(scoreOf(new String[]{"1", "2", "3", "4", "X", "-", "5"}), is(25));
    }

    private int scoreOf(String[] game) {
        int score = 0;
        for (int frameNumber = 0; frameNumber < game.length / 2; frameNumber++) {
            if (isStrike(frameNumber, game)) {
                score += 10 + scoreOf(getExtraSpareRoll(frameNumber, game, 0)) + scoreOf(getExtraSpareRoll(frameNumber, game, 1));
            } else if (isSpare(frameNumber, game)) {
                score += 10 + scoreOf(getExtraSpareRoll(frameNumber, game, 1));
            } else {
                score += frameScore(game, frameNumber);
            }
        }
        return score;
    }

    private boolean isStrike(int frameNumber, String[] game) {
        return "X".equals(game[getNumberOfFirstRollFrom(frameNumber)]);
    }

    private String getExtraSpareRoll(int frameNumber, String[] game, int extraRoll) {
        return game[getNumberOfFirstRollFrom(frameNumber) + 1 + extraRoll];
    }

    private boolean isSpare(int frameNumber, String[] game) {
        return "/".equals(game[getNumberOfFirstRollFrom(frameNumber) + 1]);
    }

    private int getNumberOfFirstRollFrom(int frameNumber) {
        return frameNumber * 2;
    }

    private int frameScore(String[] game, int frameNumber) {
        int numberOfFirstRoll = getNumberOfFirstRollFrom(frameNumber);
        return scoreOf(game[numberOfFirstRoll]) + scoreOf(game[numberOfFirstRoll + 1]);
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
}
