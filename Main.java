public class Main {
    public static void main(String[] args) {
        ScheduleOp scheduleOp = new ScheduleOp();
        int i = 1000; 
        long start = System.nanoTime();
        while (true) {
            int compare = scheduleOp.randomize();
            if (compare < i)
            {
                i = compare;
                long point = System.nanoTime();
                long duration = (point - start)/1000000000;
                System.out.println("New best optimization score " + i + " found at " + duration + "s");
            }
        }
    }
}