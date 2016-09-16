/**
 * Created by Venoth on 9/8/2016.
 */

import java.util.ArrayList;

public class Student implements Comparable<Student> {
    /**
     *
     */
    private String firstName;
    private String lastName;
    private String major;
    private String id;
    private ArrayList<Course> courses;
    private double totalCredits;
    private double gpa;


    @Override
    public int compareTo(Student s) {
        return s.lastName.compareTo(this.lastName);
    }

    /**
     * @param lastName
     * @param firstName
     * @param id
     */
    public Student(String lastName, String firstName, String id) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.id = id;
    }

    public Student() {
    }


    public Student(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }


    @Override
    public String toString() {
        //return lastName + ", " + firstName + ", " + id + "\n" + courses.toString()  + totalCredits + ", " + gpa;
        if (id == null) {
            return lastName + ", " + firstName + "\n";
        } else {
            // go through the ArrayList courses and append it to StringBuilder
            //Use StringBuilder because String is no immutable
            StringBuilder sb = new StringBuilder();
            for (Course c : courses) {
                sb.append(c.toString());
            }
            return lastName + ", " + firstName + ", " + id + "\n" + sb.toString() + totalCredits + ", " + gpa + "\n";
        }
    }

    @Override
    public boolean equals(Object o) {
        return ((Student) o).id.equals(this.id);
    }

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


