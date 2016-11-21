/**
 * Created by Venoth Krishnan on 9/8/2016.
 */

import java.util.ArrayList;

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private String major;
    private String id;
    private ArrayList<Course> coursesList;
    private double totalCredits;
    private double gpa;

    /**
     * This constructor is used when Loading Data from text files
     * Sets lastName, firstName, and id at once
     *
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
     * This constructor is used when Adding Students
     * sets lastName and firstName at once
     *
     * @param lastName
     * @param firstName
     */
    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Boolean Contains(String lastName, String firstName) {

        return false;
    }

    /**
     * Calculates the gpa and total credits for student
     *
     * @return
     */
    public void Calculate() {
        gpa = 0;
        totalCredits = 0;
        if (coursesList != null) { //checks if the student has courses added
            double topSum = 0;
            for (Course c : coursesList) {

                topSum += c.getCredits() * convertLetterGrade(c.getGrade());
                totalCredits += c.getCredits(); // will add all the credits
            }

            gpa = (double) Math.round(topSum / totalCredits * 1000) / 1000; //rounds the result to 3 places
        }
    }

    public double convertLetterGrade(String s) {

        switch (s) {
            case "A+":
            case "A":
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D":
                return 1.0;
            case "D-":
                return 0.7;
            case "F":
                return 0.0;
            default:
                return 0;
        }

    }

    /**
     * returns string in a format:
     * lastName, firstName, id#
     * course1
     * course2
     * etc
     * totalCredits, GPA
     *
     * @return
     */
    @Override
    public String toString() {

        if (coursesList == null) {
            return lastName + ", " + firstName + "\n";
        } else {
            // go through the ArrayList coursesList and append it to StringBuilder
            StringBuilder sb = new StringBuilder();
            for (Course c : coursesList) {
                sb.append(c.toString());
            }
            return lastName + ", " + firstName + ", " + id + "\n" + sb.toString() + totalCredits + ", " + gpa + "\n";
        }
    }

    /**
     * equality test based on id#
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        return ((Student) o).id.equals(this.id);
    }

    /**
     * Comparison based on lastName
     *
     * @param s
     * @return
     */
    @Override
    public int compareTo(Student s) {
        if (s.lastName.equalsIgnoreCase(this.lastName)) {
            return s.firstName.compareToIgnoreCase(this.firstName);
        }
        return s.lastName.compareToIgnoreCase(this.lastName);
    }

    /**
     * All the setters and getters
     *
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

    public ArrayList<Course> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(ArrayList<Course> coursesList) {
        this.coursesList = coursesList;
    }


    public void addCourses(Course course)
    {
        if (this.coursesList == null){
            this.coursesList = new ArrayList<>();
        }
        this.coursesList.add(course);
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


