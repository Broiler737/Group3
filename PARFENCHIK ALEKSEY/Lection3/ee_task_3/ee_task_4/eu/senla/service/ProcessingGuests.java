package eu.senla.service;

import eu.senla.dao.GuestDao;
import eu.senla.model.guest.Guest;
import eu.senla.model.guest.GuestsAndRooms;
import eu.senla.model.guest.OrderedService;
import eu.senla.model.guest.RegistrationGuests;
import eu.senla.model.hotel.Hotel;

import java.time.LocalDate;

public class ProcessingGuests {

    private final GuestDao guestDao;

    public ProcessingGuests(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    public RegistrationGuests getRegisteredGuests(int roomNumber) {
        RegistrationGuests tempRoomAndGuests = null;
        for (RegistrationGuests hotelGuest : guestDao.getGuestsList()) {
            if (hotelGuest.getRoomNumber() == roomNumber) {
                tempRoomAndGuests = hotelGuest;
                break;
            }
        }
        return tempRoomAndGuests;
    }

    public int getCountOfRegisteredGuests(Hotel informationToProcessing) {
        int counterOfRegisteredGuests = 0;
        for (int i = 0; i < informationToProcessing.getGuestDao().getGuestsList().size(); i++) {
            if (!informationToProcessing.getGuestDao().getGuestsList().get(i)
                    .getRegisteredInRoomGuests().isEmpty()) {
                for (int j = 0;
                     j < informationToProcessing.getGuestDao().getGuestsList().get(i)
                             .getRegisteredInRoomGuests()
                             .size(); j++) {
                    if (informationToProcessing.getGuestDao().getGuestsList().get(i)
                            .getRegisteredInRoomGuests()
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
                        .getServicePrice();
            } else {
                tempDebt = tempDebt
                        + orderedService.getCountOfOrderingService() * orderedService.getOrderedService()
                        .getServicePrice();
            }
            tempServiceDebt = tempServiceDebt + tempDebt;
        }
        return tempServiceDebt;
    }

    public double countGuestDebt(Hotel informationToProcessing, Guest guest, int guestHash) {

        double tempDebt = 0.0;
        double tempServiceDebt = countDebtForServiceOfGuest(guest);
        tempDebt = tempDebt + tempServiceDebt;
        double roomPrice = informationToProcessing.getProcessingRooms().findGuestRoom(informationToProcessing, guestHash).getRoomPrice();
        tempDebt = tempDebt + guest.getGuestDurationOfStay() * roomPrice;
        guest.setGuestDebt(tempDebt);
        return tempDebt;
    }

    public void addingServiceByNameToGuest(Hotel informationToProcessing, Guest guest,
                                           String serviceNameToAdd) {
        if (guest.getOrderedServices().size() > 0) {
            boolean isServiceAdded = false;
            int numberOfRecord = 0;
            int tempDurationOfUseService = 0;
            for (int j = 0; j < guest.getOrderedServices().size(); j++) {
                isServiceAdded = guest.getOrderedServices().get(j).getOrderedService().getServiceName()
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
                guest.getOrderedServices().add(new OrderedService(informationToProcessing, serviceNameToAdd,
                        LocalDate.of(2021, 6, 10), LocalDate.of(2021, 6, 12)));
            }
        } else {
            guest.getOrderedServices().add(new OrderedService(informationToProcessing, serviceNameToAdd,
                    LocalDate.of(2021, 6, 10), LocalDate.of(2021, 6, 12)));
        }
    }

    public void addingServiceByNumberToGuest(Hotel informationToProcessing, Guest guest,
                                             int serviceNumberToAdd) {
        if (guest.getOrderedServices().size() > 0) {
            for (int i = 0; i < guest.getOrderedServices().size(); i++) {
                if (guest.getOrderedServices().get(i).getOrderedService().getServiceId()
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
            guest.getOrderedServices().add(new OrderedService(informationToProcessing, serviceNumberToAdd,
                    LocalDate.of(2021, 6, 10), LocalDate.of(2021, 6, 12)));
        }
    }

    public Guest selectGuestByName(Hotel informationToProcessing, String guestName) {
        Guest tempGuest = null;
        GuestsAndRooms[] tempGuestAndRoomArray = informationToProcessing.processingGuestList
                .getGuestsAndRooms(informationToProcessing);
        for (GuestsAndRooms guestsAndRooms : tempGuestAndRoomArray) {
            if (guestsAndRooms.getGuest().getGuestName().equals(guestName)) {
                tempGuest = guestsAndRooms.getGuest();
                break;
            }
        }
        return tempGuest;
    }

    public Guest findGuestByHash(Hotel informationToProcessing, int guestHash) {
        Guest tempGuest = null;
        for (int i = 0; i < informationToProcessing.guestDao.getGuestsList().size(); i++) {
            for (int j = 0;
                 j < informationToProcessing.guestDao.getGuestsList().get(i).getRegisteredInRoomGuests()
                         .size(); j++) {
                if (informationToProcessing.guestDao.getGuestsList().get(i).getRegisteredInRoomGuests()
                        .get(j).hashCode() == guestHash) {
                    tempGuest = informationToProcessing.guestDao.getGuestsList().get(i)
                            .getRegisteredInRoomGuests().get(j);
                }
            }
        }
        return tempGuest;
    }
}