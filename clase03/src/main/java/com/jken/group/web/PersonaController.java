package com.jken.group.web;


import com.jken.group.business.NotFoundExcpetion;
import com.jken.group.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.jken.group.model.Person.from;

@RestController
@RequestMapping("/persons")    // todos los metodos usan el request mapping
public class PersonaController {

    private List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void init(){
        persons = Stream.of(from("ken","aguirre","jk@gmail.com"),
                from("juan","juan","juan@gmail.com"),
                from("pedro","pedrox","pedro@gmail.com"))
                .collect(Collectors.toList());
    }

    @GetMapping
    public List<Person> people() {
        return persons;
    }

    @GetMapping("/{idPerson}")
    public Person findById(@PathVariable("idPerson") String idPerson) {
        return persons.stream().filter(person -> person.getId().equals(idPerson))
                .findFirst()
                .orElseThrow(() ->
                new NotFoundExcpetion("No se encontro", idPerson));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person post(@RequestBody Person person){
        persons.add(person);
        return person;
    }

    @DeleteMapping("/{idPerson}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String idPerson){
        if(persons.removeIf(person -> person.getId().equals(idPerson))){
            throw new NotFoundExcpetion("No se encontro",idPerson);
        }
    }


    @PutMapping("/{idPerson}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Person put(@RequestBody Person personRq){
        Person per = persons.stream()
                .filter(person -> person.getId().equals(personRq.getId()))
                .findFirst()
                .orElseThrow(()->
                    new NotFoundExcpetion("Nose encontro",personRq.getId()));
        per = personRq;
        return per;
    }




}
