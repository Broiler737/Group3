package eu.senla.api.print.hotel;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import java.time.LocalDate;

public class PrintHotel {

  public void printCountOfFreeRoomsInHotel(Hotel hotel) {
    int countOfFreeRooms = hotel.getRoomService().getFreeRooms();
    System.out.println("At this moment " + countOfFreeRooms + " free rooms in hotel");
  }

  public void printCountOfHotelGuests(Hotel informationToProcessing) {
    int counter;
    counter = informationToProcessing.getGuestService()
        .getCountOfRegisteredGuests(informationToProcessing);
    System.out
        .println("In hotel has been registered and living " + counter + " guests at this moment");
  }

  public void printListOfFreeInFutureRoomsInHotel(Hotel hotel, LocalDate dateToCheck) {
    Room[] tempRoomArray = hotel.getRoomService().getFreeInFutureRooms(hotel, dateToCheck);
    System.out.println(
        "At " + dateToCheck + " in hotel, will be free these rooms:");
    for (Room roomToPrint : tempRoomArray
    ) {
      hotel.printInformation.getPrintRooms().printRoomDetails(hotel, roomToPrint);
    }
  }
}
