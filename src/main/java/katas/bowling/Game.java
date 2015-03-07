package katas.bowling;

public class Game {
    private Rolls rolls;

    public Game(String[] strings) {
        rolls = new Rolls(strings);
    }

    public int score() {
        int score = 0;
        for (Frame frame : rolls.frames()) {
            score += frame.score();
        }
        return score;
    }

}
