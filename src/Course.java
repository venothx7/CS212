/**
 * Created by Venoth on 9/8/2016.
 */
public class Course {
    String courseNumber;
    double credits;
    String grade;

    public Course(String courseNumber, double credits, String grade) {
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.grade = grade;

    }

    @Override
    public String toString() {
        return courseNumber + ", " + credits + ", " + grade+ "\n";

    }

    @Override
    public boolean equals(Object obj) {
        Course c = (Course) obj; // type casting
        return c.courseNumber.equals(this.courseNumber);

    }



    // The Setters and Getters
    public String getCourseNumber() {
        return courseNumber;
    }
    public double getCredits() {
        return credits;
    }
    public void setCredits(double credits) {
        this.credits = credits;
    }
    public String getGrade() {
        return grade;
    }
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }






}
