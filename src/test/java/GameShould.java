import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameShould {
    @Test
    void a_game_starts_with_zero_points() {
        Game game = new Game();
        assertEquals(0, game.score());
    }
}
