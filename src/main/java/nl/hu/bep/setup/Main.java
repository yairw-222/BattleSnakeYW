package nl.hu.bep.setup;

import nl.hu.bep.setup.model.User;
import nl.hu.bep.setup.model.UserValidation;

import java.util.List;

public class Main {
    public static void main(String[] args){
        List<User> Users = UserValidation.getUserList();
        User user1= new User("Yairw1","Test123","user");
        Users.add(user1);
    }
}
