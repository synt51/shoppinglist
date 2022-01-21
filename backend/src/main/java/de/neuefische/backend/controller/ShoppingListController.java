package de.neuefische.backend.controller;

import de.neuefische.backend.models.ShoppingList;
import de.neuefische.backend.service.ShoppingListService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lists")
@CrossOrigin
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService){
        this.shoppingListService = shoppingListService;
    }

    @GetMapping("/")
    public List<ShoppingList> getAllLists(){
        return shoppingListService.getAllLists();
    }

    @GetMapping("/{id}")
    public ShoppingList getListById(@PathVariable String listId){
        return shoppingListService.getListById(listId);
    }

    @PostMapping("/")
    public ShoppingList addNewList(@RequestBody ShoppingList newList){
        return shoppingListService.addNewList(newList);
    }

    @PutMapping("/")
    public ShoppingList changeListName(@RequestBody ShoppingList newList){
        return shoppingListService.changeListName(newList);
    }

    @DeleteMapping("/{id}")
    public String deleteList (@PathVariable String listId){
        return shoppingListService.deleteList(listId);
    }
}
