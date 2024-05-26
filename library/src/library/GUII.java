/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//153

package library;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */

public class GUII extends Application {
    private Stage primaryStage;
    private Library librarySystem;
    
    private account account;
   Scene scene1, scene2, scene3,scene4,scene5,scene6;
   
   public double Calculatefine(double n) 
    { 
        double fine_amount;
        
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
            
        return fine_amount;
    }
   
@Override
public void start(Stage primaryStage) {
        
//Scene 1

        librarySystem = new Library("MALE", "M", "1");
        account = new account(8, 55, 13, 14, 982.75,"ALI MALOL", 95784);

        primaryStage.setTitle("LIBRARAY ");
        
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
//        grid.setStyle("-fx-background-color: FLORALWHITE; ");
        grid.setPadding(new Insets(90, 90, 100, 13));

        Text scenetitle = new Text("Welcome");        
        scenetitle.setStyle("-fx-font: normal bold 90px 'serif';"); 
        grid.add(scenetitle, 0, 0, 2, 1);
scenetitle.setFill(Color.DARKRED);
        Label userName = new Label("User Name :");
        grid.add(userName, 0, 4);
        userName.setStyle("-fx-font: normal bold 40px 'serif'; -fx-text-fill:DARKRED "); 
        TextField userTextField = new TextField();
        userTextField.setStyle("-fx-font: normal 18px 'serif'; -fx-text-fill:BLACK "); 
        grid.add(userTextField, 1, 4);

        Label pw = new Label("Password   :");
        grid.add(pw, 0, 5);
        pw.setStyle("-fx-font: normal bold 40px 'serif'; -fx-text-fill:DARKRED "); 
        PasswordField passwordBox = new PasswordField();
         passwordBox.setStyle("-fx-font: normal 18px 'serif'; -fx-text-fill:BLACK "); 
        grid.add(passwordBox, 1, 5);

        Button btn = new Button("Login");
        btn.setStyle("-fx-background-color: DARKRED; -fx-text-fill: WHITE; -fx-font-size: 2em; -fx-font: normal bold 40px;-fx-pref-height: 40px;\n" +
"    -fx-pref-width: 100px;");
        
        //REAARRANGE IN HORIZINTAL LINE 
        HBox hbBtn = new HBox(50);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 6);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

       
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setFill(Color.FIREBRICK);
                String username = userTextField.getText().toString();
                String password = passwordBox.getText().toString();
                 if (librarySystem.login(username, password)) {
                 if (librarySystem.getUsername().equals(username) && librarySystem.getPassword().equals(password)) 
                 {
                      System.out.println("Login Successfully ");
                      primaryStage.setScene(scene2);
//                      display();
                 }
                  else 
                     {
                         JOptionPane.showMessageDialog(null, "Invalid username or password");
                    
                      }
                     
                } 
                
                userTextField.setText("");
                passwordBox.setText("");
            }
        });
      
        grid.setId("pane");
       
        
       
             Scene scene1 = new Scene(grid, 1300, 800);
             scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
             
//main page

  GridPane gridmain = new GridPane();
        gridmain.setAlignment(Pos.CENTER);
        gridmain.setPadding(new Insets(20));
        gridmain.setHgap(10);
        gridmain.setVgap(10);
gridmain.setPadding(new Insets(25,25,25,25));

 Label admin = new Label("HI , ADMIN !");
        admin.setStyle("-fx-font: normal bold 70px 'serif'; -fx-text-fill:DARKRED ; -fx-font-alignment: center  "); 
        admin.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridmain.add(admin,0,0);
        
        
 Button Libarian = new Button("Libarian");
  Libarian.setStyle("-fx-background-color: DARKRED; -fx-text-fill: white; -fx-font-size: 2em; -fx-pref-height: 28px;\n" +
"    -fx-pref-width: 200px;");
 Libarian.setAlignment(Pos.CENTER);
 gridmain.add(Libarian, 0, 4);
        Libarian.setOnAction(E -> {
            primaryStage.setScene(scene4);
        });
       Button Book = new Button("Book");
         Book.setStyle("-fx-background-color: CHOCOLATE; -fx-text-fill: white;  -fx-font-size: 2em; -fx-pref-height: 28px;\n" +
"    -fx-pref-width: 200px;");

 gridmain.add(Book, 0, 5);
        Book.setOnAction(E -> {
            primaryStage.setScene(scene5);
        });
Button authorr = new Button("Author");
         authorr.setStyle("-fx-background-color: CHOCOLATE; -fx-text-fill: white;  -fx-font-size: 2em; -fx-pref-height: 28px;\n" +
"    -fx-pref-width: 200px;");
 gridmain.add(authorr, 0, 6);
        authorr.setOnAction(E -> {
            primaryStage.setScene(scene6);
        });
        
        Button Account = new Button("Account");
                 Account.setStyle("-fx-background-color: DARKRED; -fx-text-fill: white; -fx-font-size: 2em;-fx-pref-height: 28px;\n" +
"    -fx-pref-width: 200px; ");

 gridmain.add(Account, 0, 7);
        Account.setOnAction(E -> {
            primaryStage.setScene(scene3);
        });
         gridmain.setId("pane1");
         scene2 = new Scene(gridmain, 1300, 800);        
         scene2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
             
        
        
        
//scene 3
 Label account= new Label("Account Information: ");
         account.setStyle( "-fx-font: normal bold 30px 'serif';");
        Label lp= new Label("?");
        
       
       // btnAdd.setMaxWidth(Double.MAX_VALUE);
       
       Button btnMAINaccount= new Button("Back to MainPage");
         btnMAINaccount.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large; ");
         
         
        Button btnCALCULATE =new Button("FINE AMOUNT");
         btnCALCULATE.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large; ");
       
       
       Label searchaccount= new Label("Search");
        searchaccount.setStyle( "-fx-font: normal bold 20px 'serif';");
       TextField srchaccount= new TextField();
       srchaccount.setPrefWidth(300);
       
        
       GridPane gaccount= new GridPane();
        gaccount.add(account, 0, 0, 1, 2);
        gaccount.add(btnCALCULATE, 0, 3);
        gaccount.add(lp, 1, 3);
        gaccount.add(btnMAINaccount, 0, 5);

       
       
        gaccount.setVgap(20);
        gaccount.setHgap(20);
        gaccount.setPadding(new Insets(20));
        
        HBox haccount= new HBox(searchaccount, srchaccount);
        haccount.setPadding(new Insets(20, 0 ,20, 100));
        haccount.setSpacing(50);
        
        TableView <account> tableaccount= new TableView<>();
        tableaccount.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableaccount.setPlaceholder(new Label("No rows to display"));
      
        
        TableColumn cno_borrowed_books = new TableColumn("no_borrowed_books");
        cno_borrowed_books.setCellValueFactory(new PropertyValueFactory<>("no_borrowed_books"));
        

        TableColumn cno_reserved_books = new TableColumn("no_reserved_books");
        cno_reserved_books.setCellValueFactory(new PropertyValueFactory<>("no_reserved_books"));
        
        TableColumn  cno_returned_books = new TableColumn("no_returned_books");
        cno_returned_books.setCellValueFactory(new PropertyValueFactory<>("no_returned_books"));
        
         TableColumn  cno_lost_books = new TableColumn("no_lost_books");
        cno_lost_books.setCellValueFactory(new PropertyValueFactory<>("no_lost_books"));
        
         TableColumn  cfine_amount = new TableColumn("fine_amount");
        cfine_amount.setCellValueFactory(new PropertyValueFactory<>("fine_amount"));
        
        
         TableColumn Cname = new TableColumn("Name");
        Cname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        
         TableColumn cid = new TableColumn("ID");
        cid.setCellValueFactory(new PropertyValueFactory<>("id"));

        tableaccount.getColumns().addAll(cno_borrowed_books, cno_reserved_books, cno_returned_books,cno_lost_books,cfine_amount,Cname,cid);
       
       
       //A list that enables listeners to track changes when they occur
        ObservableList<account> dataaccount= FXCollections.observableArrayList(); 
       dataaccount.addAll(new account(3,4 , 2, 8, 44.0, "Jomana", 1),new account(10,7 , 6, 8, 4.5, "Basmala", 2),new account(13,5 , 3, 7, 4.3, "Tassnem", 3),new account(23,3 , 6, 8, 4.5, "Nayera", 4),new account(11,6 , 6, 8, 4.5, "Nour", 5)
       ,new account(1,4 , 6, 9, 6.5, "Nada", 6),new account(44,0 , 2, 8, 4.3, "Jana", 7));

        tableaccount.setItems(dataaccount);
     
         
        VBox vaccount= new VBox(tableaccount);
        vaccount.setPadding(new Insets(20));
        
        //Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<account> filteraccount= new FilteredList<>(dataaccount, e-> true);
      
        //Will be notified whenever the value of the ObservableValue changes.   
        srchaccount.textProperty().addListener((ObsValue, oldValue, newValue)->{
                filteraccount.setPredicate(lib ->{
                    // If filter text is empty, display all students.
                    if(newValue == null || newValue.isEmpty())
                        return true;
                    String s= newValue.toLowerCase();
                    if(Integer.toString(lib.getNo_borrowed_books()).contains(s))
                        return true;
                    else if(Integer.toString(lib.getNo_reserved_books()).contains(s))
                        return true;
                    else if(Integer.toString(lib.getNo_lost_books()).contains(s))
                        return true;
                    else if(Integer.toString(lib.getNo_returned_books()).contains(s))
                        return true;
                    else if(Integer.toString(lib.getId()).contains(s))
                        return true;
                    else if(lib.getName().toLowerCase().contains(s))
                        return true;
                   
                    
                    return false;    
                });
                
                //Wrap the FilteredList in a SortedList.
            SortedList <account> sortaccount= new SortedList<>(filteraccount);
            sortaccount.comparatorProperty().bind(tableaccount.comparatorProperty());
            tableaccount.setItems(sortaccount);
        });
        
 
       
         btnMAINaccount.setOnAction((ActionEvent event) -> {
                primaryStage.setScene(scene2);
         });
       btnCALCULATE.setOnAction((ActionEvent event) -> {
            double p = Calculatefine(13);
           lp.setText(Integer.toString((int) p));
         });
         
       GridPane rootaccount= new GridPane();
       rootaccount.add(haccount, 0, 0, 3, 1);
       rootaccount.add(gaccount, 0, 1);
       rootaccount.add(vaccount, 1, 1);
       rootaccount.setAlignment(Pos.CENTER);

       // FlowPane root= new FlowPane(g, v);
        rootaccount.setId("pane2");
       
        
         scene3 = new Scene(rootaccount, 1300, 800);
         scene3.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        
        
//Scene 4
        Label l= new Label("Libraian Information: ");
         l.setStyle( "-fx-font: normal bold 30px 'serif';");

        l.getStyleClass().add("labl");
        Label id= new Label("ID");
        id.setStyle( "-fx-font: normal bold 20px 'serif';");
        TextField tid= new TextField();
        Label name= new Label("Name");
                name.setStyle( "-fx-font: normal bold 20px 'serif';");

        TextField tname= new TextField();
        Label password= new Label("password");
                        password.setStyle( "-fx-font: normal bold 20px 'serif';");

        TextField tpassword= new TextField();
        Button btnAdd= new Button("Add");
        btnAdd.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large; ");
        
       // btnAdd.setMaxWidth(Double.MAX_VALUE);
        Button btnClear= new Button("clear");
         btnClear.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large; ");
       // btnClear.setMaxWidth(Double.MAX_VALUE);
       
       
       Button btnMAIN= new Button("Back to MainPage");
         btnMAIN.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large; ");
       
       
       
       Label search= new Label("Search");
        search.setStyle( "-fx-font: normal bold 20px 'serif';");
       TextField srch= new TextField();
       srch.setPrefWidth(300);
       
        
       GridPane g= new GridPane();
        g.add(l, 0, 0, 2, 1);
        g.add(id, 0, 1);
        g.add(tid, 1, 1);
        g.add(name, 0, 2);
        g.add(tname, 1, 2);
        g.add(password, 0, 3);
        g.add(tpassword, 1, 3);
        g.add(btnAdd, 0, 4);
        g.add(btnClear, 1, 4);
        g.add(btnMAIN, 0, 9);

       
       
        g.setVgap(20);
        g.setHgap(20);
        g.setPadding(new Insets(20));
        
        HBox h= new HBox(search, srch);
        h.setPadding(new Insets(20, 0 ,20, 100));
        h.setSpacing(50);
        
        TableView <librarian>  table= new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No rows to display"));
      
        table.setMinWidth(500);
        
        TableColumn c1 = new TableColumn("ID");
        c1.setCellValueFactory(new PropertyValueFactory<>("id"));
        

        TableColumn c2 = new TableColumn("Name");
        c2.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn  c3 = new TableColumn("password");
        c3.setCellValueFactory(new PropertyValueFactory<>("password"));

        table.getColumns().addAll(c1, c2, c3);
       
       
       //A list that enables listeners to track changes when they occur
        ObservableList<librarian> data= FXCollections.observableArrayList(); 
       data.addAll(new librarian("Nayera", 1, "1234"), new librarian("Jomana", 2, "3030"),
               new librarian("Basmala", 3, "3627"), new librarian("Nour", 4, "5989"), new librarian("Tassnem", 5, "5969"));
       table.setItems(data);
     
         
        VBox v= new VBox(table);
        v.setPadding(new Insets(20));
        
        //Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<librarian> filter= new FilteredList<>(data, e-> true);
      
        //Will be notified whenever the value of the ObservableValue changes.   
        srch.textProperty().addListener((ObsValue, oldValue, newValue)->{
                filter.setPredicate(stu ->{
                    // If filter text is empty, display all students.
                    if(newValue == null || newValue.isEmpty())
                        return true;
                    String s= newValue.toLowerCase();
                    if(Integer.toString(stu.getId()).contains(newValue))
                        return true;
                    else if(stu.getName().toLowerCase().contains(s))
                        return true;
                    else if(stu.getPassword().contains(newValue))
                        return true;
                    return false;    
                });
                
                //Wrap the FilteredList in a SortedList.
            SortedList <librarian> sort= new SortedList<>(filter);
            sort.comparatorProperty().bind(table.comparatorProperty());
            table.setItems(sort);
        });
        
     btnAdd.setOnAction((ActionEvent event) -> {
        try{
         int vid= Integer.parseInt(tid.getText());
         String vname= tname.getText();
         String Vpassword= tpassword.getText();
         table.getItems().add(new librarian(vname, vid, Vpassword));
         librarian librarian1 = new librarian("Nayera", 1, "1234");
         librarian librarian2 = new librarian("Jomana", 2, "3030");
         librarian librarian3 = new librarian("Basmala", 3, "3627");
         librarian librarian4 = new librarian("Nour", 4, "5989");
         librarian librarian5 = new librarian("Tassnem", 5, "5969");
          if (vname.isEmpty()||Vpassword.isEmpty())
            {   
            }
         try {
             FileWriter fl = new FileWriter("C:\\New folder (2)\\librarian.txt");
             fl.write(librarian1.toString());
             fl.write(librarian2.toString());
             fl.write(librarian3.toString());
             fl.write(librarian4.toString());
             fl.write(librarian5.toString());
             fl.write(vname +"   "+Vpassword+"   "+vid+"\n");
             fl.close();
             
         }
         catch (FileNotFoundException e) {
             System.out.print("File not found");
         }
        }
        catch (Exception e) {
        
        System.out.println("The Fields Is Empty");
    }  

        });
         

         btnClear.setOnAction((ActionEvent event) -> {
           
            tid.clear();
            tname.clear();
            tpassword.clear();
        });
       
         btnMAIN.setOnAction((ActionEvent event) -> {
                primaryStage.setScene(scene2);
         });
       
         
       GridPane root= new GridPane();
       root.add(h, 0, 0, 3, 1);
       root.add(g, 0, 1);
       root.add(v, 1, 1);
       root.setAlignment(Pos.CENTER);
        root.setId("pane2");
       
        
       
             

       // FlowPane root= new FlowPane(g, v);
         scene4 = new Scene(root,1300, 800); 
         scene4.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

       
//SCENE5

     Label lbook1= new Label("Book Information: ");
     lbook1.setStyle( "-fx-font: normal bold 30px 'serif';");

        lbook1.getStyleClass().add("labl");
        Label title= new Label("Title");
       title.setStyle( "-fx-font: normal bold 20px 'serif';");

        TextField ttitle= new TextField();
        Label author= new Label("Author");
               author.setStyle( "-fx-font: normal bold 20px 'serif';");

        TextField tauthor= new TextField();
        Label price= new Label("Price");
               price.setStyle( "-fx-font: normal bold 20px 'serif';");

        TextField tprice= new TextField();
        Label dueDate= new Label("DueDate");
               dueDate.setStyle( "-fx-font: normal bold 20px 'serif';");

        TextField tdueDate= new TextField();
        Label feedback= new Label("Feedback");
               feedback.setStyle( "-fx-font: normal bold 20px 'serif';");

        TextField tfeedback= new TextField();
        Button btnAdd1= new Button("Add");
                         btnAdd1.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large; ");

       // btnAdd1.setMaxWidth(Double.MAX_VALUE);
        Button btnClear1= new Button("clear");
                 btnClear1.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large; ");

       // btnClear1.setMaxWidth(Double.MAX_VALUE);
       
       Button btnMAINBOOK= new Button("Back to MainPage");
         btnMAINBOOK.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large;-fx-pref-height: 18px;\n" +
"    -fx-pref-width: 200px");
         
         
       Label search1= new Label("Search");
       search1.setStyle( "-fx-font: normal bold 20px 'serif';");
       TextField srch1= new TextField();
       srch1.setPrefWidth(300);
       
        
       GridPane g1= new GridPane();
        g1.add(lbook1, 0, 0, 2, 1);
        g1.add(title, 0, 1);
        g1.add(ttitle, 1, 1);
        g1.add(author, 0, 2);
        g1.add(tauthor, 1, 2);
        g1.add(price, 0, 3);
        g1.add(tprice, 1, 3);
        g1.add(dueDate, 0, 4);
        g1.add(tdueDate, 1, 4);
        g1.add(feedback, 0, 5);
        g1.add(tfeedback, 1, 5);
        g1.add(btnAdd1, 0, 6);
        g1.add(btnClear1, 1, 6);
        g1.add(btnMAINBOOK, 0, 9);

       
        g1.setVgap(20);
        g1.setHgap(20);
        g1.setPadding(new Insets(20));
        
        HBox h1= new HBox(search1, srch1);
        h1.setPadding(new Insets(20, 0 ,20, 100));
        h1.setSpacing(50);
        
        TableView <book>  booktable= new TableView<>();
        booktable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        booktable.setPlaceholder(new Label("No rows to display"));
        booktable.setMinWidth(500);
   
      
        
        TableColumn col1 = new TableColumn("Title");
        col1.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn col2 = new TableColumn("Author");
        col2.setCellValueFactory(new PropertyValueFactory<>("author"));
        
        TableColumn  col3 = new TableColumn("Price");
        col3.setCellValueFactory(new PropertyValueFactory<>("price"));
        
         TableColumn  col4 = new TableColumn("DueDate");
        col4.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

         TableColumn  col5 = new TableColumn("Feedback");
        col5.setCellValueFactory(new PropertyValueFactory<>("feedback"));


        booktable.getColumns().addAll(col1, col2, col3,col4,col5);
       
       
       //A list that enables listeners to track changes when they occur
        ObservableList<book> databook= FXCollections.observableArrayList(); 
       databook.addAll(new book("Pride and Prejudice", "Jane Austen", 100, "2000", "5/10"), new book("ard al naam", "ahmed mahmoud", 150, "1990", "6/10"),
               new book("Ali Maaloul", "Basmla Osama", 200, "2016", "10/10"), new book("Messi", "Jomana Reda", 2000, "2003", "11/10"),new book("The Great Gatsby", "F. Scott Fitzgerald", 1600, "1950", "7/10"),
               new book("To Kill a Mockingbird", "Harper Lee", 500, "1960", "2/10"));
       booktable.setItems(databook);
      
        VBox v1= new VBox(booktable);
        v1.setPadding(new Insets(20));
        
        //Wrap the ObservableList in a FilteredList (initially display all databook).
        FilteredList<book> filter1= new FilteredList<>(databook, e-> true);
      
        //Will be notified whenever the value of the ObservableValue changes.   
        srch1.textProperty().addListener((ObsValue, oldValue, newValue)->{
                filter1.setPredicate(b1 ->{
                    // If filter text is empty, display all students.
                    String sbook= newValue.toLowerCase();
                    if(newValue == null || newValue.isEmpty())
                        return true;
//                    String s= newValue.toLowerCase();
                    if(b1.getTitle().toLowerCase().contains(sbook))
                        return true;
                    else if(b1.getAuthor().toLowerCase().contains(sbook))
                        return true;
                   
                    return false;    
                });
                //Wrap the FilteredList in a SortedList.
            SortedList <book> sort1= new SortedList<>(filter1);
            sort1.comparatorProperty().bind(booktable.comparatorProperty());
            booktable.setItems(sort1);
        });
        
      
        btnAdd1.setOnAction((ActionEvent event) -> {
       book book1= new book("Pride and Prejudice", "Jane Austen", 100, "2000", "5/10");
       book book2= new book("ard al naam", "ahmed mahmoud", 150, "1990", "6/10");
       book book3= new book("Ali Maaloul", "Basmla Osama", 200, "2016", "10/10");
       book book4= new book("Messi", "Jomana Reda", 2000, "2003", "11/10");
       book book5= new book("The Great Gatsby", "F. Scott Fitzgerald", 1600, "1950", "7/10");
       book book6= new book("To Kill a Mockingbird", "Harper Lee", 500, "1960", "2/10");
           try {
            String vtitle= ttitle.getText();
            String vauthor= tauthor.getText();
            double vprice= Double.parseDouble(tprice.getText());
            String vduedate= tdueDate.getText();
            String vfeedback= tfeedback.getText();
            booktable.getItems().add(new book(vtitle, vauthor,  vprice, vduedate, vfeedback));
            
            if (vtitle.isEmpty() || vauthor.isEmpty()||vduedate.isEmpty()||vfeedback.isEmpty())
            {   
            } 
            
           try{  
               FileWriter f2 = new FileWriter("C:\\New folder (2)\\book.txt");
           f2.write(book1.toString());
           f2.write(book2.toString());
           f2.write(book3.toString());
           f2.write(book4.toString());
           f2.write(book5.toString());
           f2.write(book6.toString());
           f2.write(vtitle+"  "+vauthor+" "+ vprice+"  "+ vduedate+"   "+vfeedback);
           f2.close();
           }
           catch(Exception e){
           }
           } 
           catch (Exception e) {
        System.out.println("The Fields Is Empty");
    }  
       
        });

        
         btnClear1.setOnAction((ActionEvent event) -> {
           
            ttitle.clear();
            tauthor.clear();
            tprice.clear();
            tdueDate.clear();
            tfeedback.clear();
        });
        btnMAINBOOK.setOnAction((ActionEvent event) -> {
                primaryStage.setScene(scene2);
         });
         
       GridPane root1= new GridPane();
       root1.add(h1, 0, 0, 3, 1);
       root1.add(g1, 0, 1);
       root1.add(v1, 1, 1);
       root1.setAlignment(Pos.CENTER);

       scene5 = new Scene(root1, 1300, 800);
 root1.setId("pane2");
       
        
       
             

       // FlowPane root= new FlowPane(g, v);
         scene5.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

       
//SCENE6

Label lauthor= new Label("Author and Poet Information: ");
     lauthor.setStyle( "-fx-font: normal bold 30px 'serif'; ");
        lauthor.getStyleClass().add("labl");
        
        Label lpAUTHOR= new Label("?");
        
       
        
        Button btnAddauthor= new Button("Write");
        btnAddauthor.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large; ");

       
       
       Button btnMAINauthor= new Button("Back to MainPage");
         btnMAINauthor.setStyle("-fx-background-color: DARKRED;  -fx-text-fill: white;  -fx-font-size: large;-fx-pref-height: 18px;\n" +
"    -fx-pref-width: 200px");
         
        
        
        
         GridPane gauthor=new GridPane();
         gauthor.add(lauthor, 0, 0, 2, 1);
       gauthor.setAlignment(Pos.CENTER);
        gauthor.add(btnAddauthor, 0, 6);
        gauthor.add(lpAUTHOR, 1, 6);
        
         gauthor.add(btnMAINauthor, 0,7);
       gauthor.setVgap(20);
        gauthor.setHgap(20);
        gauthor.setPadding(new Insets(20));
         
         btnAddauthor.setOnAction((ActionEvent event) -> {
             Poet poet=new Poet(STYLESHEET_MODENA, STYLESHEET_MODENA, STYLESHEET_CASPIAN);
             String pauthor = poet.write();
             lpAUTHOR.setText(pauthor);
         });
         
        btnMAINauthor.setOnAction((ActionEvent event) -> {
                primaryStage.setScene(scene2);
         });
        
       GridPane rootauthor= new GridPane();
      
       rootauthor.add(gauthor, 0, 1);
       

       rootauthor.setAlignment(Pos.CENTER);
       
       scene6 = new Scene(rootauthor, 1300, 800);
        rootauthor.setId("pane2");
       
         scene6.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());

        //show
        primaryStage.setResizable(true);
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

//main
public static void main(String[] args) {
    
             librarian librarian1 = new librarian("Nayera", 1, "1234");
             librarian librarian2 = new librarian("Jomana", 2, "3030");
              librarian librarian3 = new librarian("Basmala", 3, "3627");
             librarian librarian4 = new librarian("Nour", 4, "5989");
            librarian librarian5 = new librarian("Tassnem", 5, "5969");
              try {
             FileWriter fl = new FileWriter("C:\\New folder (2)\\librarian.txt");
             fl.write(librarian1.toString());
             fl.write(librarian2.toString());
             fl.write(librarian3.toString());
             fl.write(librarian4.toString());
             fl.write(librarian5.toString());
            
             fl.close();

        }
              
        catch (IOException e) {
                System.out.println("File not found");
        }
        
       book book1= new book("Pride and Prejudice", "Jane Austen", 100, "2000", "5/10");
       book book2= new book("ard al naam", "ahmed mahmoud", 150, "1990", "6/10");
       book book3= new book("Ali Maaloul", "Basmla Osama", 200, "2016", "10/10");
       book book4= new book("Me"
               + "ssi", "Jomana Reda", 2000, "2003", "11/10");
       book book5= new book("The Great Gatsby", "F. Scott Fitzgerald", 1600, "1950", "7/10");
       book book6= new book("To Kill a Mockingbird", "Harper Lee", 500, "1960", "2/10");
        try{  
               FileWriter f2 = new FileWriter("C:\\New folder (2)\\book.txt");
           f2.write(book1.toString());
           f2.write(book2.toString());
           f2.write(book3.toString());
           f2.write(book4.toString());
           f2.write(book5.toString());
           f2.write(book6.toString());
           f2.close();
           }
           catch(Exception e){
           
           }
         account account1 = new account(3,4 , 2, 8, 44.0, "Jomana", 1);
         account account2 = new account(10,7 , 6, 8, 4.5, "Basmala", 2);
         account account3 = new account(13,5 , 3, 7, 4.3, "Tassnem", 3);
         account account4 = new account(23,3 , 6, 8, 4.5, "Nayera", 4);
         account account5 = new account(1,4 , 6, 9, 6.5, "Nada", 6);
         account account6 = new account(44,0 , 2, 8, 4.3, "Jana", 7);
          try{  
               FileWriter f3 = new FileWriter("C:\\New folder (2)\\account.txt");
           f3.write(account1.toString());
           f3.write(account2.toString());
           f3.write(account3.toString());
           f3.write(account4.toString());
           f3.write(account5.toString());
           f3.write(account6.toString());
           f3.close();
           }
           catch(Exception e){
               
           }
      launch(args);
}
}