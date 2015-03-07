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
        Roll firstRoll = rolls.get(index);
        Roll secondRoll = rolls.get(index + 1);
        if (isLastFrame(index)) {
            return index + LAST_FRAME_MAX_LENGTH;
        }
        if (firstRoll.isStrike() || secondRoll.isSpare()) {
            return index + (secondRoll.isSpare() ? FRAME_LENGTH : STRIKE_FRAME_LENGTH);
        }
        return index + FRAME_LENGTH;
    }

    private boolean isLastFrame(int index) {
        return index + 3 == rolls.size();
    }

    private Frame frame(int index) {
        Roll firstRoll = rolls.get(index);
        Roll secondRoll = rolls.get(index + 1);
        if (firstRoll.isStrike()) {
            Roll thirdRoll = rolls.get(index + 2);
            return new StrikeFrame(new Roll[]{firstRoll, secondRoll, thirdRoll});
        }
        if (secondRoll.isSpare()) {
            Roll thirdRoll = rolls.get(index + 2);
            return new SpareFrame(new Roll[]{firstRoll, secondRoll, thirdRoll});
        }
        return new DefaultFrame(new Roll[]{firstRoll, secondRoll});
    }


}
