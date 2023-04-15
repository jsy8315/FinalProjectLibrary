--BOOK 테이블의 ID는 따로 입력하지 않아도 자동으로 부여되면 좋겠음 -> SEQUENCE 쓰자
CREATE SEQUENCE BOOK_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

--BOOK 테이블 만들기
CREATE TABLE BOOK (
    ID              NUMBER(100)        DEFAULT BOOK_ID_SEQ.NEXTVAL PRIMARY KEY,--도서관에 존재하는 책ID를 고유의 값으로 지정
    TITLE           VARCHAR2(1000)     NOT NULL, --TITLE은 입력해줘야함
    AUTHOR          VARCHAR2(1000)     NOT NULL, --AUTHOR는 입력해줘야함
    PUBLISHER       VARCHAR2(1000)     NOT NULL, --PUBLISHER는 입력해줘야함
    LENDPOSSIBLE    NUMBER(10)         DEFAULT 1    --대출이 가능하면 1, 불가능하면 0이고 디폴트 1로 설정
    );
    
SELECT * FROM BOOK;

--MEMBER 테이블의 ID는 따로 입력하지 않아도 자동으로 부여되면 좋겠음 -> SEQUENCE 쓰자
CREATE SEQUENCE MEMBER_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

--MEMBER 테이블 만들기
CREATE TABLE MEMBER (
    ID              NUMBER(10)      DEFAULT MEMBER_ID_SEQ.NEXTVAL PRIMARY KEY, --도서관의 회원ID를 고유의 값으로 지정   
    NAME            VARCHAR2(1000)   NOT NULL,  --MEMBER의 NAME은 입력해줘야함
    ADDRESS         VARCHAR2(1000)   NOT NULL, --MEMBER의 ADDRESS는 입력해줘야함
    PHONENUMBER     VARCHAR2(12)         CONSTRAINT PHONENUMBER_CK CHECK (LENGTH(PHONENUMBER) = 11) UNIQUE, --UNIQUE로 하면, 자기 폰이 없는 자녀가 부모 폰번호를 입력할수없긴함
    BIRTHDAY        DATE             CONSTRAINT BIRTHDAY_CK CHECK (BIRTHDAY = TO_DATE(TO_CHAR(BIRTHDAY, 'YYYY/MM/DD'), 'YYYY/MM/DD')),
    MEMBERDAY       DATE             DEFAULT SYSDATE,
    LENDPOSSIBLE    NUMBER(10)       DEFAULT 1  --대출이 가능하면 1, 불가능하면 0이고 디폴트 1로 설정
    );
    
SELECT * FROM MEMBER;