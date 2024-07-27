package CasasMurosMCO2Package;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class to display the frame which holds the hotels within the system for the user to choose from
 */
@SuppressWarnings("serial")
public class HotelListGUI extends JFrame{

  private JButton btnSubmit = new JButton("Submit");
  private JComboBox comboBoxList;
  private JButton backButton = new JButton("Back");
  private int type;

  /**
   * Creates a hotel list GUI to be displayed with the set configurations
   * @param List is the list of hotels to choose from
   * @param type is the menu type requiring the choice of a hotel (1-Manage Hotel Menu, 2-View Hotel Menu, 3-Customer Menu)
   */
  public HotelListGUI(String[] List, int type) {
    this.type = type;
      this.setSize(600,600);
      this.setTitle("Hotel Reservation System");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(null);
      this.setResizable(false);
      init(List);
      this.setVisible(true);
    }
  /**
   * Holds the components to be added onto the JFrame being displayed
   * @param List is the list of hotels to choose from
   */
  private void init(String[] List) {
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
       * Sub-header label with the set formatting
       */
      JLabel subHeaderLabel = new JLabel();
      subHeaderLabel.setText("Select Hotel");
      subHeaderLabel.setForeground(Color.black);
      subHeaderLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
      subHeaderLabel.setBounds(235, 150, 200, 20);
      this.add(subHeaderLabel);

      headerPanel.add(headerLabel);
      this.add(headerPanel);

      /**
       * Setting the formatting for the included buttons and drop-down menu
       */
      backButton.setBounds(50, 500, 100, 20);
      backButton.setFocusable(false);
      this.add(backButton);

      btnSubmit.setBounds(435, 500, 100, 20);
      btnSubmit.setFocusable(false);
      this.add(btnSubmit);

      comboBoxList = new JComboBox(List);
      comboBoxList.setBounds(200, 180, 200, 20);
      comboBoxList.setFocusable(false);
      this.add(comboBoxList);
  }
  /**
   * Sets and adds an action listener to all the instantiated buttons within the class
   * @param listener is the object listening to events made by the button
   */
  public void setActionListener(ActionListener listener){
        btnSubmit.addActionListener(listener);
        comboBoxList.addActionListener(listener);
        backButton.addActionListener(listener);
    }
  /**
   * Gets the button used to return to the previous display
   * @return the button used to return to the previous display
   */
  public JButton getBackButton() {
    return backButton;
  }
  /**
   * Gets the button used to submit the chosen option from the drop down list of hotels
   * @return the button used to submit the chosen option
   */
  public JButton getSubmitButton() {
    return btnSubmit;
  }
  /**
   * Gets the current index of the chosen item from the hotel list
   * @return the current index of the chosen item from the hotel list
   */
  public int getCurrIndex() {
    return comboBoxList.getSelectedIndex();
  }
  /**
   * Gets the drop down list used to display the hotel options
   * @return the drop down list used to display the hotel options
   */
  public JComboBox getComboBox() {
    return comboBoxList;
  }
  /**
   * Gets the type of menu that needs the choice of hotel
   * @return Gets the type of menu that needs the choice of hotel represented as an integer
   */
  public int getMenuType() {
    return this.type;
  }
}
