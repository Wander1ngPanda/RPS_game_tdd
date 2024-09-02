import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerPlayerTest {

    private static int getMove(int moveChoice) {
        Random fakeRandom = getFakeRandom(moveChoice);
        Player computerPlayer = new ComputerPlayer(fakeRandom);
        return computerPlayer.shoot();
    }

    private static Random getFakeRandom(final int i) {
        return new Random() {
            @Override
            public int nextInt(int n) {
                return i;
            }
        };
    }

    @Test
    void randNumGeneratorShouldThrowRock() {
        assertEquals(Move.ROCK, getMove(0));
    }

    @Test
    void randNumGeneratorShouldThrowPaper() {
        assertEquals(Move.PAPER, getMove(1));
    }

    @Test
    void randNumGeneratorShouldThrowScissors() {
        assertEquals(Move.SCISSORS, getMove(2));
    }
}
