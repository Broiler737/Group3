package eu.senla.service;

import eu.senla.dao.GuestList;
import eu.senla.model.guest.RegistrationGuests;
import eu.senla.model.hotel.Hotel;

public class ProcessingGuests {

  private final GuestList guestList;

  public ProcessingGuests(GuestList guestList) {
    this.guestList = guestList;
  }

  public RegistrationGuests getRegisteredGuests(int roomNumber) {
    RegistrationGuests tempRoomAndGuests = null;
    for (RegistrationGuests hotelGuest : guestList.getHotelGuests()) {
      if (hotelGuest.getRoomNumber() == roomNumber) {
        tempRoomAndGuests = hotelGuest;
        break;
      }
    }
    return tempRoomAndGuests;
  }

  public int getCountOfRegisteredGuests(Hotel informationToProcessing) {
    int counterOfRegisteredGuests = 0;
    for (int i = 0; i < informationToProcessing.getGuestList().getHotelGuests().size(); i++) {
      if (!informationToProcessing.getGuestList().getHotelGuests().get(i)
          .getRegisteredInRoomGuests().isEmpty()) {
        for (int j = 0;
            j < informationToProcessing.getGuestList().getHotelGuests().get(i)
                .getRegisteredInRoomGuests()
                .size(); j++) {
          if (informationToProcessing.getGuestList().getHotelGuests().get(i)
              .getRegisteredInRoomGuests()
              .get(j) != null) {
            counterOfRegisteredGuests++;
          }
        }
      }
    }
    return counterOfRegisteredGuests;
  }
}