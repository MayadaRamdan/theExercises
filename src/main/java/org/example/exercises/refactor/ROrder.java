package org.example.exercises.refactor;

import java.util.List;

public class ROrder {

    List<RItem> items ;

    public ROrder(List<RItem> items) {
        this.items = items;
    }

    public List<RItem> getItems() {
        return items;
    }
}
