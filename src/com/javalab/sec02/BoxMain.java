package com.javalab.sec02;

public class BoxMain {
    public static void main(String[] args) {
        // BOx 객체 생성
        Box box = new Box();

        box.setContent("사과");

        String content = (String) box.getContent();
        System.out.println(content);

        box.setContent(120); //int 120dl 자동포장되어서 Integer 타입의 120을 Object 타입으로 자동 형변환 시킴
        Integer itg = (int) box.getContent();
        System.out.println("Interger itg : " + itg );
        //5. Box 객체에 Audio 타입의 객체를 담음 "LG"

        Audio audio = new Audio();
        audio.setModel("LG");
        box.setContent(audio); // audio 타입의 객체를 Object 타입으로 자동 형변환
        Audio audio1 = (Audio) box.getContent();
        System.out.println("Audio audio1 "+ audio1.getModel() );

    }
}
