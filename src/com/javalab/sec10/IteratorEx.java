package com.javalab.sec10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorEx {
    public static void main(String[] args) {
        // 셋 컬렉션 hashset 클래스 객체 생성
        Set<String> set = new HashSet<>();

        // 요소 추가
        set.add("사과");
        set.add("바나나");
        set.add("오렌지");
        set.add("포도");

        /**
         * Iterator(반복자)를 사용하여 Set의 모든 요소 출력
         */
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);

            if (fruit.equals("바나나")) {
                iterator.remove();
            }
        }
        // 삭제 후 남은 요소 출력
        System.out.println("삭제 후 남은 요소 : " + set);
    }
}

