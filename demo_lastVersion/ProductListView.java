import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class ProductListView extends View {
    
    private static final long serialVersionUID = 1L;
    
    private JPanel scrollPanel;
    
    public ProductListView() {
        setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        add(panel, BorderLayout.NORTH);
        
          JButton movieButton = new JButton("Movie");
        movieButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //getController().setView(new MovieView());
                 scrollPanel.removeAll(); 
                 revalidate();
                 List<Product> list = getController().getBackend().getProducts();
                 for(Product p : list){
                     if(p.getPropertyCategory(p.getName()).equals("CATEGORY : MOVIE")){
                         scrollPanel.add(new ProductThumbnail(getController(), p));
                        }
            //propertiesPanel.add(new ProductThumbnail(getController(), p));
        }
            }
        }); 
        panel.add(movieButton);
        
          JButton musicButton = new JButton("Music");
        musicButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //getController().setView(new MusicView());
                 scrollPanel.removeAll();  
                 revalidate();
                 List<Product> list = getController().getBackend().getProducts();
                 for(Product p : list){
                     if(p.getPropertyCategory(p.getName()).equals("CATEGORY : MUSIC")){
                         scrollPanel.add(new ProductThumbnail(getController(), p));
                        }
                        //propertiesPanel.add(new ProductThumbnail(getController(), p));
                    }
            }
        });        
        panel.add(musicButton);
        
         JButton gameButton = new JButton("Game");
        gameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //getController().setView(new GameView());
                scrollPanel.removeAll();    
                revalidate();
                List<Product> list = getController().getBackend().getProducts();
                for(Product p : list){
                    if(p.getPropertyCategory(p.getName()).equals("CATEGORY : GAMES")){
                        scrollPanel.add(new ProductThumbnail(getController(), p));
                    }
                    //propertiesPanel.add(new ProductThumbnail(getController(), p));
                }
            }
        });        
        panel.add(gameButton);
        
         JButton tvButton = new JButton("TV Series");
        tvButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                 scrollPanel.removeAll();      
                 revalidate();
                 List<Product> list = getController().getBackend().getProducts();
                 for(Product p : list){
                     if(p.getPropertyCategory(p.getName()).equals("CATEGORY : TV SERIES")){
                         scrollPanel.add(new ProductThumbnail(getController(), p));
                        }
                        //propertiesPanel.add(new ProductThumbnail(getController(), p));
                    }
                //getController().setView(new TvSeriesView ());
            }
        });        
        panel.add(tvButton);
        
        JLabel spacer_1 = new JLabel("             ");
            panel.add(spacer_1);
            
            JLabel spacer_2 = new JLabel("           ");
            panel.add(spacer_2);
        
        JButton myInfoButton = new JButton("My account");
        panel.add(myInfoButton);
        
        myInfoButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                UserDetails.display(getController());
            }
        });
        
        JButton cartButton = new JButton("Cart");
        
        cartButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().showCartView();
            }
        });
        
        panel.add(cartButton);
        
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
        revalidate(); 
        List<Product> list = getController().getBackend().getProducts();
        for(Product p : list){
            scrollPanel.add(new ProductThumbnail(getController(), p));
        }
        revalidate(); 
    }
}
