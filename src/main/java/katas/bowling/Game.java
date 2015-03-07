package katas.bowling;

public class Game {
    private Rolls rolls;

    public Game(String[] strings) {
        rolls = new Rolls(strings);
    }

    public int score() {
        return rolls.frames().stream().mapToInt(roll -> roll.score()).sum();
    }

}
