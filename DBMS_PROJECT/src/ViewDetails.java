import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewDetails extends JFrame {

	private JPanel OuterContainer;

	/**
	 * Launch the application.
	 */
	Connection connect= null;
	 ResultSet rs1,rs,rs2,rs3;
	 public static int u1;
	 String rname,rid,rtemp;
	 String m1,m2,m3,m4,m5,m6,m7,m8,m9,m0;
	 int s1,s2,s3,s4,s5,s6,s7,s8,s9,s0;
	 String m12,m22,m32,m42,m52,m62,m72,m82,m92,m02;
	 String[] movies= {"Avengers","Batman","3 Idiots","Tenet","Inception"};
	 public static int u;

	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDetails frame = new ViewDetails(1);
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
	public ViewDetails(int id2) {
		connect=databaseConnect.dbconnect();
		u1=id2;
		String query1 = "select * from CinemaStation";
		PreparedStatement ps1=null;
		try {
            ps1 = connect.prepareStatement(query1);
            rs3=ps1.executeQuery();
            int i=0;
            while(rs3.next()) {
                rname = rs3.getString("Station Name");
                rid = rs3.getString("Movie ID");
                rtemp = rs3.getString("Station ID");
                int id= Integer.parseInt(rid);
                if(i==0)
                {
                	m1=rname;
                	m12=movies[id-1];
                	s1= Integer.parseInt(rtemp);
                }
                else if(i==1)
                {
                	m2=rname;
                	m22=movies[id-1];
                	s2= Integer.parseInt(rtemp);
                }
                else if(i==2)
                {
                	m3=rname;
                	m32=movies[id-1];
                	s3= Integer.parseInt(rtemp);
                }
                else if(i==3)
                {
                	m4=rname;
                	m42=movies[id-1];
                	s4= Integer.parseInt(rtemp);
                }
                else if(i==5)
                {
                	m5=rname;
                	m52=movies[id-1];
                	s5= Integer.parseInt(rtemp);
                }
                else if(i==6)
                {
                	m6=rname;
                	m62=movies[id-1];
                	s6= Integer.parseInt(rtemp);
                }
                else if(i==7)
                {
                	m7=rname;
                	m72=movies[id-1];
                	s7= Integer.parseInt(rtemp);
                }
                else if(i==8)
                {
                	m8=rname;
                	m82=movies[id-1];
                	s8= Integer.parseInt(rtemp);
                }
                else if(i==9)
                {
                	m9=rname;
                	m92=movies[id-1];
                	s9= Integer.parseInt(rtemp);
                }
                else
                {
                	m0=rname;
                	m02=movies[id-1];
                	s0= Integer.parseInt(rtemp);
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
		OuterContainer.setBackground(new Color(51, 255, 255));
		OuterContainer.setBorder(null);
		setContentPane(OuterContainer);
		OuterContainer.setLayout(null);
		
		JPanel MovieOptions = new JPanel();
		MovieOptions.setBackground(new Color(51, 255, 255));
		MovieOptions.setForeground(new Color(0, 0, 0));
		MovieOptions.setBounds(10, 10, 1280, 730);
		OuterContainer.add(MovieOptions);
		MovieOptions.setLayout(null);
		
		JLabel MovieHeading = new JLabel("Station Details");
		MovieHeading.setBackground(new Color(102, 255, 255));
		MovieHeading.setForeground(new Color(0, 0, 0));
		MovieHeading.setFont(new Font("Calibri", Font.BOLD, 50));
		MovieHeading.setHorizontalAlignment(SwingConstants.CENTER);
		MovieHeading.setBounds(0,0,1280,74);
		MovieOptions.add(MovieHeading);
		
		JPanel panel1 = new JPanel();
		panel1.addMouseListener(new PanelButtonMouseAdapter(panel1,s1));
		panel1.setBackground(new Color(255, 204, 51));
		panel1.setBounds(90, 110, 500, 80);
		MovieOptions.add(panel1);
		panel1.setLayout(null);
		
		JLabel l1 = new JLabel(m12);
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
		l1.setBounds(100, 20, 100, 40);
		panel1.add(l1);
		
		JLabel l2 = new JLabel(m1);
		l2.setFont(new Font("Calibri", Font.BOLD, 20));
		l2.setBounds(250, 20, 200, 40);
		panel1.add(l2);
		
		JPanel panel2 = new JPanel();
		panel2.addMouseListener(new PanelButtonMouseAdapter(panel2,s2));
		panel2.setBackground(new Color(255, 204, 51));
		panel2.setBounds(90, 200, 500, 80);
		MovieOptions.add(panel2);
		panel2.setLayout(null);
		
		JLabel l3 = new JLabel(m22);
		l3.setFont(new Font("Calibri", Font.BOLD, 20));
		l3.setBounds(100, 20, 100, 40);
		panel2.add(l3);
		
		JLabel l4 = new JLabel(m2);
		l4.setFont(new Font("Calibri", Font.BOLD, 20));
		l4.setBounds(250, 20, 200, 40);
		panel2.add(l4);
		
		JPanel panel3 = new JPanel();
		panel3.addMouseListener(new PanelButtonMouseAdapter(panel3,s3));
		panel3.setBackground(new Color(255, 204, 51));
		panel3.setBounds(90, 290, 500, 80);
		MovieOptions.add(panel3);
		panel3.setLayout(null);
		
		JLabel l5 = new JLabel(m32);
		l5.setFont(new Font("Calibri", Font.BOLD, 20));
		l5.setBounds(100, 20, 100, 40);
		panel3.add(l5);
		
		JLabel l6 = new JLabel(m3);
		l6.setFont(new Font("Calibri", Font.BOLD, 20));
		l6.setBounds(250, 20, 200, 40);
		panel3.add(l6);
		
		JPanel panel4 = new JPanel();
		panel4.addMouseListener(new PanelButtonMouseAdapter(panel4,s4));
		panel4.setBackground(new Color(255, 204, 51));
		panel4.setBounds(90, 380, 500, 80);
		MovieOptions.add(panel4);
		panel4.setLayout(null);
		
		JLabel l7 = new JLabel(m42);
		l7.setFont(new Font("Calibri", Font.BOLD, 20));
		l7.setBounds(100, 20, 100, 40);
		panel4.add(l7);
		
		JLabel l8 = new JLabel(m4);
		l8.setFont(new Font("Calibri", Font.BOLD, 20));
		l8.setBounds(250, 20, 200, 40);
		panel4.add(l8);
		
		JPanel panel5 = new JPanel();
		panel5.addMouseListener(new PanelButtonMouseAdapter(panel5,s5));
		panel5.setBackground(new Color(255, 204, 51));
		panel5.setBounds(90, 470, 500, 80);
		MovieOptions.add(panel5);
		panel5.setLayout(null);
		
		JLabel l9 = new JLabel(m52);
		l9.setFont(new Font("Calibri", Font.BOLD, 20));
		l9.setBounds(100, 20, 100, 40);
		panel5.add(l9);
		
		JLabel l10 = new JLabel(m5);
		l10.setFont(new Font("Calibri", Font.BOLD, 20));
		l10.setBounds(250, 20, 200, 40);
		panel5.add(l10);
		
		JPanel DashboardBack = new JPanel();
		DashboardBack.addMouseListener(new PanelButtonMouseAdapter(DashboardBack,33));
		DashboardBack.setBackground(new Color(255, 204, 0));
		DashboardBack.setToolTipText("");
		DashboardBack.setBounds(90, 630, 250, 50);
		MovieOptions.add(DashboardBack);
		DashboardBack.setLayout(null);
		
		JLabel DashboardBackL = new JLabel("Back To Dashboard");
		DashboardBackL.setHorizontalAlignment(SwingConstants.CENTER);
		DashboardBackL.setFont(new Font("Calibri", Font.BOLD, 20));
		DashboardBackL.setBounds(25, 5, 200, 40);
		DashboardBack.add(DashboardBackL);
		
		JPanel panel6 = new JPanel();
		panel6.addMouseListener(new PanelButtonMouseAdapter(panel6,s6));
		panel6.setLayout(null);
		panel6.setBackground(new Color(255, 204, 51));
		panel6.setBounds(690, 110, 500, 80);
		MovieOptions.add(panel6);
		
		JLabel l11 = new JLabel(m62);
		l11.setFont(new Font("Calibri", Font.BOLD, 20));
		l11.setBounds(100, 20, 100, 40);
		panel6.add(l11);
		
		JLabel l12 = new JLabel(m6);
		l12.setFont(new Font("Calibri", Font.BOLD, 20));
		l12.setBounds(250, 20, 200, 40);
		panel6.add(l12);
		
		JPanel panel7 = new JPanel();
		panel7.addMouseListener(new PanelButtonMouseAdapter(panel7,s7));
		panel7.setLayout(null);
		panel7.setBackground(new Color(255, 204, 51));
		panel7.setBounds(690, 200, 500, 80);
		MovieOptions.add(panel7);
		
		JLabel l13 = new JLabel(m72);
		l13.setFont(new Font("Calibri", Font.BOLD, 20));
		l13.setBounds(100, 20, 100, 40);
		panel7.add(l13);
		
		JLabel l14 = new JLabel(m7);
		l14.setFont(new Font("Calibri", Font.BOLD, 20));
		l14.setBounds(250, 20, 200, 40);
		panel7.add(l14);
		
		JPanel panel8 = new JPanel();
		panel8.addMouseListener(new PanelButtonMouseAdapter(panel8,s8));
		panel8.setLayout(null);
		panel8.setBackground(new Color(255, 204, 51));
		panel8.setBounds(690, 290, 500, 80);
		MovieOptions.add(panel8);
		
		JLabel l15 = new JLabel(m82);
		l15.setFont(new Font("Calibri", Font.BOLD, 20));
		l15.setBounds(100, 20, 100, 40);
		panel8.add(l15);
		
		JLabel l16 = new JLabel(m8);
		l16.setFont(new Font("Calibri", Font.BOLD, 20));
		l16.setBounds(250, 20, 200, 40);
		panel8.add(l16);
		
		JPanel panel9 = new JPanel();
		panel9.addMouseListener(new PanelButtonMouseAdapter(panel9,s9));
		panel9.setLayout(null);
		panel9.setBackground(new Color(255, 204, 51));
		panel9.setBounds(690, 380, 500, 80);
		MovieOptions.add(panel9);
		
		JLabel l17 = new JLabel(m92);
		l17.setFont(new Font("Calibri", Font.BOLD, 20));
		l17.setBounds(100, 20, 100, 40);
		panel9.add(l17);
		
		JLabel l18 = new JLabel(m9);
		l18.setFont(new Font("Calibri", Font.BOLD, 20));
		l18.setBounds(250, 20, 200, 40);
		panel9.add(l18);
		
		JPanel panel0 = new JPanel();
		panel0.addMouseListener(new PanelButtonMouseAdapter(panel0,s0));
		panel0.setLayout(null);
		panel0.setBackground(new Color(255, 204, 51));
		panel0.setBounds(690, 470, 500, 80);
		MovieOptions.add(panel0);
		
		JLabel l19 = new JLabel(m02);
		l19.setFont(new Font("Calibri", Font.BOLD, 20));
		l19.setBounds(100, 20, 100, 40);
		panel0.add(l19);
		
		JLabel l20 = new JLabel(m0);
		l20.setFont(new Font("Calibri", Font.BOLD, 20));
		l20.setBounds(250, 20, 200, 40);
		panel0.add(l20);
	}	
	
	public class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel Panel;
		int n;
		public PanelButtonMouseAdapter(JPanel panel,int n)
		{
			this.Panel=panel;
			this.n=n;
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
		
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(n==33)
			{
				setVisible(false);
				new adminDashboard(u1).setVisible(true);
			}
			else
			{
				new DetailsPop(n).setVisible(true);
			}
		}
	}
}









