package eu.senla.service;

import eu.senla.dao.RoomsList;
import eu.senla.model.guest.RegistrationGuests;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import java.time.LocalDate;
import java.util.ArrayList;

public class ProcessingRooms {

  private final RoomsList roomsList;

  public ProcessingRooms(RoomsList roomsList) {
    this.roomsList = roomsList;
  }

  public Room[] getFreeInFutureRooms(Hotel informationToProcessing, LocalDate dateToCheck) {
    RegistrationGuests[] tempHotelRoom;
    tempHotelRoom = informationToProcessing.guestList.getHotelGuests()
        .toArray(new RegistrationGuests[]{});
    ArrayList<Room> tempListOfFreeInFutureRooms = new ArrayList<Room>(0);
    Room[] listOfFreeInFutureRooms;
    for (int i = 0; i < tempHotelRoom.length; i++) {
      boolean isAllGuestCheckOut = false;
      for (int j = 0;
          j < informationToProcessing.guestList.getHotelGuests().get(i).getRegisteredInRoomGuests()
              .size();
          j++) {
        isAllGuestCheckOut = tempHotelRoom[i].getRegisteredInRoomGuests().get(j)
            .getGuestCheckOutDate()
            .isBefore(dateToCheck);
      }
      if (isAllGuestCheckOut) {
        tempListOfFreeInFutureRooms.add(informationToProcessing.getRoomsList().getHotelRoom().get(0)
            .selectRoomByNumber(informationToProcessing.roomsList,
                informationToProcessing.guestList.getHotelGuests().get(i).getRoomNumber()));
      }
    }
    listOfFreeInFutureRooms = tempListOfFreeInFutureRooms.toArray(new Room[]{});
    return listOfFreeInFutureRooms;
  }

  public int getFreeRooms() {
    int numberOfFreeRooms = 0;
    Room[] tempHotelRoom = new Room[roomsList.getHotelRoom().size()];
    for (int i = 0; i < roomsList.getHotelRoom().size(); i++) {
      tempHotelRoom[i] = roomsList.getHotelRoom().get(i);
    }
    for (Room roomToCount : tempHotelRoom
    ) {
      if (roomToCount.isFree()) {
        numberOfFreeRooms++;
      }
    }
    return numberOfFreeRooms;
  }

  public Room findRoomByNumber(int roomNumber) {
    Room tempRoom = null;
    for (Room hotelRoom : roomsList.getHotelRoom()) {
      if (hotelRoom.getRoomNumber() == roomNumber) {
        tempRoom = hotelRoom;
      }
    }
    return tempRoom;
  }
}