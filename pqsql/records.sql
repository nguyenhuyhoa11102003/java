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


/* Table-based Record Datatype */

DECLARE
    v_product product%ROWTYPE;
BEGIN
    SELECT * INTO v_product FROM PRODUCT
    WHERE id = 3 ;  
    DBMS_OUTPUT.PUT_LINE(v_product.id || ', ' || v_product.name || ', ' || v_product.price);
END;


/* Cursor-Based */

DECLARE
    CURSOR my_cursor  IS SELECT * FROM product;
    v_product my_cursor%ROWTYPE;
BEGIN
    OPEN my_cursor;
    LOOP 
        FETCH my_cursor INTO v_product;
        EXIT WHEN my_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_product.id || ', ' || v_product.name || ', ' || v_product.price);
    END LOOP;
    CLOSE my_cursor;
END;

/* User Defined Record Datatype */
/* Useage : a record whose structure is not based on the existing ones */

DECLARE
    TYPE product_type IS RECORD(
        id product.id%TYPE,
        name product.name%TYPE,
        price product.price%TYPE
    );
    
    v_product product_type;
    
BEGIN
    SELECT * INTO v_product FROM product WHERE id = 3;
    DBMS_OUTPUT.PUT_LINE(v_product.id || ', ' || v_product.name || ', ' || v_product.price);
END;



