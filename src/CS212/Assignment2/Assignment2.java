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
        int r = -1, c = -1, input;
        String input0;
        while (game.getCounter() < 9) {// run the game 9 times

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
            /**
             * this while loop will keep asking the user for an input if they dont
             * enter it in the correct format, or if the position is already taken
             */
            boolean active = false;
            while (!active) {
                System.out.println("start while loop");
                input0 = reader.nextLine();
                if (input0.matches("^\\d$")) {
                    //switch case converts the input to row, column
                    switch (input0) {
                        case "1":
                            r = 0;
                            c = 0;
                            break;
                        case "2":
                            r = 0;
                            c = 1;
                            break;
                        case "3":
                            r = 0;
                            c = 2;
                            break;
                        case "4":
                            r = 1;
                            c = 0;
                            break;
                        case "5":
                            r = 1;
                            c = 1;
                            break;
                        case "6":
                            r = 1;
                            c = 2;
                            break;
                        case "7":
                            r = 2;
                            c = 0;
                            break;
                        case "8":
                            r = 2;
                            c = 1;
                            break;
                        case "9":
                            r = 2;
                            c = 2;
                            break;

                        default:
                            //the input cant be converted, not valid input
                            System.out.println("Please Enter a valid input!");
                            continue;
                    }

                    //checks if spot is taken, if not then add to the board
                    if (game.validateMove(r,c)){
                        game.addMove(r,c);
                        active=true; // to break out of while loop
                    }
                    else{//if spot is taken,
                        System.out.println("Invalid Move!, Position already taken! ");
                        System.out.println("Please try again, ");
                        continue;
                    }
                }

                else{// prints this if the user enters not a digit
                    System.out.println("Please enter the correct format, ");
                }
                System.out.println("end while loop");
            }
            System.out.println(game); // print board
           // game.boardState(currentPlayer);
            System.out.println("end of currentPLayer");
        }
        System.out.println("end main");
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
