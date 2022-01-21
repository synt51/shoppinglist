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
    void getItemByNonExistingId() {
        //GIVEN
        ShoppingItem expected = ShoppingItem.builder().itemId("test-id").itemName("test-name").itemCount(1).build();

        when(shoppingItemRepo.findById("test-id")).thenReturn(Optional.of(expected));
        when(shoppingItemRepo.findById("wrong-id")).thenReturn(Optional.empty());
        //WHEN
        Optional<ShoppingItem> actual = shoppingItemService.getItemById("wrong-id");
        //THEN
        assertThat(actual, Matchers.is(Optional.empty()));
    }

    @Test
    void getItemByNullId() {
        //GIVEN
        ShoppingItem expected = ShoppingItem.builder().itemId("test-id").itemName("test-name").itemCount(1).build();

        when(shoppingItemRepo.findById("test-id")).thenReturn(Optional.of(expected));
        when(shoppingItemRepo.findById(null)).thenThrow(new IllegalArgumentException());
        //WHEN
        try {
            shoppingItemService.getItemById(null);
            fail();
        } catch (IllegalArgumentException e){

        }
        //THEN

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