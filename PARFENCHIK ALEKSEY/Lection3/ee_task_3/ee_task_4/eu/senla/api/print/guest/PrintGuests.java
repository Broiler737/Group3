package eu.senla.api.print.guest;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.service.ServiceService.OrderedService;
import eu.senla.utils.comparator.guest.ComparatorGuestByDateCheckOutDateAscending;
import eu.senla.utils.comparator.guest.ComparatorGuestByDateCheckOutDateDescending;
import eu.senla.utils.comparator.guest.ComparatorGuestByNameAscending;
import java.util.Arrays;

public class PrintGuests {

  public void printGuestCard(Hotel informationToProcessing, Guest guest) {
    printCard(guest);
    if (!guest.getOrderedServices().isEmpty()) {
      System.out.println("Services ordered by guest:");
      System.out.println();
      informationToProcessing.getPrintInformation().getPrintGuests()
          .printGuestServices(informationToProcessing, guest);
      System.out
          .println("Guest's debt for services is " + informationToProcessing.getGuestService()
              .countDebtForServiceOfGuest(guest) + "$");
    } else {
      System.out.println("Guest haven't ordered any service");
    }
    System.out.println(
        "Guest debt is " + informationToProcessing.getGuestService()
            .countGuestDebt(informationToProcessing, guest, guest.hashCode())
            + "$ in this moment");
    System.out.println("********** ********** **********");
  }

  public void printArchivedGuestCard(Hotel informationToProcessing, Guest guest) {
    printCard(guest);
    if (!guest.getOrderedServices().isEmpty()) {
      System.out.println("Services ordered by guest:");
      System.out.println();
      informationToProcessing.getPrintInformation().getPrintGuests()
          .printGuestServices(informationToProcessing, guest);
      System.out.println(
          "Guest debt is " + (guest.getDebt())
              + "$ in this moment");
      System.out.println("********** ********** **********");
    }
  }

  private void printCard(Guest guest) {
    System.out.println("********** Guest card **********");
    System.out.println("Guest name: " + guest.getName());
    System.out.println("Guest passport #: " + guest.getPassportNumber());
    System.out.println(
        "Guest check-in date " + guest.getCheckInDate() + " and check-out date "
            + guest.getCheckOutDate());
    System.out.println("Guest duration of stay: " + guest.getDurationOfStay() + " days");
  }

  public void printAllHotelGuestsByRoomNumber(Hotel hotelInformationToPrint) {
    for (int i = 0; i < hotelInformationToPrint.getRoomsDao().getRoomsList().size(); i++) {
      if (!hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
          .getCurrentGuest()
          .isEmpty()) {
        System.out.println(
            "In room #" + hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                .getNumber()
                + " are living these guests:");
        for (int j = 0;
            j < hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest().size();
            j++) {
          hotelInformationToPrint.getPrintInformation().getPrintGuests()
              .printGuestCard(hotelInformationToPrint,
                  hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                      .getCurrentGuest().get(j));
          System.out.println();
        }
      }
    }
  }

  public void printGuestsByCheckOutDateAscending(Hotel hotelInformationToPrint) {
    for (int i = 0; i < hotelInformationToPrint.getRoomsDao().getRoomsList().size(); i++) {
      if (!hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
          .getCurrentGuest()
          .isEmpty()) {
        for (int j = 0;
            j < hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest().size();
            j++) {
          hotelInformationToPrint.getGuestDao().getGuestsList()
              .add(hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                  .getCurrentGuest().get(j));
        }
      }
    }
    Guest[] tempGuestsArray = hotelInformationToPrint.getGuestDao().getGuestsList()
        .toArray(new Guest[]{});
    Arrays.sort(tempGuestsArray, 0, tempGuestsArray.length,
        new ComparatorGuestByDateCheckOutDateAscending());
    for (Guest guest : tempGuestsArray) {
      System.out.println("Room #" + hotelInformationToPrint.getRoomService()
          .findGuestRoom(hotelInformationToPrint, guest.hashCode()));
      hotelInformationToPrint.printInformation.getPrintGuests()
          .printGuestCard(hotelInformationToPrint, guest);
    }
  }

  public void printGuestsByCheckOutDateDescending(Hotel hotelInformationToPrint) {
    for (int i = 0; i < hotelInformationToPrint.getRoomsDao().getRoomsList().size(); i++) {
      if (!hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
          .getCurrentGuest()
          .isEmpty()) {
        for (int j = 0;
            j < hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest().size();
            j++) {
          hotelInformationToPrint.getGuestDao().getGuestsList()
              .add(hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                  .getCurrentGuest().get(j));
        }
      }
    }
    Guest[] tempGuestsArray = hotelInformationToPrint.getGuestDao().getGuestsList()
        .toArray(new Guest[]{});
    Arrays.sort(tempGuestsArray, 0, tempGuestsArray.length,
        new ComparatorGuestByDateCheckOutDateDescending());
    for (Guest guest : tempGuestsArray) {
      System.out.println("Room #" + hotelInformationToPrint.getRoomService()
          .findGuestRoom(hotelInformationToPrint, guest.hashCode()).getNumber());
      hotelInformationToPrint.printInformation.getPrintGuests()
          .printGuestCard(hotelInformationToPrint, guest);
    }
  }

  public void printGuestsByNameAscending(Hotel hotelInformationToPrint) {
    for (int i = 0; i < hotelInformationToPrint.getRoomsDao().getRoomsList().size(); i++) {
      if (!hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
          .getCurrentGuest()
          .isEmpty()) {
        for (int j = 0;
            j < hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest().size();
            j++) {
          hotelInformationToPrint.getGuestDao().getGuestsList()
              .add(hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                  .getCurrentGuest().get(j));
        }
      }
    }
    Guest[] tempGuestsArray = hotelInformationToPrint.getGuestDao().getGuestsList()
        .toArray(new Guest[]{});
    Arrays.sort(tempGuestsArray, 0, tempGuestsArray.length,
        new ComparatorGuestByNameAscending());
    for (Guest guest : tempGuestsArray) {
      System.out.println("Room #" + hotelInformationToPrint.getRoomService()
          .findGuestRoom(hotelInformationToPrint, guest.hashCode()).getNumber());
      hotelInformationToPrint.printInformation.getPrintGuests()
          .printGuestCard(hotelInformationToPrint, guest);
    }
  }

  public void printGuestsByNameDescending(Hotel hotelInformationToPrint) {
    for (int i = 0; i < hotelInformationToPrint.getRoomsDao().getRoomsList().size(); i++) {
      if (!hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
          .getCurrentGuest()
          .isEmpty()) {
        for (int j = 0;
            j < hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest().size();
            j++) {
          hotelInformationToPrint.getGuestDao().getGuestsList()
              .add(hotelInformationToPrint.getRoomsDao().getRoomsList().get(i)
                  .getCurrentGuest().get(j));
        }
      }
    }
    Guest[] tempGuestsArray = hotelInformationToPrint.getGuestDao().getGuestsList()
        .toArray(new Guest[]{});
    Arrays.sort(tempGuestsArray, 0, tempGuestsArray.length,
        new ComparatorGuestByNameAscending());
    Guest[] tempGuestsReverseArray = new Guest[tempGuestsArray.length];
    for (int i = 0; i < tempGuestsArray.length; i++) {
      tempGuestsReverseArray[i] = tempGuestsArray[tempGuestsArray.length - 1
          - i];
    }
    for (Guest guest : tempGuestsReverseArray) {
      System.out.println("Room #" + hotelInformationToPrint.getRoomService()
          .findGuestRoom(hotelInformationToPrint, guest.hashCode()).getNumber());
      hotelInformationToPrint.printInformation.getPrintGuests()
          .printGuestCard(hotelInformationToPrint, guest);
    }
  }

  public void printGuestServices(Hotel informationToProcessing, Guest guest) {
    for (OrderedService orderedService : guest.getOrderedServices()) {
      informationToProcessing.printInformation.getPrintServices()
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

  public void printRoomArchivedGuests(Hotel hotelInformationToPrint, Room room) {
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
            hotelInformationToPrint.printInformation.getPrintGuests()
                .printArchivedGuestCard(hotelInformationToPrint, room.getArchivedGuest()[i][j]);
          }
        }
      }
    } else {
      System.out.println("Nobody lived here before");
    }
  }
}
