package sec01;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * [FileOutputStream]
 * 파일을 바이트 단위로 써준다(출력)
 * OutputStream을 상속받아서 구현한 클래스(자식)
 * OutputStream은 추상 클래스이므로 객체 생성이 불가능합다. 그러므로 자식이 객체로 생성될 때,
 * 부모가 먼저 객체로 생성된다.
 * 파일을 바이트 단위로 쓰기 때문에 문자열을 byte[] 변환하여 파일로 출력한다(인코딩 변환)
 */
public class FileOutputEx01 {
    public static void main(String[] args) {

        FileOutputStream fos = null;
        try {
            String filepath = "C:/filetest/test1.txt";
            fos = new FileOutputStream(filepath);
            String str ="안녕하세요, FileOutputStream";
            byte[] arr = str.getBytes();
            fos.write(arr);
        }catch (IOException e){
            e.printStackTrace();

        }finally{
            try {
                if (fos != null) fos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
