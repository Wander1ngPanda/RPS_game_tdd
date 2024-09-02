public class Move {
    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;

    public static boolean beats(int move1, int move2) {
        switch (move1){
            case ROCK:
                return move2 == SCISSORS;
            case PAPER:
                return move2 == ROCK;
            case SCISSORS:
                return move2 == PAPER;
            default:
                return false;
        }
    }
}
