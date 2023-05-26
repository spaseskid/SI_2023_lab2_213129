package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function(User user, List<User> allUsers) {
        if (user == null || user.getPassword() == null || user.getEmail() == null) { //1
            throw new RuntimeException("Mandatory information missing!");//2
        }

        if (user.getUsername() == null) { //3
            user.setUsername(user.getEmail());//4
        }

        int same = 1;
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {//5
            same = 0;//6
            for (int i = 0; i < allUsers.size(); i++) {//7.1
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) { //8
                    same += 1; //9
                }
                if (existingUser.getUsername() == user.getUsername()) { //10
                    same += 1;//11
                } //12
            }
        }

        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        String password = user.getPassword();
        String passwordLower = password.toLowerCase();

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length() < 8) { //13
            return false; //14
        } else {
            if (!passwordLower.contains(" ")) { //15
                for (int i = 0; i < specialCharacters.length(); i++) { //16.1
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //17
                        return same == 0; //18
                    }
                } // 19
            }
        }
        return false;//20
    } //21

}