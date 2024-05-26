/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author Dell
 */

public  class user {
    private String User_Name;
    private int User_ID;
       
  
    public void checkAccount() {
    System.out.println("Information about account :  " + toString());
    System.out.println( super.toString());
    
}

    public void getBookInfo() {
       book book = new book("ard al naam", "mohamed ahmed", "99098", "6585742568965", 0 , "1988-09-29" , true, "perfect", true, true);
     System.out.println("Information about book :  " + book.toString());
    
}
   
    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }
    

    @Override
    public String toString() {
        return "user{" + "User_Name=" + User_Name + ", User_ID=" + User_ID + '}'+ "\n";
    }

    protected user(String User_Name, int User_ID) {
        this.User_Name = User_Name;
        this.User_ID = User_ID;
       
    }
   
}
