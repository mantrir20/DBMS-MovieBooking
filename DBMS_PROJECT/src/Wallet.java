import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Wallet {

	private JFrame frame;
	private JLabel MoneyToBeAdded;
	private JLabel lblCurrentBalance;
	static Connection connect= null;
	ResultSet rs;
	String username;
	String balance;
	PreparedStatement ps1=null;
	public static int uid;
	int total;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Wallet(int user_id) {
		initialize(user_id);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int user_id) {
		
		uid=user_id;
		connect = databaseConnect.dbconnect();
		String query1 = "select * from User where Uid="+uid+";";
		
		try {
            ps1 = connect.prepareStatement(query1);
            rs=ps1.executeQuery();
            while(rs.next()) {
            	username = rs.getString("Uname");	
            	balance =rs.getString("Balance");
            }
            
		}
		catch(SQLException ex) {
			System.out.println("SQL Exception "+ex.getMessage());
		}
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblCurrentBalance = new JLabel("Current Balance : "+ "Rs "+balance);
		lblCurrentBalance.setBounds(60, 96, 348, 26);
		frame.getContentPane().add(lblCurrentBalance);
		
		JLabel lblHi = new JLabel("Hi "+username);
		lblHi.setBounds(60, 62, 101, 36);
		frame.getContentPane().add(lblHi);
		
		JLabel lblWallet = new JLabel("WALLET");
		lblWallet.setBounds(198, 22, 62, 26);
		frame.getContentPane().add(lblWallet);
		
		JButton Add50 = new JButton("+50");
		Add50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMoneyLabel(50);
			}

		});
		Add50.setBounds(46, 179, 79, 25);
		frame.getContentPane().add(Add50);
		
		JButton Add100 = new JButton("+100");
		Add100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMoneyLabel(100);
			}
		});
		Add100.setBounds(137, 179, 79, 25);
		frame.getContentPane().add(Add100);
		
		JButton Add500 = new JButton("+500");
		Add500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMoneyLabel(500);
			}
		});
		Add500.setBounds(227, 179, 79, 25);
		frame.getContentPane().add(Add500);
		
		JButton Add1000 = new JButton("+1000");
		Add1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMoneyLabel(1000);
			}
		});
		Add1000.setBounds(318, 179, 79, 25);
		frame.getContentPane().add(Add1000);
		
		JLabel lblAddMoney = new JLabel("Add Money");
		lblAddMoney.setBounds(154, 148, 95, 15);
		frame.getContentPane().add(lblAddMoney);
		
		MoneyToBeAdded = new JLabel("0");
		MoneyToBeAdded.setText("0");
		MoneyToBeAdded.setBounds(265, 148, 70, 15);
		frame.getContentPane().add(MoneyToBeAdded);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amnt=MoneyToBeAdded.getText();
				int i=Integer.parseInt(amnt);
				int j=Integer.parseInt(balance);
				total=i+j;
				String query="Update User"+" SET Balance = "+total+" Where Uid = "+uid+" ;";
				
				try {
		            ps1 = connect.prepareStatement(query);
		            int rs1=ps1.executeUpdate(query);
		            updateCurrentBalanceUI();
		            JOptionPane.showMessageDialog(null, "Money added Successfully!");
		            
				}
				catch(SQLException ex) {
					System.out.println("SQL Exception "+ex.getMessage());
				}
				
			}
		});
		btnAdd.setBounds(237, 216, 117, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoneyToBeAdded.setText("0");
			}
		});
		btnReset.setBounds(94, 216, 117, 25);
		frame.getContentPane().add(btnReset);
		
	
	}

	protected void updateCurrentBalanceUI() {
		 lblCurrentBalance.setText("Current Balance : "+ "Rs "+total);
		 MoneyToBeAdded.setText("0");
		
	}

	protected void updateMoneyLabel(int amount) {
		// TODO Auto-generated method stub
		String money= MoneyToBeAdded.getText();
		int i=Integer.parseInt(money); 
		i+=amount;
		money=Integer.toString(i);
		MoneyToBeAdded.setText(money);
		
	}
}
