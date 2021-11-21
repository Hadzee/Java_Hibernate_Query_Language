import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShowPanel {

    JFrame f = new JFrame("Enter Employees");
    JButton b = new JButton("Show Employees");


    JTextArea ta1 = new JTextArea();


    ShowPanel() {

        f.setBackground(Color.BLACK);

        ta1.setBounds(140, 40, 400, 350);


        b.setBounds(140,400,400,40);
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLUE);


        f.add(b);
        f.add(ta1);


        f.setSize(700,600);
        f.setLocation(450, 150);
        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ta1.setText(String.valueOf(HibernateUtil.readEmployees()));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

}
