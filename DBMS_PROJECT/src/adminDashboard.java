import java.applet.*;
import java.awt.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class adminDashboard extends JFrame {
	private JPanel contentPane;
	private Image movie=new ImageIcon(userDashboard.class.getResource("Movies-icon.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image booking=new ImageIcon(userDashboard.class.getResource("booking.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image wallet=new ImageIcon(userDashboard.class.getResource("wallet.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image rating=new ImageIcon(userDashboard.class.getResource("ratings.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image transaction=new ImageIcon(userDashboard.class.getResource("transaction.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image report=new ImageIcon(userDashboard.class.getResource("report.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image signout=new ImageIcon(userDashboard.class.getResource("signout.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image update=new ImageIcon(userDashboard.class.getResource("Update.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image view=new ImageIcon(userDashboard.class.getResource("View.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	private Image user=new ImageIcon(userDashboard.class.getResource("User.png")).getImage().getScaledInstance(90,90,Image.SCALE_SMOOTH);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminDashboard frame = new adminDashboard(1);
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
	public adminDashboard(int admin_id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 604);
		setUndecorated(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 69, 19));
		contentPane.setBounds(100, 100, 835, 704);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel mainframe = new JPanel();
		mainframe.setBackground(new Color(139, 69, 19));
		mainframe.setBounds(10, 11, 824, 545);
		contentPane.add(mainframe);
		mainframe.setLayout(null);
		
		JPanel Booking = new JPanel();
		Booking.setBorder(new LineBorder(new Color(0, 0, 0)));
		Booking.addMouseListener(new Adapter(Booking));
		Booking.setBackground(new Color(255, 239, 213));
		Booking.setBounds(0, 111, 811, 89);
		mainframe.add(Booking);
		Booking.setLayout(null);
		
		JLabel booklabel = new JLabel("View Station Details");
		booklabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		booklabel.setForeground(new Color(0, 0, 0));
		booklabel.setBounds(357, 11, 255, 61);
		Booking.add(booklabel);
		
		JLabel Bookpic = new JLabel("");
		Bookpic.setHorizontalAlignment(SwingConstants.CENTER);
		Bookpic.setBounds(31, 0, 303, 83);
		Bookpic.setIcon(new ImageIcon(view));
		Booking.add(Bookpic);
		
		JPanel Wallet = new JPanel();
		Wallet.setBorder(new LineBorder(new Color(0, 0, 0)));
		Wallet.addMouseListener(new Adapter(Wallet));
		Wallet.setBackground(new Color(255, 239, 213));
		Wallet.setBounds(0, 198, 811, 89);
		mainframe.add(Wallet);
		Wallet.setLayout(null);
		
		JLabel label = new JLabel("Update Station Details");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label.setBounds(350, 11, 352, 61);
		Wallet.add(label);
		
		JLabel walletpic = new JLabel("");
		walletpic.setHorizontalAlignment(SwingConstants.CENTER);
		walletpic.setBounds(54, 0, 266, 94);
		walletpic.setIcon(new ImageIcon(update));
		Wallet.add(walletpic);
		
		JPanel Report = new JPanel();
		Report.setBorder(new LineBorder(new Color(0, 0, 0)));
		Report.addMouseListener(new Adapter(Report));
		Report.setBackground(new Color(255, 239, 213));
		Report.setBounds(0, 285, 811, 89);
		mainframe.add(Report);
		Report.setLayout(null);
		
		JLabel label_1 = new JLabel("Station Report");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_1.setBounds(353, 11, 248, 61);
		Report.add(label_1);
		
		JLabel reportpic = new JLabel("");
		reportpic.setHorizontalAlignment(SwingConstants.CENTER);
		reportpic.setBounds(46, 11, 266, 78);
		reportpic.setIcon(new ImageIcon(report));
		Report.add(reportpic);
		
		JPanel Signout = new JPanel();
		Signout.setBorder(new LineBorder(new Color(0, 0, 0)));
		Signout.addMouseListener(new Adapter(Signout));
		Signout.setBackground(new Color(255, 239, 213));
		Signout.setBounds(0, 456, 811, 89);
		mainframe.add(Signout);
		Signout.setLayout(null);
		
		JLabel label_4 = new JLabel("Sign-Out");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_4.setBounds(353, 11, 168, 61);
		Signout.add(label_4);
		
		JLabel signoutpic = new JLabel("");
		signoutpic.setHorizontalAlignment(SwingConstants.CENTER);
		signoutpic.setBounds(46, 11, 266, 83);
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.addMouseListener(new Adapter(panel));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 239, 213));
		panel.setBounds(0, 369, 811, 89);
		mainframe.add(panel);
		
		JLabel label_2 = new JLabel("User Interface");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 40));
		label_2.setBounds(353, 11, 205, 61);
		panel.add(label_2);
		
		JLabel userpic = new JLabel("");
		userpic.setHorizontalAlignment(SwingConstants.CENTER);
		userpic.setBounds(56, 11, 247, 78);
		userpic.setIcon(new ImageIcon(user));
		panel.add(userpic);
	}
	private class Adapter extends MouseAdapter{
		JPanel panel;
		public Adapter(JPanel panel) {
			this.panel=panel;
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
	}
}