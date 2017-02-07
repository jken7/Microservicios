package com.jken.group.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 * Created by root on 2/3/17.
 */
//@Builder
@Getter
@Setter
public class Person {
    private String id;
    private String name;
    private String mail;

    /*public static Person from(String name, String mail){
        return Person.
        //return null;
    }*/

    public static Person from(String id, String name, String mail){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setMail(mail);
        return person;
    }

}
