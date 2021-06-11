package eu.senla.dao;

import eu.senla.guest.GuestsAndRooms;
import eu.senla.hotel.Hotel;

public class ProcessingGuestList {

  public GuestsAndRooms[] getGuestsAndRooms(Hotel informationToProcessing) {
    GuestsAndRooms[] guestsAndRooms = new GuestsAndRooms[informationToProcessing.hotelGuest
        .getCountOfRegisteredGuests(informationToProcessing)];
    int tempCounterOfGuests = 0;
    for (int i = 0; i < informationToProcessing.hotelGuest.getHotelGuests().size(); i++) {
      if (!informationToProcessing.hotelGuest.getHotelGuests().get(i).getRegisteredInRoomGuests()
          .isEmpty()) {
        for (int j = 0;
            j < informationToProcessing.hotelGuest.getHotelGuests().get(i)
                .getRegisteredInRoomGuests().size();
            j++) {
          if (informationToProcessing.getHotelGuest().getHotelGuests().get(i)
              .getRegisteredInRoomGuests().get(j) != null) {
            guestsAndRooms[tempCounterOfGuests] = new GuestsAndRooms(
                informationToProcessing.getHotelGuest().getHotelGuests().get(i)
                    .getRegisteredInRoomGuests().get(j),
                informationToProcessing.hotelGuest.getHotelGuests().get(i).getRoomNumber());
            tempCounterOfGuests++;
          }
        }
      }
    }
    return guestsAndRooms;
  }
}
