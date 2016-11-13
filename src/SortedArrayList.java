import java.util.ArrayList;

/**
 * Created by Venoth on 11/10/2016.
 */
public class SortedArrayList {

    //makes an array list of Students
    private ArrayList<Student> studentList = new ArrayList<>();

    public SortedArrayList() {
        studentList = new ArrayList<>();
    }


    public ArrayList<Student> quicksort(ArrayList<Student> students) {
        if (students.size() <= 1)
            return students;
        int pivot = students.size() / 2;
        ArrayList<Student> lesser = new ArrayList<Student>();
        ArrayList<Student> greater = new ArrayList<Student>();
        int sameAsPivot = 0;
        for (Student s : students) {
            if (s.compareTo(students.get(pivot)) == 1)
                greater.add(s);
            else if (s.compareTo(students.get(pivot)) == -1)
                lesser.add(s);
            else
                sameAsPivot++;
        }
        lesser = quicksort(lesser);

        for (int i = 0; i < sameAsPivot; i++)
            lesser.add(students.get(pivot));
        greater = quicksort(greater);
        ArrayList<Student> sorted = new ArrayList<Student>();
        for (Student s : lesser)
            sorted.add(s);
        for (Student s : greater)
            sorted.add(s);
        return sorted;
    }

    public String DisplayStudent(Student s) {
        int pos = Find(s);

        return "x";
    }

    // looks for student and returns position, if not found return -1
    public Integer Find(Student s) {
        int pos = 0;
        // traverse thru the list
        while (pos < studentList.size()) {
            if (s.compareTo(studentList.get(pos)) == 0) { // if the same last and first
                return pos;
            }
            pos++;
        }
        //if not found, return -1
        return -1;
    }


    public void add(Student s) {

        if(studentList.size()==0){
            studentList.add(s);
        }else{
            for(int i=0;i<=studentList.size();i++){
                if(s.compareTo(studentList.get(i))<=0){
                    studentList.add(i,s);
                    break;
                }
            }
        }


    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

//public class SortedArrayList(){}


}

