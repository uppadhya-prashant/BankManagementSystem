package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;

public class createFD extends JFrame implements ActionListener {
    int accNum;
    JButton exitBTN,createFDBTN;
    JTextField balTF,amtTF,durTF;
    createFD(int accNum){
        this.accNum=accNum;
        setLayout(null);
        setLocation(400,50);
        setSize(500,600);

        JLabel acc=new JLabel("ACCOUNT NUMBER: "+accNum);
        acc.setFont(new Font("Raleway",Font.BOLD,18));
        acc.setBounds(90,20,300,50);
        add(acc);

        JLabel bal=new JLabel("BALANCE");
        bal.setBounds(70,150,150,30);
        bal.setFont(new Font("Raleway",Font.BOLD,13));
        add(bal);

        balTF=new JTextField();
        balTF.setEnabled(false);
        balTF.setBounds(250,150,150,30);
        balTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(balTF);

        JLabel fdLBL=new JLabel("AMOUNT");
        fdLBL.setBounds(70,210,150,30);
        fdLBL.setFont(new Font("Raleway",Font.BOLD,13));
        add(fdLBL);

        amtTF=new JTextField();
        amtTF.setBounds(250,210,150,30);
        add(amtTF);

        JLabel dur=new JLabel("DURATION");
        dur.setBounds(70,270,150,30);
        dur.setFont(new Font("Raleway",Font.BOLD,13));
        add(dur);

        durTF=new JTextField();
        durTF.setBounds(250,270,150,30);
        add(durTF);

        exitBTN=new JButton("BACK");
        exitBTN.setBackground(Color.black);
        exitBTN.setForeground(Color.white);
        exitBTN.setBounds(75,500,150,30);
        exitBTN.addActionListener(this);
        add(exitBTN);

        createFDBTN=new JButton("CREATE FD");
        createFDBTN.setBackground(Color.black);
        createFDBTN.setForeground(Color.white);
        createFDBTN.setBounds(255,500,150,30);
        createFDBTN.addActionListener(this);
        add(createFDBTN);

        try{
            double balance=0.0;
            ConnectionSQL c=new ConnectionSQL();
            String query="SELECT * FROM balance where accNum="+accNum+"";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
                balance=rs.getDouble("bal");
            balTF.setText(""+balance);

        }catch (Exception e){
            System.out.println(e);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new createFD(123456789);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exitBTN){
            this.setVisible(false);
            new MoreOptions(accNum);
        }
        else if(ae.getSource()==createFDBTN){
            double bal=Double.parseDouble(balTF.getText());
            double amt=Double.parseDouble(amtTF.getText());
            int dur=Integer.parseInt(durTF.getText());
            if(bal<amt)
                JOptionPane.showMessageDialog(null,"Insufficent funds");
            else{
                if(amt>0 && dur>0){
                    double interest=0.08;
                    double interestAmt=amt+amt*0.08*dur;
                    int opt=JOptionPane.showConfirmDialog(null,"Interest amt: "+interestAmt+" after "+dur+" year(s)");
                    if(opt==NO_OPTION|| opt==CANCEL_OPTION){
                        JOptionPane.showMessageDialog(null,"CANCELLED");
                        this.setVisible(false);
                        new MoreOptions(accNum);
                    }
                    else{
                        try{
                            Random rn=new Random();
                            int fdID=Math.abs(rn.nextInt()%900000000);
                            bal-=amt;
                            String sql1="Insert into fd(fdid,accnum,createdate,amt,finalamt) values ('"+fdID+"','"+accNum+"',curdate(),"+amt+","+interestAmt+")";
                            String sql2="insert into transactions values ("+accNum+","+amt+","+bal+",'Withdraw(FD)',curdate())";
                            String sql3="Update balance set bal="+bal+" where accNum="+accNum+"";
                            ConnectionSQL c=new ConnectionSQL();
                            c.s.executeUpdate(sql1);
                            c.s.executeUpdate(sql2);
                            c.s.executeUpdate(sql3);
                            JOptionPane.showMessageDialog(null,"FD created with FD ID: "+fdID+"\nYou can check the list of FD(s)");
                            this.setVisible(false);
                            new MoreOptions(accNum);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }

                }
                else
                    JOptionPane.showMessageDialog(null,"Invalid data");

            }

        }
    }
}
