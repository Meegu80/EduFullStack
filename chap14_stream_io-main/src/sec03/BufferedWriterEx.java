package sec03;

import java.io.*;

public class BufferedWriterEx {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("C:/filetest/test4.txt"));
            for (int i = 1; i < 11; i++) {
                String data = i + " 번재 줄입니다.\n";
                bw.write(data);
            }
            System.out.println("파일 저장이 완료되었습니다. ");
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(bw != null){
                    bw.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
