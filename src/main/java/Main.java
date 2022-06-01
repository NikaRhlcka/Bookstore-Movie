import TrainingSession.MovieDAOImpl;
import TrainingSession.MoviesCommands;
import TrainingSession.MoviesController;
import products.ProductController;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        /*
        ProductController productController = new ProductController();

        System.out.println("Welcome to the supermarket!");

        String input = "";

        do {
            System.out.println("""
                    What would you like to do?
                    1.Add products to supermarket
                    2.List products in supermarket
                    3.Update product details in supermarket
                    4.Find products by name
                    5.Find products by id
                    6.Delete product by id
                    """);

            input = scanner.nextLine();

            switch (input) {
                case "quit":
                    System.out.println("Closing application.");
                    break;
                case "1":
                    productController.createProduct();
                    break;
                case "2":
                    productController.listProducts();
                    break;
                case "3":
                    productController.updateProduct();
                    break;
                case "4":
                    productController.findProductsByName();
                    break;
                case "5":
                    productController.findProductsById();
                    break;
                case "6":
                    productController.deleteById();
                    break;
                default:
                    System.out.println("Please enter a valid input");
                    break;

            }

        }while (!input.equalsIgnoreCase("quit")) ;
    }
*/


        //Movies Training session
/*
        MoviesController moviesController = new MoviesController();

        System.out.println("Welcome to the movie shop!");

        String input = "";


        //use only one time when creating a table at the beginning
        try{
            MoviesCommands moviesCommands = new MoviesCommands();
            moviesCommands.createTable();
            System.out.println("Table created");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error creating table.");
        }*/


        /*do {
            System.out.println("""
                    What would you like to do?
                    1.Add movie
                    2.Update movies record by ID
                    3.Delete selected movie by ID
                    4.Display all movies
                    """);

            input = scanner.nextLine();

           switch (input) {
                case "quit":
                    System.out.println("Closing application.");
                    break;
                case "1":
                    moviesController.addMovie();
                    break;
               case "2":
                   //
                   break;
               case "3":
                   //
                   break;
               case "4":
                   //
                   break;
                default:
                    System.out.println("Please enter a valid input");
                    break;

            }

        }while (!input.equalsIgnoreCase("quit")) ;
    }*/


        MovieDAOImpl movieDAOImpl = new MovieDAOImpl();
        movieDAOImpl.createTable();
    }
}
