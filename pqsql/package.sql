SET SERVEROUTPUT ON;


-- Package contains headers
CREATE OR REPLACE PACKAGE pkg_mypackage 
IS 
    FUNCTION fn_calculateSum(a NUMBER, b NUMBER) RETURN NUMBER;
    PROCEDURE pr_sayHello(name VARCHAR2);

END pkg_mypackage;

-- Package contains body (implement)
CREATE OR REPLACE PACKAGE BODY pkg_mypackage
IS
    FUNCTION fn_calculateSum(a NUMBER, b NUMBER)
    RETURN NUMBER
    IS
    BEGIN
        RETURN a+b;
    END;
    
    PROCEDURE pr_sayHello(name VARCHAR2)
    IS
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Hello: ' || name);
    END;
END pkg_mypackage;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Test function in package: ' || pkg_mypackage.fn_calculateSum(3, 5));
    DBMS_OUTPUT.PUT_LINE('Test procedure in package: ');
    pkg_mypackage.pr_sayHello('HD Bank');
END;