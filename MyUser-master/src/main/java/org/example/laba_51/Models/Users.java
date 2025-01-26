package org.example.laba_51.Models;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String groupe_number;

    public Users() {
    }

    public Users(String name, String surname, int age, String groupe_number) {
        this.name = name;
        this.surname = surname;;
        this.age = age;
        this.groupe_number = groupe_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroupe_number() {
        return groupe_number;
    }

    public void setGroupe_number(String groupe_number) {
        this.groupe_number = groupe_number;
    }
}
