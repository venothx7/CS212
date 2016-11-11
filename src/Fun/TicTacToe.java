package Fun;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Venoth on 10/27/2016.
 */
public class TicTacToe {
    private String[][] board = new String[3][3];
    private int counter = 0;

    //creates the board when created
    public TicTacToe() {
        createBoard();
    }

    public static void main(String[] args) {
        int PlayerO = 0;
        int PlayerX = 1;
        int currentPlayer;//starting player

        TicTacToe game = new TicTacToe();

        Scanner reader = new Scanner(System.in);
        System.out.println("Player 0 is X's");
        System.out.println("Player 1 is O's \n");

        //System.out.println("1" + " | " + "2" + " | " + "3" + "\n" +
        //        "4" + " | " + "5" + " | " + "6" + "\n" +
        //        "7" + " | " + "8" + " | " + "9");
        // System.out.println("Use the numbers above to determine the position you want to input you value");

        int row, column;
        String input0;
        while (game.checkCounter()) {// run the game 9 times

            if (game.getCounter() % 2 == 0) { //even for 0,2,4,6,8
                //System.out.println("even " + game.getCounter());
                System.out.println("Player A's turn, choose a position to place an 'X' ");
                currentPlayer = PlayerX;

            } else {//Odd 1,3,5,7
                //System.out.println("odd " + game.getCounter());
                System.out.println("Player B's turn, choose a position to place an 'O' ");
                //board[input - 1] = "O";
                currentPlayer = PlayerO;
            }
            /**
             * this while loop will keep asking the user for an input if they don't
             * enter it in the correct format, or if the position is already taken
             */
            boolean active = false;
            while (!active) {
                input0 = reader.nextLine();
                if (input0.matches("^\\d$")) {
                    //switch case converts the input to row, column
                    switch (input0) {
                        case "1":
                            row = 0;
                            column = 0;
                            break;
                        case "2":
                            row = 0;
                            column = 1;
                            break;
                        case "3":
                            row = 0;
                            column = 2;
                            break;
                        case "4":
                            row = 1;
                            column = 0;
                            break;
                        case "5":
                            row = 1;
                            column = 1;
                            break;
                        case "6":
                            row = 1;
                            column = 2;
                            break;
                        case "7":
                            row = 2;
                            column = 0;
                            break;
                        case "8":
                            row = 2;
                            column = 1;
                            break;
                        case "9":
                            row = 2;
                            column = 2;
                            break;

                        default:
                            //the input cant be converted, not valid input
                            System.out.println("Please Enter a valid input!");
                            continue;
                    }
                    //checks if spot is taken, if not then add to the board
                    if (game.validateMove(row, column)) {
                        game.addMove(row, column);
                        game.addCounter();
                        active = true; // to break out of while loop
                    } else {//if spot is taken,
                        System.out.println("Invalid Move!, Position already taken! ");
                        System.out.println("Please try again, ");
                        continue;
                    }
                } else {// prints this if the user enters not a digit
                    System.out.println("Please enter the position in the correct format, ");
                }
            }
            System.out.println(game); // print board
            game.boardState(currentPlayer);
        }
    }

    //initializes the board array with single whitespace
    public void createBoard() {
        for (String[] row : board) {
            Arrays.fill(row, " ");
        }
    }

    public int getCounter() {
        return counter;
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

    //checks the three columns and rows and also both diagonals for a winner
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
        return checkThree(board[2][0], board[2][2], board[0][2]);

    }

    //returns true if the 3 String inputs are all equal and not empty.
    public Boolean checkThree(String a, String b, String c) {
        return !a.equals(" ") && a.equals(b) && b.equals(c);
    }

    //given the row and column, an X or an O will be added to the board
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


