/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;
import library.Library;
import library.account;
import library.author;
import library.book;
import library.librarian;

public class LibrarySystemGUI extends Application {

    private Label messageLabel = new Label();
    private account account;
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        Button displayButton = new Button("Display Info");
        displayButton.setOnAction(e -> display());

        root.getChildren().addAll(displayButton, messageLabel);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Library System GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void display() {
        try {
            // Example usage of creating objects of classes
            librarian librarian1 = new librarian("nour amer", 2556156, "nour09090909");
            librarian librarian2 = new librarian("tassneem omar", 2556157, "tasnim123");
            librarian librarian3 = new librarian("nayera nagy", 2556158, "nayera123");
            book book = new book("ard al naam", "mohamed ahmed", "99098", "6585742568965", 0, "1988-09-29", true, "perfect", true, true);
            author author = new author("ALI AL-SHEIKH", "Male", "mohamed44@gmail.com");
       Library librarySystem = new Library("MALE", "MOHAMED MAHMOUD", "MOHAMED123546");

            // Example usage of methods
            System.out.println(librarySystem.toString());
            System.out.println();
            account.checkAccount();
            account.getBookInfo();
            account.Calculate_fine(13);
            System.out.println(account.toString());
            System.out.println(account.getNo_borrowed_books());
            System.out.println();
            System.out.println(librarian1.toString());
            System.out.println(librarian2.toString());
            System.out.println();

            // Save to files
            try (FileWriter f = new FileWriter("test1.txt");
                 FileWriter f1 = new FileWriter("test2.txt");
                 FileWriter f2 = new FileWriter("test3.txt");
                 FileWriter f3 = new FileWriter("test4.txt")) {
                f.write("login" + librarySystem.toString());
                f1.write(account.toString());
                f2.write(account.getNo_borrowed_books());
                f3.write(librarian1.toString());
                f3.write(librarian2.toString());
                f3.write(librarian3.toString());
                f3.write(librarySystem.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Read from file
            System.out.println("Enter the id : ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();

            try (BufferedReader reader = new BufferedReader(new FileReader("test4.txt"))) {
                String line;
                boolean idExists = false;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    int librarianId = Integer.parseInt(parts[3]);
                    if (librarianId == librarian1.getId()) {
                        idExists = true;
                        break;
                    }
                }

                if (idExists) {
                    System.out.println("The id exists");
                } else {
                    System.out.println("The id doesn't exist");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Update the message label in the GUI
            messageLabel.setText("Information displayed!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}