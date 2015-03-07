package katas.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jllado on 7/03/15.
 */
public class Rolls {
    private static final int FRAME_LENGTH = 2;
    private static final int LAST_FRAME_MAX_LENGTH = 3;
    private static final int STRIKE_FRAME_LENGTH = 1;

    private List<Roll> rolls;

    public Rolls(String[] strings) {
        rolls = new ArrayList<>();
        for (String string : strings) {
            rolls.add(new Roll(string));
        }
    }

    public List<Frame> frames() {
        List<Frame> frames = new ArrayList<>();
        int roll = 0;
        while (roll < rolls.size()) {
            frames.add(frame(roll));
            roll = nextRoll(roll);
        }
        return frames;
    }

    private int nextRoll(int index) {
        if (isLastFrame(index)) {
            return index + LAST_FRAME_MAX_LENGTH;
        }
        if (firstRoll(index).isStrike() || secondRoll(index).isSpare()) {
            return index + (secondRoll(index).isSpare() ? FRAME_LENGTH : STRIKE_FRAME_LENGTH);
        }
        return index + FRAME_LENGTH;
    }

    private boolean isLastFrame(int index) {
        return index + 3 == rolls.size();
    }

    private Frame frame(int index) {
        if (firstRoll(index).isStrike()) {
            return new StrikeFrame(new Roll[]{firstRoll(index), secondRoll(index), thirdRoll(index)});
        }
        if (secondRoll(index).isSpare()) {
            return new SpareFrame(new Roll[]{firstRoll(index), secondRoll(index), thirdRoll(index)});
        }
        return new DefaultFrame(new Roll[]{firstRoll(index), secondRoll(index)});
    }

    private Roll thirdRoll(int index) {
        return rolls.get(index + 2);
    }

    private Roll secondRoll(int index) {
        return rolls.get(index + 1);
    }

    private Roll firstRoll(int index) {
        return rolls.get(index);
    }


}
