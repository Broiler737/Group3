package eu.senla.service;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.service.ServiceService.OrderedService;
import eu.senla.utils.userinput.ProcessingUserInput;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class GuestService {

  public int getCountOfRegisteredGuests(Hotel informationToProcessing) {
    int counterOfRegisteredGuests = 0;
    for (int i = 0; i < informationToProcessing.getRoomsDao().getRoomsList().size(); i++) {
      if (!informationToProcessing.getRoomsDao().getRoomsList().get(i)
          .getCurrentGuest().isEmpty()) {
        for (int j = 0;
            j < informationToProcessing.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest()
                .size(); j++) {
          if (informationToProcessing.getRoomsDao().getRoomsList().get(i)
              .getCurrentGuest()
              .get(j) != null) {
            counterOfRegisteredGuests++;
          }
        }
      }
    }
    return counterOfRegisteredGuests;
  }

  public double countDebtForServiceOfGuest(Guest guest) {
    double tempServiceDebt = 0.0;
    for (OrderedService orderedService : guest.getOrderedServices()) {
      double tempDebt = 0.0;
      if (orderedService.getOrderedService().isPerDay()) {
        tempDebt = tempDebt
            + orderedService.getDurationOfUseService() * orderedService.getOrderedService()
            .getPrice();
      } else {
        tempDebt = tempDebt
            + orderedService.getCountOfOrderingService() * orderedService.getOrderedService()
            .getPrice();
      }
      tempServiceDebt = tempServiceDebt + tempDebt;
    }
    return tempServiceDebt;
  }

  public double countGuestDebt(Hotel informationToProcessing, Guest guest, int guestHash) {
    double tempDebt = 0.0;
    double tempServiceDebt = countDebtForServiceOfGuest(guest);
    tempDebt = tempDebt + tempServiceDebt;
    double roomPrice = informationToProcessing.getRoomService()
        .findGuestRoom(informationToProcessing, guestHash).getPrice();
    tempDebt = tempDebt + guest.getDurationOfStay() * roomPrice;
    guest.setDebt(tempDebt);
    return tempDebt;
  }

  public void addingServiceByNameToGuest(Hotel informationToProcessing, Guest guest,
      String serviceNameToAdd) {
    if (guest.getOrderedServices().size() > 0) {
      boolean isServiceAdded = false;
      int numberOfRecord = 0;
      int tempDurationOfUseService = 0;
      for (int j = 0; j < guest.getOrderedServices().size(); j++) {
        isServiceAdded = guest.getOrderedServices().get(j).getOrderedService().getName()
            .toLowerCase()
            .equals(serviceNameToAdd.toLowerCase());
        if (isServiceAdded) {
          tempDurationOfUseService = guest.getOrderedServices().get(j).getDurationOfUseService();
          numberOfRecord = j;
          break;
        }
      }
      if (isServiceAdded) {
        System.out.println();
        guest.getOrderedServices().get(numberOfRecord).setDurationOfUseService(
            guest.getOrderedServices().get(numberOfRecord).getDurationOfUseService()
                + tempDurationOfUseService);
        guest.getOrderedServices().get(numberOfRecord).setDurationOfUseService(
            guest.getOrderedServices().get(numberOfRecord).getCountOfOrderingService() + 1);
      } else {
        guest.getOrderedServices()
            .add(new OrderedService(informationToProcessing, serviceNameToAdd,
                LocalDate.of(2021, 6, 10), LocalDate.of(2021, 6, 12)));
      }
    } else {
      guest.getOrderedServices()
          .add(new OrderedService(informationToProcessing, serviceNameToAdd,
              LocalDate.of(2021, 6, 10), LocalDate.of(2021, 6, 12)));
    }
  }

  public void addingServiceByNumberToGuest(Hotel informationToProcessing, Guest guest,
      int serviceNumberToAdd) {
    if (guest.getOrderedServices().size() > 0) {
      for (int i = 0; i < guest.getOrderedServices().size(); i++) {
        if (guest.getOrderedServices().get(i).getOrderedService().getId()
            == serviceNumberToAdd) {
          guest.getOrderedServices().get(i).setCountOfOrderingService(
              guest.getOrderedServices().get(i).getCountOfOrderingService() + 1);
        } else {
          guest.getOrderedServices()
              .add(new OrderedService(informationToProcessing, serviceNumberToAdd,
                  LocalDate.of(2021, 6, 10), LocalDate.of(2021, 6, 12)));
          break;
        }
      }
    } else {
      guest.getOrderedServices()
          .add(new OrderedService(informationToProcessing, serviceNumberToAdd,
              LocalDate.of(2021, 6, 10), LocalDate.of(2021, 6, 12)));
    }
  }

  public Guest selectGuestByName(Hotel informationToProcessing, String guestName) {
    Guest tempGuest = null;
    for (int i = 0; i < informationToProcessing.getRoomsDao().getRoomsList().size(); i++) {
      if (!informationToProcessing.getRoomsDao().getRoomsList().get(i)
          .getCurrentGuest()
          .isEmpty()) {
        for (int j = 0;
            j < informationToProcessing.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest().size();
            j++) {
          if (informationToProcessing.getRoomsDao().getRoomsList().get(i).getCurrentGuest()
              .get(j).getName().toLowerCase().equals(guestName.toLowerCase())) {
            tempGuest = informationToProcessing.getRoomsDao().getRoomsList().get(i)
                .getCurrentGuest()
                .get(j);
            break;
          }
        }
      }
    }
    return tempGuest;
  }

  public Guest findGuestByHash(Hotel informationToProcessing, int guestHash) {
    Guest tempGuest = null;
    for (int i = 0; i < informationToProcessing.getRoomsDao().getRoomsList().size(); i++) {
      for (int j = 0;
          j < informationToProcessing.getRoomsDao().getRoomsList().get(i).getCurrentGuest()
              .size(); j++) {
        if (informationToProcessing.getRoomsDao().getRoomsList().get(i).getCurrentGuest()
            .get(j).hashCode() == guestHash) {
          tempGuest = informationToProcessing.getRoomsDao().getRoomsList().get(i)
              .getCurrentGuest().get(j);
        }
      }
    }
    return tempGuest;
  }

  public void checkInGuest(Room room, Guest[] guest) {
    if (guest.length <= room.getMaxCapacity()) {
      room.getCurrentGuest().addAll(Arrays.asList(guest));
      room.setFree(false);
    } else {
      System.out.println("Room " + room.getNumber() + "is full");
    }
  }

  public Guest[] prepareToCheckIn(ProcessingUserInput processingUserInput, int countOfGuests) {
    Guest[] tempGuestArray = new Guest[countOfGuests];
    String guestName = null;
    boolean isRight = false;
    for (int i = 0; i < tempGuestArray.length; i++) {
      System.out.println("Please enter " + (i + 1) + " guest name");
      guestName = processingUserInput.processUserStringInput();
      System.out.println("Please enter " + (i + 1) + " guest passport number");
      String guestPassportNumber = processingUserInput.processUserStringInput();
      System.out.println("Please enter " + (i + 1) + " guest check-in date");
      LocalDate guestCheckInDate = processingUserInput.processUserDateInput();
      System.out.println("Please enter " + (i + 1) + " guest duration of stay");
      Integer guestDurationOfStay = processingUserInput.processUserIntegerNumericInput();
      tempGuestArray[i] = new Guest(guestName, guestPassportNumber, guestCheckInDate,
          guestDurationOfStay);
    }
    return tempGuestArray;
  }

  public void checkOutGuests(Hotel hotel, Room room) {
    hotel.getRoomService()
        .processingArchivedGuests(room, prepareToCheckOut(room.getCurrentGuest()));
    room.getCurrentGuest().clear();
    room.setFree(true);
  }

  private Guest[] prepareToCheckOut(List<Guest> currentRoomGuests) {
    Guest tempGuest;
    Guest[] tempGuestArray = new Guest[currentRoomGuests.size()];
    for (int i = 0; i < currentRoomGuests.size(); i++) {
      tempGuest = new Guest();
      tempGuest.setPassportNumber(currentRoomGuests.get(i).getPassportNumber());
      tempGuest.setDebt(currentRoomGuests.get(i).getDebt());
      tempGuest.setName(currentRoomGuests.get(i).getName());
      tempGuest.setDurationOfStay(currentRoomGuests.get(i).getDurationOfStay());
      tempGuest.setOrderedServices(currentRoomGuests.get(i).getOrderedServices());
      tempGuest.setCheckOutDate(currentRoomGuests.get(i).getCheckOutDate());
      tempGuest.setCheckInDate(currentRoomGuests.get(i).getCheckInDate());
      tempGuestArray[i] = tempGuest;
    }
    return tempGuestArray;
  }
}