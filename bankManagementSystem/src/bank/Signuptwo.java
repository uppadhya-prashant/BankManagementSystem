package bank;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signuptwo extends JFrame implements ActionListener {
    JComboBox religionCBO,categoryCBO,incomeCBO,educationCBO,occupationCBO;
    JTextField panTF,aadharTF;
    JRadioButton seniorRBT,notSeniorRBT,existingAccRBT,notExistingAccountRBT;
    JButton nextBTN;
    String formno;
    ButtonGroup sen,exic;
    Signuptwo(String formno){
        this.formno=formno;
        //label for printing page number personal details
        JLabel page=new JLabel("Page 2: Additional Details");
        page.setBounds(250,90,200,20);
        add(page);
        JLabel form_no=new JLabel("Form no: "+formno);
        form_no.setBounds(500,70,150,50);
        add(form_no);

        //name TF

        //CODE FOR religion
        JLabel rel=new JLabel("Religion: ");
        rel.setBounds(125,150,100,20);
        add(rel);
        String varReligion[]={"--NOT SELECTED--","HINDU","MUSLIM","SIKH","CHRISTIAN","OTHERS"};
        religionCBO=new JComboBox(varReligion);
        religionCBO.setFont(new Font("Raleway",Font.BOLD,14));
        religionCBO.setBounds(300,150,200,20);
        add(religionCBO);
    //code for category
        JLabel category=new JLabel("Category");
        category.setBounds(125,190,100,20);
        add(category);

        String cat[]={"--NOT SELECTED--","GENERAL","OBC","SC","ST"};
        categoryCBO=new JComboBox(cat);
        categoryCBO.setFont(new Font("Raleway",Font.BOLD,14));
        categoryCBO.setBounds(300,190,200,20);
        add(categoryCBO);

        //dob label
        JLabel income=new JLabel("Income");
        income.setBounds(125,230,100,20);
        add(income);
        //dob TF
        String inc[]={"--NOT SELECTED--","<100000",">100000 and <250000",">250000 and <500000"," >500000 and <800000",">800000"};
        incomeCBO=new JComboBox(inc);
        //dobTF.setFont(new Font("Raleway",Font.BOLD,14));
        incomeCBO.setBounds(300,230,200,20);
        add(incomeCBO);

        //gender label
        JLabel edu=new JLabel("Education");
        edu.setBounds(125,270,100,20);
        add(edu);
        //gender RBT
        String ed[]={"--NOT SELECTED--","Undergraduate","Postgraduate","Diploma","Student","No education"};
        educationCBO=new JComboBox(ed);
        educationCBO.setBounds(300,270,200,20);
        add(educationCBO);

        // mail address label
        JLabel occ=new JLabel("Occupation");
        occ.setBounds(125,310,100,20);
        add(occ);
        //mailTF
        String oc[]={"--NOT SELECTED--","Doctor","Teacher","Engineer","Self-Employed","Student","Unemployed"};
        occupationCBO=new JComboBox(oc);
        occupationCBO.setFont(new Font("Raleway",Font.BOLD,14));
        occupationCBO.setBounds(300,310,200,20);
        add(occupationCBO);

        //Marital status label
        JLabel pan=new JLabel("PAN No.");
        pan.setBounds(125,350,100,20);
        add(pan);
        //marital RBT
        panTF=new JTextField();
        panTF.setBounds(300,350,200,20);
        panTF.setFont(new Font("Raleway",Font.BOLD,14));
        add(panTF);

        //address label
        JLabel aadhar=new JLabel("Aadhar No.");
        aadhar.setBounds(125,390,100,20);
        add(aadhar);
        //address TF
        aadharTF=new JTextField();
        aadharTF.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTF.setBounds(300,390,200,20);
        add(aadharTF);

        //city label
        JLabel senior=new JLabel("Senior Citizen");
        senior.setBounds(125,430,100,20);
        add(senior);
        //city TF
        seniorRBT=new JRadioButton("Yes");
        seniorRBT.setBounds(300,430,100,20);
        add(seniorRBT);
        notSeniorRBT =new JRadioButton("No");
        notSeniorRBT.setBounds(400,430,100,20);
        add(notSeniorRBT);
        sen=new ButtonGroup();
        sen.add(seniorRBT);
        sen.add(notSeniorRBT);
        //state
        JLabel exi=new JLabel("Existing Account");
        exi.setBounds(125,470,100,20);
        add(exi);
        //state TF
        existingAccRBT =new JRadioButton("Yes");
        existingAccRBT.setBounds(300,470,100,20);
        add(existingAccRBT);
        notExistingAccountRBT =new JRadioButton("No");
        notExistingAccountRBT.setBounds(400,470,100,20);
        add(notExistingAccountRBT);
        exic=new ButtonGroup();
        exic.add(existingAccRBT);
        exic.add(notExistingAccountRBT);

        //NEXT BTN
        nextBTN=new JButton("NEXT");
        nextBTN.setBackground(Color.BLACK);
        nextBTN.setForeground(Color.WHITE);
        nextBTN.setBounds(430,540,100,30);
        nextBTN.addActionListener(this);
        add(nextBTN);
        //code to make the frame
        setLocation(250,20);
        setSize(700,650);
        setLayout(null);
        setVisible(true);
        setTitle("ACCOUNT OPENING FORM-PAGE 2");
    }

    public static void main(String[] args) {
        new Signuptwo("202303112230");
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==nextBTN){
            String religion=religionCBO.getSelectedItem().toString();
            String category=categoryCBO.getSelectedItem().toString();
            String income=incomeCBO.getSelectedItem().toString();
            String education=educationCBO.getSelectedItem().toString();
            String ocupation=occupationCBO.getSelectedItem().toString();
            String pan=panTF.getText();
            String aadhar=aadharTF.getText();
            String senior,exis;
            if(seniorRBT.isSelected())
                senior="Yes";
            else
                senior="No";
            if(existingAccRBT.isSelected())
                exis="Yes";
            else
                exis="No";

            try{
                ConnectionSQL c=new ConnectionSQL();
                String query="Insert into signup2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+ocupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+exis+"')";
                c.s.executeUpdate(query);
                this.setVisible(false);
                new Signupthree(formno).setVisible(true);
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }
}
