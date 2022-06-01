package TrainingSession;

public class Movie {
    public int id;
    public String title;
    public String genre;
    public int yearOfRelease;

  /*  public Movie(int id, String title, String genre, int yearOfRelease){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }*/

    public Movie(String title, String genre, int yearOfRelease){
        this.title = title;
        this.genre = genre;
        this.yearOfRelease = yearOfRelease;
    }

    public Movie(){}

    public int getID(){
        return id;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                '}';
    }
}
