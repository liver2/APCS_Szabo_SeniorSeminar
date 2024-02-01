import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * The main algorithm, which places students into the schedule with the lowest optimization score possible.
 */

/**
* ScheduleOp.java 
* Author: Oliver Szabo
* Date: February 5, 2023, 11:59 PM
* Purpose: The main algorithm, which places students into the schedule with the lowest optimization score possible.
*/
public class ScheduleOp 
{
    int[] counter = new int[18]; // Counts # of sections per Seminar (hence size: 18)

    ArrayList<Student> students = new ArrayList<Student>(); // Encompasses both students who have not been loaded into the Seminar system yet and those who have

    public String search(String str) 
    {
        boolean found1 = false; // Acts as a "toggle" to determine whether to print "Student not found"
        
        for (Student s : students) 
        {
            if (s.getEmail().equals(str)) 
            {
                System.out.println(s.toString());
                found1 = true;
            }
        }

        if (!found1) 
        {
            return "Student not found";
        }

        return "";
    }

    public void importAndPrintData() 
    { 
        ArrayList<String> dataStrings =  new ArrayList<String>();

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

        System.out.println("Seminar ID's & Corresponding Names:");

        for(String s : dataStrings) 
        {
            String[] construction = s.split(","); // Used to "construct" the display of the schedule-ID lookup
            System.out.println("ID " + construction[1] + " --> \"" + construction[0] + "\" with " + construction[2] + " \'" + construction[3]);
        }
    }

    public boolean dupeCheck(Seminar sem, Student stu) 
    {
        for (int i = 0; i < 5; i++) 
        {
            if (sem.getId() == stu.getSeminar(i).getId()) 
            {
                return false;
            }
        }
        return true;
    }

    public int sort(Seminar[][] schedule, Student s, int choice) 
    {
        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++) 
            {
                if (schedule[i][j].getId() == s.getChoices(choice) && !(schedule[i][j].getRosterSize() == 16)) // Conditional to add Student to existing Seminar
                {
                    if (s.getSeminar(i).placeholder()) 
                    {
                        schedule[i][j].setTime(i+1); // Index at 1 (first period is 1, second period is 2, etc).
                        schedule[i][j].addStudent(s);
                        s.addSeminar(schedule[i][j], i); // i refers to row of table, and thus time of day
                        s.setOccupied(schedule[i][j].getTime()-1,schedule[i][j].getTime());
                        return 0; // Later added to optimization score (Student on which this function is working got their choice, so 0 optimization points are added. Lower is better)
                    }
                } 
                else if (s.getSeminar(i).placeholder() && s.getChoices(choice) != 0) // Conditional to create new Seminar
                {   
                    if (s.getSeminar(i).getId() == -1 && !(counter[s.getChoices(choice)-1] == 2)) 
                    {
                        schedule[i][j] = new Seminar(s.getChoices(choice));
                        schedule[i][j].setTime(i+1); // Index at 1 (first period is 1, second period is 2, etc).
                        counter[schedule[i][j].getId()-1]++; // Adds 1 to the counter corresponding to the Seminar ID to which the student was registered
                        schedule[i][j].addStudent(s);
                        s.addSeminar(schedule[i][j], i);// i refers to row of table, and thus time of day
                        return 0; // Later added to optimization score (Student on which this function is working got their choice, so 0 optimization points are added. Lower is better)
                    }
                }
            }
        }
        
        if(s.getChoices(choice) != 0) {
            return (5-choice); // Later added to optimization score (Student on which this function is working did not get their choice, so points are added. Lower is better)
        }

        return 0; // Those whose choices are 0 do not affect the optimization score
    }

    public void fill(Seminar[][] schedule, Student s) 
    {
        for (int i = 0; i < 5; i++) 
        {
            if (s.getSeminar(i).placeholder()) 
            {
                inner: // Loop Label. Source: "Branching Statements", ORACLE Java Documentation
                for (int j = 0; j < 5; j++) 
                {
                    if (schedule[i][j].getRosterSize() < 16 && dupeCheck(schedule[i][j],s)) 
                    {
                        schedule[i][j].addStudent(s);
                        s.addSeminar(schedule[i][j], i); // i refers to index (time of day)
                        s.setOccupied(schedule[i][j].getTime()-1,schedule[i][j].getTime());
                        break inner;                        
                    }
                }
            }
        }
    }

    public int randomize() 
    {
        Seminar[][] schedule = new Seminar[5][5];
        ArrayList<String> data2Strings = new ArrayList<String>(); // Differentiates from dataStrings (lecturers)

        for (int i = 0; i < counter.length; i++) 
        {
            counter[i] = 0; // Initializes counter[] so that other instances of randomize() running do not affect the current instance
        }

        int optimization = 0;

        try 
        {
            File data2 = new File("plaindata.csv");
            Scanner scan = new Scanner(data2);
            scan.nextLine();

            while(scan.hasNextLine()) 
            {
                data2Strings.add(scan.nextLine());
            }

            scan.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("An error occurred.");
        }
        
        for (String s : data2Strings) 
        {
            String[] construction = s.split(",");
            students.add(new Student(
                Integer.parseInt(construction[0]),
                construction[1],construction[2],
                Integer.parseInt(construction[3]),
                Integer.parseInt(construction[4]),
                Integer.parseInt(construction[5]),
                Integer.parseInt(construction[6]),
                Integer.parseInt(construction[7])));
        }

        // Initializes each seminar to a placeholder, or empty slot (-1)
        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++) 
            {
                schedule[i][j] = new Seminar(-1);
            }
        }
        
        // Sorts students into the schedule and calculates the optimization score
        for (int i = 0; i < 5; i++) 
        {
            for (Student s : students) 
            {
                optimization += sort(schedule, s,i);
            }
        }

        // Fills students who did not get their choices into the schedule
        for (Student s : students) 
        {
            fill(schedule, s);
        }

        // Prints the Schedule-ID legend/key
        importAndPrintData();
        
        // Prints student rosters
        for (Student s : students) 
        {
            System.out.println(s + "\n");
        }

        // Prints the "Master Schedule" (what classes are when?)
        System.out.println("");
        System.out.println("Master Schedule");
        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++) 
            {
                System.out.print(schedule[i][j].tempGridDisplay() + " ");
            }

            System.out.println("");
        }

        for (int i = 0; i < 5; i++) 
        {
            for (int j = 0; j < 5; j++) 
            {
                System.out.println(schedule[i][j].toString());
            }
        }

        System.out.println();

        return optimization; // For debugging and optimization purposes
    }
}