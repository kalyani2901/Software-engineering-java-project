/**
 * <pre>
 * This class represents a product of category Game in the store.
 * It holds the properties of a game item, including the quantity in stock and price.
 * </pre>
 */
public class Game
{
    /**
	* <pre>
	* The Game's full name.
	* </pre>
	*/
    private String title;
    
    /**
	* <pre>
	* The Game's year of release.
	* </pre>
	*/
    private int year;
    
    /**
	* <pre>
	* The platform compatible with Game, like windows,etc.
	* </pre>
	*/
    private String platform;
    
    /**
	* <pre>
	* The Game's director.
	* </pre>
	*/
    private String publisher;
    
    /**
	* <pre>
	* The Game's quantity in stock.
	* </pre>
	*/
    private int quantity;
    
    /**
	* <pre>
	* The price of Game item
	* </pre>
	*/
    private float price;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        title = "";
        year = 0;
        platform = "";
        publisher = "";
        quantity = 0;
        price = 0;
    }

    public Game(String title1,int year1,String platform1,String publisher1, int quantity1,float price1)
    {
        title = title1;
        year = year1;
        platform = platform1;
        publisher = publisher1;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
        return String.format("Name: "+ title  + "<br/>" + "Release Year: "+ year + "<br/>" + "Platform: " + platform + "<br/>" + "Publisher: " + publisher + "<br/>" + "Price ($): "+ price);
    }
    
    
}