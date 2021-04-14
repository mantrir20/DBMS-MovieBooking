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
import java.awt.event.InputMethodEvent;

public class BookingWindow {

	private JFrame frame;
	private JTextField txtNoOfSeats;
	JButton btnMakePayment;
	JLabel lblTotalAmount = new JLabel();
	int seat, price;
	int totalCost=0;
	int availableSeats=50; //get value from database;
	int balance=1000; //get value from wallet.Balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingWindow window = new BookingWindow();
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
	public BookingWindow() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookingWindow = new JLabel("Booking Window");
		lblBookingWindow.setBounds(153, 12, 127, 20);
		frame.getContentPane().add(lblBookingWindow);
		
		JLabel lblInputNumberOf = new JLabel("Input number of seats :");
		lblInputNumberOf.setBounds(38, 63, 185, 15);
		frame.getContentPane().add(lblInputNumberOf);
		
		txtNoOfSeats = new JTextField();
		txtNoOfSeats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seat= Integer.parseInt(txtNoOfSeats.getText());
				if(seat>availableSeats) {
					JOptionPane.showMessageDialog(null, "Only "+availableSeats+" seats remaining.");
				}
				else {
					price= 100; // price of movie Ticket
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
		txtNoOfSeats.setBounds(241, 61, 114, 19);
		frame.getContentPane().add(txtNoOfSeats);
		txtNoOfSeats.setColumns(10);
		
		JLabel lblSelectPaymentMethod = new JLabel("Select payment method");
		lblSelectPaymentMethod.setBounds(38, 102, 185, 15);
		frame.getContentPane().add(lblSelectPaymentMethod);
		
		JRadioButton rdbtnWallet = new JRadioButton("Wallet");
		rdbtnWallet.setSelected(true);
		rdbtnWallet.setBounds(241, 98, 149, 23);
		frame.getContentPane().add(rdbtnWallet);
		
		
		
		
		btnMakePayment = new JButton("Make Payment");
		btnMakePayment.setEnabled(false);
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Ticket Booked Successfully!");
				//add insert query in company transaction and ticket booking table
							
			}
		});
		btnMakePayment.setBounds(153, 198, 169, 25);
		frame.getContentPane().add(btnMakePayment);
		
		
		
		lblTotalAmount = new JLabel("Total Amount : "+ 0);
		lblTotalAmount.setBounds(38, 146, 382, 15);
		frame.getContentPane().add(lblTotalAmount);
		
		
		
		

	}
}
