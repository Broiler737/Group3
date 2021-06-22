package eu.senla.dao;

import eu.senla.model.guest.GuestsAndRooms;
import eu.senla.model.hotel.Hotel;

public class ProcessingGuestList {

  public GuestsAndRooms[] getGuestsAndRooms(Hotel informationToProcessing) {
    GuestsAndRooms[] guestsAndRooms = new GuestsAndRooms[informationToProcessing.getProcessingGuests()
        .getCountOfRegisteredGuests(informationToProcessing)];
    int tempCounterOfGuests = 0;
    for (int i = 0; i < informationToProcessing.guestDao.getGuestsList().size(); i++) {
      if (!informationToProcessing.guestDao.getGuestsList().get(i).getRegisteredInRoomGuests()
          .isEmpty()) {
        for (int j = 0;
            j < informationToProcessing.guestDao.getGuestsList().get(i)
                .getRegisteredInRoomGuests().size();
            j++) {
          if (informationToProcessing.getGuestDao().getGuestsList().get(i)
              .getRegisteredInRoomGuests().get(j) != null) {
            guestsAndRooms[tempCounterOfGuests] = new GuestsAndRooms(
                informationToProcessing.getGuestDao().getGuestsList().get(i)
                    .getRegisteredInRoomGuests().get(j),
                informationToProcessing.guestDao.getGuestsList().get(i).getRoomNumber());
            tempCounterOfGuests++;
          }
        }
      }
    }
    return guestsAndRooms;
  }
}
