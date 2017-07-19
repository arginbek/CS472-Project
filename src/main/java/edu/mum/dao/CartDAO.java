package edu.mum.dao;

import java.util.HashMap;
import java.util.Map;

import edu.mum.models.Cart;
import edu.mum.models.InventoryItem;
import edu.mum.models.Product;
import edu.mum.models.User;

public class CartDAO {
    private static Map<String, Cart> userCarts;

    static {
        userCarts = new HashMap<>();
        User user = UserDAO.getUserByUserName("user1");
        Product prod = InventoryDAO.getInvItemByProductId("1").getProduct();
        Cart cart = new Cart();
        cart.addItem(new InventoryItem(prod, 2));
        userCarts.put(user.getUserName(), cart);
    }

    public static boolean checkCartByUsername(String userName) {
        return userCarts.containsKey(userName);
    }

    public static void deleteCartByUserName(String userName) {
        userCarts.remove(userName);
    }

    public static Cart getCartByUserName(String userName) {
        return userCarts.get(userName);
    }

    public static void addCart(User user, Cart cart) {
        userCarts.put(user.getUserName(), cart);
    }
}
