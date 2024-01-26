public class Student {
    private String name;
    private String email;
    private int order;
    private int[] idChoices = new int[5];
    private Seminar[] seminars = new Seminar[5];
    private int[] occupied = new int[5];

    public Student(int o,String e,String n,int c1,int c2,int c3,int c4,int c5) {
        name = n;
        email = e;
        order = o;
        idChoices[0] = c1;
        idChoices[1] = c2;
        idChoices[2] = c3;
        idChoices[3] = c4;
        idChoices[4] = c5;
        for (int i = 0; i < 5; i++) {
            occupied[i] = 0;
        }
        for (int i = 0; i < 5; i++) {
            seminars[i] = new Seminar(-1);
        }
    }

    public int getChoices(int i) {
        return idChoices[i];
    }

    public int getOrder() {
        return order;
    }

    public String toString() {
        String r = "";
        r += "\nName: " + name + "\n";
        r += "Email: " + email + "\n";
        r += "Order: " + order + "\n";
        r += "Choices: " + idChoices[0] + "," + idChoices[1] + "," + idChoices[2] + "," + idChoices[3] + "," + idChoices[4] + "\n";
        r += "Seminars: " + seminars[0].tempGridDisplay() + "," + 
                            seminars[1].tempGridDisplay() + "," + 
                            seminars[2].tempGridDisplay() + "," + 
                            seminars[3].tempGridDisplay() + "," + 
                            seminars[4].tempGridDisplay() + "\n";
        return r;
    }

    public void addSeminar(Seminar s, int i) {
        seminars[i] = s;
    }

    public Seminar getSeminar(int i) {
        return seminars[i];
    }

    public int[] getOccupied() {
        return occupied;
    }

    public void setOccupied(int index, int value) {
        occupied[index] = value;
    }

    public String seminarToString() {
        String r = "";
        r += "List of seminars:\n";
        for (int i = 0; i < seminars.length; i++) {
            r += seminars[i].toString() + "\n";
        }
        return r;
    }
}
