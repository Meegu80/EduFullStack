package com.javalab.sec07;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx {
    public static void main(String[] args) {
        //ArrayList 생성
        List<String> list = new ArrayList<>();

        //  요소 추가
        list.add("바나나");
        list.add("사과");
        list.add("오렌지");

        // ArrayList 요소 조회
        showFruitList(list);

        // ArrayList 요소 삭제
        list.remove("바나나");
        showFruitList(list);

        list.remove(1); // 삭제할 인덱스 전달
        showFruitList(list);
        //ArrayList 요소 추가
        list.add(1, "딸기"); // 1번 인덱스에 딸기 추가
        showFruitList(list);

        // ArrayList 요소 개수 출력
        int size = list.size();
        System.out.println("총 요소 수 : " + size);
    }// end of main

    // 출력메소드 모듈화
    public static void showFruitList(List<String> list) {
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}