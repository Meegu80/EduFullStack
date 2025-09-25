package com.javalab.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/******************************************************************
 * 앨범 자바빈즈(도메인 클래스)
 * @author  홍길동
 * 2024.06.11
 * 앨범정보를 저장하는 자바빈즈
 * - 롬복 애노테이션으로 간단하게 구현
 * - 자바빈즈의 직렬화시 안정성 확보 
  ******************************************************************/

// 롬복 어노테이션 - 메타데이터
@NoArgsConstructor			//기본생성자
@AllArgsConstructor			//오버로딩생성자
@Getter							
@Setter
@ToString
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;		// 도서제목
	private String artist; 	// 제작자
	private int releaseYear; 	//
	
	
}
