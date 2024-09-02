import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTests {

    private final Player playsRock = makePlayer(Move.ROCK);
    private final Player playsPaper = makePlayer(Move.PAPER);
    private final SpyEventListener spyEventListener = new SpyEventListener();
    private final Player mockPlayer = mock(Player.class);

    @BeforeEach
    void setup(){
        when(mockPlayer.shoot()).thenReturn(Move.ROCK, Move.SCISSORS);
    }

    @Test
    void player2CanWin() {
        playGame(playsRock, playsPaper);
        spyEventListener.assertWinner(playsPaper);
    }

    @Test
    void player1CanWin() {
        playGame(playsPaper, playsRock);
        spyEventListener.assertWinner(playsPaper);
    }

    @Test
    void playersCanDraw() {
        playGame(playsRock, mockPlayer);
        spyEventListener.assertDraw();
    }

    @Test
    void shouldReportPlayer1MoveRock() {
        playGame(playsRock, playsPaper);
        spyEventListener.assertPlayerChoseMove(playsRock, Move.ROCK);
    }

    @Test
    void shouldReportPlayer2MovePaper() {
        playGame(playsRock, playsPaper);
        spyEventListener.assertPlayerChoseMove(playsPaper, Move.PAPER);
    }

    private Player makePlayer(int move) {
        return new Player() {
            @Override
            public int shoot() {
                return move;
            }
        };
    }

    private void playGame(Player player1, Player player2) {
        Game game = new Game(player1, player2, spyEventListener);
        game.play();
    }


    private static class SpyEventListener implements Game.EventListener {

        private final Map<Player, Integer> moves = new HashMap<>();
        private Player winner;
        private boolean draw;

        @Override
        public void playerChoseMove(Player player, int move) {
            moves.put(player, move);
        }

        @Override
        public void playerWins(Player winner) {
            this.winner = winner;
        }

        @Override
        public void draw() {
            this.draw = true;
        }

        public void assertPlayerChoseMove(Player expectedPlayer, int expectedMove) {
            assertTrue(moves.containsKey(expectedPlayer));
            assertEquals(expectedMove, moves.get(expectedPlayer));
        }

        public void assertWinner(Player expectedPlayer) {
            assertEquals(expectedPlayer, this.winner);
        }

        public void assertDraw() {
            assertTrue(this.draw);
        }
    }
}
