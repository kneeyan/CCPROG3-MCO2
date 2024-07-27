package CasasMurosMCO2Package;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.event.DocumentListener;

/**
 * The class to display the low level information of a hotel
 */
@SuppressWarnings("serial")
public class LowLevelGUI extends JFrame{

  private String[] list = {"Available Rooms for Inputted Date", "Room Information (Input Room No.)", "Reservation Information (Input Code)"};
  private JButton btnSubmit = new JButton("Submit");
  private JComboBox comboBoxList;
  private JButton backButton = new JButton("Back");
  private JTextField f = new JTextField();
  private JButton mainMenu = new JButton("Main Menu");

  /**
   * Creates a display of a frame which holds the low-level information of a hotel
   */
  public LowLevelGUI() {
      this.setSize(600,600);
      this.setTitle("Low-Level Information");
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
      headerLabel.setText("Low-Level Information");
      headerLabel.setForeground(Color.white);
      headerLabel.setFont(new Font("Comic Sans", Font.BOLD, 40));
      /**
       * Sub-header label with the set formatting
       */
      JLabel subHeaderLabel = new JLabel();
      subHeaderLabel.setText("Select Option");
      subHeaderLabel.setForeground(Color.black);
      subHeaderLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
      subHeaderLabel.setBounds(235, 150, 200, 20);
      this.add(subHeaderLabel);

      headerPanel.add(headerLabel);
      this.add(headerPanel);

      /**
       * Setting the formatting for the included buttons, text field, and drop-down menu
       */
      backButton.setBounds(50, 500, 100, 20);
      backButton.setFocusable(false);
      this.add(backButton);

      btnSubmit.setBounds(200, 240, 200, 20);
      btnSubmit.setFocusable(false);
      this.add(btnSubmit);

      mainMenu.setBounds(435, 500, 100, 20);
      mainMenu.setFocusable(false);
      this.add(mainMenu);

      comboBoxList = new JComboBox(list);
      comboBoxList.setBounds(175, 180, 250, 20);
      comboBoxList.setFocusable(false);
      this.add(comboBoxList);

      JLabel lblDesc = new JLabel("Input:");
      lblDesc.setBounds(200, 210, 200, 20);
      lblDesc.setFocusable(false);
      this.add(lblDesc);

      f.setBounds(240, 210, 160, 20);
      this.add(f);
  }
  /**
   * Sets and adds an action listener to all the instantiated buttons within the class
   * @param listener is the object listening to events made by the button
   */
  public void setActionListener(ActionListener listener){
        btnSubmit.addActionListener(listener);
        comboBoxList.addActionListener(listener);
        backButton.addActionListener(listener);
        mainMenu.addActionListener(listener);
    }
  /**
   * Sets and adds a document listener to the instantiated text fields within the class
   * @param listener is the object listening to changes made to the text field
   */
  public void setDocumentListener(DocumentListener listener) {
    f.getDocument().addDocumentListener(listener);
  }
  /**
   * Gets the button used to return to the previous frame
   * @return the button used to return to the previous frame
   */
  public JButton getBackButton() {
    return backButton;
  }
  /**
   * Gets the button used to submit the chosen option
   * @return the button used to submit the chosen option
   */
  public JButton getSubmitButton() {
    return btnSubmit;
  }
  /**
   * Gets the button used to return to the main menu
   * @return the button used to return to the main menu
   */
  public JButton getMenuButton() {
    return mainMenu;
  }
  /**
   * Gets the current index of the chosen item from the low-level options
   * @return the current index of the chosen item from the low-level options
   */
  public int getCurrIndex() {
    return comboBoxList.getSelectedIndex();
  }
  /**
   * Gets the drop down menu of the low-level options
   * @return the drop down menu of the low-level options
   */
  public JComboBox getComboBox() {
    return comboBoxList;
  }
  /**
   * Gets the text input from the text field
   * @return Gets the text input from the text field
   */
  public String getText() {
    return f.getText();
  }
  /**
   * Displays a pop-up message indicating the number of rooms available for the given date
   * @param num  is the number of rooms available for a given date
   * @param date is the date the user wishes to see is available
   */
  public void option1(int num, String date) {
    JOptionPane.showMessageDialog(null, num + " room(s) available for date: " + date, "Available Rooms", JOptionPane.PLAIN_MESSAGE);
  }
  /**
   * Displays a pop-up error message to indicate that the user entered an invalid date
   */
  public void option1error() {
    JOptionPane.showMessageDialog(null, "Invalid Date.", "Error", JOptionPane.ERROR_MESSAGE);
  }
  /**
   * Displays a pop-up message indicating the information of a given room
   * @param name  is the name of the room
   * @param price is the price-per-night of the room
   * @param dates is the lsit of days the given room is available
   */
  public void option2(String name, Double price, String dates) {
    JOptionPane.showMessageDialog(null,  "Room Name: " + name + "\nPrice Per Night: " + price + "\nAvailable Dates: " + dates, 
        "Room Information", JOptionPane.DEFAULT_OPTION);
  }
  /**
   * Displays a pop-up error message to indicate that the input room does not exist
   */
  public void option2error() {
    JOptionPane.showMessageDialog(null, "Room does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
  }
  /**
   * Displays a pop-up confirmation message for when the user makes a reservation 
   * depending on whether they have a valid discount code or not
   * @param reservation is the reservation the user made
   */
  public void option3(Reservation reservation) {
    String code;
    if (reservation.getHasDiscount() != 0) {
      if (reservation.getHasDiscount() == 1) {
        code = "I_WORK_HERE (-10%)";
      } else if (reservation.getHasDiscount() == 2) {
        code = "STAY4_GET1 (First Day Free)";
      } else {
        code = "PAYDAY (-7%)";
      }

      JOptionPane.showMessageDialog(null, "Guest Name: " + reservation.getName() + "\nRoom Number: " + reservation.getRoom().getRoomNumber()
              + "\n\nCost Breakdown:\nCheck-In Date: " + reservation.getCheckIn() + "\nCheck-Out Date: " + reservation.getCheckOut() + 
              "\nPrice Per Night: " + reservation.getRoom().getRoomPrice() + "\nLess Discount Code: "+ code + "\nNet Price: " + new DecimalFormat("#.##").format(reservation.getTotalPrice()), "Reservation Information", 
              JOptionPane.PLAIN_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Guest Name: " + reservation.getName() + "\nRoom Number: " + reservation.getRoom().getRoomNumber()
              + "\n\nCost Breakdown:\nCheck-In Date: " + reservation.getCheckIn() + "\nCheck-Out Date: " + reservation.getCheckOut() + 
              "\nPrice Per Night: " + reservation.getRoom().getRoomPrice() + "\nNet Price: " + new DecimalFormat("#.##").format(reservation.getTotalPrice()), "Reservation Information", 
              JOptionPane.PLAIN_MESSAGE);
    }
  }
  /**
   * Displays a pop-up error message to indicate that the input reservation code does not exist
   */
  public void option3error() {
    JOptionPane.showMessageDialog(null, "Reservation does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
  }
  /**
   * Displays a pop-up error message to indicate that the input is invalid 
   */
  public void blankError() {
    JOptionPane.showMessageDialog(null, "Invalid Input.", "Error", JOptionPane.ERROR_MESSAGE);
  }
}
