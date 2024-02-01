import java.util.Scanner;

/*
 * Contains the main method, a disclaimer for students who did not fill out the form, 
 * initializes a ScheduleOp object which runs the optimization, and operates the search module.
 */

/**
* Main.java 
* Author: Oliver Szabo
* Date: February 5, 2023, 11:59 PM
* Purpose: Contains the main method, a disclaimer for students who did not fill out the form, 
* initializes a ScheduleOp object which runs the optimization, and operates the search module.
*/
public class Main 
{
    /*
     * Main method, which houses the search module and a ScheduleOp object.
     * Returns: void
     * Arguments: String[] args
     */
    public static void main(String[] args) 
    {
        System.out.println("For students who did not fill out the form, a Seminar ID of \"-1\" indicates we were unable to place the student in a Seminar."); 
        // Challenge: The best sorting algorithm did not allow students who did not fill out the form to be placed into the schedule without duplicate sessions. 
        // This is a fitting punishment for the students who did not follow directions.

        ScheduleOp scheduleOp = new ScheduleOp();
        Scanner userInput = new Scanner(System.in);
        scheduleOp.randomize();
        while (true) // Infinite loop, so that those who wish to search can search as many times as they want
        {
            System.out.println("-----"); // Divider Line
            System.out.print("Search a student by email22: ");
            String email = userInput.nextLine();
            System.out.println(scheduleOp.search(email)); // Searches according to email22
        } 
    }
}