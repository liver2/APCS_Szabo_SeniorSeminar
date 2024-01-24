public class ScheduleOp {
    private int[] counter = new int[18];

    public ScheduleOp() {
        for (int i = 0; i < counter.length; i++) {
            counter[i] = 0;
        }
    }
    
    public int sort(Seminar[][] schedule, Student s, int choice) { // adapt algo for all five choices?
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (schedule[i][j].getId() == s.getChoices(choice) && !(schedule[i][j].getRosterSize() == 16)) {
                    if (!(arrCompare(i+1,s.getOccupied()))) {
                        schedule[i][j].setTime(i+1);
                        schedule[i][j].addStudent(s);
                        s.addSeminar(schedule[i][j], i); // i refers to index (time of day)
                        s.setOccupied(schedule[i][j].getTime()-1,schedule[i][j].getTime());
                    }
                    return 1;
                } else if (schedule[i][j].placeholder() && s.getChoices(choice) != 0) {   
                    if (!(arrCompare(i+1,s.getOccupied())) && !(counter[s.getChoices(choice)-1] == 2)) {
                        schedule[i][j] = new Seminar(s.getChoices(choice));
                        schedule[i][j].setTime(i+1); //index at 1 (first period is 1, second period is 2, etc)
                        counter[schedule[i][j].getId()-1]++;
                        // add one to the counter corresponding to the seminar id
                        schedule[i][j].addStudent(s);
                        s.addSeminar(schedule[i][j], i);
                    }
                    return 1;
                }
            } // what if there are no more slots left and you're trying to put people in a seminar that has already been created?
            // take the first student's first choice
            // create a seminar as to the left as possible and place the student in it
            // repeat for all students.
            // CREATE A DEBUG MODE to see the schedule fully
            // if there is no space available then || prioritize secon choice || place wherever space
        }
        System.out.println(s.toString() + "could not be given their " + choice + " choice");
        return 0;
    }

    public boolean arrCompare(int i, int[] j) { // returns true if 
        for (int a = 0; a < j.length; a++) {
            if (j[a] == i) {
                return true;
            } 
        }
        return false;
    }
}

