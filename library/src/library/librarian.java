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

public class librarian {
    private String name;
    private int id;
    private String password;
   

    public librarian() {
        name="";
        id=0;
        password="";
                        
    }
    
    
    
    public librarian(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



   @Override
    public String toString() {
        return "librarian{" +"name=" + name + " id= "+ id + " password=" + password + '}'+ "\n" ;
    }
    
}
