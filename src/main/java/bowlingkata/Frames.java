package bowlingkata;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private List<Frame> frames;

    public Frames() {
        frames = new ArrayList<>();
        frames.add(new Frame());
    }

    Frame getFrame(int i) {
        return frames.get(frames.size() - i);
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
}