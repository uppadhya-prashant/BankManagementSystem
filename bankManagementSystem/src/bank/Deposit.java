package bank;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
public class Deposit extends JFrame implements ActionListener {
    int accNum;
    JButton exitBTN,depositBTN;
    JTextField amountTF;
    Deposit(int accNum){
        this.accNum=accNum;
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

        exitBTN=new JButton("BACK");
        exitBTN.setBackground(Color.black);
        exitBTN.setForeground(Color.white);
        exitBTN.setBounds(120,170,100,30);
        exitBTN.addActionListener(this);
        add(exitBTN);

        depositBTN=new JButton("DEPOSIT");
        depositBTN.setBackground(Color.black);
        depositBTN.setForeground(Color.white);
        depositBTN.setBounds(240,170,100,30);
        depositBTN.addActionListener(this);
        add(depositBTN);
        //code for frame
        setLocation(400,200);
        setSize(500,300);
        //setUndecorated(true);
        setVisible(true);
//        setBackground(Color.BLACK);
//        setForeground(Color.WHITE);
    }
    public static void main(String[] args) {
        new Deposit(123);
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exitBTN){
            new Transactions(accNum);
            this.setVisible(false);
        }
        else if(ae.getSource()==depositBTN){
            double amt=Double.parseDouble(amountTF.getText());
            ConnectionSQL c=new ConnectionSQL();
            String sql1="Select bal from balance where accNum="+accNum+"";
            try{
                ResultSet rs=c.s.executeQuery(sql1);
                while(rs.next()){
                    double balance=rs.getDouble("bal");
                    if(amt>0){
                        ConnectionSQL c1=new ConnectionSQL();
                        balance+=amt;
                        String sql2="Update balance set bal="+balance+"where accNum="+accNum+"";
                        String sql3="insert into transactions values ("+accNum+","+amt+","+balance+",'Deposit',curdate())";
                        c1.s.executeUpdate(sql2);
                        c1.s.executeUpdate(sql3);

                        JOptionPane.showMessageDialog(null,"Amount Deposited\nNew Balance: "+balance);
                        this.setVisible(false);
                        new Transactions(accNum);
                    }
                }
            }catch(Exception ex){

                JOptionPane.showMessageDialog(null,ex);
            }
//            String sql2="Update table balance set bal=bal+'"+amt+"'where accNum='"+accNum+"'";
//            String sql3="insert into transaction values'"+accNum+"','"+amt+"','Deposit',curdate()";

        }
    }
}
