import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.util.Map;
import java.util.Set;
public class DummyModel implements Model {

    ArrayList<Product> productList = new ArrayList<Product>();
    HashMap<String, String> passwords = new HashMap<>();
    HashMap<String, Customer> details = new HashMap<>();
    HashMap<String, Cart> CustomerCart = new HashMap<>();
    HashMap<Float, Order> orders = new HashMap<>();
    Product product;
    String record="";
    
    /**constructor of DummyModel
       files will be read and stored to corresponding hashmap or arrayList*/
   public DummyModel(){
    /**read from file*/
      try{
         // create filewriter and bufferedreader
         FileReader cusStream=new FileReader("cust.txt");
         BufferedReader cusIn = new BufferedReader(cusStream);
         FileReader movStream=new FileReader("files/Movies.txt");
         FileReader gamStream=new FileReader("files/Game.txt");
         FileReader musicStream=new FileReader("files/Music.txt");
         FileReader seriesStream=new FileReader("files/TvSeries.txt");
         BufferedReader movIn = new BufferedReader(movStream);
         BufferedReader gamIn = new BufferedReader(gamStream);
         BufferedReader musIn = new BufferedReader(musicStream);
         BufferedReader serIn = new BufferedReader(seriesStream);
         String line;//define a common String to iterator
        /** read cust.txt and store in detail and password hashmap*/
        while ((line = cusIn.readLine()) != null)
        {
            String[] parts = line.split(":");//spilt a line of record by : and stored into a String List
            if (parts.length == 2)//only the lines can be spilt into 2 parts by : will be read
            {
                String[] cuDetail = parts[1].split(",");//further spilt the second part by ,
                Customer cu = new Customer(cuDetail[1],cuDetail[2],cuDetail[3],cuDetail[4]);//use constractor to generate a new Customer
                details.put( parts[0], cu); //add key and Customer into details hashmap
                passwords.put( parts[0],cuDetail[0]);//add key and password into passwords hashmap
            } 
        }        
        cusIn.close();
        
        /** read movie.txt and store in productList*/
        while ((line = movIn.readLine()) != null)
        {
            String[] parts = line.split(":");
            if (parts.length == 2)
            {
                String[] moDetail = parts[1].split(",");
                Movie mo = new Movie(parts[0],Integer.parseInt(moDetail[0]),moDetail[1],moDetail[2],Integer.parseInt(moDetail[3]),Integer.parseInt(moDetail[4]),Float.parseFloat(moDetail[5]));
                Product birb = new Product(parts[0]);
                birb.setProperty(parts[0],"CATEGORY : MOVIE",mo);//use setProperty method to add value to 2 hashmaps in Product
                productList.add(birb);//add product to productList
            } 
        } 
        movIn.close();
        
        /** read music.txt and store in productList*/
        while ((line = musIn.readLine()) != null)
        {
            String[] parts = line.split(":");
            if (parts.length == 2)
            {   
                String key = parts[0];
                String value = parts[1];
                String[] musicDetail = value.split(",");
                Music music = new Music(key,musicDetail[0],musicDetail[1],Integer.parseInt(musicDetail[2]),Integer.parseInt(musicDetail[3]),Float.parseFloat(musicDetail[4]));
                Product birb = new Product(key);
                birb.setProperty(key,"CATEGORY : MUSIC",music);
                productList.add(birb);
            } else {
                //System.out.println("ignoring line: " + line);
            }
        }
        musIn.close();
        
        /** read game.txt and store in productList*/
        while ((line = gamIn.readLine()) != null)
        {
            String[] parts = line.split(":");
            if (parts.length == 2)
            {   
                String key = parts[0];
                String value = parts[1];
                String[] gaDetail = value.split(",");
                Game ga = new Game(key,Integer.parseInt(gaDetail[0]),gaDetail[1],gaDetail[2],Integer.parseInt(gaDetail[3]),Float.parseFloat(gaDetail[4]));
                Product birb = new Product(key);
                birb.setProperty(key,"CATEGORY : GAMES",ga);
                productList.add(birb);
            } 
        }
        gamIn.close();
        
        /** read TvSeries.txt and store in productList*/
            while ((line = serIn.readLine()) != null)
        {
            String[] parts = line.split(":");
            if (parts.length == 2)
            {
                String key = parts[0];
                String value = parts[1];
                String[] serDetail = value.split(",");
                TvSeries tv = new TvSeries(key,Integer.parseInt(serDetail[0]),serDetail[1],serDetail[2],serDetail[3],Integer.parseInt(serDetail[4]),Integer.parseInt(serDetail[5]),Float.parseFloat(serDetail[5]));
                Product birb = new Product(key);
                birb.setProperty(key,"CATEGORY : TV SERIES", tv);
                productList.add(birb);
            } 
        } 
        serIn.close();
        
      }
      catch(IOException i) {
         i.printStackTrace();    
         return;
      }
      readOrder();//read order.txt and stored in orders hashmap
    }
  
    /** get the List of products
       @return type: List<Product>*/
    public List<Product> getProducts() {
        return productList;
    }
    
    /** search an item in 'orders' hashmap and stored the orders contain that item into an arraylist
     * @param: String itemname
       @return type: List<Order>*/
    public List<Order> getSearchResult(String item){
        ArrayList<Order> searchResult = new ArrayList<Order>();
        Iterator<Map.Entry<Float, Order>> ord = orders.entrySet().iterator();
        while (ord.hasNext()) {
            Map.Entry<Float, Order> ordMap = ord.next();
            for(CartItem ci:ordMap.getValue().getCustOrder().getList()){
                if(ci.getProduct().getName().equals(item)){
                    searchResult.add(ordMap.getValue());
                }
            }
        }
        return searchResult;
    }
    
    /** search an item with date in 'orders' hashmap and stored the orders contain that item in that date into an arraylist
     * @param : String itemname,String ordered date
       @return type: List<Order>*/
    public List<Order> getSearchResult(String item,String date){
        ArrayList<Order> searchResult = new ArrayList<Order>();
        Iterator<Map.Entry<Float, Order>> ord = orders.entrySet().iterator();
        while (ord.hasNext()) {
            Map.Entry<Float, Order> ordMap = ord.next();
            if(ordMap.getValue().getDateTime().equals(date)){
                for(CartItem ci:ordMap.getValue().getCustOrder().getList()){
                    if(ci.getProduct().getName().equals(item)){
                        searchResult.add(ordMap.getValue());
                    }
                }
            }
        }
        return searchResult;
    }
    
    /** login to the system with username and passowrd. If successful,the method will return ture, otherwise it will return false
     * @param : String username, String password
       @return type: boolean */
    public boolean login(String username, String password) {
        if(username.equals("admin")){
            return password.equals("admin");
        }
        if(passwords.containsKey(username)){
            return passwords.get(username).equals(password);
        }
        return false;
    }
    
    /** sign up to the system with username and passowrd. 
     * Check in hashmap whether the username is already exist or not. If exist, return falses and do nothing.
     * If successful,the method will return ture.
     * @param : String username, String password
       @return type: boolean */
    public boolean signup(String username, String password) {
        if(passwords.containsKey(username)) return false;
        passwords.put(username, password);
        details.put(username, new Customer(username, " ", " ", " "));
        return true;
    }

    /**write cust to file
       get customer information from hashmaps: details and passwords
       matching common key for the two hashmaps and store information together into one line of file*/
    public void write() {
        try {
            FileWriter fstream;
            BufferedWriter out;
            // create your filewriter and bufferedreader
            fstream = new FileWriter("cust.txt");
            out = new BufferedWriter(fstream);
            // create your iterator for your map
            Iterator<Map.Entry<String, String>> psd = passwords.entrySet().iterator();
            Iterator<Map.Entry<String, Customer>> det = details.entrySet().iterator();
            // then use the iterator to loop through the map, stopping when we reach the
            // last record in the map or when we have printed enough records
            while (psd.hasNext()) {
                while (det.hasNext()) {
                    Map.Entry<String, String> pairs = psd.next();
                    // the key/value pair is stored here in pairs
                    Map.Entry<String, Customer> info = det.next();
                    if(info.getKey().equals(pairs.getKey())){
                        //System.out.println(pairs.getKey()+":" + pairs.getValue()+ ","+info.getValue().getName()+"," +info.getValue().getAddress()+"," +info.getValue().getCardNumber()+"," +info.getValue().getPhoneNumber()+ "\n");
                        out.write(pairs.getKey()+":" + pairs.getValue()+ ","+info.getValue().getName()+"," +info.getValue().getAddress()+"," +info.getValue().getCardNumber()+"," +info.getValue().getPhoneNumber()+ "\n");
                    }
            }
            // lastly, close the file and end
            out.close();
         } 
        }
        catch(IOException i) {
                  i.printStackTrace();
                  return;}
    }
    
    /** read order.txt and store in orders hashmap*/
    public void readOrder(){
        try {
            FileReader ordStream=new FileReader("order.txt");
            BufferedReader ordIn = new BufferedReader(ordStream);
            String line;
            while ((line = ordIn.readLine()) != null)
            {
                String[] parts = line.split(":");
                if (parts.length == 2)
                {
                    Float key = Float.parseFloat(parts[0]);
                    String value = parts[1];
                    String[] ordDetail = value.split(",");
                    if(ordDetail.length == 3){
                        String[] carDetail = ordDetail[1].split("/");
                        Cart car = new Cart();
                        for(String i:carDetail){
                            String[] iteDetail = i.split("-");
                            CartItem items = new CartItem(new Product(iteDetail[0]),Float.parseFloat(iteDetail[1]));
                            car.add(items);}
                        Order ord = new Order(ordDetail[0],car);
                        ord.setDateTime(ordDetail[2]);
                        ord.setorderID(key);
                        orders.put(key, ord);
                    }
                }
                if(!line.equals("")){record = record +"\n" + line;}
            }        
            ordIn.close();
        }
        catch(IOException i) {
                  i.printStackTrace();
                  return;
                }
            }
         
    /** put one order into orders hashmap,
     * the key of that hashmap is increasing from 0,
     * everytime it will get the max key value and increase 1
     * @param : Order order */        
    public void setOrder(Order order) {
        float orderId = 0;
        if(orders.keySet().size()!=0){
            float maxKey = Collections.max(orders.keySet());
            orderId = maxKey+1;}
        else { orderId= orderId+1;}
        orders.put(orderId,order);
    }
    
    /**write orders to file
       get order information from hashmaps: orders
       store information into order.txt file*/
    public void writeOrder(){
        /**write to order file*/
        try {
            FileWriter ordFstream = new FileWriter("order.txt");
            BufferedWriter ordOut = new BufferedWriter(ordFstream);
            
            Iterator<Map.Entry<Float, Order>> ordMap = orders.entrySet().iterator();
             while (ordMap.hasNext()) {
                Map.Entry<Float, Order> ord = ordMap.next();
                String items = "";
                for(int i = 0; i< ord.getValue().getCustOrder().getList().size(); i++){
                    if(items.equals("")){
                        items = ord.getValue().getCustOrder().getList().get(i).getProduct().getName()+"-"+
                                 ord.getValue().getCustOrder().getList().get(i).getQuantity();}
                    else{
                        items = items + "/"+ord.getValue().getCustOrder().getList().get(i).getProduct().getName()+"-"+
                                 ord.getValue().getCustOrder().getList().get(i).getQuantity();}
                }
                ordOut.write(ord.getKey()+":" + ord.getValue().getUserName()+","+items+","+ord.getValue().getDateTime()+"\n");
            }
            ordOut.close();
            }
        catch(IOException i) {
              i.printStackTrace();
              return;
            }
        }
        
    /**write orders to file
       get order information from hashmaps: orders
       store information into order.txt file*/
    public void writeToMovie()
    {
        try
        {
            PrintWriter outputMovieFile = new PrintWriter ("files/Movies.txt");
            PrintWriter outputMusicFile = new PrintWriter ("files/Music.txt");
            PrintWriter outputGameFile = new PrintWriter ("files/Game.txt");
            PrintWriter outputTvSeriesFile = new PrintWriter ("files/TvSeries.txt");
            for(Product birb: productList)
            {              
                if(birb.getPropertyCategory(birb.getName()).equals("CATEGORY : MOVIE")){
                Movie mov = ((Movie)birb.getPropertyValue(birb.getName()));
                outputMovieFile.write (mov.getTitle() +":"+ mov.getYear() +","+ mov.getGenre() +"," + mov.getDirector()+","+ mov.getQuantity() +","+ mov.getNumberOfFilms() +","+ mov.getPrice() +"\r\n");
            }
            
            if(birb.getPropertyCategory(birb.getName()).equals("CATEGORY : MUSIC")){
                Music mus = ((Music)birb.getPropertyValue(birb.getName()));
                outputMusicFile.write (mus.getTitle() +":"+ mus.getSinger()+ ","+ mus.getGenre() +"," + mus.getYear() +","+ + mus.getQuantity() +","+ mus.getPrice() +"\r\n");
            }
            
             if(birb.getPropertyCategory(birb.getName()).equals("CATEGORY : GAMES")){
                Game game = ((Game)birb.getPropertyValue(birb.getName()));
                outputGameFile.write (game.getTitle() +":"+ game.getYear()+ ","+ game.getPlatform() +"," + game.getPublisher() +","+ game.getQuantity() +","+ game.getPrice() +"\r\n");
            }
            
             if(birb.getPropertyCategory(birb.getName()).equals("CATEGORY : TV SERIES")){
                TvSeries tv = ((TvSeries)birb.getPropertyValue(birb.getName()));
                outputTvSeriesFile.write (tv.getTitle() +":"+ tv.getYear()+ ","+ tv.getGenre() +"," + tv.getDirector()  +","+ tv.getStars() +","+ tv.getQuantity() +","+ tv.getSeasons() +","+ tv.getPrice() +"\r\n");
            }
            
            }
            outputMovieFile.close();
            outputMusicFile.close();
            outputGameFile.close();
            outputTvSeriesFile.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**get particular user personal information from details by user name
       @param  String username
       @return type: Customer*/
    public Customer getUserInfo(String username) {
        return details.get(username);
    }

    /**set a user personal information to details 
       @param String username,Customer info
       @return type: true*/
    public boolean setUserInfo(String username, Customer info) {
        details.put(username, info);
        return true;
    }
     
    /**add a movie information to productList 
       @param  String title,Movie mov
       @return type: true*/   
    public boolean setMovieInfo(String title,Movie mov) {       
         Product birb = new Product(title);
         birb.setProperty(title,"CATEGORY : MOVIE", mov);
         productList.add(birb);
         return true;
    }
    
    /**add a music information to productList 
       @param  String title,Movie mov
       @return type: true*/
    public boolean setMusicInfo(String title,Music mus) {       
         Product birb = new Product(title);
         birb.setProperty(title,"CATEGORY : MUSIC", mus);
         productList.add(birb);   
         return true;
    }
    
    /**add a game information to productList 
       @param  String title,Movie mov
       @return type: true*/
    public boolean setGameInfo(String title, Game game){       
         Product birb = new Product(title);
         birb.setProperty(title,"CATEGORY : GAMES", game);
         productList.add(birb);   
         return true;
    }
    
    /**add a TV SERIES information to productList 
       @param  String title,Movie mov
       @return type: true*/
    public boolean setTvSeriesInfo(String title, TvSeries tv){       
         Product birb = new Product(title);
         birb.setProperty(title,"CATEGORY : TV SERIES", tv);
         productList.add(birb);   
         return true;
    }
    
    /**calcualte totle price of items in a cart 
       @param  Cart cart
       @return float total*/
    public float getPrice(Cart cart) {
        float total = 0;
         for(CartItem cItem : cart.getList()) 
            if(cItem.product.hasProperty(cItem.product.getName())){
                Object o = cItem.product.getPropertyValue(cItem.product.getName());
                String category = cItem.product.getPropertyCategory(cItem.product.getName());
                if(category.equals("CATEGORY : MOVIE"))total += ((float) ((Movie)o).getPrice()) * cItem.quantity;
                if(category.equals("CATEGORY : MUSIC"))total += ((float) ((Music)o).getPrice()) * cItem.quantity;
                if(category.equals("CATEGORY : TV SERIES"))total += ((float) ((TvSeries)o).getPrice()) * cItem.quantity;
                if(category.equals("CATEGORY : GAMES"))total += ((float) ((Game)o).getPrice()) * cItem.quantity;
            }
        return total;
    }

    public boolean processOrder(String currentUserID, Cart cart) {
        return true;
    }


}
