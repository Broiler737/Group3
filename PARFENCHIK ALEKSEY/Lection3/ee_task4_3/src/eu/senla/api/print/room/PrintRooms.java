package eu.senla.api.print.room;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.utils.comparator.room.ComparatorRoomByCapacityAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByCapacityDescending;
import eu.senla.utils.comparator.room.ComparatorRoomByPriceAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByPriceDescending;
import eu.senla.utils.comparator.room.ComparatorRoomByRatingAscending;
import eu.senla.utils.comparator.room.ComparatorRoomByRatingDescending;
import java.util.Arrays;

public class PrintRooms {

  public void printRoomDetails(Hotel hotelInformationToPrint, Room room) {
    System.out.println();
    System.out.println("########## Room #" + room.getRoomNumber() + " details ##########");
    System.out.println("Room Number #" + room.getRoomNumber());
    System.out.println("The room has " + room.getRoomRating() + "-star rating");
    System.out.println("Maximum guests in room is " + room.getRoomMaxCapacity() + " guests");
    System.out.println("Price per night in this room is " + room.getRoomPrice() + "$");
    System.out.println("Is this room in service? - " + room.isInService());
    System.out.println("Is this room free? - " + room.isFree());
    System.out.println("These guests were lived in  in this room before:");
    hotelInformationToPrint.printInformation.getPrintGuests()
        .printRoomArchivedGuests(hotelInformationToPrint, room);
  }

  public void printHotelRoomsByRatingAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      hotelInformationToPrint.printInformation.getPrintRooms()
          .printRoomDetails(hotelInformationToPrint, roomToPrint);
    }
  }

  public void printHotelRoomsByRatingDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      hotelInformationToPrint.printInformation.getPrintRooms()
          .printRoomDetails(hotelInformationToPrint, roomToPrint);
    }
  }

  public void printHotelRoomsByPriceAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      hotelInformationToPrint.printInformation.getPrintRooms()
          .printRoomDetails(hotelInformationToPrint, roomToPrint);
    }
  }

  public void printHotelRoomsByPriceDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      hotelInformationToPrint.printInformation.getPrintRooms()
          .printRoomDetails(hotelInformationToPrint, roomToPrint);
    }
  }

  public void printHotelFreeRoomsByCapacityAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRooms()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByCapacityDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRooms()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByPriceAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRooms()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByPriceDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByPriceDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRooms()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByRatingAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRooms()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }

  public void printHotelFreeRoomsByRatingDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByRatingDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      if (roomToPrint.isFree()) {
        hotelInformationToPrint.printInformation.getPrintRooms()
            .printRoomDetails(hotelInformationToPrint, roomToPrint);
      }
    }
  }

  public void printHotelRoomsByCapacityAscending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityAscending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      hotelInformationToPrint.printInformation.getPrintRooms()
          .printRoomDetails(hotelInformationToPrint, roomToPrint);
    }
  }

  public void printHotelRoomsByCapacityDescending(Hotel hotelInformationToPrint) {
    Room[] tempHotelRoom = new Room[hotelInformationToPrint.roomsDao.getRoomsList().size()];
    for (int i = 0; i < hotelInformationToPrint.roomsDao.getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotelInformationToPrint.roomsDao.getRoomsList().get(i);
    }
    Arrays.sort(tempHotelRoom, 0, tempHotelRoom.length, new ComparatorRoomByCapacityDescending());
    for (Room roomToPrint : tempHotelRoom
    ) {
      hotelInformationToPrint.printInformation.getPrintRooms()
          .printRoomDetails(hotelInformationToPrint, roomToPrint);
    }
  }
}
