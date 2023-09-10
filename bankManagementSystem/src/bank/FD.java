package bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
public class FD extends JFrame implements ActionListener {
    int accNum;
    JTable tab;
    JButton backBTN;
    JComboBox optCBO;
    //String columnName[]={"Date","Amount","Type"};
    FD(int accNum){
        this.accNum=accNum;
        setLayout(null);
        String op[]={"--NOT SELECTED--","ALL FD(s)","ACTIVE FD(s)","CLOSED FD(s)"};
        optCBO=new JComboBox(op);
        optCBO.setBounds(250,20,200,30);
        optCBO.addActionListener(this);
        add(optCBO);

        tab=new JTable();
        tab.setModel(new DefaultTableModel(new Object [][] {},new String [] {"FD_ID", "CREATION_DATE", "CLOSING_DATE","AMOUNT","FINAL_AMT","STATUS"}));
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
        new FD(893716579);
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new MoreOptions(accNum);
        }
        else if(ae.getSource()==optCBO){
            String opt=""+optCBO.getSelectedItem();
            if(opt.equals("--NOT SELECTED--")){
                JOptionPane.showMessageDialog(null,"Please make a selection");
                this.setVisible(false);
                new FD(accNum);
            }
            else if(opt.equals("ALL FD(s)")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM fd where accNum='"+accNum+"'";
                    ResultSet rs=c.s.executeQuery(query);
                    //"FD_ID", "CREATION_DATE", "CLOSING_DATE","AMOUNT","FINAL_AMT","STATUS"
                    while(rs.next()){
                        String fd_id=""+rs.getInt("fdid");
                        String amt=""+rs.getDouble("amt");
                        String final_amt=""+rs.getDouble("finalamt");
                        String create_date=""+rs.getDate("createdate");
                        String close_date=""+rs.getDate("breakdate");
                        String status=""+rs.getString("status");
                        String tbdata[]={fd_id,create_date,close_date,amt,final_amt,status};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("ACTIVE FD(s)")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM fd where accNum='"+accNum+"' and status='ACTIVE'";
                    ResultSet rs=c.s.executeQuery(query);
                    //"FD_ID", "CREATION_DATE", "CLOSING_DATE","AMOUNT","FINAL_AMT","STATUS"
                    while(rs.next()){
                        String fd_id=""+rs.getInt("fdid");
                        String amt=""+rs.getDouble("amt");
                        String final_amt=""+rs.getDouble("finalamt");
                        String create_date=""+rs.getDate("createdate");
                        String close_date=""+rs.getDate("breakdate");
                        String status=""+rs.getString("status");
                        String tbdata[]={fd_id,create_date,close_date,amt,final_amt,status};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("CLOSED FD(s)")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM fd where accNum='"+accNum+"' and status='CLOSED'";
                    ResultSet rs=c.s.executeQuery(query);
                    //"FD_ID", "CREATION_DATE", "CLOSING_DATE","AMOUNT","FINAL_AMT","STATUS"
                    while(rs.next()){
                        String fd_id=""+rs.getInt("fdid");
                        String amt=""+rs.getDouble("amt");
                        String final_amt=""+rs.getDouble("finalamt");
                        String create_date=""+rs.getDate("createdate");
                        String close_date=""+rs.getDate("breakdate");
                        String status=""+rs.getString("status");
                        String tbdata[]={fd_id,create_date,close_date,amt,final_amt,status};
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
