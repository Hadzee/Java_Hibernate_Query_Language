import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdatePanel {

    JFrame f = new JFrame("Update Employees");
    JButton b = new JButton("Update");

    JLabel l = new JLabel("Enter ID: ");
    JLabel l2 = new JLabel("Enter age: ");
    JLabel l3 = new JLabel("Enter adress: ");
    JLabel l4 = new JLabel("Enter income: ");

    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();
    JTextField tf5 = new JTextField();

    UpdatePanel() {

        f.setBackground(Color.BLACK);

        tf1.setBounds(140, 40,400,25);
        tf2.setBounds(140,80,400,25);
        tf3.setBounds(140,120,400,25);
        tf4.setBounds(140,160,400,25);
        tf5.setBounds(140,200,400,25);

        l.setBounds(10,45,80,20);
        l.setForeground(Color.BLUE);
        l2.setBounds(10,85,80,20);
        l2.setForeground(Color.BLUE);
        l3.setBounds(10,125,80,20);
        l3.setForeground(Color.BLUE);
        l4.setBounds(10,165,80,20);
        l4.setForeground(Color.BLUE);

        b.setBounds(140,220,400,40);
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLUE);


        f.add(b);
        f.add(l);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(tf4);
        f.add(tf5);


        f.setSize(650,350);
        f.setLocation(450, 150);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tf1.getText());
                int age = Integer.parseInt(tf2.getText());
                String adress = tf3.getText();
                double income = Double.parseDouble(tf4.getText());
                Employees employees = new Employees(id,age,adress,income);
                try {
                    HibernateUtil.updateEmployees(employees);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }
}
