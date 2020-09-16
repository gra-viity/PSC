package com.example.myapplication;

public class model {
    String name, age;

    public model(String name, String Age) {
        this.name = name;
        this.age = Age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}

