DROP TABLE IF EXISTS dog CASCADE;
CREATE TABLE dog (
	id INT AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
	breed VARCHAR(255) NOT NULL,
	age INT NOT NULL,
	weight DOUBLE PRECISION NOT NULL,
	PRIMARY KEY (id)
	);