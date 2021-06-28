package eu.senla.api.print;

import eu.senla.api.print.guest.PrintGuests;
import eu.senla.api.print.hotel.PrintHotel;
import eu.senla.api.print.room.PrintRooms;
import eu.senla.api.print.service.PrintServices;
import eu.senla.model.hotel.Hotel;
import java.time.LocalDate;

public class PrintInformation {

  protected final PrintHotel printHotel = new PrintHotel();
  protected final PrintServices printServices = new PrintServices();
  protected final PrintGuests printGuests = new PrintGuests();
  protected final PrintRooms printRooms = new PrintRooms();

  public PrintInformation() {
  }

  public void printInformation(Hotel hotelInformationToPrint) {
    //Simple test of work classes and methods
    System.out.println("Print results of check-out guests");
    hotelInformationToPrint.getPrintInformation().getPrintGuests()
        .printAllHotelGuestsByRoomNumber(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel rooms by price");
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelRoomsByPriceAscending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelRoomsByPriceDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel rooms by capacity");
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelRoomsByCapacityAscending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelRoomsByCapacityDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel rooms by rating");
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelRoomsByRatingAscending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelRoomsByRatingDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel free rooms by price");
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelFreeRoomsByPriceAscending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelFreeRoomsByPriceDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel free rooms by capacity");
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelFreeRoomsByCapacityAscending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelFreeRoomsByCapacityDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Print list of hotel free rooms by rating");
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelFreeRoomsByRatingAscending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintRooms()
        .printHotelFreeRoomsByRatingDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("printGuestsByName");
    hotelInformationToPrint.getPrintInformation().getPrintGuests()
        .printGuestsByNameAscending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintGuests()
        .printGuestsByNameDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("printGuestsByCheckOutDate");
    hotelInformationToPrint.getPrintInformation().getPrintGuests()
        .printGuestsByCheckOutDateAscending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintGuests()
        .printGuestsByCheckOutDateDescending(hotelInformationToPrint);
    System.out.println();
    System.out.println("Count of free rooms in hotel");
    printHotel.printCountOfFreeRoomsInHotel(hotelInformationToPrint);
    System.out.println();
    System.out.println("Count of registered guests in hotel");
    hotelInformationToPrint.getPrintInformation().getPrintHotel()
        .printCountOfHotelGuests(hotelInformationToPrint);
    System.out.println();
    System.out.println("PrintListOfFreeInFutureRoomsInHotel");
    hotelInformationToPrint.getPrintInformation().getPrintHotel()
        .printListOfFreeInFutureRoomsInHotel(hotelInformationToPrint, LocalDate.of(2021,
            7, 19));
    System.out.println();
    System.out.println("printGuestCard and debt");
    printGuests.printGuestCard(hotelInformationToPrint,
        hotelInformationToPrint.getGuestService()
            .selectGuestByName(hotelInformationToPrint, "Mike"));
    System.out.println();
    System.out.println("printGuestServicesByNameAscending");
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printGuestServicesByNameDescending(hotelInformationToPrint,
            hotelInformationToPrint.getGuestService()
                .selectGuestByName(hotelInformationToPrint, "Nick").hashCode());
    System.out.println();
    System.out.println("printGuestServicesByPriceAscending");
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printGuestByNameServicesByPriceAscending(hotelInformationToPrint, "Monica");
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printGuestServicesByPriceAscending(hotelInformationToPrint,
            hotelInformationToPrint.getRoomsDao().getRoomsList().get(7).getRoomCurrentGuest()
                .get(0));
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printGuestByNameServicesByPriceDescending(hotelInformationToPrint, "Margaret");
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printGuestServicesByPriceDescending(hotelInformationToPrint,
            hotelInformationToPrint.getRoomsDao().getRoomsList().get(5).getRoomCurrentGuest()
                .get(1));
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printServicesByNameAscending(hotelInformationToPrint);
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printServicesByNameDescending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printServicesByPriceAscending(hotelInformationToPrint);
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printServicesByPriceDescending(hotelInformationToPrint);
    System.out.println();
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printServicesByTypeAscending(hotelInformationToPrint);
    hotelInformationToPrint.getPrintInformation().getPrintServices()
        .printServicesByTypeDescending(hotelInformationToPrint);
    printRooms.printRoomDetails(hotelInformationToPrint,
        hotelInformationToPrint.getRoomService().findRoomByNumber(2));
  }

  public PrintServices getPrintServices() {
    return printServices;
  }

  public PrintGuests getPrintGuests() {
    return printGuests;
  }

  public PrintRooms getPrintRooms() {
    return printRooms;
  }

  public PrintHotel getPrintHotel() {
    return printHotel;
  }

}


