package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import static javax.swing.JOptionPane.*;

public class reqLoan extends JFrame implements ActionListener {
    JTextField amountTF,reasonTF,durationTF;
    JButton exitBTN,reqBTN;
    JCheckBox termsCHK;
    //JComboBox reasonCBO;
    int accNum;
    reqLoan(int accNum){
        setLayout(null);
        JLabel accnum=new JLabel("Account Number: "+accNum);
        accnum.setFont(new Font("Raleway", Font.BOLD,18));
        accnum.setBounds(100,20,400,30);
        add(accnum);
        JLabel amount=new JLabel("Amount");
        amount.setFont(new Font("Raleway", Font.BOLD,18));
        amount.setBounds(120,120,100,30);
        add(amount);


        amountTF=new JTextField();
        amountTF.setFont(new Font("Raleway", Font.BOLD,18));
        amountTF.setBounds(240,120,100,30);
        add(amountTF);

        JLabel rea=new JLabel("Reason");
        rea.setFont(new Font("Raleway", Font.BOLD,18));
        rea.setBounds(120,170,100,30);
        add(rea);

        reasonTF=new JTextField();
        reasonTF.setFont(new Font("Raleway",Font.BOLD,16));
        reasonTF.setBounds(240,170,100,30);
        add(reasonTF);

        JLabel dur=new JLabel("Duration");
        dur.setFont(new Font("Raleway", Font.BOLD,18));
        dur.setBounds(120,220,100,30);
        add(dur);

        durationTF=new JTextField();
        durationTF.setFont(new Font("Raleway",Font.BOLD,16));
        durationTF.setBounds(240,220,100,30);
        add(durationTF);

        termsCHK=new JCheckBox("I have read and agree to the Terms and Conditions");
        termsCHK.setBounds(100,300,400,30);
        add(termsCHK);

        exitBTN=new JButton("BACK");
        exitBTN.setBackground(Color.black);
        exitBTN.setForeground(Color.white);
        exitBTN.setBounds(120,370,100,30);
        exitBTN.addActionListener(this);
        add(exitBTN);

        reqBTN=new JButton("REQUEST");
        reqBTN.setBackground(Color.black);
        reqBTN.setForeground(Color.white);
        reqBTN.setBounds(240,370,100,30);
        reqBTN.addActionListener(this);
        add(reqBTN);


        this.accNum=accNum;
        setLocation(400,100);
        setTitle("LOAN REQUEST");
        setSize(500,500);
        setVisible(true);
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exitBTN){
            this.setVisible(false);
            new Transactions(accNum);
        }
        else if(ae.getSource()==reqBTN){
            if(!termsCHK.isSelected())
                JOptionPane.showMessageDialog(null,"Please agree to the terms and conditions");

            else {
                double amt = Double.parseDouble(amountTF.getText());
                double dur = Double.parseDouble(durationTF.getText());
                double rate = 0.07;
                String reason = reasonTF.getText();
                double finalamt = 0;
                finalamt = amt + amt * rate;
                int res = JOptionPane.showConfirmDialog(null, "Amount to pay after " + dur + " year(s): " + finalamt);
                if (res == NO_OPTION || res == CANCEL_OPTION) {
                    this.setVisible(false);
                    new Transactions(accNum);
                }
                else{
                int reqLoanID;
                Random rn = new Random();
                reqLoanID = (Math.abs(rn.nextInt() % 900000000));

                ConnectionSQL c = new ConnectionSQL();
                String sql = "Insert into loanrequests(reqLoanID,accNum,amt,dur,reason,finalamt,reqdate)" +
                        " values (" + reqLoanID + "," + accNum + "," + amt + "," + dur + ",'" + reason + "'," + finalamt + ",curdate())";
                try {
                    c.s.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Request Placed\nYour request ID is " + reqLoanID +
                            "\nYou should see the amount reflected in your account soon ");
                    this.setVisible(false);
                    new Transactions(accNum);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            }
        }
    }

    public static void main(String[] args) {
        new reqLoan(123456789);
    }
}
