/**
 * Created by Venoth Krishnan on 9/8/2016.
 */

public class Course {

    private String courseNumber;
    private double credits;
    private String grade;

    /**
     * Constructor used when Loading data
     * @param courseNumber
     * @param credits
     * @param grade
     */
    public Course(String courseNumber, double credits, String grade) {
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.grade = grade;
    }


    /**
     * reutrns a String in a certain format:
     * course#, Credits, Grade
     * @return
     */
    @Override
    public String toString() {
        return courseNumber + ", " + credits + ", " + grade + "\n";

    }

    /**
     * returns true if the courseNumber is the same
     */
    @Override
    public boolean equals(Object obj) {
        Course c = (Course) obj;
        return c.courseNumber.equals(this.courseNumber);
    }


    /**
     * all the setters and getters
     * @return
     */
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
