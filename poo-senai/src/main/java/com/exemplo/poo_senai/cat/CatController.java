package com.exemplo.poo_senai.cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/cats")
public class CatController {
    
    private List<Cat> cats = new ArrayList<>();

    public CatController(){
        cats.add(new Cat("Felino", 5));
    }

    @GetMapping
    public ResponseEntity<List<Cat>> getAllCats() {
        if (cats.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Cat> getCat(@PathVariable String name){
        Optional<Cat> cat = cats.stream().filter(c -> c.getName().equals(name)).findFirst();
        if (cat.isPresent()){
            return new ResponseEntity<>(cat.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}