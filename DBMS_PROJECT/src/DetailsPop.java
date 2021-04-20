import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DetailsPop extends JFrame {

	private JPanel contentPane;
	public int s;
	Connection connect= null;
	 ResultSet rs1,rs,rs2,rs3;
	 String rname,rid,rtemp,rtemp2,rtemp3,rtemp4;
	 String m1,m2,m3,m4,m5,m6,m7,m8,m9,m0;
	 int s1,s2,s3,s4,s5,s6,s7,s8,s9,s0,id1,price;
	 String m12,m22,m32,m42,m52,m62,m72,m82,m92,m02;
	 String[] movies= {"Avengers","Batman","3 Idiots","Tenet","Inception"};
	 public static int u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsPop frame = new DetailsPop(1);
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
	public DetailsPop(int id) {
		s=id;
		
		connect=databaseConnect.dbconnect();
		String query1 = "select * from CinemaStation;";
		PreparedStatement ps1=null;
		try {
            ps1 = connect.prepareStatement(query1);
            rs1=ps1.executeQuery();
            
            while(rs1.next()) {
                rname = rs1.getString("Station Name");
                rtemp = rs1.getString("Station ID");
                int temp=Integer.parseInt(rtemp);
                if(temp==s)
                {
	                rid = rs1.getString("Movie ID");
	                rtemp2 = rs1.getString("Total Seats");
	                id1= Integer.parseInt(rid);
	                m1=rname;
	                m12=movies[id1-1];
	                s1= Integer.parseInt(rtemp);
	                s2=Integer.parseInt(rtemp2);
                }
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        }
		

		String query2 = "select * from MovieDetail where `Movie ID`="+id1+";";
		PreparedStatement ps2=null;
		
		try {
            ps2 = connect.prepareStatement(query2);
            rs2=ps2.executeQuery();
            while(rs2.next()) {
            	rtemp3 = rs2.getString("Price");
            	rtemp4 = rs2.getString("Movie Name");
            }
         }
         catch (SQLException ex) {
            System.out.println("Entered");
            System.out.println(ex.getMessage());
        }
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 255, 255));
		panel.setBounds(50, 5, 800, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(m1);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(250, 15, 300, 30);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 51));
		panel_1.setBounds(50, 100, 800, 180);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Total Capacity");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_1.setBounds(150, 20, 150, 30);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblMoviePrice = new JLabel("Movie Name");
		lblMoviePrice.setFont(new Font("Calibri", Font.BOLD, 20));
		lblMoviePrice.setBounds(150, 70, 150, 30);
		panel_1.add(lblMoviePrice);
		
		JLabel lblMoviePrice_1 = new JLabel("Movie Price");
		lblMoviePrice_1.setFont(new Font("Calibri", Font.BOLD, 20));
		lblMoviePrice_1.setBounds(150, 120, 150, 30);
		panel_1.add(lblMoviePrice_1);
		
		JLabel label = new JLabel(rtemp2);
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		label.setBounds(450, 20, 150, 30);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel(rtemp4);
		label_1.setFont(new Font("Calibri", Font.BOLD, 20));
		label_1.setBounds(450, 70, 150, 30);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel(rtemp3);
		label_2.setFont(new Font("Calibri", Font.BOLD, 20));
		label_2.setBounds(450, 120, 150, 30);
		panel_1.add(label_2);
	}
}
