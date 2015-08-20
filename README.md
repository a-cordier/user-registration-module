#### A simple user registration module 

##### Using

- JSF-2.2
- CDI weld impl.
- Hibernate 4.*
- Primefaces 4.0
- Tomcat 7.*
- Java 1.7
- MySQL DB


##### TODO

- email validation

##### Matching mySQL table
````
+-----------+------------------+------+-----+---------+----------------+
| Field     | Type             | Null | Key | Default | Extra          |
+-----------+------------------+------+-----+---------+----------------+
| user_id   | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| firstname | varchar(100)     | NO   |     | NULL    |                |
| lastname  | varchar(100)     | NO   |     | NULL    |                |
| avatar    | blob             | YES  |     | NULL    |                |
| username  | varchar(50)      | NO   | UNI | NULL    |                |
| password  | char(64)         | NO   |     | NULL    |                |
| email     | varchar(254)     | NO   |     | NULL    |                |
+-----------+------------------+------+-----+---------+----------------+
````
