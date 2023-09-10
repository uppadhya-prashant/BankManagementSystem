package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Transactions extends JFrame implements ActionListener {
    int accNum;
    JButton depositBTN, withdrawBTN, statementBTN, checkBalanceBTN,logoutBTN,moreOptionsBTN;
    Transactions(int accNum){
        this.accNum=accNum;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 580, Image.SCALE_DEFAULT);
        //reason for next line: we cannot use Image for jLabel, we need to convert it to ImageIcon first
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab1 = new JLabel(i3);
        //setLayout(null);
        lab1.setBounds(0, 0, 900, 500);
        add(lab1);

        JLabel accnum=new JLabel("Account Number: "+accNum);
        accnum.setFont(new Font("Raleway", Font.BOLD,18));
        accnum.setBounds(210,140,400,30);
        accnum.setFont(new Font("Raleway",Font.BOLD,18));
        accnum.setForeground(Color.WHITE);
        lab1.add(accnum);

        //code for buttons
        depositBTN=new JButton("DEPOSIT");
        depositBTN.setBackground(Color.white);
        depositBTN.setForeground(Color.black);
        depositBTN.setBounds(155,200,160,30);
        depositBTN.addActionListener(this);
        lab1.add(depositBTN);

        checkBalanceBTN=new JButton("CHECK BALANCE");
        checkBalanceBTN.setBackground(Color.white);
        checkBalanceBTN.setForeground(Color.black);
        checkBalanceBTN.setBounds(155,240,160,30);
        checkBalanceBTN.addActionListener(this);
        lab1.add(checkBalanceBTN);

        withdrawBTN=new JButton("WITHDRAW");
        withdrawBTN.setBackground(Color.white);
        withdrawBTN.setForeground(Color.black);
        withdrawBTN.setBounds(355,280,160,30);
        withdrawBTN.addActionListener(this);
        lab1.add(withdrawBTN);

        statementBTN=new JButton("STATEMENT");
        statementBTN.setBackground(Color.white);
        statementBTN.setForeground(Color.black);
        statementBTN.setBounds(355,200,160,30);
        statementBTN.addActionListener(this);
        lab1.add(statementBTN);

        moreOptionsBTN=new JButton("MORE OPTIONS");
        moreOptionsBTN.setBackground(Color.white);
        moreOptionsBTN.setForeground(Color.black);
        moreOptionsBTN.setBounds(355,240,160,30);
        moreOptionsBTN.addActionListener(this);
        lab1.add(moreOptionsBTN);

        logoutBTN=new JButton("LOG OUT");
        logoutBTN.setBackground(Color.white);
        logoutBTN.setForeground(Color.black);
        logoutBTN.setBounds(155,280,160,30);
        logoutBTN.addActionListener(this);
        lab1.add(logoutBTN);

        //code for layout
        setLocation(225,60);
        setSize(900,500);
        setLayout(null);
        setTitle("Transactions");
        setVisible(true);

    }
    public static void main(String[] args) {
        new Transactions(893716579);
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==depositBTN){
            this.setVisible(false);
            new Deposit(accNum);
        }
        else if(ae.getSource()==checkBalanceBTN){
            ConnectionSQL c=new ConnectionSQL();
            String sql="Select bal from balance where accNum="+accNum+"";
            try{

               ResultSet rs=c.s.executeQuery(sql);
               double bal=0;
               while(rs.next())
                    bal=rs.getDouble("bal");
               rs.close();
               JOptionPane.showMessageDialog(null,"Your balance is :"+bal);
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(null,ex);
            }
            }
        else if(ae.getSource()==withdrawBTN){
            this.setVisible(false);
            new Withdraw(accNum);
        }
        else if(ae.getSource()==statementBTN){
            this.setVisible(false);
            new miniStatement(accNum);
        }
        else if(ae.getSource()==logoutBTN){
            this.setVisible(false);
            new Login();
        }
        else if(ae.getSource()==moreOptionsBTN){
            this.setVisible(false);
            new MoreOptions(accNum);
        }
        }


    }

