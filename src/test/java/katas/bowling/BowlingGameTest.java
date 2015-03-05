package katas.bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        assertThat(scoreOf(new String[]{"1", "-", "2", "/", "3", "4"}), is(21));
        assertThat(scoreOf(new String[]{"1", "-", "2", "/", "3"}), is(14));
    }

    @Test
    public void get_score_given_game_with_one_strike_frame() throws Exception {
        assertThat(scoreOf(new String[]{"X", "1", "2"}), is(13));
        assertThat(scoreOf(new String[]{"X", "2", "2"}), is(14));
        assertThat(scoreOf(new String[]{"1", "2", "X", "3", "4"}), is(20));
        assertThat(scoreOf(new String[]{"1", "2", "3", "4", "X", "-", "5"}), is(25));
    }

    @Test
    public void get_score_given_game_with_two_spare_frame() throws Exception {
        assertThat(scoreOf(new String[]{"1", "/", "2", "/", "3"}), is(25));
        assertThat(scoreOf(new String[]{"1", "/", "2", "/", "3", "1"}), is(29));
    }

    @Test
    public void get_score_given_game_with_one_spare_frame_and_one_strike_frame() throws Exception {
        assertThat(scoreOf(new String[]{"1", "/", "2", "3", "X", "1", "2"}), is(30));
    }

    @Test
    public void get_frames_given_game_with_one_frame() throws Exception {
        assertThat(getFramesFrom(new String[]{"1", "3"}).get(0), is(new String[]{"1", "3"}));
        assertThat(getFramesFrom(new String[]{"1", "2"}).get(0), is(new String[]{"1", "2"}));
    }

    @Test
    public void get_frames_given_game_with_two_frames() throws Exception {
        String[] game = {"1", "2", "2", "2"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"1", "2"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"2", "2"}));
    }

    @Test
    public void get_frames_given_game_with_three_frames() throws Exception {
        String[] game = {"1", "2", "2", "2", "3", "2"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"1", "2"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"2", "2"}));
        assertThat(getFramesFrom(game).get(2), is(new String[]{"3", "2"}));
    }

    @Test
    public void get_frames_given_game_with_one_strike() throws Exception {
        String[] game = {"X", "1", "2"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"X", "1", "2"}));
    }

    @Test
    public void get_frames_given_game_with_one_strike_and_another_two_frames() throws Exception {
        String[] game = {"X", "1", "2", "3", "4"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"X", "1", "2"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"1", "2"}));
        assertThat(getFramesFrom(game).get(2), is(new String[]{"3", "4"}));
    }

    @Test
    public void get_frames_given_game_with_two_strike() throws Exception {
        String[] game = {"X", "X", "2", "3"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"X", "X", "2"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"X", "2", "3"}));
    }

    @Test
    public void get_frames_given_game_with_two_strike_and_another_frame() throws Exception {
        String[] game = {"1", "2", "X", "X", "2", "3"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"1", "2"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"X", "X", "2"}));
        assertThat(getFramesFrom(game).get(2), is(new String[]{"X", "2", "3"}));
    }

    @Test
    public void get_frames_given_game_with_one_spare() throws Exception {
        String[] game = {"2", "/", "3"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
    }

    @Test
    public void get_frames_given_game_with_one_spare_and_another_frame() throws Exception {
        String[] game = {"2", "/", "3", "1"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"3", "1"}));
    }

    @Test
    public void get_frames_given_game_with_one_spare_and_another_two_frames() throws Exception {
        String[] game = {"2", "/", "3", "1", "4", "1"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"3", "1"}));
        assertThat(getFramesFrom(game).get(2), is(new String[]{"4", "1"}));
    }

    @Test
    public void get_frames_given_game_with_two_spares() throws Exception {
        String[] game = {"2", "/", "3", "/", "4"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"3", "/", "4"}));
    }

    @Test
    public void get_frames_given_game_with_two_spares_and_another_frame() throws Exception {
        String[] game = {"2", "/", "3", "/", "4", "1"};
        assertThat(getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
        assertThat(getFramesFrom(game).get(1), is(new String[]{"3", "/", "4"}));
        assertThat(getFramesFrom(game).get(2), is(new String[]{"4", "1"}));
    }

    private List<String[]> getFramesFrom(String[] game) {
        List<String[]> frames = new ArrayList<>();
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

    private int getNextRoll(String[] game, int rolls) {
        if (isLastFrame(game, rolls)) {
            return rolls + 3;
        }
        if (isStrike(game, rolls) || isSpare(game, rolls)) {
            return rolls + (isSpare(game, rolls) ? 2 : 1);
        }
        return 2;
    }

    private boolean isSpare(String[] game, int rolls) {
        return "/".equals(game[rolls + 1]);
    }

    private boolean isStrike(String[] game, int rolls) {
        return "X".equals(game[rolls]);
    }

    private boolean isLastFrame(String[] game, int rolls) {
        return rolls + 3 == game.length;
    }

    private String[] getFrame(String[] game, int rolls) {
        return new String[]{game[rolls], game[rolls + 1]};
    }

    private String[] getStrikeOrSpareFrame(String[] game, int rolls) {
        return new String[]{game[rolls], game[rolls + 1], game[rolls + 2]};
    }

    private int scoreOf(String[] game) {
        int score = 0;
        for (String[] frame : getFramesFrom(game)) {
            if (isStrike(frame, 0)) {
                score += 10 + scoreOf(getExtraRoll(0, frame, 0)) + scoreOf(getExtraRoll(0, frame, 1));
            } else if (isSpare(frame, 0)) {
                score += 10 + scoreOf(getExtraRoll(0, frame, 1));
            } else {
                score += frameScore(frame, 0);
            }
        }
        return score;
    }

    private String getExtraRoll(int frameNumber, String[] game, int extraRoll) {
        return game[getNumberOfFirstRollFrom(frameNumber) + 1 + extraRoll];
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
