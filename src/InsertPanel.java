import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class InsertPanel {
    JFrame f = new JFrame("Enter Employees");
    JButton b = new JButton("Enter Employee");

    JLabel l = new JLabel("Enter ID: ");
    JLabel l1 = new JLabel("Enter name: ");
    JLabel l2 = new JLabel("Enter age: ");
    JLabel l3 = new JLabel("Enter adress: ");
    JLabel l4 = new JLabel("Enter income: ");

    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf3 = new JTextField();
    JTextField tf4 = new JTextField();
    JTextField tf5 = new JTextField();
    JTextField tf6 = new JTextField();

    InsertPanel() {

        f.setBackground(Color.BLACK);

        tf1.setBounds(140, 40,400,25);
        tf2.setBounds(140,80,400,25);
        tf3.setBounds(140,120,400,25);
        tf4.setBounds(140,160,400,25);
        tf5.setBounds(140,200,400,25);

        l.setBounds(10,45,80,20);
        l.setForeground(Color.BLUE);
        l1.setBounds(10,85,80,20);
        l1.setForeground(Color.BLUE);
        l2.setBounds(10,125,80,20);
        l2.setForeground(Color.BLUE);
        l3.setBounds(10,165,80,20);
        l3.setForeground(Color.BLUE);
        l4.setBounds(10,205,80,20);
        l4.setForeground(Color.BLUE);

        b.setBounds(140,260,400,40);
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLUE);


        f.add(b);
        f.add(l);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(tf4);
        f.add(tf5);
        f.add(tf6);


        f.setSize(650,400);
        f.setLocation(450, 150);
        f.setVisible(true);


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tf1.getText());
                String name = tf2.getText();
                int age = Integer.parseInt(tf3.getText());
                String adress = tf4.getText();
                double income = Double.parseDouble(tf5.getText());
                Employees employees = new Employees(id, name, age, adress, income);
                try {
                    HibernateUtil.insertEmployee(employees);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
