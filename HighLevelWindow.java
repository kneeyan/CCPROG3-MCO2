package CasasMurosMCO2Package;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * The class to display the high level information of a hotel
 */
@SuppressWarnings("serial")
public class HighLevelWindow extends JFrame{

  private String name;
  private int roomsCount;
  private Double earnings;
  private JButton backButton = new JButton("Back");
  private JButton mainMenu = new JButton("Main Menu");
  /**
   * Creates a display of a frame which holds the high-level information of a hotel
   * @param name 	   is the name of the hotel
   * @param roomsCount is the number of rooms within the hotel
   * @param earnings   is the total earnings of the hotel
   * @pre name != null, roomsCount > 0, earnings != null
   */
  public HighLevelWindow(String name, int roomsCount, Double earnings) {
        this.name = name;
        this.roomsCount = roomsCount;
        this.earnings = earnings;
        this.setSize(600,600);
        this.setTitle("High-Level Information");
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
       * Header label with the set formatting
       */
      JLabel headerLabel = new JLabel();
      headerLabel.setText("High-Level Information");
      headerLabel.setForeground(Color.white);
      headerLabel.setFont(new Font("Comic Sans", Font.BOLD, 40));

      headerPanel.add(headerLabel);
      this.add(headerPanel);
      /**
       * Setting the formatting for the text labels on the frame
       */
      JLabel lblHotelName = new JLabel("Hotel Name: " + name);
      lblHotelName.setBounds(200, 180, 200, 20);
      this.add(lblHotelName);

      JLabel lblRoomCount = new JLabel("Total Rooms: " + roomsCount);
      lblRoomCount.setBounds(200, 210, 200, 20);
      this.add(lblRoomCount);

      JLabel lblEarnings = new JLabel("Total Earnings: " + earnings);
      lblEarnings.setBounds(200, 240, 200, 20);
      this.add(lblEarnings);
      /**
       * Setting the formatting for the included buttons
       */
      backButton.setBounds(50, 500, 100, 20);
      backButton.setFocusable(false);
      this.add(backButton);

      mainMenu.setBounds(435, 500, 100, 20);
      mainMenu.setFocusable(false);
      this.add(mainMenu);

      }

      /**
       * Sets and adds an action listener to all the instantiated buttons within the class
       * @param listener is the object listening to events made by the button
       */
      public void setActionListener(ActionListener listener) {
          mainMenu.addActionListener(listener);
          backButton.addActionListener(listener);
      }
      /**
       * Gets the button used to return back to the main menu
       * @return the button used to return to the main menu
       */
      public JButton getMenuButton() {
        return mainMenu;
      }
      /**
       * Gets the button used to return to the previous frame
       * @return the button used to return to the previous frame
       */
      public JButton getBackButton() {
        return backButton;
      }
}
