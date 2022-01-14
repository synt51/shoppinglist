package de.neuefische.backend.service;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.repositories.ShoppingItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShoppingItemService {

    @Autowired
    ShoppingItemRepo shoppingItemRepo;

    public Collection<ShoppingItem> getAllItems(){
        return shoppingItemRepo.findAll();
    }

    public String addNewItem(ShoppingItem newItem){
        shoppingItemRepo.save(newItem);
        return newItem + " has been added to items.";
    }

}
