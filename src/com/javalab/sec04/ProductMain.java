package com.javalab.sec04;

/**
 * Product 제네릭 클래스를 사용하는 실행클래스
 */
public class ProductMain {
    public static void main(String[] args) {

        /*
         * Product 제네릭 객체 생성
         * - Kind, model 두개의 타입 파라미터를 받아서 객체로 생성된다.
         * - 여기서 보내는 Tv는 앞 K에 대입되고, String은 뒤 M에 대입된다.
         */
        Product<Tv, String> tvProduct = new Product<Tv, String>();
        tvProduct.setKind(new Tv());
        tvProduct.setModel("스마트Tv");
        System.out.println("Tv 제품 : " + tvProduct.getModel());

        // Car, String 타입을 받아서 객체로 생성
        Product<Car, String> carProduct = new Product<Car, String>();
        Car electricCar = new Car();
        carProduct.setKind(electricCar);
        carProduct.setModel("전기자동차");
        System.out.println("Car 제품 : " + carProduct.getModel());

        // <Car, String> 타입 파라미터를 받는 Car product 객체에 잘못된 타입의 값을 전달.
        carProduct.setKind(new Car());
        carProduct.setModel("AI Car");
    }
}