import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final PrintStream printStream;
    private final Scanner scanner;

    public HumanPlayer(PrintStream printStream, Scanner scanner) {
        this.printStream = printStream;
        this.scanner = scanner;
    }


    @Override
    public int shoot() {
        printStream.println("Enter 1 for Rock, 2 for Scissors or 3 for Paper");
        return scanner.nextInt() - 1;
    }
    @Override
    public String toString(){
        return "Human";
    }
}
