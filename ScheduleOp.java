import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ScheduleOp {
    int[] counter = new int[18];

    ArrayList<Student> students = new ArrayList<Student>();

    public void importAndPrintData() {
        ArrayList<String> dataStrings =  new ArrayList<String>();

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

        System.out.println("Seminar ID's & Corresponding Names:");

        for(String s : dataStrings) {
            String[] construction = s.split(",");
            System.out.println("ID " + construction[1] + " --> \"" + construction[0] + "\" with " + construction[2] + " \'" + construction[3]);
        }
    }

    public boolean dupeCheck(Seminar sem, Student stu) {
        for (int i = 0; i < 5; i++) {
            if (sem.getId() == stu.getSeminar(i).getId()) {
                return false; // duped!
            }
        }
        return true; // not duped
    }

    public int sort(Seminar[][] schedule, Student s, int choice) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (schedule[i][j].getId() == s.getChoices(choice) && !(schedule[i][j].getRosterSize() == 16)) {
                    if (s.getSeminar(i).getId() == -1) {
                        schedule[i][j].setTime(i+1);
                        schedule[i][j].addStudent(s);
                        s.addSeminar(schedule[i][j], i); // i refers to index (time of day)
                        s.setOccupied(schedule[i][j].getTime()-1,schedule[i][j].getTime());
                        return 0;
                    }
                } else if (schedule[i][j].placeholder() && s.getChoices(choice) != 0) {   
                    if (s.getSeminar(i).getId() == -1 && !(counter[s.getChoices(choice)-1] == 2)) {
                        schedule[i][j] = new Seminar(s.getChoices(choice));
                        schedule[i][j].setTime(i+1); //index at 1 (first period is 1, second period is 2, etc)
                        counter[schedule[i][j].getId()-1]++;
                        // add one to the counter corresponding to the seminar id
                        schedule[i][j].addStudent(s);
                        s.addSeminar(schedule[i][j], i);
                        return 0;
                    }
                }
            }
            // if there is no space available then || prioritize secon choice || place wherever space
        }
        // System.out.println(s.toString() + "could not be given their " + (choice+1) + " choice");
        
        if(s.getChoices(choice) != 0) {
            return (5-choice);
        }

        return (0);
    }

    public int fill(Seminar[][] schedule, Student s) {
        for (int i = 0; i < 5; i++) {
            if (s.getSeminar(i).placeholder()) {
                inner: // loop label
                for (int j = 0; j < 5; j++) {
                    if (schedule[i][j].getRosterSize() < 16 && dupeCheck(schedule[i][j],s)) {
                        schedule[i][j].addStudent(s);
                        s.addSeminar(schedule[i][j], i); // i refers to index (time of day)
                        s.setOccupied(schedule[i][j].getTime()-1,schedule[i][j].getTime());
                        break inner;
                    }
                }
            }
        }
        return 1;
    }

    public String search(String str) {
        boolean found1 = false;
        
        for (Student s : students) {
            if (s.getEmail().equals(str)) {
                System.out.println(s.toString());
                found1 = true;
            }
        }

        if (!found1) {
            return "Student not found";
        }

        return "";
    }

    public int randomize() {
        Seminar[][] schedule = new Seminar[5][5];
        ArrayList<String> data2Strings = new ArrayList<String>();

        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
        }
        int optimization = 0;

        try {
            File data2 = new File("plaindata.csv");
            Scanner scan = new Scanner(data2);
            scan.nextLine();
            while(scan.hasNextLine()) {
                data2Strings.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        
        for (String s : data2Strings) {
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

        // Collections.shuffle(students);

        // 1. initialize each Seminar in schedule to a placeholder, to which Seminars can compare themselves
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                schedule[i][j] = new Seminar(-1);
            }
        }
        
        for (int i = 0; i < 5; i++) {
            for (Student s : students) {
                optimization += sort(schedule, s,i);
            }
        }

        for (Student s : students) {
            fill(schedule, s);
        }

        importAndPrintData();

        
        for (Student s : students) {
            System.out.println(s + "\n");
        }

        System.out.println("");
        System.out.println("Master Schedule");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(schedule[i][j].tempGridDisplay() + " ");
            }
            System.out.println("");
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(schedule[i][j].toString());
            }
        }
        System.out.println();

        return optimization;
    }
}