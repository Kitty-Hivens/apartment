* Mariadb (archlinux)
* JDK26
* SQL:


```sql
CREATE DATABASE apartments_db;
USE apartments_db;CREATE TABLE apartments (    
id INT AUTO_INCREMENT PRIMARY KEY,    
district VARCHAR(50),    
address VARCHAR(100),    
area DOUBLE,    
rooms INT,    
price DOUBLE);
INSERT INTO apartments (district, address, area, rooms, price) VALUES('Центр', 'ул. Ленина, 10', 45.5, 2, 40000),('Юг', 'ул. Гагарина, 25', 60.0, 3, 55000),('Север', 'ул. Кирова, 1', 70.2, 3, 80000),('Запад', 'ул. Пушкина, 3', 35.0, 1, 30000);  
CREATE USER 'takumi-haru'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON mydb.* TO 'takumi-haru'@'localhost';
FLUSH PRIVILEGES;
```
