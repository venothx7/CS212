package Fun;

/**
 * Created by Venoth on 9/1/2016.
 */
public class TestRunner {

    public static void main(String[] args) {
        System.out.println("Tester");
        String a = "aracecara";
        String b = "9876543210";


        System.out.println(isPalindrome(a));

    }

    public static boolean isPalindrome(String input) {

        if (input.length() <= 1) {
            return true;
        } else if (input.charAt(0) == input.charAt(input.length() - 1)) {
            return isPalindrome(input.substring(1, input.length() - 1));
        }
        return false;
    }
}


