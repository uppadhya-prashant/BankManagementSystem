package Admin;
import bank.*;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
public class Accounts extends JFrame implements ActionListener {
    JTable tab;
    JButton backBTN;
    JComboBox optCBO;
    //String columnName[]={"Date","Amount","Type"};
    Accounts(){

        setLayout(null);
        String op[]={"--NOT SELECTED--","ALL ACCOUNTS","ACTIVE ACCOUNTS","CLOSED ACCOUNTS","CLOSURE REQUESTS","BANNED ACCOUNTS","FREEZED ACCOUNTS"};
        optCBO=new JComboBox(op);
        optCBO.setBounds(250,20,200,30);
        optCBO.addActionListener(this);
        add(optCBO);

        tab=new JTable();
        tab.setModel(new DefaultTableModel(new Object [][] {},new String [] {"ACC_NUM", "NAME", "BALANCE","STATUS","OPEN DATE"}));
        tab.setBounds(10,80,650,300);
        JScrollPane jsp = new JScrollPane(tab);
        jsp.setBounds(10, 80, 650, 300);
        add(jsp);

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

    }


    public static void main(String[] args) {
        new Accounts();
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new admin();
        }
        else if(ae.getSource()==optCBO){
            String opt=""+optCBO.getSelectedItem();
            if(opt.equals("--NOT SELECTED--")){
                JOptionPane.showMessageDialog(null,"Please make a selection");
                this.setVisible(false);
                new admin();
            }
            else if(opt.equals("ALL ACCOUNTS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM accwithnameview";
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        String accNum=""+rs.getInt("accnum");
                        String status=rs.getString("status");
                        String name=rs.getString("name");
                        String bal=""+rs.getDouble("bal");
                        String opendate=""+rs.getDate("opendate");

                        String tbdata[]={accNum,name,bal,status,opendate};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("ACTIVE ACCOUNTS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM accwithnameview where status='active'";
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        String accNum=""+rs.getInt("accnum");
                        String status=rs.getString("status");
                        String name=rs.getString("name");
                        String bal=""+rs.getDouble("bal");
                        String opendate=""+rs.getDate("opendate");

                        String tbdata[]={accNum,name,bal,status,opendate};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("CLOSED ACCOUNTS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM accwithnameview where status='CLOSED'";
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        String accNum=""+rs.getInt("accnum");
                        String status=rs.getString("status");
                        String name=rs.getString("name");
                        String bal=""+rs.getDouble("bal");
                        String opendate=""+rs.getDate("opendate");

                        String tbdata[]={accNum,name,bal,status,opendate};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
           else if(opt.equals("CLOSURE REQUESTS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM accwithnameview where status='REQ_CLOSURE'";
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        String accNum=""+rs.getInt("accnum");
                        String status=rs.getString("status");
                        String name=rs.getString("name");
                        String bal=""+rs.getDouble("bal");
                        String opendate=""+rs.getDate("opendate");

                        String tbdata[]={accNum,name,bal,status,opendate};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("BANNED ACCOUNTS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM accwithnameview where status='BANNED'";
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        String accNum=""+rs.getInt("accnum");
                        String status=rs.getString("status");
                        String name=rs.getString("name");
                        String bal=""+rs.getDouble("bal");
                        String opendate=""+rs.getDate("opendate");

                        String tbdata[]={accNum,name,bal,status,opendate};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("FREEZED ACCOUNTS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM accwithnameview where status='FREEZED'";
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        String accNum=""+rs.getInt("accnum");
                        String status=rs.getString("status");
                        String name=rs.getString("name");
                        String bal=""+rs.getDouble("bal");
                        String opendate=""+rs.getDate("opendate");

                        String tbdata[]={accNum,name,bal,status,opendate};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
}

