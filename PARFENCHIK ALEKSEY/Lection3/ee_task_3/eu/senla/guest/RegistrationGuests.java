package eu.senla.guest;

import eu.senla.room.Room;
import java.util.ArrayList;

public class RegistrationGuests {

  private final ArrayList<Guest> currentRoomGuests = new ArrayList<>();
  private int roomNumber;

  public RegistrationGuests(Room room, Guest[] guest) {
    checkInGuest(room, guest);
  }


  public void checkInGuest(Room room, Guest[] guest) {
    for (Guest value : guest) {
      if (currentRoomGuests.size() < room.getRoomMaxCapacity()) {
        currentRoomGuests.add(value);
        roomNumber = room.getRoomNumber();
        room.setFree(false);
      } else {
        System.out.println("Room " + room.getRoomMaxCapacity() + "is full");
      }
    }
  }

  private Guest[] prepareToCheckout(ArrayList<Guest> currentRoomGuests) {
    Guest tempGuest;
    Guest[] tempGuestArray = new Guest[currentRoomGuests.size()];
    for (int i = 0; i < currentRoomGuests.size(); i++) {
      tempGuest = new Guest();
      tempGuest.setGuestPassportNumber(currentRoomGuests.get(i).getGuestPassportNumber());
      tempGuest.setGuestName(currentRoomGuests.get(i).getGuestName());
      tempGuest.setGuestDurationOfStay(currentRoomGuests.get(i).getGuestDurationOfStay());
      tempGuest.setGuestCheckOutDate(currentRoomGuests.get(i).getGuestCheckOutDate());
      tempGuest.setGuestCheckInDate(currentRoomGuests.get(i).getGuestCheckInDate());
      tempGuestArray[i] = tempGuest;
    }
    return tempGuestArray;
  }

  public void checkOutGuests(Room room) {
    room.processingArchivedGuests(room, prepareToCheckout(currentRoomGuests));
    this.currentRoomGuests.clear();
    this.roomNumber = 0;
    room.setFree(true);
  }

  public ArrayList<Guest> getCurrentRoomGuests() {
    return currentRoomGuests;
  }

  public int getRoomNumber() {
    return roomNumber;
  }
}
