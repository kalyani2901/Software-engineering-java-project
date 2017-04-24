import javax.swing.ImageIcon;
/**
 * <pre>
 * This class represents a customer, it holds all of the data that the store needs to know about someone.
 * </pre>
 */
public class Customer{

	/**
	 * <pre>
	 * The customer's full name.
	 * </pre>
	 */
	public String name;
	
	/**
	 * <pre>
	 * The customer's home address.
	 * </pre>
	 */
	public String address;
	
	/**
	 * <pre>
	 * The customer's card number.
	 * </pre>
	 */
	public String cardNumber;
	
	/**
	 * <pre>
	 * The customer's phone number.
	 * </pre>
	 */
	public String phoneNumber;
	
	private ImageIcon image = null;
	
	public Customer(String name, String address, String cardNumber, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.cardNumber = cardNumber;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    public String toString ()
    {
        return String.format("Name: "+ name  + "<br/>" + "Address: "+ address + "<br/>" + "Phone Number: " + phoneNumber);
    }
}
