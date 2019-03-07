package bowlingkata;

import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Integer> scores = new ArrayList<>();

    int score() {
        return scores
                .stream().mapToInt(score -> score)
                .sum();
    }


    public void roll(int rollScore) {
        scores.add(rollScore);

        if (scores.size() > 2) {
            Frame frame = lastRolledFrame();

            if (frame.isSpare()) {
                scores.remove(scores.size() - 2);
                scores.add(scores.size() - 2, frame.secondRollScore() + rollScore);
            }
        }
    }

    private Frame lastRolledFrame() {
        int firstRoll = scores.get(scores.size() - 3);
        int secondRoll = scores.get(scores.size() - 2);
        return new Frame(new Roll(firstRoll), new Roll(secondRoll));
    }
}
