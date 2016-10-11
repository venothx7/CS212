package Fun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Venoth on 9/1/2016.
 */
public class TestRunner {

    public static void main(String[] args) {
        /**
         * testing regex
         */
        String a = "aracecara";
        String b = "9876543210";
        String input = "Venoth Krishnan";
        String inp1 = "Venoth  Krishnan";
        //([a-zA-Z]+)\s([a-zA-Z]+)
        //System.out.println(input.matches("([a-zA-Z]+)\\s([a-zA-Z]+)"));
        //System.out.println(input.matches("[a-zA-Z]+"));

        /**
         Scanner sc = new Scanner(System.in);
         while (!sc.hasNextInt()) {
         System.out.println("Enter a whole number");
         sc.next();
         }
         String i = sc.next();
         System.out.println(i);
         **/
        String[][] matrix = new String[3][3];
        int [][] test0=new int[3][3];
        // Fill each row with 1.0
        for (int[] row : test0) {
            Arrays.fill(row, 1);
        }
        for (String[] row:matrix){
            Arrays.fill(row,"1");
        }
        int counter = 0;
        String counter0="";

        System.out.println("test1");
        for (int[] s : test0) {
            System.out.println();
            for (int i : s) {
                counter+=i;
            }
        }
        System.out.println(counter);
        for (int[] s : test0) {
            System.out.println();
            for (int i : s) {

                System.out.print(i);
            }
        }
    }


    //System.out.println(isPalindrome(a));

}

/**
 * public static boolean isPalindrome(String input) {
 * if (input.length() <= 1) {
 * return true;
 * } else if (input.charAt(0) == input.charAt(input.length() - 1)) {
 * return isPalindrome(input.substring(1, input.length() - 1));
 * }
 * return false;
 * }
 */





