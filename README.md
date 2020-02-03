# 200131

# 스프링 기초 공부

## POST, GET, PUT, DELETE



# 200203
# Springboot-MyBatis-MySQL

## 1. MySQL 세팅 
``` sql
CREATE USER 'spring'@'%' IDENTIFIED BY 'bitc5600';

GRANT ALL PRIVILEGES ON *.* TO 'spring'@'%';
CREATE DATABASE spring;
USE spring;


use spring;

CREATE TABLE mem (
	id int AUTO_INCREMENT PRIMARY KEY,
	username varchar(100) NOT NULL,
	password varchar(100) NOT NULL,
    email varchar(100),
	createTime timestamp
) ENGINE=InnoDB DEFAULT CHARSET = utf8;
```

## 2. jstl 태그 라이브러리
```jsp
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
```

