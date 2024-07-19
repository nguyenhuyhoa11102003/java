set serveroutput on;

select * from person;

insert into person values(1 , 'hh1');
insert into person values(2 , 'hh2');

/* select into */
declare
    type fullname is table of person.name%type;
    v_name fullname;
begin
    select name bulk collect into v_name
    from person;
    
    for i in 1..v_name.count
    loop
        dbms_output.put_line('Name ' || i || ': ' || v_name(i));
    end loop;
end;

/* fetch into */

declare 
    cursor my_cursor is select name from product ;
    type product_name is table of product.name%type;    
    v_pname product_name;
begin
    open my_cursor;
    loop 
        fetch my_cursor bulk collect into v_pname;
        exit when v_pname.count =  0 ;
        
        for i in v_pname.first .. v_pname.last
        loop 
            dbms_output.put_line(i || '. ' || v_pname(i));
        end loop;
        
    end loop;
    close my_cursor;
end;

/* limit */
declare
    cursor my_cursor is select name from product;
    type product_name is table of product.name%type;
    v_pname product_name;
begin
    open my_cursor;
    fetch my_cursor bulk collect into v_pname limit 3;
    close my_cursor;
    
    for i in 1 .. v_pname.count
    loop
        dbms_output.put_line(i || '. ' || v_pname(i));
    end loop;
end;


select * from product;
select * from person

