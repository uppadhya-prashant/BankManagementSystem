package Admin;
import bank.ConnectionSQL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class adminSendMessage extends JFrame implements ActionListener {
    //int accNum;
    String recType;
    JComboBox receiverTypeCBO;
    JLabel receiverAccNum;
    JButton sendBTN,backBTN,clearBTN;
    JTextField receiverAccNumTF;
    JTextArea messageTA;
    public adminSendMessage(){
        //this.accNum=accNum;
        setLayout(null);
        setLocation(400,100);
        setTitle("SEND MESSAGE");
        setSize(500,550);

        JLabel recieverType=new JLabel("RECEIVER");
        recieverType.setFont(new Font("Raleway", Font.BOLD,20));
        recieverType.setBounds(190,20,400,30);
        add(recieverType);

        String rec[]={"--NOT SELECTED--","PERSON","BANK"};
        receiverTypeCBO =new JComboBox(rec);
        receiverTypeCBO.setBounds(170,90,150,30);
        receiverTypeCBO.addActionListener(this);
        add(receiverTypeCBO);

        receiverAccNum =new JLabel("RECEIVER ACCOUNT NUMBER");
        receiverAccNum.setBounds(50,150,200,30);
        add(receiverAccNum);

        receiverAccNumTF=new JTextField("Please select the receiver");
        receiverAccNumTF.setBounds(300,150,150,30);
        receiverAccNumTF.setEnabled(false);
        add(receiverAccNumTF);

        JLabel enterMessage=new JLabel("MESSAGE");
        enterMessage.setFont(new Font("Raleway", Font.BOLD,20));
        enterMessage.setBounds(190,210,400,30);
        add(enterMessage);

        messageTA=new JTextArea();
        messageTA.setBounds(20,240,440,150);
        messageTA.setEnabled(false);
        messageTA.setText("PLEASE SELECT THE TYPE OF THE RECEIVER");
        add(messageTA);

        backBTN=new JButton("BACK");
        backBTN.setBackground(Color.black);
        backBTN.setForeground(Color.white);
        backBTN.setBounds(50,420,100,30);
        backBTN.addActionListener(this);
        add(backBTN);

        clearBTN=new JButton("CLEAR");
        clearBTN.setBackground(Color.black);
        clearBTN.setForeground(Color.white);
        clearBTN.setBounds(180,420,100,30);
        clearBTN.addActionListener(this);
        add(clearBTN);

        sendBTN=new JButton("SEND");
        sendBTN.setBackground(Color.black);
        sendBTN.setForeground(Color.white);
        sendBTN.setBounds(310,420,100,30);
        sendBTN.addActionListener(this);
        sendBTN.setEnabled(false);
        add(sendBTN);


//        JLabel recieverType=new JLabel("RECEIVER");
//        recieverType.setFont(new Font("Raleway", Font.BOLD,18));
//        recieverType.setBounds(120,120,100,30);
//        add(recieverType);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==receiverTypeCBO){
            recType=""+receiverTypeCBO.getSelectedItem();
            //System.out.println(recType);
            if(recType.equals("PERSON")){
                receiverAccNumTF.setText("");
                receiverAccNumTF.setEnabled(true);
                messageTA.setText("");
                sendBTN.setEnabled(true);
                messageTA.setEnabled(true);
            }
            else if(recType.equals("BANK")){
                receiverAccNumTF.setText("--NOT REQUIRED--");
                receiverAccNumTF.setEnabled(false);
                messageTA.setText("");
                sendBTN.setEnabled(true);
                messageTA.setEnabled(true);
            }
            else if(recType.equals("--NOT SELECTED--")){
                receiverAccNumTF.setText("Please select the receiver");
                messageTA.setEnabled(false);
                messageTA.setText("PLEASE SELECT THE TYPE OF THE RECEIVER");
                sendBTN.setEnabled(false);
                receiverAccNumTF.setEnabled(false);
            }
        }
        else if(ae.getSource()==backBTN){
            this.setVisible(false);
            new admin();
        }
        else if(ae.getSource()==clearBTN){
            messageTA.setText("");
        }
        else if(ae.getSource()==sendBTN){

            String recType=""+receiverTypeCBO.getSelectedItem();
            String rec=null,message=null;
            message=messageTA.getText();
            if(recType.equals("BANK")) {

                rec="BANK";
            }else if(recType.equals("PERSON")){
                rec=receiverAccNumTF.getText();
            }
            //System.out.println(recType);
            try{
                Random rn=new Random();
                int messageID=Math.abs(rn.nextInt()%900000000);
                String sql="Insert into messages(reciever,sender,message,messageid) values('"+rec+"','ADMIN','"+message+"','"+messageID+"')";
                ConnectionSQL c=new ConnectionSQL();
                c.s.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Message sent");
            }catch(Exception e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new adminSendMessage();
    }
}
