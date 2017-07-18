package edu.mum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mum.models.InventoryItem;
import edu.mum.models.Product;

public class InventoryDAO {

    static Map<String, InventoryItem> inventory = new HashMap<>();
    {
        Product prod;
        for (int i = 1; i <= 20; i++) {
            prod = new Product(Integer.valueOf(i).toString(), "Prod" + i, "Description of the product " + i, 10.00 + i,
                    "product" + i + ".jpg");
            InventoryItem invItem = new InventoryItem(prod, 10 + i);
            inventory.put(prod.getId(), invItem);
        }
    }

    public InventoryDAO() {
    }

    public void addItem(InventoryItem item) {
        inventory.put(item.getProduct().getId(), item);
    }

    public static List<InventoryItem> getAllItems() {
        return new ArrayList<>(inventory.values());
    }

    public static Map<String, InventoryItem> getInventory() {
        return inventory;
    }

    public String genId() {
        return Integer.valueOf(inventory.size() + 1).toString();
    }

}
