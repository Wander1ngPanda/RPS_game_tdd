import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanPlayerTest {

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Test
    void outputShouldBeCorrect() {
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        Player humanPlayer = new HumanPlayer(printStream, new Scanner("2"));

        humanPlayer.shoot();

        assertEquals("Enter 1 for Rock, 2 for Scissors or 3 for Paper" + System.lineSeparator(), byteArrayOutputStream.toString());

    }

    @Test
    void scissorsInputShouldBeCorrect() {
        assertEquals(Move.PAPER, getMove("2"));
    }

    @Test
    void rockInputShouldBeCorrect() {
        assertEquals(Move.ROCK, getMove("1"));
    }

    @Test
    void paperInputShouldBeCorrect() {
        assertEquals(Move.SCISSORS, getMove("3"));
    }

    @Test
    void testToString(){
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        Player humanPlayer = new HumanPlayer(printStream, new Scanner("2"));
        assertEquals("Human", humanPlayer.toString());
    }

    private int getMove(String source) {
        HumanPlayer humanPlayer = new HumanPlayer(new PrintStream(byteArrayOutputStream), new Scanner(source));
        return humanPlayer.shoot();
    }
}