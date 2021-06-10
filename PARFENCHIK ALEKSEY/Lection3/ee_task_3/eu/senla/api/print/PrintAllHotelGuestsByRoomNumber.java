package eu.senla.api.print;

import eu.senla.hotel.Hotel;

public class PrintAllHotelGuestsByRoomNumber {

  public void printAllHotelGuestsByRoomNumber(Hotel hotelInformationToPrint) {
    for (int i = 0; i < hotelInformationToPrint.getHotelGuest().getHotelGuests().size(); i++) {
      if (!hotelInformationToPrint.getHotelGuest().getHotelGuests().get(i).getCurrentRoomGuests()
          .isEmpty()) {
        System.out.println();
        System.out.println(
            "In room #" + hotelInformationToPrint.getHotelGuest().getHotelGuests().get(i)
                .getRoomNumber()
                + " are living these guests:");
        for (int j = 0;
            j < hotelInformationToPrint.getHotelGuest().getHotelGuests().get(i)
                .getCurrentRoomGuests().size();
            j++) {
          hotelInformationToPrint.getPrintInformation().getPrintGuestCard()
              .printGuestCard(
                  hotelInformationToPrint.getHotelGuest().getHotelGuests().get(i)
                      .getCurrentRoomGuests().get(j));
          System.out.println();
        }
      }
    }
  }
}
