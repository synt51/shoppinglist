package de.neuefische.backend.service;

import de.neuefische.backend.models.ShoppingList;
import de.neuefische.backend.repositories.ShoppingListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepo shoppingListRepo;

    public Collection<ShoppingList> getAllLists(){
        return shoppingListRepo.findAll();
    }

    public String addNewList(ShoppingList newList){
        shoppingListRepo.save(newList);
        return newList + " has been added as a new list.";
    }
}
