package edu.mum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mum.models.User;
import edu.mum.models.UserType;

public class UserDAO {
    private static Map<String, User> userlist;

    static {
        userlist = new HashMap<>();
        User user;
        for (int i = 0; i < 5; i++) {
            user = new User("user" + i, "Customer" + i, "Last" + i, "email" + i + "@example.com", "pass" + i);
            userlist.put(user.getUserName(), user);
        }

        for (int i = 0; i < 2; i++) {
            user = new User("manager" + i, "Manager" + i, "Default" + i, "manager" + i + "@webstore.com", "admin" + i,
                    UserType.MANAGER);
            userlist.put(user.getUserName(), user);
        }
    }

    public UserDAO() {
        super();
    }

    public static boolean addUser(User user) {
        if (userlist.containsKey(user.getUserName())) {
            return false;
        }
        userlist.put(user.getUserName(), user);
        return true;
    }

    public static void updateUser(User user) {
        userlist.put(user.getUserName(), user);
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(userlist.values());
    }

    public static Map<String, User> getUserList() {
        return userlist;
    }

    public static User getUserByUserName(String userName) {
        return userlist.get(userName);
    }

    public static boolean checkUserByUserName(String userName) {
        return userlist.containsKey(userName);
    }

    public static boolean validateEmail(String email) {
        for (User s : getAllUsers()) {
            if (email.equals(s.getEmail()))
                return false;
        }
        return true;
    }

}
