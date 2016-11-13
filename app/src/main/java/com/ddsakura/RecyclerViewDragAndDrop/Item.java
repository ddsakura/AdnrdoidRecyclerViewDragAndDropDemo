
package com.ddsakura.RecyclerViewDragAndDrop;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Item> generateSampleList() {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Item item = new Item();
            item.setName("Name - " + i);
            list.add(item);
        }
        return list;
    }
}
