package bank;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.*;
public class payLoan extends JFrame implements ActionListener {
    int accNum;
    JTable tab;
    String bal;
    JButton backBTN,payBTN;
    String loan_id;
    JTextField amtTF,balTF;
    double final_amt=0.0;

    payLoan(int accNum){
        this.accNum=accNum;
        setLayout(null);

        JLabel amtLBL=new JLabel("NET AMOUNT");
        amtLBL.setBounds(150,260,200,30);
        amtLBL.setFont(new Font("",Font.BOLD,20));
        add(amtLBL);
        amtTF=new JTextField();
        amtTF.setBounds(350,260,100,30);
        amtTF.setEnabled(false);
        add(amtTF);

        JLabel balLBL=new JLabel("BALANCE");
        balLBL.setBounds(150,340,200,30);
        balLBL.setFont(new Font("",Font.BOLD,20));
        add(balLBL);
        balTF=new JTextField();
        balTF.setBounds(350,340,100,30);
        balTF.setEnabled(false);
        add(balTF);

        tab=new JTable();
        tab.setModel(new DefaultTableModel(new Object [][] {},new String [] {"LOAN_ID", "AMOUNT", "DURATION","FINAL_AMT","REQ_DATE","APPR_DATE","TYPE"}));
        tab.setBounds(10,10,650,200);
        JScrollPane jsp = new JScrollPane(tab);
        jsp.setBounds(10, 10, 650, 200);
        add(jsp);
        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tab1MouseClickedEvent(e);
            }
        });

        backBTN=new JButton("BACK");
        backBTN.setForeground(Color.white);
        backBTN.setBackground(Color.black);
        backBTN.setBounds(200,430,100,30);
        backBTN.addActionListener(this);
        add(backBTN);



        payBTN=new JButton("PAY");
        payBTN.setForeground(Color.white);
        payBTN.setBackground(Color.black);
        payBTN.setBounds(330,430,100,30);
        payBTN.addActionListener(this);
        add(payBTN);
        //frame code
        setLocation(300,100);
        setSize(700,500);

        try{
            ConnectionSQL c=new ConnectionSQL();
            String query="SELECT * FROM unpaidloans where accNum="+accNum+"";
            ResultSet rs=c.s.executeQuery(query);

            while(rs.next()){
                String loan_id=""+rs.getInt("reqloanid");
                String amt=""+rs.getDouble("amt");
                String dur=""+rs.getInt("dur");
                String final_amt=""+rs.getDouble("finalamt");
                String req_date=""+rs.getDate("reqdate");
                String appr_date=""+rs.getDate("apprdate");
                String type=""+rs.getString("type");
                bal=""+rs.getInt("bal");
                String tbdata[]={loan_id,amt,dur,final_amt,req_date,appr_date,type};
                DefaultTableModel tab1=(DefaultTableModel)tab.getModel();
                tab1.addRow(tbdata);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        balTF.setText(bal);
        setVisible(true);

    }

    private void tab1MouseClickedEvent(MouseEvent e) {
        int i=tab.getSelectedRow();
        TableModel model=tab.getModel();
        loan_id=model.getValueAt(i,0).toString();
        String final_amtS=model.getValueAt(i,3).toString();
        amtTF.setText(final_amtS);


    }


    public static void main(String[] args) {
        new payLoan(527880378);
    }

    //@Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==backBTN){
            this.setVisible(false);
            new MoreOptions2(accNum);
        }
        else if(ae.getSource()==payBTN){
            Double bal=Double.parseDouble(balTF.getText());
            Double amt=Double.parseDouble(amtTF.getText());
            if(amt>bal)
                JOptionPane.showMessageDialog(null,"Insufficient funds");
            else{
                //System.out.println(loan_id+"\n"+bal+"\n"+amt);
                try{
                    bal-=amt;
                    ConnectionSQL c=new ConnectionSQL();
                    String sql1="Update loanrequests set persstatus='PAID' where reqloanid="+loan_id+"";
                    String sql2="insert into transactions values ("+accNum+","+amt+","+bal+",'WITH_LOAN(REP)',curdate())";
                    String sql3="update balance set bal="+bal+" where accnum="+accNum+"";
                    c.s.executeUpdate(sql1);
                    c.s.executeUpdate(sql2);
                    c.s.executeUpdate(sql3);
                    JOptionPane.showMessageDialog(null,"Loan has been repayed");
                    this.setVisible(false);
                    new payLoan(accNum);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }


    }
}
