package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class optCreateCloseFD extends JFrame implements ActionListener {
    int accNum;
    JButton createFDBTN,closeFDBTN;
    public optCreateCloseFD(int accNum){

        setLayout(null);

        this.accNum=accNum;
        setTitle("--CREATE/CLOSE FD--");
        setLocation(450,200);
        setSize(400,300);

        createFDBTN=new JButton("CREATE FD");
        createFDBTN.setBackground(Color.black);
        createFDBTN.setForeground(Color.white);
        createFDBTN.setBounds(110,50,180,50);
        createFDBTN.addActionListener(this);
        add(createFDBTN);

        closeFDBTN=new JButton("CLOSE FD");
        closeFDBTN.setBackground(Color.black);
        closeFDBTN.setForeground(Color.white);
        closeFDBTN.setBounds(110,150,180,50);
        closeFDBTN.addActionListener(this);
        add(closeFDBTN);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==createFDBTN){
            this.setVisible(false);
            new createFD(accNum);
        }
        else if(ae.getSource()==closeFDBTN){
            this.setVisible(false);
            new closeFD(accNum);
        }
    }

    public static void main(String[] args) {
        new optCreateCloseFD(123456789);
    }
}
