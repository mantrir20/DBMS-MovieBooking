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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CinemaSelect extends JFrame {

	private JPanel OuterContainer;

	/**
	 * Launch the application.
	 */
	public static int u;
	Connection connect= null;
	 ResultSet rs1,rs,rs2,rs3;
	 String rname,rid;
	 String m1,m2,m3,m4,m5;
	 public static int s1,s2,m;

	/**
	 * Create the frame.
	 */
	public CinemaSelect(int movieID,int userID) {
		m=movieID;
		u=userID;
		connect=databaseConnect.dbconnect();
		String query1 = "select * from CinemaStation where `Movie ID`="+movieID+";";
		PreparedStatement ps1=null;
		try {
            ps1 = connect.prepareStatement(query1);
            rs3=ps1.executeQuery();
            int i=0;
            while(rs3.next()) {
                rname = rs3.getString("Station Name");
                rid = rs3.getString("Station ID");
                if(i==0)
                {
                	m1=rname;
                	s1=Integer.parseInt(rid);  
                }
                else
                {
                	m2=rname;
                	s2=Integer.parseInt(rid);  
                }
                i++;
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        } 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1300,750);
		setUndecorated(false);
		OuterContainer = new JPanel();
		OuterContainer.setForeground(new Color(0, 0, 0));
		OuterContainer.setBackground(new Color(102, 255, 255));
		OuterContainer.setBorder(null);
		setContentPane(OuterContainer);
		OuterContainer.setLayout(null);
		
		JPanel StationOptions = new JPanel();
		StationOptions.setBackground(new Color(102, 255, 255));
		StationOptions.setForeground(new Color(0, 0, 0));
		StationOptions.setBounds(10, 10, 1276, 703);
		OuterContainer.add(StationOptions);
		StationOptions.setLayout(null);
		
		JLabel MovieHeading = new JLabel("Choose Your Cinema Station");
		MovieHeading.setBackground(new Color(102, 255, 255));
		MovieHeading.setForeground(new Color(0, 0, 0));
		MovieHeading.setFont(new Font("Calibri", Font.BOLD, 50));
		MovieHeading.setHorizontalAlignment(SwingConstants.CENTER);
		MovieHeading.setBounds(0,0,1280,74);
		StationOptions.add(MovieHeading);
		
		JPanel Station1 = new JPanel();
		Station1.addMouseListener(new PanelButtonMouseAdapter(Station1,s1));
		Station1.setBackground(new Color(255, 204, 51));
		Station1.setBounds(90, 110, 1100, 80);
		StationOptions.add(Station1);
		Station1.setLayout(null);
		
		JLabel StationName1 = new JLabel(m1);
		StationName1.setFont(new Font("Calibri", Font.BOLD, 30));
		StationName1.setHorizontalAlignment(SwingConstants.CENTER);
		StationName1.setBounds(300, 20, 500, 40);
		Station1.add(StationName1);
		
		JPanel Station2 = new JPanel();
		Station2.addMouseListener(new PanelButtonMouseAdapter(Station2,s2));
		Station2.setBackground(new Color(255, 204, 51));
		Station2.setBounds(90, 200, 1100, 80);
		StationOptions.add(Station2);
		Station2.setLayout(null);
		
		JLabel StationName2 = new JLabel(m2);
		StationName2.setFont(new Font("Calibri", Font.BOLD, 30));
		StationName2.setHorizontalAlignment(SwingConstants.CENTER);
		StationName2.setBounds(300, 20, 500, 40);
		Station2.add(StationName2);
		
		JPanel BookingBack = new JPanel();
		BookingBack.addMouseListener(new PanelButtonMouseAdapter(BookingBack,33));
		BookingBack.setBackground(new Color(255, 204, 0));
		BookingBack.setToolTipText("");
		BookingBack.setBounds(90, 630, 250, 50);
		StationOptions.add(BookingBack);
		BookingBack.setLayout(null);
		
		JLabel BookingBackL = new JLabel("Back To Booking");
		BookingBackL.setHorizontalAlignment(SwingConstants.CENTER);
		BookingBackL.setFont(new Font("Calibri", Font.BOLD, 20));
		BookingBackL.setBounds(25, 5, 200, 40);
		BookingBack.add(BookingBackL);
	}
	
	public class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel Panel;
		int s_id;
		public PanelButtonMouseAdapter(JPanel panel,int s_id)
		{
			this.Panel=panel;
			this.s_id=s_id;
		}
		
		@Override
		public void mouseEntered(MouseEvent e)
		{
			Panel.setBackground(new Color(255, 204, 153));
		}
		
		@Override
		public void mouseExited(MouseEvent e)
		{
			Panel.setBackground(new Color(255, 204, 51));
		}
		
		@Override
		public void mousePressed(MouseEvent e)
		{
			Panel.setBackground(new Color(255, 102, 51));
		}
		
		@Override
		public void mouseReleased(MouseEvent e)
		{
			Panel.setBackground(new Color(255, 204, 153));
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(s_id!=33)
			{
				new CinemaSelect(m,u).setVisible(false);
				new BookingWindow(u,m,s_id).setVisible(true);
			}
			else
			{
				new CinemaSelect(m,u).setVisible(false);
				new Booking(u).setVisible(true);
			}
		}
	}
}
