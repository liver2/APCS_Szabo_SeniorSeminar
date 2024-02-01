import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * A class that initializes and matches Seminars to the Seminar-ID key found in lecturerData.csv and stores rosters of Student objects.
 */

/**
* Seminar.java 
* Author: Oliver Szabo
* Date: February 5, 2023, 11:59 PM
* Purpose: A class that initializes and matches Seminars to the Seminar-ID key found in lecturerData.csv and stores rosters of Student objects.
*/
public class Seminar 
{
    private String name;
    private int id;
    private int timeOfDay;
    private ArrayList<Student> students = new ArrayList<Student>();

    /*
     * Constructor for the Seminar class, which initializes name according to a single argument.
     * Returns: new Seminar (creates a new Seminar)
     * Arguments: int i (Shorthand for ID of new Seminar.)
     */
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

    /*
     * Simple getter.
     * Returns: int id
     * Arguments: None
     */
    public int getId() 
    {
        return id;
    }

    /*
     * Simple getter.
     * Returns: int timeOfDay
     * Arguments: None
     */
    public int getTime() 
    {
        return timeOfDay;
    }

    /*
     * Simple getter for the ArrayList students's size.
     * Returns: int students.size()
     * Arguments: None
     */
    public int getRosterSize() 
    {
        return students.size();
    }

    /*
     * Simple setter for the Seminar's time.
     * Returns: void
     * Arguments: int i (value)
     */
    public void setTime(int i) 
    {
        timeOfDay = i;
    }

    /*
     * Simple setter to add a student to the ArrayList.
     * Returns: void
     * Arguments: Student s (new student which is to be added)
     */
    public void addStudent(Student s) 
    {
        students.add(s);
    }

    /*
     * Determines whether the Seminar object is acting as a placeholder.
     * Returns: boolean
     * Arguments: None
     */
    public boolean placeholder() 
    {
        if (id == -1) return true;
        return false;
    }

    /*
     * A String method for use in the Master Schedule and Student Schedules.
     * Returns: String form of id
     * Arguments: None
     */
    public String tempGridDisplay() 
    {
        String r = "";
        r += " " + id;
        return r;
    }

    /*
     * A String method for use in the Seminar rosters.
     * Returns: String
     * Arguments: None
     */
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
