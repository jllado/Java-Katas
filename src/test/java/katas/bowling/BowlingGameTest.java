package katas.bowling;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by jllado on 16/02/15.
 */
public class BowlingGameTest {

    @Test
    public void get_score_given_one_roll() throws Exception {
        assertThat(new Game().scoreOf("1"), is(1));
        assertThat(new Game().scoreOf("2"), is(2));
        assertThat(new Game().scoreOf("-"), is(0));
        assertThat(new Game().scoreOf("X"), is(10));
    }

    @Test
    public void get_score_given_game_with_one_frame() throws Exception {
        assertThat(new Game(new String[]{"1", "-"}).scoreOf(new String[]{"1", "-"}), is(1));
    }

    @Test
    public void get_score_given_game_with_two_frames() throws Exception {
        assertThat(new Game(new String[]{"1", "-", "2", "3"}).scoreOf(new String[]{"1", "-", "2", "3"}), is(6));
    }

    @Test
    public void get_score_given_game_with_three_frames() throws Exception {
        assertThat(new Game(new String[]{"1", "-", "2", "3", "1", "1"}).scoreOf(new String[]{"1", "-", "2", "3", "1", "1"}), is(8));
    }

    @Test
    public void get_score_given_game_with_one_spare_frame() throws Exception {
        assertThat(new Game(new String[]{"1", "/", "2"}).scoreOf(new String[]{"1", "/", "2"}), is(12));
        assertThat(new Game(new String[]{"1", "/", "2", "1"}).scoreOf(new String[]{"1", "/", "2", "1"}), is(15));
        assertThat(new Game(new String[]{"1", "2", "2", "/", "3"}).scoreOf(new String[]{"1", "2", "2", "/", "3"}), is(16));
        assertThat(new Game(new String[]{"1", "/", "2", "1", "3", "4"}).scoreOf(new String[]{"1", "/", "2", "1", "3", "4"}), is(22));
        assertThat(new Game(new String[]{"1", "-", "2", "/", "3", "4"}).scoreOf(new String[]{"1", "-", "2", "/", "3", "4"}), is(21));
        assertThat(new Game(new String[]{"1", "-", "2", "/", "3"}).scoreOf(new String[]{"1", "-", "2", "/", "3"}), is(14));
    }

    @Test
    public void get_score_given_game_with_one_strike_frame() throws Exception {
        assertThat(new Game(new String[]{"X", "1", "2"}).scoreOf(new String[]{"X", "1", "2"}), is(13));
        assertThat(new Game(new String[]{"X", "2", "2"}).scoreOf(new String[]{"X", "2", "2"}), is(14));
        assertThat(new Game(new String[]{"1", "2", "X", "3", "4"}).scoreOf(new String[]{"1", "2", "X", "3", "4"}), is(20));
        assertThat(new Game(new String[]{"1", "2", "3", "4", "X", "-", "5"}).scoreOf(new String[]{"1", "2", "3", "4", "X", "-", "5"}), is(25));
    }

    @Test
    public void get_score_given_game_with_two_spare_frame() throws Exception {
        assertThat(new Game(new String[]{"1", "/", "2", "/", "3"}).scoreOf(new String[]{"1", "/", "2", "/", "3"}), is(25));
        assertThat(new Game(new String[]{"1", "/", "2", "/", "3", "1"}).scoreOf(new String[]{"1", "/", "2", "/", "3", "1"}), is(29));
        assertThat(new Game(new String[]{"1", "/", "2", "/", "3", "1", "4", "1"}).scoreOf(new String[]{"1", "/", "2", "/", "3", "1", "4", "1"}), is(34));
    }

    @Test
    public void get_score_given_game_with_one_spare_frame_and_one_strike_frame() throws Exception {
        assertThat(new Game(new String[]{"1", "/", "2", "3", "X", "1", "2"}).scoreOf(new String[]{"1", "/", "2", "3", "X", "1", "2"}), is(30));
        assertThat(new Game(new String[]{"1", "/", "2", "3", "X", "1", "2", "3", "1"}).scoreOf(new String[]{"1", "/", "2", "3", "X", "1", "2", "3", "1"}), is(37));
    }

    @Test
    public void get_score_given_ten_strikes() throws Exception {
        assertThat(new Game(new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}).scoreOf(new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}), is(300));
    }

    @Test
    public void get_score_given_twenty_rolls() throws Exception {
        String game = "9-9-9-9-9-9-9-9-9-9-";
        assertThat(new Game(toArray(game)).scoreOf(toArray(game)), is(90));
    }

    @Test
    public void get_score_given_twenty_one_rolls() throws Exception {
        String game = "5/5/5/5/5/5/5/5/5/5/5";
        assertThat(new Game(toArray(game)).scoreOf(toArray(game)), is(150));
    }

    private String[] toArray(String game) {
        String[] array = new String[game.length()];
        for (int i = 0; i < game.toCharArray().length; i++) {
            array[i] = String.valueOf(game.charAt(i));
        }
        return array;
    }
}
