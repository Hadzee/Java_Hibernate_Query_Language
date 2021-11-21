import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DeletePanel {

    JFrame f = new JFrame("Enter Employees");
    JButton b = new JButton("Delete");

    JLabel l = new JLabel("Enter ID: ");


    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();


    DeletePanel() {

        f.setBackground(Color.BLACK);

        tf1.setBounds(140, 40,400,25);
        tf2.setBounds(140,80,400,25);


        l.setBounds(10,45,80,20);
        l.setForeground(Color.BLUE);


        b.setBounds(140,100,400,40);
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLUE);


        f.add(b);
        f.add(l);
        f.add(tf1);
        f.add(tf2);


        f.setSize(650,200);
        f.setLocation(450, 150);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(tf1.getText());
                Employees employees = new Employees(id);
                try {
                    HibernateUtil.deleteEmployees(id);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }

}
