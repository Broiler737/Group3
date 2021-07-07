package eu.senla.api.print.guest;

import eu.senla.api.print.PrintInformation;
import eu.senla.model.guest.Guest;
import eu.senla.model.room.Room;
import eu.senla.service.GuestService;
import eu.senla.service.RoomService;
import eu.senla.service.ServiceService.OrderedService;
import eu.senla.utils.comparator.guest.ComparatorGuestByDateCheckOutDateAscending;
import eu.senla.utils.comparator.guest.ComparatorGuestByDateCheckOutDateDescending;
import eu.senla.utils.comparator.guest.ComparatorGuestByNameAscending;
import java.util.Arrays;
import java.util.List;

public class PrintGuests {

  public void printGuestCard(PrintInformation printInformation, List<Room> roomList,
      RoomService roomService, GuestService guestService, Guest guest) {
    printCard(guest);
    if (!guest.getOrderedServices().isEmpty()) {
      System.out.println("Services ordered by guest:");
      System.out.println();
      printGuestServices(printInformation, guest);
      System.out
          .println("Guest's debt for services is " + guestService
              .countDebtForServiceOfGuest(guest) + "$");
    } else {
      System.out.println("Guest haven't ordered any service");
    }
    System.out.println(
        "Guest debt is " + guestService
            .countGuestDebt(roomList, roomService, guest,
                guest.hashCode())
            + "$ in this moment");
    System.out.println("********** ********** **********");
  }

  public void printArchivedGuestCard(PrintInformation printInformation, Guest guest) {
    printCard(guest);
    if (!guest.getOrderedServices().isEmpty()) {
      System.out.println("Services ordered by guest:");
      System.out.println();
      printInformation.getPrintGuests()
          .printGuestServices(printInformation, guest);
      System.out.println(
          "Guest debt is " + (guest.getDebt())
              + "$ in this moment");
      System.out.println("********** ********** **********");
    }
  }

  private void printCard(Guest guest) {
    System.out.println("********** Guest card **********");
    System.out.println("Guest name: " + guest.getFullName());
    System.out.println("Guest passport #: " + guest.getPassportNumber());
    System.out.println(
        "Guest check-in date " + guest.getCheckInDate() + " and check-out date "
            + guest.getCheckOutDate());
    System.out.println("Guest duration of stay: " + guest.getDurationOfStay() + " days");
  }

  public void printAllHotelGuestsByRoomNumber(PrintInformation printInformation,
      List<Room> roomList, RoomService roomService, GuestService guestService) {
    for (int i = 0; i < roomList.size(); i++) {
      if (!roomList.get(i).getCurrentGuest().isEmpty()) {
        System.out.println(
            "In room #" + roomList.get(i).getNumber() + " are living these guests:");
        for (int j = 0;
            j < roomList.get(i).getCurrentGuest().size(); j++) {
          printGuestCard(printInformation, roomList, roomService, guestService,
              roomList.get(i).getCurrentGuest().get(j));
          System.out.println();
        }
      }
    }
  }

  public void printGuestsByCheckOutDateAscending(PrintInformation printInformation,
      List<Room> roomList, RoomService roomService, List<Guest> guestsList,
      GuestService guestService) {
    Guest[] tempGuestsArray = guestsList
        .toArray(new Guest[]{});
    Arrays.sort(tempGuestsArray, 0, tempGuestsArray.length,
        new ComparatorGuestByDateCheckOutDateAscending());
    for (Guest guest : tempGuestsArray) {
      System.out.println("Room #" + roomService
          .findGuestRoom(roomList, guest.hashCode())
          .getNumber());
      printGuestCard(printInformation, roomList, roomService, guestService, guest);
    }
  }

  public void printGuestsByCheckOutDateDescending(PrintInformation printInformation,
      List<Room> roomList, RoomService roomService, List<Guest> guestsList,
      GuestService guestService) {
    Guest[] tempGuestsArray = guestsList
        .toArray(new Guest[]{});
    Arrays.sort(tempGuestsArray, 0, tempGuestsArray.length,
        new ComparatorGuestByDateCheckOutDateDescending());
    for (Guest guest : tempGuestsArray) {
      System.out.println("Room #" + roomService
          .findGuestRoom(roomList, guest.hashCode())
          .getNumber());
      printGuestCard(printInformation, roomList, roomService, guestService, guest);
    }
  }

  public void printGuestsByNameAscending(PrintInformation printInformation,
      List<Room> roomList, RoomService roomService, List<Guest> guestsList,
      GuestService guestService) {
    Guest[] tempGuestsArray = guestsList.toArray(new Guest[]{});
    Arrays.sort(tempGuestsArray, 0, tempGuestsArray.length,
        new ComparatorGuestByNameAscending());
    for (Guest guest : tempGuestsArray) {
      System.out
          .println("Room #" + roomService.findGuestRoom(roomList, guest.hashCode()).getNumber());
      printGuestCard(printInformation, roomList, roomService, guestService, guest);
    }
  }

  public void printGuestsByNameDescending(PrintInformation printInformation,
      List<Room> roomList, RoomService roomService, List<Guest> guestsList,
      GuestService guestService) {
    Guest[] tempGuestsArray = guestsList.toArray(new Guest[]{});
    Arrays.sort(tempGuestsArray, 0, tempGuestsArray.length,
        new ComparatorGuestByNameAscending());
    Guest[] tempGuestsReverseArray = new Guest[tempGuestsArray.length];
    for (int i = 0; i < tempGuestsArray.length; i++) {
      tempGuestsReverseArray[i] = tempGuestsArray[tempGuestsArray.length - 1 - i];
    }
    for (Guest guest : tempGuestsReverseArray) {
      System.out
          .println("Room #" + roomService.findGuestRoom(roomList, guest.hashCode()).getNumber());
      printGuestCard(printInformation, roomList, roomService, guestService, guest);
    }
  }

  public void printGuestServices(PrintInformation printInformation, Guest guest) {
    for (OrderedService orderedService : guest.getOrderedServices()) {
      printInformation.getPrintServices()
          .printServiceSimple(orderedService.getOrderedService());
      if (orderedService.getOrderedService().isPerDay()) {
        System.out.println(
            "The guest use this service " + orderedService.getDurationOfUseService() + " days");
      } else {
        System.out.println(
            "The guest use this service " + (orderedService.getCountOfOrderingService())
                + " times");
      }
    }
  }

  public void printRoomArchivedGuests(PrintInformation printInformation, Room room) {
    boolean isAnybodyLivedHere = false;
    for (int i = 0; i < room.getArchivedGuest().length; i++) {
      boolean tempIsAnybodyLivedHere = false;
      for (int j = 0; j < room.getArchivedGuest()[i].length; j++) {
        if (room.getArchivedGuest()[i][j] != null) {
          tempIsAnybodyLivedHere = true;
          break;
        }
      }
      isAnybodyLivedHere = tempIsAnybodyLivedHere;
      if (isAnybodyLivedHere) {
        break;
      }
    }
    if (isAnybodyLivedHere) {
      for (int i = 0; i < room.getArchivedGuest().length; i++) {
        if (room.getArchivedGuest()[i].length == 0) {
          System.out.println("Nobody lived here before previous guest");
          break;
        }
        System.out.println("Guests #" + (i + 1) + " who lived before current guest");
        for (int j = 0; j < room.getArchivedGuest()[i].length; j++) {
          if (room.getArchivedGuest()[i][j] != null) {
            printInformation.getPrintGuests()
                .printArchivedGuestCard(printInformation, room.getArchivedGuest()[i][j]);
          }
        }
      }
    } else {
      System.out.println("Nobody lived here before");
    }
  }
}
