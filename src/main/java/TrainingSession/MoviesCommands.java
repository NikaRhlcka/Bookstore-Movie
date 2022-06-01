package TrainingSession;

import database.DBHandler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MoviesCommands {
    DBHandler dbHandler = new DBHandler();

    public void createTable() throws SQLException {
        String query = "CREATE TABLE movies(id int PRIMARY KEY AUTO_INCREMENT, title varchar(255), genre varchar(255), yearOfRelease int(10))";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public void addMovie(Movie movie) throws SQLException{
        String query = "INSERT INTO movies(title, genre, yearOfRelease) VALUES(?,?,?)";

        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        preparedStatement.setString(1, movie.title);
        preparedStatement.setString(2, movie.genre);
        preparedStatement.setInt(3,movie.yearOfRelease);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public void updateMovie(Movie movie) throws SQLException{
        String query = "UPDATE movies SET title=?, genre=?, yearOfRelease=? WHERE id=?";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);

        preparedStatement.setString(1, movie.title);
        preparedStatement.setString(2, movie.genre);
        preparedStatement.setInt(3,movie.yearOfRelease);
        preparedStatement.setInt(4, movie.getID());

        preparedStatement.execute();
        preparedStatement.close();
    }

}
