package com.javalab.sec03;

/**
 * 제네릭 클래스
 * - 자바에서 제네릭은 클래스, 인터페이스, 메소드를 정의할 때 타입을
 *   파라미터로 사용할 수 있도록 하는 기능을 말한다.
 *   이를 통해서 컴파일 시점에 타입 안정성을 제공하며 타입 캐스팅을 줄여서
 *   코드를 더 안전하고 읽기 쉽게 만들 수 있다.
 * - 제네릭 클래스를 선언할 때는 클래스 이름 뒤에 <T>와 같이 타입 파라미터를 선언하고
 *   객체를 생성할 때 구체적인 타입을 결정할 수 있다.
 * - <T>는 타입 파라미터라고 불리며 객체 생성시 전달된 타입으로 정해진다.
 *   일반적으로 영문, 대문자 T, V, E 등으로 표현한다.
 * - 타입 파라미터가 객체 생성시 정해지는 것 같지만 실제로는 컴파일 시점에
 *   컴파일러가 타입을 체크하고 변환한다.
 */
public class Box<T> {
    private T conent;

    // 기본생성자
    public Box() {
    }
    // 생성자
    public Box(T content) {
        this.conent = content;
    }
    // getter
    public T getContent() {
        return conent;
    }
    // setter
    public void setContent(T content) {
        this.conent = content;
    }
    // toString
    @Override
    public String toString() {
        return "Box{" +
                "content=" + conent +
                '}';
    }

}