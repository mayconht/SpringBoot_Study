package com.demo.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;


/*
* Aqui é como uma classe main comum do Java.
* é Necessario colocar o annotation do SpringBoot que define ele como uma aplicação SpringBoot
* Com isso é possivel chamar a subinterface RUN que define o startpoint.class (parametros pro spring)
* */
@SpringBootApplication
public class StartPointSB implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(StartPointSB.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
    }
}
