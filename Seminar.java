import java.util.ArrayList;

public class Seminar {
    private String name;
    private int id;
    private int section;
    private Alum alumne;
    private ArrayList<Student> students = new ArrayList<Student>();

    // create seminar constructor based on id
    public Seminar(int i) {
        id = i;

        // later: determine name, section, alumnus, etc. based on data
    }

    // create method to compare seminars to placeholder seminars to figure out if a seminar can be placed in a blank spot
    public boolean placeholder() {
        if (id == 0) return true;
        return false;
    }

    public int getId() {
        return id;
    }

    public void addStudent(Student s) {
        students.add(s);
    }
    
    public int getRosterSize() {
        return students.size();
    }

    public String toString() {
        String r = "";
        r += "ID: " + id + "\n";
        r += "# of students: " + students.size();
        return r;
    }
}
