package Cuphead.Controller;

import Cuphead.Model.User;

public class ProfileController extends Controller{
    public String changeUsername(String username){
        if (currentUser.getUsername().equals(username))
            return "New username is the same as the old one";
        currentUser.setUsername(username);
        return "Username changed successfully";
    }

    public String changePassword(String password){
        currentUser.setPassword(password);
        return "Password changed successfully";
    }

    public String logout(){
        currentUser = null;
        return "Logged out successfully";
    }

    public String deleteAccount(){
        User.getAllUsers().remove(currentUser);
        currentUser = null;
        return "Account deleted successfully";
    }
}
