package bank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Signupone extends JFrame implements ActionListener{

    JButton nextBTN;
    JRadioButton maleRBT,femaleRBT,marriedRBT,unmarriedRBT;
    JDateChooser dobCH;
    int random;
    DateTimeFormatter dtf;
    LocalDateTime now;
    JTextField nameTF,fnameTF,dobTF,mailTF,addressTF,cityTF,stateTF,pincodeTF;
    Signupone(){
        //generating random form number
        Random rn=new Random();
        random=Math.abs(rn.nextInt()%9000);

        dtf = DateTimeFormatter.ofPattern("yyyyssMMddHHmm");
        now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        //code for head label
        JLabel head=new JLabel("CREATE ACCOUNT");
        head.setFont(new Font("Raleway",Font.BOLD,38));
        add(head);
        //VERY IMPORTANT LINE
        setLayout(null);
        head.setBounds(150,20,400,50);

        //formno label
        JLabel formno=new JLabel("Form no: "+dtf.format(now));
        formno.setBounds(500,70,150,50);
        add(formno);

        //label for printing page number personal details
        JLabel page=new JLabel("Page 1: Personal Details");
        page.setBounds(250,90,200,20);
        add(page);

        //name Label
        JLabel name=new JLabel("Name");
        name.setBounds(125,150,100,20);
        add(name);

        //name TF
        nameTF=new JTextField();
        nameTF.setFont(new Font("Raleway",Font.BOLD,14));
        nameTF.setBounds(300,150,200,20);
        add(nameTF);

        //fathername label
        JLabel fname=new JLabel("Father's name");
        fname.setBounds(125,190,100,20);
        add(fname);

        //fname TF
        fnameTF=new JTextField();
        fnameTF.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTF.setBounds(300,190,200,20);
        add(fnameTF);

        //dob label
        JLabel dob=new JLabel("DOB");
        dob.setBounds(125,230,100,20);
        add(dob);
        //dob TF
        dobCH=new JDateChooser();
        //dobTF.setFont(new Font("Raleway",Font.BOLD,14));
        dobCH.setBounds(300,230,200,20);
        add(dobCH);

        //gender label
        JLabel gen=new JLabel("Gender");
        gen.setBounds(125,270,100,20);
        add(gen);
        //gender RBT
        maleRBT=new JRadioButton("Male");
        maleRBT.setBounds(300,270,100,20);
        add(maleRBT);
        femaleRBT=new JRadioButton("Female");
        femaleRBT.setBounds(430,270,100,20);
        add(femaleRBT);
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(maleRBT);
        genderGroup.add(femaleRBT);

        // mail address label
        JLabel mail=new JLabel("E-Mail Address");
        mail.setBounds(125,310,100,20);
        add(mail);
        //mailTF
        mailTF=new JTextField();
        mailTF.setFont(new Font("Raleway",Font.BOLD,14));
        mailTF.setBounds(300,310,200,20);
        add(mailTF);

        //Marital status label
        JLabel marital=new JLabel("Marital Status");
        marital.setBounds(125,350,100,20);
        add(marital);
        //marital RBT
        marriedRBT=new JRadioButton("Married");
        marriedRBT.setBounds(300,350,100,20);
        add(marriedRBT);
        unmarriedRBT=new JRadioButton("Unmarried");
        unmarriedRBT.setBounds(430,350,100,20);
        add(unmarriedRBT);

        ButtonGroup marritalGroup=new ButtonGroup();
        marritalGroup.add(marriedRBT);
        marritalGroup.add(unmarriedRBT);
        //address label
        JLabel address=new JLabel("Address");
        address.setBounds(125,390,100,20);
        add(address);
        //address TF
        addressTF=new JTextField();
        addressTF.setFont(new Font("Raleway",Font.BOLD,14));
        addressTF.setBounds(300,390,200,20);
        add(addressTF);

        //city label
        JLabel city=new JLabel("City");
        city.setBounds(125,430,100,20);
        add(city);
        //city TF
        cityTF=new JTextField();
        cityTF.setFont(new Font("Raleway",Font.BOLD,14));
        cityTF.setBounds(300,430,200,20);
        add(cityTF);

        //state
        JLabel state=new JLabel("State");
        state.setBounds(125,470,100,20);
        add(state);
        //state TF
        stateTF=new JTextField();
        stateTF.setFont(new Font("Raleway",Font.BOLD,14));
        stateTF.setBounds(300,470,200,20);
        add(stateTF);

        //pincode
        JLabel pincode=new JLabel("Pincode");
        pincode.setBounds(125,510,100,20);
        add(pincode);
        //pincode TF
        pincodeTF=new JTextField();
        pincodeTF.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTF.setBounds(300,510,200,20);
        add(pincodeTF);

        //NEXT BTN
        nextBTN=new JButton("NEXT");
        nextBTN.setBackground(Color.BLACK);
        nextBTN.setForeground(Color.WHITE);
        nextBTN.setBounds(430,540,100,30);
        nextBTN.addActionListener(this);
        add(nextBTN);

        //Creating the frame
        setLocation(250,20);
        setSize(700,650);
        setTitle("ACCOUNT OPENING FORM-PAGE 1");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==nextBTN){
            String formno=""+dtf.format(now);
            String name=nameTF.getText();
            String fname=fnameTF.getText();
            String dob=((JTextField) dobCH.getDateEditor().getUiComponent()).getText();
            String gender=null;
            System.out.println(""+formno);
            if(maleRBT.isSelected()){
                gender="Male";
            }
            else if(femaleRBT.isSelected())
                gender="Female";
            String email=mailTF.getText();
            String marital=null;
            if(marriedRBT.isSelected())
                marital="Married";
            else if(unmarriedRBT.isSelected())
                marital="Unmarried";
            String address=addressTF.getText();
            String city=cityTF.getText();
            String pincode=pincodeTF.getText();
            String state=stateTF.getText();

            if(name.equals(""))
                JOptionPane.showMessageDialog(null,"Name cannot be empty");

            else if(fname.equals(""))
                JOptionPane.showMessageDialog(null,"Fathers name cannot be empty");
            else{
                try{
                    ConnectionSQL c=new ConnectionSQL();
                    String query="Insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new Signuptwo(formno).setVisible(true);
                }
                catch(Exception e){

                    System.out.println(e);
                }



            }
        }
    }
    public static void main(String[] args) {
        new Signupone();
    }

}
