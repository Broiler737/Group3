package eu.senla.hotel;

import eu.senla.guest.RegistrationGuests;
import java.util.ArrayList;

public class HotelGuest {

  final ArrayList<RegistrationGuests> hotelGuests = new ArrayList<>();

  public RegistrationGuests getRegisteredGuests(int roomNumber) {
    RegistrationGuests tempRoomAndGuests = null;
    for (RegistrationGuests hotelGuest : this.hotelGuests) {
      if (hotelGuest.getRoomNumber() == roomNumber) {
        tempRoomAndGuests = hotelGuest;
        break;
      }
    }
    return tempRoomAndGuests;
  }

  public int getCountOfRegisteredGuests(Hotel informationToProcessing) {
    int counterOfRegisteredGuests = 0;
    for (int i = 0; i < informationToProcessing.getHotelGuest().getHotelGuests().size(); i++) {
      if (!informationToProcessing.getHotelGuest().getHotelGuests().get(i)
          .getRegisteredInRoomGuests().isEmpty()) {
        for (int j = 0;
            j < informationToProcessing.getHotelGuest().getHotelGuests().get(i)
                .getRegisteredInRoomGuests()
                .size(); j++) {
          if (informationToProcessing.getHotelGuest().getHotelGuests().get(i)
              .getRegisteredInRoomGuests()
              .get(j) != null) {
            counterOfRegisteredGuests++;
          }
        }
      }
    }
    return counterOfRegisteredGuests;
  }

  public ArrayList<RegistrationGuests> getHotelGuests() {
    return hotelGuests;
  }
}
