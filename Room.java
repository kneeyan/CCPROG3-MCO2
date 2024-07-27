package CasasMurosMCO2Package;

import java.util.*;
/**
 * Represents a room in a hotel
 */
public class Room{
  /** 
   * Represents the room number created by the combination of the hotel number and the 
   * total number of rooms within the hotel
   */
  private int roomNumber;
  /**
   * Represents the reservations made for this room
   */
  private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
  /**
   * Represents the reservation status of this room on the 31 days within the month.
   * If this room is already reserved on a specific day, the value of the array element,
   * with the day-1 being the index, is true.
   */
  private boolean[] reserveStatus = new boolean[31]; 
  /**
   * Represents this room type. 1-Standard, 2-Deluxe, 3-Suite.
   */
  private int roomType;
  private double roomPrice;

  /**
   * Creates a room with the elements needed to assign a room number and price
   * @param roomCount   is the total number of rooms within the hotel
   * @param hotelNumber is the hotel number of the hotel that this room belongs to
   * @param roomType 	is the type of this room
   * @param roomPrice	is the price-per-day of this room
   * @pre roomCount >= 0
   * @pre hotelNumber > 0
   */
  public Room(int roomCount, int hotelNumber, int roomType, double roomPrice){
    this.roomNumber = hotelNumber*100 + roomCount+1;
    this.roomType = roomType; 
    setRoomPrice(roomPrice);
  }
  /**
   * Sets the price-pre-day of this room based on the room type, and base price
   * @param basePrice is the base price-per-day of the hotel this room belongs to
   * @pre basePrice >= 100
   */
  public void setRoomPrice(double basePrice) {
  switch(roomType){
      case 1: this.roomPrice = basePrice; break;
      case 2: this.roomPrice = basePrice*1.2; break;
      case 3: this.roomPrice = basePrice*1.35; break;
    }
  }
  /**
  * Gets the number of this room
  * @return the number of this room
  */
  public int getRoomNumber(){
    return this.roomNumber;
  }
  /**
   * Gets the room type of this room
   * @return the type of this room represented as an integer
   */
  public int getRoomType(){
    return this.roomType;
  }
  /**
   * Gets the price-per-day of this room
   * @return the price-per-day of this room
   */
  public double getRoomPrice(){
    return this.roomPrice;
  }
  /**
  * Gets the reservation status of this room for the month
  * @return the list of the reservation status of this room for the month
  */
  public ArrayList<Reservation> getReservations(){
    return reservations;
  }
  /**
  * Gets the reservation status of this room for a given check-in date
  * @param date is the check-in date of the guest
  * @return the reservation status of this room for the given check-in date
  * @pre date >= 1 && date < 31
  */
  public boolean getReserveStatus(int date){
    return reserveStatus[date-1];
  }
  /**
  * Reserves the dates for this room with the information with the given reservation.
  * This is only done when the reservation is confirmed to be valid.
  * @param reservation is the reservation made by the guest
  * @pre reservation != null
  */
  public void reserveRoom(Reservation reservation){ 
    int i, dates = reservation.getCheckOut() - reservation.getCheckIn();
    reservations.add(reservation);
    for(i=0; i<dates; i++){
      reserveStatus[reservation.getCheckIn()-1+i] = true;
    }
  }
  /**
  * Removes the reservation made by the guest for this room.
  * Initializes the reservation status of this room for the given check-in date to available.
  * @param reservation is the reservation to be deleted.
  * @pre reservation != null
  */
  public void removeReservation(Reservation reservation){
    int i, dates = reservation.getCheckOut() - reservation.getCheckIn();
    for(i=0; i<dates; i++){
      reserveStatus[reservation.getCheckIn()-1+i] = false;
    }
    reservations.remove(reservation);
  }
  /**
   * Gets the days of the month that this room is available
   * @return the string of days that this room is available
   */
  public String daysAvailable() {
    String a = "";
    for (int i = 1; i <= 31; i++) {
      if (this.getReserveStatus(i) == false) {
        a = a + "["+ i +"]"+ " ";
      }
    }
    return a;
  }
}

