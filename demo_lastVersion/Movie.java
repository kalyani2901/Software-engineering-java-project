import javax.swing.ImageIcon;
/**
 * <pre>
 * This class represents a product of category Movie in the store.
 * It holds the properties of a movie item, including the quantity in stock and price.
 * </pre>
 */
public class Movie
{   
   /**
	* <pre>
	* The Movie's full name.
	* </pre>
	*/
    private String title;
    
    /**
	* <pre>
	* The Movie's year of release.
	* </pre>
	*/
    private int year;
    
    /**
	* <pre>
	* The Movie's genre; category of movie like horror,melodrama,action,etc.
	* </pre>
	*/
    private String genre;
    
    /**
	* <pre>
	* The Movie's director.
	* </pre>
	*/
    private String director; 
    
    /**
	* <pre>
	* The number of films in a Movie's series.
	* </pre>
	*/
    private int numberOfFilms;
    
    /**
	* <pre>
	* The Movie's quantity in stock.
	* </pre>
	*/
    private int quantity;
    
    /**
	* <pre>
	* The price of Movie item(DVD,CD,etc)
	* </pre>
	*/
    private float price;

    /**
     * Constructor for objects of class Movie
     */
    public Movie()
    {
        title = "";
        year = 0;
        genre = "";
        director = "";
        numberOfFilms = 0;
        quantity = 0;
        price = 0;
    }
    
    public Movie(String title1,int year1,String genre1,String director1, int numberOfFilms1,int quantity1,float price1)
    {
        title = title1;
        year = year1;
        genre = genre1;
        director = director1;
        numberOfFilms=numberOfFilms1;
        quantity = quantity1;
        price = price1;
    }

   public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getNumberOfFilms() {
        return numberOfFilms;
    }

    public void setNumberOfFilms(int numberOfFilms) {
        this.numberOfFilms = numberOfFilms;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
     public String toString ()
    {
        return String.format("Name: "+ title  + "<br/>" + "Release Year: "+ year + "<br/>" + "Genre: " + genre + "<br/>" + "Directed By: " + director + "<br/>" + "No. Of Parts: " + numberOfFilms + "<br/>" + "Price ($): "+ price);
    }

    
}