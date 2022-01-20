

DROP TABLE IF EXISTS customer CASCADE;

CREATE TABLE customer(
	customer_id SERIAL PRIMARY KEY,
	customer_first_name VARCHAR(30),
	customer_last_name VARCHAR(30),
	customer_email VARCHAR(30)
);

DROP TABLE IF EXISTS employee CASCADE;

CREATE TABLE employee(
	employee_number SERIAL PRIMARY KEY,
	employee_customer_id INTEGER UNIQUE,
	employee_first_name VARCHAR(30),
	employee_last_name VARCHAR(30),
	employee_email VARCHAR(30)
);

DROP TABLE IF EXISTS bank_account CASCADE;

CREATE TABLE bank_account(
	account_number  SERIAL PRIMARY KEY,
	account_balance NUMERIC(22,2)
);

DROP TABLE IF EXISTS customer_bank_account_join CASCADE;

CREATE TABLE customer_bank_account_join(
);



--Define relationships between tables


--define employee as a customer
ALTER TABLE employee ADD COLUMN customer_id INTEGER UNIQUE REFERENCES customer(customer_id);

--join the customer and accounts tables
ALTER TABLE customer_bank_account_join ADD COLUMN customer INTEGER REFERENCES customer(customer_id);
ALTER TABLE customer_bank_account_join ADD COLUMN account_number INTEGER REFERENCES bank_account(account_number);
ALTER TABLE customer_bank_account_join ADD PRIMARY KEY (customer, account_number);



INSERT INTO bank_account(account_balance) VALUES (123.45);
INSERT INTO bank_account(account_balance) VALUES (543.21);
INSERT INTO bank_account(account_balance) VALUES (23.45);
INSERT INTO bank_account(account_balance) VALUES (0.45);


INSERT INTO customer(customer_first_name, customer_last_name, customer_email) VALUES ('Matt','Smith', 'matt.smith@aol.com');
INSERT INTO customer(customer_first_name, customer_last_name, customer_email) VALUES ('David','Tenant', 'david.tenant@gmail.com');
INSERT INTO customer(customer_first_name, customer_last_name, customer_email) VALUES ('Chris','Eccleston', 'chris.eccleston@gmail.com');
INSERT INTO customer(customer_first_name, customer_last_name, customer_email) VALUES ('Peter','Capaldi', 'pater.capaldi@gmail.com');
INSERT INTO customer(customer_first_name, customer_last_name, customer_email) VALUES ('Tom','Baker', 'tom.baker@outlook.com');

INSERT INTO employee(employee_first_name, employee_last_name, employee_email) VALUES ('Matt','Smith', 'matt.smith@aol.com');
INSERT INTO employee(employee_first_name, employee_last_name, employee_email) VALUES ('David','Tenant', 'david.tenant@gmail.com');


CREATE TABLE logins(
	username VARCHAR(30) PRIMARY KEY,
	en_password VARCHAR(500)
);

--Generated with encryption in advance
INSERT INTO logins(username, en_password) values('username', 'b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86')

ALTER TABLE LOGINS ADD COLUMN access_level INTEGER;
UPDATE logins SET access_level = 3 WHERE username = "username";








CREATE PROCEDURE transfer(
	sender_id int,
	reciever_id int,
	amount double PRECISION
)
LANGUAGE plpgsql
AS $$
BEGIN
	UPDATE 	bank_account SET account_balance = account_balance - amount WHERE account_number = sender_id;
	UPDATE 	bank_account SET account_balance = account_balance + amount WHERE account_number = reciever_id;
	COMMIT;
END;$$






--Set triggers
--CREATE OR REPLACE FUNCTION function_copy() RETURNS TRIGGER AS
--$BODY$
--BEGIN
--    INSERT 
--        employee(customer_id)
--        VALUES(
--        SELECT customer_id 
--        FROM 
--        (
--        	SELECT * FROM customer
--        	WHERE customer_first_name = NEW.employee_first_name
--        )
--      	WHERE customer_last_name = employee_last_name);
--
--          RETURN new;
--END;
--$BODY$
--language plpgsql;



--CREATE TRIGGER trig_copy
   --  AFTER INSERT ON employee
   --  SELECT employee_customer_id
  --   EXECUTE PROCEDURE function_copy();










