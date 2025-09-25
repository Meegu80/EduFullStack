package sec02;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputStream
 * 파일을 바이트 단위로 읽어들인다(입력)
 * read():파일로부터 1byte를 읽어들인다. 파일의 끝에 도달하면 -1을 리턴한다.
 * read(byte[512] b) : 파일로부터 512kb만큼 읽어들인다. 읽어들인 바이트 수를 리턴한다
 */
public class FileInputStream02 {
    public static void main(String[] args) {
        String filePath = "C:/filetest/test2.txt";
        //try-with-resource 구문
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] buffer = new byte[512]; // 길이가 512k byte씩 읽어들인다.

            int byteRead; //읽어들인 바이트 수를 저장할 변수

            while ((byteRead = fis.read(buffer)) != -1) {
                // 읽어들인 바이트 수만큼 출력
                for (int i = 0; i < byteRead; i++) {
                    System.out.println((char) buffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}