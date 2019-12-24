KNU Folio
==========

README: [한국어](README.ko.md), [English](README.md)  

</br>

설명
----------

이 프로젝트는 데이터베이스 수업의 기말 과제입니다.  

KNU Folio는 학생들이 자신들의 포트폴리오를 관리할 수 있도록 도와주는 웹 서비스입니다.  

이 프로젝트는 **Java, JDBC, JSP, Servlet, Oracle Database Server**가 필요합니다.

</br>

ER 다이어그램
----------

![ER_Diagram](https://user-images.githubusercontent.com/33472400/71419654-da330680-26b3-11ea-9071-d68ec04c02b5.png)

</br>

전제 조건
----------

- [Apache Tomcat](http://tomcat.apache.org/) v8.0 or higher (로컬 컴퓨터와 이클립스에 아파치 톰캣이 설치되있어야 합니다.)  

- [Oracle Database](https://www.oracle.com/database/technologies/) (이 프로젝트에서는 Oracle Database 11g가 사용되었습니다.)  

- JDBC (**이클립스는 반드시 오라클 JDBC 드라이버와 연결되있어야 합니다.**)

</br>

설치
----------

1. 데이터베이스에 아래의 쿼리를 실행해주세요.
    
    <details>
    <summary>Query</summary>
    <p>
    
    ```
    create table members(id varchar(32) primary key, password varchar(32), student_number int unique, student_name varchar2(32), degree int, major_name varchar2(32));
    create table competition(id varchar2(32) references members(id) on delete cascade, competition_name varchar2(64), prize varchar(32), competition_date date);
    create table internship(id varchar2(32) references members(id) on delete cascade, company_name varchar2(64), start_date date, end_date date);
    create table volunteer(id varchar2(32) references members(id) on delete cascade, volunteer_name varchar2(64), start_date date, end_date date);
    create table rest(id varchar2(32) references members(id) on delete cascade, start_date date, end_date date);
    create table multipleMajor(id varchar2(32) references members(id) on delete cascade, major_name varchar2(32));
    create table passedCompany(id varchar2(32) references members(id) on delete cascade, company_name varchar2(64));
    create table interviewQuestion(id varchar2(32) references members(id) on delete cascade, company_name varchar2(64), question varchar2(4000));
    create table classes(class_code varchar2(32) primary key, class_name varchar2(64));
    create table took(id varchar2(32) references members(id) on delete cascade, class_code varchar2(32) references classes(class_code), class_name varchar2(64), grade varchar2(8));
    create table clubs(club_name varchar2(64) primary key);
    create table participating(id varchar2(32) references members(id) on delete cascade, club_name varchar2(64) references clubs(club_name), start_date date, end_date date);
    create table licenses(license_name varchar2(64) primary key);
    create table has(id varchar2(32) references members(id) on delete cascade, license_name varchar2(64) references licenses(license_name), score int);
    create table article(id varchar2(32) references members(id) on delete cascade, article_number int primary key, article_name varchar2(256), author varchar(32), write_date date);

    insert into classes values('CLTR003003','실용화법');
    insert into classes values('CLTR264001','소셜네트워크');
    insert into classes values('COME301011','이산수학');
    insert into classes values('COMP204001','프로그래밍기초');
    insert into classes values('COMP205002','기초창의공학설계');
    insert into classes values('CLTR043008','서양의역사와문화');
    insert into classes values('COME311004','확률및통계');
    insert into classes values('COME331010','자료구조');
    insert into classes values('COMP224004','소프트웨어설계');
    insert into classes values('COMP432001','소프트웨어특강');
    insert into classes values('ELEC462002','시스템프로그래밍');
    insert into classes values('ITEC423001','자료구조프로그래밍');
    insert into classes values('MTED231001','선형대수');
    insert into classes values('CLTR639002','디자인과 현대문화');
    insert into classes values('COMP320001','알고리즘2');
    insert into classes values('COMP322001','데이타베이스');
    insert into classes values('COMP323001','데이타통신');
    insert into classes values('COMP328003','모바일앱프로그래밍1');
    insert into classes values('COMP423001','프로그래밍언어론');
    insert into classes values('ITEC401003','종합설계프로젝트1');
    insert into classes values('STAT452010','수치해석');
    insert into classes values('TCHR593001','컴퓨터교육론');
    insert into classes values('TCHR594001','컴퓨터교재연구및지도법');
    insert into classes values('COME368001','정보보호론');
    insert into classes values('COMP424001','무선네트워크');
    insert into classes values('COMP427001','병렬프로그래밍');
    insert into classes values('COMP428001','IT기술경영개론');
    insert into classes values('COMP435001','디지털미디어아트');
    insert into classes values('COMP436001','증강현실');
    insert into classes values('COMP437001','의료정보학시스템');
    insert into classes values('ITEC402016','종합설계프로젝트2');

    insert into clubs values('KERT');
    insert into clubs values('PROG');
    insert into clubs values('산사랑');
    insert into clubs values('작은몸짓');
    insert into clubs values('그루터기');
    insert into clubs values('러블리앤커뮤니케이션');
    insert into clubs values('DIGITAL_MIDIA_ART');
    insert into clubs values('VIC');
    insert into clubs values('REVOLUTION');
    insert into clubs values('ADMIN');
    insert into clubs values('GORI');

    insert into licenses values('TOEIC');
    insert into licenses values('TOEIC Speaking');
    insert into licenses values('TOEIC Writing');
    insert into licenses values('TOEFL');
    insert into licenses values('TEPS');
    insert into licenses values('IELTS');
    insert into licenses values('OPIc');
    insert into licenses values('SAT');
    insert into licenses values('JLPT');
    insert into licenses values('베트남어');
    insert into licenses values('프랑스어');
    insert into licenses values('한국사');
    insert into licenses values('중국어');
    insert into licenses values('멀티미디어콘텐츠제작전문가');
    insert into licenses values('사무자동화산업기사');
    insert into licenses values('전자계산기조직응용기사');
    insert into licenses values('정보관리기술사');
    insert into licenses values('정보기기운용기능사');
    insert into licenses values('정보처리기능사');
    insert into licenses values('정보처리기사');
    insert into licenses values('정보처리산업기사');
    insert into licenses values('컴퓨터시스템응용기술사');
    ```
    </p>
    </details>

2. 이 프로젝트를 이클립스에서 복제하고, 이클립스에서 아파치 톰캣 서버로 실행해주세요.  

    ![Installation_1](https://user-images.githubusercontent.com/33472400/71420077-82e26580-26b6-11ea-9eaf-3a993c5abb19.png)

3. [http://localhost:8080/DatabaseProject/index.jsp](http://localhost:8080/DatabaseProject/index.jsp)에 접속해주세요.

</br>

데모 영상
----------

[<img src="http://img.youtube.com/vi/PIJWqJt30p8/0.jpg" width="600">](http://www.youtube.com/watch?v=PIJWqJt30p8)
