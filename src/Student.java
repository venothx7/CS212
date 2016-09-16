/**
 * Created by Venoth Krishnan on 9/8/2016.
 */

import java.util.ArrayList;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private String major;
    private String id;
    private ArrayList<Course> courses;
    private double totalCredits;
    private double gpa;


    /**
     * This constructor is used when Loading Data from text files
     * Sets tlastName, firstName, and id at once
     * @param lastName
     * @param firstName
     * @param id
     */
    public Student(String lastName, String firstName, String id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    /**
     * This constructor us used when Adding Students
     * sets lastName and firstName at once
     * @param lastName
     * @param firstName
     */
    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    /**
     * returns string in a certain format:
     * lastName, firstName, id#
     * course1
     * course2
     * etc
     * totalCredits, GPA
     * @return
     */
    @Override
    public String toString() {

        if (id == null) {
            return lastName + ", " + firstName + "\n";
        } else {
            // go through the ArrayList courses and append it to StringBuilder
            //Used StringBuilder to save memory space
            // used it this way to get rid of the brackets and extra commas when printed as arraylist
            StringBuilder sb = new StringBuilder();
            for (Course c : courses) {
                sb.append(c.toString());
            }
            return lastName + ", " + firstName + ", " + id + "\n" + sb.toString() + totalCredits + ", " + gpa + "\n";
        }
    }

    /**
     * equality test based on id#
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        return ((Student) o).id.equals(this.id);
    }

    /**
     * Comparison based on lastName
     * @param s
     * @return
     */
    @Override
    public int compareTo(Student s) {
        return s.lastName.compareTo(this.lastName);
    }

    /**
     * all the setters and getters
     * most are not used because of the constructors at top,
     * but they are here in case needed later in the semester
     * @return
     */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(double totalCredits) {
        this.totalCredits = totalCredits;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}


