SET SERVEROUTPUT ON;

-- USING EXCEPTION VARIABLE
DECLARE
    a NUMBER;
    b  NUMBER;
    ex EXCEPTION;
    
BEGIN
     a := &a;
    b := &b;
    
    IF b = 0  THEN
        RAISE ex;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(a || ' / ' || b || ' = ' || a/b);
    
EXCEPTION  WHEN ex THEN
    DBMS_OUTPUT.PUT_LINE('Cannot devide by zero!!');
END;


-- USING RAISE_APPLICATION_ERROR
-- Custom dialog input message
ACCEPT a NUMBER PROMPT 'Enter a: ';
ACCEPT b NUMBER PROMPT 'Enter b: ';
DECLARE
    a NUMBER;
    b NUMBER;
BEGIN
    a := &a;
    b := &b;
    
    IF b = 0 THEN
        RAISE_APPLICATION_ERROR(-20008, 'Cannot devide by zero!');
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(a || ' / ' || b || ' = ' || a/b);
    
EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
