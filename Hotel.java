package CasasMurosMCO2Package;

import java.util.*;
/** 
 * Represents a hotel within the system.
 */
public class Hotel{
  private String hotelName;
  /** 
  * Represents the number of the hotel based on then number of hotels already made,
  * irrespective to the actual number of hotels in the system.
  */
  private int hotelNumber; 
  private int roomCount=0;
  private ArrayList<Room> rooms = new ArrayList<Room>();
  private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
  /** 
   * Represents the standard base price for all the rooms within the hotel.
   */
  private double roomBasePrice = 1299.0;
  private double[] datePriceModifiers = new double[31];

  /**
  * Creates a hotel which immediately has a name, hotel number, and at least one room.
  * Automatically sets the price modifier within the datePriceModifiers array to 1.0
  * @param name         is the name of this hotel.
  * @param hotelNumber  is the number of this hotel.
  * @pre name != null
  * @pre hotelNumber > 0
  */
  public Hotel(String name, int hotelNumber){
    this.hotelName = name;
    this.hotelNumber = hotelNumber;

    int i;
    for(i=0; i<31; i++){
      datePriceModifiers[i] = 1.0;
    }
  }
  /**
  * Assigns a name to this hotel.
  * @param name  is the intended name of this hotel.
  */
  public void setHotelName(String name){
    this.hotelName = name;
  }
  /**
  * Assigns a number to this hotel.
  * @param number  is the intended number of this hotel.
  */
  public void setHotelNumber(int number){
    this.hotelNumber = number;
  }
  /**
  * Sets the base price of all the rooms within this hotel
  * @param price  is the new base price of all the rooms within this hotel.
  * @pre price >= 100.0
  */
  public void setRoomBasePrice(double price){
    this.roomBasePrice = price;
    for(Room room: rooms) {
      room.setRoomPrice(price);
    }
  }
  /**
   * Sets the price modifier to the given check-in date
   * @param modifier is the new modifier for the given date
   * @param checkIn	 is the check-in date to modify the price of
   * @pre 0.50 <= modifier <= 1.50
   * @pre 1 <= checkIn <= 30
   */
  public void setDatePriceModifier(double modifier, int checkIn){
    this.datePriceModifiers[checkIn-1] = modifier;
  }
  /**
  * Gets the name of this hotel.
  * @return the name of this hotel.
  */
  public String getHotelName(){
    return this.hotelName;
  }
  /**
  * Gets the number of this hotel.
  * @return the number of this hotel.
  */
  public int getHotelNumber(){
    return this.hotelNumber;
  }
  /**
  * Gets the number of rooms present within this hotel.
  * @return the number of rooms present within this hotel.
  */
  public int getRoomCount(){
    return this.roomCount;
  }
  /**
  * Gets a specified room present at this hotel.
  * @param index is the index at which the room is located at within the list
  * @return the room that was located at the specified index.
  * @pre 0 <= index <= rooms.size()-1
  */
  public Room getRoom(int index){
    return rooms.get(index);
  }
  /**
  * Gets the full list of rooms present at this hotel
  * @return the full list of rooms present at this hotel.
  */
  public ArrayList<Room> getRooms(){
    return this.rooms;
  }
  /**
   * Returns the room given the room number
   * @param roomNumber of the room you wish to find
   * @return the room with the given room number
   */
  public int returnRoom(int roomNumber) {
    int index=-1, i=0;
    while (index==-1 && i<this.getRoomCount()) {
        if (this.getRoom(i).getRoomNumber() == roomNumber) {
          index = i;
        }
        i++;
      }
    return index;
  }
  /**
  * Gets a specified reservation present at this hotel.
  * @param index is the index which the reservation is located at within the list.
  * @return the reservation that was located at the specified index.
  * @pre 0 <= index <= reservations.size()-1
  */
  public Reservation getReservation(int index){
    return reservations.get(index);
  }
  /**
  * Gets the full list of reservations present at this hotel.
  * @return the full list of reservations present at this hotel.
  */
  public ArrayList<Reservation> getReservations(){
    return this.reservations;
  }
  /**
   * Gets the reservation with the matching reservation code
   * @param reservationCode is the code of the reservation you wish to find
   * @return the reservation with the corresponding code
   */
  public int returnReservation(String reservationCode) {
    int index=-1, i=0;
    while (index==-1 && i<this.getReservationCount()) {
        if (this.getReservation(i).getReservationCode().equalsIgnoreCase(reservationCode)) {
          index = i;
        }
        i++;
      }
    return index;
  }
  /**
  * Gives the total number of reservations made at this hotel.
  * @return the total number of reservations made at this hotel.
  */
  public int getReservationCount(){
    return this.reservations.size();
  }
  /**
  * Gets the base price of all the rooms within this hotel.
  * @return the base price of all the rooms within this hotel.
  */
  public double getRoomBasePrice(){
    return this.roomBasePrice;
  }
  /**
   * Gets the price modifier of the given check in date
   * @param checkIn is the date the user wishes to get the modifier of
   * @return the price modifier of the given date
   */
  public double getDatePriceModifier(int checkIn){
    return this.datePriceModifiers[checkIn-1];
  }
  /**
   * Gets the array of modifiers for each date
   * @return the array of date-price modifiers
   */
  public double[] getDatePriceModifiers(){
    return this.datePriceModifiers;
  }
  /**
  * Adds rooms to this hotel.
  * @param quantity is the number of rooms to be added.
  * @param type 	is the type of the room to be added
  */
  public void addRoom(int quantity, int type){
    this.roomCount = rooms.size();
    for(int i=0; i<quantity; i++){
      rooms.add(new Room(this.roomCount, this.hotelNumber, type, this.roomBasePrice));
      this.roomCount+=1;
    }
  }
  /**
  * Adds a reservation to the list of reservations for this hotel.
  * @param reservation is the reservation to be added.
  * @pre reservation != null
  */
  public void addReservation(Reservation reservation){
    reservations.add(reservation);
  }
  /**
  * Adds a reservation to the list of reservations for this hotel.
  * @param reservation is the reservation to be added.
  * @pre reservation != null
  */
  public void reserveRoom(Reservation reservation){
    reservations.add(reservation);
    reservation.getRoom().reserveRoom(reservation);
  }
  /**
  * Removes a room within the list of rooms in this hotel.
  * @param index  is the index of the room to be removed.
  * @pre index >= 0 and index <= rooms.size()-1
  */
  public void removeRoom(int index){
    rooms.remove(index);
    this.roomCount--;
  }
  /**
  * Removes a reservation from the list of reservations for this hotel.
  * @param index  is the index of the reservation to be removed.
  * @pre index >= 0 and index <= reservations.size()-1
  */
  public void removeReservation(int index){
    reservations.remove(index);
  }
  /**
  * Computes the total earnings of this hotel by getting the sum of all
  * total prices from the reservations made within their list.
  * @return the total earnings of this hotel.
  */
  public double computeTotalEarnings(){
    int size = reservations.size();
    int i;
    double sum=0.0;
    for(i=0; i<size; i++){
      sum += reservations.get(i).getTotalPrice();
    }
    return sum;
  }


}