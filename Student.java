public class Student 
{
    private String name;
    private String email;
    private int order; 
    // Although not used currently, the "order" was used as an ID number in a previous version of this program,
    // which continuously randomized the order of importing students into the schedule.
    // This program aimed to find the optimal schedule for these students' choices. After ~12 hours of testing 3000 randomizations/second (1.296e8 randomizations),
    // The program found the current schedule. With more testing, an even more optimal schedule is likely possible. More info in ScheduleOp.
    private int[] idChoices = new int[5];
    private Seminar[] seminars = new Seminar[5];
    private int[] occupied = new int[5]; // Keeps track of when a student's schedule is filled by a Seminar: Used in the "randomize" placing algorithm.

    public Student(int o,String e,String n,int c1,int c2,int c3,int c4,int c5) 
    {
        name = n;
        email = e;
        order = o;
        idChoices[0] = c1;
        idChoices[1] = c2;
        idChoices[2] = c3;
        idChoices[3] = c4;
        idChoices[4] = c5;

        for (int i = 0; i < 5; i++) 
        {
            occupied[i] = 0; 
        }

        for (int i = 0; i < 5; i++) 
        {
            seminars[i] = new Seminar(-1); // -1 => placeholder. 
            // Originally the placeholder ID was zero, but the program matched those who had no choices (ID: 0) to sessions with ID 0, so a new placeholder had to be made.
        }
    }

    public int getChoices(int i) 
    {
        return idChoices[i];
    }

    public int getOrder() 
    {
        return order;
    }

    public Seminar getSeminar(int i) 
    {
        return seminars[i];
    }

    public int[] getOccupied() 
    {
        return occupied;
    }

    public String getName() 
    {
        return name;
    }

    public String getEmail() 
    {
        return email;
    }

    public void addSeminar(Seminar s, int i) 
    {
        seminars[i] = s;
    }

    public void setOccupied(int index, int value) 
    {
        occupied[index] = value;
    }

    public String toString() 
    {
        String r = "";
        r += "\nName: " + name + "\n";
        r += "Email: " + email + "\n";
        r += "Seminars: " + seminars[0].tempGridDisplay() + "," + 
                            seminars[1].tempGridDisplay() + "," + 
                            seminars[2].tempGridDisplay() + "," + 
                            seminars[3].tempGridDisplay() + "," + 
                            seminars[4].tempGridDisplay() + "";
        return r;
    }
}
