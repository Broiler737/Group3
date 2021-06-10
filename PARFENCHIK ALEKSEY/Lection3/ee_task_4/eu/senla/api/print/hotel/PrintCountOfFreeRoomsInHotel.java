package eu.senla.api.print.hotel;

import eu.senla.hotel.Hotel;

public class PrintCountOfFreeRoomsInHotel {

  public void printCountOfFreeRoomsInHotel(Hotel hotel) {
    int countOfFreeRooms = hotel.hotelRooms.getFreeRooms();
    System.out.println("At this moment " + countOfFreeRooms + " free rooms in hotel");
  }
}
