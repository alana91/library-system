package com.library.library.service;

import org.springframework.stereotype.Service;

@Service("CollectionService")
public class CollectionService{
    public String search(){
        return "list";
    }
}
