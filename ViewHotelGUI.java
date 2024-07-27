package CasasMurosMCO2Package;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * The class to display the manage hotel menu to be interacted with by the user
 */
@SuppressWarnings("serial")
public class ViewHotelGUI extends JFrame{
  private JButton btnHigh = new JButton("High-Level Information");
  private JButton btnLow = new JButton("Low-Level Information");
  private JButton backButton = new JButton("Back");
  private Hotel hotel;
    /**
     * Creates a view hotel menu GUI with the set configurations
     * @param hotel is the hotel with the information to display
     */
    public ViewHotelGUI(Hotel hotel) {
      this.hotel = hotel;
      this.setSize(600,600);
      this.setTitle("View Hotel");
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
    headerLabel.setText("View Hotel");
    headerLabel.setForeground(Color.white);
    headerLabel.setFont(new Font("Comic Sans", Font.BOLD, 40));
    /**
     * Sub-Header label with the set formatting
     */
    JLabel subHeaderLabel = new JLabel();
    subHeaderLabel.setText("Select Level of Information");
    subHeaderLabel.setForeground(Color.black);
    subHeaderLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));

    headerPanel.add(headerLabel);
    subHeaderPanel.add(subHeaderLabel);
    this.add(headerPanel);
    this.add(subHeaderPanel);

    /**
     * Setting the formatting for the included buttons
     */
    btnHigh.setBounds(200, 180, 200, 20);
    btnHigh.setFocusable(false); 
    this.add(btnHigh);

    btnLow.setBounds(200, 210, 200, 20);
    btnLow.setFocusable(false); 
    this.add(btnLow);

    backButton.setBounds(50, 500, 100, 20);
    backButton.setFocusable(false);
    this.add(backButton);
    }
    /**
     * Sets and adds an action listener to all the instantiated buttons within the class
     * @param listener is the object listening to events made by the button
     */
    public void setActionListener(ActionListener listener) {
      btnHigh.addActionListener(listener);
      btnLow.addActionListener(listener);
      backButton.addActionListener(listener);
    }
    /**
     * Gets the button used to direct the user to the high-level information view
     * @return the button used to direct the user to the high-level information view
     */
    public JButton getHighButton() {
      return btnHigh;
    }
    /**
     * Gets the button used to direct the user to the low-level information view
     * @return the button used to direct the user to the low-level information view
     */
    public JButton getLowButton() {
      return btnLow;
    }
    /**
     * Gets the button used to return back to the previous display
     * @return the "Back" button
     */
    public JButton getBackButton() {
      return backButton;
    }
    /**
     * Gets the hotel the user wishes to view the information of
     * @return the hotel the user wishes to view the information of
     */
    public Hotel getHotel() {
      return hotel;
    }

  }
