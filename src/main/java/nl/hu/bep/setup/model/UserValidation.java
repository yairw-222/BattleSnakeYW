package nl.hu.bep.setup.model;

import java.util.List;

public class UserValidation {

    protected static List<User> userList;

    public static List<User> getUserList() {
        return userList;
    }

    public static User validateLogin(String username, String password){
        for(User user:userList ){
            if(username.equals(user.getUsername())&&password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    public static User findUserByUsername(String username){
        for(User user:userList ){
            if(username.equals(user.getUsername())){
                return user;
            }
        }
        return null;
    }



}
