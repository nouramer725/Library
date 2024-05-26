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
public class author {
        private String name ;
        private String gender ;
        private String   email;
        private book []boo; 

    public author(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
    }

    public author() {
        name="";
        gender="";
        email="";
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public book[] getBoo() {
        return boo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBoo(book[] boo) {
        this.boo = boo;
    }

    
      public void booksNumber(int n) 
    { 
        boo= new book[n]; 
    }  

    @Override
    public String toString() {
        return "author{" + "name=" + name + ", gender=" + gender + ", email=" + email + ", boo=" + boo + '}'+"\n";
    }
      
}
