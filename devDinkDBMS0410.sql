--SQL���� ������ ���
SELECT ENAME, COMM, COMM + 300 FROM EMP;

--ALIAS, AS, Ư������, ���鹮��, ��ҹ��� ������ �ʿ��� ��� " " ���
SELECT ENAME, MGR Manager, SAL * 12 AS annual_SAL, COMM + 300 "Special Bonus" FROM EMP;

--���ڿ� ���� ���� ����ǥ
SELECT ENAME||'"s JOB is '||job as job_list FROM EMP;

--���� Ÿ�԰� ���� Ÿ���� ����, ���� Ÿ���� ���ڷ� ����ȯ, TO_CHAR �Ἥ ��Ȯ�ϰ� ���ִ°� �ǰ�
SELECT SAL, SAL * 100, SAL||'00', TO_CHAR(SAL)||'00' FROM EMP;

--system�� ���� date(��¥�� �ð�)�� ����
SELECT SYSDATE FROM DUAL;

--WHERE: ���ϴ� ROW�� ��ȸ�ϴ� ������
SELECT DEPTNO, ENAME, SAL, JOB FROM EMP 
    WHERE (DEPTNO, JOB, MGR) = ((10, 'MANAGER', '7839'));
    
--NVL : NULL �����Լ�
SELECT COMM, NVL(COMM, 0) FROM EMP;

--DECODE 
SELECT DECODE(C0MM, NULL, 0, COMM) AS NVL_SIMUL FROM EMP;

--ASC�� ��������, DESC�� ��������
SELECT DEPTNO, JOB, ENAME FROM EMP ORDER BY DEPTNO, JOB;

--DISTINCT : �ߺ��� �����͸� ���͸�
SELECT JOB FROM EMP;
SELECT DISTINCT JOB FROM EMP;
--DEPTNO, JOB �������� �ߺ��� ����
SELECT DISTINCT DEPTNO, JOB FROM EMP;

--BETWEEN ���� ������
SELECT ENAME, SAL, HIREDATE FROM EMP WHERE SAL BETWEEN 1000 AND 2000;
SELECT ENAME, SAL, HIREDATE FROM EMP WHERE ENAME BETWEEN 'C' AND 'K';

--LIKE ��Ȯ�� ���� ���� ã�� �� �ִ� ���� ���� ��Ī ������ : '%'�� 0�� �̻��� ��� ����, '_'�� 1���� ��� ����, ��ġ�� �ǹ̸� ����
SELECT ENAME FROM EMP WHERE ENAME LIKE 'A%';
SELECT ENAME FROM EMP WHERE ENAME LIKE '%L%E%';
SELECT ENAME FROM EMP WHERE ENAME LIKE '%LE%';
SELECT ENAME FROM EMP WHERE ENAME LIKE '_A%';

--IN ����Ʈ ������ : Ư�� ���� ���� ���� �� �� �ϳ��� ��ġ�ϴ� ��쿡 �ش� ���� ��ȯ��
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE (JOB, DEPTNO) IN (('MANAGER', 20),('CLERK', 20));

--DECODE : ������ ������, =�� ���
SELECT DEPTNO, ENAME, DECODE(DEPTNO, 10, 'ACCOUNTING', 20, 'RESEARCH', 30, 'SALES', 'ETC') FROM EMP ORDER BY DEPTNO;

--CASE :������, DECODE ������ ��� Ȯ�� & ���� ���
SELECT DEPTNO, ENAME, SAL,
    CASE WHEN SAL >= 4800 THEN 'HIGH'
        WHEN SAL BETWEEN 3000 AND 4799 THEN 'MID'
        WHEN SAL <= 2999 THEN 'LOW'
    ELSE 'EXTREMELY_LOW'
    END AS SAL_GRADE
FROM EMP
ORDER BY DEPTNO;

--ROWNUM : SELECT������ ��ȯ�Ǵ� ROW�� ��ȣ�� ��Ÿ���� ���� �÷�
SELECT * FROM EMP WHERE ROWNUM <= 5;

--�Լ�, �Լ��� ��ø����
--SUBSTR(string, position, lengh): ������ ��ġposition������ length���̸�ŭ �κ� ���ڿ��� ��ȯ
SELECT ENAME, SUBSTR(ENAME, 2,3) FROM EMP;

--INSTR : string���� ���ڿ�(pattern)�� ó������ ��Ÿ���� ��ġ(position)�� ��ȯ�ϴ� �Լ�
--INSTR(string, pattern, start_position, occurrence) : start_position�� �˻��� ������ ��ġ�� ��Ÿ����, �⺻���� 1, 
--occurrence�� �˻��� pattern�� ���°�� ��Ÿ������ �����ϴ� ����, �⺻���� 1
SELECT ENAME, INSTR(ENAME, 'A', 2, 1) FROM EMP;

--LENGTH(string) : ���ڿ����� ��ȯ
SELECT LENGTH('���ѹα�'), LENGTH('ABCD') FROM DUAL;

--REPLACE(string, pattern, replacement)
SELECT REPLACE('Hello World', 'World', 'ELON') FROM DUAL;

--TRIM : ���ڿ� ���� ���� �ִ� ���� ����
SELECT TRIM('   HELLO FUCKING TOM BOY    ') FROM DUAL;

--ROUND �Լ� : �ݿø�
SELECT ROUND(42.1299, 2), ROUND(42.9, 0), ROUND(42.28, 1) FROM DUAL;

--TRUNCATE �Լ� : ����
SELECT TRUNC(42.1299, 2), TRUNC(42.12, 1) FROM DUAL;

--DATE TYPE
SELECT SYSDATE FROM DUAL;

--GROUP BY : ���� �÷����� ������ �׷��� ������ �˸� �ڵ� ������ �� ������ : FROM WHERE GROUPBY HAVING SELECT ORDERBY
SELECT DEPTNO, COUNT(*) FROM SCOTT.EMP GROUP BY DEPTNO;
SELECT DEPTNO, AVG(SAL), SUM(SAL) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, AVG(SAL), SUM(SAL) FROM EMP GROUP BY DEPTNO ORDER BY DEPTNO;

--HAVING : GROUP BY ��� ������ ������
SELECT DEPTNO, COUNT(*), SUM(SAL), ROUND(AVG(SAL), 1) FROM EMP GROUP BY DEPTNO;
SELECT DEPTNO, COUNT(*), SUM(SAL), ROUND(AVG(SAL), 1) FROM EMP GROUP BY DEPTNO HAVING SUM(SAL) >= 9000;
SELECT DEPTNO, ROUND(AVG(SAL), 1), SUM(SAL) FROM EMP WHERE DEPTNO IN (10, 20)
GROUP BY DEPTNO
HAVING SUM(SAL) >= 9000
ORDER BY DEPTNO DESC;

