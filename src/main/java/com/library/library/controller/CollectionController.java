package com.library.library.controller;

import com.library.library.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/collection")
@RestController
public class CollectionController {

    @Autowired
    private CollectionService service;

    @RequestMapping(method = RequestMethod.GET)
    public String search(){
        return service.search();
    }
}


