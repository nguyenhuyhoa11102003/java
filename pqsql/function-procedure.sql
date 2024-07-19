SET SERVEROUTPUT ON;


/* FUNCTION */

CREATE OR REPLACE FUNCTION calculateCircleRadius(r NUMBER)
RETURN NUMBER
IS
    pi CONSTANT NUMBER := 3.14;
    area NUMBER;
    
BEGIN 
    area := pi * r * r;
    RETURN area;
END;

DECLARE 
    r NUMBER;
BEGIN
    r := &input;
    DBMS_OUTPUT.PUT_LINE('The area of circle whose radius = ' || r || ' is: ' || calculateCircleRadius(r));
END;


/* PROCEDURE */
CREATE OR REPLACE PROCEDURE pr_calculateCircleRadius(r NUMBER)
IS
    pi CONSTANT NUMBER := 3.14;
    area NUMBER;
BEGIN
    area := pi * r * r;
    DBMS_OUTPUT.PUT_LINE('The area of circle whose radius = ' || r || ' is: ' || area);
END;

EXEC pr_calculateCircleRadius(3);



/* NOTATION IN SUBROUTINES */
-- Notation cho phép s? d?ng giá tr? m?c ??nh trong các tham s? c?a hàm khi nó không ???c truy?n vô
CREATE OR REPLACE FUNCTION calculateSum(a NUMBER DEFAULT 0, b NUMBER DEFAULT 0, c NUMBER DEFAULT 0)
RETURN NUMBER
IS
    total NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('a = ' || a);
    DBMS_OUTPUT.PUT_LINE('b = ' || b);
    DBMS_OUTPUT.PUT_LINE('c = ' || c);
    
    total := a+b+c;
    return total;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('sum = ' || calculateSum(b => 2, c => 3));
    DBMS_OUTPUT.PUT_LINE('sum = ' || calculateSum(a => 1, c => 3));
    DBMS_OUTPUT.PUT_LINE('sum = ' || calculateSum(a => 1, b => 2));
    DBMS_OUTPUT.PUT_LINE('sum = ' || calculateSum(a => 1, b => 2, c => 3));
END;
/


