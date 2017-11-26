package com.library.library.controller;

import com.library.library.DTO.ItemDTO;
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
    public List<ItemDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/collection/{id}")
    public ItemDTO getItem(@PathVariable String id){
        return service.getItem(id);
    }

    @PostMapping("/collection")
    public ResponseEntity<Void> addItem(@RequestBody ItemDTO newItemDTO){
        ItemDTO itemDTO = service.addItem(newItemDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(itemDTO.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/collection/{id}")
    public ResponseEntity<?> updateItem(@PathVariable String id, @RequestBody ItemDTO newItemDTO){
        ItemDTO updatedItemDTO = service.updateItem(newItemDTO, id);
        return new ResponseEntity<ItemDTO>(updatedItemDTO, HttpStatus.OK);
    }
}


