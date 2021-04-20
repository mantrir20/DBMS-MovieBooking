import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class RatingPage extends JFrame {

	private JFrame frame;
	Connection connect =null;
	String MovieName;
	double CurrentRating;
	int RatedBy;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RatingPage window = new RatingPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public RatingPage(int movie_id,int user_id) {
		initialize(movie_id,user_id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int movie_id,int user_id) {
		
		connect=databaseConnect.dbconnect();
		String query="Select * from MovieDetail where `Movie Id`="+movie_id+";";
		PreparedStatement ps=null;
		try {
            ps = connect.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            int i=0;
            while(rs.next()) {
                MovieName = rs.getString("Movie Name");
                CurrentRating=rs.getDouble("Rating");
                RatedBy=rs.getInt("RatedBy");
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        } 
		
		System.out.println("Rating Before:"+CurrentRating+" Rated By:"+RatedBy);
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblPleaseRateYour = new JLabel("How did you like the movie");
		lblPleaseRateYour.setBounds(122, 22, 279, 35);
		frame.getContentPane().add(lblPleaseRateYour);
		
		JLabel lblMovieName = new JLabel(MovieName);
		lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
		lblMovieName.setBounds(122, 52, 192, 31);
		frame.getContentPane().add(lblMovieName);
		
		JSlider MovieSlider = new JSlider();
		MovieSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
			}
		});
		MovieSlider.setToolTipText("");
		MovieSlider.setValue(1);
		MovieSlider.setPaintTicks(true);
		MovieSlider.setMajorTickSpacing(1);
		MovieSlider.setPaintTrack(true);
		MovieSlider.setPaintLabels(true);
		MovieSlider.setMaximum(5);
		MovieSlider.setBounds(122, 112, 200, 48);
		frame.getContentPane().add(MovieSlider);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(167, 194, 117, 25);
		frame.getContentPane().add(btnSubmit);
		
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int movie_rating= MovieSlider.getValue();
				CurrentRating=((CurrentRating*RatedBy)+movie_rating)/(RatedBy+1);
				RatedBy++;
				
				String query2="update MovieDetail set Rating="+CurrentRating+" , RatedBy="+RatedBy+" where `Movie Id`="+movie_id+";";                     
				PreparedStatement ps1=null;
				try {
		            ps1 = connect.prepareStatement(query2);
		            ps1.executeUpdate(query2);
		            JOptionPane.showMessageDialog(null, "Thank you for Rating the movie");
		            setVisible(false);
		            System.out.println("Rating After:"+CurrentRating+" Rated By:"+RatedBy);
		            
				}
				catch(SQLException ex) {
					System.out.println("SQL Exception "+ex.getMessage());
				}
				
				
				
				
			}
		});
		
	}
}
