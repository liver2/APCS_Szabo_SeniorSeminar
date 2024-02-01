import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Seminar 
{
    private String name;
    private int id;
    private int timeOfDay;
    private ArrayList<Student> students = new ArrayList<Student>();

    public Seminar(int i) 
    {
        ArrayList<String> dataStrings =  new ArrayList<String>(); // Used to import and sort data, matching int i to correct ID and name

        id = i;
        timeOfDay = 0;
        
        // Source: "File I/O", W3 Schools
        try 
        { 
            File data = new File("lecturerData.csv");
            Scanner scan = new Scanner(data);
            scan.nextLine();

            while(scan.hasNextLine()) 
            {
                dataStrings.add(scan.nextLine());
            }
            
            scan.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Lecturer data file reading error"); // Did not work on Mac due to Linux error (?)
        }

        for(String s : dataStrings) 
        {
            String[] construction = s.split(",");

            if (Integer.parseInt(construction[1]) == id) 
            {
                name = construction[0];
            }
        }
    }

    public int getId() 
    {
        return id;
    }

    public int getTime() 
    {
        return timeOfDay;
    }

    public int getRosterSize() 
    {
        return students.size();
    }

    public void setTime(int i) 
    {
        timeOfDay = i;
    }

    public void addStudent(Student s) 
    {
        students.add(s);
    }

    public boolean placeholder() 
    {
        if (id == -1) return true;
        return false;
    }

    public String tempGridDisplay() 
    {
        String r = "";
        r += " " + id;
        return r;
    }

    public String toString() 
    {
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
