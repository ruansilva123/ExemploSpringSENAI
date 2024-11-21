package com.exemplo.poo_senai.cat;

// import lombok.Getter;
// import lombok.Setter;


public class Cat {
    
    // @Getter
    // @Setter
    private String name;
    // @Getter
    // @Setter
    private int age;
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }
}