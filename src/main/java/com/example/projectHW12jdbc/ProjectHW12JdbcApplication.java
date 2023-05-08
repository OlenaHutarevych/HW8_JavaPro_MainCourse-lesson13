package com.example.projectHW12jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Домашнее задание: (HW8, projectdemo12jdbc)
//        1. Доделать предідущие.
//        2. Реализовать DAO классі для своих таблиц.
//        3. Реализовать контроллері, которіе будут оперировать дао для доступа к даннім из бд
//        (по аналогии с дао, для каждой таблиці создать свой контроллер,
//        в котором будут точки для поиска, вставки, добавления и удаления информации).

@SpringBootApplication
public class ProjectHW12JdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectHW12JdbcApplication.class, args);
    }
}
