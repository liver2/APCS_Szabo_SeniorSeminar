import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Seminar {
    private String name;
    private int id;
    private int timeOfDay;
    private ArrayList<Student> students = new ArrayList<Student>();

    // create seminar constructor based on id
    public Seminar(int i) {
        ArrayList<String> dataStrings =  new ArrayList<String>();

        id = i;
        timeOfDay = 0;
        
        try {
            File data = new File("lecturerData.csv");
            Scanner scan = new Scanner(data);
            scan.nextLine();
            while(scan.hasNextLine()) {
                dataStrings.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lecturer data file reading error");
        }

        for(String s : dataStrings) {
            String[] construction = s.split(",");
            if (Integer.parseInt(construction[1]) == id) {
                name = construction[0];
            }
        }
        
        
        
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
        r += id + "|" + students.size() + " ";
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
        r += "Seminar Name: " + name + "\n";
        r += "Seminar Block #: " + timeOfDay + "\n\n";
        r += "Student Names:\n";
        for (Student s : students) {
            r += s.getName() + "\n";
        }
        System.out.println();
        return r;
    }
}
