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
    private static double totalCredits;
    private double gpa;


    /**
     * This constructor is used when Loading Data from text files
     * Sets lastName, firstName, and id at once
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

    double topSum = 0;
    double totalCredit = 0;

    public double gpaCalcualte() {
        for (Course c : courses) {

            topSum += c.getCredits() * convertLetterGrade(c.getGrade());
            totalCredit += c.getCredits();
        }
        totalCredits = totalCredit;
        return topSum / totalCredit;
    }

    public double convertLetterGrade(String s) {
        double gradeDouble;
        switch (s) {
            case "A+":
                gradeDouble = 4.0;
                break;
            case "A":
                gradeDouble = 4.0;
                break;
            case "A-":
                gradeDouble = 3.7;
                break;
            case "B+":
                gradeDouble = 3.3;
                break;
            case "B":
                gradeDouble = 3.0;
                break;
            case "B-":
                gradeDouble = 2.7;
                break;
            case "C+":
                gradeDouble = 2.3;
                break;
            case "C":
                gradeDouble = 2.0;
                break;
            case "C-":
                gradeDouble = 1.7;
                break;
            case "D+":
                gradeDouble = 1.3;
                break;
            case "D":
                gradeDouble = 1.0;
                break;
            case "D-":
                gradeDouble = 0.7;
                break;
            case "F":
                gradeDouble = 0.0;
                break;
            default:
                gradeDouble = 0;
                break;
        }
        return gradeDouble;

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


