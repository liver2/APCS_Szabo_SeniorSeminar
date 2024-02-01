/*
 * A class to store data about students, their identifying information, their Seminar choices, and
 * those in which they are actually enrolled. Used heavily in the ScheduleOp class to optimize the schedule.
 */

/**
* Student.java 
* Author: Oliver Szabo
* Date: February 5, 2023, 11:59 PM
* Purpose: A class to store data about students, their identifying information, their Seminar choices, and
* those in which they are actually enrolled. Used heavily in the ScheduleOp class to optimize the schedule.
*/
public class Student 
{
    private String name;
    private String email;
    private int order; 
    // Although not used currently, the "order" was used as an ID number in a previous version of this program,
    // which continuously randomized the order of importing students into the schedule.
    // This program aimed to find the optimal schedule for these students' choices. After ~12 hours of testing 3000 randomizations/second (1.296e8 randomizations),
    // The program found the current schedule. With more testing, an even more optimal schedule is likely possible. More info in ScheduleOp.
    private int[] idChoices = new int[5];
    private Seminar[] seminars = new Seminar[5];
    private int[] occupied = new int[5]; // Keeps track of when a student's schedule is filled by a Seminar: Used in the "randomize" placing algorithm.

    /*
     * Constructor for the Student class.
     * Returns: new Student (creates a new Student)
     * Arguments: int o,String e,String n,int c1,int c2,int c3,int c4,int c5 (Shorthand for future variable values.)
     */
    public Student(int o,String e,String n,int c1,int c2,int c3,int c4,int c5) 
    {
        name = n;
        email = e;
        order = o;
        idChoices[0] = c1;
        idChoices[1] = c2;
        idChoices[2] = c3;
        idChoices[3] = c4;
        idChoices[4] = c5;

        for (int i = 0; i < 5; i++) 
        {
            occupied[i] = 0; 
        }

        for (int i = 0; i < 5; i++) 
        {
            seminars[i] = new Seminar(-1); // -1 => placeholder. 
            // Originally the placeholder ID was zero, but the program matched those who had no choices (ID: 0) to sessions with ID 0, so a new placeholder had to be made.
        }
    }

    /*
     * Simple getter for an array's element.
     * Returns: int idChoices[i]
     * Arguments: int i (index)
     */
    public int getChoices(int i) 
    {
        return idChoices[i];
    }

    /*
     * Simple getter.
     * Returns: int order
     * Arguments: None
     */
    public int getOrder() 
    {
        return order;
    }

    /*
     * Simple getter for an array's element.
     * Returns: int seminars[i]
     * Arguments: int i (index)
     */
    public Seminar getSeminar(int i) 
    {
        return seminars[i];
    }

    /*
     * Simple getter for an array.
     * Returns: int[] occupied
     * Arguments: None
     */
    public int[] getOccupied() 
    {
        return occupied;
    }

    /*
     * Simple getter.
     * Returns: String name
     * Arguments: None
     */
    public String getName() 
    {
        return name;
    }

    /*
     * Simple getter.
     * Returns: String email
     * Arguments: None
     */
    public String getEmail() 
    {
        return email;
    }

    /*
     * Simple setter for an array. Admittedly poorly named.
     * Returns: void
     * Arguments: Seminar s, int i (adds a new Seminar s to the seminars[] array at index i)
     */
    public void addSeminar(Seminar s, int i) 
    {
        seminars[i] = s;
    }

    /*
     * Simple setter for an array.
     * Returns: void
     * Arguments: int index, int value (sets occupied[index] to value.)
     */
    public void setOccupied(int index, int value) 
    {
        occupied[index] = value;
    }

    /*
     * toString method which displays the Student's name, email, and seminars.
     * Returns: String r (for use with System.out.print-type functions)
     * Arguments: none
     */
    public String toString() 
    {
        String r = "";
        r += "\nName: " + name + "\n";
        r += "Email: " + email + "\n";
        r += "Seminars: " + seminars[0].tempGridDisplay() + "," + 
                            seminars[1].tempGridDisplay() + "," + 
                            seminars[2].tempGridDisplay() + "," + 
                            seminars[3].tempGridDisplay() + "," + 
                            seminars[4].tempGridDisplay() + "";
        return r;
    }
}
