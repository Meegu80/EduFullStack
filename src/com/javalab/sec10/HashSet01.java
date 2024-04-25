package com.javalab.sec10;

import java.util.HashSet;
import java.util.Set;

/**
 * Set 컬렉션 HashSet 클래스 사용 예
 * 셋 컬렉션은 중복을 허용하지 않는 컬랙션
 * HashSet 클래스는 Set 인터페이스를 구현한 클래스로, 중복을 허용하지 않습니다.
 * HashSet 클래스는 해시 알고리즘을 사용하여 검색 속도가 빠르다.
 * HashSet 클래스는 순서를 유지하지 않는다.
 * HashSet 클래스는 null 값을 저장할 수 있다
 * HashSet 클래스는 동기화를 지원하지 않는다
 */

public class HashSet01 {
    public static void main(String[] args) {
        // 셋 컬렉션 hashset 클래스 객체 생성
        Set<String> set = new HashSet<>();
        // set 컬렉션에 객체 추가
        set.add("apple");
        set.add("banana");
        set.add("cherry");

        for(String fruit : set){
            System.out.println(fruit);
        }

        // set 컬렉션에 객체 추가
        set.add("apple");
        set.add("banana");
        set.add("pineapple");

        // Set 컬렉션의 객체 출력
        System.out.println("Set 컬렉션에 중복된 객체 추가 후 " + set.toString());
        // pineapple만이 추가됨, 나머지는 중복 제거
    }
}
