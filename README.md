# project
과제

1. 이클립스 또는 STS실행 
  - 이클립스 또는 STS 를 다운, 설치 후 해당 프로그램을 실행한 후 borwse 위치는 해당 프로그램 작동폴더에서 실행시킨다(첨부파일 때문에 그럼)

2. 프로젝트 빌드
  - git svn가서 clone a Git repository 클릭 후 URI를 https://github.com/sanghund6039/project.git 으로 설정
  - 생성되었으면 Working Tree > Project 우클릭 후 Import Project 후 Finish

3. server 설치
  - tomcat 9버전 설치

4. db설정 방법
  - src\main\resources\conf\globals.properties 위치에서 내용변경 필요(사용할 db는 오라클)
  - src\main\webapp\resources\info\db테이블 및 컬럼 생성.txt 해당 구역에서 테이블, 시퀀스, 공지사항 내용 넣어둠(데이터)

5. 실행방법
  - 톰캣 설정 마친 후 run as 
  - 관리자페이지 : /auth/login.do
  - 사용자 페이지 : /front/notice.do

모든 설정을 마치고 실행
메일 또는 src\main\webapp\resources\info\화면정의서_공지사항.pptx 로 화면정의서 공유
