package edu.mum.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<String, InventoryItem> cartItems;

    public Cart() {
        this.cartItems = new HashMap<>();
    }

    public Map<String, InventoryItem> getCartItems() {
        return cartItems == null ? new HashMap<>() : cartItems;
    }

    public List<InventoryItem> getAllCartItems() {
        return new ArrayList<>(this.getCartItems().values());
    }

    public boolean addItem(InventoryItem item) {
        if (InventoryDAO.getInventory().get(item.getProduct().getId()).getQuantity() > item.getQuantity()) {
            cartItems.put(item.getProduct().getId(), item);
            return true;
        }
        return false;
    }

    public boolean deleteItem(InventoryItem item) {
        if (cartItems.containsKey(item.getProduct().getId())) {
            cartItems.remove(item.getProduct().getId());
            return true;
        }
        return false;
    }
}