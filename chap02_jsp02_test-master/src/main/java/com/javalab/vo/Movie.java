package com.javalab.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/******************************************************************
 * 영화 자바빈즈(도메인 클래스)
 * @author  홍길동
 * 2024.06.11
 * 영화정보를 저장하는 자바빈즈
 * - 롬복 애노테이션으로 간단하게 구현
 * - 자바빈즈의 직렬화시 안정성 확보 
  ******************************************************************/
 

// 롬복 어노테이션 - 메타데이터
@NoArgsConstructor			//기본생성자
@AllArgsConstructor			//오버로딩생성자
@Getter							
@Setter
@ToString
public class Movie implements Serializable {

	/**
	 * 		직렬화 - 자바 객체를 문자열 형태로 만들어서 전송
	 * 		받는 쪽에서는 역질렬화를 해서 받아야 한다.  
	 * 		역직렬화는 문자열 형태로 만들어진 문자열을 자바 객체로 실제 자바
	 * 		객체로 완성할 때 처음 만들어진 자바 객체로 실제 바자 객체로 완성할 때 
	 * 		처음 만들어진 자바 객체와 역직렬화 되어 다시 재조립된 자바 객체(자바빈즈)가
	 * 		같은 확인하기 위해서 다음과 같은 serialVersionUID가 필요하다.
	 */
	private static final long serialVersionUID = 1L;
	private String title;		// 영화제목
	private String director; 	// 제작자
	private int releaseYear; 	// 개봉년도
		
	}
