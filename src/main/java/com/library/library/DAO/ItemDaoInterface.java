package com.library.library.DAO;

import com.library.library.DTO.ItemDTO;

import java.util.List;

public interface ItemDaoInterface {

    public List<ItemDTO> getAll();

    public ItemDTO getItem(String id);

    public ItemDTO addItem(ItemDTO itemDTO);

    public ItemDTO updateItem(ItemDTO itemDTO, String id);

    public void removeItem(String id);
}
