--BOOK 테이블의 ID는 따로 입력하지 않아도 자동으로 부여되면 좋겠음 -> SEQUENCE 쓰자
CREATE SEQUENCE BOOK_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

--BOOK 테이블 만들기
CREATE TABLE BOOK (
    ID              NUMBER(10)        DEFAULT BOOK_ID_SEQ.NEXTVAL PRIMARY KEY,--도서관에 존재하는 책ID를 고유의 값으로 지정
    TITLE           VARCHAR2(1000)    NOT NULL,
    AUTHOR          VARCHAR2(1000)    NOT NULL,
    PUBLISHER       VARCHAR2(1000)    NOT NULL,
    LENDPOSSIBLE    NUMBER(10)        DEFAULT 1
    );
    

    