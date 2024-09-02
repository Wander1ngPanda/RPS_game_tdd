import java.io.PrintStream;
import java.util.List;

public class PrintEventListener implements Game.EventListener {

    private final PrintStream printStream;

    public PrintEventListener(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void playerChoseMove(Player player, int move) {
        String moveChoice = null;
        switch (move) {
            case Move.ROCK:
                moveChoice = "Rock";
                break;
            case Move.PAPER:
                moveChoice = "Paper";
                break;
            case Move.SCISSORS:
                moveChoice = "Scissors";
                break;
        }

        printStream.println(player.toString() + " chose " + moveChoice);
    }

    @Override
    public void playerWins(Player player) {
        printStream.println(player.toString() + " wins!!!");
    }

    @Override
    public void draw() {

    }
}
