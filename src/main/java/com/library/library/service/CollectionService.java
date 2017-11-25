package com.library.library.service;

import com.library.library.DAO.ItemDao;
import com.library.library.DTO.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("CollectionService")
public class CollectionService{

    @Autowired
    private ItemDao itemDao;

    public List<ItemDTO> getAll(){
        return itemDao.getAll();
    }

    public ItemDTO getItem(String id){
        return itemDao.getItem(id);
    }

    public ItemDTO addItem(ItemDTO itemDTO){
        return itemDao.addItem(itemDTO);
    }

    public ItemDTO updateItem(ItemDTO itemDTO, String id){
        return itemDao.updateItem(itemDTO, id);
    }

    public void removeItem(String id){
        itemDao.removeItem(id);
    }
}