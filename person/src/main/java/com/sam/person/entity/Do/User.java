package com.sam.person.entity.Do;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sam
 * @since 2020-01-13
 */
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;

    private Integer age;

    private String password;

    private String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
        "name=" + name +
        ", age=" + age +
        ", password=" + password +
        ", id=" + id +
        "}";
    }
}
