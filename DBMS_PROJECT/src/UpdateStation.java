import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.InputMethodEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JList;
import javax.swing.JMenuBar;
import java.awt.ScrollPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.io.*;
import java.util.*;

public class UpdateStation extends JFrame {

	private JFrame frame;
	JButton btnMakePayment;
	JLabel lblTotalAmount = new JLabel();
	
	
	Connection connect= null;
	ResultSet rs1,rs,rs2,rs3,rs_Getnumber,rs4;
	String rname,rid,rseat;
	String m1,m2,m3,m4,m5;
	public static int adminid,station_id, curr_movie_id;
	public static String station_name="", movie_list, emp_name;
	private JTextField station_given;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStation window = new UpdateStation(1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UpdateStation(int admin_id) {
		initialize(admin_id);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int admin_id) {
		
		adminid = admin_id;
		
		connect=databaseConnect.dbconnect();
		System.out.println("In Update window");
		
		// Get Employee Details
		String query1 = "select * from employee where Eid="+adminid+";";
		PreparedStatement ps1=null;
		try {

            ps1 = connect.prepareStatement(query1);
            rs1=ps1.executeQuery();
            while(rs1.next()) {
                station_id = rs1.getInt("Station ID");
            }
         }
         catch (SQLException ex) {
            System.out.println("Error getting employee details");
            System.out.println(ex.getMessage());
        }
		
		// Get Station details
		String query2 = "select * from cinemastation where `station id`="+station_id+";";
		PreparedStatement ps2=null;
		try {
            ps2 = connect.prepareStatement(query2);
            rs2=ps2.executeQuery();
            while(rs2.next()) {
                station_name = rs2.getString(5);
                curr_movie_id = rs2.getInt(4);
            }
         }
         catch (SQLException ex) {
            System.out.println("Error getting station details");
            System.out.println(ex.getMessage());
        }
		
		// Get All Movies
		Vector<String> v = new Vector<String>();
		Vector<Integer> v1 = new Vector<Integer>();
		String query3 = "select * from moviedetail;";
		PreparedStatement ps3=null;
		try {
            ps3 = connect.prepareStatement(query3);
            rs3=ps3.executeQuery();
            while(rs3.next()) {
            	String movie_name = rs3.getString(2);
            	int z = rs3.getInt(1);
                v.add(movie_name);
                v1.add(z);
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        } 
		
		System.out.println(v);
		System.out.println(v1);
		
		
        
		
   
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(102, 255, 255));
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 10));
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookingWindow = new JLabel("Update Window");
		lblBookingWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingWindow.setFont(new Font("Calibri", Font.BOLD, 30));
		lblBookingWindow.setBounds(165, 10, 300, 61);
		frame.getContentPane().add(lblBookingWindow);
		
		station_given = new JTextField();
		station_given.setText(station_name);
		
		station_given.setBounds(274, 119, 208, 19);
		frame.getContentPane().add(station_given);
		station_given.setColumns(10);
		station_given.setEditable(false);
		
		JCheckBox chkb1 = new JCheckBox("9 A.M - 12 P.M");
		chkb1.setBounds(277, 217, 93, 21);
		frame.getContentPane().add(chkb1);
		
		JCheckBox chkb3 = new JCheckBox("3 P.M - 6 P.M");
		chkb3.setBounds(414, 217, 93, 21);
		frame.getContentPane().add(chkb3);
		
		JCheckBox chkb2 = new JCheckBox("12 P.M - 3 P.M");
		chkb2.setBounds(277, 256, 93, 21);
		frame.getContentPane().add(chkb2);
		
		JCheckBox chkb4 = new JCheckBox("6 P.M - 9 P.M");
		chkb4.setBounds(414, 256, 93, 21);
		frame.getContentPane().add(chkb4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(274, 156, 221, 21);
		frame.getContentPane().add(comboBox);
		Iterator value = v.iterator();
        while (value.hasNext()) {
        	comboBox.addItem(value.next());
        }
        
        
		
		
		btnMakePayment = new JButton("Update");
		btnMakePayment.setFont(new Font("Calibri", Font.BOLD, 20));
		
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object item = comboBox.getSelectedItem();
		        String movie_selected = item.toString();
		        System.out.println(movie_selected);
		        
		        boolean x1 = chkb1.isSelected();
		        boolean x2 = chkb2.isSelected();
		        boolean x3 = chkb3.isSelected();
		        boolean x4 = chkb4.isSelected();
		        
		        String timing = "";
		        if(x1 == true) timing = timing + '1';
		        else timing = timing + '0';
		        if(x2 == true) timing = timing + '1';
		        else timing = timing + '0';
		        if(x3 == true) timing = timing + '1';
		        else timing = timing + '0';
		        if(x4 == true) timing = timing + '1';
		        else timing = timing + '0';
		        
		        System.out.println(timing);
		        
		        int movie_updated = 0;
		        for(int index = 0; index < v.size(); index++) {
		        	if(movie_selected.equals(v.get(index)))
					movie_updated = v1.get(index);
				}
		        
		        // Update Cinema Station
				try{
		             String query="UPDATE cinemastation "
		             		+ "SET "
		             		+ " Availability =" + timing
		             		+ ','
		             		+ " `Movie ID` =" + movie_updated
		             		+ " WHERE "
		             		+ " `Station ID` =" + station_id;
					 PreparedStatement ps=null;
					 ps=connect.prepareStatement(query);
					 ps.execute();
					 JOptionPane.showMessageDialog(null, "Update Successful");
					  
				}catch (java.sql.SQLException e){
					        System.out.println(e.getMessage());
					        JOptionPane.showMessageDialog(null, "Username Already Taken");
				}
		        
		        System.out.println(movie_updated);
		        
			}
		});
		btnMakePayment.setBounds(189, 392, 237, 30);
		frame.getContentPane().add(btnMakePayment);
		
		JLabel lblSelectDate = new JLabel("Update Movie");
		lblSelectDate.setBounds(78, 159, 173, 15);
		frame.getContentPane().add(lblSelectDate);
		
		JLabel lblSelectSlot = new JLabel("Select Slot");
		lblSelectSlot.setBounds(78, 217, 108, 15);
		frame.getContentPane().add(lblSelectSlot);
		
		
		
		JLabel lblSelectDate_1 = new JLabel("Alloted Station");
		lblSelectDate_1.setBounds(78, 121, 173, 15);
		frame.getContentPane().add(lblSelectDate_1);
		
	}
}
