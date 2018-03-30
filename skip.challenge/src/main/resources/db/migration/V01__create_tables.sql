CREATE TABLE customer(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(30) NOT NULL,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(255) NOT NULL,
	creation DATETIME,
	password VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO skip_db.customer(`id`, `name`, `email`,`address`,`creation`,`password`)
VALUES(1,"Angelo Daiher","example@example.com","321, Street One ","2018/03/03 10:00:00","cyphed");

CREATE TABLE cousine (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	description VARCHAR(255)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO skip_db.cousine(`id`, `name`, `description`) VALUES(1,"Brazilian Food", "Any kind of Brazilian food");
INSERT INTO skip_db.cousine(`id`, `name`, `description`) VALUES(2,"Italian Food", "Any kind of Italian food");
INSERT INTO skip_db.cousine(`id`, `name`, `description`) VALUES(3,"Chinese", "Chinese food");

CREATE TABLE  store (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	cousine_id BIGINT(20),
	name VARCHAR(50) NOT NULL,
	description VARCHAR(255),
    FOREIGN KEY (cousine_id) REFERENCES cousine(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO skip_db.store(`id`, `cousine_id` , `name`, `description`) VALUES(1,1,"Brazilian Restaurant", "The best of Brazilian food");
INSERT INTO skip_db.store(`id`, `cousine_id` , `name`, `description`) VALUES(2,2,"Italian Best Food", "All of Italian food");
INSERT INTO skip_db.store(`id`, `cousine_id` , `name`, `description`) VALUES(3,3,"Chinese", "");

CREATE TABLE product (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	store_id BIGINT(20),
	name VARCHAR(50) NOT NULL,
	description VARCHAR(255) NOT NULL,
	price double(4,3),
	FOREIGN KEY (store_id) REFERENCES store(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO skip_db.product(`id`, `store_id` , `name`, `description`, `price`) VALUES(1,1,"Brazilian Feijoada", "Feijoada",'6.25');
INSERT INTO skip_db.product(`id`, `store_id` , `name`, `description`, `price`) VALUES(2,1,"Mineira Food ", "Rice, beans, egg, beef",'6.25');
INSERT INTO skip_db.product(`id`, `store_id` , `name`, `description`, `price`) VALUES(3,2,"Pasta - 1", "With the best sauce",'4.25');
INSERT INTO skip_db.product(`id`, `store_id` , `name`, `description`, `price`) VALUES(4,2,"Pasta - 2", "With the best sauce",'4.25');
INSERT INTO skip_db.product(`id`, `store_id` , `name`, `description`, `price`) VALUES(5,3,"Yakisoba - Beef", "",'4.25');
INSERT INTO skip_db.product(`id`, `store_id` , `name`, `description`, `price`) VALUES(6,3,"Yakisoba - Chicken", "",'4.25');

CREATE TABLE orders (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	customer_id  BIGINT(20),
	store_id  BIGINT(20),
	date DATETIME,
	delivery_address VARCHAR(255),
	contact	VARCHAR(100),
	total double(4,3),
	status VARCHAR(50),
	last_update DATETIME,
	FOREIGN KEY (customer_id) REFERENCES customer(id),
	FOREIGN KEY (store_id) REFERENCES store(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE order_item (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	order_id  BIGINT(20),
	product_id  BIGINT(20),
	price  double(4,3),
	quantity INTEGER NOT NULL,
	total  double(4,3),
	FOREIGN KEY (order_id) REFERENCES orders(id),
	FOREIGN KEY (product_id) REFERENCES product(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


