package Admin;
import javax.swing.*;
import bank.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane.*;
import java.sql.ResultSet;

import static javax.swing.JOptionPane.NO_OPTION;


public class admin extends JFrame implements ActionListener {
    JLabel statusLBL;
    JMenuItem loanreq,delreq,allTrans,loanTrans,signout,changePin,readMessages,unreadMessages,sendMessage;
    JMenuItem allAcc,activeAcc,closedAcc;
    JMenuItem freezeAcc,freezedAc,banAcc,bannedAcc,unbanAcc,unfreezeAcc,putMainitain,activate;
    //JButton delRequestsBTN, loanRequestsBTN, statementBTN, checkBalanceBTN,logoutBTN,requestBTN;
    JMenuBar mb;
    public admin(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 580, Image.SCALE_DEFAULT);
        //reason for next line: we cannot use Image for jLabel, we need to convert it to ImageIcon first
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lab1 = new JLabel(i3);
        //setLayout(null);
        lab1.setBounds(0, 0, 900, 500);
        add(lab1);

        statusLBL=new JLabel();
        statusLBL.setBounds(690,5,250,20);
        statusLBL.setFont(new Font("Raleway",Font.BOLD,18));
        lab1.add(statusLBL);

        mb=new JMenuBar();
        mb.setBounds(0,0,900,30);
        lab1.add(mb);

        JMenu req=new JMenu("REQUESTS");
        mb.add(req);

        loanreq=new JMenuItem ("LOAN REQUESTS");
        loanreq.addActionListener(this);
        req.add(loanreq);

        delreq=new JMenuItem ("DELETION REQUESTS");
        delreq.addActionListener(this);
        req.add(delreq);

        JMenu transactions=new JMenu("TRANSACTIONS");
        transactions.addActionListener(this);
        mb.add(transactions);

        allTrans =new JMenuItem ("ALL TRANSACTIONS");
        allTrans.addActionListener(this);
        transactions.add(allTrans);

        loanTrans=new JMenuItem ("LOAN TRANSACTIONS");
        loanTrans.addActionListener(this);
        transactions.add(loanTrans);

        JMenu messages=new JMenu("MESSAGES");
        mb.add(messages);

        unreadMessages=new JMenuItem("UNREAD MESSAGES");
        unreadMessages.addActionListener(this);
        messages.add(unreadMessages);

        readMessages=new JMenuItem("READ MESSAGES");
        readMessages.addActionListener(this);
        messages.add(readMessages);

        sendMessage=new JMenuItem("SEND MESSAGES");
        sendMessage.addActionListener(this);
        messages.add(sendMessage);

        JMenu view=new JMenu("VIEW");
        mb.add(view);

        allAcc=new JMenuItem("ACCOUNTS");
        allAcc.addActionListener(this);
        view.add(allAcc);

        JMenu action=new JMenu("ACTION");
        mb.add(action);

        freezeAcc=new JMenuItem("FREEZE ACCOUNT");
        freezeAcc.addActionListener(this);
        action.add(freezeAcc);

        unfreezeAcc=new JMenuItem("UN-FREEZE ACCOUNT");
        unfreezeAcc.addActionListener(this);
        action.add(unfreezeAcc);

        banAcc=new JMenuItem("BAN ACCOUNT");
        banAcc.addActionListener(this);
        action.add(banAcc);

        unbanAcc=new JMenuItem("UN-BAN ACCOUNT");
        unbanAcc.addActionListener(this);
        action.add(unbanAcc);

        JMenu manage=new JMenu("MANAGE");
        manage.setForeground(Color.BLUE);
        mb.add(manage);

        changePin=new JMenuItem("CHANGE PIN");
        changePin.setForeground(Color.GREEN);
        manage.add(changePin);

        activate=new JMenuItem("ACTIVATE SYSTEM AGAIN");
        activate.setForeground(Color.GREEN);
        activate.addActionListener(this);
        manage.add(activate);

        putMainitain=new JMenuItem("PUT SYSTEM IN MAINTENANCE");
        putMainitain.setForeground(Color.RED);
        putMainitain.addActionListener(this);
        manage.add(putMainitain);


        signout=new JMenuItem("SIGN OUT");
        signout.setForeground(Color.RED);
        signout.addActionListener(this);
        manage.add(signout);

        try{
            String sql="SELECT * FROM BANKSTATS";
            String status=null;
            try{
                ConnectionSQL c=new ConnectionSQL();
                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next())
                    status=rs.getString("status");
                if(status.equals("active"))
                    statusLBL.setText("SYSTEMS ACTIVE");
                else
                    statusLBL.setText("SYSTEMS INACTIVE");
            }catch(Exception e){
                System.out.println(e);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        setLocation(225,60);
        setSize(900,500);
        setLayout(null);
        setTitle("--ADMIN--");
        setVisible(true);
    }
    public static void main(String[] args) {
        new admin();
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==allTrans){
            this.setVisible(false);
            new TransactionsHistory();
        }
        else if(ae.getSource()==loanreq){
            this.setVisible(false);
            new AdminLoanReq();
        }
        else if(ae.getSource()==signout){
            this.setVisible(false);
            new Login();
        }
        else if(ae.getSource()==unreadMessages){
            this.setVisible(false);
            new adminUnreadMessages();
        }
        else if(ae.getSource()==readMessages) {
            this.setVisible(false);
            new adminReadMessages();
        }
        else if(ae.getSource()==sendMessage){
            this.setVisible(false);
            new adminSendMessage();
        }
        else if(ae.getSource()==delreq){
            this.setVisible(false);
            new AdminAccountClosure();
        }
        else if(ae.getSource()==freezeAcc){
            this.setVisible(false);
            new Freeze();
        }
        else if(ae.getSource()==putMainitain){
            int opt=JOptionPane.showConfirmDialog(null,"You are about to put the system under maintenance, are you" +
                    " sure","SYSTEM MAINTENANCE",JOptionPane.YES_NO_OPTION);
            if(opt==NO_OPTION)
                new admin();
            else{
                String sql="UPDATE bankstats set status='UNDER_MAINTAIN'";
                try{
                    ConnectionSQL c=new ConnectionSQL();
                    c.s.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null,"SYSTEM IS NOW UNDER MAINTAINENCE");
                    this.setVisible(false);
                    new admin();
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==activate){
            String sql="UPDATE bankstats set status='active'";
            try{
                ConnectionSQL c=new ConnectionSQL();
                c.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"SYSTEM IS NOW UP");
                this.setVisible(false);
                new admin();
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==allAcc){
            new Accounts();
            this.setVisible(false);
        }
    }


}