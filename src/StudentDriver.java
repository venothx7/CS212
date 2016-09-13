import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class StudentDriver {
    static String fileName = "313data.txt";


    public static void main(String[] args) {

        LoadData();
    }

    public static void LoadData() {
        ArrayList<Student> studentList = new ArrayList<>();


        try {
            BufferedReader file = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName)));

            String input = file.readLine();
            while (input != null) {
                System.out.println();
                String[] temp = input.split(",");
                Student tempStudent = new Student(temp[0], temp[1], temp[2]); //read first line into Student

                ArrayList<Course> courseList = new ArrayList<>();

                input = file.readLine();
                while (!input.equals("-999")) {

                    temp = input.split(",");
                    Course tempCourse = new Course(temp[0], Double.parseDouble(temp[1]), temp[2]);
                    courseList.add(tempCourse);
                    input = file.readLine();

                }
                input = file.readLine();
                temp = input.split(",");
                tempStudent.setTotalCredits(Double.parseDouble(temp[0]));
                tempStudent.setGpa(Double.parseDouble(temp[1]));
                tempStudent.setCourses(courseList);
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


    }


}
