package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoreOptions2 extends JFrame implements ActionListener {
    int accNum;
    JButton payBTN,activeFDBTN,accountClosureBTN,instantLoanBTN,borrowingsBTN,backBTN;
    JTextArea customTA;
    MoreOptions2(int accNum){
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
        payBTN=new JButton("PAY LOAN");
        payBTN.setBackground(Color.white);
        payBTN.setForeground(Color.black);
        payBTN.setBounds(155,200,160,30);
        payBTN.addActionListener(this);
        lab1.add(payBTN);

        activeFDBTN=new JButton("OPEN/CLOSE FD");
        activeFDBTN.setBackground(Color.white);
        activeFDBTN.setForeground(Color.black);
        activeFDBTN.setBounds(155,240,160,30);
        activeFDBTN.addActionListener(this);
        lab1.add(activeFDBTN);

        instantLoanBTN=new JButton("INSTANT LOAN");
        instantLoanBTN.setBackground(Color.white);
        instantLoanBTN.setForeground(Color.black);
        instantLoanBTN.setBounds(355,240,160,30);
        instantLoanBTN.addActionListener(this);
        lab1.add(instantLoanBTN);

        borrowingsBTN=new JButton("BORROWINGS");
        borrowingsBTN.setBackground(Color.white);
        borrowingsBTN.setForeground(Color.black);
        borrowingsBTN.setBounds(355,200,160,30);
        borrowingsBTN.addActionListener(this);
        lab1.add(borrowingsBTN);

        accountClosureBTN=new JButton("ACCOUNT CLOSURE");
        accountClosureBTN.setBackground(Color.white);
        accountClosureBTN.setForeground(Color.black);
        accountClosureBTN.setBounds(355,280,160,30);
        accountClosureBTN.addActionListener(this);
        lab1.add(accountClosureBTN);

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
        if(ae.getSource()==payBTN){
            this.setVisible(false);
            new payLoan(accNum);
        }
        else if(ae.getSource()==backBTN){
            this.setVisible(false);
            new MoreOptions(accNum);
        }
        else if(ae.getSource()==instantLoanBTN){
            this.setVisible(false);
            new instLoan(accNum);
        }
        else if(ae.getSource()==activeFDBTN){
            this.setVisible(false);
            new optCreateCloseFD(accNum);
        }
        else if(ae.getSource()==borrowingsBTN){
            this.setVisible(false);
            new Borrowings(accNum);
        }
        else if(ae.getSource()==accountClosureBTN){
            this.setVisible(false);
            new accountClosure(accNum);
        }

    }

    public static void main(String[] args) {
        new MoreOptions2(893716579);
    }
}
