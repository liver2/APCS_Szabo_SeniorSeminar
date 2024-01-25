public class Main {
    public static void main(String[] args) {
        ScheduleOp scheduleOp = new ScheduleOp();
        int i = 1000; 
        while (true) {
            int compare = scheduleOp.randomize();
            if (compare < i)
            {
                i = compare;
                System.out.println("New best optimization score " + i + "found");
            }
        }
    }
}