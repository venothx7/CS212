package Fun;

/**
 * Created by Venoth on 9/1/2016.
 */
public class TestRunner {

    public static void main(String[] args) {
        System.out.println("Tester");
        String a = "aracecara";
        String b = "9876543210";

        //convertLetterGrade(a);
        double gPoint;
        String Grade = "A";

        switch (Grade) {
            case "A+":
                gPoint = 4.3;
            case "A":
                gPoint = 4.0;
                break;
            case "A-":
                gPoint = 3.7;
            case "B+":
                gPoint = 3.4;
            case "B":
                gPoint = 3.1;
            case "B-":
                gPoint = 2.8;
            case "C+":
                gPoint = 2.5;
            case "C":
                gPoint = 2.2;
            case "C-":
                gPoint = 1.9;
            case "D+":
                gPoint = 1.6;
            case "D":
                gPoint = 1.3;
            case "D-":
                gPoint = 1.0;
            case "F":
                gPoint = 0.0;
            default:
                gPoint = 0.0;
        }
        System.out.println(gPoint);


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


