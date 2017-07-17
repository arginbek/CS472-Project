package edu.mum.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryDAO {
    private static Map<String, InventoryItem> inventory;

    {
        inventory = new HashMap<>();
    }

    public InventoryDAO() {
        Product prod;
        for (int i = 0; i < 20; i++) {
            prod = new Product("Prod" + i, "Description of the product " + i, 10.00 + i, "product" + i + ".jpg");
            InventoryItem invItem = new InventoryItem(prod, 10 + i);
            inventory.put(prod.getId(), invItem);
        }
    }

    public void addItem(InventoryItem item) {
        inventory.put(item.getProduct().getId(), item);
    }

    public static Map<String, InventoryItem> getInventory() {
        return inventory;
    }

    public List<InventoryItem> getAllItems() {
        return new ArrayList<>(inventory.values());
    }

}
