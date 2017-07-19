package edu.mum.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mum.dao.InventoryDAO;

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

			if (cartItems.containsKey(item.getProduct().getId())) {
				int nQty = (cartItems.get(item.getProduct().getId()).getQuantity()) + 1;
				cartItems.get(item.getProduct().getId()).setQuantity(nQty);
			} else {
				cartItems.put(item.getProduct().getId(), item);
			}

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
