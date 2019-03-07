package bowlingkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameShould {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void start_with_zero_points() {
        assertEquals(0, game.score());
    }

    @Test
    void add_score_has_player_roll() {
        game.roll(1);

        assertEquals(1, game.score());
    }

    @Test
    void sum_rolls() {
        game.roll(1);
        game.roll(1);

        assertEquals(2, game.score());
    }
}
