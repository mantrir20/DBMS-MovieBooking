import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SlotSelect extends JFrame {
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlotSelect frame = new SlotSelect(1,1,1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel OuterContainer;

	/**
	 * Launch the application.
	 */
	Connection connect= null;
	 ResultSet rs1,rs,rs2,rs3;
	 String rname,rseat;
	 String m1,m2,m3,m4,m5;
	 public static int m,s,u;

	/**
	 * Create the frame.
	 */
	public SlotSelect(int userID,int movieId,int Station_id) {
		m=movieId;
		s=Station_id;
		u=userID;
		connect=databaseConnect.dbconnect();
		String query1 = "select * from cinemastation where `Station ID`="+Station_id+";";
		PreparedStatement ps1=null;
		try {
            ps1 = connect.prepareStatement(query1);
            rs3=ps1.executeQuery();
            int i=0;
            while(rs3.next()) {
                rname = rs3.getString("Availability");
                rseat = rs3.getString("Total Seats");
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        } 
		int t1=Character.getNumericValue(rname.charAt(0));  
		int t2=Character.getNumericValue(rname.charAt(1));  
		int t3=Character.getNumericValue(rname.charAt(2));  
		int t4=Character.getNumericValue(rname.charAt(3));
		
		
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
		
		JLabel MovieHeading = new JLabel("Slot Timings");
		MovieHeading.setBackground(new Color(102, 255, 255));
		MovieHeading.setForeground(new Color(0, 0, 0));
		MovieHeading.setFont(new Font("Calibri", Font.BOLD, 50));
		MovieHeading.setHorizontalAlignment(SwingConstants.CENTER);
		MovieHeading.setBounds(0,0,1280,74);
		StationOptions.add(MovieHeading);
		
		JPanel Slot1 = new JPanel();
		Slot1.addMouseListener(new PanelButtonMouseAdapter(Slot1,movieId,1,rseat));
		Slot1.setBackground(new Color(255, 204, 51));
		Slot1.setBounds(90, 110, 1100, 80);
		StationOptions.add(Slot1);
		Slot1.setLayout(null);
		
		
		if(t1==1)
		{
			m1="Slot1 - 9am to 12pm -->  Available";
		}
		else
		{
			m1="Slot1 - 9am to 12pm -->  Not Available";
		}
		JLabel Time1 = new JLabel(m1);
		Time1.setFont(new Font("Calibri", Font.BOLD, 30));
		Time1.setHorizontalAlignment(SwingConstants.CENTER);
		Time1.setBounds(250, 20, 600, 40);
		Slot1.add(Time1);
		
		JPanel Slot2 = new JPanel();
		Slot2.addMouseListener(new PanelButtonMouseAdapter(Slot2,movieId,2,rseat));
		Slot2.setBackground(new Color(255, 204, 51));
		Slot2.setBounds(90, 200, 1100, 80);
		StationOptions.add(Slot2);
		Slot2.setLayout(null);
		
		
		if(t2==1)
		{
			m2="Slot2 - 12pm to 3pm -->  Available";
		}
		else
		{
			m2="Slot2 - 12pm to 3pm -->  Not Available";
		}
		JLabel Time2 = new JLabel(m2);
		Time2.setFont(new Font("Calibri", Font.BOLD, 30));
		Time2.setHorizontalAlignment(SwingConstants.CENTER);
		Time2.setBounds(250, 20, 600, 40);
		Slot2.add(Time2);
		
		JPanel Slot3 = new JPanel();
		Slot3.addMouseListener(new PanelButtonMouseAdapter(Slot3,movieId,3,rseat));
		Slot3.setLayout(null);
		Slot3.setBackground(new Color(255, 204, 51));
		Slot3.setBounds(90, 290, 1100, 80);
		StationOptions.add(Slot3);
		
		
		if(t3==1)
		{
			m3="Slot3 - 3pm to 6pm -->  Available";
		}
		else
		{
			m3="Slot3 - 3pm to 6pm -->  Not Available";
		}
		JLabel Time3 = new JLabel(m3);
		Time3.setHorizontalAlignment(SwingConstants.CENTER);
		Time3.setFont(new Font("Calibri", Font.BOLD, 30));
		Time3.setBounds(250, 20, 600, 40);
		Slot3.add(Time3);
		
		JPanel Slot4 = new JPanel();
		Slot4.addMouseListener(new PanelButtonMouseAdapter(Slot4,movieId,4,rseat));
		Slot4.setLayout(null);
		Slot4.setBackground(new Color(255, 204, 51));
		Slot4.setBounds(90, 380, 1100, 80);
		StationOptions.add(Slot4);
		
		
		if(t4==1)
		{
			m4="Slot4 - 6pm to 9pm -->  Available";
		}
		else
		{
			m4="Slot4 - 6pm to 9pm -->  Not Available";
		}
		JLabel Time4 = new JLabel(m4);
		Time4.setHorizontalAlignment(SwingConstants.CENTER);
		Time4.setFont(new Font("Calibri", Font.BOLD, 30));
		Time4.setBounds(250, 20, 600, 40);
		Slot4.add(Time4);
		
		JPanel CinemaBack = new JPanel();
		CinemaBack.addMouseListener(new PanelButtonMouseAdapter(CinemaBack,33,33,"0"));
		CinemaBack.setBackground(new Color(255, 204, 0));
		CinemaBack.setToolTipText("");
		CinemaBack.setBounds(90, 630, 250, 50);
		StationOptions.add(CinemaBack);
		CinemaBack.setLayout(null);
		
		JLabel CinemaBackL = new JLabel("Back To Station Select");
		CinemaBackL.setHorizontalAlignment(SwingConstants.CENTER);
		CinemaBackL.setFont(new Font("Calibri", Font.BOLD, 20));
		CinemaBackL.setBounds(25, 5, 200, 40);
		CinemaBack.add(CinemaBackL);
	}
	
	public class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel Panel;
		int id;
		int time;
		String seatTotal;
		int seat;
		public PanelButtonMouseAdapter(JPanel panel,int id,int time,String seatTotal)
		{
			this.Panel=panel;
			this.id=id;
			this.time=time;
			this.seatTotal=seatTotal;
			seat = Integer.parseInt(seatTotal);  
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
			if(id==33)
			{
				new SlotSelect(u,m,s).setVisible(false);
				new CinemaSelect(m,u).setVisible(true);
			}
			else
			{
				new SlotSelect(u,m,s).setVisible(false);
				new BookingWindow(u,m,s,seat).setVisible(true);
			}
		}
	}

}
