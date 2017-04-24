import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Component;


public class ReportCustomer extends View {
    
    private static final long serialVersionUID = 1L;
    
    private JPanel scrollPanel;
    private Component verticalStrut;
    private JTextField searchItem;
    private JTextField orderDate;
    
    public ReportCustomer() {
        setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        add(panel,BorderLayout.NORTH);
        
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        JPanel titlePanel = new JPanel();
        
        FlowLayout flowLayout = (FlowLayout) titlePanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        JLabel heading = new JLabel("REPORT CUSTOMERS");
        heading.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        titlePanel.add(heading);        
        JLabel spacer_1 = new JLabel("                       ");
        titlePanel.add(spacer_1);
        JLabel spacer_2 = new JLabel("                            ");
        titlePanel.add(spacer_2); 
        JLabel spacer_3 = new JLabel("                           ");
        titlePanel.add(spacer_3); 
            
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setView(new AdminHomePage());
            }
        });      
        titlePanel.add(homeButton);
        
        JButton logOutButton = new JButton("LogOut");        
        logOutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setUserCart();
                getController().init();
          }
        });        
        titlePanel.add(logOutButton);
        panel.add(titlePanel);
        verticalStrut = Box.createVerticalStrut(30);
        panel.add(verticalStrut);
       
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1, 8,0,0));
        JLabel lblSpace = new JLabel("   ");
        searchPanel.add(lblSpace);
        JLabel lblItem = new JLabel("Item Name:");
        lblItem.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        searchPanel.add(lblItem);
        searchItem = new JTextField();
        searchItem.setText("");
        searchPanel.add(searchItem);
        
         JLabel lblSpace1 = new JLabel("   ");
        searchPanel.add(lblSpace1);
        
        JLabel lblDate = new JLabel("Order Date:");
        lblDate.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        searchPanel.add(lblDate);
        orderDate =  new JTextField();
        orderDate.setText("");
        searchPanel.add(orderDate);
        
        JLabel lblSpace2 = new JLabel("   ");
        searchPanel.add(lblSpace2);
   
        JButton searchCustomer = new JButton("Search");
        searchCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               if(!searchItem.getText().equals("")){
                scrollPanel.removeAll();      
                revalidate();
                List<Order> list;
                if(orderDate.getText().equals("")){
                    list = getController().getBackend().getSearchResult(searchItem.getText());}
                else{
                    list = getController().getBackend().getSearchResult(searchItem.getText(),orderDate.getText());}
                for(Order o : list){
                 String userName = o.getUserName();
                 scrollPanel.add(new ReportThumbnail(getController(), o));
                }
            }
           else {
                showPopup("Item name is neeed for search");
                scrollPanel.removeAll();      
                revalidate();
            }
        }
        });        
        searchPanel.add(searchCustomer);
        panel.add(searchPanel);
        
        scrollPanel = new JPanel();
        JScrollPane scroll = new JScrollPane(scrollPanel);
        scrollPanel.setLayout(new GridLayout(0, 2, 0, 0));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(scroll, BorderLayout.CENTER);

    }
    
    public void initialize() {     

    }
}