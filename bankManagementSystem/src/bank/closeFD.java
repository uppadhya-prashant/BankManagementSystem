package bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import java.util.Random;

public class closeFD extends JFrame implements ActionListener {
    int accNum;
    JTable tab;
    JButton backBTN,closeBTN;
    JComboBox optCBO;
    //String columnName[]={"Date","Amount","Type"};
    closeFD(int accNum){
        this.accNum=accNum;
        setLayout(null);

        JLabel lb=new JLabel("ACTIVE FD(s)");
        lb.setFont(new Font("Raleway",Font.BOLD,20));
        lb.setForeground(Color.RED);
        lb.setBounds(270,20,200,30);
        add(lb);

        tab=new JTable();
        tab.setModel(new DefaultTableModel(new Object [][] {},new String [] {"FD_ID", "CREATION_DATE", "CLOSING_DATE","AMOUNT","FINAL_AMT","STATUS"}));
        tab.setBounds(10,80,650,300);
        JScrollPane jsp = new JScrollPane(tab);
        jsp.setBounds(10, 80, 650, 300);
        add(jsp);

        backBTN=new JButton("BACK");
        backBTN.setForeground(Color.white);
        backBTN.setBackground(Color.black);
        backBTN.setBounds(200,430,100,30);
        backBTN.addActionListener(this);
        add(backBTN);

        closeBTN=new JButton("CLOSE");
        closeBTN.setForeground(Color.white);
        closeBTN.setBackground(Color.black);
        closeBTN.setBounds(330,430,100,30);
        closeBTN.addActionListener(this);
        add(closeBTN);

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

        //frame code
        setLocation(300,100);
        setSize(700,500);
        setVisible(true);

    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new MoreOptions(accNum);
        }
        else if(ae.getSource()==closeBTN){
            int i=tab.getSelectedRow();
            TableModel model=tab.getModel();
            String fd_id=model.getValueAt(i,0).toString();
            String final_amtS=model.getValueAt(i,4).toString();
            double final_amt=Double.parseDouble(final_amtS);
//            System.out.println(fd_id);
//            System.out.println(final_amt);
            double loss_amt=0.2*final_amt;
            double loss_final_amt=final_amt-loss_amt;

            String opt=JOptionPane.showInputDialog(null,"You will lose 20% of the FINAL AMOUNT, if you cancel this FD now\n" +
                    "You will get: "+loss_final_amt+"\nTotal loss: "+loss_amt+"\nENTER 'CONTINUE' TO PROCEED");
            if(!opt.equals("CONTINUE")){
                JOptionPane.showMessageDialog(null,"REQUEST CANCELLED");
            }
            else{
                try{
                    ConnectionSQL c =new ConnectionSQL();
                    String query="SELECT bal FROM BALANCE where accNum="+accNum+"";
                    double bal=0.0;
                    ResultSet rs=c.s.executeQuery(query);
                    while(rs.next())
                        bal=rs.getDouble("bal");
                    bal+=loss_final_amt;
                    Random rn=new Random();
                    int messageID=Math.abs(rn.nextInt()%900000000);
                    String query1="Insert into messages(reciever,sender,message,messageID) values ("+accNum+",'BANK FIX_DEP DEPT','Your FD with id: "+ fd_id+" is now CLOSED as per " +
                            "your request','"+messageID+"')";
                    String sql1="UPDATE fd SET breakdate=curdate(),finalamt="+loss_final_amt+",status='CLOSED' WHERE fdid='"+fd_id+"'";
                    String sql2="insert into transactions values ("+accNum+","+loss_final_amt+","+bal+",'DEPOSIT(FD)',curdate())";
                    String sql3="Update balance set bal="+bal+" where accNum="+accNum+"";

                    c.s.executeUpdate(sql1);
                    c.s.executeUpdate(sql2);
                    c.s.executeUpdate(sql3);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"FD CLOSED with FD ID: "+fd_id+"\nThe amount should be reflected in your" +
                            "account instantly\nPlease check your balance");
                    this.setVisible(false);
                    new MoreOptions(accNum);
                }catch(Exception e){
                    System.out.println(e);
                }
            }

        }

    }
    public static void main(String[] args) {
        new closeFD(893716579);
    }
}
