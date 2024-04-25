package com.javalab.sec03;

public class BoxMain {
    public static void main(String[] args) {
        // 1. 제네릭 박스 객체 생성
        Box<String> box = new Box<String>(); // Box 객체 생성 시, String 타입으로 지정
        box.setContent("사과");

        // 2. Audio 객체 생성
        Box<Audio> audioBox = new Box<Audio>(); // Box 객체 생성 시, Audio 타입으로 지정
        Audio audio = new Audio("LG");
        audioBox.setContent(audio);
        System.out.println("audioBox : " + audioBox.toString());

        //3. TV 객체
        Box<TV> tvBox = new Box<TV>();
        TV tv = new TV("삼성",1000000);
        tvBox.setContent(tv); // TV 타입을 객체 생성시 전달했기 때문에 그 객체를 저장할 수 있음.

    }
}