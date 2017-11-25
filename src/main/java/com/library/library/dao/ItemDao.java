package com.library.library.DAO;
import com.library.library.DTO.ItemDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao implements ItemDaoInterface{

    private Helper helper = Helper.getInstance();
    private List<ItemDTO> itemDTOS = helper.createItemList();

    @Override
    public List<ItemDTO> getAll(){
        return itemDTOS;
    }

    @Override
    public ItemDTO getItem(String id){
        ItemDTO selectedItemDTO = null;
        for(ItemDTO itemDTO : itemDTOS){
            if(itemDTO.getId().equals(id)){
                selectedItemDTO = itemDTO;
                break;
            }
        }
        return selectedItemDTO;
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO){
        itemDTOS.add(itemDTO);
        return itemDTO;
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO, String id){
        ItemDTO selectedItemDTO = getItem(id);
        selectedItemDTO.setArea(itemDTO.getArea());
        selectedItemDTO.setAuthor(itemDTO.getAuthor());
        selectedItemDTO.setCountry(itemDTO.getCountry());
        selectedItemDTO.setDate(itemDTO.getDate());
        selectedItemDTO.setTitle(itemDTO.getTitle());
        selectedItemDTO.setIsBorrowed(itemDTO.getIsBorrowed());
        return selectedItemDTO;
    }

    @Override
    public void removeItem(String id){
        ItemDTO itemDTO = getItem(id);
        itemDTOS.remove(itemDTO);
    }
}
