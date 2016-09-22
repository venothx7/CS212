package CS212.Assignment2;

import java.util.Scanner;
/**
 * Assignment 2
 * Venoth Krishnan
 */
public class Assignment2 {
    public static void main(String[] args) {
        String[] board={"_"," "," ","_","_","_"," ","_","_"};
        System.out.println(board.length);

        Scanner reader = new Scanner(System.in);
        System.out.println("Player A is X's");
        System.out.println("Player B is O's \n");

        System.out.println("1" + " | " + "2" + " | " + "3" + "\n" +
                "4" + " | " + "5" + " | " + "6" + "\n" +
                "7" + " | " + "8" + " | " + "9");
        System.out.println("Use the numbers above to determine the position you want to input you value");
        System.out.println("for Example: if you enter 9, and you are player B, the position will be filled with an O.");

        int counter=0;
        while(counter!=9) {

            if (counter%2 ==0){ //even for 0,2,4,6,8
                System.out.println("even " +counter);
                System.out.println("Player A, Please choose a position to place your 'X' ");
                int input = reader.nextInt();


            }
            else {//Odd 1,3,5,7
                System.out.println("odd "+ counter);
                System.out.println("Player B, Please choose a position to place your 'O' ");

            }

            counter++;

        }


    }





}
