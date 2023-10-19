

/** created new board and player objects and looped through the game.
 * added exception to cash outofbound error */

public class PlayTheGame {

    public static <e> void main(String[] args) {

        NewBoard board = new NewBoard();
        int currentPlayer = 1;

        while (!board.isGameOver()) {
            System.out.println("Player " + currentPlayer + "'s turn");
            System.out.println("Current board:");
            for (int i = 0; i < 14; i++) {
                System.out.print(board.getStones(i) + " ");
            }
            System.out.println();

            if (currentPlayer == 1) {
                Players.player1(board);
            } else {
                Players.player2(board);
            }

            currentPlayer = (currentPlayer == 1) ? 2 : 1; // Switch players (ternary)
        }

        int winner = board.getWinner();
        if (winner == 0) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Player " + winner + " wins!");
        }
    }

}

