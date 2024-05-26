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

public class book {
    private String title;
    private String author;
    private String ISBN;
    private double price ; 
    
     //FINE AMOUNT
    private String dueDate;
    private boolean reserved;
    private String feedback;
    private boolean bookRequested;
    private boolean renewInfo;

    public book(String title, String author, String ISBN, double price, String dueDate, boolean reserved, String feedback, boolean bookRequested, boolean renewInfo) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
       
        this.price = price;
        this.dueDate = dueDate;
        this.reserved = reserved;
        this.feedback = feedback;
        this.bookRequested = bookRequested;
        this.renewInfo = renewInfo;
    }

    public book(String title, String author, double price, String dueDate, String feedback) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.dueDate = dueDate;
        this.feedback = feedback;
    }
    

    public book() {
        title="";
     author="";
    ISBN="";
   
     price=0 ; 
     dueDate="12/20/2024";
    reserved =true;
    feedback="";
     bookRequested=true;
     renewInfo=true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public boolean isBookRequested() {
        return bookRequested;
    }

    public void setBookRequested(boolean bookRequested) {
        this.bookRequested = bookRequested;
    }

    public boolean isRenewInfo() {
        return renewInfo;
    }

    public void setRenewInfo(boolean renewInfo) {
        this.renewInfo = renewInfo;
    }
    
    
   public void showDueDate() {
        if (dueDate != null) {
            System.out.println("Due Date: " + dueDate);
        } else {
            System.out.println("No due date set.");
        }
    }

    public void reservationStatus() {
        if (reserved) {
            System.out.println("Book is reserved.");
        } else {
            System.out.println("Book is not reserved.");
        }
    }

    public void feedback() {
        if (feedback != null && !feedback.isEmpty()) {
            System.out.println("Feedback: " + feedback);
        } else {
            System.out.println("No feedback available.");
        }
    }

    public void bookRequest() {
        if (bookRequested != false) {
            System.out.println("Book request has been made.");
        } else {
            System.out.println("No book request has been made.");
        }
    }

    public void renewInfo() {
        if (renewInfo != false) {
            System.out.println("Renewal information is available.");
        } else {
            System.out.println("No renewal information available.");
        }
    }

    @Override
    public String toString() {
        return "book{" + "title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", price=" + price + ", dueDate=" + dueDate + ", reserved=" + reserved + ", feedback=" + feedback + ", bookRequested=" + bookRequested + ", renewInfo=" + renewInfo + '}'+"\n";
    }

    
    
}
