package com.jken.group.business;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by root on 2/3/17.
 */
public class NotFoundExcpetion extends RuntimeException {

    @Getter
    private final Serializable identifier;

    public NotFoundExcpetion(String msg, Serializable identifier){
        super(msg);

        this.identifier = identifier;
    }
}
