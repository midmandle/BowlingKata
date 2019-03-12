package bowlingkata;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Frames {
    private List<Frame> frames;

    public Frames() {
        frames = new ArrayList<>();
        frames.add(new Frame());
    }

    void addFrame() {
        frames.add(new Frame());
    }

    int score() {
        return frames
                .stream().mapToInt(frame -> frame.score())
                .sum();
    }

    double size() {
        return frames.size();
    }

    Frame currentFrame() {
        return getFrame(1);
    }

    Optional<Frame> previousFrame() {
        if (frames.size() < 2)
            return Optional.empty();

        return Optional.of(getFrame(2));
    }

    private Frame getFrame(int i) {
        return frames.get(frames.size() - i);
    }

    void addRollToCurrentFrame(Roll roll) {
        currentFrame().add(roll);
    }

    FrameState state() {
        return currentFrame().state();
    }

    Optional<Frame> secondToLast() {
        if(frames.size() < 3)
            return Optional.empty();

        return Optional.of(getFrame(3));
    }
}