package com.javalab.sec02;

/**
 * Box 클래스의 content변수의 타입을 Object 타입으로 선언
 * - 어떤 객체든지 담을 수 있다.
 * - 단점은 해당 객체로 다시 꺼낼대는 (강제형변환)을 해줘야해서 불편함.
 */
public class Box {
    // 멤버 변수가 Object 타입으로 선언되어 있음. 모든 객체를 받을 수 있음
    private Object content;
    public Box(){}

    public Box(Object content){
        this.content = content;
    }

    public Object getContent(){
        return content;
    }

    public void setContent(Object content){
        this.content = content;
    }

    @Override
    public String toString() {
        return "Box{" +
                "content=" + content +
                '}';
    }
}
