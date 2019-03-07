package bowlingkata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrameShould {
    @Test
    void start_in_play() {
        Frame frame = new Frame();
        frame.add(new Roll(1));
        assertEquals(FrameState.IN_PLAY, frame.state());
    }

    @Test
    void check_if_there_is_a_spare() {
        Frame frame = new Frame();
        frame.add(new Roll(5));
        frame.add(new Roll(5));

        assertTrue(frame.isSpare());
    }

    @Test
    void finish_after_two_rolls() {
        Frame frame = new Frame();
        frame.add(new Roll(5));
        frame.add(new Roll(5));
        assertEquals(FrameState.FINISHED, frame.state());
    }
}
