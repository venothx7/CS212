/**
 * Created by Venoth on 9/1/2016.
 */

public class Palindrome {
    // given 2 strings, Check if the 2 strings are palindrome

    public static void main(String[] args) {
        String a = "0123456789";
        String b = "9876543219";

        //first convert both strings to array.
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        boolean check = true; // this turns false when its not equal while checking the string
        int range = b1.length - 1;

        if (a1.length == b1.length) { //check if both lengths are equal, if not then exit loop

            for (char i : a1) { //for loop going thru the array

                if (b1[range] != i) { // checks if both array are equal
                    check = false;
                }
                range--; //checks down the counter
            }

        } else {
            System.out.println("False, Length not matched");
        }
        System.out.println(check);
    }
}
