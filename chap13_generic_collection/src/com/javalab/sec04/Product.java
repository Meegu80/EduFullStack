package com.javalab.sec04;

/**
 * 제네릭 클래스 - 상품 클래스
 * K,M 두개의 제네릭 타입 파라미터를 받아들이는 제네릭 클래스
 * 제네릭 타입 파라미터 K,M은 각각 상품의 종류와 모델을 나타낸다.
 * 각각은 Product 객체 생성시 전달되는 타입 파라미터에 맞게 타입이 정해진다.
 * 객체 생성시 전달된 타입 파라미터가 클래스에 선언되어 있는 타입 파라미터로 대체된다.
 *
 */

public class Product<K,M> {
    // 필드, 속성, 변수
    private K kind;
    private M model;

    public Product(){
    }

    public Product(K kind, M model) {
        this.kind = kind;
        this.model = model;
    }

    public K getKind() {
        return kind;
    }

    public void setKind(K kind) {
        this.kind = kind;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Product{" +
                "kind=" + kind +
                ", model=" + model +
                '}';
    }
}
