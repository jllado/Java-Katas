package katas.bowling;

/**
 * Created by jllado on 7/03/15.
 */
public class SpareFrame implements Frame {

    private Roll[] rolls;

    public SpareFrame(Roll[] rolls) {
        this.rolls = rolls;
    }

    @Override
    public int score() {
        return 10 + rolls[2].score();
    }
}
