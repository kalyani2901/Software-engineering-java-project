/**
 * <pre>
 * This class represents a product of category TV Series in the store.
 * It holds the properties of a tv series item, including the quantity in stock and price.
 * </pre>
 */
public class TvSeries
{
    /**
	* <pre>
	* The Tv Series's full name.
	* </pre>
	*/
    private String title;
    
    /**
	* <pre>
	* The TV Series's year of release. It holds the release year of first season of the series.
	* </pre>
	*/
    private int year;
    
    /**
	* <pre>
	* The TV Series's genre; category of series like horror, melodrama, action,etc.
	* </pre>
	*/
    private String genre;
    
    /**
	* <pre>
	* The TV Series's director.
	* </pre>
	*/
    private String director;
    
    /**
	* <pre>
	* The star,i.e, the lead actor/actress of the TV Series.
	* </pre>
	*/
    private String stars;
    
    /**
	* <pre>
	* The TV Series's quantity in stock.
	* </pre>
	*/
    private int quantity;
    
    /**
	* <pre>
	* The number of seasons in a TV series.
	* </pre>
	*/
    private int seasons;
    
    /**
	* <pre>
	* The price of Tv Series item (DVD,CD,etc)
	* </pre>
	*/
    private float price;

    /**
     * Constructor for objects of class TvSeries
     */
    public TvSeries()
    {
        title = "";
        year = 0;
        genre = "";
        director = "";
        stars = "";
        quantity = 0;
        seasons =0;
        price = 0;
    }

     public TvSeries(String title1,int year1,String genre1,String director1, String stars1,int quantity1,int seasons1,float price1)
    {
        title = title1;
        year = year1;
        genre = genre1;
        director = director1;
        stars=stars1;
        quantity = quantity1;
        seasons = seasons1;
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

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getQuantity() {
        return quantity;
    }

     public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

      public int getSeasons() {
        return seasons;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
     public String toString ()
    {
        return String.format("Name: "+ title  + "<br/>" + "Release Year: "+ year + "<br/>" + "Genre: " + genre + "<br/>" + "Directed By: " + director + "<br/>" + "Stars: " + stars + "<br/>" + "No. of Seasons: " + seasons + "<br/>" + "Price ($): "+ price);
    }
    
}