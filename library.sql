--BOOK ���̺��� ID�� ���� �Է����� �ʾƵ� �ڵ����� �ο��Ǹ� ������ -> SEQUENCE ����
CREATE SEQUENCE BOOK_ID_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE;

--BOOK ���̺� �����
CREATE TABLE BOOK (
    ID              NUMBER(10)        DEFAULT BOOK_ID_SEQ.NEXTVAL PRIMARY KEY,--�������� �����ϴ� åID�� ������ ������ ����
    TITLE           VARCHAR2(1000)    NOT NULL,
    AUTHOR          VARCHAR2(1000)    NOT NULL,
    PUBLISHER       VARCHAR2(1000)    NOT NULL,
    LENDPOSSIBLE    NUMBER(10)        DEFAULT 1
    );
    

    