# Demo Online Store

## Description
demoShop application registration of goods and users

***
## Requirements
- Open JDK 17
- Maven 3.6.x
- PostrgeSQL 14.x
***
## Steps to Setup
1. Clone the application
~~~
git clone https://gitlab.com/vitaly-lab/demoShop.git
~~~
2. Create PostgresSQL database
~~~ 
CREATE DATABASE shop;
CREATE USER demoshop WITH PASSWORD 'pass';
GRANT ALL PRIVILEGES ON DATABASE demoshop to pass;
~~~
***
