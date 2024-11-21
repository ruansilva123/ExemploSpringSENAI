package com.exemplo.poo_senai.controllers;

import lombok.Getter;
import lombok.Setter;


public class Cat {
    
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }
}
