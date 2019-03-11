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

    @Test
    void give_a_bonus_score_with_the_score_of_the_next_roll() {
        game.roll(5);
        game.roll(5);
        game.roll(3);

        assertEquals(16, game.score());
    }

    @Test
    void calculate_score_with_multiple_spares() {
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(5);
        game.roll(1);

        assertEquals(27, game.score());
    }
}
