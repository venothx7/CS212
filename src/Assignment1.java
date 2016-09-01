import javax.swing.*;

public class Assignment1 {

    public static void main(String[] args) {
        //avgInt();
        //avgDoub();
        //reverseInput();
        //whiteSpaceCount();
        String testString = "101";
        int testInt = Integer.parseInt(testString);
        System.out.println(testInt+1);
        //committed 8/31/2016 2d




    }

    //
    public static void avgInt() {
        int sum = 0;
        String inputValue = JOptionPane.showInputDialog(null, "Enter 3 Numbers Seperated by a Space (Ex. 3 4 5)", "Average Of 3 Integers", JOptionPane.INFORMATION_MESSAGE);
        if (inputValue != null) {// if the user presses cancel it will skip to the end of this method
            String[] parts = inputValue.split(" ");
            //Sums the 3 Integers
            for (String s : parts) {
                sum = sum + Integer.parseInt(s);
            }
            double avg = (double) (sum) / parts.length; //getting the average, also typecasting
            double b = (double) Math.round(avg * 100) / 100;//rounding to 2 decimal places
            JOptionPane.showMessageDialog(null, "The Average of " + inputValue + " is " + b, "Average", JOptionPane.INFORMATION_MESSAGE);
        }
    }// average 3 Integers, rounding 2 decimal places

    public static void avgDoub() {
        String inputValue = JOptionPane.showInputDialog(null, "Please 3 Decimal Numbers Seperated by a Space (Ex. .3 .4 5.5)", "Average of 3 Decimal Numbers", JOptionPane.INFORMATION_MESSAGE);
        double sum = 0;
        if (inputValue != null) {// if the user presses cancel it will skip to the end of this method
            String[] parts = inputValue.split(" ");
            //Sums the 3 Integers with loop
            for (String s : parts) {
                sum = sum + Double.parseDouble(s);
            }
            double avg = (sum) / parts.length; //getting the average, also typecasting
            double b = (double) Math.round(avg * 100) / 100;//rounding to 2 decimal places
            JOptionPane.showMessageDialog(null, "The Average of " + inputValue + " is " + b, "Average", JOptionPane.INFORMATION_MESSAGE);
        }

    } // average 3 Doubles,rounding 2 decimal places

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

        String inputValue = JOptionPane.showInputDialog(null, "Please input a value", "Average", JOptionPane.INFORMATION_MESSAGE);
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



