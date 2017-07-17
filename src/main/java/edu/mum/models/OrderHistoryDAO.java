package edu.mum.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderHistoryDAO {
    private static Map<String, List<Order>> orders;

    {
        orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        List<Order> toBeAdded = new ArrayList<>();
        if (orders.containsKey(order.getUser().getUserName())) {
            toBeAdded = orders.get(order.getUser().getUserName());
        }
        toBeAdded.add(order);
        orders.put(order.getUser().getUserName(), toBeAdded);
    }
}
