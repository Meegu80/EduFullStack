package com.javalab.sec01;

/** Box 도메인 클래스
 * content 속성에는 String Type의 값만 저장할 수 있음(고정)
 */

public class Box {
    private String content;

    public Box(){}

    public Box(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }




}
