package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Messages extends JFrame implements ActionListener {
    int accNum;
    JButton sendMessageBTN,unreadMessageBTN,readMessageBTN;
    public Messages(int accNum){

        setLayout(null);

        this.accNum=accNum;
        setTitle("--MESSAGES--");
        setLocation(450,200);
        setSize(400,300);

        sendMessageBTN=new JButton("SEND MESSAGE");
        sendMessageBTN.setBackground(Color.black);
        sendMessageBTN.setForeground(Color.white);
        sendMessageBTN.setBounds(110,30,180,50);
        sendMessageBTN.addActionListener(this);
        add(sendMessageBTN);

        readMessageBTN=new JButton("READ MESSAGES");
        readMessageBTN.setBackground(Color.black);
        readMessageBTN.setForeground(Color.white);
        readMessageBTN.setBounds(110,100,180,50);
        readMessageBTN.addActionListener(this);
        add(readMessageBTN);


        unreadMessageBTN=new JButton("UNREAD MESSAGES");
        unreadMessageBTN.setBackground(Color.black);
        unreadMessageBTN.setForeground(Color.white);
        unreadMessageBTN.setBounds(110,170,180,50);
        unreadMessageBTN.addActionListener(this);
        add(unreadMessageBTN);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==sendMessageBTN){
            this.setVisible(false);
            new SendMessage(accNum);
        }
        else if(ae.getSource()==unreadMessageBTN){
            this.setVisible(false);
            new UnreadMessages(accNum);
        }
        else if(ae.getSource()==readMessageBTN){
            this.setVisible(false);
            new ReadMessages(accNum);
        }
    }

    public static void main(String[] args) {
        new Messages(123456789);
    }
}
