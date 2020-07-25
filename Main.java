import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Exception;
import java.util.*;

public class Main implements ActionListener {

    // The main frame
    JFrame frame;

    // All the pages
    static JPanel menuPanel, addFlightPanel, addUserPanel, displayFlightPanel, displayUserPanel, chooseFlightPanel,
            parentNamePanel, chooseUserFlightPanel;
    static int flightCount = 0;

    // add flight page components
    JLabel fromL, toL, priceL, priceIndicator, addFlightTitle;
    JTextField fromtxt, totxt, pricetxt;
    JButton submitFlightBTN;
    Flight flightList[];

    // mainPanel components
    JLabel title;
    JButton addFlightBTN, addUserBTN, displayFlightsBTN, displayUsersBTN, exitBTN;

    // add user page components
    JLabel userNameL, passportNumL, parentNameL, ageL, addUserTitle;
    JTextField userNametxt, passportNumtxt, agetxt;
    JButton backToMenuBTN, submitUserBTN;
    Users usersList[];
    String name;
    int age, passportNum;

    // display flight page components
    JLabel numOfFlightsL;
    JTextPane FlightInfo;
    String str = "";
    Container list;
    JLabel emptyL;

    // choose flight page components
    JLabel chooseFlightTitle;
    ArrayList<JRadioButton> radioList;
    ButtonGroup BTNgroup;
    JButton proceedBTN;
    Flight chosenFlight;
    int chosenFlightIndex;

    // parent name page components
    JLabel parentNameTitle;
    JTextField parentNametxt;
    JButton submitKidBTN;
    String parentName;

    // choose user flight page components
    JButton proceedToUserBTN;
    JLabel chooseUserFlightTitle;
    ArrayList<JRadioButton> radioList2;
    ButtonGroup BTNgroup2;

    // display users panel
    JTextPane UserInfo;

    GridBagConstraints gbc;

    public Main() {
        setup();
    }

    public void setup() {

        frame = new JFrame();

        flightList = new Flight[10];
        list = new Container();

        menuPanel = new JPanel();
        addUserPanel = new JPanel();
        addFlightPanel = new JPanel();
        displayFlightPanel = new JPanel();
        displayUserPanel = new JPanel();

        gbc = new GridBagConstraints();

        frame.setTitle("Flight Booking System");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setVisible(true);

        // =========================================================================================
        // Main Page

        frame.add(menuPanel);

        menuPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Welcome to Flight Booking System");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        menuPanel.add(title, gbc);

        addFlightBTN = new JButton("Add Flight");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(addFlightBTN, gbc);

        addUserBTN = new JButton("Add User");

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(addUserBTN, gbc);

        displayFlightsBTN = new JButton("Display Flights");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(displayFlightsBTN, gbc);

        displayUsersBTN = new JButton("Display Users");

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(displayUsersBTN, gbc);

        exitBTN = new JButton("Exit");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(exitBTN, gbc);
        // End of main page

        // ===========================================================================================
        // Add Users Page

        addUserPanel = new JPanel();

        addUserPanel.setVisible(false);

        addUserPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);

        userNameL = new JLabel("Name");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(userNameL, gbc);

        userNametxt = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(userNametxt, gbc);

        ageL = new JLabel("Age");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(ageL, gbc);

        agetxt = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(agetxt, gbc);

        passportNumL = new JLabel("Passport");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(passportNumL, gbc);

        passportNumtxt = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(passportNumtxt, gbc);

        submitUserBTN = new JButton("Submit");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(submitUserBTN, gbc);

        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                addUserPanel.setVisible(false);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(backToMenuBTN, gbc);

        // ==========================================================================================
        // Add Flight Page

        addFlightPanel = new JPanel();

        addFlightPanel.setVisible(false);

        addFlightPanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);

        fromL = new JLabel("Flying from");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(fromL, gbc);

        fromtxt = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(fromtxt, gbc);

        toL = new JLabel("Flying to");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(toL, gbc);

        totxt = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(totxt, gbc);

        priceL = new JLabel("Price");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(priceL, gbc);

        pricetxt = new JTextField(5);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(pricetxt, gbc);

        

        
        

        // =======================================================================================
        // choose Flight Page usage

        radioList = new ArrayList<JRadioButton>();
        chooseFlightPanel = new JPanel();
        chooseFlightPanel.setVisible(false);

        chooseFlightPanel.setLayout(null);
        BTNgroup = new ButtonGroup();
        proceedBTN = new JButton("Proceed");

        submitFlightBTN = new JButton("Submit Flight");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(submitFlightBTN, gbc);

        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                addFlightPanel.setVisible(false);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(backToMenuBTN, gbc);

        // ===========================================================================================
        // Display Flights Page

        displayFlightPanel = new JPanel();

        displayFlightPanel.setVisible(false);

        displayFlightPanel.setLayout(null);

        FlightInfo = new JTextPane();
        FlightInfo.setEditable(false);
        FlightInfo.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
        FlightInfo.setBounds(20, 2, 244, 175);

        

        // label when there's no flight data to display
        emptyL = new JLabel("No flight data!");
        emptyL.setBounds(100, 75, 130, 23);
        displayFlightPanel.add(emptyL);

        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                displayFlightPanel.setVisible(false);
            }
        });
        backToMenuBTN.setBounds(70, 180, 150, 25);
        displayFlightPanel.add(backToMenuBTN);

        // ===========================================================================================
        // Choose Flights Page

        chooseFlightTitle = new JLabel("Flights to choose from");
        chooseFlightTitle.setBounds(74, 0, 200, 50);
        chooseFlightPanel.add(chooseFlightTitle);

        proceedBTN = new JButton("Proceed");

        proceedBTN.setBounds(70, 150, 150, 25);
        chooseFlightPanel.add(proceedBTN);

        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                chooseFlightPanel.setVisible(false);
            }
        });

        backToMenuBTN.setBounds(70, 180, 150, 25);
        chooseFlightPanel.add(backToMenuBTN);

        // ===========================================================================================
        // Parent Name Page

        parentNamePanel = new JPanel();
        parentNamePanel.setLayout(null);

        parentNameTitle = new JLabel("Kid Registration");
        parentNameTitle.setBounds(100, 0, 200, 50);
        parentNamePanel.add(parentNameTitle);

        parentNameL = new JLabel("Parent Name");
        parentNameL.setBounds(40, 75, 130, 20);
        parentNamePanel.add(parentNameL);

        parentNametxt = new JTextField(10);
        parentNametxt.setBounds(120, 75, 130, 23);
        parentNamePanel.add(parentNametxt);

        submitKidBTN = new JButton("Submit kid");
        submitKidBTN.setBounds(70, 150, 150, 25);
        parentNamePanel.add(submitKidBTN);

        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                parentNamePanel.setVisible(false);
            }
        });

        backToMenuBTN.setBounds(70, 180, 150, 25);
        parentNamePanel.add(backToMenuBTN);

        // ===========================================================================================
        // Choose user flight panel

        chooseUserFlightPanel = new JPanel();
        chooseUserFlightPanel.setVisible(false);
        chooseUserFlightPanel.setLayout(null);
        radioList2 = new ArrayList<JRadioButton>();
        BTNgroup2 = new ButtonGroup();

        chooseUserFlightTitle = new JLabel("Flights to choose from");
        chooseUserFlightTitle.setBounds(74, 0, 200, 50);
        chooseUserFlightPanel.add(chooseUserFlightTitle);

        proceedToUserBTN = new JButton("Proceed");

        proceedToUserBTN.setBounds(70, 150, 150, 25);
        chooseUserFlightPanel.add(proceedToUserBTN);

        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                chooseUserFlightPanel.setVisible(false);
            }
        });

        backToMenuBTN.setBounds(70, 180, 150, 25);
        chooseUserFlightPanel.add(backToMenuBTN);

        // =================================================================
        // display users page

        displayUserPanel = new JPanel();
        displayUserPanel.setLayout(null);

        UserInfo = new JTextPane();
        UserInfo.setEditable(true);
        UserInfo.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
        UserInfo.setBounds(20, 2, 244, 175);
        UserInfo.setEditable(false);
        displayUserPanel.add(UserInfo);

        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                displayUserPanel.setVisible(false);
            }
        });

        backToMenuBTN.setBounds(70, 180, 150, 25);
        displayUserPanel.add(backToMenuBTN);

        // Adding all components with an actionlistener
        addFlightBTN.addActionListener(this);
        addUserBTN.addActionListener(this);
        displayFlightsBTN.addActionListener(this);
        displayUsersBTN.addActionListener(this);
        exitBTN.addActionListener(this);
        submitUserBTN.addActionListener(this);
        submitFlightBTN.addActionListener(this);
        proceedBTN.addActionListener(this);
        submitKidBTN.addActionListener(this);
        proceedToUserBTN.addActionListener(this);

    }

    // ==============================================================================
    // ACTION LISTENER FOR ALL BUTTONS, ETC
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addFlightBTN) {
            menuPanel.setVisible(false);
            frame.add(addFlightPanel);
            addFlightPanel.setVisible(true);
        }

        else if (e.getSource() == addUserBTN) {
            menuPanel.setVisible(false);
            frame.add(chooseFlightPanel);
            chooseFlightPanel.setVisible(true);
        }

        else if (e.getSource() == displayFlightsBTN) {
            menuPanel.setVisible(false);
            frame.add(displayFlightPanel);
            displayFlightPanel.setVisible(true);
        }

        else if (e.getSource() == displayUsersBTN) {
            menuPanel.setVisible(false);
            frame.add(chooseUserFlightPanel);
            chooseUserFlightPanel.setVisible(true);
        }

        else if (e.getSource() == exitBTN) {
            System.exit(0);
        }

        else if (e.getSource() == submitFlightBTN) {

            try {
                if (fromtxt.getText().equals("") || totxt.getText().equals("") || pricetxt.getText().equals("")) {
                    throw new Exception();

                }

                else {

                    /*
                     * flightList[flightCount] = new Flight(fromtxt.getText(), totxt.getText(),
                     * Integer.parseInt(pricetxt.getText())); flightCount++;
                     */

                    int startPos = 20;
                    int startPos2 = 20;

                    list.addFlight(fromtxt.getText(), totxt.getText(), Integer.parseInt(pricetxt.getText()));
                    radioList.add(new JRadioButton(fromtxt.getText() + "  -->  " + totxt.getText(), false));
                    radioList2.add(new JRadioButton(fromtxt.getText() + "  --> " + totxt.getText(), false));

                    if (list.getCount() > 0) {
                        FlightInfo.setText(list.displayInfo());
                        displayFlightPanel.add(FlightInfo);
                        displayFlightPanel.remove(emptyL);

                        for (int i = 0; i < list.getCount(); i++) {

                            radioList.get(i).setBounds(50, (startPos += 20), 200, 20);
                            radioList2.get(i).setBounds(50, (startPos2 += 20), 200, 20);

                            chooseFlightPanel.add(radioList.get(i));
                            chooseUserFlightPanel.add(radioList2.get(i));
                            BTNgroup.add(radioList.get(i));
                            BTNgroup2.add(radioList2.get(i));
                            radioList.get(i).setFocusable(false);
                            radioList2.get(i).setFocusable(false);

                        }

                        addFlightPanel.setVisible(false);
                        menuPanel.setVisible(true);
                        JOptionPane.showMessageDialog(menuPanel, "Flight submitted successfully", "Success",
                                JOptionPane.INFORMATION_MESSAGE);

                    }

                }

            }

            catch (Exception exc) {
                JOptionPane.showMessageDialog(addFlightPanel, "Can't leave any field empty", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            fromtxt.setText(null);
            totxt.setText(null);
            pricetxt.setText(null);
        }

        else if (e.getSource() == proceedBTN) {
            int bool = 2;

            try {

                for (int i = 0; i < list.getCount(); i++) {

                    if (radioList.get(i).isSelected() == true) {
                        bool = 1;

                        chosenFlightIndex = i;

                        break;
                    } else {
                        bool = 0;
                    }
                }
                if (bool == 0) {
                    throw new Exception();
                } else if (bool == 1) {
                    addUserPanel.setVisible(true);
                    frame.add(addUserPanel);
                    chooseFlightPanel.setVisible(false);
                    BTNgroup.clearSelection();

                } else {
                    JOptionPane.showMessageDialog(chooseFlightPanel, "No flight data to choose from", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception exc2) {
                JOptionPane.showMessageDialog(chooseFlightPanel, "You must choose a flight", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        else if (e.getSource() == submitUserBTN) {

            try {

                if (userNametxt.getText().equals("") || agetxt.getText().equals("")
                        || passportNumtxt.getText().equals("")) {

                    throw new Exception();
                }

                else {
                    name = userNametxt.getText();
                    passportNum = Integer.parseInt(passportNumtxt.getText());
                    age = Integer.parseInt(agetxt.getText());

                    if (Integer.parseInt(agetxt.getText()) <= 12) {
                        parentNamePanel.setVisible(true);
                        frame.add(parentNamePanel);
                        addUserPanel.setVisible(false);

                    } else {
                        list.getFlight(chosenFlightIndex).addUser(new Adult(name, passportNum, age));

                        menuPanel.setVisible(true);
                        addUserPanel.setVisible(false);
                        JOptionPane.showMessageDialog(menuPanel, "Flight successfully booked for adult user", "Success",
                                JOptionPane.INFORMATION_MESSAGE);

                    }

                    userNametxt.setText(null);
                    passportNumtxt.setText(null);
                    agetxt.setText(null);
                    parentNametxt.setText(null);

                }

            } catch (Exception exc3) {
                JOptionPane.showMessageDialog(addUserPanel, "Can't leave any field empty", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

        else if (e.getSource() == submitKidBTN) {

            parentName = parentNametxt.getText();
            list.getFlight(chosenFlightIndex).addUser(new Kid(name, passportNum, parentName, age));

            menuPanel.setVisible(true);
            parentNamePanel.setVisible(false);
            JOptionPane.showMessageDialog(menuPanel, "Flight successfully booked for kid user", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        else if (e.getSource() == proceedToUserBTN) {

            String str = "";
            int bool2 = 2;

            try {

                for (int i = 0; i < list.getCount(); i++) {

                    if (radioList2.get(i).isSelected() == true) {
                        bool2 = 1;

                        chosenFlightIndex = i;

                        break;
                    } else {
                        bool2 = 0;
                    }
                }
                if (bool2 == 0) {
                    throw new Exception();
                } else if (bool2 == 1) {
                    
                    if(list.getFlight(chosenFlightIndex).getUserCount() == 0){
                        BTNgroup2.clearSelection();
                        throw new NullPointerException();
                    }
                    chooseUserFlightPanel.setVisible(false);
                    frame.add(displayUserPanel);
                    displayUserPanel.setVisible(true);
                    BTNgroup.clearSelection();
                    
                    
                    str += "--------------- User's Information --------------\n";
                    for (int i = 0; i < list.getFlight(chosenFlightIndex).getUserCount(); i++) {
                        str += list.getFlight(chosenFlightIndex).getUser(i).displayInfo() + "        " + "Price: "+ list.getFlight(chosenFlightIndex).getPrice(i) + " (RM)\n\n";
                    }
                    UserInfo.setText(str);
                    BTNgroup2.clearSelection();

                } else {
                    JOptionPane.showMessageDialog(chooseFlightPanel, "No flight data to choose from", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
             catch(NullPointerException exc5){
                JOptionPane.showMessageDialog(chooseFlightPanel, "No users at this flight", "Error",
                JOptionPane.ERROR_MESSAGE);
             }
             catch (Exception exc2) {
                JOptionPane.showMessageDialog(chooseFlightPanel, "You must choose a flight", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

    }
    // ==============================================================================

    public static void main(String[] args) {

        new Main();

    }

}