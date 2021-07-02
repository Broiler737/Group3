package eu.senla.api.print.room;

import eu.senla.api.print.PrintInformation;
import eu.senla.model.room.Room;
import eu.senla.utils.comparator.room.ComparatorRoomByCapacityAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByCapacityDescending;
import eu.senla.utils.comparator.room.ComparatorRoomByPriceAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByPriceDescending;
import eu.senla.utils.comparator.room.ComparatorRoomByRatingAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByRatingDescending;
import java.util.Arrays;
import java.util.List;

public class PrintRooms {

  public void printRoomDetails(PrintInformation printInformation, Room room) {
    System.out.println();
    System.out.println("########## Room #" + room.getNumber() + " details ##########");
    System.out.println("Room Number #" + room.getNumber());
    System.out.println("The room has " + room.getRating() + "-star rating");
    System.out.println("Maximum guests in room is " + room.getMaxCapacity() + " guests");
    System.out.println("Price per night in this room is " + room.getPrice() + "$");
    System.out.println("Is this room in service? - " + room.isInService());
    System.out.println("Is this room free? - " + room.isFree());
    System.out.println("These guests were lived in  in this room before:");
    printInformation.getPrintGuests()
        .printRoomArchivedGuests(printInformation, room);
  }

  public void printHotelRoomsByRatingAscending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      printRoomDetails(printInformation, roomToPrint);
    }
  }

  public void printHotelRoomsByRatingDescending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      printRoomDetails(printInformation, roomToPrint);
    }
  }

  public void printHotelRoomsByPriceAscending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      printRoomDetails(printInformation, roomToPrint);
    }
  }

  public void printHotelRoomsByPriceDescending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      printRoomDetails(printInformation, roomToPrint);
    }
  }

  public void printHotelFreeRoomsByCapacityAscending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        printRoomDetails(printInformation, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByCapacityDescending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        printRoomDetails(printInformation, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByPriceAscending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        printRoomDetails(printInformation, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByPriceDescending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        printRoomDetails(printInformation, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByRatingAscending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        printRoomDetails(printInformation, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByRatingDescending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        printRoomDetails(printInformation, roomToPrint);
      }
    }
  }

  public void printHotelRoomsByCapacityAscending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      printRoomDetails(printInformation, roomToPrint);
    }
  }

  public void printHotelRoomsByCapacityDescending(PrintInformation printInformation,
      List<Room> roomList) {
    Room[] tempHotelRoom = new Room[roomList.size()];
    for (int i = 0; i < roomList.size(); i++) {
      tempHotelRoom[i] = roomList.get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      printRoomDetails(printInformation, roomToPrint);
    }
  }
}
