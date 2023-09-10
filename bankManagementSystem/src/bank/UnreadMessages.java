package bank;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bank.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class UnreadMessages extends JFrame implements ActionListener {
    int accNum;
    JTable tab1;
    String loanReqIDS;
    String amtS,balS;
    JButton approveBTN,rejectBTN,backBTN;
    //public String messageid;
    UnreadMessages(int accNum){
        this.accNum=accNum;

        setLayout(null);
        JLabel lb1=new JLabel("MESSAGES");
        lb1.setFont(new Font("Raleway",Font.BOLD,20));
        lb1.setForeground(Color.RED);
        lb1.setBounds(275,10,200,40);
        add(lb1);

        tab1=new JTable();
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        JScrollPane jsp = new JScrollPane(tab1);
        jsp.setBounds(10, 60, 650, 300);
        add(jsp);
        tab1.setModel(new DefaultTableModel(new Object [][] {},new String [] {"SENDER", "MESSAGE", "DATE","MESSAGE_ID"}));
        tab1.setBounds(0,60,700,300);

        backBTN=new JButton("BACK");
        backBTN.setForeground(Color.WHITE);
        backBTN.setBackground(Color.BLACK);
        backBTN.setBounds(275,420,100,30);
        backBTN.addActionListener(this);
        add(backBTN);



        setTitle("SASTRA BANK");
        setLocation(300,100);
        setSize(700,500);
        setVisible(true);

        try{
            ConnectionSQL c=new ConnectionSQL();
            String sql;
            sql="SELECT * FROM unreadmessages where reciever='"+accNum+"'";

            ResultSet rs=c.s.executeQuery(sql);
            while(rs.next()){
                String sender=rs.getString("sender");
                String message=rs.getString("message");
                String date=rs.getString("date");
                String messageid=rs.getString("messageid");
                String tbdata[]={sender,message,date,messageid};
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
        String sender=model.getValueAt(i,0).toString();
        String message=model.getValueAt(i,1).toString();
        String messid=model.getValueAt(i,3).toString();
        JOptionPane.showMessageDialog(null,"Message: "+message+"\nSender: "+sender);
        try{
            String sql="UPDATE messages set readStatus='READ' where messageid='"+messid+"'";
            ConnectionSQL c1=new ConnectionSQL();
            c1.s.executeUpdate(sql);
            this.setVisible(false);
            new UnreadMessages(accNum);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new MoreOptions(accNum);
        }
    }

    public static void main(String[] args) {
        new UnreadMessages(893716579);
    }
}
