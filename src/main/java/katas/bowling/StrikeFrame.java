package katas.bowling;

/**
 * Created by jllado on 7/03/15.
 */
public class StrikeFrame implements Frame {

    private Roll[] rolls;

    public StrikeFrame(Roll[] rolls) {
        this.rolls = rolls;
    }

    @Override
    public int score() {
        return rolls[0].score() + rolls[1].score() + rolls[2].score();
    }
}
