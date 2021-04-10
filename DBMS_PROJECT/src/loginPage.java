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
public class loginPage extends javax.swing.JFrame {
    Connection connect=null;
   
    public loginPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(login);
        
        separator = new JSeparator();
        separator.setBackground(Color.BLACK);
        separator.setForeground(Color.BLACK);
        separator.setBounds(168, 77, 445, 13);
        getContentPane().add(separator);
        connect=databaseConnect.dbconnect();
    }

    /**
     * Creates new form loginPage
     */
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBorder(new LineBorder(new Color(0, 0, 0)));
        login = new javax.swing.JButton();
        login.setFont(new Font("Arial", Font.BOLD, 15));
        sign_up = new javax.swing.JButton();
        sign_up.setFont(new Font("Arial", Font.BOLD, 15));
        jLabel2 = new javax.swing.JLabel();
        txt_email_id = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox1.setFont(new Font("Arial", Font.PLAIN, 10));
        jLabel3 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(930, 565));
        setMinimumSize(new java.awt.Dimension(930, 565));
        setPreferredSize(new java.awt.Dimension(930, 565));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new Font("Arial", Font.BOLD, 36)); // NOI18N
        jLabel1.setText("User Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(168, 0, 360, 90);

        jPanel1.setOpaque(false);

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        sign_up.setText("Sign Up");
        sign_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_upActionPerformed(evt);
            }
        });

        jLabel2.setFont(new Font("Arial", Font.BOLD, 16)); // NOI18N
        jLabel2.setForeground(Color.BLACK);
        jLabel2.setText("Email");

        txt_email_id.setForeground(new java.awt.Color(204, 204, 204));
        txt_email_id.setText("Enter Email ID");
        txt_email_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_user_idFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_user_idFocusLost(evt);
            }
        });
        txt_email_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_user_idActionPerformed(evt);
            }
        });

        jCheckBox1.setForeground(Color.BLACK);
        jCheckBox1.setText("Show Password");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new Font("Arial", Font.BOLD, 16)); // NOI18N
        jLabel3.setForeground(Color.BLACK);
        jLabel3.setText("Password");

        jLabel4.setForeground(Color.BLACK);
        jLabel4.setText("New User?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(64, Short.MAX_VALUE)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(sign_up, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
        					.addGroup(Alignment.TRAILING, jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel1Layout.createSequentialGroup()
        							.addComponent(login, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        							.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(txt_password, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
        								.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
        									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(jLabel4)
        										.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        											.addComponent(txt_email_id)
        											.addComponent(jLabel2, Alignment.LEADING)))))
        							.addGap(53)))))
        			.addGap(10))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(36)
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txt_email_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jLabel3)
        			.addGap(14)
        			.addComponent(txt_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        			.addGap(29)
        			.addComponent(login, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        			.addComponent(jLabel4)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(sign_up, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(19))
        );
        jPanel1.setLayout(jPanel1Layout);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(168, 100, 290, 350);

        jLabel5.setIcon(null); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 950, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            txt_password.setEchoChar((char)0);
        }else
        txt_password.setEchoChar('*');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void txt_user_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_user_idActionPerformed

    }//GEN-LAST:event_txt_user_idActionPerformed

    private void txt_user_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_user_idFocusLost
        if(txt_email_id.getText().equals("")){
            txt_email_id.setForeground(new Color(204,204,204));
            txt_email_id.setText("Enter User ID");
        }
    }//GEN-LAST:event_txt_user_idFocusLost

    private void txt_user_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_user_idFocusGained
        if(txt_email_id.getText().equals("Enter User ID")){
            txt_email_id.setText(null);
            txt_email_id.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txt_user_idFocusGained

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        boolean check=false;
        if("Enter Email ID".equals(txt_email_id.getText())){
            JOptionPane.showMessageDialog(null, "Enter Valid Email ID");
        }
        else if(txt_password.getPassword().length==0){
            JOptionPane.showMessageDialog(null, "Enter Valid Password");
        }
        else{
        	int user_id = 0;
        	String pass=null;
        	int count=0;
        	String user_email = null;
            try
            {
                user_email = txt_email_id.getText();
                String query ="select * from User where Email = ?";
                PreparedStatement ps =connect.prepareStatement(query);
                ps.setString(1, user_email);
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    count++;
                    pass=rs.getString(6);
                    user_id = rs.getInt(1);
                }
                System.out.println(count);
                
                if(count>=1){
                    if(pass.equals(String.valueOf(txt_password.getPassword()))){
                        check=true;
                        
                    }
                    else
                    JOptionPane.showMessageDialog(null ,"Incorrect password!");
                }
                else{
                    JOptionPane.showMessageDialog(null ,"SORRY you need to register!");
                    check=false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null ,"Enter a valid User Id or Password!");
                System.out.println(e.getMessage());
            }

            if(check){
            	System.out.println("Login Successfull");
                this.setVisible(false);
                new home(user_id).setVisible(true);
                
            }
            else {
            	System.out.println(user_id);
            	System.out.println("Login Failed");
            }

        }

    }//GEN-LAST:event_loginActionPerformed

    private void sign_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_upActionPerformed
        this.setVisible(false);
        new mainPage().setVisible(true);
    }//GEN-LAST:event_sign_upActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton login;
    private javax.swing.JButton sign_up;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_email_id;
    private JSeparator separator;
    // End of variables declaration//GEN-END:variables
}