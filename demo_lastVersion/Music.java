/**
 * <pre>
 * This class represents a product of category Music in the store.
 * It holds the properties of a music item, including the quantity in stock and price.
 * </pre>
 */
public class Music
{
     /**
	* <pre>
	* The Music album's full name.
	* </pre>
	*/
    private String title;
    
    /**
	* <pre>
	* The Music album's year of release.
	* </pre>
	*/
    private int year;
    
    /**
	* <pre>
	* The Music's genre; category of music like rock, traditional, pop,etc.
	* </pre>
	*/
    private String genre;
    
    /**
	* <pre>
	* The Music album's singer.
	* </pre>
	*/
    private String singer;
    
    /**
	* <pre>
	* The Music album's quantity in stock.
	* </pre>
	*/
    private int quantity;
    
     /**
	* <pre>
	* The price of Music item(DVD,CD,etc)
	* </pre>
	*/
    private float price;

    /**
     * Constructor for objects of class Music
     */
    public Music()
    {
       title = "";
        year = 0;
        genre = "";
        singer = "";
        quantity = 0;
        price = 0;
    }

       public Music(String title1,String genre1,String singer1,int year1, int quantity1,float price1)
    {
        title = title1;
        year = year1;
        genre = genre1;
        singer = singer1;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
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
        return String.format("Name: "+  title+ "<br/>" + "Release Year: "+ year + "<br/>" + "Genre: " + genre + "<br/>" + "Singer: " + singer+ "<br/>" + "Price ($): "+ price);
    }
    
}