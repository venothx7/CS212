/**
 * Created by Venoth on 9/8/2016.
 */

import java.util.ArrayList;

public class Student implements Comparable<Student> {
    String firstName;
    String lastName;
    String major;
    String id;
    ArrayList<Course> courses;
    double totalCredits;
    double gpa;

    public Student(String lastName, String firstName,String id) {
        this.lastName=lastName;
        this.firstName=firstName;
        this.id=id;
    }

    @Override
    public int compareTo(Student s) {
        return s.lastName.compareTo(this.lastName);
    }

    @Override
    public String toString() {
        return lastName +", "+ firstName +", "+ major
                +", "+ id +", "+  courses
                +", "+  totalCredits +", "+ gpa;
    }

    @Override
    public boolean equals(Object o) {
        return ((Student)o).id.equals(this.id);
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


