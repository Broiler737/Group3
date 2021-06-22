package eu.senla.api.print.hotel;

import eu.senla.model.hotel.Hotel;

public class PrintCountOfFreeRoomsInHotel {

  public void printCountOfFreeRoomsInHotel(Hotel hotel) {
    int countOfFreeRooms = hotel.getProcessingRooms().getFreeRooms();
    System.out.println("At this moment " + countOfFreeRooms + " free rooms in hotel");
  }
}
