package bowlingkata;

import java.util.ArrayList;
import java.util.List;

class Game {
    private List<Frame> frames;

    public Game() {
        frames = new ArrayList<>();
        frames.add(new Frame());
    }

    int score() {
        return frames
                .stream().mapToInt(frame -> frame.score())
                .sum();
    }


    public void roll(int rollScore) {

        if (getFrame(1).state() == FrameState.FINISHED) {
            frames.add(new Frame());
        }

        Roll roll = new Roll(rollScore);
        getFrame(1).add(roll);

        if (frames.size() > 1) {
            if (getFrame(2).isSpare()) {
                getFrame(2).addBonus(roll);
            }
        }
    }

    private Frame getFrame(int i) {
        return frames.get(frames.size() - i);
    }
}
