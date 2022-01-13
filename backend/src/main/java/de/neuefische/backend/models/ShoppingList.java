package de.neuefische.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("shopItems")
public class ShoppingList {

    @Id
    private String listId;

   // @Indexed(unique = true)  //for unique list name
    private String listName;
    private List<ShoppingItem> itemsInList;

    public ShoppingList(String listName, List<ShoppingItem> itemsInList) {
        this.listName = listName;
        this.itemsInList = itemsInList;
    }
}