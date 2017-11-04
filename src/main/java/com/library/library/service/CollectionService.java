package com.library.library.service;

import com.library.library.dao.ItemDao;
import com.library.library.model.Item;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("CollectionService")
public class CollectionService{

    ItemDao itemDao = new ItemDao();

    public List<Item> getAll(){
        return itemDao.getAll();
    }

    public Item getItem(String id){
        return itemDao.getItem(id);
    }

    public Item addItem(Item item){
        item.setId();
        return itemDao.addItem(item);
    }
}
