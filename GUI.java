package CasasMurosMCO2Package;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class to display the main menu interface to be interacted with by customers
 */
@SuppressWarnings("serial")
public class GUI extends JFrame{
    private JButton btnCustomer = new JButton("Enter Customer Menu");
    private JButton btnManager = new JButton("Enter Manager Menu");
    private JButton btnCreateHotel = new JButton("Create New Hotel");
    private JButton btnViewHotel = new JButton("Enter View Hotel Menu");
    private JButton exitButton = new JButton("Exit");

    /**
     * Creates a main menu GUI to be displayed with the set configurations
     */
    public GUI() {
      this.setSize(600,600);
      this.setTitle("Hotel Reservation System");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(null);
      this.setResizable(false);
      init();
      this.setVisible(true);
    }
    /**
     * Holds the components to be added onto the JFrame being displayed
     */
    private void init() {
    /**
     * The panel to be displayed at the top of the frame with the header components
     */
    JPanel headerPanel = new JPanel();
    headerPanel.setBackground(Color.blue);
    headerPanel.setLayout(new FlowLayout());
    headerPanel.setBounds(0,0,600,60);
    /**
     * The panel to be displayed at the top of the frame with the sub-header components
     */
    JPanel subHeaderPanel = new JPanel();
    subHeaderPanel.setBackground(Color.lightGray);
    subHeaderPanel.setLayout(new FlowLayout());
    subHeaderPanel.setBounds(0,60,600,40);
    /**
     * Header label with the set formatting
     */
    JLabel headerLabel = new JLabel();
    headerLabel.setText("Hotel reservation system");
    headerLabel.setForeground(Color.white);
    headerLabel.setFont(new Font("Comic Sans", Font.BOLD, 40));
    /**
     * Sub-Header label with the set formatting
     */
    JLabel subHeaderLabel = new JLabel();
    subHeaderLabel.setText("Welcome!!");
    subHeaderLabel.setForeground(Color.black);
    subHeaderLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));

    headerPanel.add(headerLabel);
    subHeaderPanel.add(subHeaderLabel);
    this.add(headerPanel);
    this.add(subHeaderPanel);

    /**
     * Setting the formatting for the included buttons
     */
    btnCustomer.setBounds(200, 150, 200, 20);
    btnCustomer.setFocusable(false); 
    this.add(btnCustomer);

    btnManager.setBounds(200, 180, 200, 20);
    btnManager.setFocusable(false); 
    this.add(btnManager);

    btnViewHotel.setBounds(200, 210, 200, 20);
    btnViewHotel.setFocusable(false);
    this.add(btnViewHotel);

    btnCreateHotel.setBounds(200, 240, 200, 20);
    btnCreateHotel.setFocusable(false); 
    this.add(btnCreateHotel);

    exitButton.setBounds(50, 500, 100, 20);
    exitButton.setFocusable(false);
    this.add(exitButton);
    }

    /**
     * Sets and adds an action listener to all the instantiated buttons within the class
     * @param listener is the object listening to events made by the button
     */
    public void setActionListener(ActionListener listener){
          btnCustomer.addActionListener(listener);
          btnManager.addActionListener(listener);
          btnCreateHotel.addActionListener(listener);
          btnViewHotel.addActionListener(listener);
          exitButton.addActionListener(listener);
      }
    /**
     * Gets the button used to select the manager menu options
     * @return the button to enter the manager menu
     */
    public JButton getManagerButton() {
      return btnManager;
    }
    /**
     * Gets the button used to select the customer menu
     * @return the button to enter the customer menu
     */
    public JButton getCustomerButton() {
      return btnCustomer;
    }
    /**
     * Gets the button selected to create a new hotel
     * @return the button used to enter the create hotel menu
     */
    public JButton getCreateButton() {
      return btnCreateHotel;
    }
    /**
     * Gets the button used to exit the program
     * @return the button used to exit the program
     */
    public JButton getExitButton() {
      return exitButton;
    }
    /**
     * Gets the button used to select the view hotel menu
     * @return the button to enter the view hotel menu
     */
    public JButton getViewHotelButton() {
      return btnViewHotel;
    }
    /**
     * Displays a pop-up error message when the user selects an option when there are no hotels in the system
     */
    public void showError() {
      JOptionPane.showMessageDialog(null, "No Hotels Created.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

