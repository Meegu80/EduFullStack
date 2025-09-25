package sec03;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;    // URL 클래스 import

public class FileCopy01 {
    public static void main(String[] args) {
        // 현재 클래스 파일의 메타 정보를 담고 있는 Class 클래스 객체 얻기
        Class clazz = FileCopy01.class;
        String resourceName = "bird.png";

        try {
            //  메서드는 클래스의 위치를 시작점으로 하여 지정된 리소스의 이름에 해당하는 리소스를 URL로 반환
            // URL에는 프로토콜, 파일경로, 호스트, 포트번호, 쿼리문자열 등이 포함되어 있다.
            URL originUrl = clazz.getResource(resourceName);
            System.out.println("originUrl: " + originUrl);  // URL 객체 출력
            System.out.println("originUrl.getPath(): " + originUrl.getPath()); // URL 객체의 경로 출력, out 의 바이트코드 경로
            System.out.println("originUrl.getFile(): " + originUrl.getFile()); //
            System.out.println("originUrl.toURI(): " + originUrl.toURI());      // URL 인코딩 된 상태로 제공해준다.(더 정확하다.)

            if(originUrl == null) {
                System.out.println("리소스를 찾을 수 없습니다.");
                return;
            }

            // URL 객체로부터 안전한 타입의 파일 경로 취득
            // new File() 생성자는 파일 경로를 문자열로 받아 파일 객체를 생성
            File orginFile = new File(originUrl.toURI());   // URL 객체를 File 객체로 변환, import java.io.File;
            String originalFileName = orginFile.getPath();  // 파일 경로를 문자열로 반환
            // 출력할 파일 경로(복사될 파일 경로)
            String targetFileName = orginFile.getParent() + File.separator + "new_bird.png"; // 파일 경로의 부모 디렉토리 경로를 문자열로 반환

            // 파일 복사를 위한 스트림 생성
            InputStream is = new FileInputStream(originalFileName);
            OutputStream os = new FileOutputStream(targetFileName);

            // 파일 복사
            is.transferTo(os);  // transferTo() 메서드는 InputStream 인터페이스에 추가된 메서드로, 파일 복사를 위한 메서드

            // 스트림 닫기
            is.close();
            os.close();

        }catch (URISyntaxException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}