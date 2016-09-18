/**
 * Created by Venoth Krishnan on 9/8/2016.
 */

public class Course {

    private String courseNumber;
    private double credits;
    private String grade;

    /**
     * Constructor used when Loading data
     *
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
     *
     * @return
     */
    @Override
    public String toString() {
        return courseNumber + ", " + credits + ", " + grade + "\n";

    }

    /**
     * all class and objests inherits from the objects class
     * all the child classes that inherit that ojbect class can overide, meaning they can change the implementation,
     * meaning "You Can Change What it Does" if you dont like what the default object class does
     */
    @Override
    public boolean equals(Object obj) {
        Course c = (Course) obj;
        return c.courseNumber.equals(this.courseNumber);
    }


    /**
     * all the setters and getters
     * none of them are used now, but they are here in case needed later
     *
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
