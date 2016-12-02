/**
 * Created by Venoth Krishnan on 9/8/2016.
 * CS 313 Assignment 1
 */

//delete a course for a student
// makesure evrytin prints out to JoptionPane


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class StudentDriver {
    private static final String FILE_NAME = "WarmUpData.txt"; //file name to read in

    //private static ArrayList<Student> studentList = new ArrayList<>();
    //makes an instance of SortedArrayList
    private static SortedArrayList studentList = new SortedArrayList();

    public static void main(String[] args) {

        //JOptionPane.showMessageDialog(null, "Message", "title", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showOptionDialog(null,
                "Do you like this answer?",
                "Feedback",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Yes I do", "No I don't"}, // this is the array
                "default");


        LoadData();
        Calculate();

        Boolean run = true;
        while (run) {
            String[] choices = {"Display the current registration", //choice[0]
                    "Add a Student to the registration",//choice[1]
                    "Search for a student info",//choice[2]
                    "Delete a registered student",//choice[3]
                    "Add a course/grade for a student",//choice[4]
                    "Delete a course for a student ",//choice[5]
                    "Save student list to text file",//choice[6]
                    "Save and Exit"};//choice[7]
            String input = (String) JOptionPane.showInputDialog(null, "What would you like to do?",
                    "Main Menu", JOptionPane.QUESTION_MESSAGE, null,
                    choices, // Array of choices
                    choices[2]); // Initial choice
            if (input == null) break;
            switch (input) {
                case "Display the current registration":
                    Display();
                    break;
                case "Add a Student to the registration":
                    AddStudent();
                    break;
                case "Search for a student info":
                    FindStudent();
                    break;
                case "Delete a registered student":
                    System.out.println(DeleteStudent());
                    break;
                case "Add a course/grade for a student":
                    System.out.println(StudentAddCourse());
                    break;
                case "Delete a course for a student ":
                    break;
                case "Save student list to text file":
                    StoreData();
                    break;
                case "Save and Exit":
                    StoreData();
                    run = false;
                    break;
                default:
                    run = false;
            }
        }


        //LoadData(); // load the data
        //Calculate();
        //AddStudent(); //add students if u want
        //System.out.println(FindStudent());
        //System.out.println(StudentAddCourse());
        //System.out.println(DeleteStudent());
        //Display();
        //StoreData();
        System.out.println("end");
    }

    public static String DeleteStudent() {
        String input = JOptionPane.showInputDialog(null,
                "Enter Student's Name(First and Last Name must be Separated by ONE space)\n(Ex. Venoth Krishnan)):",
                "Removing Student from List", JOptionPane.INFORMATION_MESSAGE);

        if (input != null && input.matches("([a-zA-Z]+)\\s([a-zA-Z]+)")) // gets the correct input
        {
            String[] tempArray = input.split("\\s+");
            //tempArray[1] holds Last Name as a String
            //tempArray[0] holds First Name as a String

            Student tempStudent =
                    new Student(
                            tempArray[1].replace('\n', ' ').trim(),
                            tempArray[0].replace('\n', ' ').trim());

            int pos = studentList.Find(tempStudent);
            if (pos == -1) {
                JOptionPane.showMessageDialog(null,
                        "Student Not Found! \n" +
                                tempArray[1] + ", " + tempArray[0],
                        "Error",
                        JOptionPane.WARNING_MESSAGE);
                return "Student Not Found";
            }
            JOptionPane.showMessageDialog(null,
                    studentList.getStudentList().get(pos).toString(),
                    "Student Removed: " + studentList.getStudentList().get(pos).getFirstName() + " " +
                            studentList.getStudentList().get(pos).getLastName()
                            + " ",
                    JOptionPane.ERROR_MESSAGE);
            studentList.getStudentList().remove(pos);


            return "Student Removed: " + studentList.getStudentList().get(pos).getFirstName() + " " +
                    studentList.getStudentList().get(pos).getLastName()
                    + " ";
        }

        JOptionPane.showMessageDialog(null,
                "Not Correct Format, \n " +
                        "Please enter Last Name and First Name, \n" +
                        "Separated with One whitespace, and only Letters are allowed!",
                "Error",
                JOptionPane.WARNING_MESSAGE);

        return "Not Correct Format, \n " +
                "Please enter Last Name and First Name, \n" +
                "Separated with One whitespace, and only Letters are allowed!";


    }

    //displays fine
    public static void FindStudent() {
        String input = JOptionPane.showInputDialog(null,
                "Enter Student's Name(First and Last Name must be Separated by ONE space)\n(Ex. Venoth Krishnan)):",
                "Adding Student to List", JOptionPane.INFORMATION_MESSAGE);

        if (input != null && input.matches("([a-zA-Z]+)\\s([a-zA-Z]+)")) // gets the correct input
        {
            String[] tempArray = input.split("\\s+");
            //tempArray[1] holds Last Name as a String
            //tempArray[0] holds First Name as a String

            Student tempStudent =
                    new Student(
                            tempArray[1].replace('\n', ' ').trim(),
                            tempArray[0].replace('\n', ' ').trim());

            int pos = studentList.Find(tempStudent);
            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "Student Not Found", "Error",
                        JOptionPane.PLAIN_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null,
                    studentList.getStudentList().get(pos).toString(),
                    "Student Found",
                    JOptionPane.PLAIN_MESSAGE);

        }
        JOptionPane.showMessageDialog(null,
                "Not Correct Format, \n " +
                        "Please enter Last Name and First Name, \n" +
                        "Separated with One whitespace, and only Letters are allowed!",
                "Error: Not Correct Format",
                JOptionPane.PLAIN_MESSAGE);
    }

    //Find Student and Add Course
    public static String StudentAddCourse() {
        String input = JOptionPane.showInputDialog(null,
                "Enter Student's Name(First and Last Name must be Separated by ONE space)\n(Ex. Venoth Krishnan)):",
                "Find Student and Add Course", JOptionPane.INFORMATION_MESSAGE);

        if (input != null && input.matches("([a-zA-Z]+)\\s([a-zA-Z]+)")) // gets the correct input
        {
            String[] tempArray = input.split("\\s+");
            //tempArray[1] holds Last Name as a String
            //tempArray[0] holds First Name as a String

            Student tempStudent =
                    new Student(
                            tempArray[1].replace('\n', ' ').trim(),
                            tempArray[0].replace('\n', ' ').trim());

            int pos = studentList.Find(tempStudent);
            if (pos == -1) { // Student not Found
                return "Student Not Found";
            } else { // Student Found
                //get course info from user
                input = JOptionPane.showInputDialog(null,
                        "Enter The Course number, 2.5, and Grade  \n" +
                                "Each separated with a single whitespace\n" +
                                "(Ex. 4598 3 C+)",
                        "Student Found: " + studentList.getStudentList().get(pos).getFirstName() + "" +
                                studentList.getStudentList().get(pos).getLastName(),
                        JOptionPane.INFORMATION_MESSAGE);
                String[] temp = input.split(" ");
                // temp[0] holds String courseNumber
                // temp[1] holds String credits, will convert to Double from String by parse
                // temp[2] holds String grade, will convert to Uppercase if needed

                Course tempCourse = new Course(temp[0], Double.parseDouble(temp[1]), temp[2].toUpperCase());
                studentList.getStudentList().get(pos).addCourses(tempCourse);
                studentList.getStudentList().get(pos).Calculate(); // to calculate new gpa and total credits
            }

            return studentList.getStudentList().get(pos).toString();
        }
        // if the User did not enter correct format for Name
        return "Not Correct Format, \n " +
                "Please enter Last Name and First Name, \n" +
                "Separated with One whitespace, and only Letters are allowed!";

    }

    // Find Student, and Delete a Course
    public static String StudentDeleteCourse() {

        return "Not Correct Format, \n " +
                "Please enter Last Name and First Name, \n" +
                "Separated with One whitespace, and only Letters are allowed!";

    }


    /**
     * Loads the data from WarmUpData.txt and adds it to studentList
     * does not load the gpa and total credits, for it will be calculated by the Calculate() method
     */
    public static void LoadData() {
        try {
            BufferedReader file = new BufferedReader(
                    new InputStreamReader(new FileInputStream(FILE_NAME)));

            String input = file.readLine();//reads first line
            while (input != null && !input.trim().equals("")) {
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
                    // temp[1] holds Double credits
                    // temp[2] holds String grade

                    // String credits will be converted to Double by using the parse
                    Course tempCourse = new Course(temp[0], Double.parseDouble(temp[1]), temp[2]);
                    courseList.add(tempCourse); // add the current course to courseList
                    input = file.readLine();

                }
                input = file.readLine();//reads the line after -999
                /**
                 * this code can be commented in if Calcualte() method is not used
                 */
                //temp = input.split(",");
                // Set the totalCredits and gpa into tempStudent
                //temp[0] holds the totalCredits as String
                //temp[1] holds the gpa as String

                //parsed the Strings to double for the Credits and Gpa
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

    /**
     * Calculates the gpa and totalCredits for each student in studentList
     */
    public static void Calculate() {
        //Calculate gpa and totalCredits for all students in studentList
        for (Student s : studentList.getStudentList()) {
            s.Calculate();
        }
    }


    /**
     * prints studentList in the format given in the assignment
     */
    //done
    public static void Display() {
        StringBuilder roster = new StringBuilder();
        for (Student student : studentList.getStudentList()) {
            roster.append(student.toString());
        }
        JOptionPane.showMessageDialog(null, roster, "Student Roster", JOptionPane.PLAIN_MESSAGE);

    }

    /**
     * Adds a Student using JOption Pane, Only First and Last Name
     * User must separate First and Last name with a Space!
     * Will check to make sure if the user entered the name in the correct format.
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

                if (!input.matches("([a-zA-Z]+)\\s([a-zA-Z]+)")) {//checks if user did not enter name in correct format
                    JOptionPane.showMessageDialog(null,
                            "Please Enter a Valid Name(ex. John Smith) \n Must contain only letters and a space!",
                            "Input Error!",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String[] tempArray = input.split("\\s+");

                    //tempArray[1] holds Last Name as a String
                    //tempArray[0] holds First Name as a String

                    Student tempStudent = new Student(tempArray[1], tempArray[0]);
                    studentList.add(tempStudent);//adds current tempStudent to studentList

                    result = JOptionPane.showConfirmDialog(null,
                            "Would you like to add another Student", "Add Students", JOptionPane.YES_NO_OPTION);
                }

            } else break;
        }
    }

    /**
     * Creates a new text file called WarmUpDataOutput.txt
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

            for (Student s : studentList.getStudentList()) {
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
