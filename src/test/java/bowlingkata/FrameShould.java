package bowlingkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrameShould {
    @Test
    void start_in_play() {
        Frame frame = new Frame(0, 0);
        assertEquals(FrameState.IN_PLAY, frame.state());
    }

    @Test
    void check_if_there_is_a_spare() {
        Frame frame = new Frame(new Roll(5), new Roll(5));

        assertTrue(frame.isSpare());
    }
}
