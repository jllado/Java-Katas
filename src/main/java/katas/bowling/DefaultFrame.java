package katas.bowling;

public class DefaultFrame implements Frame {

    private Roll[] rolls;

    public DefaultFrame(Roll[] rolls) {
        this.rolls = rolls;
    }

    @Override
    public int score() {
        return rolls[0].score() + rolls[1].score();
    }
}
