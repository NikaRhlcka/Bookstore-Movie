package products;

import database.DBHandler;

import javax.xml.transform.Result;
import java.net.ProxySelector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductRepository {
    DBHandler dbHandler = new DBHandler();


    //create a table for product
    //if a method has the ability to return an error than either specify an error while creating the method
    //or wrap the code in try-catch to handle the error properly
    public void createTable() throws SQLException {
        String query = "CREATE TABLE products(id int(11) PRIMARY KEY, name varchar(50) NOT NULL, price double(12,2) NOT NULL, quantity int(11) DEFAULT 0, description varchar(120))";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public void create(Product product) throws SQLException{
        String query = "INSERT INTO products(name, price, quantity, description) VALUES(?,?,?,?)";

        //create prepare statement to help execute query
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        //set value for ? placeholders
        preparedStatement.setString(1, product.name);
        preparedStatement.setDouble(2, product.price);
        preparedStatement.setInt(3,product.getQuantity());
        preparedStatement.setString(4,product.description);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public ArrayList<Product> getAll() throws SQLException{
        //specify query to get all columns in the products table
        String query = "SELECT * FROM products";

        //create statement variable
        Statement statement = dbHandler.getConnection().createStatement();

        //query the statement with the query string created and store the results in a result set
        ResultSet result = statement.executeQuery(query);

        //create arraylist to hold the result gotten from the database
        ArrayList<Product> products = new ArrayList<>();

        //loop through result with result.next() and save each record to the
        while (result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            double price = result.getDouble("price");
            int quantity = result.getInt("quantity");
            String description = result.getString("description");

            products.add(new Product(id,name, price, quantity, description));
        }

        statement.close();
        return products;
    }

    public Product findById(int id) throws SQLException{
        String query = "SELECT * FROM products WHERE id=?";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.setInt(1,id);
        preparedStatement.execute();

        ResultSet result = preparedStatement.getResultSet();



        if(result.next()){
            int resultId = result.getInt("id");
            String name = result.getString("name");
            double price = result.getDouble("price");
            int quantity = result.getInt("quantity");
            String description = result.getString("description");

            return new Product(resultId, name, price, quantity, description);
        }else{
            return null;
        }
    }

    public void update(Product product) throws SQLException{
        String query = "UPDATE products SET name = ?, price = ?, quantity = ?, description = ? WHERE id=?";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.setString(1,product.name);
        preparedStatement.setDouble(2,product.price);
        preparedStatement.setInt(3,product.getQuantity());
        preparedStatement.setString(4,product.description);
        preparedStatement.setInt(5,product.getId());

        preparedStatement.execute();
        preparedStatement.close();
    }

    public ArrayList<Product> getProductByName(String name) throws SQLException{
        String query = "SELECT * FROM products WHERE name=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1,name);

        preparedStatement.execute();

        ResultSet result = preparedStatement.getResultSet();

        ArrayList<Product> products = new ArrayList<>();

        while(result.next()){
            int id = result.getInt("id");
            String productName = result.getString("name");
            double price = result.getDouble("price");
            int quantity = result.getInt("quantity");
            String description = result.getString("description");

            //created new product and added it
            products.add(new Product(id, productName, price,quantity,description));
        }
        preparedStatement.close();

        return products;
    }

    //deleting products by id because its unique
    public void delete(int id) throws SQLException{
        String query = "DELETE FROM products WHERE id=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();

    }


}
