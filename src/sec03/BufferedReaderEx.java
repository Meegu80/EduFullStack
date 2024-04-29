package sec03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader
 * - 파일을 문자 단위로 읽어준다(입력)
 * BufferedReader은 생성자로 Reader를 받아들여서 생성한다.
 * Reader 중에서도 FileReader를 많이 사용한다.
 * BufferedReader 자체적으로는 파일을 읽지 않고 Reader의 자식들 중에서
 * 하나를 생성자의 파라미터로 받아서 만들어진다
 * BufferedReader는 버퍼를 이용하여 데이터를 한꺼번에 8KB씩 읽어들여서 속도가 빠름.
 * readLine()메서드를 이용하여 한 줄씩 읽어들인다.
 */
public class BufferedReaderEx {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            // new FileReader("C:/filetest/test1.txt") : 파일을 읽어들이는 Reader 객체 생성
            // 위에서 생성한 FileReader를 BufferedReader의 생성자로 넣어서 BufferedReader객체 생성
            br = new BufferedReader(new FileReader("C:/filetest/test1.txt"));
            int lineNo = 1;
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
                System.out.println(lineNo + " : " + line);
                lineNo++;
            }
            br.close(); // 스트림을 닫는다
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
