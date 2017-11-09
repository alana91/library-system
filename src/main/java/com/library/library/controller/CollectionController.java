package com.library.library.controller;

import com.library.library.model.Item;
import com.library.library.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class CollectionController {

    @Autowired
    private CollectionService service;

    @GetMapping("/collection")
    public List<Item> getAll(){
        return service.getAll();
    }

    @GetMapping("/collection/{id}")
    public Item getItem(@PathVariable String id){
        return service.getItem(id);
    }

    @PostMapping("/collection")
    public ResponseEntity<Void> addItem(@RequestBody Item newItem){
        Item item = service.addItem(newItem);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/collection/{id}")
    public ResponseEntity<?> updateItem(@PathVariable String id, @RequestBody Item newItem){
        Item updatedItem = service.updateItem(newItem, id);
        return new ResponseEntity<Item>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/collection/{id}")
    public ResponseEntity<Void> removeItem(@PathVariable String id){
        service.removeItem(id);
        return ResponseEntity.noContent().build();
    }
}


