package sec01;

public class Student {
    private int id;
    private String securityNum;
    private String name;
    private int grade;
    private String address;
    private int clroom;

    public Student() {

    }

    public Student(int id, String securityNum, String name, int grade, String address, int clroom) {
        this.id = id;
        this.securityNum = securityNum;
        this.name = name;
        this.grade = grade;
        this.address = address;
        this.clroom = clroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecurityNum() {
        return securityNum;
    }

    public void setSecurityNum(String securityNum) {
        this.securityNum = securityNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getClroom() {
        return clroom;
    }

    public void setClroom(int clroom) {
        this.clroom = clroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", securityNum='" + securityNum + '\'' +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address='" + address + '\'' +
                ", clroom=" + clroom +
                '}';
    }

}
