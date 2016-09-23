package Fun;

/**
 * Created by Venoth on 9/1/2016.
 */
public class TestRunner {

    public static void main(String[] args) {
        String a = "aracecara";
        String b = "9876543210";
        String input = "Venoth Krishnan";
        String inp1 = "Venoth  Krishnan";
        //([a-zA-Z]+)\s([a-zA-Z]+)
        System.out.println(input.matches("([a-zA-Z]+)\\s([a-zA-Z]+)"));
        System.out.println(input.matches("[a-zA-Z]+"));



        //System.out.println(isPalindrome(a));

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


