import sec01.Student;

import java.util.ArrayList;

public class StudentMain {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        //public Student(int id, String securityNum, String name, int grade, String address, int clroom) {
        students.add(new Student(1292001, "900424-1825409", "김광식", 3, "서울", 920));
        students.add(new Student(1292002, "900305-2730021", "김정현", 3, "서울", 923));
        students.add(new Student(1292003, "891021-2308302", "김현정", 4, "대전", 925));
        students.add(new Student(1292301, "880902-2704012", "김정숙", 2, "대구", 923));
        students.add(new Student(1292303, "910715-1524390", "박광수", 3, "광주", 920));
        students.add(new Student(1292305, "921011-1809003", "김우주", 4, "부산", 925));
        students.add(new Student(1292501, "900825-1506390", "박철수", 3, "대전", 923));
        students.add(new Student(1292502, "911011-1809003", "백태성", 3, "서울", 925));

         printStudent(students);  // 문제2
         printWomanStudent(students); //문제3
         print3rdgradeStudent(students);  //문제4
        // 문제5는 점수가 없으니 PASS
        randomcharNameShow(students); // 문제6
        Showkwangcode(students);// 문제 7

    } //end of main

    //===============================================================================================
    // 학생List 출력메소드
    public static void printStudent(ArrayList<Student> students) {
        for (Student stulist : students) {
            System.out.println("학번 : " + stulist.getId() + "\t\t" + "주민번호 : " + stulist.getSecurityNum() + "\t\t" + "이름 :"
                    + stulist.getName() + "\t\t" + "학년 : " + stulist.getGrade() + "\t\t" + "주소 : " + stulist.getAddress() + "\t\t" +
                    "강의실 : " + stulist.getClroom());
        }
        System.out.println("===============각 문제의 끝입니다====================");
    }

    //===============================================================================================
    //문제3. 여학생들만 조회해서 출력(주민버호 8번째 수가 1,2중에 2를 선택해서 출력)
    public static void printWomanStudent(ArrayList<Student> students) {
        for (Student stulist : students) {
            if (stulist.getSecurityNum().charAt(7) == '2') {

                System.out.println("학번 : " + stulist.getId() + "\t\t" + "주민번호 : " + stulist.getSecurityNum() + "\t\t" + "이름 :"
                        + stulist.getName() + "\t\t" + "학년 : " + stulist.getGrade() + "\t\t" + "주소 : " + stulist.getAddress() + "\t\t" +
                        "강의실 : " + stulist.getClroom());
            } else {
            }
        }
        System.out.println("===============각 문제의 끝입니다====================");
    }

    //===============================================================================================
    //문제4. 서울에 사는 3학년 학생들을 조회하고 그 결과를 받아와서 출력하시오.
    public static void print3rdgradeStudent(ArrayList<Student> students) {
        for (Student stulist : students) {
            if (stulist.getAddress().equals("서울")) {

                System.out.println("학번 : " + stulist.getId() + "\t\t" + "주민번호 : " + stulist.getSecurityNum() + "\t\t" + "이름 :"
                        + stulist.getName() + "\t\t" + "학년 : " + stulist.getGrade() + "\t\t" + "주소 : " + stulist.getAddress() + "\t\t" +
                        "강의실 : " + stulist.getClroom());
            } else {
            }
        }
        System.out.println("===============각 문제의 끝입니다====================");
    }
    //===============================================================================================
    //문제5. 학생들 중에서 3학년 학생들의 평균을 구하시오.
    // 평균 구하는 메소드 호출
    // System.out.println("3학년 학생들의 평균은 : " + avg);
    // 점수가 없으니 패스

    //===============================================================================================
    //문제6. 이름에 특정 문자가 들어간 학생만 출력("김"이 들어간 학생만 출력)
    // 메소드 호출

    public static void randomcharNameShow(ArrayList<Student> students) {
        for (Student stulist : students) {
            if (stulist.getName().contains("김")) {

                System.out.println("학번 : " + stulist.getId() + "\t\t" + "주민번호 : " + stulist.getSecurityNum() + "\t\t" + "이름 :"
                        + stulist.getName() + "\t\t" + "학년 : " + stulist.getGrade() + "\t\t" + "주소 : " + stulist.getAddress() + "\t\t" +
                        "강의실 : " + stulist.getClroom());
            } else {
            }
        }
        System.out.println("===============각 문제의 끝입니다====================");
    }


    //===============================================================================================
    //문제7. 주소가 광주인 학생의 학과 코드를 925로 변경하시오.
    public static void Showkwangcode(ArrayList<Student> students) {
        for (Student stulist : students) {
            if (stulist.getAddress().equals("광주")) {
                stulist.setClroom(925); //코드를 바꿈
                System.out.println("학번 : " + stulist.getId() + "\t\t" + "주민번호 : " + stulist.getSecurityNum() + "\t\t" + "이름 :"
                        + stulist.getName() + "\t\t" + "학년 : " + stulist.getGrade() + "\t\t" + "주소 : " + stulist.getAddress() + "\t\t" +
                        "강의실 : " + stulist.getClroom());
            } else {
            }
        }
    }
    //===============================================================================================
}
