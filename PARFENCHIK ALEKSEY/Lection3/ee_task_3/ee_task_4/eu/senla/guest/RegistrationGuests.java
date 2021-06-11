package eu.senla.guest;

import eu.senla.room.Room;
import java.util.ArrayList;

public class RegistrationGuests {

  final ArrayList<Guest> registeredInRoomGuests = new ArrayList<>();
  int roomNumber;

  public RegistrationGuests(Room room, Guest[] guest) {
    checkInGuest(room, guest);
  }

  public void checkInGuest(Room room, Guest[] guest) {
    for (Guest value : guest) {
      if (registeredInRoomGuests.size() < room.getRoomMaxCapacity()) {
        registeredInRoomGuests.add(value);
        roomNumber = room.getRoomNumber();
        room.setFree(false);
      } else {
        System.out.println("Room " + room.getRoomNumber() + "is full");
      }
    }
  }

  private Guest[] prepareToCheckout(ArrayList<Guest> currentRoomGuests) {
    Guest tempGuest;
    Guest[] tempGuestArray = new Guest[currentRoomGuests.size()];
    for (int i = 0; i < currentRoomGuests.size(); i++) {
      tempGuest = new Guest();
      tempGuest.setGuestPassportNumber(currentRoomGuests.get(i).getGuestPassportNumber());
      tempGuest.setGuestDebt(currentRoomGuests.get(i).getGuestDebt());
      tempGuest.setGuestName(currentRoomGuests.get(i).getGuestName());
      tempGuest.setGuestDurationOfStay(currentRoomGuests.get(i).getGuestDurationOfStay());
      tempGuest.setOrderedServices(currentRoomGuests.get(i).getOrderedServices());
      tempGuest.setGuestCheckOutDate(currentRoomGuests.get(i).getGuestCheckOutDate());
      tempGuest.setGuestCheckInDate(currentRoomGuests.get(i).getGuestCheckInDate());
      tempGuestArray[i] = tempGuest;
    }
    return tempGuestArray;
  }

  public void checkOutGuests(Room room) {
    room.processingArchivedGuests(room, prepareToCheckout(registeredInRoomGuests));
    this.registeredInRoomGuests.clear();
    this.roomNumber = 0;
    room.setFree(true);
  }

  public ArrayList<Guest> getRegisteredInRoomGuests() {
    return registeredInRoomGuests;
  }

  public int getRoomNumber() {
    return roomNumber;
  }
}
