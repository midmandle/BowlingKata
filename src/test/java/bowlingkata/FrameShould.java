package bowlingkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameShould {
    @Test
    void start_in_play() {
        Frame frame = new Frame(0, 0);
        assertEquals(FrameState.IN_PLAY, frame.state());
    }
}
