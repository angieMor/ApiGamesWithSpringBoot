package com.powerup.square.domain.model;

public class Player {

    private Long id;
    private String firstName;
    private String lastname;
    private String username;
    private Integer age;
    private String email;
    private String sex;

    public Player(Long id, String firstName, String lastname, String username, Integer age, String email, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastname = lastname;
        this.username = username;
        this.age = age;
        this.email = email;
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
