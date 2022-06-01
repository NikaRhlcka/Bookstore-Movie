package TrainingSession;

import products.ProductRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class MoviesController {
    MoviesCommands moviesCommands = new MoviesCommands();
    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    public void createTable(){
        try {
            System.out.println("Creating new table");
            moviesCommands.createTable();
            System.out.println("Table created successfully!");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error creating table.");
        }
    }

    public void addMovie(){
        try {
            System.out.println("Adding movie...");

            System.out.println("Title: ");
            String title = scanner.nextLine();

            System.out.println("Genre ");
            String genre = scanner.nextLine();

            System.out.println("Year of release: ");
            int yearOfRelease = intScanner.nextInt();

            Movie movie = new Movie(title, genre, yearOfRelease);

            moviesCommands.addMovie(movie);
            System.out.println("Movie added successfully!");

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error while adding movie!");
        }
    }

    public void update(){
        System.out.println("Updating a movie...");

        System.out.println("Title: ");

    }


}
