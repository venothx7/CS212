package CS212.Assignment2;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Assignment 2
 * Venoth Krishnan
 */
//String[] board={"_","_","_","_","_","_","_","_","_"};
//String[] board = {" ", " ", " ", " ", " ", " ", " ", " ", " "};

public class Assignment2 {
    public static void main(String[] args) {
        int PlayerO = 0;
        int PlayerX = 1;
        int currentPlayer;//starting player
        PlayGame game = new PlayGame();

        Scanner reader = new Scanner(System.in);
        System.out.println("Player 0 is X's");
        System.out.println("Player 1 is O's \n");

        System.out.println("1" + " | " + "2" + " | " + "3" + "\n" +
                "4" + " | " + "5" + " | " + "6" + "\n" +
                "7" + " | " + "8" + " | " + "9");
        System.out.println("Use the numbers above to determine the position you want to input you value");

        int counter = 0;
        int r=-1, c=-1, input;
        String input0;
        while (game.getCounter() < 9) {

            if (game.getCounter() % 2 == 0) { //even for 0,2,4,6,8
                System.out.println("even " + game.getCounter());
                System.out.println("Player A, Please choose a position to place your 'X' ");
                currentPlayer = PlayerX;

            } else {//Odd 1,3,5,7
                System.out.println("odd " + game.getCounter());
                System.out.println("Player B, Please choose a position to place your 'O' ");
                //board[input - 1] = "O";
                currentPlayer = PlayerO;
            }
            input0 = reader.nextLine();
            while (input0 != "") {
                switch (input0) {
                    case "1":
                        r = 0;
                        c = 0;
                        break;
                    case "2":
                        r = 0;
                        c = 1;
                        break;
                    default:
                        System.out.println("Please Enter a valid input!");
                        input0 = reader.nextLine();

                }
            }

            while (!game.validateMove(r, c)) {
                System.out.println("Invalid Move!, Position already taken");
                System.out.println("Please try again, ");
                input0 = reader.nextLine();
            }
            game.addMove(r, c);
            System.out.println(game); // print board
            game.boardState(currentPlayer);
        }
    }


    public static void printBoard(String[] board) {
        System.out.println(board[0] + " | " + board[1] + " | " + board[2] + "\n" +
                board[3] + " | " + board[4] + " | " + board[5] + "\n" +
                board[6] + " | " + board[7] + " | " + board[8]);

    }

    public static Boolean checkValidMove(String[] board, int pos) {
        if (board[pos - 1] != " ") {
            return false;
        } else return true;
    }

    public static void checkState(String[] board) {


    }


}
