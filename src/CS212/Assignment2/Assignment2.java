package CS212.Assignment2;

import java.util.Scanner;

/**
 * Assignment 2
 * Venoth Krishnan
 */

public class Assignment2 {
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
            while (!active ) {
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


}
