import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ConfirmDialog extends JDialog {

    private static final long serialVersionUID = 1L;
	private JTextField fullName;
	private JTextField phoneNumber;
	private JTextField homeAddr;
	private JTextField cardNum;
	private final JPanel contentPanel = new JPanel();

	public Customer toCustomer(){
		return new Customer(fullName.getText(), homeAddr.getText(), cardNum.getText(), phoneNumber.getText());
	}
	
    public static void display(ShopController c){
        ConfirmDialog dialog = new ConfirmDialog(c);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLocationRelativeTo(c.getWindow());
        dialog.setVisible(true);
    }
    
    public ConfirmDialog(ShopController c) {
        JDialog me = this;
        setBounds(200, 200, 650, 500);
        getContentPane().setLayout(new BorderLayout());
        {
            JPanel panel = new JPanel();
            panel.setBorder(new EmptyBorder(10, 10, 10, 10));
            getContentPane().add(panel, BorderLayout.NORTH);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            {
                JLabel lblNewLabel = new JLabel("ORDER DETAILS:");
                panel.add(lblNewLabel);
            }
            {
                JLabel spacer = new JLabel("  ");
                panel.add(spacer);
            }
            {
                String text = "<html>";
                
                for(CartItem item : c.getCart().getList()){
                    Cart thisItemInACart = new Cart();
                    thisItemInACart.add(item);
                    text += "ITEM: "+item.product.getName() +
                            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;QTY: " + item.quantity +
                            "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PRICE: " + c.getBackend().getPrice(thisItemInACart) + "<br>";
                }
                text += "</html>";
                JLabel details = new JLabel(text);
                panel.add(details);
            }
        }
        {
            Customer user = c.getCurrentCustomerDetails();
	
    		setTitle("Confirm User Information");
    		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    		getContentPane().add(contentPanel, BorderLayout.CENTER);
    		GridBagLayout gbl_contentPanel = new GridBagLayout();
    		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
    		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
    		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
    		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    		contentPanel.setLayout(gbl_contentPanel);
    		{
    			JLabel lblFullName = new JLabel("Full name:");
    			lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
    			GridBagConstraints gbc_lblFullName = new GridBagConstraints();
    			gbc_lblFullName.insets = new Insets(0, 0, 5, 5);
    			gbc_lblFullName.gridx = 1;
    			gbc_lblFullName.gridy = 1;
    			contentPanel.add(lblFullName, gbc_lblFullName);
    		}
                        		{
    			fullName = new JTextField();
    			GridBagConstraints gbc_fullName = new GridBagConstraints();
    			gbc_fullName.insets = new Insets(0, 0, 5, 5);
    			gbc_fullName.fill = GridBagConstraints.HORIZONTAL;
    			gbc_fullName.gridx = 2;
    			gbc_fullName.gridy = 1;
    			contentPanel.add(fullName, gbc_fullName);
    			fullName.setColumns(10);
    			fullName.setText(user.name);
    		}
    		{
    			JLabel lblPhoneNumber = new JLabel("Phone number:");
    			GridBagConstraints gbc_lblPhoneNumber = new GridBagConstraints();
    			gbc_lblPhoneNumber.anchor = GridBagConstraints.EAST;
    			gbc_lblPhoneNumber.insets = new Insets(0, 0, 5, 5);
    			gbc_lblPhoneNumber.gridx = 1;
    			gbc_lblPhoneNumber.gridy = 2;
    			contentPanel.add(lblPhoneNumber, gbc_lblPhoneNumber);
    		}
    		{
    			phoneNumber = new JTextField();
    			GridBagConstraints gbc_phoneNumber = new GridBagConstraints();
    			gbc_phoneNumber.insets = new Insets(0, 0, 5, 5);
    			gbc_phoneNumber.fill = GridBagConstraints.HORIZONTAL;
    			gbc_phoneNumber.gridx = 2;
    			gbc_phoneNumber.gridy = 2;
    			contentPanel.add(phoneNumber, gbc_phoneNumber);
    			phoneNumber.setColumns(10);
    			phoneNumber.setText(user.phoneNumber);
    		}
    		{
    			JLabel lblHomeAddress = new JLabel("Home address:");
    			lblHomeAddress.setHorizontalAlignment(SwingConstants.LEFT);
    			GridBagConstraints gbc_lblHomeAddress = new GridBagConstraints();
    			gbc_lblHomeAddress.anchor = GridBagConstraints.EAST;
    			gbc_lblHomeAddress.insets = new Insets(0, 0, 5, 5);
    			gbc_lblHomeAddress.gridx = 1;
    			gbc_lblHomeAddress.gridy = 3;
    			contentPanel.add(lblHomeAddress, gbc_lblHomeAddress);
    		}
    		{
    			homeAddr = new JTextField();
    			GridBagConstraints gbc_homeAddr = new GridBagConstraints();
    			gbc_homeAddr.insets = new Insets(0, 0, 5, 5);
    			gbc_homeAddr.fill = GridBagConstraints.HORIZONTAL;
    			gbc_homeAddr.gridx = 2;
    			gbc_homeAddr.gridy = 3;
    			contentPanel.add(homeAddr, gbc_homeAddr);
    			homeAddr.setColumns(10);
    			homeAddr.setText(user.address);
    		}
    		{
    			JLabel lblCardNumber = new JLabel("Card number:");
    			GridBagConstraints gbc_lblCardNumber = new GridBagConstraints();
    			gbc_lblCardNumber.anchor = GridBagConstraints.EAST;
    			gbc_lblCardNumber.insets = new Insets(0, 0, 0, 5);
    			gbc_lblCardNumber.gridx = 1;
    			gbc_lblCardNumber.gridy = 4;
    			contentPanel.add(lblCardNumber, gbc_lblCardNumber);
    		}
    		{
    			cardNum = new JTextField();
    			GridBagConstraints gbc_cardNum = new GridBagConstraints();
    			gbc_cardNum.insets = new Insets(0, 0, 0, 5);
    			gbc_cardNum.fill = GridBagConstraints.HORIZONTAL;
    			gbc_cardNum.gridx = 2;
    			gbc_cardNum.gridy = 4;
    			contentPanel.add(cardNum, gbc_cardNum);
    			cardNum.setColumns(10);
    			cardNum.setText(user.cardNumber);
    		}
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton confirmButton = new JButton("Confirm order");
                confirmButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        c.updateUserDetails(toCustomer());
                        c.attemptTransaction();
                        me.dispose();
                    }
                });
                confirmButton.setActionCommand("OK");
                buttonPane.add(confirmButton);
                getRootPane().setDefaultButton(confirmButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        me.dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}