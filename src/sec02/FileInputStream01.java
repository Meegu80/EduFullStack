package sec02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * [FileInputStream]
 * 파일을 바이트 단위로 읽어들인다.(입력)
 * InputStream을 상속받아서 구현한 클래스(자식)
 * read():파일로부터 1byte를 읽어들인다. 파일의 끝에 도달하면, -1을 리턴한다.
 *
 */

public class FileInputStream01 {
    public static void main(String[] args) {
        try {
            // FileInputStream 생성
            // new FileInputStream("파일경로") : 해당 경로의 파일을 찾고
            // 파일을 읽어들일 수 있는 FileInputStream 객체를 생성한다.
            // 만약에, 해당 경로에 파일이 없으면 FileNotFoundException 발생.

            InputStream is = new FileInputStream("C:/filetest/test1.txt");
            int byteRead; //읽어온 데이터를 임시로 담아들 변수(4byte)
            // while문을 통해 파일의 끝까지 1byte씩 읽어들인다.
            // read() 메소드가 파일의 끝에 도달하면 -1을 리턴한다.
            while ((byteRead = is.read()) != -1) {
                System.out.println((char) byteRead); // 읽은 데이터를 문자로 변환하여 출력
            }
        } catch (FileNotFoundException e) { //경로에 파일이 없을때
            e.printStackTrace();
        } catch (IOException e) { // 파일을 읽고 있던 중, 끊겨서 입력에러가 뜬다일 경우
            e.printStackTrace();
        }
    }
}
