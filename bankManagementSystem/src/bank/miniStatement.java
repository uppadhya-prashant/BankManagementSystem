package bank;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
public class miniStatement extends JFrame implements ActionListener {
    int accNum;
    JTable tab;
    JButton backBTN;
    //String columnName[]={"Date","Amount","Type"};
    miniStatement(int accNum){
        this.accNum=accNum;
        setLayout(null);

        tab=new JTable();
        tab.setModel(new DefaultTableModel(new Object [][] {},new String [] {"DATE", "AMOUNT", "BALANCE","TYPE"}));
        tab.setBounds(10,10,650,400);

        JScrollPane jsp = new JScrollPane(tab);
        jsp.setBounds(10, 10, 650, 400);
        add(jsp);


        //add(tab);
        backBTN=new JButton("BACK");
        backBTN.setForeground(Color.white);
        backBTN.setBackground(Color.black);
        backBTN.setBounds(300,430,100,30);
        backBTN.addActionListener(this);
        add(backBTN);
        //frame code
        setLocation(300,100);
        setSize(700,500);
        setVisible(true);
        //tab.addColumn("Amount");

        try{

            ConnectionSQL c=new ConnectionSQL();
            String sql="SELECT * FROM transactions where accNum="+accNum+"";
            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()) {
                String accnum= String.valueOf(rs.getInt("accNum"));
                String amt= String.valueOf(rs.getDouble("amt"));
                String bal=String.valueOf(rs.getDouble("bal"));
                String type=rs.getString("type");
                String date= String.valueOf(rs.getDate("date"));
                String tbdata[]={date,amt,bal,type};

                DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                tab1.addRow(tbdata);
            }

        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        }


    public static void main(String[] args) {
        new miniStatement(893716579);
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backBTN){
            this.setVisible(false);
            new Transactions(accNum);
        }
    }
}
