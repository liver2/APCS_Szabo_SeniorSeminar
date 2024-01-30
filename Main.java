import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("For students who did not fill out the form, a Seminar ID of \"-1\" indicates we were unable to place the student in a Seminar.");
        ScheduleOp scheduleOp = new ScheduleOp();
        Scanner scan = new Scanner(System.in);
        scheduleOp.randomize();
        while (true) {
            System.out.println("-----");
            System.out.print("Search a student by email22: ");
            String email = scan.nextLine();
            System.out.println(scheduleOp.search(email));
        } 
    }
}