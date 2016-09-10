import javax.swing.*;
// This code was written by Venoth Krishnan
// CS 212 Assignment 1
//Due Friday September 9  11:59PM

public class Assignment1 {

    public static void main(String[] args) {
        avgInt();
        avgDoub();
        reverseInput();
        whiteSpaceCount();

    }
    // average 3 Integers, rounding 2 decimal places
    // User Input: 22,44,55
    // Output: The Average of 22,44,55 is 40.33
    public static void avgInt() {
        int sum = 0;
        String inputValue = JOptionPane.showInputDialog(null, "Enter 3 Numbers Seperated by a Space (Ex. 3 4 5)", "Average Of 3 Integers", JOptionPane.INFORMATION_MESSAGE);
        if (inputValue != null) {// if the user presses Cancel it will skip to the end of this method
            String[] parts = inputValue.split(","); // splits the input String and stores it in an array
            //Sums the 3 Integers
            for (String s : parts) { // a loop going through every value in the array
                sum = sum + Integer.parseInt(s); // converts the string into an integer, then adds it
            }
            double avg = (double) (sum) / parts.length; //getting the average, also typecasting
            double b = (double) Math.round(avg * 100) / 100;//rounding to 2 decimal places
            JOptionPane.showMessageDialog(null, "The Average of " + inputValue + " is " + b, "Average", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // average 3 Doubles,rounding 2 decimal places
    // User Input: 22.5,0.89,99.567
    // Output:Average of 22.5,0.89,99.567 is 40.99
    public static void avgDoub() {
        String inputValue = JOptionPane.showInputDialog(null, "Please 3 Decimal Numbers Seperated by a Space (Ex. .3 .4 5.5)", "Average of 3 Decimal Numbers", JOptionPane.INFORMATION_MESSAGE);
        double sum = 0;
        if (inputValue != null) {// if the user presses cancel it will skip to the end of this method
            String[] parts = inputValue.split(",");
            //Sums the 3 Doubles with loop
            for (String s : parts) { // a loop going through every value in the array
                sum = sum + Double.parseDouble(s); // convert string to Double then add to sum
            }
            double avg = (sum) / parts.length; //getting the average, also typecasting
            double b = (double) Math.round(avg * 100) / 100;//rounding to 2 decimal places
            JOptionPane.showMessageDialog(null, "The Average of " + inputValue + " is " + b, "Average", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    //User input: Venoth Krishnan
    //Output is: nanhsirK htoneV
    public static void reverseInput() {
        String inputValue = JOptionPane.showInputDialog(null, "Enter a your First and Last name Seperated with a space(Ex. John Smith)", "Reverse Input", JOptionPane.INFORMATION_MESSAGE);
        if (inputValue != null) {// if the user presses cancel it will skip to the end of this method
            char[] in = inputValue.toCharArray();//converting string to array
            int count = 0;
            int end = in.length - 1;// end of array is (length of array) -1
            char temp;
            while (end > count) {
                temp = in[count]; //temp holds count
                in[count] = in[end]; //stores the end of string into first
                in[end] = temp; // puts the start of the string to the end from temp
                end--; //subtract 1 so you can move to nxt letter from the right
                count++; //add 1 so you can move to the nxt letter from the left
                // keeps going until you get to the middle
            }
            String b = new String(in); // convert array in to a String called b.
            JOptionPane.showMessageDialog(null, b);
        }
    }//Reverse String

    public static void whiteSpaceCount() {

        String inputValue = JOptionPane.showInputDialog(null, "Please input a value ( Will Output number of white " +
                "spaces)", "White Space Count", JOptionPane.INFORMATION_MESSAGE);
        if (inputValue != null) { // if the user presses cancel it will skip to the end of this method
            char[] in = inputValue.toCharArray();//converting string to array
            int count = 0;
            for (char c : in) {
                if (Character.isWhitespace(c)) {
                    count++;
                }
            }
            JOptionPane.showMessageDialog(null, "There are " + count + " white spaces");
        }
    }


}



