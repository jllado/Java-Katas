package katas.bowling;

public class Roll {
    public Roll() {
    }

    boolean isSpare(String roll) {
        return Frame.isSpare(roll);
    }

    boolean isStrike(String roll) {
        return Frame.isStrike(roll);
    }
}
