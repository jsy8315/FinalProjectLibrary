--BOOK ���̺��� ID�� ���� �Է����� �ʾƵ� �ڵ����� �ο��Ǹ� ������ -> SEQUENCE ����
CREATE SEQUENCE BOOK_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

DROP SEQUENCE BOOK_ID_SEQ;

DROP TABLE BOOK;
--BOOK ���̺� �����
CREATE TABLE BOOK (
    ID              NUMBER(10)         DEFAULT BOOK_ID_SEQ.NEXTVAL PRIMARY KEY,--�������� �����ϴ� åID�� ������ ������ ����
    TITLE           VARCHAR2(1000)     NOT NULL, --TITLE�� �Է��������
    AUTHOR          VARCHAR2(1000)     NOT NULL, --AUTHOR�� �Է��������
    PUBLISHER       VARCHAR2(1000)     NOT NULL, --PUBLISHER�� �Է��������
    LENDPOSSIBLE    VARCHAR2(100)      DEFAULT '���Ⱑ��'    --������ �����ϸ� "���Ⱑ��", �Ұ����ϸ� "����Ұ�"�̰� ����Ʈ "���Ⱑ��"�� ����
    );
    
SELECT * FROM BOOK;

--BOOK ���̺�
--1,EPL������ִ¹�,����Ȧ����,��ü���ͽ�Ƽ,1
INSERT INTO BOOK(TITLE, AUTHOR, PUBLISHER) VALUES ('EPL���� �� �ִ� ��', '���� Ȧ����', '��ü���� ��Ƽ');
COMMIT;
--2,EPL������ý�Ʈ�ϴ¹�, �ɺ���������, ��ü���ͽ�Ƽ,1
--3,�󸮰�������ִ¹�,�κ���Ʈ���ݵ�����Ű,FC�ٸ����γ�,1
--4,�󸮰�������ý�Ʈ�ϴ¹�,�����ȱ׸��,AT���帮��,1
--5,�е�������������ִ¹�,��Ŭ��Ǹũ��,�������극��,,1
--6,�е�������������ý�Ʈ�ϴ¹�,�����ݷι��ƴ�,����ũǪ��Ʈ,1
--7,������A������ִ¹�,���Ϳ��ø�,������,1
--8,������A������ý�Ʈ�ϴ¹�,ũ����ũ�ٶ�Ʈ���̸���,������,1
--9,���׾ӿ�����ִ¹�,�����ܵ��̺�,��,1
--10,���׾ӿ�����ý�Ʈ�ϴ¹�,�����ڸ޽�,�ĸ���������,1
--11,K���׿�����ִ¹�,���Լ�,����������ͽ�,1
--12,K���׿�����ý�Ʈ�ϴ¹�,�̱���,�����Ｚ�������,1

DROP SEQUENCE MEMBER_ID_SEQ;
--MEMBER ���̺��� ID�� ���� �Է����� �ʾƵ� �ڵ����� �ο��Ǹ� ������ -> SEQUENCE ����
CREATE SEQUENCE MEMBER_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;


--MEMBER ���̺� �����
DROP TABLE MEMBER;

CREATE TABLE MEMBER (
    ID              NUMBER(10)       DEFAULT MEMBER_ID_SEQ.NEXTVAL PRIMARY KEY, --�������� ȸ��ID�� ������ ������ ����   
    NAME            VARCHAR2(1000)   NOT NULL,  --MEMBER�� NAME�� �Է��������
    ADDRESS         VARCHAR2(1000)   NOT NULL, --MEMBER�� ADDRESS�� �Է��������
    PHONENUMBER     VARCHAR2(12)     CONSTRAINT PHONENUMBER_CK CHECK (LENGTH(PHONENUMBER) = 11) UNIQUE, --UNIQUE�� �ϸ�, �ڱ� ���� ���� �ڳడ �θ� ����ȣ�� �Է��Ҽ�������
    BIRTHDAY        DATE             CONSTRAINT BIRTHDAY_CK CHECK (BIRTHDAY = TO_DATE(TO_CHAR(BIRTHDAY, 'YYYY/MM/DD'), 'YYYY/MM/DD')),
    MEMBERDAY       DATE             DEFAULT SYSDATE, --���� ��¥�� ����Ʈ
    LENDPOSSIBLE    VARCHAR2(100)     DEFAULT '���Ⱑ��ȸ��'  --������ �����ϸ� '���Ⱑ��ȸ��', �Ұ����ϸ� '����Ұ�ȸ��'�̰� ����Ʈ 1�� ����
    );
    
SELECT * FROM MEMBER;

INSERT INTO MEMBER(NAME, ADDRESS, PHONENUMBER, BIRTHDAY) VALUES ('�����', '������ ��õ��', '01098890001', '1992/07/08');
INSERT INTO MEMBER(NAME, ADDRESS, PHONENUMBER, BIRTHDAY) VALUES ('����� Ĳ��', '������ �ĸ�', '01098890002', '1991/03/29');
INSERT INTO MEMBER(NAME, ADDRESS, PHONENUMBER, BIRTHDAY) VALUES ('�ĺ�� ����', '�ȴ޷�þ� �����', '01098890003', '2004/08/05');

COMMIT;
--���� ���̺��� ID�� ���� �Է����� �ʾƵ� �ڵ����� �ο��Ǹ� ������ -> SEQUENCE ����
CREATE SEQUENCE LEND_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

--���� ���̺� �����
CREATE TABLE LEND (
    ID                                       NUMBER(10)       DEFAULT LEND_ID_SEQ.NEXTVAL PRIMARY KEY,
    LENDDAY /*���⳯¥, ���� ��¥��*/           DATE             DEFAULT SYSDATE, --���ó�¥�� ���⳯¥ ����
    EXPRETURNDAY /*�ݳ�������*/                DATE             DEFAULT SYSDATE + 7,
    EXPRETURNCOUNT /*�ݳ� ������ �� �ִ� Ƚ��*/  VARCHAR(10)      DEFAULT 1,
    LENDMEMBERID                             NUMBER(10)        NOT NULL,
    LENDBOOKID                               NUMBER(10)        NOT NULL
    );
    
SELECT * FROM LEND;
    