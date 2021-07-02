package eu.senla.service;

import eu.senla.dao.RoomsDao;
import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import java.time.LocalDate;
import java.util.ArrayList;

public class RoomService {

  public void addRoom(Hotel hotel, int roomNumber, int roomMaxCapacity, int roomRating,
      double roomPrice) {
    hotel.getRoomsDao().getRoomsList()
        .add(new Room(roomNumber, roomMaxCapacity, roomRating, roomPrice));
  }

  public Room[] getFreeInFutureRooms(Hotel informationToProcessing, LocalDate dateToCheck) {
    Room[] listOfFreeInFutureRooms;
    ArrayList<Room> tempListOfFreeInFutureRooms = new ArrayList<>(0);
    for (int i = 0; i < informationToProcessing.getRoomsDao().getRoomsList().size(); i++) {
      boolean isAllGuestCheckOut = false;
      for (int j = 0;
          j < informationToProcessing.getRoomsDao().getRoomsList().get(i).getCurrentGuest()
              .size();
          j++) {
        isAllGuestCheckOut = informationToProcessing.getRoomsDao().getRoomsList().get(i)
            .getCurrentGuest().get(j)
            .getCheckOutDate()
            .isBefore(dateToCheck);
      }
      if (isAllGuestCheckOut) {
        tempListOfFreeInFutureRooms
            .add(informationToProcessing.getRoomsDao().getRoomsList().get(i));
      }
    }
    listOfFreeInFutureRooms = tempListOfFreeInFutureRooms.toArray(new Room[]{});
    return listOfFreeInFutureRooms;
  }

  public int getFreeRooms(Hotel hotel) {
    int numberOfFreeRooms = 0;
    Room[] tempHotelRoom = new Room[hotel.getRoomsDao().getRoomsList().size()];
    for (int i = 0; i < hotel.getRoomsDao().getRoomsList().size(); i++) {
      tempHotelRoom[i] = hotel.getRoomsDao().getRoomsList().get(i);
    }
    for (Room roomToCount : tempHotelRoom
    ) {
      if (roomToCount.isFree()) {
        numberOfFreeRooms++;
      }
    }
    return numberOfFreeRooms;
  }

  public Room findRoomByNumber(Hotel hotel, int roomNumber) {
    Room tempRoom = null;
    for (Room hotelRoom : hotel.getRoomsDao().getRoomsList()) {
      if (hotelRoom.getNumber() == roomNumber) {
        tempRoom = hotelRoom;
      }
    }
    return tempRoom;
  }

  public void changeRoomPrice(Room room, double roomPrice) {
    room.setPrice(roomPrice);
    System.out.println("Now room #" + room.getNumber() + " costs " + roomPrice + "$ per night");
  }

  public void changeRoomState(Room room) {
    room.setInService();
    if (room.isInService()) {
      System.out.println("Now room #" + room.getNumber() + " is in service");
    } else {
      System.out.println("Now room #" + room.getNumber() + " is out of service");
    }
  }

  public final void changeRoomRating(Room room, int newRating) {
    room.setRating(newRating);
  }

  public final void changeRoomCapacity(Room room, int newCapacity) {
    room.setMaxCapacity(newCapacity);
  }

  public void processingArchivedGuests(Room roomToCheckOut, Guest[] currentRoomGuest) {
    Guest[][] tempArchivedGuest = new Guest[Room.getHistoryDepth()
        + 1][roomToCheckOut.getMaxCapacity()];
    for (int i = 0; i < roomToCheckOut.getArchivedGuest().length; i++) {
      if (roomToCheckOut.getArchivedGuest()[i] != null) {
        tempArchivedGuest[i + 1] = roomToCheckOut.getArchivedGuest()[i];
      }
    }
    tempArchivedGuest[0] = currentRoomGuest;
    System.out.println();
    for (int i = 0; i < roomToCheckOut.getArchivedGuest().length; i++) {
      roomToCheckOut.getArchivedGuest()[i] = tempArchivedGuest[i];
    }
  }

  public Room selectRoomByNumber(RoomsDao roomsDao, int roomNumber) {
    Room tempRoom = null;
    for (Room rooms : roomsDao.getRoomsList()
    ) {
      if (rooms.getNumber() == roomNumber) {
        tempRoom = rooms;
        break;
      }
    }
    return tempRoom;
  }

  public Room selectSuitableRoom(RoomsDao roomsDao, int countOfGuests, int roomRating) {
    try {
      Room tempRoom = null;
      Room[] tempHotelRoom = new Room[roomsDao.getRoomsList().size()];
      for (int i = 0; i < roomsDao.getRoomsList().size(); i++) {
        tempHotelRoom[i] = roomsDao.getRoomsList().get(i);
      }
      for (Room room : tempHotelRoom) {
        if ((room.getMaxCapacity() >= countOfGuests) && (room.isInService())
            && (room.isFree()) && (room.getRating() >= roomRating)) {
          tempRoom = room;
          System.out.println();
          System.out.println("The suitable room was found");
          break;
        } else {
          if ((room.getMaxCapacity() < countOfGuests)) {
            System.out.println(
                "Room #" + room.getNumber() + " has only " + room.getMaxCapacity()
                    + " places. It's not suitable for " + countOfGuests + " guests");
            System.out.println("The system try to found another room");
            System.out.println();
          }
          if ((room.getRating() < roomRating)) {
            System.out.println(
                "Room #" + room.getNumber() + " has only " + room.getRating()
                    + "-star rating. It's not suitable for guests, who want to live in "
                    + roomRating
                    + "-star rating room");
            System.out.println("The system try to found another room");
            System.out.println();
          }
          if (!room.isFree()) {
            System.out.println(
                "Room #" + room.getNumber()
                    + " is not free. You could't check-in guests inside");
            System.out.println("The system try to found another room");
            System.out.println();
          }
          if (!room.isInService()) {
            System.out.println(
                "Room #" + room.getNumber()
                    + " is out-of-service. You could't check-in guests inside");
            System.out.println("The system try to found another room");
            System.out.println();
          }
        }
      }
      return tempRoom;
    } catch (NullPointerException e) {
      System.out.println("System couldn't find any suitable room ");
      return null;
    }
  }

  public Room findGuestRoom(Hotel informationToProcessing, int guestHash) {
    Room tempRoom = null;
    for (int i = 0; i < informationToProcessing.getRoomsDao().getRoomsList().size(); i++) {
      if (!informationToProcessing.getRoomsDao().getRoomsList().get(i)
          .getCurrentGuest()
          .isEmpty()) {
        for (int j = 0;
            j < informationToProcessing.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest().size();
            j++) {
          if (informationToProcessing.getRoomsDao().getRoomsList().get(i).getCurrentGuest()
              .get(j).hashCode() == guestHash) {
            tempRoom = informationToProcessing.getRoomsDao().getRoomsList().get(i);
            break;
          }
        }
      }
    }
    return tempRoom;
  }
}