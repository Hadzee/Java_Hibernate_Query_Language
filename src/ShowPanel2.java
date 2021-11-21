import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowPanel2 {

    JFrame f = new JFrame("Enter Employees");
    JButton b = new JButton("Show Employees");


    JTextArea ta1 = new JTextArea();

    JLabel l = new JLabel("Enter income: ");
    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();


    ShowPanel2() {

        f.setBackground(Color.BLACK);

        ta1.setBounds(140, 40, 400, 350);
        tf1.setBounds(140, 400,400,25);
        tf2.setBounds(140, 450,400,25);

        l.setBounds(50,600,100,40);
        l.setForeground(Color.BLUE);


        b.setBounds(140,500,400,40);
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLUE);

        f.add(ta1);
        f.add(b);
        f.add(tf1);
        f.add(tf2);
        f.add(l);



        f.setSize(800,800);
        f.setLocation(450, 150);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double income = Double.parseDouble(tf1.getText());
                Employees employee1 = new Employees();
                employee1.setIncome((float) income);

                double income2 = Double.parseDouble(tf2.getText());
                Employees employee2 = new Employees();
                employee2.setIncome((float) income2);
                try {
                    ta1.setText(String.valueOf(HibernateUtil.readEmployees1(employee1, employee2)));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
