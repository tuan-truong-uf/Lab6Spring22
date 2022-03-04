// Lab 05, March 4th, 2022
// Nathan Truong
// 5 methods (1 main method at the end), 151 lines

import java.util.Scanner;
public class ConnectFour {
    // method will return false if said player didn't win the game, otherwise it's true
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        boolean winner = false;  // return whether the player wins or not
        int chipCount = 0;  // used to count whether there are 4 consecutive chips of the same type

        for (int i = 0; i < array[0].length; i++) {  // this loop checks every row that the chip appeared for a consecutive 4
            if (array[row][i] == chipType) {
                chipCount += 1;
            }
            else {
                chipCount = 0;
            }

            if (chipCount == 4) {  // return true if there are enough consecutive chips
                winner = true;
                break;
            }
        }

        chipCount = 0;  // resets the counter

        if (!winner) {
            for (char[] chars : array) {  // in case there was no consecutive 4 in a row, this one checks for said column
                if (chars[col] == chipType) {
                    chipCount += 1;
                }
                else {
                    chipCount = 0;
                }

                if (chipCount == 4) {  // return true if there are enough consecutive chips
                    winner = true;
                    break;
                }
            }
        }

        return winner;
    }

    // method is used to insert the desired chip into said column, then return the row where said chip is placed
    public static int insertChip(char[][] array, int col, char chipType) {
        int row = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {  // if there is still space '-' then insert the chip and break the loop
                array[i][col] = chipType;
                row = i;  // the row where the chip is placed
                break;
            }
        }

        return row;  // return the row
    }

    // this method changes every blank slot in the array into the '-', which meant a free board with no chip inserted
    public static void initializeBoard(char[][] array) {
        for (int i = array.length; i > 0; i--) {  // this loop goes through each row
            for (int j = 0; j < array[0].length; j++) {  // this loop goes through each column
                array[i-1][j] = '-';  // give the slot a dash
            }
        }
    }

    // method is used to print the board out
    public static void printBoard(char[][] array) {
        for (int i = array.length; i > 0; i--) {  // goes through the rows
            for (int j = 0; j < array[0].length; j++) {  // goes through the column
                System.out.print(array[i-1][j]);  // print out the char in that index
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // setting up variables
        boolean game = true;
        Scanner scan = new Scanner(System.in);

        // ask for the desired height and length of the board
        System.out.print("What would you like the height of the board to be? ");
        int boardHeight = scan.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int boardLength = scan.nextInt();

        // initializing the board - create a new 2D array, initialize it, then print it out
        char[][] boardArray = new char[boardHeight][boardLength];
        initializeBoard(boardArray);
        printBoard(boardArray);
        System.out.println();
        int boardFill = boardHeight * boardLength;  // this is the maximum number of chips possible in a game also

        // give each player a char to work with
        System.out.println("Player 1: x");
        char player1 = 'x';
        System.out.println("Player 2: o");
        char player2 = 'o';
        System.out.println();

        // this loop will run, as long as no winner or draw has been declared
        while (game) {
            // ask for column, insert the chip, then print out the board
            System.out.print("Player 1: Which column would you like to choose? ");
            int column1 = scan.nextInt();
            int row1 = insertChip(boardArray, column1, player1);
            printBoard(boardArray);
            System.out.println();

            // if the chip inserted creates a row of 4 or a column of 4 consecutive chips, declare this player a winner
            boolean winner1 = checkIfWinner(boardArray, column1, row1, player1);
            if (winner1) {
                System.out.println("Player 1 won the game!");
                break;
            }

            // ask for column, insert the chip, then print out the board
            System.out.print("Player 2: Which column would you like to choose? ");
            int column2 = scan.nextInt();
            int row2 = insertChip(boardArray, column2, player2);
            printBoard(boardArray);
            System.out.println();

            // if the chip inserted creates a row of 4 or a column of 4 consecutive chips, declare this player a winner
            boolean winner2 = checkIfWinner(boardArray, column2, row2, player2);
            if (winner2) {
                System.out.println("Player 2 won the game!");
                break;
            }

            int boardFillCount = 0;  // used to count the number of chips placed in the board
            for (char[] chars : boardArray) {  // goes through each row
                for (int j = 0; j < boardArray[0].length; j++) {  // goes through each column
                    if (chars[j] == player1 || chars[j] == player2) {  // if a chip is present, the counter goes up by 1
                        boardFillCount += 1;
                    }
                }
            }
            if (boardFillCount == boardFill) {  // if the board is full, end the game
                System.out.println("Draw. Nobody wins.");
                game = false;
            }
        }
    }
}

// end of lab 05