package eu.senla.api.print.hotel;

import eu.senla.api.print.PrintInformation;
import eu.senla.model.room.Room;
import eu.senla.service.GuestService;
import eu.senla.service.RoomService;
import java.time.LocalDate;
import java.util.List;

public class PrintHotel {

  public void printCountOfFreeRoomsInHotel(List<Room> roomList, RoomService roomService) {
    int countOfFreeRooms = roomService.getFreeRooms(roomList);
    System.out.println("At this moment " + countOfFreeRooms + " free rooms in hotel");
  }

  public void printCountOfHotelGuests(List<Room> roomList, GuestService guestService) {
    int counter;
    counter = guestService.getCountOfRegisteredGuests(roomList);
    System.out
        .println("In hotel has been registered and living " + counter + " guests at this moment");
  }

  public void printListOfFreeInFutureRoomsInHotel(PrintInformation printInformation,
      List<Room> roomList, RoomService roomService, LocalDate dateToCheck) {
    Room[] tempRoomArray = roomService.getFreeInFutureRooms(roomList, dateToCheck);
    System.out.println(
        "At " + dateToCheck + " in hotel, will be free these rooms:");
    for (Room roomToPrint : tempRoomArray
    ) {
      printInformation.getPrintRooms().printRoomDetails(printInformation, roomToPrint);
    }
  }
}
