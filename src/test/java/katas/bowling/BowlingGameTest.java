package katas.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by jllado on 16/02/15.
 */
public class BowlingGameTest {

    @Test
    public void get_score_given_game_with_one_frame() throws Exception {
        assertThat(scoreOf("1-"), is(1));
    }

    @Test
    public void get_score_given_game_with_two_frames() throws Exception {
        assertThat(scoreOf("1-23"), is(6));
    }

    @Test
    public void get_score_given_game_with_three_frames() throws Exception {
        assertThat(scoreOf("1-2311"), is(8));
    }

    @Test
    public void get_score_given_game_with_one_spare_frame() throws Exception {
        assertThat(scoreOf("1/2"), is(12));
        assertThat(scoreOf("1/21"), is(15));
        assertThat(scoreOf("122/3"), is(16));
        assertThat(scoreOf("1/2134"), is(22));
        assertThat(scoreOf("1-2/34"), is(21));
        assertThat(scoreOf("1-2/3"), is(14));
    }

    @Test
    public void get_score_given_game_with_one_strike_frame() throws Exception {
        assertThat(scoreOf("X12"), is(13));
        assertThat(scoreOf("X22"), is(14));
        assertThat(scoreOf("12X34"), is(20));
        assertThat(scoreOf("1234X-5"), is(25));
    }

    @Test
    public void get_score_given_game_with_two_spare_frame() throws Exception {
        assertThat(scoreOf("1/2/3"), is(25));
        assertThat(scoreOf("1/2/31"), is(29));
        assertThat(scoreOf("1/2/3141"), is(34));
    }

    @Test
    public void get_score_given_game_with_one_spare_frame_and_one_strike_frame() throws Exception {
        assertThat(scoreOf("1/23X12"), is(30));
        assertThat(scoreOf("1/23X1231"), is(37));
    }

    @Test
    public void get_score_given_ten_strikes() throws Exception {
        assertThat(scoreOf("XXXXXXXXXXXX"), is(300));
    }

    @Test
    public void get_score_given_twenty_rolls() throws Exception {
        assertThat(scoreOf("9-9-9-9-9-9-9-9-9-9-"), is(90));
    }

    @Test
    public void get_score_given_twenty_one_rolls() throws Exception {
        String game = "5/5/5/5/5/5/5/5/5/5/5";
        assertThat(new Game(toArray(game)).score(), is(150));
    }

    private int scoreOf(String rolls) {
        return new Game(toArray(rolls)).score();
    }

    private String[] toArray(String game) {
        String[] array = new String[game.length()];
        for (int i = 0; i < game.toCharArray().length; i++) {
            array[i] = String.valueOf(game.charAt(i));
        }
        return array;
    }
}
