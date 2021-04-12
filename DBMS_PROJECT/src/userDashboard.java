import java.applet.*;
import java.awt.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class userDashboard extends JFrame {
	private JPanel contentPane;
	private Image movie=new ImageIcon(userDashboard.class.getResource("Movies-icon.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image booking=new ImageIcon(userDashboard.class.getResource("booking.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image wallet=new ImageIcon(userDashboard.class.getResource("wallet.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image rating=new ImageIcon(userDashboard.class.getResource("ratings.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image transaction=new ImageIcon(userDashboard.class.getResource("transaction.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image report=new ImageIcon(userDashboard.class.getResource("report.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image signout=new ImageIcon(userDashboard.class.getResource("signout.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public static int u=0;
	public userDashboard(int user_id) {
		u=user_id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 704);
		setUndecorated(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 69, 19));
		contentPane.setBounds(100, 100, 835, 704);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainframe = new JPanel();
		mainframe.setBackground(new Color(139, 69, 19));
		mainframe.setBounds(10, 11, 811, 645);
		contentPane.add(mainframe);
		mainframe.setLayout(null);
		
		JPanel Booking = new JPanel();
		Booking.setBorder(new LineBorder(new Color(0, 0, 0)));
		Booking.addMouseListener(new Adapter(Booking,1));
		Booking.setBackground(new Color(255, 239, 213));
		Booking.setBounds(0, 111, 811, 89);
		mainframe.add(Booking);
		Booking.setLayout(null);
		
		JLabel booklabel = new JLabel("Book A Ticket!");
		booklabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		booklabel.setForeground(new Color(0, 0, 0));
		booklabel.setBounds(357, 11, 255, 61);
		Booking.add(booklabel);
		
		JLabel Bookpic = new JLabel("");
		Bookpic.setHorizontalAlignment(SwingConstants.CENTER);
		Bookpic.setBounds(31, 0, 303, 83);
		Bookpic.setIcon(new ImageIcon(booking));
		Booking.add(Bookpic);
		
		JPanel Wallet = new JPanel();
		Wallet.setBorder(new LineBorder(new Color(0, 0, 0)));
		Wallet.addMouseListener(new Adapter(Wallet,2));
		Wallet.setBackground(new Color(255, 239, 213));
		Wallet.setBounds(0, 198, 811, 89);
		mainframe.add(Wallet);
		Wallet.setLayout(null);
		
		JLabel label = new JLabel("Check Your Wallet!");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label.setBounds(350, 11, 352, 61);
		Wallet.add(label);
		
		JLabel walletpic = new JLabel("");
		walletpic.setHorizontalAlignment(SwingConstants.CENTER);
		walletpic.setBounds(54, 11, 266, 83);
		walletpic.setIcon(new ImageIcon(wallet));
		Wallet.add(walletpic);
		
		JPanel Rating = new JPanel();
		Rating.setBorder(new LineBorder(new Color(0, 0, 0)));
		Rating.addMouseListener(new Adapter(Rating,3));
		Rating.setBackground(new Color(255, 239, 213));
		Rating.setBounds(0, 286, 811, 89);
		mainframe.add(Rating);
		Rating.setLayout(null);
		
		JLabel label_1 = new JLabel("Rate A Movie!");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_1.setBounds(353, 11, 248, 61);
		Rating.add(label_1);
		
		JLabel ratingpic = new JLabel("");
		ratingpic.setHorizontalAlignment(SwingConstants.CENTER);
		ratingpic.setBounds(57, 0, 266, 98);
		ratingpic.setIcon(new ImageIcon(rating));
		Rating.add(ratingpic);
		
		JPanel Transaction = new JPanel();
		Transaction.setBorder(new LineBorder(new Color(0, 0, 0)));
		Transaction.addMouseListener(new Adapter(Transaction,4));
		Transaction.setBackground(new Color(255, 239, 213));
		Transaction.setBounds(0, 372, 811, 96);
		mainframe.add(Transaction);
		Transaction.setLayout(null);		
		JLabel label_2 = new JLabel("Check Your Past Bookings");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_2.setBounds(355, 11, 433, 61);
		Transaction.add(label_2);
		
		JLabel transactionpic = new JLabel("");
		transactionpic.setHorizontalAlignment(SwingConstants.CENTER);
		transactionpic.setBounds(53, 0, 266, 96);
		transactionpic.setIcon(new ImageIcon(transaction));
		Transaction.add(transactionpic);
		
		JPanel Report = new JPanel();
		Report.setBorder(new LineBorder(new Color(0, 0, 0)));
		Report.addMouseListener(new Adapter(Report,5));
		Report.setBackground(new Color(255, 239, 213));
		Report.setBounds(0, 468, 811, 95);
		mainframe.add(Report);
		Report.setLayout(null);
		
		JLabel label_3 = new JLabel("Your Transaction History");
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_3.setBounds(354, 11, 416, 61);
		Report.add(label_3);
		
		JLabel reportpic = new JLabel("");
		reportpic.setHorizontalAlignment(SwingConstants.CENTER);
		reportpic.setBounds(60, 0, 266, 95);
		reportpic.setIcon(new ImageIcon(report));
		Report.add(reportpic);
		
		JPanel Signout = new JPanel();
		Signout.setBorder(new LineBorder(new Color(0, 0, 0)));
		Signout.addMouseListener(new Adapter(Signout,6));
		Signout.setBackground(new Color(255, 239, 213));
		Signout.setBounds(-11, 563, 822, 89);
		mainframe.add(Signout);
		Signout.setLayout(null);
		
		JLabel label_4 = new JLabel("Sign-Out");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_4.setBounds(353, 11, 168, 61);
		Signout.add(label_4);
		
		JLabel signoutpic = new JLabel("");
		signoutpic.setHorizontalAlignment(SwingConstants.CENTER);
		signoutpic.setBounds(47, 0, 266, 83);
		signoutpic.setIcon(new ImageIcon(signout));
		Signout.add(signoutpic);
		
		JPanel Dash = new JPanel();
		Dash.setLayout(null);
		Dash.setBackground(new Color(139, 69, 19));
		Dash.setBounds(0, 0, 807, 100);
		mainframe.add(Dash);
		
		JLabel Dashpic = new JLabel("");
		Dashpic.setHorizontalAlignment(SwingConstants.CENTER);
		Dashpic.setIcon(new ImageIcon(movie));
		Dashpic.setBounds(180, 11, 486, 78);
		Dash.add(Dashpic);
	}
	private class Adapter extends MouseAdapter{
		JPanel panel;
		int n;
		public Adapter(JPanel panel,int n) {
			this.panel=panel;
			this.n=n;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255, 239, 213));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60,179,113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112,128,144));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			new userDashboard(u).setVisible(false);
            if(n==1)
            {
            	new Booking(u).setVisible(true);
            }
            else if(n==2)
            {
            	
            }
            else if(n==3)
            {
            	
            }
            else if(n==4)
            {
            	
            }
            else if(n==5)
            {
            	
            }
            else if(n==6)
            {
            	
            }
		}
	}
}





