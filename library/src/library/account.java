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
public class account {
    private int no_borrowed_books; 
    private int no_reserved_books;
    private int  no_returned_books;
     private int no_lost_books ;
     private String name;
     private int id;

    public account(int no_borrowed_books, int no_reserved_books, int no_returned_books, int no_lost_books, double fine_amount ,String name, int id) {
        this.no_borrowed_books = no_borrowed_books;
        this.no_reserved_books = no_reserved_books;
        this.no_returned_books = no_returned_books;
        this.no_lost_books = no_lost_books;
        this.fine_amount = fine_amount;
        this.name = name;
        this.id = id;
        
    }

//     fine_amount for returning a book late after the due date as per the conditions
     private double fine_amount ;

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

   

    public int getNo_borrowed_books() {
        return no_borrowed_books;
    }

    public void setNo_borrowed_books(int no_borrowed_books) {
        this.no_borrowed_books = no_borrowed_books;
    }

    public int getNo_reserved_books() {
        return no_reserved_books;
    }

    public void setNo_reserved_books(int no_reserved_books) {
        this.no_reserved_books = no_reserved_books;
    }

    public int getNo_returned_books() {
        return no_returned_books;
    }

    public void setNo_returned_books(int no_returned_books) {
        this.no_returned_books = no_returned_books;
    }

    public int getNo_lost_books() {
        return no_lost_books;
    }

    public void setNo_lost_books(int no_lost_books) {
        this.no_lost_books = no_lost_books;
    }

    public double getFine_amount() {
        return fine_amount;
    }

    public void setFine_amount(double fine_amount) {
        this.fine_amount = fine_amount;
    }
    
   public void Calculatefine(double n) 
    { 
        
// A library charges a fine for returning a book late after the due date as per the conditions given below:
//No. of days	            Fine
//First five days	₹ 2.00 per day
//Six to ten days	₹ 5.00 per day
//Above ten days	₹ 10.00 per day

        if (n <= 5)
            fine_amount = n * 2.0 ;
        else if (n <= 10)
            fine_amount = 10 + (n - 5) * 5.0 ;
        else
            fine_amount = 10 + 25 + (n - 10) * 10 ;
            
        System.out.println("Fine to be paid = " + fine_amount);
    }

    @Override
    public String toString() {
        return "account{" + "no_borrowed_books=" + no_borrowed_books + ", no_reserved_books=" + no_reserved_books + ", no_returned_books=" + no_returned_books + ", no_lost_books=" + no_lost_books + ", fine_amount=" + fine_amount +", name=" + name + ", id=" + id +  '}';
    }
   
}