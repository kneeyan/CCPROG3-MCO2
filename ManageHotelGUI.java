package CasasMurosMCO2Package;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The class to display the manage hotel menu to be interacted with by the user
 */
@SuppressWarnings("serial")
public class ManageHotelGUI extends JFrame {

  private JButton exitButton = new JButton("Exit");
  private JButton[] options = new JButton[7];
  private int i;

  /**
   * Creates a manage hotel menu GUI with the set configurations
   */
  public ManageHotelGUI() {
    this.setSize(600, 600);
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
  public void init() {
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
    headerLabel.setText("Manager View");
    headerLabel.setForeground(Color.white);
    headerLabel.setFont(new Font("Comic Sans", Font.BOLD, 40));
    /**
     * Sub-Header label with the set formatting
     */
    JLabel subHeaderLabel = new JLabel();
    subHeaderLabel.setText("Manage Hotel Options");
    subHeaderLabel.setForeground(Color.black);
    subHeaderLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));

    headerPanel.add(headerLabel);
    subHeaderPanel.add(subHeaderLabel);
    this.add(headerPanel);
    this.add(subHeaderPanel);

    /**
     * Setting the formatting for the included buttons
     */
    options[0] = new JButton("Change Hotel Name");
    options[1] = new JButton("Add Room");
    options[2] = new JButton("Remove Room");
    options[3] = new JButton("Update Base Price");
    options[4] = new JButton("Remove Reservation");
    options[5] = new JButton("Remove Hotel");
    options[6] = new JButton("Modify Date-Price");

    for (i = 0; i < 7; i++) {
      options[i].setBounds(200, 150 + i * 30, 200, 20);
      options[i].setFocusable(false);
      this.add(options[i]);
    }

    exitButton.setBounds(50, 500, 100, 20);
    exitButton.setFocusable(false);
    this.add(exitButton);
  }
  /**
   * Sets and adds an action listener to all the instantiated buttons within the class
   * @param listener is the object listening to events made by the button
   */
  public void setActionListener(ActionListener listener) {
    for (i = 0; i < 7; i++) {
      options[i].addActionListener(listener);
    }
    exitButton.addActionListener(listener);
  }
  /**
   * Displays a pop-up message which prompts the user to input a new hotel name
   * @return the input string for the new hotel name
   */
  public String changeHotelName() {
    return JOptionPane.showInputDialog(this, "New Hotel Name");
  }
  /**
   * Displays a pop-up message which prompts the user to input the quantity of rooms to add
   * @return the input quantity. Returns -1 if the user exits, cancels, or leaves the input empty, and 999 if the user inputs a string value
   */
  public int addRoomQty() {
    String s = JOptionPane.showInputDialog(this, "# of Rooms to Add", "0");
    try {
      if (s != null && s.length()!=0) {
            return Integer.parseInt(s);
      } else {
            return -1;
      }
    }catch(NumberFormatException e) {
      return 999;
    }
  }
  /**
   * Displays a pop-up option pane which asks the user to choose the type of room to add
   * @return the type of room the user chose. 0-Standard, 1-Deluxe, 2-Suite, -1 if otherwise
   */
  public int addRoomType() {
    String[] types = { "Standard", "Deluxe", "Suite" };
    return JOptionPane.showOptionDialog(this, "Added Room Type", "Add Room/s",
        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, types, 0);
  }
  /**
   * Displays a pop-up message which prompts the user to 
   * input the room number of the room they wish to remove
   * @return the input room number. Returns -1 if the user exits, cancels, or leaves the input empty, and 999 if the user inputs a string value
   */
  public int removeRoom() {
    String s = JOptionPane.showInputDialog(this, "Room # to Remove");
    try {
      if (s != null && s.length()!=0) {
          return Integer.parseInt(s);
      } else {
        return -1;
      }
    }catch(NumberFormatException e) {
      return 999;
    }
  }
  /**
   * Displays a pop-up message which prompts the user to input a new base price for the hotel
   * @return the input new base price. Returns -1 if the user exits, cancels, or leaves the input empty, and -999 if the user inputs a string
   */
  public double updateBasePrice() {
    String s = JOptionPane.showInputDialog(this, "New Base Price (>=100.00)", "100.00");
    try {
      if (s != null && s.length()!=0) {
            return Double.parseDouble(s);
      } else {
        return -1.0;
      }
    }catch(NumberFormatException e) {
      return -999.0;
    }
  }
  /**
   * Displays a pop-up message which prompts the user to input the 
   * reservation code of the reservation they wish to remove
   * @return the input reservation code
   */
  public String removeReservation() {
    return JOptionPane.showInputDialog(this, "Reservation Code");
  }
  /**
   * Displays a pop-up message which prompts the user confirm if they wish to delete the hotel
   * @return 0 if the user chooses yes, 1 if no, 2 if cancelled, and -1 if otherwise.
   */
  public int removeHotel() {
    return JOptionPane.showConfirmDialog(this, "Remove Hotel?", "Delete Hotel", JOptionPane.YES_NO_CANCEL_OPTION);
  }
  /**
   * Displays a pop-up message which prompts the user to input the date they wish to modify the price of
   * @return the input check in date. Returns -1 if the user exits, cancels, or leaves the input empty, 
   * and 999 if the user inputs a string value
   */
  public int modifyDatePrice() {
    String s = JOptionPane.showInputDialog(this, "Date to Modify (1-30)");
    try {
      if (s != null && s.length()!=0) {
            return Integer.parseInt(s);
      } else {
        return -1;
      }
    }catch(NumberFormatException e) {
      return 999;
    }
  }
  /**
   * Displays a pop-up message which prompts the user to input the new piece modifier for the date
   * @param checkIn is the date the user wishes to change the date-price of
   * @return the input date-price modifier. Returns -1 if the user exits, cancels, 
   * or leaves the input empty, and 999 if the user inputs a string value
   */
  public double datePriceModifier(int checkIn) {
    String s = JOptionPane.showInputDialog(this, "Modifier for day " + checkIn + " (0.50<=X<=1.50)", "1.00");
    try {
      if (s != null && s.length()!=0) {
            return Double.parseDouble(s);
      } else {
        return -1.0;
      }
    }catch(NumberFormatException e) {
      return 999.0;
    }
  }

  /**
   * Displays a pop-up message to confirm the changes the user made 
   * @return 0 if the user chooses yes, 1 if no, 2 if cancelled, and -1 if otherwise.
   */
  public int confirm() {
    i = JOptionPane.showConfirmDialog(this, "Confirm Changes?", "Confirm Change", JOptionPane.YES_NO_CANCEL_OPTION);
    if (i == 0) {
      JOptionPane.showMessageDialog(this, "Changes Successful!");
    } else if (i != -1) {
      JOptionPane.showMessageDialog(this, "Changes Cancelled");
    }
    return i;
  }
  /**
   * Displays a specific pop-up error message given a code
   * @param code to determine which corresponding error message to display
   */
  public void errorMessage(int code) {
    switch (code) {
      case 1:
        JOptionPane.showMessageDialog(this, "Hotel Name Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
        break;
      case 2:
        JOptionPane.showMessageDialog(this, "Unable to Add Room/s", "Error", JOptionPane.ERROR_MESSAGE);
        break;
      case 3:
        JOptionPane.showMessageDialog(this, "Unable to Delete Room", "Error", JOptionPane.ERROR_MESSAGE);
        break;
      case 4:
        JOptionPane.showMessageDialog(this, "Invalid Price", "Error", JOptionPane.ERROR_MESSAGE);
        break;
      case 5:
        JOptionPane.showMessageDialog(this, "Reservation Doesn't Exist", "Error", JOptionPane.ERROR_MESSAGE);
        break;
      case 6:
        JOptionPane.showMessageDialog(this, "Unable To Modify Date Price", "Error", JOptionPane.ERROR_MESSAGE);
        break;
    }
  }
  /**
   * Gets the button used to exit to the main menu
   * @return the button used to exit to the main menu
   */
  public JButton getExitButton() {
    return exitButton;
  }
  /**
   * Gets the button within the button array given the specified 
   * index which corresponds to each manage menu option
   * @param index of the button being used
   * @return the corresponding button at the given index
   */
  public JButton getOptionButton(int index) {
    return options[index];
  }

}