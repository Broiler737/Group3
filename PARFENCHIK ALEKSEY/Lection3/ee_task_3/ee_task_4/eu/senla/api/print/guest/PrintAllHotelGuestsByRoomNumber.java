package eu.senla.api.print.guest;

import eu.senla.model.hotel.Hotel;

public class PrintAllHotelGuestsByRoomNumber {

  public void printAllHotelGuestsByRoomNumber(Hotel hotelInformationToPrint) {
    for (int i = 0; i < hotelInformationToPrint.getGuestDao().getGuestsList().size(); i++) {
      if (!hotelInformationToPrint.getGuestDao().getGuestsList().get(i)
          .getRegisteredInRoomGuests()
          .isEmpty()) {
        System.out.println(
            "In room #" + hotelInformationToPrint.getGuestDao().getGuestsList().get(i)
                .getRoomNumber()
                + " are living these guests:");
        for (int j = 0;
            j < hotelInformationToPrint.getGuestDao().getGuestsList().get(i)
                .getRegisteredInRoomGuests().size();
            j++) {
          hotelInformationToPrint.getPrintInformation().getPrintGuestCard()
              .printGuestCard(hotelInformationToPrint,
                  hotelInformationToPrint.getGuestDao().getGuestsList().get(i)
                      .getRegisteredInRoomGuests().get(j));
          System.out.println();
        }
      }
    }
  }

}
