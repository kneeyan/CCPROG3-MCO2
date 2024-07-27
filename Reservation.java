package CasasMurosMCO2Package;

/** 
 * Represents a reservation made by a customer
 */
public class Reservation{
  private String guestName;
  private int checkIn;
  private int checkOut;
  private Room room;
  /** 
   * Represents the hotel the reservation is made for 
   */
  private Hotel hotel;
  private double totalPrice;
  /** 
   * Represents the unique reservation code which would be generated through the 
   * combination of the room number, check-in date, and check-out date
   */ 
  private String reservationCode;
  private int hasDiscount;

  /** 
  * Creates a reservation which immediately assigned the values of the 
  * guestName, checkIn, checkOut, room, hotel, and totalPrice of this reservation
  * @param guestName  the name of the guest booking the reservation
  * @param checkIn    the check-in date of this reservation from 1 to 30
  * @param checkOut   the check-out date of this reservation from 2 to 31
  * @param room       is the room this reservation is made for
  * @param hotel      is the hotel this reservation is made for
  * @pre checkIn and checkOut are both valid dates
  * @pre room != null
  */
  public Reservation(String guestName, int checkIn, int checkOut, Room room, Hotel hotel){
    this.guestName = guestName;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.room = room;
    this.hotel  = hotel;
    this.totalPrice = 0;
    this.hasDiscount = 0;
    /** 
    * computes the total price of the reservation by multiplying 
    * the base price of the room by the number of days of stay 
    */
    for (int i = checkIn; i < checkOut; i++){
      this.totalPrice = this.totalPrice + (room.getRoomPrice() * hotel.getDatePriceModifier(i));
    }
  }
  /** 
  * Gets the name of the guest booking this reservation
  * @return the name of the guest booking this reservation
  */
  public String getName(){
    return this.guestName;
  }
  /** 
  * Gets the name of the hotel this reservation was made for
  * @return the hotel this reservation is made for
  */
  public Hotel getHotel(){
    return this.hotel;
  }
  /** 
  * Gets the check-in date of this reservation
  * @return the check-in date of this reservation from 1 to 30
  */
  public int getCheckIn(){
    return this.checkIn;
  }
  /** 
  * Gets the check-out date of this reservation
  * @return the check-out date of this reservation from 2 to 31
  */
  public int getCheckOut(){
    return this.checkOut;
  }
  /** 
  * Gets the room of this reservation
  * @return the room this reservation is made for
  */
  public Room getRoom(){
    return this.room;
  }
  /** 
  * Gets the total price of this reservation
  * @return the total price of this reservation based on the base 
  *         price of the room and the number of days of stay
  */
  public double getTotalPrice(){
    return this.totalPrice;
  }
  /** 
  * Gets the total price of this reservation
  * @return the total price of this reservation based on the base 
  *         price of the room and the number of days of stay
  */
  public void setTotalPrice(double totalPrice){
    this.totalPrice = totalPrice;
  }
  /** 
  * Gets the unique reservation code of this reservation
  * @return the unique reservation code of this reservation 
  */
  public String getReservationCode(){
    return this.reservationCode;
  }
  /** 
  * Assigns the created reservation code to this reservation
  * @param reservationCode  the unique reservation code of this reservation which
  *                         is generated through the combination of the room number, 
  *                         check-in date, and check-out date
  */
  public void setReservationCode(String code){
    this.reservationCode = code;
  }
  /**
   * Gets the discount type of the reservation
   * @return the discount type of the reservation
   */
  public int getHasDiscount(){
    return hasDiscount;
  }
  /**
   * Sets the reservation to indicate the discount type
   * @param hasDiscount is the discount type for the reservation
   */
  public void setHasDiscount(int hasDiscount){
    this.hasDiscount = hasDiscount;
  }

}
