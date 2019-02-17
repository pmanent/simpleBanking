truncate table movement;

insert into users
values('admin','$2a$10$hWepP802iw82KuyBx1uVaeYf1xzFGoSXy8HN9x4O96ZjrQCuZs4iy');
insert into users
values('pmanent','$2a$10$hWepP802iw82KuyBx1uVaeYf1xzFGoSXy8HN9x4O96ZjrQCuZs4iy');

insert into account (ID,NAME,AMMOUNT,USERNAME)
values(1,'Account 1',500,'admin');
insert into account (ID,NAME,AMMOUNT,USERNAME)
values(2,'Account without movements',500,'pmanent');

insert into movement (ID,DESCRIPTION,TOTAL,ACCOUNT)
values(movement_seq.NEXTVAL,'Deposit',1500,1);
insert into movement (ID,DESCRIPTION,TOTAL,ACCOUNT)
values(movement_seq.NEXTVAL,'Withdraw',-500,1);
insert into movement (ID,DESCRIPTION,TOTAL,ACCOUNT)
values(movement_seq.NEXTVAL,'Withdraw',-500,1);