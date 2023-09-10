package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Signupthree extends JFrame implements ActionListener {
    String formno;
    JButton nextBTN;
    JTextField openAmtTF;
    JCheckBox termsCHK;
    DateTimeFormatter dtf;
    LocalDateTime now;
    Signupthree(String formno){

        this.formno=formno;
        JLabel page=new JLabel("Page 3: Account Details");
        page.setBounds(250,50,200,20);
        add(page);
        JLabel form_no=new JLabel("Form no: "+formno);
        form_no.setBounds(450,60,150,50);
        add(form_no);
        JLabel opAmt=new JLabel("Opening Amount");
        opAmt.setBounds(125,150,150,20);
        add(opAmt);
        openAmtTF=new JTextField();
        openAmtTF.setBounds(250,150,200,30);
        add(openAmtTF);
        termsCHK=new JCheckBox("I have read and agree to the Terms and Conditions");
        termsCHK.setBounds(125,200,400,30);
        add(termsCHK);
        nextBTN=new JButton("NEXT");
        nextBTN.setForeground(Color.WHITE);
        nextBTN.setBackground(Color.black);
        nextBTN.setBounds(260,275,100,20);
        nextBTN.addActionListener(this);
        add(nextBTN);
        //setting the frame
        setLocation(250,60);
        setSize(700,350);
        setLayout(null);
        setTitle("ACCOUNT OPENING FORM-PAGE 3");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Signupthree("202303112230");
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==nextBTN){
            if(!termsCHK.isSelected())
                JOptionPane.showMessageDialog(null,"Please Agree to terms and conditions to continue");
            else{
                double bal=Double.parseDouble(openAmtTF.getText());
                if(bal<0)
                    JOptionPane.showMessageDialog(null,"Please enter valid amount");
                else{
                    int  accNum1 ,pin;
                    long accNum;
                    Random rn=new Random();
                    pin=(Math.abs(rn.nextInt()%9000));
                    accNum=(Math.abs(rn.nextInt()%900000000));
                    System.out.println(accNum);
                    // dtf = DateTimeFormatter.ofPattern("yyyyssMMddmm");
                    // now = LocalDateTime.now();
                    // String currTime = dtf.format(now);
                    // String tempAccNum = currTime + "" +  accNum1;
                    // System.out.println(tempAccNum);
                    // accNum = Long.parseLong(tempAccNum);
                    // System.out.println(tempAccNum);
                    JOptionPane.showMessageDialog(null,"Accnum: "+accNum+"\nPin: "+pin);
                    this.setVisible(false);
                    int count = 0;
                    try{
                        ConnectionSQL c=new ConnectionSQL();
                        String query1="Insert into signup3(formno,accnum,pin) values ('"+formno+"',"+accNum+",'"+pin+"')";
                        String query2="Insert into balance values("+accNum+",'"+bal+"')";
                         c.s.executeUpdate(query1);
                         count ++;
                         c.s.executeUpdate(query2);
                         count ++;
                    }
                    catch (NumberFormatException ne)
                    {
                        JOptionPane.showMessageDialog(null, "Enter valid amount");
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Account not opened "+e);
                        System.out.println(count);
                        try {
                            ConnectionSQL c1 = new ConnectionSQL();
                            String sql1 = "delete from signup2 where formno='" + formno + "'";
                            String sql2 = "Delete from signup where formno='" + formno + "'";
                            c1.s.executeUpdate(sql1);
                            c1.s.executeUpdate(sql2);
                        }
                        catch(Exception ex2){
                            JOptionPane.showMessageDialog(null,ex2);
                        }

                    }
                    new Login().setVisible(true);

                }
            }
        }
    }
}
