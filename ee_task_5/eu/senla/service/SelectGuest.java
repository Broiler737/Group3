package eu.senla.service;

import eu.senla.model.guest.Guest;
import eu.senla.model.guest.GuestsAndRooms;
import eu.senla.model.hotel.Hotel;

public class SelectGuest {

  public SelectGuest() {
  }

  public Guest selectGuestByName(Hotel informationToProcessing, String guestName) {
    Guest tempGuest = null;
    GuestsAndRooms[] tempGuestAndRoomArray = informationToProcessing.processingGuestList
        .getGuestsAndRooms(informationToProcessing);
    for (GuestsAndRooms guestsAndRooms : tempGuestAndRoomArray) {
      if (guestsAndRooms.getGuest().getGuestName().equals(guestName)) {
        tempGuest = guestsAndRooms.getGuest();
        break;
      }
    }
    return tempGuest;
  }

  public Guest findGuestByHash(Hotel informationToProcessing, int guestHash) {
    Guest tempGuest = null;
    for (int i = 0; i < informationToProcessing.guestList.getHotelGuests().size(); i++) {
      for (int j = 0;
          j < informationToProcessing.guestList.getHotelGuests().get(i).getRegisteredInRoomGuests()
              .size(); j++) {
        if (informationToProcessing.guestList.getHotelGuests().get(i).getRegisteredInRoomGuests()
            .get(j).hashCode() == guestHash) {
          tempGuest = informationToProcessing.guestList.getHotelGuests().get(i)
              .getRegisteredInRoomGuests().get(j);
        }
      }
    }
    return tempGuest;
  }

}