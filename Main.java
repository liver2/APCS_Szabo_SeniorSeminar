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

        for (Student s : students) {
            
        }
    }
}