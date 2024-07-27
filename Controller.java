package CasasMurosMCO2Package;
import java.awt.event.*;

import javax.swing.JOptionPane;
import javax.swing.event.*;

/**
 * This acts as the controller of the program and holds the necessary logic 
 * for the program to run according to how it was designed
 */
public class Controller implements ActionListener, DocumentListener {

  private Hotel hotel;
  private GUI gui;
  private Model model;
  private CreateHotelGUI createGui;
  private ManageHotelGUI manageGui;
  private HotelListGUI hotelList;
  private ViewHotelGUI viewHotel;
  private HighLevelWindow highLevel;
  private LowLevelGUI lowLevel;
  private BookingGUI bookingGui;
  /**
   * Assigns the values of the main starting menu and model upon instantiation
   * @param gui is an instance of the main display screen 
   * @param model is an instance of the object which holds the relevant data of the system
   * @pre gui != null
   * @pre model != null
   */
  public Controller(GUI gui, Model model) {
    this.gui = gui;
    this.model = model;

    gui.setActionListener(this);
  }

  /**
   * This is an override method included within the ActionListener interface
   * made to allow the program to read action events caused by a button during run time
   * @param e is the action event that may occur during run time
   */
  @Override
  public void actionPerformed(ActionEvent e) {
  /**
   * If the user chooses the view manage option, the hotel list connected to the manage 
   * hotel menu displays if there are existing hotels, and disposes of the previous display 
   * frame. If there are no existing hotels, it instead displays a pop-up error message
   */
    if (e.getSource() == gui.getManagerButton()) {
      if (model.getTotalHotelCount() != 0) {
        hotelList = new HotelListGUI(model.getHotelNames(), 1);
        hotelList.setActionListener(this);
        gui.dispose();
      } else {
        gui.showError();
      }
    /**
     * If the user chooses the view hotel option, the hotel list connected to the view hotel 
     * menu displays if there are existing hotels, and disposes of the previous display frame. 
     * If there are no existing hotels, it instead displays a pop-up error message
     */
    } else if (e.getSource() == gui.getViewHotelButton()) {
      if (model.getTotalHotelCount() != 0) {
        hotelList = new HotelListGUI(model.getHotelNames(), 2);
        hotelList.setActionListener(this);
        gui.dispose();
      } else {
        gui.showError();
      }
    /**
     * If the user chooses the customer option, the hotel list connected to the customer 
     * menu displays if there are existing hotels, and disposes of the previous display 
     * frame. If there are no existing hotels, it instead displays a pop-up error message
     */
    } else if (e.getSource() == gui.getCustomerButton()) {
      if (model.getTotalHotelCount() != 0) {
        hotelList = new HotelListGUI(model.getHotelNames(), 3);
        hotelList.setActionListener(this);
        gui.dispose();
      } else {
        gui.showError();
      }
    }
    /**
     * If the user chooses to press the exit button, the program 
     * disposes of the main menu and exits the program
     */
    else if (e.getSource() == gui.getExitButton()) {
      gui.dispose();
    }
    /**
     * If the user chooses to create a hotel, the hotel creation display is shown
     * and disposes of the previous frame. Action and document listeners are then 
     * added to the newly created frame.
     */
    else if (e.getSource() == gui.getCreateButton()) {
      createGui = new CreateHotelGUI();
      createGui.setActionListener(this);
      createGui.setDocumentListener(this);
      gui.dispose();
    }
    /**
     * If the source of the action is from the hotel creation frame, wherein the user
     * submits the name for a new hotel to be created, the program checks whether the given name
     * already exists within the system. If not, the hotel is created with the specified stating 
     * room type. 
     */
    else if (e.getSource() == createGui.getButton()) {
      if (model.hotelNameCheck(createGui.getHotelName())) {
        model.addHotel(new Hotel(createGui.getHotelName(), model.getTotalHotelCount() + 1));
        model.getHotel(model.getTotalHotelCount() - 1).addRoom(1, createGui.getSelected() + 1);
        JOptionPane.showMessageDialog(null, "Hotel " + createGui.getHotelName() + " created.", "Hotel Created",
            JOptionPane.PLAIN_MESSAGE);
      } else {
        JOptionPane.showMessageDialog(null, "Hotel name already exists.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    /**
     * If the source of the action is from the hotel creation frame, wherein the user
     * chooses the back button, the main menu is once again displayed and the previous
     * frame is disposed.
     */
    else if (e.getSource() == createGui.getBackButton()) {
      gui = new GUI();
      gui.setActionListener(this);
      createGui.dispose();
    }
    /**
     * If the user is currently at the hotel list display, it is directed 
     * to the corresponding menu the user wishes go to given the menu type. 
     * 1 - Manage Hotel, 2 - View Hotel, 3 - Customer View
     */
    if (hotelList != null) {
      if (e.getSource() == hotelList.getBackButton()) {
        gui = new GUI();
        gui.setActionListener(this);
        hotelList.dispose();
      } else if (e.getSource() == hotelList.getSubmitButton()) {
        // view hotel menu
        if (hotelList.getMenuType() == 2) {
          this.hotel = model.getHotel(hotelList.getCurrIndex());
          viewHotel = new ViewHotelGUI(this.hotel);
          viewHotel.setActionListener(this);
          hotelList.dispose();
        } // insert manager menu
        else if (hotelList.getMenuType() == 1) {
          this.hotel = model.getHotel(hotelList.getCurrIndex());
          manageGui = new ManageHotelGUI();
          manageGui.setActionListener(this);
          hotelList.dispose();
        } else if (hotelList.getMenuType() == 3) {
          this.hotel = model.getHotel(hotelList.getCurrIndex());
          bookingGui = new BookingGUI(this.hotel);
          bookingGui.setActionListener(this);
          hotelList.dispose();
        }
      }

    }
    /**
     * If the user is currently as the hotel booking display, the user is 
     * presented with the booking page wherein a customer name, check-in, 
     * and check-out date can be entered. A drop-down menu where the user 
     * can select a room type for the booking is also included in the display. 
     * Additionally, the user can select whether they will redeem a discount code. 
     */
    if (bookingGui != null) {
      if (e.getSource() == bookingGui.getBackButton()) {
        hotelList = new HotelListGUI(model.getHotelNames(), 3);
        hotelList.setActionListener(this);
        bookingGui.dispose();
      } else if (e.getSource() == bookingGui.getMenuButton()) {
        this.hotel = null;
        gui = new GUI();
        gui.setActionListener(this);
        bookingGui.dispose();
        /**
         * Once they click submit, an new, smaller window on whether the booking is a 
         * success or not will be displayed. If the user opted to redeem a discount code, 
         * the user will be asked to input a code. If the code matches with one of the 
         * discount codes in the system, the booking will proceed normally. Otherwise, 
         * the booking will not go through.
         */
      } else if (e.getSource() == bookingGui.getSubmitButton()) {
        int roomAssignment, discountType;
        String code;
        if (bookingGui.getHasDiscount()) {
          code = bookingGui.discountPane();
          if (code != null) {
            discountType = model.checkDiscount(code, this.hotel, bookingGui.getCheckIn(), bookingGui.getCheckOut());
            if (discountType != -1) {
              roomAssignment = model.bookRoom(this.hotel, bookingGui.getCheckIn(), bookingGui.getCheckOut(),
                  bookingGui.getName(), bookingGui.getRoomType());
              if (roomAssignment != -1) {
                model.updateReservationWithDiscount(discountType, this.hotel);
                  bookingGui.discountAppliedMsg();
                  bookingGui.successMsg(
                      model.createReserveCode(roomAssignment, bookingGui.getCheckIn(), bookingGui.getCheckOut()));
              } else {
                if (model.validateDate(bookingGui.getCheckIn(), bookingGui.getCheckOut()) == false) {
                  bookingGui.errorMsg(1);
                } else {
                  bookingGui.errorMsg(3);
                }
              }
            } else {
              bookingGui.errorMsg(2);
            }
          }
        } else {
          roomAssignment = model.bookRoom(this.hotel, bookingGui.getCheckIn(), bookingGui.getCheckOut(),
              bookingGui.getName(), bookingGui.getRoomType());
          if (roomAssignment != -1) {
            bookingGui.successMsg(model.createReserveCode(roomAssignment, bookingGui.getCheckIn(), bookingGui.getCheckOut()));
          } else {
            if (model.validateDate(bookingGui.getCheckIn(), bookingGui.getCheckOut()) == false) {
              bookingGui.errorMsg(1);
            } else {
              bookingGui.errorMsg(3);
            }
          }
        }
      }
    }
    /**
     * If the user is currently at the manage hotel display, the program listens to which 
     * corresponding button is the source of the said action. The user is then prompted to input 
     * given a pop-up option pane. After which the user is shown another pop-up message to 
     * confirm their change. Once the change is confirmed, the change is then reflected in the model.
     */
    if (manageGui != null) {
      /**
       * If the user chooses to exit, it displays the main menu and disposes of the previous frame
       */
      if (e.getSource() == manageGui.getExitButton()) {
        this.hotel = null;
        this.gui = new GUI();
        gui.setActionListener(this);
        this.manageGui.dispose();
        /**
         * If the user chooses to change the hotel name, a pop-up message prompts the user
         * to input their new name. If the name does not already exist within the system it 
         * prompts the user to confirm their change and then reflects the changes within the model
         */
      } else if (e.getSource() == manageGui.getOptionButton(0)) {
        String s = manageGui.changeHotelName();
        if (s != null) {
          if (model.hotelNameCheck(s)) {
            int answer = manageGui.confirm();
            if (answer == 0) {
              hotel.setHotelName(s);
            }
          } else {
            manageGui.errorMessage(1);
          }
        }
        /**
         * If the user chooses to add a room to the hotel, a pop-up message prompts the user to input 
         * the quantity of rooms they wish to add. It then prompts the user to choose the type of room
         * they need to be. Once this change is confirmed, it reflects the changes within the model. It
         * displays an error message if the number of added rooms is invalid or more than 50
         */
      } else if (e.getSource() == manageGui.getOptionButton(1)) {
        int answer1 = manageGui.addRoomQty();
        if (answer1 != -1) {
          if (hotel.getRoomCount() + answer1 <= 50 && answer1>0) {
            int answer2 = manageGui.addRoomType();
            if (answer2 != -1) {
              int a = manageGui.confirm();
              if (a == 0) {
                hotel.addRoom(answer1, answer2 + 1);
              }
            }
          } else {
            manageGui.errorMessage(2);
          }
        }
        /**
         * If the user chooses to delete a room from the hotel, a pop-up message prompts the user to input 
         * the room number of the room they wish to remove. Once this change is confirmed, it reflects 
         * the changes within the model. It displays an error message if the room does not exist or if the
         * room already has an existing reservation
         */
      } else if (e.getSource() == manageGui.getOptionButton(2)) {
        int answer = manageGui.removeRoom();
        if (answer != -1) {
          int index = hotel.returnRoom(answer);
          if (index != -1) {
            if (hotel.getRoom(index).getReservations().size() == 0) {
              int a = manageGui.confirm();
              if (a == 0) {
                hotel.removeRoom(index);
              }
            } else {
              manageGui.errorMessage(3);
            }
          } else {
            manageGui.errorMessage(3);
          }
        }
        /**
         * If the user chooses to update the base price of the hotel, a pop-up message prompts the user
         * to input a new price greater >=100. Once confirmed, it reflects the changes within the model.
         * An error message is displayed if an invalid input is given
         */
      } else if (e.getSource() == manageGui.getOptionButton(3)) {
        double d = manageGui.updateBasePrice();
        if (d != -1) {
          if (d >= 100.0) {
            int a = manageGui.confirm();
            if (a == 0) {
              hotel.setRoomBasePrice(d);
            }
          } else {
            manageGui.errorMessage(4);
          }
        }
        /**
         * If the user chooses to delete a reservation from the hotel, a pop-up message prompts the user to input 
         * the reservation code of the reservation they wish to remove. Once this change is confirmed, it reflects 
         * the changes within the model. It displays an error message if the reservation does not exist
         */
      } else if (e.getSource() == manageGui.getOptionButton(4)) {
        String s = manageGui.removeReservation();
        if (s != null) {
          int index = hotel.returnReservation(s);
          if (index != -1) {
            int a = manageGui.confirm();
            if (a == 0) {
              hotel.removeReservation(index);
            }
          } else {
            manageGui.errorMessage(5);
          }
        }
        /**
         * If the user chooses to delete the hotel, a pop-up message asks for
         * them to confirm their choice. Once the choice in confirmed, the hotel
         * is removed from the system and the display returns to the main menu
         */
      } else if (e.getSource() == manageGui.getOptionButton(5)) {
        int answer = manageGui.removeHotel();
        if (answer == 0) {
          int a = manageGui.confirm();
          if (a == 0) {
            this.model.removeHotel(hotel);
            this.gui = new GUI();
            gui.setActionListener(this);
            this.manageGui.dispose();
          }
        }
        /**
         * If the user chooses to modify the date price, a pop-up message prompts the
         * user to input the check-in date they wish to modify. If the input is valid, 
         * it then prompts the user to input the modifier. Once the user confirms the 
         * changes, these are then reflected in the model.
         */
      } else if (e.getSource() == manageGui.getOptionButton(6)) {
        int answer = manageGui.modifyDatePrice();
        if (answer != -1) {
          if (answer >= 1 && answer <= 30) {
            double d = manageGui.datePriceModifier(answer);
            if (d >= 0.50 && d <= 1.50) {
              int a = manageGui.confirm();
              if (a == 0) {
                hotel.setDatePriceModifier(d, answer);
              }
            } else {
              manageGui.errorMessage(6);
            }
          } else {
            manageGui.errorMessage(6);
          }
        }
      }
    }
    /**
     * If the user is currently at the view hotel menu, depending on whether 
     * they chose to view the high level or low level information, the corresponding 
     * display frame is shown and the previous frame is disposed of
     */
    if (viewHotel != null) {
      if (e.getSource() == viewHotel.getHighButton()) {
        highLevel = new HighLevelWindow(viewHotel.getHotel().getHotelName(), viewHotel.getHotel().getRoomCount(),
            viewHotel.getHotel().computeTotalEarnings());
        highLevel.setActionListener(this);
        viewHotel.dispose();
      } else if (e.getSource() == viewHotel.getLowButton()) {
        lowLevel = new LowLevelGUI();
        lowLevel.setActionListener(this);
        lowLevel.setDocumentListener(this);
        viewHotel.dispose();
      } else if (e.getSource() == viewHotel.getBackButton()) {
        this.hotel = null;
        hotelList = new HotelListGUI(model.getHotelNames(), 2);
        hotelList.setActionListener(this);
        viewHotel.dispose();
      }
    }
    /**
     * When the user clicks on the "Back" button, the previous menu will be shown.
     */
    if (lowLevel != null) {
      if (e.getSource() == lowLevel.getBackButton()) {
        viewHotel = new ViewHotelGUI(this.hotel);
        viewHotel.setActionListener(this);
        lowLevel.dispose();
      } else if (e.getSource() == lowLevel.getSubmitButton()) {
        if (lowLevel.getText().length() != 0) {
          try {
            /**
             * If the user selects "Available Rooms for Inputted Date" from the drop-down menu, 
             * the user can then input a date (1-31), and upon clicking submit, information about 
             * the number of rooms available on the date is shown. If the input is invalid, an 
             * error message will be shown instead.
             */
            if (lowLevel.getCurrIndex() == 0) {
              if (Integer.parseInt(lowLevel.getText()) >= 1 && Integer.parseInt(lowLevel.getText()) <= 31) {
                lowLevel.option1(model.roomsAvailable(this.hotel, Integer.parseInt(lowLevel.getText())),
                lowLevel.getText());
              } else {
                lowLevel.option1error();
              }
            /**
             * If the user selects "Room Information (Input Room No.)" from the drop-down menu, 
             * the user can then input a room number, and upon clicking submit, information about 
             * the inputted room number will be displayed on a new window. If the input is invalid, 
             * or if the input does not match an existing room number, an error message will be shown instead.
             */
            } else if (lowLevel.getCurrIndex() == 1) {
              if (this.hotel.returnRoom(Integer.parseInt(lowLevel.getText())) != -1) {
                lowLevel.option2(lowLevel.getText(),
                            this.hotel.getRoom(this.hotel.returnRoom(Integer.parseInt(lowLevel.getText()))).getRoomPrice(),
                            this.hotel.getRoom(this.hotel.returnRoom(Integer.parseInt(lowLevel.getText()))).daysAvailable());
              } else {
                lowLevel.option2error();
              }
                    } 
          } catch (NumberFormatException f) {
            lowLevel.blankError();
          }
        /**
         * If the user selects "Reservation Information (Input Code)" from the drop-down 
         * menu, the user can then input a reservation code, and upon clicking submit, 
         * information about the matching reservation will be displayed on a new window. 
         * If the input is invalid, or if the input does not match an existing reservation 
         * code, an error message will be shown instead.	
         */
        if (lowLevel.getCurrIndex() == 2) {
          if (this.hotel.returnReservation(lowLevel.getText()) != -1) {
                  // add discount
            lowLevel.option3(this.hotel.getReservation(this.hotel.returnReservation(lowLevel.getText())));
                } else {
                  lowLevel.option3error();
                }
              }
        } else {
          lowLevel.blankError();
        }

      } else if (e.getSource() == lowLevel.getMenuButton()) {
        this.hotel = null;
        gui = new GUI();
        gui.setActionListener(this);
        lowLevel.dispose();
      }
    }
    /**
     * If the user is currently at the high level information display, depending on whether
     * they choose to return to the main menu, or to go back to the view hotel options, they
     * are directed back to the corresponding displays
     */
    if (highLevel != null) {
      if (e.getSource() == highLevel.getMenuButton()) {
        this.hotel = null;
        gui = new GUI();
        gui.setActionListener(this);
        highLevel.dispose();
      } else if (e.getSource() == highLevel.getBackButton()) {
        viewHotel = new ViewHotelGUI(this.hotel);
        viewHotel.setActionListener(this);
        highLevel.dispose();
      }
    }

  }
  /**
   * The override method included within the document listener interface
   */
  @Override
  public void insertUpdate(DocumentEvent e) {

  }
  /**
   * The override method included within the document listener interface
   */
  @Override
  public void removeUpdate(DocumentEvent e) {

  }
  /**
   * The override method included within the document listener interface
   */
  @Override
  public void changedUpdate(DocumentEvent e) {

  }

}
