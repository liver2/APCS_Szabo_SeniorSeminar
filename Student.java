public class Student {
    private String name;
    private String email;
    private int order;
    private int[] idChoices = new int[5];
    private Seminar[] seminars;

    public Student(int o,String e,String n,int c1,int c2,int c3,int c4,int c5) {
        name = n;
        email = e;
        order = o;
        idChoices[0] = c1;
        idChoices[1] = c2;
        idChoices[2] = c3;
        idChoices[3] = c4;
        idChoices[4] = c5;
    }

    public String toString() {
        String r = "";
        r += "\nName: " + name + "\n";
        r += "Email: " + email + "\n";
        r += "Order: " + order + "\n";
        r += "Choices: " + idChoices[0] + "," + idChoices[1] + "," + idChoices[2] + "," + idChoices[3] + "," + idChoices[4] + "\n";
        return r;
    }
}
