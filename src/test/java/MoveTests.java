import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTests {
    @Test
    void rockShouldBeatScissors() {assertTrue(Move.beats(Move.PAPER, Move.ROCK));}

    @Test
    void scissorsShouldBeatPaper() {
        assertTrue(Move.beats(Move.SCISSORS, Move.PAPER));
    }

    @Test
    void paperShouldBeatRock() {
        assertTrue(Move.beats(Move.ROCK, Move.SCISSORS));
    }


}
