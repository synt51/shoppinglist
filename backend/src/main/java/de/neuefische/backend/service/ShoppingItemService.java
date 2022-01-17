package de.neuefische.backend.service;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.repositories.ShoppingItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemService {

    @Autowired
    ShoppingItemRepo shoppingItemRepo;

    public List<ShoppingItem> getAllItems(){return shoppingItemRepo.findAll();}

    public ShoppingItem getItem(String itemId){return shoppingItemRepo.findById(itemId).orElse(null);}

    public ShoppingItem addNewItem(ShoppingItem newItem){
        return shoppingItemRepo.save(newItem);
    }

    public ShoppingItem changeItemName(ShoppingItem newItem){
        ShoppingItem oldItem = shoppingItemRepo.findById(newItem.getItemId()).orElse(null);
        oldItem.setItemName(newItem.getItemName());
        shoppingItemRepo.save(oldItem);
        return oldItem;
    }

    public String deleteItem(String itemId){
        shoppingItemRepo.deleteById(itemId);
        return itemId;
    }
}
