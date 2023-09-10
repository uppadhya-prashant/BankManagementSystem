package Admin;

import bank.ConnectionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

import static javax.swing.JOptionPane.*;

public class AdminAccountClosure extends JFrame implements ActionListener {

    JTable tab1;
    String reqID,accNum;
    String amtS,balS;
    JButton approveBTN,rejectBTN,backBTN;
    public AdminAccountClosure(){
        setLayout(null);
        JLabel lb1=new JLabel("ACCOUNT CLOSURE REQUESTS");
        lb1.setFont(new Font("Raleway",Font.BOLD,20));
        lb1.setForeground(Color.RED);
        lb1.setBounds(170,10,400,40);
        add(lb1);

        tab1=new JTable();
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        tab1.setModel(new DefaultTableModel(new Object [][] {},new String [] {"REQ_ID","ACC_NUM" ,
                "TOTAL_BAL", "PEND_DUES", "FINAL_BAL","REQ_DATE","REASON"}));
        tab1.setBounds(0,60,650,300);
        JScrollPane jsp=new JScrollPane(tab1);
        jsp.setBounds(10,60,650,300);
        add(jsp);

        rejectBTN=new JButton("REJECT");
        rejectBTN.setForeground(Color.RED);
        rejectBTN.setBackground(Color.BLACK);
        rejectBTN.setBounds(150,400,100,30);
        rejectBTN.addActionListener(this);
        rejectBTN.setEnabled(false);
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
            sql="SELECT * FROM accclosure where status='PENDING'";

            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                String req_id=rs.getString("accclosereqid");
                String accnum=rs.getString("accnum");
                String totalbal=rs.getString("totalbal");
                String pendingdues=rs.getString("pendingdues");
                String finalamt=rs.getString("finalamt");
                String reqdate=rs.getString("reqdate");
                String reason=rs.getString("reason");
                String tbdata[]={req_id,accnum,totalbal,pendingdues,finalamt,reqdate,reason};
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
        reqID=model.getValueAt(i,0).toString();

        accNum=model.getValueAt(i,1).toString();

        balS=model.getValueAt(i,4).toString();


    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==approveBTN){
            String sql1="UPDATE signup3 set status='CLOSED' where accNum="+accNum+"";
            String sql2="UPDATE accclosure set status='APPROVED', apprdate=curdate() where accclosereqid='"+reqID+"'";
            String sql3="UPDATE balance set bal =-1 where accNum="+accNum+"";
            String sql4="UPDATE loanrequests set persstatus='PAID_ON_CLOSE' where accNum='"+accNum+"' and persstatus='UNPAID'";
            String sql5="insert into transactions values ("+accNum+","+balS+","+balS+",'ACC_CLOS_SETLMT',curdate())";
            try{
                ConnectionSQL c=new ConnectionSQL();
                c.s.executeUpdate(sql1);
                c.s.executeUpdate(sql2);
                c.s.executeUpdate(sql3);
                c.s.executeUpdate(sql4);
                c.s.executeUpdate(sql5);
                JOptionPane.showMessageDialog(null,"ACCOUNT CLOSURE REQUEST APPROVED");
                this.setVisible(false);
                new AdminAccountClosure();
            }catch(Exception e){
                System.out.println(e);
            }
        }


        else if(ae.getSource()==backBTN){

            this.setVisible(false);
            new admin();
        }
    }

    public static void main(String[] args) {
        new AdminAccountClosure();
    }
}
