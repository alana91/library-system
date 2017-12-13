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

    public Item updateItem(Item item, String id){
        Item selectedItem = getItem(id);
        selectedItem.setArea(item.getArea());
        selectedItem.setAuthors(item.getAuthors());
        selectedItem.setCountry(item.getCountry());
        selectedItem.setDate(item.getDate());
        selectedItem.setTitle(item.getTitle());
        selectedItem.setIsBorrowed(item.getIsBorrowed());
        return selectedItem;
    }

    public void removeItem(String id){
        Item item = getItem(id);
        items.remove(item);
    }
}
