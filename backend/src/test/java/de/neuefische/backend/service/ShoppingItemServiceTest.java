package de.neuefische.backend.service;

import de.neuefische.backend.models.ShoppingItem;
import de.neuefische.backend.repositories.ShoppingItemRepo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ShoppingItemServiceTest {

    private final ShoppingItemRepo shoppingItemRepo = mock(ShoppingItemRepo.class);

    private final ShoppingItemService shoppingItemService = new ShoppingItemService(shoppingItemRepo);

    @Test
    void getAllItems() {
    }

    @Test
    void getItemById() {
        //GIVEN
        ShoppingItem expected = ShoppingItem.builder().itemId("test-id").itemName("test-name").itemCount(1).build();

        when(shoppingItemRepo.findById("test-id")).thenReturn(Optional.of(expected));
        //WHEN
        Optional<ShoppingItem> actual = shoppingItemService.getItemById("test-id");
        //THEN
        assertThat(actual, Matchers.is(Optional.of(expected)));
    }

    @Test
    void addNewItem() {
    }

    @Test
    void changeItemName() {
    }

    @Test
    void deleteItem() {
    }
}