package CS212.Assignment2;

import java.util.Arrays;

public class PlayGame {
    private String[][] board = new String[3][3];
    private int counter = 0;


    public int getCounter() {
        return counter;
    }

    // Creates board, a 3x3 2d array with single whitespaces
    public PlayGame() {
        createBoard();
    }

    //check if board has winner, tie, Full
    public void boardState(int player) {
        //checks if a winner has been found
        if (checkWinner()) {
            System.out.println("Player " + player + " has WON the game!!");
            counter = 10;//to break out of the while loop in main class
        }
        //checks to see if board is filled, if so then game is a tie
        if (counter == 9) {
            System.out.println("Game is a Tie, no one won");
        }

    }

    public Boolean checkWinner() {
        int column = 0, row = 0;
        //Checks if there is a winner in Columns
        while (column <= 2) {
            if (checkThree(board[0][column], board[1][column], board[2][column])) {
                return true;
            }
            column++;
        }
        //Checks if there is a winner in Rows
        while (row <= 2) {
            if (checkThree(board[row][0], board[row][1], board[row][2])) {
                return true;
            }
            row++;
        }

        //checks if there is a winner in the left diagonal(- slope)
        if (checkThree(board[0][0], board[1][1], board[2][2])) {
            return true;
        }
        //checks right diagonal(+ slope)
        if (checkThree(board[2][0], board[2][2], board[0][2])) {
            return true;
        }

        return false;
    }

    //given 3 string inputs a, b, c
    //returns true if they are all equal and not empty.
    public Boolean checkThree(String a, String b, String c) {
        return !a.equals(" ") && a.equals(b) && b.equals(c);
    }

    //given the row and column, and X or an O will be added to the board
    public void addMove(int row, int col) {

        if (counter % 2 == 0) { //even 0,2,4,6,8}
            board[row][col] = "X";
        } else {//Odd 1,3,5,7
            board[row][col] = "O";
        }
    }

    // returns true if the position is empty
    public Boolean validateMove(int r, int c) {
        return board[r][c] == " ";
    }

    //initializes the board array with single whitespace
    public void createBoard() {
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
    }

    // adds 1 to the counter, to keep track of how many positions are filled
    public void addCounter() {
        counter++;
    }

    //returns true if the counter is less than 9, the board is full when counter =8
    public Boolean checkCounter() {
        return counter < 9;
    }

    @Override
    public String toString() {
        return board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" +
                board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" +
                board[2][0] + " | " + board[2][1] + " | " + board[2][2];
    }
}
