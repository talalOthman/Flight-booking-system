import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Exception;

public class Main{

    //All the pages
    static JPanel menuPanel, addFlightPanel, addUserPanel, displayFlightPanel, displayUserPanel, chooseFlightPanel;
    static int flightCount = 0;


    //add flight page components
    JLabel fromL, toL, priceL, priceIndicator, addFlightTitle;
    JTextField fromtxt, totxt, pricetxt;
    JButton submitFlightBTN;
    static Flight flightList[];


     //mainPanel components
     JLabel title;
     JButton b1, b2, b3, b4, b5;


     //add user page components
     JLabel userNameL, passportNumL, parentNameL, addUserTitle;
     JTextField userNametxt, passportNumtxt, parentNametxt;
     JButton backToMenuBTN, submitUserBTN;


     //display flight page components
     JLabel numOfFlightsL;
     JTextPane FlightInfo;
     String str = "";
     Container list;
     JLabel emptyL;


     //choose flight page components
     JLabel chooseFlightTitle;
     JRadioButton radioList[];
     ButtonGroup BTNgroup;


     
     GridBagConstraints gbc;
    



     public Main(){
         setup();
     }


    public void setup(){

        //The main frame
        JFrame frame = new JFrame();




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

//=========================================================================================
        //Main Page
        
        frame.add(menuPanel);



        menuPanel.setLayout(new GridBagLayout());
        
        gbc.insets = new Insets(5, 5, 5, 5);

        title = new JLabel("Welcome to Flight Booking System");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        menuPanel.add(title, gbc);

        
        
        
        
        
        b1 = new JButton("Add Flight");
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(false);
                frame.add(addFlightPanel);
                addFlightPanel.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1; 
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(b1, gbc);

       
       
       
       
       
       
        b2 = new JButton("Add User");
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action){
                menuPanel.setVisible(false);
                frame.add(chooseFlightPanel);
                chooseFlightPanel.setVisible(true);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(b2, gbc);

        
        
        
        
        
        
        b3 = new JButton("Display Flights");
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action){
                menuPanel.setVisible(false);
                frame.add(displayFlightPanel);
                displayFlightPanel.setVisible(true);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(b3, gbc);

        
        
        
        
        
        b4 = new JButton("Display Users");
        b4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action){
                menuPanel.setVisible(false);
                frame.add(displayUserPanel);
                displayUserPanel.setVisible(true);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(b4, gbc);

        
        
        
        
        
        b5 = new JButton("Exit");
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action) {
				System.exit(0);
			}
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        menuPanel.add(b5, gbc);
        //End of main page




//=========================================================================================== 
        //Add Users Page

        
        

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

        
        
        
        
        
        
        passportNumL = new JLabel("Passport");
        
        gbc.gridx = 0;
        gbc.gridy = 2; 
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(passportNumL, gbc);

       
       
       
       
       
       
        passportNumtxt = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(passportNumtxt, gbc);

        
        
        submitUserBTN = new JButton("Submit");
        submitUserBTN.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action) {
                
			}
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(submitUserBTN, gbc);

        
        
        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                addUserPanel.setVisible(false);
			}
        });
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addUserPanel.add(backToMenuBTN, gbc);



//==========================================================================================
        //Add Flight Page

        
        
        

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



       //========================================================================================
        //TextPane for add flight
        FlightInfo = new JTextPane();
		FlightInfo.setEditable(true);
		FlightInfo.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //=======================================================================================



        //=======================================================================================
        // choose Flight Page usage

        radioList = new JRadioButton[10];
        chooseFlightPanel = new JPanel();
        chooseFlightPanel.setVisible(false);

        chooseFlightPanel.setLayout(null);
        BTNgroup = new ButtonGroup();


        

        
        
        submitFlightBTN = new JButton("Submit Flight");
        submitFlightBTN.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action) {
                try{
                    if(fromtxt.getText().equals("") || totxt.getText().equals("") || pricetxt.getText().equals("")){
                        throw new Exception();

                    }else{

                        /*
                        flightList[flightCount] = new Flight(fromtxt.getText(), totxt.getText(), Integer.parseInt(pricetxt.getText()));
                        flightCount++;
                        */



                        list.addFlight(fromtxt.getText(), totxt.getText(), Integer.parseInt(pricetxt.getText()));

                        int startPos = 50;
                        
                        if(list.getCount() > 0){
                            FlightInfo.setText(list.displayInfo());
                            displayFlightPanel.add(FlightInfo);
                            displayFlightPanel.remove(emptyL);


                            for(int i=0; i<list.getCount(); i++){
                                radioList[i] = new JRadioButton (list.getFlight(i).getFrom());
                                radioList[i].setBounds(50, (startPos+=20), 200, 20);
                                chooseFlightPanel.add(radioList[i]);
                                BTNgroup.add(radioList[i]);

                            }

                        }


                            
                            


                    }

                }catch(Exception e){
                    JOptionPane.showMessageDialog(addFlightPanel, "Can't leave any field empty", "Error", JOptionPane.ERROR_MESSAGE);
                }

                addFlightPanel.setVisible(false);
                menuPanel.setVisible(true);
                JOptionPane.showMessageDialog(menuPanel, "Flight submitted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                fromtxt.setText(null);
                totxt.setText(null);
                pricetxt.setText(null);
			}
        });

        

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addFlightPanel.add(submitFlightBTN, gbc);

        
        
        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener(){
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


        



 //===========================================================================================
        //Display Flights Page

        displayFlightPanel = new JPanel();
        
        displayFlightPanel.setVisible(false);



        displayFlightPanel.setLayout(new GridBagLayout());
        
        gbc.insets = new Insets(5, 5, 5, 5);



        

        
        

        //label when there's no flight data to display
        emptyL = new JLabel("No flight data!");
        gbc.gridx = 0;
        gbc.gridy = 0; 
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        displayFlightPanel.add(emptyL, gbc);
    

        
        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                displayFlightPanel.setVisible(false);
			}
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        displayFlightPanel.add(backToMenuBTN, gbc);




 //===========================================================================================
        //Choose Flights Page
        
        
        chooseFlightTitle = new JLabel("Flights to choose from");
        chooseFlightTitle.setBounds(74, 0, 200, 50);
        chooseFlightPanel.add(chooseFlightTitle); 


        

    

        
        backToMenuBTN = new JButton("Back to menu");
        backToMenuBTN.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent action) {
                menuPanel.setVisible(true);
                chooseFlightPanel.setVisible(false);
			}
        });

        backToMenuBTN.setBounds(70, 180, 150, 25);
        
        chooseFlightPanel.add(backToMenuBTN);




    }















    public static void main(String [] args){
        
        new Main();
        
    }

    
}