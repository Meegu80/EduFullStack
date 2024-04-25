package com.javalab.sec07;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardMain {
    public static void main(String[] args) {
        // 게시물 객체를 저장할 ArrayList 객체 생성
        // 제네릭 클래스의 타입 파라미터로 Board Type을 지정
        // Board Type의 객체만 저장 가능
        List<Board> boardList = new ArrayList<>();

        // 5개의 Board 객체 생성 및 추가
        boardList.add(new Board("Title 1","Content 1","Writter 1", LocalDateTime.now()));
        boardList.add(new Board("Title 2","Content 2","Writter 2", LocalDateTime.now()));
        boardList.add(new Board("Title 3","Content 3","Writter 3", LocalDateTime.now()));
        boardList.add(new Board("Title 4","Content 4","Writter 4", LocalDateTime.now()));
        boardList.add(new Board("Title 5","Content 5","Writter 5", LocalDateTime.now()));

        for(Board board : boardList){
            System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWritter() + "\t" + board.getRegDate());
        }
    }
}
