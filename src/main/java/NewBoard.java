/**Creating a new board object with a constructor that takes an integer size as a
parameter. It initializes the board array with six stones in each pit except for the two big pits
6 & 13 which are initialized to zero.
 It also contains methods for getting and setting the number of stones in a pit and adding stones to a pit.
 The getBoard() method returns the board array.**/

public class NewBoard {
        public final int[] board;

        public NewBoard() {
            board = new int[14];
            for (int i = 0; i < 14; i++) {
                if (i == 6 || i == 13) {
                    board[i] = 0;
                } else {
                    board[i] = 6;
                }
            }
        }

        public int getStones(int pit) {
            return board[pit];
        }

        public void setStones(int pit, int stones) {
            board[pit] = stones;
        }

        public void addStone(int pit) {
            board[pit]++;
        }


    /** If player 1 has more stones in their big pit (index 6), then player 1 wins, method returns 1.
     If player 2 has more stones in their big pit (index 13), then player 2 wins, method returns 2.
     If both players have the same number of stones in their big pits, it's a tie and method
     returns 0.*/
    public int getWinner() {
        if (board[6] > board[13]) {
            return 1;
        } else if (board[13] > board[6]) {
            return 2;
        } else {
            return 0;
        }
    }


    /** Method returns true if the game is over and false if not. It calculates the
     sum of the stones in each player’s pits and returns true if either sum is equal to zero.*/
    public boolean isGameOver() {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < board.length; i++) {
            if (i != 6 && i != 13) {
                if (i < 6) {
                    sum1 += board[i];
                } else {
                    sum2 += board[i];
                }
            }
        }
        return sum1 == 0 || sum2 == 0;
    }
}

//        NewBoard newBoard = new NewBoard(14);
//        int[] board = newBoard.getBoard();

