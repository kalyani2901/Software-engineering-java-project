import javax.swing.ImageIcon;
/**
 * <pre>
 * This class represents a order placed by the customer when they make any purchase.
 * It stores the cart details at the time of checkout, along with associated customer details as well as the date when the ordr is made.
 * </pre>
 */
public class Order
{
    /**
	 * <pre>
	 * The customer's cart at the time of checkOut.
	 * </pre>
	 */
    private Cart custOrder = new Cart();
    
    /**
	 * <pre>
	 * The customer's user name making an order.
	 * </pre>
	 */
    private String userName;
    
    /**
	 * <pre>
	 * The order's date.
	 * </pre>
	 */
    private String dateTime;
    
    /**
	 * <pre>
	 * The unique order ID.
	 * </pre>
	 */
    private float orderID;
    private ImageIcon image = null;
    
    public float getorderID() {
        return this.orderID;
    }

    public void setorderID(float orderID) {
        this.orderID = orderID;
    }
    
    public Cart getCustOrder() {
        return custOrder;
    }

    public void setCustOrder(Cart custOrder) {
        this.custOrder = custOrder;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    /**
     * Constructor for objects of class Order
     */public Order()
    {
        this.userName = "";
    }
    
    public Order(String userName, Cart custOrder)
    {
        this.userName = userName;
        this.custOrder = custOrder;
    }
    
      public ImageIcon getImage(){
		if(this.image == null) return ShopController.CUSTOMER_IMAGE_ICON;
		else return this.image;
	}
	
	/**
	 * <pre>
	 * This method is used internally to generate the text seen in the "ReportDetails" dialog.
	 * </pre>
	 * @return A formatted string representation of all properties this order has.
	 */
    public String reportText (){   
       String out = "";
       String orderDetail = "";
        for(CartItem ci : custOrder.getList()){
            if(orderDetail.equals("")){
                orderDetail = ci.getProduct().getName()+"-"+ci.getQuantity();}
            else{
                orderDetail = orderDetail + "/"+ci.getProduct().getName()+"-"+ci.getQuantity();}
            }
        out += ("Order Id: "+ orderID+"<br/>" +"Customer Id: "+ userName  + "<br/>" + 
        "Order Details: "+ orderDetail + "<br/>" + "Date of Order: " + dateTime)+ "<br/>";
        out += "</html>";
		return out;
       }
       
}