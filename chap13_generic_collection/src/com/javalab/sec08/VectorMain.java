package com.javalab.sec08;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class VectorMain {
    public static void main(String[] args) {

        //List<Board> list = new ArrayList<>();
        List<Board> list = new Vector<>();
        //Vector는 스레드를 동기화함

        // 작업 스레드1 생성
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i, LocalDateTime.now()));
                }
            }
        };

        // 작업 스레드2 생성
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i, LocalDateTime.now()));
                }
            }
        };

        // 작업 스레드 시작
        thread1.start();
        thread2.start();

        // 메인 스레드가 모든 작업 스레드가 종료될 때까지 기다리게 함
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수: " + size);
    } // end of main
}   // end of class