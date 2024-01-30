import java.util.ArrayList;

public class Seminar {
    private String name;
    private int id;
    private int section;
    private Alum alumne;
    private int timeOfDay;
    private ArrayList<Student> students = new ArrayList<Student>();

    // create seminar constructor based on id
    public Seminar(int i) {
        id = i;
        timeOfDay = 0;
        // later: determine name, section, alumnus, etc. based on data
    }

    // create method to compare seminars to placeholder seminars to figure out if a seminar can be placed in a blank spot
    public boolean placeholder() {
        if (id == -1) return true;
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

    public String tempGridDisplay() {
        String r = "";
        r += id + "";
        return r;
    }

    public void setTime(int i) {
        timeOfDay = i;
    }

    public int getTime() {
        return timeOfDay;
    }

    public String toString() {
        String r = "";
        r += "Seminar ID: " + id + "\n";
        r += "Seminar Block #: " + timeOfDay + "\n\n";
        r += "Student Names:\n";
        for (Student s : students) {
            r += s.getName() + "\n";
        }
        System.out.println();
        return r;
    }
}
