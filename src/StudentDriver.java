import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class StudentDriver {
    static String fileName = "313data.txt";
    static ArrayList<Course> courseList= new ArrayList<>();
    static ArrayList<Student> studentList= new ArrayList<>();
    public static void main(String[] args) {
        double d;


        try {
            BufferedReader file = new BufferedReader (
                    new InputStreamReader( new FileInputStream(fileName)));

            try {
                String input = file.readLine();
                while (input != null ){
                    String [] temp = input.split(",");
                    Student tempStudent = new Student(temp[0],temp[1],temp[2]); //read first line into Student
                    studentList.add(tempStudent);
                    input = file.readLine();

                    // read courses into Course
                    while(input!="-999") {
                        d = Double.parseDouble(temp[1]);
                        Course tempCourse = new Course(temp[0], d, temp[2]);
                        courseList.add(tempCourse);
                        input = file.readLine();
                    }

                }
                int counter = 0;
                while (counter < courseList.size()){
                    System.out.println(courseList.get(counter).toString());
                    counter++;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int counter = 0;
        while (counter < courseList.size()){
            System.out.println(courseList.get(counter).toString());
            counter++;
        }

    }



}
