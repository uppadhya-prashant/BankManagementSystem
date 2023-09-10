package Admin;
import bank.*;

import bank.ConnectionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.*;
import java.util.Random;

import static javax.swing.JOptionPane.*;

public class AdminLoanReq extends JFrame implements ActionListener {

    JTable tab1;
    String loanReqIDS;
    String amtS,balS;
    JButton approveBTN,rejectBTN,backBTN;
    public AdminLoanReq(){
        setLayout(null);
        JLabel lb1=new JLabel("LOAN REQUESTS");
        lb1.setFont(new Font("Raleway",Font.BOLD,20));
        lb1.setForeground(Color.RED);
        lb1.setBounds(250,10,200,40);
        add(lb1);

        tab1=new JTable();
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        tab1.setModel(new DefaultTableModel(new Object [][] {},new String [] {"Request ID" +
                "", "Duration", "Reason","Request_Date","Amount","Curr_Bal"}));
        tab1.setBounds(0,60,650,300);
        JScrollPane jsp=new JScrollPane(tab1);
        jsp.setBounds(10,60,650,300);
        add(jsp);

        rejectBTN=new JButton("REJECT");
        rejectBTN.setForeground(Color.RED);
        rejectBTN.setBackground(Color.BLACK);
        rejectBTN.setBounds(150,400,100,30);
        rejectBTN.addActionListener(this);
        add(rejectBTN);

        backBTN=new JButton("BACK");
        backBTN.setForeground(Color.WHITE);
        backBTN.setBackground(Color.BLACK);
        backBTN.setBounds(275,400,100,30);
        backBTN.addActionListener(this);
        add(backBTN);

        approveBTN=new JButton("APPROVE");
        approveBTN.setForeground(Color.WHITE);
        approveBTN.setBackground(Color.BLACK);
        approveBTN.setBounds(400,400,100,30);
        approveBTN.addActionListener(this);
        add(approveBTN);

        setTitle("SASTRA BANK");
        setLocation(300,100);
        setSize(700,500);
        setVisible(true);

        try{
            ConnectionSQL c=new ConnectionSQL();
            String sql;
            sql="SELECT * FROM loanBalRelation";

            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                String reqLoanID=rs.getString(1);
                String dur=rs.getString(2);
                String reason=rs.getString(3);
                String reqdate=rs.getString(4);
                String amt=rs.getString(5);
                String bal=rs.getString(6);
                String tbdata[]={reqLoanID,dur,reason,reqdate,amt,bal};
                DefaultTableModel df=(DefaultTableModel)tab1.getModel();
                df.addRow(tbdata);

            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    private void tab1MouseClicked(MouseEvent evt) {
        int i=tab1.getSelectedRow();
        TableModel model=tab1.getModel();
        loanReqIDS=model.getValueAt(i,0).toString();
        //loanReqID=Integer.parseInt(loanReqIDS);
        //JOptionPane.showMessageDialog(null,""+loanReqID);
        amtS=model.getValueAt(i,4).toString();
        //amt=Integer.parseInt(amtS);
        //JOptionPane.showMessageDialog(null,""+amt);
        balS=model.getValueAt(i,5).toString();
        //bal=Integer.parseInt(balS);
        //JOptionPane.showMessageDialog(null,""+amt);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==approveBTN){
            //bal+=amt;
            int acc=0;
            //JOptionPane.showMessageDialog(null,"id: "+loanReqIDS+"\namt: "+amtS+"\nbal: "+balS);
            int loanID=Integer.parseInt(loanReqIDS);
            double amt=Double.parseDouble(amtS);
            double bal=Double.parseDouble(balS);
            //JOptionPane.showMessageDialog(null,"id: "+loanID+"\namt: "+amt+"\nbal: "+bal);
            try{
                String sql="select accnum from loanrequests where reqloanid="+loanID+"";

                ConnectionSQL c=new ConnectionSQL();
                ResultSet rs= c.s.executeQuery(sql);

                if(rs.next())
                    acc=rs.getInt("accnum");
                rs.close();
                bal+=amt;
                Random rn=new Random();
                int messageID=Math.abs(rn.nextInt()%900000000);
                String query1="Insert into messages(reciever,sender,message,messageID) values ("+acc+",'BANK LOAN DEPT','Your Loan Request with id: "+ loanID+" is APPROVED','"+messageID+"')";
                String sql1="update balance set bal=bal+"+amt+"where accnum="+acc+"";
                String sql2="insert into transactions values ("+acc+","+amt+","+bal+",'DEPOSIT(LOAN)',curdate())";
                String sql3="update loanrequests set apprStatus='APPROVED', apprdate=curdate() where reqLoanID="+loanID+"";


                c.s.executeUpdate(sql1);
                c.s.executeUpdate(sql2);
                c.s.executeUpdate(sql3);
                c.s.executeUpdate(query1);

                //JOptionPane.showMessageDialog(null,"amt:"+amt+"\nbal:"+bal+"\nacc:"+acc);
                JOptionPane.showMessageDialog(null,"REQUEST APPROVED");
                this.setVisible(false);
                new AdminLoanReq();
            }catch (Exception ex){
                System.out.println(ex);
            }


        }
        else if(ae.getSource()==rejectBTN){
            int loanID=Integer.parseInt(loanReqIDS);
            int acc=0;

            int res=JOptionPane.showConfirmDialog(null,"You are about to reject the request with req id:"+loanID );
            if(res==YES_OPTION){
                String reason=JOptionPane.showInputDialog(null,"Please enter the reason for rejection");

                try{
                        ConnectionSQL c=new ConnectionSQL();
                        String sql = "select accnum from loanrequests where reqloanid=" + loanID + "";

                        ResultSet rs = c.s.executeQuery(sql);

                        if (rs.next())
                        acc = rs.getInt("accnum");
                        rs.close();
                        //System.out.println(""+acc);
                        Random rn=new Random();
                        int messageID=Math.abs(rn.nextInt()%900000000);
                        String query1="Insert into messages(reciever,sender,message,messageID) values ("+acc+",'BANK LOAN DEPT','Your Loan Request with id: "+ loanID+" REJECTED due to "+reason+"','"+messageID+"')";
                        String query2="UPDATE loanrequests set apprstatus='REJECTED', apprdate=curdate() where reqloanid="+loanID+"";
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null,"REJECTED");
                        this.setVisible(false);
                        new AdminLoanReq();
                    }  catch (Exception ex){
                    System.out.println(ex);
                        }
            }

            }
        else if(ae.getSource()==backBTN){

            this.setVisible(false);
            new admin();
        }
    }

    public static void main(String[] args) {
        new AdminLoanReq();
    }
}
