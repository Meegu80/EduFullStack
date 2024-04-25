package com.javalab.sec10;

import java.util.HashSet;
import java.util.Set;

public class MemberMain {
    public static void main(String[] args) {
        // HashSet 컬렉션 생성
        Set<Member> memberSet = new HashSet<Member>();

        // Member 객체 저장
        Member member1 = new Member("홍길동", 30);
        Member member2 = new Member("김수진", 20);
        Member member3 = new Member("홍길동", 30);

        // Member 객체 저장
        member1.add()
        member1.add()
        member1.add()

        //hashCode 재정의
        @Override
                public boolean equals(Object obj){
            if(obj instanceof Member) {
                Member mem = (Member) obj;
                return mem.name.equals(this.name) && (mem.age == this.age);
            } else{
                return false;
            }
        }
    }
}
