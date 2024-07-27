package CasasMurosMCO2Package;
import java.util.*;

/**
 * Represents the system which holds the created hotels
 */
public class Model {
private ArrayList<Hotel>hotels;
/**
 * Creates a model with an empty array list of hotels
 */
public Model() {
  this.hotels = new ArrayList<Hotel>();
}
/**
 * Gets the names of the hotel existing within this system
 * @return list of names of the hotels
 */
public String[] getHotelNames() {
  String[] A = new String[hotels.size()];
  for (int i = 0; i < hotels.size(); i++) {
    A[i] = hotels.get(i).getHotelName();
  }
  return A;
}
/**
 * Checks if the given string is already a pre-existing hotel
 * @param A is the name of the hotel
 * @return true if the hotel does not already exist in this system, false if otherwise
 */
public Boolean hotelNameCheck(String A) {
  Boolean retval = true;
  for (int i = 0; i < hotels.size(); i++) {
    if (hotels.get(i).getHotelName().equals(A))
      retval = false;
  }
  return retval;
}
/**
 * Adds a hotel to this system
 * @param hotel is the hotel to be added
 */
public void addHotel(Hotel hotel) {
  hotels.add(hotel);
}
/**
 * Gets the number of hotels existing within this system
 * @return the number of hotels already existing within this system
 */
public int getTotalHotelCount() {
  return hotels.size();
}
/**
 * Removes the given hotel from this system
 * @param hotel to be removed from this system
 */
public void removeHotel(Hotel hotel) {
  this.hotels.remove(hotel);
}
/**
 * Gets the hotel at the specified index from the list
 * @param index is the index where the targeted hotel is located at
 * @return the hotel at the specified given index
 */
public Hotel getHotel(int index) {
  return hotels.get(index);
}
/**
 * Gets the index of the given hotel within this system
 * @param hotel is the hotel the user wishes to get the index of
 * @return the index of the given hotel from the array list
 */
public int getHotelIndex(Hotel hotel) {
  return this.hotels.indexOf(hotel);
}
/**
 * Replaces the hotel at the given index with the given hotel
 * @param index is the index of the hotel to be replaced
 * @param hotel is the new hotel to replace the previous
 */
public void setHotelIndex(int index, Hotel hotel) {
  this.hotels.set(index, hotel);
}
/**
 * Gets the number of available rooms at the given hotel for the given date
 * @param hotel is the hotel to check the availability for the rooms
 * @param date is the check-in date of the user
 * @return the number of available rooms at the given hotel for the given check-in date
 */
public int roomsAvailable(Hotel hotel, int date) {
  int count = 0;
  for (int i = 0; i < hotel.getRoomCount(); i++) {
    if (hotel.getRoom(i).getReserveStatus(date) == false) {
      count++;
    }
  }
  return count;
}
/**
 * Checks whether the given check-in and check-out dates are valid
 * @param nIn is the check-in date
 * @param nOut is the check-out date
 * @return true if the dates are valid, false if otherwise
 */
public Boolean validateDate(int nIn, int nOut) {
  if (nOut > nIn && nOut <= 31 && nOut >= 1 && nIn <= 31 && nIn >=1) {
    return true;
  } else {
    return false;
  }
}
/**
 * Books a specific room type for the given check-in to check-out date with the given
 * customer name, within the given hotel.
 * @param hotel    is the hotel to book a room at
 * @param checkIn  is the check-in date of the user
 * @param checkOut is the check-out date of the user
 * @param name	   is the name of the user
 * @param roomType is the type of room to book
 * @return the room number of the successful booking, and -1 if the booking was unsuccessful
 */
public int bookRoom(Hotel hotel, int checkIn, int checkOut, String name, int roomType){
    boolean isDateValid,
            isRoomAvailable;
    /** 
     * Represents the number of the room assigned to this booking
     */
    int roomAssignment, 
        i, j;
    String reserveCode;
    isDateValid = false;
    isRoomAvailable = false;
    roomAssignment = 0;

    if (checkOut - checkIn > 0){
      if (checkIn >= 1 && checkIn < 31 && checkOut > 1 && checkOut <= 31){
        isDateValid = true;
        /** 
         * Checks if the specific dates between the check-in and check-out are available.
         * If the dates for that room are not available, it moves on to check the next available
         * room in the hotel. 
         */
        for (i = 0; i < hotel.getRoomCount(); i++){
          if (hotel.getRoom(i).getRoomType() == roomType){ 
            isRoomAvailable = true;
            for(j=checkIn; j<checkOut; j++){
              if(hotel.getRoom(i).getReserveStatus(j)){
                isRoomAvailable = false;
              }
            }
            if(isRoomAvailable){
              roomAssignment = i+1;
              break;
            } 
          }
        }
      }
    }
    /**
     * If the date is valid and the chosen room is available, the reservation is added to the room
     */
    if (isDateValid && isRoomAvailable){
      reserveCode = ""+roomAssignment+checkIn+checkOut;
      hotel.addReservation(new Reservation(name, checkIn, checkOut, hotel.getRoom(roomAssignment-1), hotel));
      hotel.getReservation(hotel.getReservationCount()-1).setReservationCode(reserveCode);
      hotel.getRoom(roomAssignment-1).reserveRoom(hotel.getReservation(hotel.getReservationCount()-1));
      return roomAssignment;
    } 
    else {
      return -1;
    }
  }
/**
 * Checks if the given string input is a valid discount code
 * @param input is the input discount code to be validated
 * @param hotel is the hotel to make reservation 
 * @param nIn   is the check-in date for the reservation
 * @param nOut  is the check-out date for the reservation
 * @return the designated number for a valid discount code, returns -1 if the code is invalid
 */
public int checkDiscount(String input, Hotel hotel, int nIn, int nOut){
    int retval = -1;

    if (input.equals("I_WORK_HERE")){
      retval = 1;
    } else if (input.equals("STAY4_GET1")){
      if (nOut - nIn >= 5){
        retval = 2;
      } 
    } else if (input.equals("PAYDAY")){
      if (nIn <=15 && nOut > 15 || nIn <=30 && nOut > 30) {
        retval = 3;
      } 
    }
    return retval;
}
/**
 * Updates the reservation price based on the discount type
 * @param type  is the discount type to be applied on the reservation
 * @param hotel is the hotel to apply the discount to
 */
public void updateReservationWithDiscount(int type, Hotel hotel) {
  switch (type) {
    case 1:
      hotel.getReservation(hotel.getReservationCount()-1).setTotalPrice(hotel.getReservation(hotel.getReservationCount()-1).getTotalPrice() * 0.9);
        hotel.getReservation(hotel.getReservationCount()-1).setHasDiscount(1);
        break;
    case 2:
      double temp =  hotel.getReservation(hotel.getReservationCount()-1).getRoom().getRoomPrice() *  hotel.getDatePriceModifier( hotel.getReservation(hotel.getReservationCount()-1).getCheckIn());
        hotel.getReservation(hotel.getReservationCount()-1).setTotalPrice(hotel.getReservation(hotel.getReservationCount()-1).getTotalPrice()-temp);
        hotel.getReservation(hotel.getReservationCount()-1).setHasDiscount(2);
        break;
    case 3:
      hotel.getReservation(hotel.getReservationCount()-1).setTotalPrice(hotel.getReservation(hotel.getReservationCount()-1).getTotalPrice() * 0.93);
        hotel.getReservation(hotel.getReservationCount()-1).setHasDiscount(3);
        break;
  }
}
/**
 * Creates a designated reservation code for the given reservation
 * @param roomAssignment is the room the reservation is for
 * @param checkIn		 is the check-in date for the reservation
 * @param checkOut		 is the check-out date for the reservation
 * @return the created reservation code
 */
public String createReserveCode(int roomAssignment, int checkIn, int checkOut) {
  return ""+roomAssignment+checkIn+checkOut;
}

}

