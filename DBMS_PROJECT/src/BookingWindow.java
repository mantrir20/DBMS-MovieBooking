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

public class BookingWindow extends JFrame {

	private JFrame frame;
	private JTextField txtNoOfSeats;
	private JDateChooser dcDate;
	JButton btnMakePayment;
	JLabel lblTotalAmount = new JLabel();
	int seat, price;
	int totalCost=0;
	int availableSeats=100; //get value from database;
	int balance=1000; //get value from wallet.Balance;
	String date;

	
	
	Connection connect= null;
	ResultSet rs1,rs,rs2,rs3;
	String rname,rid;
	String m1,m2,m3,m4,m5;
	public static int u,m,s,total,s1,s2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingWindow window = new BookingWindow(1,1,1,300);
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
	public BookingWindow(int user_id,int movie_id,int station_id,int capacity) {
		initialize(user_id,movie_id,station_id,capacity);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int user_id,int movie_id,int station_id,int capacity) {
		
		u=user_id;
		m=movie_id;
		s=station_id;
		total=capacity;
		
		connect=databaseConnect.dbconnect();
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
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        }
		
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
		lblInputNumberOf.setBounds(116, 85, 214, 20);
		frame.getContentPane().add(lblInputNumberOf);
		
		txtNoOfSeats = new JTextField();
		txtNoOfSeats.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
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
				
				if(seat<=availableSeats && totalCost<=balance) {
					btnMakePayment.setEnabled(true);
				}
				else {
					btnMakePayment.setEnabled(false);
				}
				
				
			}
		});
		
		txtNoOfSeats.setText("0");
		txtNoOfSeats.setBounds(348, 81, 108, 30);
		frame.getContentPane().add(txtNoOfSeats);
		txtNoOfSeats.setColumns(10);
		
		JLabel lblSelectPaymentMethod = new JLabel("Select payment method");
		lblSelectPaymentMethod.setBounds(116, 136, 222, 20);
		frame.getContentPane().add(lblSelectPaymentMethod);
		
		JRadioButton rdbtnWallet = new JRadioButton("Wallet");
		rdbtnWallet.setSelected(true);
		rdbtnWallet.setBounds(348, 136, 110, 20);
		frame.getContentPane().add(rdbtnWallet);
		
		
		
		
		btnMakePayment = new JButton("Make Payment");
		btnMakePayment.setFont(new Font("Calibri", Font.BOLD, 20));
		btnMakePayment.setEnabled(false);
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-YYYY");
					date=sdf.format(dcDate.getDate()); //  pick (String)date variable from here to enter into database 
					System.out.println(date);
					JOptionPane.showMessageDialog(null, "Ticket Booked Successfully!");
					
					
				}
				catch(NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Choose Date!");
				}
				
				
				//add insert query in company transaction and ticket booking table
							
			}
		});
		btnMakePayment.setBounds(171, 315, 237, 30);
		frame.getContentPane().add(btnMakePayment);
		
		
		
		lblTotalAmount = new JLabel("Total Amount : "+ 0);
		lblTotalAmount.setFont(new Font("Calibri", Font.BOLD, 20));
		lblTotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalAmount.setBounds(156, 184, 270, 30);
		frame.getContentPane().add(lblTotalAmount);
		
		JLabel lblSelectDate = new JLabel("Select Date : ");
		lblSelectDate.setBounds(116, 244, 173, 15);
		frame.getContentPane().add(lblSelectDate);
		
		dcDate = new JDateChooser();
		
		
		dcDate.setBounds(348, 240, 110, 19);
		frame.getContentPane().add(dcDate);
		
		
		
		

	}
}
