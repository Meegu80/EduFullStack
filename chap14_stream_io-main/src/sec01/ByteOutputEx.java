package sec01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteOutputEx {
    public static void main(String[] args) {
        try {
            //OutputStream 생성
            OutputStream os = new FileOutputStream("C:/filetest/file.txt");

            String str = "Hello,OutputStream";
            // 문자열을 byte[]로 변환하여 파일로 출력
            // 문자열을 기본 문자 인코딩을 사용하여 바이트 배열로 인코딩
            // 플랫폼에 따라 다르지만 일반적으로 UTF-8로 인코딩하여 문자를 바이트로 변환
            // 한글 같은 경우는 깨지는 것을 예방
            // 각 문자를 바이트로 변환하여 쓴다.
            byte[] arr = str.getBytes();    // 문자열을 byte[]로 변환
            os.write(arr); // byte[]의 내용을 파일로 출력
        }catch(IOException e){
            e.printStackTrace();
            }
    }
}
