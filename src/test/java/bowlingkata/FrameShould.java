package bowlingkata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrameShould {

    private Frame frame;

    @BeforeEach
    void setUp() {
        frame = new Frame();
    }

    @Test
    void start_in_play() {
        frame.add(new Roll(1));
        assertEquals(FrameState.IN_PLAY, frame.state());
    }

    @Test
    void check_if_there_is_a_spare() {
        frame.add(new Roll(5));
        frame.add(new Roll(5));

        assertTrue(frame.isSpare());
    }

    @Test
    void check_if_there_is_a_strike() {

        frame.add(new Roll(10));

        assertTrue(frame.isStrike());
    }

    @Test
    void end_after_a_strike() {
        frame.add(new Roll(10));

        assertEquals(FrameState.FINISHED, frame.state());
    }

    @Test
    void finish_after_two_rolls() {
        frame.add(new Roll(5));
        frame.add(new Roll(5));
        assertEquals(FrameState.FINISHED, frame.state());
    }
}
