import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class StudentDriver {
    static String fileName = "313data.txt";
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {


        LoadData();
        AddStudent();
        Display();



    }

    public static void LoadData() {




        try {
            BufferedReader file = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName)));

            String input = file.readLine();
            while (input != null) {
                //System.out.println();
                String[] temp = input.split(",");
                //temp[0] holds String Last Name
                //temp[1] holds String First name
                //temp[2] holds String id
                Student tempStudent = new Student(temp[0], temp[1], temp[2]); //read first line into Student

                // create a ArrayList called courseList of object Course
                ArrayList<Course> courseList = new ArrayList<>();

                input = file.readLine();


                while (!input.equals("-999")) {
                    temp = input.split(",");
                    // temp[0] holds String courseNumber
                    // temp[1] holds double credits
                    // temp[2] holds String grade
                    Course tempCourse = new Course(temp[0], Double.parseDouble(temp[1]), temp[2]);
                    courseList.add(tempCourse); // add to the list of courses
                    input = file.readLine();

                }
                input = file.readLine();

                temp = input.split(",");
                // Set the totalCredits and gpa into tempStudent
                // tempStudent = new Student(Double.parseDouble(temp[0]),Double.parseDouble(temp[1]));// also doesnt work, sets gpa but not names
                //tempStudent(Double.parseDouble(temp[0]),Double.parseDouble(temp[1])); // WHY CANT I DO THIS
                tempStudent.setTotalCredits(Double.parseDouble(temp[0]));
                tempStudent.setGpa(Double.parseDouble(temp[1]));

                // adds the current courseList to the current tempStudent
                tempStudent.setCourses(courseList);
                // adds the current Student object to Student arraylist
                studentList.add(tempStudent);
                input = file.readLine();

            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        }



     public static void Display() {
         for (Student s : studentList){
             System.out.println(s);}
     }



     public static void AddStudent(){
         int result= JOptionPane.showConfirmDialog(null,
                 "Would you like to add a Student","Students", JOptionPane.YES_NO_OPTION);
         //if they Click yes
         while(result == 0){
             String input = JOptionPane.showInputDialog(null,
                     "Enter Students Name", "Adding Student", JOptionPane.INFORMATION_MESSAGE);
             Student tempStudent = new Student();
             tempStudent.setFirstName(input);
             studentList.add(tempStudent);
         }
     }


}
