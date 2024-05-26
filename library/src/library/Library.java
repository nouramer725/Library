/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import java.util.Scanner;



/**
 *
 * @author Dell
 */

public class Library {

    private String userType;
    private String username;
    private String password;

    public Library() {
        userType="";
        username="";
        password="";
    }

    
    public Library(String userType, String username, String password) {
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
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

    public void setPassword(String password) {
        this.password = password;
    }

    
    public void login() throws IOException
    {
        
    Scanner keyboard = new Scanner (System.in);
   
    System.out.print("Please enter your user name : ");
    String inpUser = keyboard.nextLine();
    
    System.out.print("Please enter your password : ");
    String inpPass = keyboard.nextLine(); // gets input from user

    if (inpUser.equals(username) && inpPass.equals(password)) {
        
        System.out.println("Login Successfully ");
    }
    else 
    {
        System.out.println("Password or Username is incorrect , PLEASE TRY AGAIN");
    }
    
    }
   

    @Override
    public String toString() {
        return "Library{" + "userType=" + userType + ", username=" + username + ", password=" + password + '}' + "\n";
    }

    boolean login(String username, String password) {
return true;
        }
    
}
