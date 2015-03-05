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

    private int scoreOf(String[] game) {
        if (game.length > 2) {
            return scoreOf(game[0]) + scoreOf(game[1]) + scoreOf(game[2]) + scoreOf(game[3]);
        }
        return scoreOf(game[0]) + scoreOf(game[1]);
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
