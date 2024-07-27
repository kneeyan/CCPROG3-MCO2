package CasasMurosMCO2Package;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentListener;

/**
 * The class to display the booking user interface to be interacted with by customers
 */
@SuppressWarnings("serial")
public class BookingGUI extends JFrame{

  private String[] roomTypes = {"Standard", "Deluxe", "Suite"};
  private JComboBox roomType;
  private JButton btnSubmit = new JButton("Submit");
  private JButton backButton = new JButton("Back");
  private JButton mainMenu = new JButton("Main Menu");
  private JTextField fIn = new JTextField();
  private JTextField fOut = new JTextField();
  private JTextField fName = new JTextField();
  private JCheckBox hasDiscount = new JCheckBox();
  private Hotel hotel;

  /**
   * Creates a booking GUI to be displayed with the set configurations
   * @param hotel is the hotel the user wishes to book a reservation at
   */
  public BookingGUI(Hotel hotel) {
    this.hotel = hotel;
      this.setSize(600,600);
      this.setTitle("Booking");
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
    headerPanel.setBounds(0, 0, 600, 60);
    /**
     * The panel to be displayed at the top of the frame with the sub-header components
     */
    JPanel subHeaderPanel = new JPanel();
    subHeaderPanel.setBackground(Color.lightGray);
    subHeaderPanel.setLayout(new FlowLayout());
    subHeaderPanel.setBounds(0, 60, 600, 40);
    /**
     * Header label with the set formatting
     */
    JLabel headerLabel = new JLabel();
    headerLabel.setText("Customer Menu");
    headerLabel.setForeground(Color.white);
    headerLabel.setFont(new Font("Comic Sans", Font.BOLD, 40));
    /**
     * Sub-header label with the set formatting
     */
    JLabel subHeaderLabel = new JLabel();
    subHeaderLabel.setText("Booking");
    subHeaderLabel.setForeground(Color.black);
    subHeaderLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));

    headerPanel.add(headerLabel);
    subHeaderPanel.add(subHeaderLabel);
    this.add(headerPanel);
    this.add(subHeaderPanel);

    /**
     * Setting the formatting of the "Back", "Submit", and "Main" buttons
     */
    backButton.setBounds(50, 500, 100, 20);
    backButton.setFocusable(false);
    this.add(backButton);

    btnSubmit.setBounds(200, 300, 200, 20);
    btnSubmit.setFocusable(false);
    this.add(btnSubmit);

    mainMenu.setBounds(435, 500, 100, 20);
    mainMenu.setFocusable(false);
    this.add(mainMenu);

    /**
     * Setting the formatting for the text labels on the frame
     */
    JLabel lblName = new JLabel("Enter Name:");
    lblName.setBounds(200, 180, 200, 20);
    lblName.setFocusable(false);
    this.add(lblName);

    JLabel lblDesc = new JLabel("Check-In Date:");
    lblDesc.setBounds(180, 210, 200, 20);
    lblDesc.setFocusable(false);
    this.add(lblDesc);

    JLabel lblDesc2 = new JLabel("Check-Out Date:");
    lblDesc2.setBounds(300, 210, 200, 20);
    lblDesc2.setFocusable(false);
    this.add(lblDesc2);

    JLabel lblType = new JLabel("Select Room Type:");
    lblType.setBounds(195, 240, 200, 20);
    lblType.setFocusable(false);
    this.add(lblType);

    /**
     * Setting the formatting for the text fields, check box, and drop-down menu
     */
    hasDiscount.setBounds(220, 270, 200, 20);
    hasDiscount.setText("Redeem Discount Code");
    hasDiscount.setFocusable(false);
    this.add(hasDiscount);

    roomType = new JComboBox(roomTypes);
    roomType.setBounds(305, 240, 100, 20);
    roomType.setFocusable(false);
    this.add(roomType);

    fIn.setBounds(265, 210, 25, 20);
    this.add(fIn);

    fOut.setBounds(395, 210, 25, 20);
    this.add(fOut);

    fName.setBounds(275, 180, 125, 20);
    this.add(fName);
  }

  /**
   * Sets and adds an action listener to all the instantiated buttons within the class
   * @param listener is the object listening to events made by the button
   */
  public void setActionListener(ActionListener listener){
        btnSubmit.addActionListener(listener);
        backButton.addActionListener(listener);
        mainMenu.addActionListener(listener);
    }
  /**
   * Sets and adds a document listener to all the instantiated text fields within the class
   * @param listener is the object listening to events made by the text field
   */
  public void setDocumentListener(DocumentListener listener) {
      fIn.getDocument().addDocumentListener(listener);
      fOut.getDocument().addDocumentListener(listener);
      fName.getDocument().addDocumentListener(listener);
  }
  /**
   * Gets the button used to return back to the previous page
   * @return the button used to return back to the previous page
   */
  public JButton getBackButton() {
    return backButton;
  }
  /**
   * Gets the button used to submit the booking entries
   * @return the button used to submit the booking entries
   */
  public JButton getSubmitButton() {
    return btnSubmit;
  }
  /**
   * Gets the button used to return back to the menu
   * @return the button used to return back to the menu
   */
  public JButton getMenuButton() {
    return mainMenu;
  }
  /**
   * Gets the text input within the name text field
   * @return the text input within the name text field
   */
  public String getName() {
    return fName.getText();
  }
  /**
   * Gets the type of the room
   * @return the type of the room. Returns 1 if the room is standard, 2 if deluxe, and 3 if it's a suite
   */
  public int getRoomType() {
    return roomType.getSelectedIndex()+1;
  }
  /**
   * Gets the check in date that the user input within the text field
   * @return the input check in date from the text field
   */
  public int getCheckIn() {
    return Integer.parseInt(fIn.getText());
  }
  /**
   * Gets the check out date of that the user input within the text field
   * @return the input check out date from the text field
   */
  public int getCheckOut() {
  return Integer.parseInt(fOut.getText());
  }
  /**
   * Gets the boolean value of the check box indicated if the user has a discount code
   * @return true if the user has a discount code, false if not
   */
  public Boolean getHasDiscount() {
    return hasDiscount.isSelected();
  }	
  /**
   * Gets the discount code input by the user
   * @return the discount code input by the user
   */
  public String discountPane() {
    return JOptionPane.showInputDialog(this, "Enter Discount Code");
  }
  /**
   * Displays a pop-up message confirming that the discount code has been applied
   */
  public void discountAppliedMsg() {
    JOptionPane.showMessageDialog(this, "Discount Code Applied.", "Booking Confirmed", JOptionPane.PLAIN_MESSAGE);
  }
  /**
   * Displays a pop-up message confirming that the booking is successful
   * @param code
   */
  public void successMsg(String code) {
    JOptionPane.showMessageDialog(this, "Booking Confirmed.\nReservation Code: "+code, "Booking Confirmed", JOptionPane.PLAIN_MESSAGE);
  }
  /**
   * Displays a pop-up error message depending on the given code
   * @param code indicates which type of error message to display
   */
  public void errorMsg(int code) {
      switch (code) {
        case 1:
          JOptionPane.showMessageDialog(this, "Date Input is Invalid.", "Error", JOptionPane.ERROR_MESSAGE);
          break;
        case 2:
          JOptionPane.showMessageDialog(this, "Invalid Discount Code", "Error", JOptionPane.ERROR_MESSAGE);
          break;
        case 3:
          JOptionPane.showMessageDialog(this, "Room Unavailable", "Error", JOptionPane.ERROR_MESSAGE);
          break;
      }
}

}
