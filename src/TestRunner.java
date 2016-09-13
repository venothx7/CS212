/**
 * Created by Venoth on 9/1/2016.
 */
public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Tester");
        String a = "0123456789";
        String b = "9876543210";

        //first convert both strings to array.
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        boolean check = true; // this turns false when its not equal while checking the string
        int range = b1.length - 1;

        if (a1.length == b1.length) { //check if both lengths are equal, if not then exit loop

            for (int i = 0; i < range; i++) { //for loop going thru the array

                if (b1[range] != a1[i]) { // checks if both array are equal
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


