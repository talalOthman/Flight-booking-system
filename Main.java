import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    JLabel title, choice;
    JButton b1, b2, b3, b4, b5;
    JTextField choiceText;

    GridBagConstraints gbc = new GridBagConstraints();

    public Main(){
        setLayout(new GridBagLayout());
        
        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Welcome to Flight Booking System");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(title, gbc);

        b1 = new JButton("Add Flight");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b1, gbc);

        b2 = new JButton("Add User");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b2, gbc);

        b3 = new JButton("Display Flights");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b3, gbc);

        b4 = new JButton("Display Users");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b4, gbc);

        b5 = new JButton("Exit");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(b5, gbc);
        
        
    }


    public static void main(String [] args){
        Main frame = new Main();

        frame.setTitle("Flight Booking System");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setVisible(true);
    }
}