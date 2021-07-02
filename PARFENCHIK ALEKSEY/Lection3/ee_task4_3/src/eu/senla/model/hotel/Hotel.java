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
    addingServicesToWholeRoom(1, getServiceService()
        .selectAvailableServiceByName(this.getServicesDao().getServicesList(), "cityTour"));
    checkOutGuests();
  }


  public void addingRooms() {
    getRoomService().addRoom(getRoomsDao().getRoomsList(), 1, 2, 2, 1);
    getRoomService().addRoom(getRoomsDao().getRoomsList(), 2, 3, 2, 2);
    getRoomService().addRoom(getRoomsDao().getRoomsList(), 3, 4, 2, 3);
    getRoomService().addRoom(getRoomsDao().getRoomsList(), 4, 2, 1, 4);
    getRoomService().addRoom(getRoomsDao().getRoomsList(), 5, 1, 1, 5);
    getRoomService().addRoom(getRoomsDao().getRoomsList(), 6, 2, 4, 6);
    getRoomService().addRoom(getRoomsDao().getRoomsList(), 7, 3, 3, 7);
    getRoomService().addRoom(getRoomsDao().getRoomsList(), 8, 4, 3, 8);
    getRoomsDao().getRoomsList().get(4).setFree(false);
  }

  public void addingServices() {
    getServiceService()
        .addService(this.getServicesDao().getServicesList(), "WiFi", 1.0, "InHouse", true);
    getServiceService()
        .addService(this.getServicesDao().getServicesList(), "Laundry", 3.0, "InHouse", false);
    getServiceService()
        .addService(this.getServicesDao().getServicesList(), "Parking", 1.5, "Outdoor", true);
    getServiceService()
        .addService(this.getServicesDao().getServicesList(), "CityTour", 20.0, "Outdoor", false);
    getServiceService()
        .addService(this.getServicesDao().getServicesList(), "Massage", 10.0, "InHouse", false);
    getServiceService()
        .addService(this.getServicesDao().getServicesList(), "AirportTransfer", 15.0, "Outdoor",
            false);
    getServiceService()
        .addService(this.getServicesDao().getServicesList(), "Gym", 2.0, "InHouse", false);
  }

  public void checkInGuests() {
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao().getRoomsList(), 2, 2)),
            new Guest[]{new Guest("Alice", "MP45458946", LocalDate.now(), 15),
                new Guest("Mark", "FT1234567", LocalDate.now(), 15)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao().getRoomsList(), 2, 3)),
            new Guest[]{
                new Guest("Margaret", "MF4558946", LocalDate.now(), 10),
                new Guest("Jane", "XT1248567", LocalDate.now(), 10)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao().getRoomsList(), 2, 2)),
            new Guest[]{
                new Guest("Mike", "FT1234567", LocalDate.now(), 10),
                new Guest("Nick", "LR123456", LocalDate.now(), 10)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao().getRoomsList(), 2, 2)),
            new Guest[]{
                new Guest("Bob", "D126546L", LocalDate.now(), 3)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao().getRoomsList(), 2, 2)),
            new Guest[]{
                new Guest("Monica", "D126546L", LocalDate.now(), 3)});
    getGuestService()
        .checkInGuest((getRoomService().selectSuitableRoom(getRoomsDao().getRoomsList(), 2, 2)),
            new Guest[]{
                new Guest("Lilith", "LY15636858", LocalDate.now(), 7),
                new Guest("Dilan", "LR123456", LocalDate.now(), 7),
                new Guest("Tom", "ZX670439", LocalDate.now(), 7),
                new Guest("Kate", "PK3650421", LocalDate.now(), 7)});
    System.out.println("Print results of check-in guests");
    getPrintInformation().getPrintGuests()
        .printAllHotelGuestsByRoomNumber(this.getPrintInformation(),
            this.getRoomsDao().getRoomsList(), this.getRoomService(), this.getGuestService());
  }

  public void checkOutGuests() {
    getGuestService()
        .checkOutGuests(this.getRoomService(),
            getRoomService().selectRoomByNumber(getRoomsDao().getRoomsList(), 1));
  }

  public void addingServicesToOneGuest() {
    getGuestService()
        .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Margaret"),
            "laundry");
    getGuestService()
        .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Dilan"),
            "AirportTransfer");
    getGuestService().addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Margaret"), "Wifi");
    getGuestService()
        .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Margaret"),
            "Laundry");
    getGuestService().addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Tom"), "Parking");
    getGuestService().addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Bob"), "cityTour");
    getGuestService().addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Mike"), "Wifi");
    getGuestService().addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Monica"), "gym");
    getGuestService()
        .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Margaret"),
            "Laundry");
    getGuestService().addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Tom"), "Parking");
    getGuestService()
        .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Monica"),
            "massage");
    getGuestService()
        .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Dilan"),
            "AirportTransfer");
    getGuestService()
        .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Margaret"),
            "AirportTransfer");
    System.out.println();
    getGuestService()
        .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Dilan"),
            "Gym");
    getGuestService()
        .addingServiceByNumberToGuest(this.getServicesDao().getServicesList(),
            this.getServiceService(),
            getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Tom"),
            3);
    getGuestService().addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
        this.getServiceService(),
        getGuestService().selectGuestByName(this.getRoomsDao().getRoomsList(), "Dilan"), "Parking");
  }

  public void addingServicesToWholeRoom(int roomNumber, Service serviceToAdd) {
    Room room = getRoomService().selectRoomByNumber(getRoomsDao().getRoomsList(), roomNumber);
    for (int i = 0; i < room.getCurrentGuest().size(); i++) {
      getGuestService()
          .addingServiceByNameToGuest(this.getServicesDao().getServicesList(),
              this.getServiceService(), getGuestService()
                  .selectGuestByName(this.getRoomsDao().getRoomsList(),
                      room.getCurrentGuest().get(i).getFullName()),
              serviceToAdd.getName());
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
    printInformation.printInformation(this.getRoomService(), this.getRoomsDao().getRoomsList(),
        this.getGuestService(), this.getGuestDao().getGuestsList(), this.getServiceService(),
        this.getServicesDao().getServicesList());
    return "";
  }
}