import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Seminar[][] schedule = new Seminar[5][5];
        ScheduleOp scheduleOp = new ScheduleOp(); 
        ArrayList<String> dataStrings = new ArrayList<String>();
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            File data2 = new File("plaindata.csv");
            Scanner scan = new Scanner(data2);
            scan.nextLine();
            while(scan.hasNextLine()) {
                dataStrings.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        
        for (String s : dataStrings) {
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

        // 1. initialize each Seminar in schedule to a placeholder, to which Seminars can compare themselves
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                schedule[i][j] = new Seminar(-1);
            }
        }

        System.out.println(students);
        
        for (int i = 0; i < 5; i++) {
            for (Student s : students) {
                scheduleOp.sort(schedule, s,i);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(schedule[i][j].tempGridDisplay());
            }
            System.out.println("");
        }
    }
}