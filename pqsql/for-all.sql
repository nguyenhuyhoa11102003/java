set serveroutput on;

create table add_table
(
    val number
);

/* demo 1 */
declare
    type associative_array is table of number;
    v_arr associative_array := associative_array (1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
begin
    v_arr.delete(3 , 6);
    
    -- Khi index c?a associative array không li?n nhau thì dùng câu l?nh này s? g?p l?i
--    forall i in 1..v_arr.count 
--        insert into add_table values(10 + v_arr(i));
      forall i in indices of v_arr
        insert into add_table values(10 + v_arr(i));
end;

select * from mul_table;
create table mul_table
(
    val number
);

/* demo 2 */
declare  
    type associative_array is table of number index by pls_integer;
    v_arr associative_array;
begin
    for i in 1..10
    loop
         v_arr(i) := i ;
    end loop;
    
    forall i in 1..10
        insert into mul_table values(10 * v_arr(i));
end;



