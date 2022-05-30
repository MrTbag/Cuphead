package Cuphead.Controller;

import Cuphead.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class LoginController extends Controller{


    public String register(String username, String password) throws FileNotFoundException {
        if (!isUsernameUnique(username))
            return "This username already exists";
        User user = new User(username, password);
        User.getAllUsers().add(user);
        return "User created successfully";
    }

    public String login(String username, String password){
        if (!isPasswordCorrect(username, password))
            return "Incorrect username or password";
        User user = getUserByUsername(username);
        currentUser = user;
        return "Logged in successfully";
    }

    public String playAsGuest(){
        User user = new User("Guest", "1234");
        currentUser = user;
        return "Entered as a guest successfully";
    }

    public boolean isLoggedIn(){
        if (currentUser == null)
            return false;
        return true;
    }

    private boolean isUsernameUnique(String username){
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username))
                return false;
        }
        return true;
    }

    private boolean isPasswordCorrect(String username, String password){
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username)){
                if (user.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }

    public User getUserByUsername(String username){
        for (User user : User.getAllUsers()) {
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }



}
