package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MoreOptions extends JFrame implements ActionListener {
    int accNum;
    JButton requestLoanBTN,transferMoneyBTN,FDBTN,messagesBTN,moreOptionsBTN,backBTN;
    JTextArea customTA;
    MoreOptions(int accNum){
        this.accNum=accNum;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 580, Image.SCALE_DEFAULT);
        //reason for next line: we cannot use Image for jLabel, we need to convert it to ImageIcon first
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab1 = new JLabel(i3);
        //setLayout(null);
        lab1.setBounds(0, 0, 900, 500);
        add(lab1);
        //code for buttons
//        JLabel accnum=new JLabel("Account Number: "+accNum);
//        accnum.setFont(new Font("Raleway", Font.BOLD,18));
//        accnum.setBounds(600,20,400,30);
//        lab1.add(accnum);
        JLabel accnum=new JLabel("Account Number: "+accNum);
        accnum.setFont(new Font("Raleway", Font.BOLD,18));
        accnum.setBounds(210,140,400,30);
        accnum.setFont(new Font("Raleway",Font.BOLD,18));
        accnum.setForeground(Color.WHITE);
        lab1.add(accnum);

        //code for buttons
        requestLoanBTN=new JButton("REQUEST LOAN");
        requestLoanBTN.setBackground(Color.white);
        requestLoanBTN.setForeground(Color.black);
        requestLoanBTN.setBounds(155,200,160,30);
        requestLoanBTN.addActionListener(this);
        lab1.add(requestLoanBTN);

        transferMoneyBTN=new JButton("TRANSFER");
        transferMoneyBTN.setBackground(Color.white);
        transferMoneyBTN.setForeground(Color.black);
        transferMoneyBTN.setBounds(155,240,160,30);
        transferMoneyBTN.addActionListener(this);
        lab1.add(transferMoneyBTN);

        FDBTN=new JButton("ALL FIXED DEPOSITS");
        FDBTN.setBackground(Color.white);
        FDBTN.setForeground(Color.black);
        FDBTN.setBounds(355,280,160,30);
        FDBTN.addActionListener(this);
        lab1.add(FDBTN);

        messagesBTN=new JButton("MESSAGES");
        messagesBTN.setBackground(Color.white);
        messagesBTN.setForeground(Color.black);
        messagesBTN.setBounds(355,200,160,30);
        messagesBTN.addActionListener(this);
        lab1.add(messagesBTN);

        moreOptionsBTN=new JButton("MORE OPTIONS");
        moreOptionsBTN.setBackground(Color.white);
        moreOptionsBTN.setForeground(Color.black);
        moreOptionsBTN.setBounds(355,240,160,30);
        moreOptionsBTN.addActionListener(this);
        lab1.add(moreOptionsBTN);

        backBTN=new JButton("BACK");
        backBTN.setBackground(Color.white);
        backBTN.setForeground(Color.black);
        backBTN.setBounds(155,280,160,30);
        backBTN.addActionListener(this);
        lab1.add(backBTN);



        //code for layout
        setLocation(225,60);
        setSize(900,500);
        setLayout(null);
        setTitle("Transactions");
        setVisible(true);
//        setBackground(Color.BLACK);
//        setForeground(Color.WHITE);
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==requestLoanBTN){
            this.setVisible(false);
            new reqLoan(accNum);
        }
        else if(ae.getSource()==backBTN){
            this.setVisible(false);
            new Transactions(accNum);
        }
        else if(ae.getSource()==transferMoneyBTN){
            this.setVisible(false);
            new Transfer(accNum);
        }
        else if(ae.getSource()==FDBTN){

            this.setVisible(false);
            new FD(accNum);
        }
        else if(ae.getSource()==messagesBTN){
            this.setVisible(false);
            new Messages(accNum);

        }
        else if(ae.getSource()==moreOptionsBTN){

            this.setVisible(false);
            new MoreOptions2(accNum);

        }
    }

    public static void main(String[] args) {
        new MoreOptions(893716579);
    }
}
