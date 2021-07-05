package eu.senla.api.print;

import eu.senla.hotel.Hotel;

public class PrintInformation {

  private final PrintServiceDetails printServiceDetails = new PrintServiceDetails();
  private final PrintGuestCard printGuestCard = new PrintGuestCard();
  private final PrintAllHotelGuestsByRoomNumber printAllHotelGuestsByRoomNumber = new PrintAllHotelGuestsByRoomNumber();

  public PrintInformation() {
  }

  public PrintServiceDetails getPrintServiceDetails() {
    return printServiceDetails;
  }

  public PrintGuestCard getPrintGuestCard() {
    return printGuestCard;
  }

  public PrintAllHotelGuestsByRoomNumber getPrintAllHotelGuestsByRoomNumber() {
    return printAllHotelGuestsByRoomNumber;
  }

  public void printInformation(Hotel hotelInformationToPrint) {
    System.out.println("Print results of check-out guests");
    printAllHotelGuestsByRoomNumber.printAllHotelGuestsByRoomNumber(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print information about one of guests");
    printGuestCard.printGuestCard(
        hotelInformationToPrint.getHotelGuest().getHotelGuests().get(1).getCurrentRoomGuests()
            .get(0));
  }
}

