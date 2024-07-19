set serveroutput on;

/* execute immediate with into  */
declare
    sql_qry varchar2(100);
    total number;
begin
    sql_qry := 'select count(*) from product';
    execute immediate sql_qry into total;
    dbms_output.put_line('Total products is: ' || total);
end;

/* execute immediate with using */
declare
    ddl_qry varchar2(200);
begin
    ddl_qry := 'insert into fraction values(:numerator, :denominator)';
    execute immediate ddl_qry using 1 , 2;
end;

/* execute immediate ddl statement */
declare 
    ddl_qry varchar2(200);
begin
    ddl_qry := 'create table fraction(
                  numerator number,
                  denominator number
                )';
    
    execute immediate ddl_qry;
end;
desc fraction;

/* execute immediate plsql block */
declare
    plsql varchar2(300);
begin
    plsql := '  declare
                    v_current_user varchar2(20);
                begin
                    select user into v_current_user from dual;
                    dbms_output.put_line(''Current user is: '' || v_current_user);
                end;';
    execute immediate plsql;
end;


/* execute immediate bulk collect */
declare
    type associative_array is table of varchar2(100);
    pname associative_array;
    sql_qry varchar2(200);
begin
    -- G?p l?i do bulk collect into ph?i ???c th?c thi trong kh?i l?nh begin...end
--    sql_qry := 'select pname bulk collect into pname from product';
--    execute immediate sql_qry;

    sql_qry := 'select name from product';
    execute immediate sql_qry bulk collect into pname;
    
    for i in 1..pname.count loop
        dbms_output.put_line(i || '. ' || pname(i));
    end loop;

end;


