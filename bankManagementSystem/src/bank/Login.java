package bank;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import Admin.*;

import static javax.swing.JOptionPane.YES_OPTION;

public class Login  extends JFrame implements ActionListener {

    JButton signin, clearBTN, newAccBTN;
    JTextField accNumTF;
    JPasswordField pinPF;

    public Login() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        //reason for next line: we cannot use Image for jLabel, we need to convert it to ImageIcon first
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab1 = new JLabel(i3);
        setLayout(null);
        lab1.setBounds(20, 20, 70, 70);
        add(lab1);

        //label2
        JLabel lab2 = new JLabel("WELCOME TO SASTRA BANK");
        add(lab2);
        lab2.setBounds(100, 20, 200, 80);

        //label for card_no
        JLabel cardNo = new JLabel("CARD NUMBER: ");
        add(cardNo);
        cardNo.setBounds(200, 150, 100, 40);

        //TextField for card_no
        accNumTF = new JTextField();
        add(accNumTF);
        accNumTF.setBounds(320, 150, 200, 40);

        //label for pin
        JLabel Pin = new JLabel("PIN: ");
        add(Pin);
        Pin.setBounds(200, 200, 100, 40);

        //Text_field for pin
        pinPF = new JPasswordField();
        pinPF.setBounds(320, 200, 200, 40);
        add(pinPF);

        //Button for login

        signin = new JButton("LOGIN");
        signin.setBounds(250, 250, 100, 50);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

        //Button for clear

        clearBTN = new JButton("CLEAR");
        clearBTN.setBounds(375, 250, 100, 50);
        clearBTN.setBackground(Color.black);
        clearBTN.setForeground(Color.white);
        clearBTN.addActionListener(this);
        add(clearBTN);

        //ButtonForNewAccount

        newAccBTN = new JButton("CREATE ACCOUNT");
        newAccBTN.setBounds(250, 325, 225, 50);
        newAccBTN.setBackground(Color.black);
        newAccBTN.setForeground(Color.white);
        newAccBTN.addActionListener(this);
        add(newAccBTN);

        //code for JFrame
        //makes the frame open from centre
        setLocation(250, 130);
        setSize(800, 480);
        setTitle("LOGIN");
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == signin) {


            int accNum = Integer.parseInt(accNumTF.getText());
            int pin = Integer.parseInt(pinPF.getText());
            if (accNum == 1234 && pin == 5678) {
                int user_id=Integer.parseInt(JOptionPane.showInputDialog("Enter user id"));
                String pass=JOptionPane.showInputDialog("Enter password");
                ConnectionSQL c=new ConnectionSQL();
                String sql="SELECT * FROM admin where user_id='"+user_id+"' and pass='"+pass+"'";
                try{

                    ResultSet rs=c.s.executeQuery(sql);
                    if(rs.next()){
                        String key=JOptionPane.showInputDialog("Enter admin key: ");
                        if(key.equals("bank123")){
                            this.setVisible(false);
                            JOptionPane.showMessageDialog(null,"Admin Login successful");
                            new admin();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Invalid admin key");
                        }
                    }
                }
                catch(Exception ex1) {
                    System.out.println(ex1);
                }
            } else {
                String status=null;
                try {
                    ConnectionSQL c = new ConnectionSQL();
                    String stats=null;
                    String check="select * from bankstats";
                    ResultSet rs1=c.s.executeQuery(check);
                    while(rs1.next())
                        stats=rs1.getString("status");
                    if(stats.equals("UNDER_MAINTAIN")){
                        JOptionPane.showMessageDialog(null,"Our severs are under maintenance, please try " +
                                "after some time");
                    }
                    else{
                        String query = "Select * from signup3 where accNum='"+accNum+"'and pin="+pin +"";
                        ResultSet rs = c.s.executeQuery(query);
                        if (rs.next()) {
                            this.setVisible(false);
                            status=rs.getString("status");
                            if(status.equals("ACTIVE")){
                                new Transactions(accNum).setVisible(true);
                            }
                                else if(status.equals("REQ_CLOSURE")){
                                int opt=JOptionPane.showConfirmDialog(null,"You have placed an account closure request," +
                                        "\nWould you like to cancel the request","SASTRA BANK",JOptionPane.YES_NO_OPTION);
                                if(opt==YES_OPTION){
                                    String opt1=JOptionPane.showInputDialog(null,"Please enter" +
                                            " 'CANCEL REQUEST' to cancel your account closure request");
                                    if(!opt1.equals("CANCEL REQUEST"))
                                        new Login();
                                    else{
                                        try{
                                            String sql1="UPDATE accClosure set status='USER_CANCL_REQ' , apprdate=curdate() where accNum='"+accNum+"'";
                                            String sql2="UPDATE signup3 set status='ACTIVE' where accnum="+accNum+"";
                                            c.s.executeUpdate(sql1);
                                            c.s.executeUpdate(sql2);
                                            JOptionPane.showMessageDialog(null,"Your account is activated");
                                            new Login();

                                        }catch(Exception e){
                                            System.out.println(e);
                                        }
                                    }
                                }
                                else{
                                    new Login();
                                }
                            }
                            else if(status.equals("FREEZED")){
                                JOptionPane.showMessageDialog(null,"Your account was freezed by admin " +
                                        "due to suspicious activites. Please wait while we take a look at your transactions.");
                                new Login();
                            }
                            else if(status.equals("CLOSED")){
                                JOptionPane.showMessageDialog(null,"Your account is already closed");
                                new Login();
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid User id or password");
                        }
                    }

                }

                catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == clearBTN) {

            accNumTF.setText("");
            pinPF.setText("");
        } else if (ae.getSource() == newAccBTN) {

            setVisible(false);
            new Signupone().setVisible(true);
        }
            }

        public static void main (String[] args){
            new Login();
        }

}
