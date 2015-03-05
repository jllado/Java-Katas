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
    }

    @Test
    public void get_score_given_game_with_one_spare_frame_and_another_frame() throws Exception {
        assertThat(scoreOf(new String[]{"1", "/", "2", "1"}), is(15));
        assertThat(scoreOf(new String[]{"1", "2", "2", "/", "3"}), is(16));
    }

    private int scoreOf(String[] game) {
        int score = 0;
        for (int i = 0; i < game.length / 2; i++) {
            if ("/".equals(game[i + 1])) {
                score += 10 + scoreOf(game[2]);
            } else {
                score += frameScore(game, i * 2);
            }
        }
        return score;
    }

    private int frameScore(String[] game, int i) {
        return scoreOf(game[i]) + scoreOf(game[i + 1]);
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
