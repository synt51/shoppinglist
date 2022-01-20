package de.neuefische.backend.service;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.repositories.ShoppingItemRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingItemService {


    private final ShoppingItemRepo shoppingItemRepo;

    public ShoppingItemService(ShoppingItemRepo shoppingItemRepo) {
        this.shoppingItemRepo = shoppingItemRepo;
    }


    public List<ShoppingItem> getAllItems(){return shoppingItemRepo.findAll();}

    public Optional<ShoppingItem> getItemById(String itemId){return shoppingItemRepo.findById(itemId);}

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
