package com.exemplo.poo_senai.cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/cats")
public class CatController {
    
    private List<Cat> cats = new ArrayList<>();

    public CatController(){
        cats.add(new Cat("Felino", 5));
        cats.add(new Cat("Bola de pelo", 3));
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

    @PostMapping
    public ResponseEntity<String> createCat(@RequestBody Cat cat){
        cats.add(cat);
        return new ResponseEntity<>("Cat created successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{name}")
    public ResponseEntity<String> updateCat(@PathVariable String name, @RequestBody Cat cat){
        for (int i = 0; i < cats.size(); i++){
            if (cats.get(i).getName().equals(name)){
                cats.set(i, cat);
                return new ResponseEntity<>("Cat updated successfully!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Cat not found!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{/{name}}")
    public ResponseEntity<String> deleteCat(@PathVariable String name){
        boolean removed = cats.removeIf(cat -> cat.getName().equals(name));
        if (removed){
            return new ResponseEntity<>("Cat deleted successfully!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>("Cat not found!", HttpStatus.NOT_FOUND);
    }
}