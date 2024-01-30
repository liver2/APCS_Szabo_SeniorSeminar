import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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