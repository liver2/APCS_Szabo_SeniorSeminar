import java.util.ArrayList;

public class Seminar {
    private String name;
    private int id;
    private int section;
    private Alum alumne;
    private ArrayList<Student> students;

    // create seminar constructor based on id
    public Seminar(int i) {

    }

    // create method to compare seminars to placeholder seminars to figure out if a seminar can be placed in a blank spot
    public boolean placeholder() {
        if (id == 0) return true;
        return false;
    }

    public int getId() {
        return id;
    }
}
