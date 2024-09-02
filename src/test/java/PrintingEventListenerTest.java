import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


public class PrintingEventListenerTest {

    @Test
    void shouldPrintChoices(){
        PrintStream mockPrintStream = mock();
        Scanner scanner = new Scanner("3");
        Random random = mock();
        when(random.nextInt(3)).thenReturn(Move.PAPER);
        PrintEventListener eventListener = new PrintEventListener(mockPrintStream);
        HumanPlayer humanPlayer = new HumanPlayer(mockPrintStream, scanner);
        ComputerPlayer computerPlayer = new ComputerPlayer(random);
        Game game = new Game(humanPlayer, computerPlayer, eventListener);
        game.play();
        verify(mockPrintStream).println("Human chose Scissors");
        verify(mockPrintStream).println("Computer chose Paper");
    }
    @Test
    void shouldPrintWinner(){
        PrintStream mockPrintStream = mock();
        Scanner scanner = new Scanner("3");
        Random random = mock();
        when(random.nextInt(3)).thenReturn(Move.PAPER);
        PrintEventListener eventListener = new PrintEventListener(mockPrintStream);
        HumanPlayer humanPlayer = new HumanPlayer(mockPrintStream, scanner);
        ComputerPlayer computerPlayer = new ComputerPlayer(random);
        Game game = new Game(humanPlayer, computerPlayer, eventListener);
        game.play();
        verify(mockPrintStream).println("Human wins!!!");
    }

}

