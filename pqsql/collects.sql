set serveroutput on;

DECLARE
    type associative_array is table of number index by varchar2(20);
    arr associative_array;
    current_key varchar2(20);
        
BEGIN
    arr('item 1') := 1000;
    arr('item 2') := 2000;
    arr('item 3') := 3000;
    arr('item 4') := 4000;
    arr('item 5') := 5000;
    
    dbms_output.put_line('Value of item 1 is: ' || arr('item 1'));

    current_key := arr.first;
    WHILE current_key  IS NOT NULL
    LOOP
         dbms_output.put_line('Key ' || current_key || ' has value is ' || arr(current_key));
         current_key := arr.next(current_key);
    END LOOP;

END;



/* varray */

CREATE TYPE obj_varray IS varray(5) of NUMBER;

create table person1
(
    id number not null primary key,
    name varchar2(30),
    favorite_number obj_varray
);

insert into person1 values(1, 'David', obj_varray(88, 72, 99, 12, 3));
insert into person1 values(2, 'John', obj_varray(25, 8));
insert into person1 values(3, 'Anna', obj_varray(46, 87, 61));


select p.id, p.name, temp.column_value as favorite_number
from person1 p, table (p.favorite_number) temp;


/*  S? d?ng procedure extend ?? c?p phát thêm vùng nh? cho varray */

declare
    type my_varray is varray(5) of number;
    numbers my_varray := my_varray();
begin
    numbers.extend;
    numbers(1) := 10;
    dbms_output.put_line('Maximum size: ' || numbers.limit);
end;



    