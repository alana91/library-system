package com.library.library.service;

import com.library.library.dao.ItemDao;
import com.library.library.model.Item;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("CollectionService")
public class CollectionService{

    private ItemDao itemDao = new ItemDao();

    public List<Item> getAll(){
        return itemDao.getAll();
    }

    public Item getItem(String id){
        return itemDao.getItem(id);
    }

    public Item addItem(Item item){
        return itemDao.addItem(item);
    }

    public Item updateItem(Item item, String id){
        return itemDao.updateItem(item, id);
    }

    public void removeItem(String id){
        itemDao.removeItem(id);
    }
}