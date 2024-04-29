package sec03;
/**
 * FileReader
 * 파일을 문자 단위로 읽어준다(입력)
 * Reader를 상속받아서 구현한 클래스(자식)
 * 문자 단위로 읽기 때문에 문자열로 출력한다. 한글과 같은 문자가 깨지지 않는다
 * reader.read() : 파일을 한 글자씩 읽어서 int로 반환한다. 파일의 끝에 도달하면, -1을 반환한다
 */


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderEx {
    public static void main(String[] args) {
        // 파일을 읽어들이는 Reader 객체 생성(Filereader의 상위객체)
        Reader reader = null; //try 문 밖에 선언해서, finally에서도 사용할 수 있도록 한다.
        try {
            reader = new FileReader("C:/filetest/test1.txt");
            while (true) {
                int data = reader.read();
                if (data == -1) break;
                System.out.println((char) data);

            }
            reader.close();
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
