package eu.senla.model.hotel;

import eu.senla.api.print.PrintInformation;
import eu.senla.dao.GuestDao;
import eu.senla.dao.RoomsDao;
import eu.senla.dao.ServicesDao;
import eu.senla.model.guest.Guest;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import eu.senla.service.ProcessingGuests;
import eu.senla.service.ProcessingRooms;
import eu.senla.service.ProcessingServices;
import java.time.LocalDate;

public class Hotel {

  public final RoomsDao roomsDao = new RoomsDao();
  public final ServicesDao servicesDao = new ServicesDao();
  public final PrintInformation printInformation = new PrintInformation();
  public final GuestDao guestDao = new GuestDao();
  private final ProcessingServices processingServices = new ProcessingServices(
      this.getServicesDao());
  private final ProcessingRooms processingRooms = new ProcessingRooms(this.getRoomsDao());
  private final ProcessingGuests processingGuests = new ProcessingGuests(this.getGuestDao());


  public Hotel() {
    addingRooms();
    addingServices();
    checkInGuests();
    addingServicesToOneGuest();
    addingServicesToWholeRoom(1, getProcessingServices().selectServiceByName("cityTour"));
    getProcessingServices().addServiceToRoomByName(this,
        this.getProcessingRooms().selectRoomByNumber(this.roomsDao, 1), "wifi");
    getProcessingServices().addServiceToRoomByCounter(this,
        this.getProcessingRooms().selectRoomByNumber(this.roomsDao, 1), 2);
    checkOutGuests();

  }

  public void addingRooms() {
    roomsDao.getRoomsList().add(new Room(1, 2, 2, 1.0));
    roomsDao.getRoomsList().add(new Room(2, 3, 2, 2.0));
    roomsDao.getRoomsList().add(new Room(3, 4, 2, 3.0));
    roomsDao.getRoomsList().add(new Room(4, 2, 1, 4.0));
    roomsDao.getRoomsList().add(new Room(5, 1, 1, 5.0));
    roomsDao.getRoomsList().add(new Room(6, 2, 4, 6.0));
    roomsDao.getRoomsList().add(new Room(7, 3, 3, 7.0));
    roomsDao.getRoomsList().add(new Room(8, 4, 3, 8.0));
    roomsDao.getRoomsList().get(4).setFree(false);
  }

  public void addingServices() {
    processingServices.addService(new Service("WiFi", 1.0, "InHouse", true));
    processingServices.addService(new Service("Laundry", 3.0, "InHouse", false));
    processingServices.addService(new Service("Parking", 1.5, "Outdoor", true));
    processingServices.addService(new Service("CityTour", 20.0, "Outdoor", false));
    processingServices.addService(new Service("Massage", 10.0, "InHouse", false));
    processingServices.addService(new Service("AirportTransfer", 15.0, "Outdoor", false));
    processingServices.addService(new Service("Gym", 2.0, "InHouse", false));
  }

  public void checkInGuests() {
    getProcessingGuests()
        .checkInGuest((getProcessingRooms().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{new Guest("Alice", "MP45458946", LocalDate.now(), 15),
                new Guest("Mark", "FT1234567", LocalDate.now(), 15)});
    getProcessingGuests()
        .checkInGuest((getProcessingRooms().selectSuitableRoom(getRoomsDao(), 2, 3)),
            new Guest[]{
                new Guest("Margaret", "MF4558946", LocalDate.now(), 10),
                new Guest("Jane", "XT1248567", LocalDate.now(), 10)});
    getProcessingGuests()
        .checkInGuest((getProcessingRooms().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Mike", "FT1234567", LocalDate.now(), 10),
                new Guest("Nick", "LR123456", LocalDate.now(), 10)});
    getProcessingGuests()
        .checkInGuest((getProcessingRooms().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Bob", "D126546L", LocalDate.now(), 3)});
    getProcessingGuests()
        .checkInGuest((getProcessingRooms().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Monica", "D126546L", LocalDate.now(), 3)});
    getProcessingGuests()
        .checkInGuest((getProcessingRooms().selectSuitableRoom(getRoomsDao(), 2, 2)),
            new Guest[]{
                new Guest("Lilith", "LY15636858", LocalDate.now(), 7),
                new Guest("Dilan", "LR123456", LocalDate.now(), 7),
                new Guest("Tom", "ZX670439", LocalDate.now(), 7),
                new Guest("Kate", "PK3650421", LocalDate.now(), 7)});
    System.out.println("Print results of check-in guests");
    printInformation.getPrintGuests().printAllHotelGuestsByRoomNumber(this);
  }

  public void checkOutGuests() {
    getProcessingGuests()
        .checkOutGuests(this, getProcessingRooms().selectRoomByNumber(this.getRoomsDao(), 1));
  }

  public void addingServicesToOneGuest() {
    getProcessingGuests()
        .addingServiceByNameToGuest(this, getProcessingGuests().selectGuestByName(this, "Margaret"),
            "laundry");
    getProcessingGuests()
        .addingServiceByNameToGuest(this, getProcessingGuests().selectGuestByName(this, "Dilan"),
            "AirportTransfer");
    getProcessingGuests().addingServiceByNameToGuest(this,
        getProcessingGuests().selectGuestByName(this, "Margaret"), "Wifi");
    getProcessingGuests()
        .addingServiceByNameToGuest(this, getProcessingGuests().selectGuestByName(this, "Margaret"),
            "Laundry");
    getProcessingGuests().addingServiceByNameToGuest(this,
        getProcessingGuests().selectGuestByName(this, "Tom"), "Parking");
    getProcessingGuests().addingServiceByNameToGuest(this,
        getProcessingGuests().selectGuestByName(this, "Bob"), "cityTour");
    getProcessingGuests().addingServiceByNameToGuest(this,
        getProcessingGuests().selectGuestByName(this, "Mike"), "Wifi");
    getProcessingGuests().addingServiceByNameToGuest(this,
        getProcessingGuests().selectGuestByName(this, "Monica"), "gym");
    getProcessingGuests()
        .addingServiceByNameToGuest(this, getProcessingGuests().selectGuestByName(this, "Margaret"),
            "Laundry");
    getProcessingGuests().addingServiceByNameToGuest(this,
        getProcessingGuests().selectGuestByName(this, "Tom"), "Parking");
    getProcessingGuests()
        .addingServiceByNameToGuest(this, getProcessingGuests().selectGuestByName(this, "Monica"),
            "massage");
    getProcessingGuests()
        .addingServiceByNameToGuest(this, getProcessingGuests().selectGuestByName(this, "Dilan"),
            "AirportTransfer");
    getProcessingGuests()
        .addingServiceByNameToGuest(this, getProcessingGuests().selectGuestByName(this, "Margaret"),
            "AirportTransfer");
    System.out.println();
    getProcessingGuests()
        .addingServiceByNameToGuest(this, getProcessingGuests().selectGuestByName(this, "Dilan"),
            "Gym");
    getProcessingGuests()
        .addingServiceByNumberToGuest(this, getProcessingGuests().selectGuestByName(this, "Tom"),
            3);
    getProcessingGuests().addingServiceByNameToGuest(this,
        getProcessingGuests().selectGuestByName(this, "Dilan"), "Parking");
  }

  public void addingServicesToWholeRoom(int roomNumber, Service serviceToAdd) {
    Room room = getProcessingRooms().selectRoomByNumber(getRoomsDao(), roomNumber);
    for (int i = 0; i < room.getRoomCurrentGuest().size(); i++) {
      getProcessingGuests()
          .addingServiceByNameToGuest(this, getProcessingGuests()
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

  public ProcessingGuests getProcessingGuests() {
    return processingGuests;
  }

  public ServicesDao getServicesDao() {
    return servicesDao;
  }

  public ProcessingServices getProcessingServices() {
    return processingServices;
  }

  public ProcessingRooms getProcessingRooms() {
    return processingRooms;
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