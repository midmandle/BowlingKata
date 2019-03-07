package bowlingkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameShould {

    @Test
    void a_game_starts_with_zero_points() {
        Game game = new Game();
        assertEquals(0, game.score());
    }

    @Test
    void add_score_has_player_roll() {
        Game game = new Game();

        game.roll(1);

        assertEquals(1, game.score());
    }
}
