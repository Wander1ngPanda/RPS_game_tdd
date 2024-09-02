public class Game {
    private final Player player1;
    private final Player player2;
    private final EventListener eventListener;

    public Game(Player player1, Player player2, EventListener eventListener) {

        this.player1 = player1;
        this.player2 = player2;
        this.eventListener = eventListener;
    }

    public void play() {
        Player winner = null;
        while (winner == null) {
            int player1Choice = player1.shoot();
            int player2Choice = player2.shoot();

            eventListener.playerChoseMove(player1, player1Choice);
            eventListener.playerChoseMove(player2, player2Choice);

            if (Move.beats(player1Choice, player2Choice)) {
                winner = player1;
            } else if (Move.beats(player2Choice, player1Choice)) {
                winner = player2;
            } else eventListener.draw();
        }
        eventListener.playerWins(winner);
    }

    public interface EventListener {
        void playerChoseMove(Player player, int move);

        void playerWins(Player player);

        void draw();
    }
}
