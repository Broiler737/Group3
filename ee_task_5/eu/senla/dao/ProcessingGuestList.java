package eu.senla.dao;

import eu.senla.model.guest.GuestsAndRooms;
import eu.senla.model.hotel.Hotel;

public class ProcessingGuestList {

  public GuestsAndRooms[] getGuestsAndRooms(Hotel informationToProcessing) {
    GuestsAndRooms[] guestsAndRooms = new GuestsAndRooms[informationToProcessing.getProcessingGuests()
        .getCountOfRegisteredGuests(informationToProcessing)];
    int tempCounterOfGuests = 0;
    for (int i = 0; i < informationToProcessing.guestList.getHotelGuests().size(); i++) {
      if (!informationToProcessing.guestList.getHotelGuests().get(i).getRegisteredInRoomGuests()
          .isEmpty()) {
        for (int j = 0;
            j < informationToProcessing.guestList.getHotelGuests().get(i)
                .getRegisteredInRoomGuests().size();
            j++) {
          if (informationToProcessing.getGuestList().getHotelGuests().get(i)
              .getRegisteredInRoomGuests().get(j) != null) {
            guestsAndRooms[tempCounterOfGuests] = new GuestsAndRooms(
                informationToProcessing.getGuestList().getHotelGuests().get(i)
                    .getRegisteredInRoomGuests().get(j),
                informationToProcessing.guestList.getHotelGuests().get(i).getRoomNumber());
            tempCounterOfGuests++;
          }
        }
      }
    }
    return guestsAndRooms;
  }
}
