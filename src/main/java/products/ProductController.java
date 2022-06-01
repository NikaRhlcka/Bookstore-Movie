package products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.err;
import static java.lang.System.in;

public class ProductController {
    ProductRepository productRepository = new ProductRepository();
    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);

    public void createTable(){
        try{
            productRepository.createTable();
            System.out.println("Created a product successfully!");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Product creation failed.");
        }
    }

    public void createProduct(){
        try{
            System.out.println("Add product to supermarket");

            System.out.println("Product Name: ");
            String name = scanner.nextLine();

            System.out.println("Price: ");
            double price = intScanner.nextDouble();

            System.out.println("Quantity: ");
            int quantity = intScanner.nextInt();

            System.out.println("Description: ");
            String description = scanner.nextLine();

            Product product = new Product(name,price,quantity,description);

            productRepository.create(product);
            System.out.println(name + " added to the supermarket!");

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to add product to supermarket.");
        }
    }

    public void listProducts(){
        try{
            System.out.println(productRepository.getAll());
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Cannot retrieve products from database.");
        }
    }

    public void updateProduct(){
        try{
            System.out.println("Update product in supermarket");
            System.out.println("Enter product id to update:");
            int id = intScanner.nextInt();

            Product product = productRepository.findById(id);
            System.out.println("Name: (" + product.name + ") ");
            product.name = scanner.nextLine();

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to update product!");
        }
    }

    public void findProductsByName(){
        try{
            System.out.println("Find products by name");

            String name = scanner.nextLine();
            ArrayList<Product> products = productRepository.getProductByName(name);
            System.out.println(products);

        }catch(SQLException e){
            e.printStackTrace();//prints info about error
            System.out.println("Error finding product!");
        }
    }

    public void findProductsById(){
        try{
        System.out.println("Find product by Id");

        //read product id from user
        int id = intScanner.nextInt();

        //call method
        Product product = productRepository.findById(id);
            System.out.println(product);

    }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error");
        }
    }


    public void deleteById(){
        //outside 'try' block to use it in 'catch' block too
        System.out.println("Delete product by id");
        int id = intScanner.nextInt();

        try{
            productRepository.delete(id);
            System.out.println("Product deleted successfully");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error deleting product" + id);


        }
    }


}
