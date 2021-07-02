package eu.senla.api.print;

import eu.senla.api.print.guest.PrintGuests;
import eu.senla.api.print.hotel.PrintHotel;
import eu.senla.api.print.room.PrintRooms;
import eu.senla.api.print.service.PrintServices;
import eu.senla.model.guest.Guest;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import eu.senla.service.GuestService;
import eu.senla.service.RoomService;
import eu.senla.service.ServiceService;
import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

public class PrintInformation {

  protected final PrintHotel printHotel = new PrintHotel();
  protected final PrintServices printServices = new PrintServices();
  protected final PrintGuests printGuests = new PrintGuests();
  protected final PrintRooms printRooms = new PrintRooms();

  public PrintInformation() {
  }

  public void printInformation(RoomService roomService, List<Room> roomList,
      GuestService guestService, List<Guest> guestList,
      ServiceService serviceService,
      TreeMap<Integer, Service> servicesList) {
    //Simple test of work classes and methods
    System.out.println("Print results of check-out guests");
    printGuests.printAllHotelGuestsByRoomNumber(this, roomList, roomService, guestService);
    System.out.println();
    System.out.println("Print list of hotel rooms by price");
    printRooms.printHotelRoomsByPriceAscending(this, roomList);
    System.out.println();
    printRooms.printHotelRoomsByPriceDescending(this, roomList);
    System.out.println();
    System.out.println("Print list of hotel rooms by capacity");
    printRooms.printHotelRoomsByCapacityAscending(this, roomList);
    System.out.println();
    printRooms.printHotelRoomsByCapacityDescending(this, roomList);
    System.out.println();
    System.out.println("Print list of hotel rooms by rating");
    printRooms.printHotelRoomsByRatingAscending(this, roomList);
    System.out.println();
    printRooms.printHotelRoomsByRatingDescending(this, roomList);
    System.out.println();
    System.out.println("Print list of hotel free rooms by price");
    printRooms.printHotelFreeRoomsByPriceAscending(this, roomList);
    System.out.println();
    printRooms.printHotelFreeRoomsByPriceDescending(this, roomList);
    System.out.println();
    System.out.println("Print list of hotel free rooms by capacity");
    printRooms.printHotelFreeRoomsByCapacityAscending(this, roomList);
    System.out.println();
    printRooms.printHotelFreeRoomsByCapacityDescending(this, roomList);
    System.out.println();
    System.out.println("Print list of hotel free rooms by rating");
    printRooms.printHotelFreeRoomsByRatingAscending(this, roomList);
    System.out.println();
    printRooms.printHotelFreeRoomsByRatingDescending(this, roomList);
    System.out.println();
    System.out.println("printGuestsByName");
    printGuests.printGuestsByNameAscending(this, roomList, roomService, guestList, guestService);
    System.out.println();
    printGuests.printGuestsByNameDescending(this, roomList, roomService, guestList, guestService);
    System.out.println();
    System.out.println("printGuestsByCheckOutDate");
    printGuests
        .printGuestsByCheckOutDateAscending(this, roomList, roomService, guestList, guestService);
    System.out.println();
    printGuests
        .printGuestsByCheckOutDateDescending(this, roomList, roomService, guestList, guestService);
    System.out.println();
    System.out.println("Count of free rooms in hotel");
    printHotel.printCountOfFreeRoomsInHotel(roomList, roomService);
    System.out.println();
    System.out.println("Count of registered guests in hotel");
    printHotel.printCountOfHotelGuests(roomList, guestService);
    System.out.println();
    System.out.println("PrintListOfFreeInFutureRoomsInHotel");
    printHotel.printListOfFreeInFutureRoomsInHotel(this, roomList, roomService,
        LocalDate.of(2021, 7, 19));
    System.out.println();
    System.out.println("printGuestCard and debt");
    printGuests.printGuestCard(this, roomList, roomService, guestService, guestService
        .selectGuestByName(roomList, "Mike"));
    System.out.println();
    System.out.println("printGuestServicesByNameAscending");
    printServices.printGuestServicesByNameDescending(guestService, roomList,
        guestService.selectGuestByName(roomList, "Nick").hashCode());
    System.out.println();
    System.out.println("printGuestServicesByPriceAscending");
    printServices.printGuestByNameServicesByPriceAscending(guestService, roomList, "Monica");
    System.out.println();
    printServices.printGuestServicesByPriceAscending(roomList.get(7).getCurrentGuest().get(0));
    System.out.println();
    printServices.printGuestByNameServicesByPriceDescending(guestService, roomList, "Margaret");
    System.out.println();
    printServices.printGuestServicesByPriceDescending(roomList.get(5).getCurrentGuest().get(1));
    printServices.printServicesByNameAscending(serviceService, servicesList);
    printServices.printServicesByNameDescending(serviceService, servicesList);
    System.out.println();
    printServices.printServicesByPriceAscending(serviceService, servicesList);
    printServices.printServicesByPriceDescending(serviceService, servicesList);
    System.out.println();
    printServices.printServicesByTypeAscending(serviceService, servicesList);
    printServices.printServicesByTypeDescending(serviceService, servicesList);
    printRooms.printRoomDetails(this, roomService.findRoomByNumber(roomList, 2));
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


