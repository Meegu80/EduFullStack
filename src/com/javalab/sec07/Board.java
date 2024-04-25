package com.javalab.sec07;

import java.time.LocalDateTime;

public class Board {
    private String subject;
    private String content;
    private String writter;
    private LocalDateTime regDate;

    public Board() {

    }

    public Board(String subject, String content, String writter, LocalDateTime regDate) {
        this.subject = subject;
        this.content = content;
        this.writter = writter;
        this.regDate = regDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", writter='" + writter + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
