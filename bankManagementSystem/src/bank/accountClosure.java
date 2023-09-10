package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class accountClosure extends JFrame implements ActionListener {
    int accNum;
    String recType;
    JComboBox receiverTypeCBO;
    JLabel receiverAccNum;
    JButton sendBTN,backBTN,clearBTN;
    JTextField loansTF,balTF,finalAmtTF;
    JTextArea messageTA;
    double balance=0.0,fd=0.0,total_bal=0.0,tot_due=0.0,tot_loss=0.0,final_amt=0.0;
    public accountClosure(int accNum){
        this.accNum=accNum;
        setLayout(null);
        setLocation(400,50);
        setTitle("ACCOUNT CLOSURE");

        setSize(500,600);

        JLabel accClosure=new JLabel("ACCOUNT CLOSURE");
        accClosure.setFont(new Font("Raleway", Font.BOLD,20));
        accClosure.setForeground(Color.RED);
        accClosure.setBounds(150,20,400,30);
        add(accClosure);

        String rec[]={"BANK"};
        receiverTypeCBO =new JComboBox(rec);
        receiverTypeCBO.setBounds(170,90,150,30);
        receiverTypeCBO.addActionListener(this);
        receiverTypeCBO.setEnabled(false);
        add(receiverTypeCBO);

        JLabel bal =new JLabel("BALANCE(INCLUDING FD)");
        bal.setBounds(80,150,200,30);
        add(bal);

        balTF=new JTextField();
        balTF.setBounds(270,150,150,30);
        balTF.setEnabled(false);
        add(balTF);

        JLabel loans =new JLabel("UNPAID LOANS");
        loans.setBounds(80,210,200,30);
        add(loans);

        loansTF=new JTextField();
        loansTF.setBounds(270,210,150,30);
        loansTF.setForeground(Color.red);
        loansTF.setEnabled(false);
        add(loansTF);

        JLabel finalamt=new JLabel("FINAL AMOUNT");
        finalamt.setBounds(80,270,200,30);
        add(finalamt);

        finalAmtTF=new JTextField();
        finalAmtTF.setBounds(270,270,150,30);
        finalAmtTF.setEnabled(false);
        add(finalAmtTF);

        JLabel enterMessage=new JLabel("Please tell us a reason");
        enterMessage.setFont(new Font("Raleway", Font.BOLD,15));
        enterMessage.setBounds(150,320,400,30);
        add(enterMessage);

        messageTA=new JTextArea();
        messageTA.setBounds(20,350,440,150);
        //messageTA.setEnabled(false);
        add(messageTA);

        backBTN=new JButton("BACK");
        backBTN.setBackground(Color.black);
        backBTN.setForeground(Color.white);
        backBTN.setBounds(50,530,100,30);
        backBTN.addActionListener(this);
        add(backBTN);

        clearBTN=new JButton("CLEAR");
        clearBTN.setBackground(Color.black);
        clearBTN.setForeground(Color.white);
        clearBTN.setBounds(180,530,100,30);
        clearBTN.addActionListener(this);
        add(clearBTN);

        sendBTN=new JButton("REQUEST");
        sendBTN.setBackground(Color.black);
        sendBTN.setForeground(Color.white);
        sendBTN.setBounds(310,530,100,30);
        sendBTN.addActionListener(this);
        //sendBTN.setEnabled(false);
        add(sendBTN);


        try{

            ConnectionSQL c=new ConnectionSQL();
            String query1="SELECT sum(finalamt) from loanrequests where persstatus='UNPAID' and apprstatus like '%APP%' and accNum="+accNum+"";
            String query2="SELECT bal from balance where accnum="+accNum+"";
            String query3="SELECT finalamt from fd where status='active' and accnum='"+accNum+"'";
            String sql4="UPDATE loanrequests set apprstatus='REJ_DUE_TO_CLOS',persstatus='REJ_DUE_TO_CLOS',apprdate" +
                    "=curdate() where accNum="+accNum+" and apprstatus='PENDING'";

            ResultSet rs=c.s.executeQuery(query1);
            while(rs.next())
                tot_due=rs.getDouble("sum(finalamt)");
            loansTF.setText(""+tot_due);
            rs.close();
            ResultSet rs1=c.s.executeQuery(query2);
            while(rs1.next())
                balance=rs1.getDouble("bal");
            rs1.close();
            ResultSet rs2=c.s.executeQuery(query3);
            while(rs2.next())
                fd=rs2.getDouble("finalamt");
            tot_loss=fd*0.2;
            fd=fd-tot_loss;
            total_bal=fd+balance;
            //total_bal-=tot_due;
            balTF.setText(""+total_bal);

            final_amt=total_bal-tot_due;
            finalAmtTF.setText(""+final_amt);

        }catch(Exception e){
            System.out.println(e);
        }

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new MoreOptions2(accNum);
        }
        else if(ae.getSource()==clearBTN){
            messageTA.setText("");
        }
        else if(ae.getSource()==sendBTN){

            if(final_amt<0)
                JOptionPane.showMessageDialog(null,"Please pay your dues first");

            else{
                String opt=JOptionPane.showInputDialog(null,"You will suffer a total FD amount loss of: "+tot_loss+"" +
                        "\nYou will get a total of: "+final_amt+" once we process your request\nEnter 'CONTINUE' to proceed.");
                if(opt.equals("CONTINUE")){
                    Random rn=new Random();
                    int accCloseID=Math.abs(rn.nextInt()%900000000);
                    String reason=messageTA.getText();
                    String sql1="Insert into accClosure(accCloseReqID,accNum,totalbal,pendingdues,finalamt,reqdate,reason) values ('"+accCloseID+"','"+accNum+"',"+total_bal+","+tot_due+","+final_amt+",curdate(),'"+reason+"')";
                    String sql2="Update signup3 set status='REQ_CLOSURE' where accNum="+accNum+"";
                    try{
                        ConnectionSQL c=new ConnectionSQL();
                        c.s.executeUpdate(sql1);
                        c.s.executeUpdate(sql2);
                        JOptionPane.showMessageDialog(null,"Account Closure Request placed, you will get your dues (if any)." +
                                "\nYour request id:"+accCloseID+
                                "\nThankyou for banking with us.");
                        this.setVisible(false);
                        new Login();
                    }
                    catch(SQLIntegrityConstraintViolationException s){
                        JOptionPane.showMessageDialog(null,"You already have a pending request");
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }

                }
                else{
                    JOptionPane.showMessageDialog(null,"REQUEST CANCELLED");
                    this.setVisible(false);
                    new MoreOptions2(accNum);
                }


            }
        }

    }

    public static void main(String[] args) {
        new accountClosure(893716579);
    }
}
