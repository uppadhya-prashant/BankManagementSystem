package Admin;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bank.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class loanTransactions extends JFrame implements ActionListener {
    JTable tab1;
    String loanReqIDS;
    String amtS,balS;
    JButton approveBTN,rejectBTN,backBTN;
    loanTransactions(){

        setLayout(null);
        JLabel lb1=new JLabel("LOAN TRANSACTIONS");
        lb1.setFont(new Font("Raleway",Font.BOLD,20));
        lb1.setForeground(Color.RED);
        lb1.setBounds(200,10,200,40);
        add(lb1);

        tab1=new JTable();
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        JScrollPane jsp = new JScrollPane(tab1);
        jsp.setBounds(0, 100, 680, 300);
        add(jsp);
        tab1.setModel(new DefaultTableModel(new Object [][] {},new String [] {"ACC_NUM", "AMOUNT", "BALANCE","TYPE","DATE"}));
        tab1.setBounds(0,100,680,300);
        //add(tab1);


//            rejectBTN=new JButton("REJECT");
//            rejectBTN.setForeground(Color.RED);
//            rejectBTN.setBackground(Color.BLACK);
//            rejectBTN.setBounds(150,420,100,30);
//            add(rejectBTN);

        backBTN=new JButton("BACK");
        backBTN.setForeground(Color.WHITE);
        backBTN.setBackground(Color.BLACK);
        backBTN.setBounds(275,420,100,30);
        backBTN.addActionListener(this);
        add(backBTN);

//            approveBTN=new JButton("APPROVE");
//            approveBTN.setForeground(Color.WHITE);
//            approveBTN.setBackground(Color.BLACK);
//            approveBTN.setBounds(400,420,100,30);
//            approveBTN.addActionListener(this);
//            add(approveBTN);

        setTitle("SASTRA BANK");
        setLocation(300,100);
        setSize(700,500);
        setVisible(true);

        try{
            ConnectionSQL c=new ConnectionSQL();
            String sql;
            sql="SELECT * FROM transactions";

            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                String accNum=rs.getString(1);
                String amt=rs.getString(2);
                String bal=rs.getString(3);
                String type=rs.getString(4);
                String date=rs.getString(5);
                String tbdata[]={accNum,amt,bal,type,date};
                DefaultTableModel df=(DefaultTableModel)tab1.getModel();
                df.addRow(tbdata);

            }
        }catch(Exception ex){
            System.out.println(ex);
        }
//            JScrollBar bar=new JScrollBar();
//            bar.se
//            tab1.add(bar);
    }
    private void tab1MouseClicked(MouseEvent evt) {
        int i=tab1.getSelectedRow();
        TableModel model=tab1.getModel();
        loanReqIDS=model.getValueAt(i,0).toString();

        amtS=model.getValueAt(i,4).toString();

        balS=model.getValueAt(i,5).toString();


    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new admin();
        }
    }

    public static void main(String[] args) {
        new loanTransactions();
    }
}
