--BOOK 테이블의 ID는 따로 입력하지 않아도 자동으로 부여되면 좋겠음 -> SEQUENCE 쓰자
CREATE SEQUENCE BOOK_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

DROP SEQUENCE BOOK_ID_SEQ;

DROP TABLE BOOK;
--BOOK 테이블 만들기
CREATE TABLE BOOK (
    ID              NUMBER(10)         DEFAULT BOOK_ID_SEQ.NEXTVAL PRIMARY KEY,--도서관에 존재하는 책ID를 고유의 값으로 지정
    TITLE           VARCHAR2(1000)     NOT NULL, --TITLE은 입력해줘야함
    AUTHOR          VARCHAR2(1000)     NOT NULL, --AUTHOR는 입력해줘야함
    PUBLISHER       VARCHAR2(1000)     NOT NULL, --PUBLISHER는 입력해줘야함
    LENDPOSSIBLE    VARCHAR2(100)      DEFAULT '대출가능'    --대출이 가능하면 "대출가능", 불가능하면 "대출불가"이고 디폴트 "대출가능"로 설정
    );
    
SELECT * FROM BOOK;

--BOOK 테이블에
--1,EPL에서골넣는법,엘링홀란드,맨체스터시티,1
INSERT INTO BOOK(TITLE, AUTHOR, PUBLISHER) VALUES ('EPL에서 골 넣는 법', '엘링 홀란드', '맨체스터 시티');
COMMIT;
--2,EPL에서어시스트하는법, 케빈더브라위너, 맨체스터시티,1
--3,라리가에서골넣는법,로베르트레반도프스키,FC바르셀로나,1
--4,라리가에서어시스트하는법,앙투안그리즈만,AT마드리드,1
--5,분데스리가에서골넣는법,니클라스퓔크루,베르더브레멘,,1
--6,분데스리가에서어시스트하는법,랜달콜로무아니,프랑크푸르트,1
--7,세리에A에서골넣는법,빅터오시멘,나폴리,1
--8,세리에A에서어시스트하는법,크비차크바라트스켈리아,나폴리,1
--9,리그앙에서골넣는법,조나단데이빗,릴,1
--10,리그앙에서어시스트하는법,리오넬메시,파리생제르맹,1
--11,K리그에서골넣는법,조규성,전북현대모터스,1
--12,K리그에서어시스트하는법,이기제,수원삼성블루윙즈,1

DROP SEQUENCE MEMBER_ID_SEQ;
--MEMBER 테이블의 ID는 따로 입력하지 않아도 자동으로 부여되면 좋겠음 -> SEQUENCE 쓰자
CREATE SEQUENCE MEMBER_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;


--MEMBER 테이블 만들기
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    ID              NUMBER(10)       DEFAULT MEMBER_ID_SEQ.NEXTVAL PRIMARY KEY, --도서관의 회원ID를 고유의 값으로 지정   
    NAME            VARCHAR2(1000)   NOT NULL,  --MEMBER의 NAME은 입력해줘야함
    ADDRESS         VARCHAR2(1000)   NOT NULL, --MEMBER의 ADDRESS는 입력해줘야함
    PHONENUMBER     VARCHAR2(12)     CONSTRAINT PHONENUMBER_CK CHECK (LENGTH(PHONENUMBER) = 11) UNIQUE, --UNIQUE로 하면, 자기 폰이 없는 자녀가 부모 폰번호를 입력할수없긴함
    BIRTHDAY        DATE             CONSTRAINT BIRTHDAY_CK CHECK (BIRTHDAY = TO_DATE(TO_CHAR(BIRTHDAY, 'YYYY/MM/DD'), 'YYYY/MM/DD')),
    MEMBERDAY       DATE             DEFAULT SYSDATE, --오늘 날짜로 디폴트
    LENDPOSSIBLE    VARCHAR2(100)     DEFAULT '대출가능회원'  --대출이 가능하면 '대출가능회원', 불가능하면 '대출불가회원'이고 디폴트 1로 설정
    );
    
SELECT * FROM MEMBER;

INSERT INTO MEMBER(NAME, ADDRESS, PHONENUMBER, BIRTHDAY) VALUES ('손흥민', '강원도 춘천시', '01098890001', '1992/07/08');
INSERT INTO MEMBER(NAME, ADDRESS, PHONENUMBER, BIRTHDAY) VALUES ('은골로 캉테', '프랑스 파리', '01098890002', '1991/03/29');
INSERT INTO MEMBER(NAME, ADDRESS, PHONENUMBER, BIRTHDAY) VALUES ('파블로 가비', '안달루시아 세비야', '01098890003', '2004/08/05');

COMMIT;
--대출 테이블의 ID는 따로 입력하지 않아도 자동으로 부여되면 좋겠음 -> SEQUENCE 쓰자
CREATE SEQUENCE LEND_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

--대출 테이블 만들기
CREATE TABLE LEND (
    ID                                       NUMBER(10)       DEFAULT LEND_ID_SEQ.NEXTVAL PRIMARY KEY,
    LENDDAY /*대출날짜, 오늘 날짜로*/           DATE             DEFAULT SYSDATE, --오늘날짜로 대출날짜 고정
    EXPRETURNDAY /*반납예정일*/                DATE             DEFAULT SYSDATE + 7,
    EXPRETURNCOUNT /*반납 연장할 수 있는 횟수*/  VARCHAR(10)      DEFAULT 1,
    LENDMEMBERID                             NUMBER(10)        NOT NULL,
    LENDBOOKID                               NUMBER(10)        NOT NULL
    );
    
SELECT * FROM LEND;
    