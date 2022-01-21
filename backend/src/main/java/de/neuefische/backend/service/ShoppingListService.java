package de.neuefische.backend.service;

import de.neuefische.backend.models.ShoppingList;
import de.neuefische.backend.repositories.ShoppingListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListRepo shoppingListRepo;

    public List<ShoppingList> getAllLists(){return shoppingListRepo.findAll();}

    public ShoppingList getListById(String listId){return shoppingListRepo.findById(listId).orElse(null);}

    public ShoppingList addNewList(ShoppingList newList){
        return shoppingListRepo.save(newList);
    }

    public ShoppingList changeListName (ShoppingList newList){
        ShoppingList oldList = shoppingListRepo.findById(newList.getListId()).orElse(null);
        oldList.setListName(newList.getListName());
        shoppingListRepo.save(oldList);
        return oldList;
    }

    public String deleteList(String listId){
        shoppingListRepo.deleteById(listId);
        return listId;
    }
}
