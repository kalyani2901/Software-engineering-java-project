import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ReportThumbnail extends JPanel {

	private static final long serialVersionUID = 1L;

	public ReportThumbnail(ShopController c, Order orde) {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("Order ID:"+orde.getorderID()+" Customer:"+c.getSearchedCustomerDetails(orde.getUserName()).getName());
		panel.add(title);
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JLabel imgLabel = new JLabel();
		imgLabel.setIcon(orde.getImage());
		panel_2.add(imgLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton view = new JButton("View");
		panel_1.add(view);
		
		view.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ReportDetails.display(c, orde);
			}
		});
	}
}
