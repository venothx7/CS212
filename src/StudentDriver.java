/**
 * Created by Venoth Krishnan on 9/8/2016.
 *CS 313 Assignment 1.1
 */

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class StudentDriver {
    private static final String FILE_NAME = "WarmUpData.txt "; //file name to read in
    private static ArrayList<Student> studentList;


    public static void main(String[] args) {
        LoadData();
        AddStudent();
        Calculate();
        Display();
        StoreData();
    }



    /**
     * Loads the data from 313data.txt and adds it to studentList
     * does not load the gpa and total credits,it will be calculated by the Calculate() method
     */
    public static void LoadData() {
        studentList = new ArrayList<>();


        try {
            BufferedReader file = new BufferedReader(
                    new InputStreamReader(new FileInputStream(FILE_NAME)));

            String input = file.readLine();//reads first line
            while (input != null) {
                //create courseList for current student
                ArrayList<Course> courseList = new ArrayList<>();

                String[] temp = input.split(",");
                //temp[0] holds String Last Name
                //temp[1] holds String First name
                //temp[2] holds String id

                //pass in the lastName, firstName, id to current student
                Student tempStudent = new Student(temp[0], temp[1], temp[2]);

                input = file.readLine();//reads line after Names, which are courses

                //loops until input is -999 is read
                while (!input.equals("-999")) {

                    temp = input.split(",");
                    // temp[0] holds String courseNumber
                    // temp[1] holds String credits
                    // temp[2] holds String grade

                    // String credits will be converted to Double by using the parse method
                    Course tempCourse = new Course(temp[0], Double.parseDouble(temp[1]), temp[2]);
                    courseList.add(tempCourse); // add the current course to courseList
                    input = file.readLine();

                }
                input = file.readLine();//reads the line after -999
                /**
                 * this part can be commented in to read in the gpa and totalCredits directly from the text file
                 * and not calculated by Calculate().
                 */
                //temp = input.split(",");

                // Set the totalCredits and gpa into tempStudent
                //temp[0] holds the totalCredits as String
                //temp[1] holds the gpa as String

                //tempStudent.setTotalCredits(Double.parseDouble(temp[0]));
                //tempStudent.setGpa(Double.parseDouble(temp[1]));


                // adds the current courseList to the current tempStudent
                tempStudent.setCoursesList(courseList);
                // adds the current Student to studentList
                studentList.add(tempStudent);
                input = file.readLine();//reads nxt line for outer while loop

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void Calculate() {
        //Calculate gpa and totalCredits for all students in studentList
        for (Student student : studentList) {
            student.Calculate();
        }
    }

    /**
     * prints studentList in the format given in the assignment
     */
    public static void Display() {
        for (Student student : studentList) {
            System.out.print(student.toString());
        }

    }

    /**
     * Adds a Student using JOption Pane, Only First and Last Name
     * User must separate First and Last name with a Space!
     */
    public static void AddStudent() {

        int result = JOptionPane.showConfirmDialog(null,
                "Would you like to add a Student", "Add Students", JOptionPane.YES_NO_OPTION);

        //While loop keeps going until the user Presses No(result =1)
        while (result == 0) {
            String input = JOptionPane.showInputDialog(null,
                    "Enter Student's Name(First and Last Name must be Separated by ONE space)\n(Ex. Venoth Krishnan)):",
                    "Adding Student to List", JOptionPane.INFORMATION_MESSAGE);
            if (input != null) {// If user presses Cancel, will break out of loop
                String[] tempArray = input.split(" ");
                //tempArray[1] holds Last Name as a String
                //tempArray[0] holds First Name as a String

                Student tempStudent = new Student(tempArray[1], tempArray[0]);
                studentList.add(tempStudent);//adds current tempStudent to studentList

                result = JOptionPane.showConfirmDialog(null,
                        "Would you like to add another Student", "Add Students", JOptionPane.YES_NO_OPTION);
            } else break;
        }
    }

    /**
     * Creates a new text file called WarmUpDataOutput.txt i
     * if there exists a file already, it will replace it!
     * the file will contain all the students information in studentList
     */
    public static void StoreData() {

        BufferedWriter bw = null;

        try {

            File file = new File("WarmUpDataOutput.txt");
            // check if file exist, otherwise create the file before writing
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (Student s : studentList) {
                bw.write(s.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the BufferedWriter" + ex);
            }
        }
    }
}
