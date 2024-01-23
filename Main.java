import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Seminar[][] schedule = new Seminar[5][5];
        ArrayList<String> dataStrings = new ArrayList<String>();
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            File data = new File("actualSrSeminarData.csv");
            Scanner scan = new Scanner(data);
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
                schedule[i][j] = new Seminar(0);
            }
        }

        for (Student s : students) { // first choice loop
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (schedule[i][j].getId() == s.getChoices(0)) {
                        schedule[i][j].addStudent(s);
                        break;
                    }
                    if (schedule[i][j].placeholder()) {
                        schedule[i][j] = new Seminar(s.getChoices(0));
                        schedule[i][j].addStudent(s);
                        break;
                        // place the student in the created seminar
                    }
                }
            } // what if there are no more slots left and you're trying to put people in a seminar that has already been created?

            // take the first student's first choice
            // create a seminar as to the left as possible and place the student in it
            // repeat for all students.
            // CREATE A DEBUG MODE to see the schedule fully
            // if there is no space available then || prioritize secon choice || place wherever space
        }

        System.out.println(schedule);
    }
}