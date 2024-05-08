package com.javalab.school.execution;

import com.javalab.school.dao.DatabaseConnection;

import java.sql.*;
import java.util.Scanner;

/**
 * 학사 행정관리 시스템 메인 클래스
 * - 학생, 교수, 강의, 학과, 학사관리 등의 기능을 제공하는 프로그램
 */
public class SchoolManagementMain {
    // 정적 멤버 변수 선언(Connection, Scanner)
    private static final Connection conn = DatabaseConnection.getConnection();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            mainMenu();
        }
    } // end of main

    /**
     * 메인 메뉴 출력 메소드
     */
    private static void mainMenu(){
        System.out.println("=============================");
        System.out.println("학사 행정관리 시스템");
        System.out.println("=============================");
        System.out.println("1. 학생 관련 업무");
        System.out.println("2. 교수 관련 업무");
        System.out.println("3. 학과 관련 업무");
        System.out.println("4. 성적 관련 업무");
        System.out.println("5. 강의 관련 업무");
        System.out.println("6. 수업 관련 업무");
        System.out.println("7. 수강 신청 관련 업무");
        System.out.println("9. 종료");
        System.out.println("=============================");
        System.out.print("메뉴 선택: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                studentMenu();
                break;
            case 2:
                professorMenu();
                break;
            case 3:
                //departmentMenu();
                break;
            case 4:
                //takesMenu();
                break;
            case 5:
                //courseMenu();
                break;
            case 6:
                //classMenu();
                break;
            case 7:
                //enrollmentMenu();
                break;
            case 9:
                System.out.println("프로그램을 종료합니다.");
                exit(); // 프로그램 종료
                return;
            default:
                System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
        }
    }

    /**
     * 학생 메뉴(서브 메뉴)
     * - 학생 등록, 조회, 수정, 삭제 기능을 제공한다.
     */
    private static void studentMenu() {
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 학생 등록");
            System.out.println("2. 학생 조회");
            System.out.println("3. 학생 정보 수정");
            System.out.println("4. 학생 정보 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    /**
     * 학생 등록
     */
    private static void registerStudent() {
        // 키보드로부터 학생 정보 입력
        System.out.println("[새 학생 입력]");
        System.out.print("학생 ID: ");
        String studentId = scanner.nextLine();
        System.out.print("주민번호: ");
        String jumin = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("학년: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("주소: ");
        String address = scanner.nextLine();
        System.out.print("학과 코드: ");
        int departmentId = scanner.nextInt();
        scanner.nextLine();
        // 데이터베이스 저장 처리
        // PreparedStatement 객체 선언 :
        // - SQL 문장을 미리 준비하여 실행할 수 있는 객체
        PreparedStatement pstmt = null;
        try{
            String sql = "insert into student(student_id, jumin, name, year, " +
                    "address, department_id) values(?, ?, ?, ?, ?, ?)";
            // 매개변수화된 파라미터에 값 세팅
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentId);
            pstmt.setString(2, jumin);
            pstmt.setString(3, name);
            pstmt.setInt(4, year);
            pstmt.setString(5, address);
            pstmt.setInt(6, departmentId);
            // SQL 문장 실행
            int i = pstmt.executeUpdate(); // insert, update, delete
            if(i > 0){
                System.out.println("학생 정보가 등록되었습니다.");
            }else{
                System.out.println("학생 정보 등록 실패");
            }
        }catch (SQLException e) {
            if(e instanceof SQLIntegrityConstraintViolationException){
                System.out.println("중복된 학생 ID가 존재합니다.");
            }else {
                e.printStackTrace();
            }
        }finally {
            close(pstmt);
        }   // end of try-catch-finally
    }   // end of registerStudent

    /**
     * 학생 조회
     * - 학생 테이블과 학과 테이블을 외부 조인하여 학생 정보를 조회한다.
     * - 학생 ID, 이름, 학년, 주소, 학과 ID, 학과명을 출력한다.
     * - 오라클 데이터베이스는 대소문자를 가리지 않는다. 하지만 키워드는 대문자로 쓰는게 좋다.
     */
    private static void displayStudents(){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT s.student_id, s.name, s.year, s.address, " +
                    "s.department_id, d.name department_name, d.office " +
                    "FROM student s " +
                    "LEFT OUTER JOIN department d on s.department_id=d.department_id " +
                    "ORDER BY s.student_id ASC ";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(); // 단순 조회 쿼리는 executeQuery() 메소드 사용

            System.out.println("학생 목록:");
            System.out.println("학생ID\t이름\t학년\t주소\t학과ID\t학과명");
            System.out.println("-------------------------------------------------");
            while(rs.next()){
                String studentId = rs.getString("student_id");
                String name = rs.getString("name");
                int year = rs.getInt("year");
                String address = rs.getString("address");
                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                String office = rs.getString("office");
                System.out.println(studentId + "\t" + name + "\t" + year + "\t" + address + "\t"
                        + departmentId + "\t" + departmentName + "\t" + office);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(pstmt, rs); // PreparedStatement, ResultSet 객체 닫기
        }
    }   // end of displayStudents

    /**
     * 학생 정보 수정
     */
    private static void updateStudent() {
        System.out.println("수정할 학생의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        System.out.print("새 주민번호: ");
        String jumin = scanner.nextLine();
        System.out.print("새 이름: ");
        String name = scanner.nextLine();
        System.out.print("새 학년: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리
        System.out.print("새 주소: ");
        String address = scanner.nextLine();
        System.out.print("새 학과 코드: ");
        int departmentId = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 처리

        PreparedStatement pstmt = null;
        try {
            String sql = "UPDATE student " +
                    "SET jumin = ?, " +
                    "    name = ?, " +
                    "    year = ?, " +
                    "    address = ?, " +
                    "    department_id = ? " +
                    "WHERE student_id = ? ";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, jumin);
            pstmt.setString(2, name);
            pstmt.setInt(3, year);
            pstmt.setString(4, address);
            pstmt.setInt(5, departmentId);
            pstmt.setString(6, id);
            int i = pstmt.executeUpdate(); // 쿼리문 실행, 업데이트된 행의 수 리턴

            if(i > 0){
                System.out.println("학생 정보가 수정되었습니다.");
            }else{
                System.out.println("학생 정보 수정 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt); // close 메소드 호출하면서 PreparedStatement 객체 전달
        }
    }   // end of updateStudent


    /**
     * PreparedStatement 객체를 닫는 메소드
     */
    public static void close(PreparedStatement pstmt) {
        try {
            if(pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * ResultSet 객체를 닫는 메소드
     */
    public static void close(ResultSet rs){
        try {
            if(rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * PreparedStatement, ResultSet 객체를 닫는 메소드
     */
    public static void close(PreparedStatement pstmt, ResultSet rs){
        close(pstmt);
        close(rs);
    }

    /**
     * 학생 정보 삭제
     */
    private static void deleteStudent( ) {
        System.out.println("삭제할 학생의 ID를 입력하세요: ");
        String id = scanner.nextLine();

        // 사용자로부터 삭제할 학생 ID 입력 받기
        PreparedStatement pstmt = null;
        try {
            String sql = "Delete from student " +
                    "Where student_id = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                System.out.println("학생 정보가 삭제되었습니다. ");
            } else {
                System.out.println("학생 정보 삭제 실패");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }
    }

    /**
     * 프로그램 종료
     * - 데이터베이스 연결을 닫고 프로그램을 종료한다.
     */
    public static void exit() {
        if(conn != null) {  // 커넥션 객체가 사용중이면 닫기
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        if(scanner != null) {   // Scanner 객체가 사용중이면 닫기
            scanner.close();
        }
        System.out.println("** 프로그램 종료 **");
        System.exit(0); // 프로그램을 완전히 종료
    } // end of exit


    /**
     * 학과 관련 메뉴
     */
    private static void departmentMenu() {
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 학과 등록");
            System.out.println("2. 학과 조회");
            System.out.println("3. 학과 정보 수정");
            System.out.println("4. 학과 정보 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    registerDepartment();
                    break;
                case 2:
                    displayDepartments();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    deleteDepartment();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    /**
     * 학과 등록
     */
    private static void registerDepartment() {
        System.out.println("[학과 등록]");
        System.out.print("학과 코드: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("학과 이름: ");
        String name = scanner.nextLine();
        System.out.print("교실 위치: ");
        String office = scanner.nextLine();

        String sql = "INSERT INTO department (department_id, name, office) VALUES (?, ?, ?) ";
        // try-with-resources 구문 사용해서 자원 자동 해체
        // try 구문이 끝나면 preparedStatement 객체가 자동으로 close() 메소드 호출
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, office);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("학과가 성공적으로 등록되었습니다.");
            } else {
                System.out.println("학과 등록에 실패했습니다.");
            }
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("무결성 제약 조건 위반으로 등록에 실패했습니다.");
            } else {
                e.printStackTrace();
            }/*finally{
                close(pstmt);*/  위에 try 안에 preparedstatement가 있어서 자동으로 닫혀서 이 구문이 필요없다.
            //}
        }
    }

    /**
     * 학과 목록 조회
     */
    private static void displayDepartments() {
        System.out.println("[등록된 학과 목록 조회]");
        String sql = "SELECT department_id, name, office FROM department ORDER BY department_id";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("department_id");
                String name = rs.getString("name");
                String office = rs.getString("office");
                System.out.printf("%-10d %-20s %-10s\n", id, name, office);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 학과 정보 수정
     */
    private static void updateDepartment() {
        System.out.println("[학과 정보 수정]");
        System.out.print("수정할 학과의 코드를 입력하세요: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("새 학과 이름: ");
        String name = scanner.nextLine();
        System.out.print("새 교실 위치: ");
        String office = scanner.nextLine();

        String sql = "UPDATE department SET name = ?, office = ? WHERE department_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, office);
            pstmt.setInt(3, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("학과 정보가 성공적으로 업데이트 되었습니다.");
            } else {
                System.out.println("해당 코드의 학과를 찾을 수 없습니다.");
            }
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("무결성 제약 조건 위반으로 등록에 실패했습니다.");
            } else {
                e.printStackTrace();
            }
        }
    }

    /**
     * 학과 정보 삭제
     */
    private static void deleteDepartment() {
        System.out.println("[학과 정보 삭제]");
        System.out.print("삭제할 학과의 코드를 입력하세요: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM department WHERE department_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("학과 정보가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("해당 코드의 학과를 찾을 수 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 교수 관련 메뉴
     */
    private static void professorMenu() {
        //
        while (true) {
            System.out.println("=============================");
            System.out.println("1. 교수 등록");
            System.out.println("2. 교수 조회");
            System.out.println("3. 교수 정보 수정");
            System.out.println("4. 교수 정보 삭제");
            System.out.println("5. 메인 메뉴로 가기");
            System.out.println("=============================");
            System.out.print("메뉴 선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    registerProfessor();
                    break;
                case 2:
                    displayProfessors();
                    break;
                case 3:
                    updateProfessor();
                    break;
                case 4:
                    deleteProfessor();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    /**
     * 교수 등록
     */
    private static void registerProfessor() {
        System.out.println("[새 교수 등록]");
        System.out.print("교수 ID: ");
        String id = scanner.nextLine();
        System.out.print("주민번호: ");
        String jumin = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("학과 코드: ");
        int department = scanner.nextInt();
        scanner.nextLine();
        System.out.print("직급: ");
        String grade = scanner.nextLine();
        System.out.print("채용 날짜(예: 2024-01-01): ");
        String hiredate = scanner.nextLine();

        String sql = "";

        // try~with~resources 구문을 사용하면 close()를 명시적으로 호출하지 않아도 자동 close
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, jumin);
            pstmt.setString(3, name);
            pstmt.setInt(4, department);
            pstmt.setString(5, grade);
            pstmt.setString(6, hiredate);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("교수가 성공적으로 등록되었습니다.");
            } else {
                System.out.println("교수 등록에 실패했습니다.");
            }
        } catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("무결성 제약 조건 위반으로 등록에 실패했습니다.");
            } else {
                e.printStackTrace();
            }
        }
    }

    /**
     * 교수 목록 조회
     */
    private static void displayProfessors() {
        System.out.println("[등록된 교수 목록 조회]");
        String sql = "SELECT p.professor_id, p.name, p.grade, p.hiredate, d.name as department_name FROM professor p JOIN department d ON p.department_id = d.department_id ORDER BY p.professor_id";
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String id = rs.getString("professor_id");
                String name = rs.getString("name");
                String grade = rs.getString("grade");
                Date hiredate = rs.getDate("hiredate");
                String departmentName = rs.getString("department_name");
                System.out.printf("%-10s %-15s %-10s %-20s %-15s\n", id, name, grade, hiredate.toString(), departmentName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 교수 정보 수정
     */
    private static void updateProfessor() {
        System.out.println("[교수 정보 수정]");
        System.out.print("수정할 교수의 ID를 입력하세요: ");
        String id = scanner.nextLine();
        System.out.print("새 주민번호: ");
        String jumin = scanner.nextLine();
        System.out.print("새 이름: ");
        String name = scanner.nextLine();
        System.out.print("새 학과 코드: ");
        int department = scanner.nextInt();
        scanner.nextLine();
        System.out.print("새 직급: ");
        String grade = scanner.nextLine();
        System.out.print("새 채용 날짜(예: 2024-01-01): ");
        String hiredate = scanner.nextLine();

        String sql = "UPDATE professor SET jumin = ?, name = ?, department_id = ?, grade = ?, hiredate = TO_DATE(?, 'YYYY-MM-DD') WHERE professor_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, jumin);
            pstmt.setString(2, name);
            pstmt.setInt(3, department);
            pstmt.setString(4, grade);
            pstmt.setString(5, hiredate);
            pstmt.setString(6, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("교수 정보가 성공적으로 업데이트 되었습니다.");
            } else {
                System.out.println("해당 ID의 교수를 찾을 수 없습니다.");
            }
        }  catch (SQLException e) {
            if (e instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("무결성 제약 조건 위반으로 등록에 실패했습니다.");
            } else {
                e.printStackTrace();
            }
        }
    }

    /**
     * 교수 정보 삭제
     */
    private static void deleteProfessor() {
        System.out.println("[교수 정보 삭제]");
        System.out.print("삭제할 교수의 ID를 입력하세요: ");
        String id = scanner.nextLine();

        String sql = "DELETE FROM professor WHERE professor_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("교수 정보가 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("해당 ID의 교수를 찾을 수 없습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }










} // end of class