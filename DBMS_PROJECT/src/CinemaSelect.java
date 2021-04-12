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
	Connection connect= null;
	 ResultSet rs1,rs,rs2,rs3;
	 String rname;
	 String m1,m2,m3,m4,m5;

	/**
	 * Create the frame.
	 */
	public CinemaSelect(int movieID) {
		connect=databaseConnect.dbconnect();
		String query1 = "select * from cinemastation where `Movie ID`="+movieID+";";
		PreparedStatement ps1=null;
		try {
            ps1 = connect.prepareStatement(query1);
            rs3=ps1.executeQuery();
            int i=0;
            while(rs3.next()) {
                rname = rs3.getString("Station Name");
                if(i==0)
                {
                	m1=rname;
                }
                else if(i==1)
                {
                	m2=rname;
                }
                else
                {
                	m3=rname;
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
		Station1.addMouseListener(new PanelButtonMouseAdapter(Station1));
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
		Station2.addMouseListener(new PanelButtonMouseAdapter(Station2));
		Station2.setBackground(new Color(255, 204, 51));
		Station2.setBounds(90, 200, 1100, 80);
		StationOptions.add(Station2);
		Station2.setLayout(null);
		
		JLabel StationName2 = new JLabel(m2);
		StationName2.setFont(new Font("Calibri", Font.BOLD, 30));
		StationName2.setHorizontalAlignment(SwingConstants.CENTER);
		StationName2.setBounds(300, 20, 500, 40);
		Station2.add(StationName2);
	}
	
public class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel Panel;
		public PanelButtonMouseAdapter(JPanel panel)
		{
			this.Panel=panel;
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
	}
}
