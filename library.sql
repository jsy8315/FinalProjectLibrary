--BOOK ���̺��� ID�� ���� �Է����� �ʾƵ� �ڵ����� �ο��Ǹ� ������ -> SEQUENCE ����
CREATE SEQUENCE BOOK_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

--BOOK ���̺� �����
CREATE TABLE BOOK (
    ID              NUMBER(100)        DEFAULT BOOK_ID_SEQ.NEXTVAL PRIMARY KEY,--�������� �����ϴ� åID�� ������ ������ ����
    TITLE           VARCHAR2(1000)     NOT NULL, --TITLE�� �Է��������
    AUTHOR          VARCHAR2(1000)     NOT NULL, --AUTHOR�� �Է��������
    PUBLISHER       VARCHAR2(1000)     NOT NULL, --PUBLISHER�� �Է��������
    LENDPOSSIBLE    NUMBER(10)         DEFAULT 1    --������ �����ϸ� 1, �Ұ����ϸ� 0�̰� ����Ʈ 1�� ����
    );
    
SELECT * FROM BOOK;

--MEMBER ���̺��� ID�� ���� �Է����� �ʾƵ� �ڵ����� �ο��Ǹ� ������ -> SEQUENCE ����
CREATE SEQUENCE MEMBER_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

--MEMBER ���̺� �����
CREATE TABLE MEMBER (
    ID              NUMBER(10)      DEFAULT MEMBER_ID_SEQ.NEXTVAL PRIMARY KEY, --�������� ȸ��ID�� ������ ������ ����   
    NAME            VARCHAR2(1000)   NOT NULL,  --MEMBER�� NAME�� �Է��������
    ADDRESS         VARCHAR2(1000)   NOT NULL, --MEMBER�� ADDRESS�� �Է��������
    PHONENUMBER     VARCHAR2(12)         CONSTRAINT PHONENUMBER_CK CHECK (LENGTH(PHONENUMBER) = 11) UNIQUE, --UNIQUE�� �ϸ�, �ڱ� ���� ���� �ڳడ �θ� ����ȣ�� �Է��Ҽ�������
    BIRTHDAY        DATE             CONSTRAINT BIRTHDAY_CK CHECK (BIRTHDAY = TO_DATE(TO_CHAR(BIRTHDAY, 'YYYY/MM/DD'), 'YYYY/MM/DD')),
    MEMBERDAY       DATE             DEFAULT SYSDATE,
    LENDPOSSIBLE    NUMBER(10)       DEFAULT 1  --������ �����ϸ� 1, �Ұ����ϸ� 0�̰� ����Ʈ 1�� ����
    );
    
SELECT * FROM MEMBER;