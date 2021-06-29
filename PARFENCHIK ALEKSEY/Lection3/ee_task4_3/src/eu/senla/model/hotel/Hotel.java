package eu.senla.model.hotel;

import eu.senla.api.print.PrintInformation;
import eu.senla.dao.GuestDao;
import eu.senla.dao.RoomsDao;
import eu.senla.dao.ServicesDao;
import eu.senla.model.guest.Guest;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import eu.senla.service.GuestService;
import eu.senla.service.RoomService;
import eu.senla.service.ServiceService;
import java.time.LocalDate;

public class Hotel {

  public final RoomsDao roomsDao = new RoomsDao();
  public final ServicesDao servicesDao = new ServicesDao();
  public final GuestDao guestDao = new GuestDao();
  private final ServiceService serviceService = new ServiceService();
  private final RoomService roomService = new RoomService();
  private final GuestService guestService = new GuestService();
  public final PrintInformation printInformation = new PrintInformation();

  public Hotel() {
    addingRooms();
    addingServices();
    checkInGuests();
    addingServicesToOneGuest();
    addingServicesToWholeRoom(1,
        getServiceService().selectAvailableServiceByName(this, "cityTour"));
    checkOutGuests();

  }

  public void addingRooms() {
    getRoomService().addRoom(this, 1, 2, 2, 1);
    getRoomService().addRoom(this, 2, 3, 2, 2);
    getRoomService().addRoom(this, 3, 4, 2, 3);
    getRoomService().addRoom(this, 4, 2, 1, 4);
    getRoomService().addRoom(this, 5, 1, 1, 5);
    getRoomService().addRoom(this, 6, 2, 4, 6);
    getRoomService().addRoom(this, 7, 3, 3, 7);
    getRoomService().addRoom(this, 8, 4, 3, 8);
    roomsDao.getRoomsList().get(4).setFree(false);
  }

  public void addingServices() {
    serviceService.addService(this, "WiFi", 1.0, "InHouse", true);
    serviceService.addService(this, "Laundry", 3.0, "InHouse", false);
    serviceService.addService(this, "Parking", 1.5, "Outdoor", true);
    serviceService.addService(this, "CityTour", 20.0, "Outdoor", false);
    serviceService.addService(this, "Massage", 10.0, "InHouse", false);
    serviceService.addService(this, "AirportTransfer", 15.0, "Outdoor", false);
    serviceService.addService(this, "Gym", 2.0, "InHouse", false);
  }

  public void checkInGuests() {
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{new Guest("Alice", "MP45458946", LocalDate.now(), 15),
                new Guest("Mark", "FT1234567", LocalDate.now(), 15)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao(), 2, 3)),
            new Guest[]{
                new Guest("Margaret", "MF4558946", LocalDate.now(), 10),
                new Guest("Jane", "XT1248567", LocalDate.now(), 10)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Mike", "FT1234567", LocalDate.now(), 10),
                new Guest("Nick", "LR123456", LocalDate.now(), 10)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Bob", "D126546L", LocalDate.now(), 3)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Monica", "D126546L", LocalDate.now(), 3)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Lilith", "LY15636858", LocalDate.now(), 7),
                new Guest("Dilan", "LR123456", LocalDate.now(), 7),
                new Guest("Tom", "ZX670439", LocalDate.now(), 7),
                new Guest("Kate", "PK3650421", LocalDate.now(), 7)});
    System.out.println("Print results of check-in guests");
    printInformation.getPrintGuests().printAllHotelGuestsByRoomNumber(this);
  }

  public void checkOutGuests() {
    getGuestService()
        .checkOutGuests(this, getRoomService().selectRoomByNumber(this.getRoomsDao(), 1));
  }

  public void addingServicesToOneGuest() {
    getGuestService()
        .addingServiceByNameToGuest(this, getGuestService().selectGuestByName(this, "Margaret"),
            "laundry");
    getGuestService()
        .addingServiceByNameToGuest(this, getGuestService().selectGuestByName(this, "Dilan"),
            "AirportTransfer");
    getGuestService().addingServiceByNameToGuest(this,
        getGuestService().selectGuestByName(this, "Margaret"), "Wifi");
    getGuestService()
        .addingServiceByNameToGuest(this, getGuestService().selectGuestByName(this, "Margaret"),
            "Laundry");
    getGuestService().addingServiceByNameToGuest(this,
        getGuestService().selectGuestByName(this, "Tom"), "Parking");
    getGuestService().addingServiceByNameToGuest(this,
        getGuestService().selectGuestByName(this, "Bob"), "cityTour");
    getGuestService().addingServiceByNameToGuest(this,
        getGuestService().selectGuestByName(this, "Mike"), "Wifi");
    getGuestService().addingServiceByNameToGuest(this,
        getGuestService().selectGuestByName(this, "Monica"), "gym");
    getGuestService()
        .addingServiceByNameToGuest(this, getGuestService().selectGuestByName(this, "Margaret"),
            "Laundry");
    getGuestService().addingServiceByNameToGuest(this,
        getGuestService().selectGuestByName(this, "Tom"), "Parking");
    getGuestService()
        .addingServiceByNameToGuest(this, getGuestService().selectGuestByName(this, "Monica"),
            "massage");
    getGuestService()
        .addingServiceByNameToGuest(this, getGuestService().selectGuestByName(this, "Dilan"),
            "AirportTransfer");
    getGuestService()
        .addingServiceByNameToGuest(this, getGuestService().selectGuestByName(this, "Margaret"),
            "AirportTransfer");
    System.out.println();
    getGuestService()
        .addingServiceByNameToGuest(this, getGuestService().selectGuestByName(this, "Dilan"),
            "Gym");
    getGuestService()
        .addingServiceByNumberToGuest(this, getGuestService().selectGuestByName(this, "Tom"),
            3);
    getGuestService().addingServiceByNameToGuest(this,
        getGuestService().selectGuestByName(this, "Dilan"), "Parking");
  }

  public void addingServicesToWholeRoom(int roomNumber, Service serviceToAdd) {
    Room room = getRoomService().selectRoomByNumber(getRoomsDao(), roomNumber);
    for (int i = 0; i < room.getRoomCurrentGuest().size(); i++) {
      getGuestService()
          .addingServiceByNameToGuest(this, getGuestService()
                  .selectGuestByName(this, room.getRoomCurrentGuest().get(i).getGuestName()),
              serviceToAdd.getServiceName());
    }
  }

  public PrintInformation getPrintInformation() {
    return printInformation;
  }

  public RoomsDao getRoomsDao() {
    return roomsDao;
  }

  public GuestService getGuestService() {
    return guestService;
  }

  public ServicesDao getServicesDao() {
    return servicesDao;
  }

  public ServiceService getServiceService() {
    return serviceService;
  }

  public RoomService getRoomService() {
    return roomService;
  }

  public GuestDao getGuestDao() {
    return guestDao;
  }

  @Override
  public String toString() {
    printInformation.printInformation(this);
    return "";
  }
}