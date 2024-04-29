package sec01;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputEx03 {
    public static void main(String[] args) {
        byte[] arr = {10,20,30,40,50};
        String filename = "C:/filetest/test3.txt";

        try(FileOutputStream fos = new FileOutputStream(filename)) {
            for (byte b : arr) {
                int value = b & 0xff; //byte를 부호 없는 정수로 변환
                fos.write(Integer.toString(value).getBytes());// 이 부호 없는 정수를 문자열로 반환합니다.
                fos.write("\n".getBytes());
            }
            System.out.println("파일이 정상적으로 써졌습니다. ");
        } catch (IOException e){
            e.printStackTrace();
            }
        }
    }

