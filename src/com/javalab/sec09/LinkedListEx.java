package com.javalab.sec09;

import java.util.LinkedList;

public class LinkedListEx {
    public static void main(String[] args) {
        // LinkedList 객체 생성
        LinkedList<String> linkedList = new LinkedList<>();

        // 요소 추가
        linkedList.add("사과");
        linkedList.add("바나나");
        linkedList.add("오렌지");

        // LinkedList 맨앞/맨뒤에 요소 추가
        linkedList.addFirst("복숭아"); // 맨 처음에 요소 추가
        linkedList.addLast("체리"); // 맨 끝에 요소 추가

        // 요소 출력
        System.out.println("리스트: " + linkedList.toString()); // linkedList.toString() 호출됨
        System.out.println();

        // 반복문을 통한 출력
        for (String str : linkedList) {
            System.out.println(str);
        }

        // 요소 접근
        String firstElement = linkedList.getFirst(); // 맨 처음 요소 얻기
        String lastElement = linkedList.getLast(); // 맨 끝 요소 얻기
        System.out.println("맨 처음과 끝 : " + firstElement + "\t " + lastElement);
        System.out.println("=================================================");
        // 이름으로 요소 검색
        int index = linkedList.indexOf("바나나");
        System.out.println("바나나 위치 : " + index);    // 2
        System.out.println("=================================================");
        // 요소 삭제(이름)
        linkedList.remove("사과");    // 이름으로 "사과" 삭제
        System.out.println("사과 삭제 후 리스트: " + linkedList);
        System.out.println("=================================================");

        // 요소 삭제(인덱스)
        linkedList.remove(1); // 인덱스 1의 요소 삭제
        System.out.println("1번째 인덱스 삭제 후 리스트 : "+ linkedList);
        System.out.println("=================================================");



    }
}