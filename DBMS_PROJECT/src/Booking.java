import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Booking extends JFrame {

	private JPanel OuterContainer;

	/**
	 * Launch the application.
	 */
	Connection connect= null;
	 ResultSet rs1,rs,rs2,rs3;
	 String rname;
	 String m1,m2,m3,m4,m5;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Booking() {
		
		
		
		connect=databaseConnect.dbconnect();
		String query1 = "select * from moviedetail";
		PreparedStatement ps1=null;
		try {
            ps1 = connect.prepareStatement(query1);
            rs3=ps1.executeQuery();
            int i=0;
            while(rs3.next()) {
                rname = rs3.getString("Movie Name");
                if(i==0)
                {
                	m1=rname;
                }
                else if(i==1)
                {
                	m2=rname;
                }
                else if(i==2)
                {
                	m3=rname;
                }
                else if(i==3)
                {
                	m4=rname;
                }
                else
                {
                	m5=rname;
                }
                i++;
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());                    // DOubt??//
        } 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1300,750);
		setUndecorated(true);
		OuterContainer = new JPanel();
		OuterContainer.setForeground(new Color(0, 0, 0));
		OuterContainer.setBackground(new Color(255, 255, 255));
		OuterContainer.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(OuterContainer);
		OuterContainer.setLayout(null);
		
		JPanel MovieOptions = new JPanel();
		MovieOptions.setBackground(new Color(153, 255, 255));
		MovieOptions.setForeground(new Color(0, 0, 0));
		MovieOptions.setBounds(10, 10, 1280, 730);
		OuterContainer.add(MovieOptions);
		MovieOptions.setLayout(null);
		
		JLabel MovieHeading = new JLabel("Choose Your Movie");
		MovieHeading.setForeground(new Color(204, 102, 153));
		MovieHeading.setFont(new Font("Calibri", Font.BOLD, 50));
		MovieHeading.setHorizontalAlignment(SwingConstants.CENTER);
		MovieHeading.setBounds(0,0,1280,74);
		MovieOptions.add(MovieHeading);
		
		JPanel Movie1 = new JPanel();
		Movie1.setBackground(new Color(255, 204, 51));
		Movie1.setBounds(90, 110, 1100, 80);
		MovieOptions.add(Movie1);
		Movie1.setLayout(null);
		
		JLabel MovieName1 = new JLabel(m1);
		MovieName1.setHorizontalAlignment(SwingConstants.CENTER);
		MovieName1.setBounds(300, 20, 500, 40);
		Movie1.add(MovieName1);
		
		JPanel Movie2 = new JPanel();
		Movie2.setBackground(new Color(255, 204, 51));
		Movie2.setBounds(90, 200, 1100, 80);
		MovieOptions.add(Movie2);
		Movie2.setLayout(null);
		
		JLabel MovieName2 = new JLabel(m2);
		MovieName2.setHorizontalAlignment(SwingConstants.CENTER);
		MovieName2.setBounds(300, 20, 500, 40);
		Movie2.add(MovieName2);
		
		JPanel Movie3 = new JPanel();
		Movie3.setBackground(new Color(255, 204, 51));
		Movie3.setBounds(90, 290, 1100, 80);
		MovieOptions.add(Movie3);
		Movie3.setLayout(null);
		
		JLabel MovieName3 = new JLabel(m3);
		MovieName3.setHorizontalAlignment(SwingConstants.CENTER);
		MovieName3.setBounds(300, 20, 500, 40);
		Movie3.add(MovieName3);
		
		JPanel Movie4 = new JPanel();
		Movie4.setBackground(new Color(255, 204, 51));
		Movie4.setBounds(90, 380, 1100, 80);
		MovieOptions.add(Movie4);
		Movie4.setLayout(null);
		
		JLabel MovieName4 = new JLabel(m4);
		MovieName4.setHorizontalAlignment(SwingConstants.CENTER);
		MovieName4.setBounds(300, 20, 500, 40);
		Movie4.add(MovieName4);
		
		JPanel Movie5 = new JPanel();
		Movie5.setBackground(new Color(255, 204, 51));
		Movie5.setBounds(90, 470, 1100, 80);
		MovieOptions.add(Movie5);
		Movie5.setLayout(null);
		
		JLabel MovieName5 = new JLabel(m5);
		MovieName5.setHorizontalAlignment(SwingConstants.CENTER);
		MovieName5.setBounds(300, 20, 500, 40);
		Movie5.add(MovieName5);
	}
}
