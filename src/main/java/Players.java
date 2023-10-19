//method for capturing stones from an opponent’s pit and adding them to their own pit.

import java.util.Scanner;

public class Players {


    static void player1(NewBoard board){
        Scanner input = new Scanner(System.in);
        int pit;
        do {
            System.out.print("Player 1, choose a pit to move stones from: ");
            pit = input.nextInt();
            if (pit < 0 || pit > 5 || board.getStones(pit) == 0) {
                System.out.println("Invalid pit selection. Please choose a valid pit from 0 to 5.");
            }
        } while (pit < 0 || pit > 5 || board.getStones(pit) == 0);

        int stones = board.getStones(pit);  // Get the number of stones in the selected pit
        board.setStones(pit, 0);      // Remove all stones from the selected pit

        int currentPit = pit;  // Initialize the current pit to the selected pit

        while (stones > 0) {
            currentPit++;
            if (currentPit == 13) {
                currentPit = 0;  // Wrap around to the beginning if necessary
            }

            if (currentPit == 6) {
                continue;  // Skip Player 2's big pit
            }

            board.addStone(currentPit);  // Place one stone in the current pit
            stones--;

            // Check for captures (opposite pit)
            if (currentPit >= 0 && currentPit <= 5 && stones == 0 && board.getStones(currentPit) == 1) {
                int oppositePit = 12 - currentPit;
                if (board.getStones(oppositePit) > 0) {
                    board.setStones(6, board.getStones(6) + board.getStones(oppositePit) + 1);
                    board.setStones(oppositePit, 0);
                    board.setStones(currentPit, 0);
                }
            }
        }

        // Check if the last stone landed in Player 1's big pit (pit index 6)
        if (currentPit == 6) {
            System.out.println("Player 1 gets another turn!");
            player1(board);  // Recursively call player1 gets another turn
        }
    }




    static void player2(NewBoard board) {
        Scanner input = new Scanner(System.in);
        int pit;
        do {
            System.out.print("Player 2, choose a pit to move stones from: ");
            pit = input.nextInt();
            if (pit < 7 || pit > 12 || board.getStones(pit) == 0) {
                System.out.println("Invalid pit selection. Please choose a valid pit from 7 to 12.");
            }
        } while (pit < 7 || pit > 12 || board.getStones(pit) == 0);

        int stones = board.getStones(pit);  // Get the number of stones in the selected pit
        board.setStones(pit, 0);     // Remove all stones from the selected pit

        int currentPit = pit;  // Initialize the current pit to the selected pit

        while (stones > 0) {
            currentPit++;
            if (currentPit == 13) {
                currentPit = 0;  // Wrap around to the beginning if necessary
            }

            if (currentPit == 13) {
                continue;  // Skip Player 1's big pit
            }

            board.addStone(currentPit);  // Place one stone in the current pit
            stones--;

            // Check for captures (opposite pit)
            if (currentPit >= 7 && currentPit <= 12 && stones == 0 && board.getStones(currentPit) == 1) {
                int oppositePit = 12 - currentPit;
                if (board.getStones(oppositePit) > 0) {
                    board.setStones(13, board.getStones(13) + board.getStones(oppositePit) + 1);
                    board.setStones(oppositePit, 0);
                    board.setStones(currentPit, 0);
                }
            }
        }

        // Check if the last stone landed in Player 2's big pit (pit index 13)
        if (currentPit == 13) {
            System.out.println("Player 2 gets another turn!");
            player2(board);  // Recursively call player2 gets another turn
        }
    }
}
