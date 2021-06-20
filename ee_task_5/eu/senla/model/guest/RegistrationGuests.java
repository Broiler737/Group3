package eu.senla.model.guest;

import eu.senla.utils.userinput.ProcessUserInput;
import eu.senla.model.room.Room;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegistrationGuests {

  final ArrayList<Guest> registeredInRoomGuests = new ArrayList<>();
  int roomNumber;

  public RegistrationGuests(ProcessUserInput processUserInput, Room room, int countOfGuests) {
    checkInGuest(room, prepareToCheckIn(processUserInput, countOfGuests));
  }

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

  public void checkOutGuests(Room room) {
    room.processingArchivedGuests(room, prepareToCheckOut(registeredInRoomGuests));
    this.registeredInRoomGuests.clear();
    this.roomNumber = 0;
    room.setFree(true);
  }

  public Guest[] prepareToCheckIn(ProcessUserInput processUserInput, int countOfGuests) {
    Guest[] tempGuestArray = new Guest[countOfGuests];
    String guestName = null;
    boolean isRight = false;
    for (int i = 0; i < tempGuestArray.length; i++) {
      System.out.println("Please enter " + (i + 1) + " guest name");
      guestName = processUserInput.processUserStringInput();
      System.out.println("Please enter " + (i + 1) + " guest passport number");
      String guestPassportNumber = processUserInput.processUserStringInput();
      System.out.println("Please enter " + (i + 1) + " guest check-in date");
      LocalDate guestCheckInDate = processUserInput.processUserDateInput();
      System.out.println("Please enter " + (i + 1) + " guest duration of stay");
      Integer guestDurationOfStay = processUserInput.processUserIntegerNumericInput();
      tempGuestArray[i] = new Guest(guestName, guestPassportNumber, guestCheckInDate,
          guestDurationOfStay);
    }
    return tempGuestArray;
  }

  private Guest[] prepareToCheckOut(ArrayList<Guest> currentRoomGuests) {
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


  public ArrayList<Guest> getRegisteredInRoomGuests() {
    return registeredInRoomGuests;
  }

  public int getRoomNumber() {
    return roomNumber;
  }
}
