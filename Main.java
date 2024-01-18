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
        
        System.out.println(dataStrings);
    }
}