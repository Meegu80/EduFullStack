# STS3-Spring 초반 세팅

2024.07.08 스프링 MVC 프로젝트 기본

1. chap05_controller_param 프로젝트 생성
 1) 탑레벨 패키지 : com.javalab.board
 
2. 빌드 패스 설정 
 1) Project facets : java, servlet 버전 변경
 - jdk 11, servelt 4.0, javascript 추가
 2) Targeted Runtime
 - 생성한 프로젝트와 톰캣을 연결 설정
 3) Web project settings 컨텍스트 패스 설정
 - "/" 설정 : URL 짧게 줄여서 쓰기 위함.
 
3. 메이븐이 사용하는 라이브러리 명세서인 pom.xml 수정 작업
 1) <java-version>11</java-version>
 2) <org.springframework-version>5.0.7.RELEASE</org.springframework-version>
 3) <source>11</source> <target>11</target> 플러그인 버전 변경

4. 프로젝트 실행해서 초기페이 오픈 -> 프로젝트 사용 OK

5. 로그 설정 의존성 추가
 1) logback 의존성
 2) log4jdbc 의존성 

6. 로그백 환경설정 파일 복사
 1) logback.xml
 2) log4jdbc.properties
 
프로젝트 기본 설정 완료!

7.프로젝트 구동
 1) web.xml : 프로젝트 구동시 가장 먼저 읽혀지는 환경설정파일
 - 서브릿 컨테이너(톰캣,WAS)가 읽어들여서 애플리케이션 어떻게 초기화 할지 파악한다.
 2) ContextLoaderListener 
  - 루트 컨테이너(루트 컨텍스트) 를 생성한다.
  - root-context.xml을 읽어들여서 다음 빈들을 생성한다.
    @Service, @Repository, 매퍼인터페이스의 프록시, 
    SqlSessionFactory 빈, SqlSessionTemplate 빈
 3) DispatcherServlet
 - 자식 컨테이너를 생성한다.
 - servelt-context.xml을 읽어들여서 스프링 MVC 관련된 빈들을 생성한다. 
   @Controller, RequestMappingHandlerMapping, RequestMappingHandlerAdapter,
   InternalResourceViewResolver
   
 
