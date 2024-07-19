SET SERVEROUTPUT ON;


CREATE TABLE product
(
    id NUMBER GENERATED ALWAYS AS IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR2(100),
    price FLOAT
);

INSERT INTO product (name, price) VALUES ('Milk', 10.2);
INSERT INTO product (name, price) VALUES ('Candy', 1.1);
INSERT INTO product (name, price) VALUES ('Meat', 36.3);
INSERT INTO product (name, price) VALUES ('Egg', 5.7);
INSERT INTO product (name, price) VALUES ('Fish', 21.12);
SELECT * FROM product;



/*CURSOR without parameter*/
DECLARE 
    v_temp VARCHAR2(100);
    CURSOR my_cursor IS (SELECT name FROM product);
BEGIN
    OPEN my_cursor;
    LOOP 
        FETCH my_cursor INTO v_temp;
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_temp);
    END LOOP;
    CLOSE my_cursor;
END;

/* CURSOR WITH PARAMETER */
DECLARE
    v_temp VARCHAR2(100);
    CURSOR my_cursor (p FLOAT := 5) IS (SELECT name FROM product WHERE price >= p);
BEGIN
    OPEN my_cursor (10.0);
    LOOP
        FETCH my_cursor INTO v_temp;
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_temp);
    END LOOP;
    CLOSE my_cursor;
END;
    
    
/*CURSOR WITH FOR LOOP*/
DECLARE 
    CURSOR my_cursor IS SELECT * FROM product;
BEGIN
    FOR p IN my_cursor
    LOOP
        DBMS_OUTPUT.PUT_LINE(p.id || ', ' || p.name || ', ' || p.price);
    END LOOP;
END;
