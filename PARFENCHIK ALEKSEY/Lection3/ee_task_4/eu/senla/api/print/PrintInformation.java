package eu.senla.api.print;

import eu.senla.api.print.guest.PrintAllHotelGuestsByRoomNumber;
import eu.senla.api.print.guest.PrintGuestCard;
import eu.senla.api.print.guest.PrintGuestsByCheckOutDate;
import eu.senla.api.print.guest.PrintGuestsByName;
import eu.senla.api.print.guest.PrintRoomArchivedGuests;
import eu.senla.api.print.hotel.PrintCountOfFreeRoomsInHotel;
import eu.senla.api.print.hotel.PrintCountOfHotelGuests;
import eu.senla.api.print.hotel.PrintListOfFreeInFutureRoomsInHotel;
import eu.senla.api.print.room.PrintHotelFreeRoomsByCapacity;
import eu.senla.api.print.room.PrintHotelFreeRoomsByPrice;
import eu.senla.api.print.room.PrintHotelFreeRoomsByRating;
import eu.senla.api.print.room.PrintHotelRoomsByCapacity;
import eu.senla.api.print.room.PrintHotelRoomsByPrice;
import eu.senla.api.print.room.PrintHotelRoomsByRating;
import eu.senla.api.print.room.PrintRoomDetails;
import eu.senla.api.print.service.PrintGuestServicesByName;
import eu.senla.api.print.service.PrintGuestServicesByPrice;
import eu.senla.api.print.service.PrintServiceDetails;
import eu.senla.api.print.service.PrintServicesByName;
import eu.senla.api.print.service.PrintServicesByPrice;
import eu.senla.api.print.service.PrintServicesByType;
import eu.senla.hotel.Hotel;
import java.time.LocalDate;

public class PrintInformation {

  protected final PrintGuestsByName printGuestsByName = new PrintGuestsByName();
  protected final PrintServicesByName printServicesByName = new PrintServicesByName();
  protected final PrintServicesByPrice printServicesByPrice = new PrintServicesByPrice();
  protected final PrintServicesByType printServicesByType = new PrintServicesByType();
  protected final PrintServiceDetails printServiceDetails = new PrintServiceDetails();
  protected final PrintGuestCard printGuestCard = new PrintGuestCard();
  protected final PrintGuestsByCheckOutDate printGuestsByCheckOutDate = new PrintGuestsByCheckOutDate();
  protected final PrintRoomDetails printRoomDetails = new PrintRoomDetails();
  protected final PrintRoomArchivedGuests printRoomArchivedGuests = new PrintRoomArchivedGuests();
  protected final PrintHotelRoomsByPrice printHotelRoomsByPrice = new PrintHotelRoomsByPrice();
  protected final PrintHotelRoomsByCapacity printHotelRoomsByCapacity = new PrintHotelRoomsByCapacity();
  protected final PrintHotelRoomsByRating printHotelRoomsByRating = new PrintHotelRoomsByRating();
  protected final PrintHotelFreeRoomsByPrice printHotelFreeRoomsByPrice = new PrintHotelFreeRoomsByPrice();
  protected final PrintHotelFreeRoomsByCapacity printHotelFreeRoomsByCapacity = new PrintHotelFreeRoomsByCapacity();
  protected final PrintHotelFreeRoomsByRating printHotelFreeRoomsByRating = new PrintHotelFreeRoomsByRating();
  protected final PrintAllHotelGuestsByRoomNumber printAllHotelGuestsByRoomNumber = new PrintAllHotelGuestsByRoomNumber();
  protected final PrintCountOfHotelGuests printCountOfHotelGuests = new PrintCountOfHotelGuests();
  protected final PrintCountOfFreeRoomsInHotel printCountOfFreeRoomsInHotel = new PrintCountOfFreeRoomsInHotel();
  protected final PrintListOfFreeInFutureRoomsInHotel printListOfFreeInFutureRoomsInHotel = new PrintListOfFreeInFutureRoomsInHotel();
  protected final PrintGuestServicesByName printGuestServicesByName = new PrintGuestServicesByName();
  protected final PrintGuestServicesByPrice printGuestServicesByPrice = new PrintGuestServicesByPrice();

  public PrintInformation() {
  }

  public void printInformation(Hotel hotelInformationToPrint) {
    //Simple test of work classes and methods
    System.out.println("Print results of check-out guests");
    printAllHotelGuestsByRoomNumber.printAllHotelGuestsByRoomNumber(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel rooms by price");
    printHotelRoomsByPrice.printHotelRoomsByPriceAscending(hotelInformationToPrint);
    System.out.println();
    printHotelRoomsByPrice.printHotelRoomsByPriceDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel rooms by capacity");
    printHotelRoomsByCapacity.printHotelRoomsByCapacityAscending(hotelInformationToPrint);
    System.out.println();
    printHotelRoomsByCapacity.printHotelRoomsByCapacityDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel rooms by rating");
    printHotelRoomsByRating.printHotelRoomsByRatingAscending(hotelInformationToPrint);
    System.out.println();
    printHotelRoomsByRating.printHotelRoomsByRatingDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel free rooms by price");
    printHotelFreeRoomsByPrice.printHotelFreeRoomsByPriceAscending(hotelInformationToPrint);
    System.out.println();
    printHotelFreeRoomsByPrice.printHotelFreeRoomsByPriceDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel free rooms by capacity");
    printHotelFreeRoomsByCapacity.printHotelFreeRoomsByCapacityAscending(hotelInformationToPrint);
    System.out.println();
    printHotelFreeRoomsByCapacity.printHotelFreeRoomsByCapacityDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel free rooms by rating");
    printHotelFreeRoomsByRating.printHotelFreeRoomsByRatingAscending(hotelInformationToPrint);
    System.out.println();
    printHotelFreeRoomsByRating.printHotelFreeRoomsByRatingDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("printGuestsByName");
    printGuestsByName.printGuestsByNameAscending(hotelInformationToPrint);
    System.out.println();
    printGuestsByName.printGuestsByNameDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("printGuestsByCheckOutDate");
    printGuestsByCheckOutDate.printGuestsByCheckOutDateAscending(hotelInformationToPrint);
    System.out.println();
    printGuestsByCheckOutDate.printGuestsByCheckOutDateDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Count of free rooms in hotel");
    printCountOfFreeRoomsInHotel.printCountOfFreeRoomsInHotel(hotelInformationToPrint);
    System.out.println();
    System.out.println("Count of registered guests in hotel");
    printCountOfHotelGuests.printCountOfHotelGuests(hotelInformationToPrint);
    System.out.println();
    System.out.println("PrintListOfFreeInFutureRoomsInHotel");
    printListOfFreeInFutureRoomsInHotel
        .printListOfFreeInFutureRoomsInHotel(hotelInformationToPrint, LocalDate.of(2021,
            6, 19));
    System.out.println();
    System.out.println("printGuestCard and debt");
    printGuestCard.printGuestCard(hotelInformationToPrint,
        hotelInformationToPrint.getGuestInRoom(hotelInformationToPrint, "Mike"));
    System.out.println();
    System.out.println("printGuestServicesByNameAscending");
    printGuestServicesByName
        .printGuestByNameServicesByNameAscending(hotelInformationToPrint, "Margaret");
    System.out.println();
    printGuestServicesByName
        .printGuestServicesByNameAscending(hotelInformationToPrint,
            hotelInformationToPrint.hotelGuest.getHotelGuests().get(4).getRegisteredInRoomGuests()
                .get(1));
    System.out.println();
    printGuestServicesByName
        .printGuestByNameServicesByNameDescending(hotelInformationToPrint, "Margaret");
    System.out.println();
    printGuestServicesByName
        .printGuestServicesByNameDescending(hotelInformationToPrint,
            hotelInformationToPrint.hotelGuest.getHotelGuests().get(4).getRegisteredInRoomGuests()
                .get(1));
    System.out.println();
    System.out.println("printGuestServicesByPriceAscending");
    printGuestServicesByPrice
        .printGuestByNameServicesByPriceAscending(hotelInformationToPrint, "Margaret");
    System.out.println();
    printGuestServicesByPrice.printGuestServicesByPriceAscending(hotelInformationToPrint,
        hotelInformationToPrint.hotelGuest.getHotelGuests().get(4).getRegisteredInRoomGuests()
            .get(1));
    System.out.println();
    printGuestServicesByPrice
        .printGuestByNameServicesByPriceDescending(hotelInformationToPrint, "Margaret");
    System.out.println();
    printGuestServicesByPrice.printGuestServicesByPriceDescending(hotelInformationToPrint,
        hotelInformationToPrint.hotelGuest.getHotelGuests().get(4).getRegisteredInRoomGuests()
            .get(1));
    printServicesByName
        .printServicesByNameAscending(hotelInformationToPrint, hotelInformationToPrint.services);
    printServicesByName
        .printServicesByNameDescending(hotelInformationToPrint, hotelInformationToPrint.services);
    System.out.println();
    printServicesByPrice
        .printServicesByPriceAscending(hotelInformationToPrint, hotelInformationToPrint.services);
    printServicesByPrice
        .printServicesByPriceDescending(hotelInformationToPrint, hotelInformationToPrint.services);
    System.out.println();
    printServicesByType
        .printServicesByTypeAscending(hotelInformationToPrint, hotelInformationToPrint.services);
    printServicesByType
        .printServicesByTypeDescending(hotelInformationToPrint, hotelInformationToPrint.services);
    printRoomDetails.printRoomDetails(hotelInformationToPrint,
        hotelInformationToPrint.hotelRooms.findRoomByNumber(2));
  }

  public PrintServiceDetails getPrintServiceDetails() {
    return printServiceDetails;
  }

  public PrintGuestCard getPrintGuestCard() {
    return printGuestCard;
  }

  public PrintRoomDetails getPrintRoomDetails() {
    return printRoomDetails;
  }

  public PrintRoomArchivedGuests getPrintRoomArchivedGuests() {
    return printRoomArchivedGuests;
  }

  public PrintAllHotelGuestsByRoomNumber getPrintAllHotelGuestsByRoomNumber() {
    return printAllHotelGuestsByRoomNumber;
  }

}


