package edu.mum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mum.models.Order;

public class OrderHistoryDAO {
    private static Map<String, List<Order>> orders;

    static {
        orders = new HashMap<>();
    }

    public static void addOrder(Order order) {
        List<Order> toBeAdded = new ArrayList<>();
        if (orders.containsKey(order.getUser().getUserName())) {
            toBeAdded = orders.get(order.getUser().getUserName());
        }
        toBeAdded.add(order);
        orders.put(order.getUser().getUserName(), toBeAdded);
    }
    
    public static List<Order> getOrderByUsername(String pUserName){
    	return orders.get(pUserName);
    }
}
