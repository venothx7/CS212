import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Created by Venoth on 9/9/2016.
 */

public class DummyTest0 {

    //Create a new instance of sorted array list
    private static SortedArrayList studentListing = new SortedArrayList();

    public static void main(String[] args) {
        Boolean run=true;
        while(run) {
            String[] selectionValues = {"LoadData/Calculate",
                    "Add Student", "Display", "Store Data", "Exit/Display/Store Data"};
            String initialSelection = "LoadData/Caclculate";
            Object selection = JOptionPane.showInputDialog(null, "What will you like to do?",
                    "Main Menu", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
            System.out.println(selection.toString());

            if (selection.toString()=="Exit"){
                break;
            }
        }


        //Trying to sort by last name

        //Create a instance of Student
        //Student (last, first,ID)
        //Student tempStudent0 = new Student("zrs", "Ve", "123456");
        //Student tempStudent1 = new Student("crs", "Ve", "123456");
        //Student tempStudent2 = new Student("ars", "Ve", "123456");

        //studentListing.add(tempStudent0);
        //studentListing.add(tempStudent1);
        //studentListing.add(tempStudent2);
       // System.out.println(studentListing.getStudentList().size());
       // int size = studentListing.getStudentList().size();



        // display
       // for (Student student : studentListing.getStudentList()) {
       //     System.out.print(student.toString());
        //}


    }
}
