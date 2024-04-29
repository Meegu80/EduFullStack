package sec03;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * FileWriter
 * 파일을 문자 단위로 써준다(출력)
 * Writer를 상속받아서 구현한 클래스(자식)
 * = 문자 단위로 쓰기 때문에 문자열을 문자 단위로 변환하여 파일로 출력한다.
 * writer.write() : 문자열을 파일에 출력한다.
 */
public class FileWriterEx01 {
    public static void main(String[] args) {
        // 문자기반 출력 스트림 생성
        Writer writer = null;
        try {
            writer = new FileWriter("C:/filetest/test4.txt");

            // 한문자씩 출력(쓰기)
            char a = 'A';
            char b = 'B';
            writer.write(a);
            writer.write(b);

            writer.flush();// 버퍼에 남아있는 데이터를 출력시킨다.
            writer.close();// 스트림을 닫는다.
            System.out.println("파일 저장이 완료되었습니다. ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
