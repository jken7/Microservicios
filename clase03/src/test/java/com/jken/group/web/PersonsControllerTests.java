package com.jken.group.web;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by root on 2/6/17.
 */
public class PersonsControllerTests {

    @Test
    public void shouldFindAPersonById(){
        PersonaController hc = new PersonaController();
        hc.init();
        Assert.assertNotNull(hc.findById("ken"));
    }

    @Test
    public void should(){

    }
}
