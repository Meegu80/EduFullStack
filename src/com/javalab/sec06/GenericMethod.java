package com.javalab.sec06;

import java.sql.SQLOutput;

public class GenericMethod {

    // 제네릭 메소드 예제
    // 제네릭 메소드는 메소드의 선언부에 타입 파라미터를 선언하는 메소드이다.
    // 타입 파라미터<T>는 이 메소드 호출시 전달되는 인자값을 추론하여 결정한다.
    // Integer가 오면 제네릭 메소드는 전달된 타입 파라미터의 타입에 따라서 Box<Integer>객체를 생성한다.
    // 반환 타입 앞의 <T>는 제네릭 메소드의 타입 파라미터를 의미한다.
    // 그 타입에 맞춰서 반환타입, 매개변수 타입이 확정된다.
    // 이걸 생략하면 컴파일러가 오류를 발생시킨다.
    // 메소드의 리턴 타입 앞에 <T>를 붙여서 제네릭 메소드를 선언할 수 있다.
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.setT(t);
        return box;
    }

    public static void main(String[] args) {
        //제네릭 메소드 호출
        // 인자값으로 100을 전달하면 boxing 메소드의 타입 파라미터는 <Integer>타입으로 결정된다.
        Box<Integer> box1 = boxing(100);
        int intValue = box1.getT();
        System.out.println("intValue : " + intValue);

        //
        Box<String> box2 = boxing("100");
        String strValue = box2.getT();
        System.out.println("strValue : " + strValue);

        Box<String> box3 = boxing("LG");
        String model = box3.getT();
        System.out.println("model : " + model);

        // 제네릭 메소드 호출
        Box<Audio> aBox = boxing(new Audio("LG"));
        Audio audio = aBox.getT();
        System.out.println("audio : " + audio);
    }
}
