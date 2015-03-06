package katas.bowling;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by jllado on 16/02/15.
 */
public class BowlingGameTest {
    private final Game game = new Game();

    @Test
    public void get_score_given_one_roll() throws Exception {
        assertThat(game.scoreOf("1"), is(1));
        assertThat(game.scoreOf("2"), is(2));
        assertThat(game.scoreOf("-"), is(0));
        assertThat(game.scoreOf("X"), is(10));
    }

    @Test
    public void get_score_given_game_with_one_frame() throws Exception {
        assertThat(game.scoreOf(new String[]{"1", "-"}), is(1));
    }

    @Test
    public void get_score_given_game_with_two_frames() throws Exception {
        assertThat(game.scoreOf(new String[]{"1", "-", "2", "3"}), is(6));
    }

    @Test
    public void get_score_given_game_with_three_frames() throws Exception {
        assertThat(game.scoreOf(new String[]{"1", "-", "2", "3", "1", "1"}), is(8));
    }

    @Test
    public void get_score_given_game_with_one_spare_frame() throws Exception {
        assertThat(game.scoreOf(new String[]{"1", "/", "2"}), is(12));
        assertThat(game.scoreOf(new String[]{"1", "/", "2", "1"}), is(15));
        assertThat(game.scoreOf(new String[]{"1", "2", "2", "/", "3"}), is(16));
        assertThat(game.scoreOf(new String[]{"1", "/", "2", "1", "3", "4"}), is(22));
        assertThat(game.scoreOf(new String[]{"1", "-", "2", "/", "3", "4"}), is(21));
        assertThat(game.scoreOf(new String[]{"1", "-", "2", "/", "3"}), is(14));
    }

    @Test
    public void get_score_given_game_with_one_strike_frame() throws Exception {
        assertThat(game.scoreOf(new String[]{"X", "1", "2"}), is(13));
        assertThat(game.scoreOf(new String[]{"X", "2", "2"}), is(14));
        assertThat(game.scoreOf(new String[]{"1", "2", "X", "3", "4"}), is(20));
        assertThat(game.scoreOf(new String[]{"1", "2", "3", "4", "X", "-", "5"}), is(25));
    }

    @Test
    public void get_score_given_game_with_two_spare_frame() throws Exception {
        assertThat(game.scoreOf(new String[]{"1", "/", "2", "/", "3"}), is(25));
        assertThat(game.scoreOf(new String[]{"1", "/", "2", "/", "3", "1"}), is(29));
        assertThat(game.scoreOf(new String[]{"1", "/", "2", "/", "3", "1", "4", "1"}), is(34));
    }

    @Test
    public void get_score_given_game_with_one_spare_frame_and_one_strike_frame() throws Exception {
        assertThat(game.scoreOf(new String[]{"1", "/", "2", "3", "X", "1", "2"}), is(30));
        assertThat(game.scoreOf(new String[]{"1", "/", "2", "3", "X", "1", "2", "3", "1"}), is(37));
    }

    @Test
    public void get_score_given_ten_strikes() throws Exception {
        assertThat(game.scoreOf(new String[]{"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"}), is(300));
    }

    @Test
    public void get_score_given_twenty_rolls() throws Exception {
        String game = "9-9-9-9-9-9-9-9-9-9-";
        assertThat(this.game.scoreOf(toArray(game)), is(90));
    }

    @Test
    public void get_score_given_twenty_one_rolls() throws Exception {
        String game = "5/5/5/5/5/5/5/5/5/5/5";
        assertThat(this.game.scoreOf(toArray(game)), is(150));
    }

    @Test
    public void get_frames_given_game_with_one_frame() throws Exception {
        assertThat(game.getFramesFrom(new String[]{"1", "3"}).get(0), is(new String[]{"1", "3"}));
        assertThat(game.getFramesFrom(new String[]{"1", "2"}).get(0), is(new String[]{"1", "2"}));
    }

    @Test
    public void get_frames_given_game_with_two_frames() throws Exception {
        String[] game = {"1", "2", "2", "2"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"1", "2"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"2", "2"}));
    }

    @Test
    public void get_frames_given_game_with_three_frames() throws Exception {
        String[] game = {"1", "2", "2", "2", "3", "2"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"1", "2"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"2", "2"}));
        assertThat(this.game.getFramesFrom(game).get(2), is(new String[]{"3", "2"}));
    }

    @Test
    public void get_frames_given_game_with_one_strike() throws Exception {
        String[] game = {"X", "1", "2"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"X", "1", "2"}));
    }

    @Test
    public void get_frames_given_game_with_one_strike_and_another_two_frames() throws Exception {
        String[] game = {"X", "1", "2", "3", "4"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"X", "1", "2"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"1", "2"}));
        assertThat(this.game.getFramesFrom(game).get(2), is(new String[]{"3", "4"}));
    }

    @Test
    public void get_frames_given_game_with_two_strike() throws Exception {
        String[] game = {"X", "X", "2", "3"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"X", "X", "2"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"X", "2", "3"}));
    }

    @Test
    public void get_frames_given_game_with_two_strike_and_another_frame() throws Exception {
        String[] game = {"1", "2", "X", "X", "2", "3"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"1", "2"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"X", "X", "2"}));
        assertThat(this.game.getFramesFrom(game).get(2), is(new String[]{"X", "2", "3"}));
    }

    @Test
    public void get_frames_given_game_with_one_spare() throws Exception {
        String[] game = {"2", "/", "3"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
    }

    @Test
    public void get_frames_given_game_with_one_spare_and_another_frame() throws Exception {
        String[] game = {"2", "/", "3", "1"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"3", "1"}));
    }

    @Test
    public void get_frames_given_game_with_one_spare_and_another_two_frames() throws Exception {
        String[] game = {"2", "/", "3", "1", "4", "1"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"3", "1"}));
        assertThat(this.game.getFramesFrom(game).get(2), is(new String[]{"4", "1"}));
    }

    @Test
    public void get_frames_given_game_with_two_spares() throws Exception {
        String[] game = {"2", "/", "3", "/", "4"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"3", "/", "4"}));
    }

    @Test
    public void get_frames_given_game_with_two_spares_and_another_frame() throws Exception {
        String[] game = {"2", "/", "3", "/", "4", "1"};
        assertThat(this.game.getFramesFrom(game).get(0), is(new String[]{"2", "/", "3"}));
        assertThat(this.game.getFramesFrom(game).get(1), is(new String[]{"3", "/", "4"}));
        assertThat(this.game.getFramesFrom(game).get(2), is(new String[]{"4", "1"}));
    }

    private String[] toArray(String game) {
        String[] array = new String[game.length()];
        for (int i = 0; i < game.toCharArray().length; i++) {
            array[i] = String.valueOf(game.charAt(i));
        }
        return array;
    }
}
