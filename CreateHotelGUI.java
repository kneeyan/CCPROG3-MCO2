package CasasMurosMCO2Package;
import javax.swing.*;
import javax.swing.event.DocumentListener;

import java.awt.*;
import java.awt.event.*;
/**
 * The class to display the create hotel interface to be interacted with by customers
 */
@SuppressWarnings("serial")
public class CreateHotelGUI extends JFrame{

  private JButton button = new JButton("Submit");
  private JButton backButton = new JButton("Back");
  private JComboBox roomType;
  private JTextField f = new JTextField();
  private String[] A = {"Standard", "Deluxe", "Suite"};

  /**
   * Creates a create-hotel GUI to be displayed with the set configurations
   */
  public CreateHotelGUI() {
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
    headerLabel.setText("Manager View");
    headerLabel.setForeground(Color.white);
    headerLabel.setFont(new Font("Comic Sans", Font.BOLD, 40));
    /**
     * Sub-Header label with the set formatting
     */
    JLabel subHeaderLabel = new JLabel();
    subHeaderLabel.setText("Create Hotel");
    subHeaderLabel.setForeground(Color.black);
    subHeaderLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));

    headerPanel.add(headerLabel);
    subHeaderPanel.add(subHeaderLabel);
    this.add(headerPanel);
    this.add(subHeaderPanel);

    /**
     * Setting the formatting for the text labels on the frame
     */
    JLabel text = new JLabel();
    text.setText("Input hotel name");
    text.setFont(new Font("Comic Sans", Font.PLAIN, 25));

    JPanel textPanel = new JPanel();
    textPanel.setLayout(new FlowLayout());
    textPanel.add(text);
    textPanel.setBounds(150, 200, 300, 35);

    this.add(textPanel);

    /**
     * Setting the formatting for the included buttons, text field, and drop-down menu
     */
    button.setBounds(435, 500, 100, 20);
    this.add(button);
    button.setFocusable(false);

    backButton.setBounds(50, 500, 100, 20);
    this.add(backButton);
    backButton.setFocusable(false);

    f.setBounds(150, 250, 300, 20);
    this.add(f);

    JLabel lblDesc = new JLabel("Select Room Type for Room 01:");
    lblDesc.setBounds(200, 300, 300, 20);
    this.add(lblDesc);

    roomType = new JComboBox(A);
    roomType.setBounds(250, 325, 100, 20);
    roomType.setFocusable(false);
    this.add(roomType);

    }

  /**
   * Sets and adds an action listener to all the instantiated buttons within the class
   * @param listener is the object listening to events made by the button
   */
  public void setActionListener(ActionListener listener){
      button.addActionListener(listener);
      backButton.addActionListener(listener);
      roomType.addActionListener(listener);
  }

  /**
   * Sets and adds a document listener to the instantiated text fields within the class
   * @param listener is the object listening to changes made to the text field
   */
  public void setDocumentListener(DocumentListener listener) {
    f.getDocument().addDocumentListener(listener);
  }
  /**
   * Gets the hotel name input into the text field
   * @return the string input from the text field
   */
  public String getHotelName() {
    return f.getText();
  }
  /**
   * Gets the button used to submit the new input
   * @return the button "Submit"
   */
  public JButton getButton() {
    return button;
  }
  /**
   * Gets the button used to return back to the previous display
   * @return the button "Back"
   */
  public JButton getBackButton() {
    return backButton;
  }
  /**
   * Gets the given room type selected from the drop-down menu
   * @return the index of the chosen option at the drop-down menu
   */
  public int getSelected() {
    return roomType.getSelectedIndex();
  }
}

