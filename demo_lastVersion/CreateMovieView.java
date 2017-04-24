import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JOptionPane;

public class CreateMovieView extends View {
    private static final long serialVersionUID = 1L;
    private JPanel scrollPanel;   
    private JTextField title;
    private JTextField year;
    private JTextField genre;
    private JTextField director;
    private JTextField numberOfFilms;
    private JTextField quantity;
    private JTextField price;
    
    public Movie toMovie(){
        Movie mov =new Movie();
        try{
        mov= new Movie(title.getText(), Integer.parseInt(year.getText()), genre.getText(), director.getText(), Integer.parseInt(numberOfFilms.getText()), Integer.parseInt(quantity.getText() ), Float.parseFloat(price.getText()));
       }
        catch(NumberFormatException ex){
            return null;
        }
        return mov;
    }
    
    public CreateMovieView() {
        setLayout(new BorderLayout(0, 0));
        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        
        add(panel,BorderLayout.NORTH);
        
        JLabel productCategory = new JLabel("CREATE NEW ITEM:MOVIE");
        productCategory.setFont(new Font("Lucida Grande", Font.BOLD, 24));
        panel.add(productCategory);        
        JLabel spacer_1 = new JLabel("                   ");
        panel.add(spacer_1);
        JLabel spacer_2 = new JLabel("                        ");
        panel.add(spacer_2); 
        JLabel spacer_3 = new JLabel("                       ");
        panel.add(spacer_3); 
            
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setView(new AdminHomePage());
            }
        });      
        panel.add(homeButton);
        
        JButton logOutButton = new JButton("LogOut");        
        logOutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getController().setUserCart();
                getController().init();
          }
        });        
        panel.add(logOutButton);
        
        scrollPanel = new JPanel();
        JScrollPane scroll = new JScrollPane(scrollPanel);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        add(scroll, BorderLayout.CENTER);
        
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0,0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0,0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0,0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        scrollPanel.setLayout(gbl_contentPanel);
        {
            JLabel spacer = new JLabel("                  ");
            spacer.setHorizontalAlignment(SwingConstants.LEFT);
            GridBagConstraints gbc_spacer = new GridBagConstraints();
            gbc_spacer.insets = new Insets(0, 0, 5, 5);
            gbc_spacer.gridx = 1;
            gbc_spacer.gridy = 1;
            scrollPanel.add(spacer, gbc_spacer);
        }
        {
            JLabel spacer1 = new JLabel("                    ");        
            spacer1.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_spacer1 = new GridBagConstraints();
            gbc_spacer1.insets = new Insets(0, 0, 5, 5);
            gbc_spacer1.gridx = 2;
            gbc_spacer1.gridy = 1;
            scrollPanel.add(spacer1, gbc_spacer1);
        }
        
        {
            JLabel lblTitle = new JLabel("Movie title:");
            lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblTitle = new GridBagConstraints();
            gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
            gbc_lblTitle.gridx = 3;
            gbc_lblTitle.gridy = 2;
            scrollPanel.add(lblTitle, gbc_lblTitle);
        }
        {
            title = new JTextField();
            GridBagConstraints gbc_title = new GridBagConstraints();
            gbc_title.insets = new Insets(0, 0, 5, 5);
            gbc_title.fill = GridBagConstraints.HORIZONTAL;
            gbc_title.gridx = 4;
            gbc_title.gridy = 2;
            scrollPanel.add(title, gbc_title);
            title.setColumns(20);
            title.setText("");
        }
        {
            JLabel lblYear = new JLabel("Release Year:");
            GridBagConstraints gbc_lblYear = new GridBagConstraints();
            gbc_lblYear.anchor = GridBagConstraints.EAST;
            gbc_lblYear.insets = new Insets(0, 0, 5, 5);
            gbc_lblYear.gridx = 3;
            gbc_lblYear.gridy = 3;
            scrollPanel.add(lblYear, gbc_lblYear);
        }
        {
            year = new JTextField();
            GridBagConstraints gbc_year = new GridBagConstraints();
            gbc_year.insets = new Insets(0, 0, 5, 5);
            gbc_year.fill = GridBagConstraints.HORIZONTAL;
            gbc_year.gridx = 4;
            gbc_year.gridy = 3;
            scrollPanel.add(year, gbc_year);
            year.setColumns(20);
            year.setText("");
        }
        {
            JLabel lblGenre = new JLabel("Genre:");
            lblGenre.setHorizontalAlignment(SwingConstants.CENTER);
            GridBagConstraints gbc_lblGenre = new GridBagConstraints();
            gbc_lblGenre.anchor = GridBagConstraints.EAST;
            gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
            gbc_lblGenre.gridx = 3;
            gbc_lblGenre.gridy = 4;
            scrollPanel.add(lblGenre, gbc_lblGenre);
        }
        {
            genre = new JTextField();
            GridBagConstraints gbc_genre = new GridBagConstraints();
            gbc_genre.insets = new Insets(0, 0, 5, 5);
            gbc_genre.fill = GridBagConstraints.HORIZONTAL;
            gbc_genre.gridx = 4;
            gbc_genre.gridy = 4;
            scrollPanel.add(genre, gbc_genre);
            genre.setColumns(20);
            genre.setText("");
        }
        {
            JLabel lblDirector = new JLabel("Directed By:");
            GridBagConstraints gbc_lblDirector = new GridBagConstraints();
            gbc_lblDirector.anchor = GridBagConstraints.EAST;
            gbc_lblDirector.insets = new Insets(0, 0, 5, 5);
            gbc_lblDirector.gridx = 3;
            gbc_lblDirector.gridy = 5;
            scrollPanel.add(lblDirector, gbc_lblDirector);
        }
        {
            director = new JTextField();
            GridBagConstraints gbc_director = new GridBagConstraints();
            gbc_director.insets = new Insets(0, 0, 5, 5);
            gbc_director.fill = GridBagConstraints.HORIZONTAL;
            gbc_director.gridx = 4;
            gbc_director.gridy = 5;
            scrollPanel.add(director, gbc_director);
            director.setColumns(20);
            director.setText("");
        }
        
        {
            JLabel lblNumberOfFilms = new JLabel("No. Of Films:");
            GridBagConstraints gbc_lblNumberOfFilms = new GridBagConstraints();
            gbc_lblNumberOfFilms.anchor = GridBagConstraints.EAST;
            gbc_lblNumberOfFilms.insets = new Insets(0, 0, 5, 5);
            gbc_lblNumberOfFilms.gridx = 3;
            gbc_lblNumberOfFilms.gridy = 6;
            scrollPanel.add(lblNumberOfFilms, gbc_lblNumberOfFilms);
        }
        {
            numberOfFilms = new JTextField();
            GridBagConstraints gbc_numberOfFilms = new GridBagConstraints();
            gbc_numberOfFilms.insets = new Insets(0, 0, 5, 5);
            gbc_numberOfFilms.fill = GridBagConstraints.HORIZONTAL;
            gbc_numberOfFilms.gridx = 4;
            gbc_numberOfFilms.gridy = 6;
            scrollPanel.add(numberOfFilms, gbc_numberOfFilms);
            numberOfFilms.setColumns(20);
            numberOfFilms.setText("");
        }

        {
            JLabel lblQuantity = new JLabel("Quantity in Stock:");
            GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
            gbc_lblQuantity.anchor = GridBagConstraints.EAST;
            gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
            gbc_lblQuantity.gridx = 3;
            gbc_lblQuantity.gridy = 7;
            scrollPanel.add(lblQuantity, gbc_lblQuantity);
        }
        {
            quantity = new JTextField();
            GridBagConstraints gbc_quantity = new GridBagConstraints();
            gbc_quantity.insets = new Insets(0, 0, 5, 5);
            gbc_quantity.fill = GridBagConstraints.HORIZONTAL;
            gbc_quantity.gridx = 4;
            gbc_quantity.gridy = 7;
            scrollPanel.add(quantity, gbc_quantity);
            quantity.setColumns(20);
            quantity.setText("");
        }
        {
            JLabel lblPrice = new JLabel("Price/Unit:");
            GridBagConstraints gbc_lblPrice = new GridBagConstraints();
            gbc_lblPrice.anchor = GridBagConstraints.EAST;
            gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
            gbc_lblPrice.gridx = 3;
            gbc_lblPrice.gridy = 8;
            scrollPanel.add(lblPrice, gbc_lblPrice);
        }
        {
            price = new JTextField();
            GridBagConstraints gbc_price = new GridBagConstraints();
            gbc_price.insets = new Insets(0, 0, 5, 5);
            gbc_price.fill = GridBagConstraints.HORIZONTAL;
            gbc_price.gridx = 4;
            gbc_price.gridy = 8;
            scrollPanel.add(price, gbc_price);
            price.setColumns(20);
            price.setText("");
        }
        {
            JButton okButton = new JButton("Save");
            GridBagConstraints gbc_save = new GridBagConstraints();
            gbc_save.insets = new Insets(0, 0, 5, 5);
            gbc_save.fill = GridBagConstraints.HORIZONTAL;
            gbc_save.gridx = 5;
            gbc_save.gridy = 9;
                okButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        if(toMovie()!=null && !(title.getText().trim().equals("")) && !(genre.getText().trim().equals("")) && !(director.getText().trim().equals(""))){
                        getController().createMovieItem(title.getText(),toMovie());
                        getController().setView(new CreateMovieView()); 
                    }
                    else{
                        showPopup("Kindly enter all the details in correct format!");
                    }
                }
                });
                scrollPanel.add(okButton,gbc_save);
         }
         {
            JButton cancelButton = new JButton("Cancel");
            GridBagConstraints gbc_cancel = new GridBagConstraints();
            gbc_cancel.insets = new Insets(0, 0, 5, 5);
            gbc_cancel.fill = GridBagConstraints.HORIZONTAL;
            gbc_cancel.gridx = 6;
            gbc_cancel.gridy = 9;
                cancelButton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                         getController().setView(new CreateMovieView());
                    }
                });
                scrollPanel.add(cancelButton,gbc_cancel);
                
          }
    }

    public void initialize() {
        
    }

}
