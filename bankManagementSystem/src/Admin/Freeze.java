package Admin;
import bank.*;

import bank.ConnectionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;


public class Freeze extends JFrame implements ActionListener {

    JTable tab1;
    String accNum;
    Double unpAmt,fdAmt,bal,finalAmt;
    String unpAmtS;
    JButton freezeBTN,backBTN;
    public Freeze(){
        setLayout(null);
        JLabel lb1=new JLabel("FREEZE ACCOUNTS");
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

        tab1.setModel(new DefaultTableModel(new Object [][] {},new String [] {"ACC_NUM","UNPAID_DUES","NO_OF_UNPAID_LOANS"}));
        tab1.setBounds(0,60,650,300);
        JScrollPane jsp=new JScrollPane(tab1);
        jsp.setBounds(10,60,650,300);
        add(jsp);


        backBTN=new JButton("BACK");
        backBTN.setForeground(Color.WHITE);
        backBTN.setBackground(Color.BLACK);
        backBTN.setBounds(200,400,100,30);
        backBTN.addActionListener(this);
        add(backBTN);

        freezeBTN=new JButton("FREEZE");
        freezeBTN.setBackground(Color.BLACK);
        freezeBTN.setBounds(325,400,100,30);
        freezeBTN.addActionListener(this);
        freezeBTN.setForeground(Color.RED);
        add(freezeBTN);

        setTitle("SASTRA BANK");
        setLocation(300,100);
        setSize(700,500);
        setVisible(true);

        try{
            ConnectionSQL c=new ConnectionSQL();
            String sql;
            sql="SELECT * FROM activeaccunpaidloandues";

            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                String accNum=rs.getString("accnum");
                String tot_unp_loan=""+rs.getDouble("totalunpaidloan");
                String no_of_unpaid_loans=rs.getString("noofunpaidloans");
                String tbdata[]={accNum,tot_unp_loan,no_of_unpaid_loans};
                DefaultTableModel model=(DefaultTableModel)tab1.getModel();
                model.addRow(tbdata);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    private void tab1MouseClicked(MouseEvent evt) {
        int i=tab1.getSelectedRow();
        TableModel model=tab1.getModel();
        accNum=model.getValueAt(i,0).toString();
        unpAmtS=model.getValueAt(i,1).toString();
        try{
            String query="SELECT * FROM totalamtinfd where accnum='"+accNum+"'";
            ConnectionSQL c=new ConnectionSQL();
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                fdAmt=rs.getDouble("finalamt");
                bal=rs.getDouble("bal");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        unpAmt=Double.parseDouble(unpAmtS);
        finalAmt=bal+fdAmt-unpAmt;
        JOptionPane.showMessageDialog(null,"Accnum: "+accNum+"\nBalance: "+bal+"\nFD: "+fdAmt
        +"\nUnpaid dues: "+unpAmt+"\nFinal Amount: "+finalAmt);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new admin();
        } else if (ae.getSource()==freezeBTN) {
            int opt=JOptionPane.showConfirmDialog(null,"Are you sure? ","CONFIRMATION",JOptionPane.YES_NO_OPTION);
            if(opt==NO_OPTION)
                JOptionPane.showMessageDialog(null,"OPERATION CANCELLED");
            else{
                String reason=JOptionPane.showInputDialog(null,"Enter a reason: ");

                String sql1="Update signup3 set status='FREEZED' where accNum="+accNum+"";
                String sql2="Insert into freeze(accnum,freezedate,reason) values ('"+accNum+"',curdate(),'"+reason+"')";
                try{
                    ConnectionSQL c=new ConnectionSQL();
                    c.s.executeUpdate(sql1);
                    c.s.executeUpdate(sql2);
                    JOptionPane.showMessageDialog(null,"ACCOUNT FREEZED");
                    this.setVisible(false);
                    new Freeze();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
            String sql="Update signup3 set status='FREEZED' where accNum="+accNum+"";
            try{
                ConnectionSQL c=new ConnectionSQL();
                c.s.executeUpdate(sql);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new Freeze();
    }
}
