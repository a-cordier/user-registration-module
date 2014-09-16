#### A simple user registration module 

##### Using

- JSF-2.2
- CDI weld impl.
- Hibernate 4.*
- Primefaces 4.0
- Tomcat 7.*
- Java 1.7
- MySQL DB

##### DONE

- Scaffolding layers separation
- building a basic example view
- validating username uniqueness
- hashing password (SHA-256)

##### TODO

- User avatar persisted as blob
- Improve UI

##### Matching mySQL table
````
| Field     | Type             | Null | Key | Default | Extra          |
+-----------+------------------+------+-----+---------+----------------+
| user_id   | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| firstname | varchar(100)     | YES  |     | NULL    |                |
| lastname  | varchar(100)     | YES  |     | NULL    |                |
| avatar    | blob             | YES  |     | NULL    |                |
| username  | varchar(50)      | YES  |     | NULL    |                |
| password  | char(64)         | YES  |     | NULL    |                |
````
