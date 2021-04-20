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

public class BookingWindow extends JFrame {

	private JFrame frame;
	private JTextField txtNoOfSeats;
	private JDateChooser dcDate;
	private JRadioButton rdbtn1,rdbtn2,rdbtn4,rdbtn3;
	JButton btnMakePayment;
	JLabel lblTotalAmount = new JLabel();
	int seat, price;
	int totalCost=0;
	int availableSeats=1000; //get value from database;
	int balance; //get value from wallet.Balance;
	String date;
	String movieName;
	int numOfSeats;
	String dummy;
	int time;
	int ticketID;
	int paymentID;
	String times;
	
	
	Connection connect= null;
	ResultSet rs1,rs,rs2,rs3,rs_Getnumber,rs4,rs_Getnumber1;
	String rname,rid,rseat;
	String m1,m2,m3,m4,m5;
	public static int u,m,s,capacity,s1,s2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingWindow window = new BookingWindow(1,1,1);
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
	public BookingWindow(int user_id,int movie_id,int station_id) {
		initialize(user_id,movie_id,station_id);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int user_id,int movie_id,int station_id) {
		
		u=user_id;
		m=movie_id;
		s=station_id;
		
		connect=databaseConnect.dbconnect();
		System.out.println("in Booking window");
		String query1 = "select * from User where Uid="+u+";";
		String query2 = "select * from MovieDetail where `Movie ID`="+m+";";
		
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		try {

            ps1 = connect.prepareStatement(query1);
            rs1=ps1.executeQuery();
            ps2 = connect.prepareStatement(query2);
            rs2=ps2.executeQuery();
            while(rs1.next()) {
                rname = rs1.getString("Balance");
            }
            while(rs2.next()) {
            	
                rid = rs2.getString("Price");
                movieName=rs2.getString("Movie Name");
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        }
		
		PreparedStatement ps_Getnumber = null;
        try {
      	  String query_Getnumber = "select count(*) from Ticket";
      	  ps_Getnumber  = connect.prepareStatement(query_Getnumber);
            rs_Getnumber = ps_Getnumber.executeQuery();
            rs_Getnumber.next();
            ticketID = rs_Getnumber.getInt(1);
        }catch(Exception e) {
      	  System.out.println(e.getMessage());
		      JOptionPane.showMessageDialog(null, "Error getting number of users");
        }
        
		PreparedStatement ps_Getnumber1 = null;
        try {
      	  String query_Getnumber = "select count(*) from CompanyTransaction";
      	  ps_Getnumber1  = connect.prepareStatement(query_Getnumber);
            rs_Getnumber1 = ps_Getnumber1.executeQuery();
            rs_Getnumber1.next();
           paymentID = rs_Getnumber1.getInt(1);
        }
        catch(Exception e) {
      	  System.out.println(e.getMessage());
		      JOptionPane.showMessageDialog(null, "Error getting number of transactions");
        }
        
        
        
        
        String query5 = "select * from CinemaStation where `Station ID`="+s+";";
		PreparedStatement ps5=null;
		try {
            ps5 = connect.prepareStatement(query5);
            rs4=ps5.executeQuery();
            int i=0;
            while(rs4.next()) {
                times= rs4.getString("Availability");
                rseat = rs4.getString("Total Seats");
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        } 
		int t1=Character.getNumericValue(times.charAt(0));  
		int t2=Character.getNumericValue(times.charAt(1));  
		int t3=Character.getNumericValue(times.charAt(2));  
		int t4=Character.getNumericValue(times.charAt(3));
		
	
		
		
		capacity = Integer.parseInt(rseat);
		balance = Integer.parseInt(rname);
		price = Integer.parseInt(rid);
		
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(102, 255, 255));
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 10));
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookingWindow = new JLabel("Booking Window");
		lblBookingWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingWindow.setFont(new Font("Calibri", Font.BOLD, 30));
		lblBookingWindow.setBounds(156, 12, 300, 61);
		frame.getContentPane().add(lblBookingWindow);
		
		JLabel lblInputNumberOf = new JLabel("Input number of seats :");
		lblInputNumberOf.setBounds(78, 238, 214, 20);
		frame.getContentPane().add(lblInputNumberOf);
		
		txtNoOfSeats = new JTextField();
		txtNoOfSeats.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
//				if(dcDate.getDate().toString()!="") {
//					txtNoOfSeats.setEnabled(true);
//				}
//				else {
//					JOptionPane.showMessageDialog(null, "Choose date first");
//					return;
//				}
				try{
					seat= Integer.parseInt(txtNoOfSeats.getText());
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "Enter a positive integral value.");
				}
				if(seat<0)
				{
					JOptionPane.showMessageDialog(null, "Enter a positive value.");
				}
				else if(seat>availableSeats) {
					JOptionPane.showMessageDialog(null, "Only "+availableSeats+" seats remaining.");
				}
				else {
					totalCost=seat*price;
					
				}
				
				if(totalCost<=balance) {
					lblTotalAmount.setText("Total Amount : "+ totalCost);					
				}
				else {
					lblTotalAmount.setText("Total Amount : "+ totalCost);
					JOptionPane.showMessageDialog(null, "Insufficient Balance in wallet");
				}
				
				if(seat<=availableSeats) {
					btnMakePayment.setEnabled(true);
				}
				else {
					btnMakePayment.setEnabled(false);
				}
				
				
			}
		});
		
		txtNoOfSeats.setText("0");
		txtNoOfSeats.setBounds(277, 234, 188, 30);
		frame.getContentPane().add(txtNoOfSeats);
		txtNoOfSeats.setColumns(10);
		
		
		
		
		btnMakePayment = new JButton("Make Payment");
		btnMakePayment.setFont(new Font("Calibri", Font.BOLD, 20));
		btnMakePayment.setEnabled(false);
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
					date=sdf.format(dcDate.getDate()); //  pick (String)date variable from here to enter into database 
					System.out.println(date);
					String query3 = "select sum(`Number of Seats`) temp from Ticket where Date="+"\""+date+"\""+" and `Movie Name`="+"\""+movieName+"\" and Time=1;";

					PreparedStatement ps3=null;
					try {

			           
			            ps3 = connect.prepareStatement(query3);
			            rs3=ps3.executeQuery();
			            while(rs3.next()) {
			            	
			            	dummy = rs3.getString("temp");
			            	if(dummy==null) {
			            		dummy="0";
			            	}
			                
			            }
			            
			         }
			         catch (SQLException ex) {
			            System.out.println("Entered");
			            System.out.println(ex.getMessage());
			        }
					numOfSeats = Integer.parseInt(dummy.toString());
					System.out.println("numofseats="+numOfSeats+"dummy="+dummy);
					availableSeats=capacity-numOfSeats;
					
					if(totalCost<=balance) {
						
						System.out.println(time);
						try{
				             String query4="insert into Ticket values(?,?,?,?,?,?,?)";
							 PreparedStatement ps4=null;
							 ps4=connect.prepareStatement(query4);
							
							 ps4.setInt(1, ticketID+1);
							 ps4.setString(2, movieName);
							 ps4.setInt(3, seat); // Initial Balance of 5000
							 ps4.setString(4, date);
							 ps4.setInt(5, time);
							 ps4.setInt(6, u);
							 ps4.setInt(7, s);
							 ps4.execute();
							 JOptionPane.showMessageDialog(null, "Ticket Booked Successfully!");
						
							 balance=balance-(seat*price);
							 String query6= "update User set Balance="+balance+" where Uid="+u+";";
							 PreparedStatement ps6=null;
							 ps6=connect.prepareStatement(query6);
							 int rs1=ps6.executeUpdate(query6);
							 
							 String query7="insert into CompanyTransaction values(?,?,?,?,?,?,?,?)";
							 PreparedStatement ps7=null;
							 ps7=connect.prepareStatement(query7);
							
							 ps7.setInt(1, paymentID+1);
							 ps7.setInt(2, 1);
							 ps7.setInt(3, seat); 
							 ps7.setInt(4, totalCost);
							 ps7.setString(5, date);
							 ps7.setInt(6, time);
							 ps7.setInt(7, u);
							 ps7.setInt(8, s);
							 ps7.execute();
							 
							 dispose();
							 
							  
							 }
						catch (java.sql.SQLException e){
							        System.out.println(e.getMessage());
							        
							  }

							                
		                
		                
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Transaction Failed! Please Add money in your wallet, Current balance: "+balance);
						try{
				             String query7="insert into CompanyTransaction values(?,?,?,?,?,?,?,?)";
							 PreparedStatement ps7=null;
							 ps7=connect.prepareStatement(query7);
							
							 ps7.setInt(1, paymentID+1);
							 ps7.setInt(2, 0);
							 ps7.setInt(3, seat);
							 ps7.setInt(4, totalCost);
							 ps7.setString(5, date);
							 ps7.setInt(6, time);
							 ps7.setInt(7, u);
							 ps7.setInt(8, s);
							 ps7.execute();

							 dispose();
							 
							  
							 }
						catch (java.sql.SQLException e){
							        System.out.println(e.getMessage());
							        
							  }
					}
					
					
					
				}
				catch(NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Choose Date!");
				}
				
				
				//add insert query in company transaction and ticket booking table
							
			}
		});
		btnMakePayment.setBounds(189, 392, 237, 30);
		frame.getContentPane().add(btnMakePayment);
		
		
		
		lblTotalAmount = new JLabel("Total Amount : "+ 0);
		lblTotalAmount.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAmount.setBounds(156, 329, 270, 30);
		frame.getContentPane().add(lblTotalAmount);
		
		JLabel lblSelectDate = new JLabel("Select Date : ");
		lblSelectDate.setBounds(78, 85, 173, 15);
		frame.getContentPane().add(lblSelectDate);
		
		dcDate = new JDateChooser();
		
		
		dcDate.setBounds(277, 85, 188, 19);
		frame.getContentPane().add(dcDate);
		
		JLabel lblSelectSlot = new JLabel("Select Slot");
		lblSelectSlot.setBounds(77, 130, 108, 15);
		frame.getContentPane().add(lblSelectSlot);
		
		 rdbtn1 = new JRadioButton("9 A.M -12 P.M");
		 rdbtn1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(rdbtn1.isSelected()){    
		 			time=1;    
		 			} 
		 	}
		 });
		 
		rdbtn1.setEnabled(false);
		rdbtn1.setBounds(277, 126, 149, 23);
		frame.getContentPane().add(rdbtn1);
		
		 rdbtn2 = new JRadioButton("12 P.M-3 P.M");
		rdbtn2.setEnabled(false);
		rdbtn2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(rdbtn2.isSelected()){    
		 			time=2;    
		 			} 
		 	}
		 });
		rdbtn2.setBounds(430, 126, 149, 23);
		frame.getContentPane().add(rdbtn2);
		
		 rdbtn3 = new JRadioButton("3 P.M - 6 P.M.");
		rdbtn3.setEnabled(false);
		rdbtn3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(rdbtn3.isSelected()){    
		 			time=3;    
		 			} 
		 	}
		 });
		rdbtn3.setBounds(277, 165, 149, 23);
		frame.getContentPane().add(rdbtn3);
		
		 rdbtn4 = new JRadioButton("6 P.M -9 P.M");
		rdbtn4.setEnabled(false);
		rdbtn4.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(rdbtn4.isSelected()){    
		 			time=4;    
		 			} 
		 	}
		 });
		rdbtn4.setBounds(430, 165, 149, 23);
		frame.getContentPane().add(rdbtn4);
		
		if(t1==1) {
			rdbtn1.setEnabled(true);
		}
		if(t2==1) {
			rdbtn2.setEnabled(true);
		}
		if(t3==1) {
			rdbtn3.setEnabled(true);
		}
		if(t4==1) {
			rdbtn4.setEnabled(true);
		}
	}
}
