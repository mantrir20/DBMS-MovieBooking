import java.applet.*;
import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.*;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import com.itextpdf.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class adminDashboard extends JFrame {
	private JPanel contentPane;
	private Image movie=new ImageIcon(userDashboard.class.getResource("Movies-icon.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image booking=new ImageIcon(userDashboard.class.getResource("booking.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image wallet=new ImageIcon(userDashboard.class.getResource("wallet.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image rating=new ImageIcon(userDashboard.class.getResource("ratings.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image transaction=new ImageIcon(userDashboard.class.getResource("transaction.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image report=new ImageIcon(userDashboard.class.getResource("report.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image signout=new ImageIcon(userDashboard.class.getResource("signout.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image user=new ImageIcon(userDashboard.class.getResource("User.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image update=new ImageIcon(userDashboard.class.getResource("Update.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image view=new ImageIcon(userDashboard.class.getResource("View.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	static Connection connect= null;
	/**
	 * Launch the application.
	 * 
	 * 
	 */
	String ename;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userDashboard frame = new userDashboard(1);
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
	public static int u=0;
	public adminDashboard(int admin_id) {
		
		u=admin_id;
		
		PreparedStatement ps1=null;
		connect = databaseConnect.dbconnect();
		String query1 = "select * from Employee where Eid="+u+";";
		
		try {
			
            ps1 = connect.prepareStatement(query1);
            ResultSet rs=ps1.executeQuery(query1);
            while(rs.next()) {
            	ename = rs.getString("Ename");
            }
            
		}
		catch(SQLException ex) {
			System.out.println("SQL Exception "+ex.getMessage());
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 700);
		//setBounds(100, 100, 450, 300);
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
		Booking.addMouseListener(new Adapter(Booking,3));
		Booking.setBackground(new Color(255, 239, 213));
		Booking.setBounds(0, 111, 811, 89);
		mainframe.add(Booking);
		Booking.setLayout(null);
		
		JLabel booklabel = new JLabel("Station Report");
		booklabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		booklabel.setForeground(new Color(0, 0, 0));
		booklabel.setBounds(158, 12, 641, 61);
		Booking.add(booklabel);
		
		JLabel Bookpic = new JLabel("");
		Bookpic.setHorizontalAlignment(SwingConstants.CENTER);
		Bookpic.setBounds(29, 0, 99, 83);
		Bookpic.setIcon(new ImageIcon(view));
		Booking.add(Bookpic);
		
		JPanel Wallet = new JPanel();
		Wallet.setBorder(new LineBorder(new Color(0, 0, 0)));
		Wallet.addMouseListener(new Adapter(Wallet,1));
		Wallet.setBackground(new Color(255, 239, 213));
		Wallet.setBounds(0, 198, 811, 89);
		mainframe.add(Wallet);
		Wallet.setLayout(null);
		
		JLabel lblUserInterface = new JLabel("View Station Details");
		lblUserInterface.setForeground(new Color(0, 0, 0));
		lblUserInterface.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblUserInterface.setBounds(159, 11, 613, 61);
		Wallet.add(lblUserInterface);
		
		JLabel walletpic = new JLabel("");
		walletpic.setHorizontalAlignment(SwingConstants.CENTER);
		walletpic.setBounds(12, 12, 125, 68);
		walletpic.setIcon(new ImageIcon(update));
		Wallet.add(walletpic);
		
		JPanel Rating = new JPanel();
		Rating.setBorder(new LineBorder(new Color(0, 0, 0)));
		Rating.addMouseListener(new Adapter(Rating,2));
		Rating.setBackground(new Color(255, 239, 213));
		Rating.setBounds(0, 286, 811, 89);
		mainframe.add(Rating);
		Rating.setLayout(null);
		
		JLabel lblUpdateStationDetails = new JLabel("Update Station Details");
		lblUpdateStationDetails.setForeground(new Color(0, 0, 0));
		lblUpdateStationDetails.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		lblUpdateStationDetails.setBounds(161, 11, 577, 61);
		Rating.add(lblUpdateStationDetails);
		
		JLabel ratingpic = new JLabel("");
		ratingpic.setHorizontalAlignment(SwingConstants.CENTER);
		ratingpic.setBounds(39, 0, 90, 90);
		ratingpic.setIcon(new ImageIcon(report));
		Rating.add(ratingpic);
		
		JPanel Transaction = new JPanel();
		Transaction.setBorder(new LineBorder(new Color(0, 0, 0)));
		Transaction.addMouseListener(new Adapter(Transaction,4));
		Transaction.setBackground(new Color(255, 239, 213));
		Transaction.setBounds(0, 372, 811, 96);
		mainframe.add(Transaction);
		Transaction.setLayout(null);		
		JLabel label_2 = new JLabel("User Interface");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_2.setBounds(159, 11, 662, 61);
		Transaction.add(label_2);
		
		JLabel transactionpic = new JLabel("");
		transactionpic.setHorizontalAlignment(SwingConstants.CENTER);
		transactionpic.setBounds(29, 0, 107, 96);
		transactionpic.setIcon(new ImageIcon(user));
		Transaction.add(transactionpic);
		
		JPanel Signout = new JPanel();
		Signout.setBorder(new LineBorder(new Color(0, 0, 0)));
		Signout.addMouseListener(new Adapter(Signout,6));
		Signout.setBackground(new Color(255, 239, 213));
		Signout.setBounds(0, 468, 822, 89);
		mainframe.add(Signout);
		Signout.setLayout(null);
		
		JLabel label_4 = new JLabel("Sign-Out");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_4.setBounds(182, 11, 339, 61);
		Signout.add(label_4);
		
		JLabel signoutpic = new JLabel("");
		signoutpic.setHorizontalAlignment(SwingConstants.CENTER);
		signoutpic.setBounds(36, 0, 107, 83);
		signoutpic.setIcon(new ImageIcon(signout));
		Signout.add(signoutpic);
		
		JPanel Dash = new JPanel();
		Dash.setLayout(null);
		Dash.setBackground(new Color(139, 69, 19));
		Dash.setBounds(12, 0, 807, 100);
		mainframe.add(Dash);
		
		JLabel Dashpic = new JLabel("");
		Dashpic.setHorizontalAlignment(SwingConstants.CENTER);
		Dashpic.setIcon(new ImageIcon(movie));
		Dashpic.setBounds(24, 12, 134, 78);
		Dash.add(Dashpic);
		
		JLabel lblHi = new JLabel("Hi! "+ename);
		lblHi.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblHi.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 43));
		lblHi.setForeground(Color.WHITE);
		lblHi.setSize(new Dimension(20, 20));
		lblHi.setBounds(301, 12, 483, 64);
		Dash.add(lblHi);
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
            if(n==1)
            {
            	setVisible(false);
            	new ViewDetails(u).setVisible(true);
            }
            else if(n==2)
            {
            	setVisible(false);
            	new UpdateStation(u).setVisible(true);
            }
            else if(n==3)
            {
            	try
            	{
            		String file_name="Station_report.pdf";
                	Document document=new Document();
                	PdfWriter.getInstance(document, new FileOutputStream(file_name));
                	document.open();
                	PdfPTable table=new PdfPTable(5);
                	PdfPCell c1=new PdfPCell(new Phrase("Station ID"));
                	PdfPCell c2=new PdfPCell(new Phrase("Total Seats"));
                	PdfPCell d1=new PdfPCell(new Phrase("Availability"));
                	PdfPCell d2=new PdfPCell(new Phrase("Movie ID"));
                	PdfPCell e1=new PdfPCell(new Phrase("Station Name"));
                	table.addCell(c1);
                	table.addCell(c2);
                	table.addCell(d1);
                	table.addCell(d2);
                	table.addCell(e1);
                	table.setHeaderRows(1);
                	Connection connect=databaseConnect.dbconnect();
                	String query="select * from CinemaStation order by `Station ID`";
                	PreparedStatement ps1=null;
                	try {
                        ps1 = connect.prepareStatement(query);
                        ResultSet rs=ps1.executeQuery();
                        int i=0;
                        while(rs.next()) {
                        	PdfPCell c3=new PdfPCell(new Phrase(rs.getString("Station Id")));
                        	table.addCell(c3);          
                        	PdfPCell c4=new PdfPCell(new Phrase(rs.getString("Total Seats")));
                        	table.addCell(c4);
                        	PdfPCell c5=new PdfPCell(new Phrase(rs.getString("Availability")));
                        	table.addCell(c5);
                        	PdfPCell c6=new PdfPCell(new Phrase(rs.getString("Movie ID")));
                        	table.addCell(c6);
                        	PdfPCell c7=new PdfPCell(new Phrase(rs.getString("Station Name")));
                        	table.addCell(c7);
                        }
                     }
                     catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                	document.add(table);
                	document.close();
            	}
            	catch(Exception e1)
            	{
            		System.err.println(e1);
            	}
            }
            else if(n==4)
            {
            	setVisible(false);
            	new loginPage().setVisible(true);
            }
            else
            {
            	setVisible(false);
            	new loginPage().setVisible(true);
            }
		}
	}
}





