insert into todolist select nextval('seq_todolist') id, 'todo 1' "name", to_date('2018-10-26', 'yyyy-mm-dd') duedate, 1 priority;
insert into todolist select nextval('seq_todolist') id, 'todo 2' "name", to_date('2018-10-27', 'yyyy-mm-dd') duedate, 2 priority;
insert into todolist select nextval('seq_todolist') id, 'todo 3' "name", to_date('2018-10-28', 'yyyy-mm-dd') duedate, 3 priority;