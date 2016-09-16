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
    private static final String FILE_NAME = "313data.txt";
    private static ArrayList<Student> studentList;


    public static void main(String[] args) {


        LoadData();
        AddStudent();
        //Display(studentList);
        StoreData();

    }


    /**
     * Loads the data from 313data.txt and adds it to studentList
     */
    public static void LoadData() {
        // create a ArrayList called courseList of object Course
        studentList = new ArrayList<>();
        ArrayList<Course> courseList = new ArrayList<>();

        try {
            BufferedReader file = new BufferedReader(
                    new InputStreamReader(new FileInputStream(FILE_NAME)));

            String input = file.readLine();
            while (input != null) {
                String[] temp = input.split(",");
                //temp[0] holds String Last Name
                //temp[1] holds String First name
                //temp[2] holds String id
                Student tempStudent = new Student(temp[0], temp[1], temp[2]);

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
                tempStudent.setTotalCredits(Double.parseDouble(temp[0]));
                tempStudent.setGpa(Double.parseDouble(temp[1]));

                // adds the current courseList to the current tempStudent
                tempStudent.setCourses(courseList);
                // adds the current Student to studentList
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


    public static void Display(ArrayList studentList) {

        for (Object o : studentList) {
            System.out.print(o.toString());
        }

    }


    public static void AddStudent() {
        int result = JOptionPane.showConfirmDialog(null,
                "Would you like to add a Student", "Add Students", JOptionPane.YES_NO_OPTION);
        //if they Click yes
        while (result == 0) {
            String input = JOptionPane.showInputDialog(null,
                    "Enter Students Name(First Last, seperated with a space):",
                    "Adding Student", JOptionPane.INFORMATION_MESSAGE);
            String[] tempArray = input.split(" ");
            Student tempStudent = new Student(tempArray[0], tempArray[1]);
            studentList.add(tempStudent);
            result = JOptionPane.showConfirmDialog(null,
                    "Would you like to add another Student", "Add Students", JOptionPane.YES_NO_OPTION);
        }
    }

    public static void StoreData() {

        BufferedWriter bw = null;

        try {
            String strContent = "This example shows how to write string content to a files";
            File file = new File("tester.txt");
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
