 INSERT INTO role (id,role) VALUES (1,'ROLE_ADMIN');
-- INSERT INTO role (customer_id,role) VALUES (2,'ROLE_USER');

insert into customer (customer_id, active, email, customer_name, login, password) values ( 1,1,'konrad@konrad.com', 'konrad' , 'konrad', '$2a$10$CPUI9dBhGc098R5jPaBuT.zNi1G5.pshSx1kqDEqh2M/5TYYPNqyq') on conflict (customer_id) do nothing;
-- replace into customer (id, active, email, name, login, password) values (2, 1, 'kozamee11@gmail.com', 'katarzyna', 'faraś', 'kasia', '$2a$10$YExsesmK.EXsh.xJWTh.xetae7qkzpJtDpaQkg4kK/hRVeLcriB8C');
-- insert into customer_role (customer_id,role_id) values ( 1,1 );
-- replace into customer_role (employee_id,role_id) values ( 2,2 );
INSERT INTO customer_role
   (customer_id, role_id)
SELECT 1, 1
WHERE
   NOT EXISTS (
       SELECT customer_id FROM customer_role WHERE customer_id = 1
   );