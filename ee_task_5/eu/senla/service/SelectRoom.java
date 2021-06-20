package eu.senla.service;

import eu.senla.model.guest.GuestsAndRooms;
import eu.senla.model.hotel.Hotel;
import eu.senla.dao.RoomsList;
import eu.senla.model.room.Room;

public class SelectRoom {

  public SelectRoom() {
  }

  public Room selectRoomByNumber(RoomsList roomsList, int roomNumber) {
    Room tempRoom = null;
    for (Room rooms : roomsList.getHotelRoom()
    ) {
      if (rooms.getRoomNumber() == roomNumber) {
        tempRoom = rooms;
        break;
      }
    }
    return tempRoom;
  }

  public Room selectSuitableRoom(RoomsList roomsList, int countOfGuests, int roomRating) {
    try {


    Room tempRoom = null;
    Room[] tempHotelRoom = new Room[roomsList.getHotelRoom().size()];
    for (int i = 0; i < roomsList.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = roomsList.getHotelRoom().get(i);
    }
    for (Room room : tempHotelRoom) {
      if ((room.getRoomMaxCapacity() >= countOfGuests) && (room.isInService())
          && (room.isFree()) && (room.getRoomRating() >= roomRating)) {
        tempRoom = room;
        System.out.println();
        System.out.println("The suitable room was found");
        break;
      } else {

        if ((room.getRoomMaxCapacity() < countOfGuests)) {
          System.out.println(
              "Room #" + room.getRoomNumber() + " has only " + room.getRoomMaxCapacity()
                  + " places. It's not suitable for " + countOfGuests + " guests");
          System.out.println("The system try to found another room");
          System.out.println();
        }
        if ((room.getRoomRating() < roomRating)) {
          System.out.println(
              "Room #" + room.getRoomNumber() + " has only " + room.getRoomRating()
                  + "-star rating. It's not suitable for guests, who want to live in " + roomRating
                  + "-star rating room");
          System.out.println("The system try to found another room");
          System.out.println();
        }
        if (!room.isFree()) {
          System.out.println(
              "Room #" + room.getRoomNumber() + " is not free. You could't check-in guests inside");
          System.out.println("The system try to found another room");
          System.out.println();
        }
        if (!room.isInService()) {
          System.out.println(
              "Room #" + room.getRoomNumber()
                  + " is out-of-service. You could't check-in guests inside");
          System.out.println("The system try to found another room");
          System.out.println();
        }
      }
    }
      return tempRoom;
    }catch (NullPointerException e){
      System.out.println("System couldn't find any suitable room ");
      return null;
    }

  }



    public Room findGuestRoom(Hotel informationToProcessing, int guestHash) {
      Room tempRoom = null;
      int tempRoomNumber = 0;
      GuestsAndRooms[] tempGuestListGuestsAndRoomsArray = informationToProcessing.processingGuestList
          .getGuestsAndRooms(informationToProcessing);
      for (GuestsAndRooms guestsAndRooms : tempGuestListGuestsAndRoomsArray) {
        if (guestsAndRooms.getGuest().hashCode() == guestHash) {
          tempRoomNumber = guestsAndRooms.getRoomNumber();
        }
        tempRoom = informationToProcessing.getProcessingRooms().findRoomByNumber(tempRoomNumber);
      }
      return tempRoom;
    }

}