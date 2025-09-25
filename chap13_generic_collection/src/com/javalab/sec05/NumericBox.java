package com.javalab.sec05;

/**
 * 제한된 타입 파라미터
 * 제한된 타입 파라미터는 제네릭 타입이 특정 클래스의 서브클래스나 구현체만 받도록
 * 제한할 수 있다. 이를 통해서 타입 안정성 확보할 수 있다.
 * 타입 파라미터가 number 클래스를 상속한 클래스들만 받을 수 있다.
 *
 */
public class NumericBox<T extends Number> {
    private T number;
    //생성자
    public NumericBox(T number) {
        this.number = number;
    }
    // 기본생성자
    public NumericBox() {
    }
    //Getter 메소드
    public T getNumber() {
        return number;
    }
    //Setter 메소드
    public void setNumber(T number) {
        this.number = number;
    }
    // toString() 메소드 재정의
    @Override
    public String toString() {
        return "NumericBox [number=" + number + "]";
    }

    //Number의 doubleValue() 메소드 호출
    public double doubleValue() {
        return number.doubleValue();
    }
    // Number의 intValue() 메소드 호출
    public int intValue() {
        return number.intValue();
    }



}