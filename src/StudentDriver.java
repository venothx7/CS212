/**
 * Created by Venoth Krishnan on 9/8/2016.
 * This program is able to read in a text file of students with there
 * FirstName, LastName, Id#, Courses taking, total credits taking, and GPA.
 * It will then add each student to a Student List
 * It will aslo
 *
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
    private static final String FILE_NAME = "WarmUpData.txt ";
    private static ArrayList<Student> studentList;


    public static void main(String[] args) {
        LoadData();
        //Calculate();
        AddStudent();
        Display(studentList);
        StoreData();
    }

    public static void Calculate() {
        for (Student student : studentList) {
            student.setGpa(student.gpaCalcualte());
        }

    }

    /**
     * Loads the data from 313data.txt and adds it to studentList
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

                input = file.readLine();//reads line after name, which is courses

                //loops until input is -999
                while (!input.equals("-999")) {

                    temp = input.split(",");
                    // temp[0] holds String courseNumber
                    // temp[1] holds double credits
                    // temp[2] holds String grade

                    Course tempCourse = new Course(temp[0], Double.parseDouble(temp[1]), temp[2]);
                    courseList.add(tempCourse); // add the current course to courseList
                    input = file.readLine();//reads the nxt line for the inner while loop

                }
                input = file.readLine();//reads the line after -999,which is credits and gpa

                temp = input.split(",");
                // Set the totalCredits and gpa into tempStudent
                //temp[0] holds the totalCredits as String
                //temp[1] holds the gpa as String

                //parsed the Strings to double for the Credits and Gpa
                tempStudent.setTotalCredits(Double.parseDouble(temp[0]));
                tempStudent.setGpa(Double.parseDouble(temp[1]));
                //tempStudent.setTotalCredits(0);
                //tempStudent.setGpa(0);

                // adds the current courseList to the current tempStudent
                tempStudent.setCourses(courseList);
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

    /**
     * prints studentList in the format given in the assignment
     * @param studentList
     */
    public static void Display(ArrayList studentList) {
        //goes through the list and prints the values in the format given
        for (Object o : studentList) {
            System.out.print(o.toString());
        }

    }

    /**
     * adds a Student by using JOption Pane
     */
    public static void AddStudent() {
        int result = JOptionPane.showConfirmDialog(null,
                "Would you like to add a Student", "Add Students", JOptionPane.YES_NO_OPTION);
        //loop keeps going until the user Presses no
        while (result == 0) {
            String input = JOptionPane.showInputDialog(null,
                    "Enter Student's Name(First and Last Name must be Separated by ONE space)\n(Ex. Venoth Krishnan)):",
                    "Adding Student to List", JOptionPane.INFORMATION_MESSAGE);
            String[] tempArray = input.split(" ");
            //tempArray[1] holds Last Name as String
            //tempArray[0] holds First Name as String

            Student tempStudent = new Student(tempArray[1], tempArray[0]);
            studentList.add(tempStudent);//adds current tempStudent to studentList
            result = JOptionPane.showConfirmDialog(null,
                    "Would you like to add another Student", "Add Students", JOptionPane.YES_NO_OPTION);
        }
    }

    /**
     * Creates a new text file in the same directory as this java file
     * if there exists a file already, it will replace it!
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
            for (Object o : studentList) {
                bw.write(o.toString());
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
