package eu.senla.hotel;

import eu.senla.guest.RegistrationGuests;
import eu.senla.room.Room;
import java.time.LocalDate;
import java.util.ArrayList;

public class HotelRooms {

  final ArrayList<Room> hotelRoom = new ArrayList<>();

  public Room[] getFreeInFutureRooms(Hotel informationToProcessing, LocalDate dateToCheck) {
    RegistrationGuests[] tempHotelRoom;
    tempHotelRoom = informationToProcessing.hotelGuest.getHotelGuests()
        .toArray(new RegistrationGuests[]{});
    ArrayList<Room> tempListOfFreeInFutureRooms = new ArrayList<>(0);
    Room[] listOfFreeInFutureRooms;
    for (int i = 0; i < tempHotelRoom.length; i++) {
      boolean isAllGuestCheckOut = false;
      for (int j = 0;
          j < informationToProcessing.hotelGuest.getHotelGuests().get(i).getRegisteredInRoomGuests()
              .size();
          j++) {
        isAllGuestCheckOut = tempHotelRoom[i].getRegisteredInRoomGuests().get(j)
            .getGuestCheckOutDate()
            .isBefore(dateToCheck);
      }
      if (isAllGuestCheckOut) {
        tempListOfFreeInFutureRooms.add(informationToProcessing.hotelRooms.hotelRoom.get(0)
            .selectRoomByNumber(informationToProcessing.hotelRooms,
                informationToProcessing.hotelGuest.getHotelGuests().get(i).getRoomNumber()));
      }
    }
    listOfFreeInFutureRooms = tempListOfFreeInFutureRooms.toArray(new Room[]{});
    return listOfFreeInFutureRooms;
  }

  public int getFreeRooms() {
    int numberOfFreeRooms = 0;
    Room[] tempHotelRoom = new Room[this.hotelRoom.size()];
    for (int i = 0; i < this.hotelRoom.size(); i++) {
      tempHotelRoom[i] = this.hotelRoom.get(i);
    }
    for (Room roomToCount : tempHotelRoom
    ) {
      if (roomToCount.isFree()) {
        numberOfFreeRooms++;
      }
    }
    return numberOfFreeRooms;
  }

  public ArrayList<Room> getHotelRoom() {
    return hotelRoom;
  }

  public Room findRoomByNumber(int roomNumber) {
    Room tempRoom = null;
    for (Room hotelRoom : this.hotelRoom) {
      if (hotelRoom.getRoomNumber() == roomNumber) {
        tempRoom = hotelRoom;
      }
    }
    return tempRoom;
  }
}

