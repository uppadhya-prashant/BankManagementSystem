package bank;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
public class Borrowings extends JFrame implements ActionListener {
    int accNum;
    JTable tab;
    JButton backBTN;
    JComboBox optCBO;
    //String columnName[]={"Date","Amount","Type"};
    Borrowings(int accNum){
        this.accNum=accNum;
        setLayout(null);
        String op[]={"--NOT SELECTED--","ALL LOANS","PENDING LOANS","APPROVED LOANS","REJECTED LOANS","INSTANT LOANS"};
        optCBO=new JComboBox(op);
        optCBO.setBounds(250,20,200,30);
        optCBO.addActionListener(this);
        add(optCBO);

        tab=new JTable();
        tab.setModel(new DefaultTableModel(new Object [][] {},new String [] {"LOAN_ID", "AMOUNT", "DURATION","FINAL_AMT","REQ_DATE","APPR_DATE","TYPE"}));
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
        new Borrowings(893716579);
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new MoreOptions2(accNum);
        }
        else if(ae.getSource()==optCBO){
            String opt=""+optCBO.getSelectedItem();
            if(opt.equals("--NOT SELECTED--")){
                JOptionPane.showMessageDialog(null,"Please make a selection");
                this.setVisible(false);
                new Borrowings(accNum);
            }
            else if(opt.equals("ALL LOANS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{

                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM LOANREQUESTS where accNum="+accNum+"";
                    ResultSet rs=c.s.executeQuery(query);
                    //{"LOAN_ID", "AMOUNT", "DURATION","FINAL_AMT","REQ_DATE","APPR_DATE","TYPE"}
                    while(rs.next()){
                        String loan_id=""+rs.getInt("reqloanid");
                        String amt=""+rs.getDouble("amt");
                        String dur=""+rs.getInt("dur");
                        String final_amt=""+rs.getDouble("finalamt");
                        String req_date=""+rs.getDate("reqdate");
                        String appr_date=""+rs.getDate("apprdate");
                        String type=""+rs.getString("type");
                        String tbdata[]={loan_id,amt,dur,final_amt,req_date,appr_date,type};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("PENDING LOANS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{
                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM LOANREQUESTS where accNum="+accNum+" AND apprstatus='PENDING'";
                    ResultSet rs=c.s.executeQuery(query);
                    //{"LOAN_ID", "AMOUNT", "DURATION","FINAL_AMT","REQ_DATE","APPR_DATE","TYPE"}
                    while(rs.next()){
                        String loan_id=""+rs.getInt("reqloanid");
                        String amt=""+rs.getDouble("amt");
                        String dur=""+rs.getInt("dur");
                        String final_amt=""+rs.getDouble("finalamt");
                        String req_date=""+rs.getDate("reqdate");
                        String appr_date=""+rs.getDate("apprdate");
                        String type=""+rs.getString("type");
                        String tbdata[]={loan_id,amt,dur,final_amt,req_date,appr_date,type};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("APPROVED LOANS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{
                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM LOANREQUESTS where accNum="+accNum+" AND apprstatus IN('APPROVED','INST_APPROVED')";
                    ResultSet rs=c.s.executeQuery(query);
                    //{"LOAN_ID", "AMOUNT", "DURATION","FINAL_AMT","REQ_DATE","APPR_DATE","TYPE"}
                    while(rs.next()){
                        String loan_id=""+rs.getInt("reqloanid");
                        String amt=""+rs.getDouble("amt");
                        String dur=""+rs.getInt("dur");
                        String final_amt=""+rs.getDouble("finalamt");
                        String req_date=""+rs.getDate("reqdate");
                        String appr_date=""+rs.getDate("apprdate");
                        String type=""+rs.getString("type");
                        String tbdata[]={loan_id,amt,dur,final_amt,req_date,appr_date,type};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("REJECTED LOANS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{
                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM LOANREQUESTS where accNum="+accNum+" AND apprstatus='REJECTED'";
                    ResultSet rs=c.s.executeQuery(query);
                    //{"LOAN_ID", "AMOUNT", "DURATION","FINAL_AMT","REQ_DATE","APPR_DATE","TYPE"}
                    while(rs.next()){
                        String loan_id=""+rs.getInt("reqloanid");
                        String amt=""+rs.getDouble("amt");
                        String dur=""+rs.getInt("dur");
                        String final_amt=""+rs.getDouble("finalamt");
                        String req_date=""+rs.getDate("reqdate");
                        String appr_date=""+rs.getDate("apprdate");
                        String type=""+rs.getString("type");
                        String tbdata[]={loan_id,amt,dur,final_amt,req_date,appr_date,type};
                        DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                        tab1.addRow(tbdata);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(opt.equals("INSTANT LOANS")){
                DefaultTableModel model=(DefaultTableModel)tab.getModel();
                model.setRowCount(0);
                try{
                    ConnectionSQL c=new ConnectionSQL();
                    String query="SELECT * FROM LOANREQUESTS where accNum="+accNum+" AND type='INST_LOAN'";
                    ResultSet rs=c.s.executeQuery(query);
                    //{"LOAN_ID", "AMOUNT", "DURATION","FINAL_AMT","REQ_DATE","APPR_DATE","TYPE"}
                    while(rs.next()){
                        String loan_id=""+rs.getInt("reqloanid");
                        String amt=""+rs.getDouble("amt");
                        String dur=""+rs.getInt("dur");
                        String final_amt=""+rs.getDouble("finalamt");
                        String req_date=""+rs.getDate("reqdate");
                        String appr_date=""+rs.getDate("apprdate");
                        String type=""+rs.getString("type");
                        String tbdata[]={loan_id,amt,dur,final_amt,req_date,appr_date,type};
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
