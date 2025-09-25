package com.javalab.sec05;

public class LimitedTypeParam {
    public static void main(String[] args) {
        // NumericBox 객체 생성시 Number의 서브클래스인 Integer타입을 전달
        NumericBox<Integer> intBox = new NumericBox<>(10);
        System.out.println("Integer Value : " + intBox.getNumber());

        // NumericBox 객체 생성시 Number의 서브클래스인 Double 타입을 전달
        NumericBox<Double> doubleBox = new NumericBox<>(99.5);
        System.out.println("Double value : "+ doubleBox.doubleValue());

    }
}
