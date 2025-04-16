package org.example.exercises;

import java.util.List;

public class Order {
    private List<Item> items;

    // Constructor
    public Order(List<Item> items) {
        this.items = items;
    }

    // Getter for items
    public List<Item> getItems() {
        return items;
    }
}


