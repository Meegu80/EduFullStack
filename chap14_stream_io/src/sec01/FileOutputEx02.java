package sec01;

import java.io.FileOutputStream;

public class FileOutputEx02 {
    public static void main(String[] args) {
        String filePath = "C:/filetest/test2.txt";
        // try-with-resource구문
        // FileOutputStream("파일경로 + 파일이름") 생성자에 파일 경로를 적어준다.
        // 해당 경로에 파일이 없으면 새로 생성한다.

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            String str = "안녕하냐, 아따 거시기 허여";
            byte[] arr = str.getBytes();
            fos.write(arr); // 파일에 문자열을 출력
            fos.flush();    // 출력 스트림에 남아 있는 내용을 비워준다.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}