package com.library.library.dao;
import com.library.library.model.Item;

import java.util.List;

public class ItemDao {
    private Helper helper = new Helper();
    private List<Item> items = helper.createItemList();

    public List<Item> getAll(){
        return items;
    }

    public Item getItem(String id){
        Item selectedItem = null;
        for(Item item : items){
            if(item.getId().equals(id)){
                selectedItem = item;
                break;
            }
        }
        return selectedItem;
    }

    public Item addItem(Item item){
        items.add(item);
        return item;
    }

}
