package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class Transfer extends JFrame implements ActionListener {
    int accNum;
    JTextField nameTF,accnumTF,confaccnumTF,amtTF;
    JButton transferBTN,exitBTN;
    Transfer(int accNum){
        setLayout(null);
        //setLocation();
        this.accNum=accNum;
        JLabel accnum=new JLabel("Account Number: "+accNum);
        accnum.setFont(new Font("Raleway", Font.BOLD,18));
        accnum.setBounds(100,20,400,30);
        add(accnum);
        JLabel lb1=new JLabel("DETAILS OF BENIFICIARY");
        lb1.setFont(new Font("Raleway", Font.BOLD,14));
        lb1.setBounds(130,70,200,30);
        add(lb1);

        JLabel lb2=new JLabel("Name");
        lb2.setBounds(50,110,100,30);
        add(lb2);

        nameTF=new JTextField();
        nameTF.setFont(new Font("Raleway", Font.BOLD,16));
        nameTF.setBounds(210,110,200,30);
        add(nameTF);

        JLabel lb3=new JLabel("Account Number");
        lb3.setBounds(50,160,100,30);
        add(lb3);

        accnumTF=new JTextField();
        accnumTF.setFont(new Font("Raleway", Font.BOLD,16));
        accnumTF.setBounds(210,160,200,30);
        add(accnumTF);

        JLabel lb4=new JLabel("Confirm Account Number");
        lb4.setBounds(50,210,170,30);
        add(lb4);

        confaccnumTF=new JTextField();
        confaccnumTF.setFont(new Font("Raleway", Font.BOLD,16));
        confaccnumTF.setBounds(210,210,200,30);
        add(confaccnumTF);

        JLabel lb5=new JLabel("Amount");
        lb5.setBounds(50,260,170,30);
        add(lb5);

        amtTF=new JTextField();
        amtTF.setFont(new Font("Raleway", Font.BOLD,16));
        amtTF.setBounds(210,260,200,30);
        add(amtTF);

        exitBTN=new JButton("BACK");
        exitBTN.setBackground(Color.black);
        exitBTN.setForeground(Color.white);
        exitBTN.setBounds(120,370,100,30);
        exitBTN.addActionListener(this);
        add(exitBTN);

        transferBTN=new JButton("TRANSFER");
        transferBTN.setBackground(Color.black);
        transferBTN.setForeground(Color.white);
        transferBTN.setBounds(240,370,100,30);
        transferBTN.addActionListener(this);
        add(transferBTN);

        setLocation(400,100);
        setTitle("TRANSFERS");
        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==exitBTN){
            this.setVisible(false);
            new Transactions(accNum);
        }
        else if(ae.getSource()==transferBTN){
            double amt=Double.parseDouble(amtTF.getText());
            if(amt<=0.0)
                JOptionPane.showMessageDialog(null,"Invalid amount");
            else{
                double bal=0.0;
                ConnectionSQL c=new ConnectionSQL();
                String sql1="select bal from balance where accnum="+accNum+"";
                try{
                    ResultSet rs=c.s.executeQuery(sql1);
                    if(rs.next())
                        bal=rs.getDouble("bal");
                    rs.close();
                    if(bal<amt)
                        JOptionPane.showMessageDialog(null,"Insufficent funds");

                    else{

                        String benName=nameTF.getText();
                        String benNameSQL=null;
                        int benAccSQL=0;
                        int benAcc=Integer.parseInt(accnumTF.getText());
                        String sql2="select * from nameaccnumlinkview where name ='"+benName+"'AND accnum="+benAcc+"";
                        ResultSet rs1=c.s.executeQuery(sql2);
                        if(rs1.next()){
                            benNameSQL=rs1.getString(1);
                            benAccSQL=rs1.getInt(2);
                            rs1.close();
                            if(benAccSQL==0 || benNameSQL==null)
                                JOptionPane.showMessageDialog(null,"Invalid benificiary account id or name");
                            else{
                                double benBal=0.0;
                                String query="select bal from accnumbalancelinkview where name ='"+benName+"'AND accnum="+benAcc+"";
                                ResultSet rs2=c.s.executeQuery(query);
                                if(rs2.next())
                                    benBal=rs2.getDouble("bal");
                                rs2.close();
                                Random rn=new Random();
                                int trasactionID=Math.abs(rn.nextInt()%900000000);
                                String sql3="Update balance set bal=bal-"+amt+"where accnum="+accNum+"";
                                String sql4="Update balance set bal=bal+"+amt+"where accnum="+benAccSQL+"";
                                bal-=amt;
                                benBal+=amt;
                                String sql5="insert into transactions values ("+accNum+","+amt+","+bal+",'Withdraw(TRAN)',curdate())";
                                String sql6="insert into transactions values ("+benAccSQL+","+amt+","+benBal+",'Deposit(TRAN)',curdate())";
                                String sql7="insert into transfers values ("+trasactionID+","+accNum+","+benAccSQL+","+amt+",curdate())";
                                c.s.executeUpdate(sql3);
                                c.s.executeUpdate(sql4);
                                c.s.executeUpdate(sql5);
                                c.s.executeUpdate(sql6);
                                c.s.executeUpdate(sql7);
                                JOptionPane.showMessageDialog(null,"Transaction completed"+"" +
                                        "\nTransaction ID:"+trasactionID);
                                this.setVisible(false);
                                new Transactions(accNum);
                            }
                        }
                    }
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Transfer(123456789);
    }
}
