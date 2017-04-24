import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

/**
 * Write a description of class AdminHomePage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdminHomePage extends View 
{   
    private static final long serialVersionUID = 1L;    
    private JPanel scrollPanel;
    
    public AdminHomePage() {
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        add(panel, BorderLayout.NORTH);
        
        JLabel newItem = new JLabel("CREATE ITEM:");
        newItem.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        panel.add(newItem);
        
          JButton movieButton = new JButton("Movie");
        movieButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
               getController().setView(new CreateMovieView());
            }
        }); 
        panel.add(movieButton);
        
        
          JButton musicButton = new JButton("Music");
        musicButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setView(new CreateMusicView());
            }
        });        
        panel.add(musicButton);
        
         JButton gameButton = new JButton("Game");
        gameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setView(new CreateGameView());
            }
        });        
        panel.add(gameButton);
        
         JButton tvButton = new JButton("TV Series");
        tvButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setView(new CreateSeriesView());
            }
        });        
        panel.add(tvButton);
        
        
        JLabel spacer = new JLabel("                 ");
        panel.add(spacer);        
        
        JButton report = new JButton("Report");
        report.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        report.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setView(new ReportCustomer());
            }
        });
        
        panel.add(report);
        
        JButton logOutButton = new JButton("LogOut");
        
        logOutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setUserCart();
                getController().logout();
                getController().init();
          }
        });
        
        panel.add(logOutButton);
        
        scrollPanel = new JPanel();
        JScrollPane scroll = new JScrollPane(scrollPanel);
        scrollPanel.setLayout(new GridLayout(0, 3, 0, 0));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(scroll, BorderLayout.CENTER);

    }
    
    public void initialize() {     
        scrollPanel.removeAll();      
        List<Product> list = getController().getBackend().getProducts();
        for(Product p : list){
            scrollPanel.add(new ProductThumbnail(getController(), p));
        }
        revalidate(); 
    }
}
