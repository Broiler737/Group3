package eu.senla.model.hotel;

import eu.senla.api.print.PrintInformation;
import eu.senla.dao.GuestDao;
import eu.senla.dao.RoomsDao;
import eu.senla.dao.ServicesDao;
import eu.senla.model.service.Service;
import eu.senla.service.GuestService;
import eu.senla.service.HotelService;
import eu.senla.service.RoomService;
import eu.senla.service.ServiceService;

public class Hotel {

  public final RoomsDao roomsDao = new RoomsDao();
  public final ServicesDao servicesDao = new ServicesDao();
  public final GuestDao guestDao = new GuestDao();
  private final ServiceService serviceService = new ServiceService();
  private final RoomService roomService = new RoomService();
  private final GuestService guestService = new GuestService();
  public final PrintInformation printInformation = new PrintInformation();
  private final HotelService hotelService = new HotelService(this);

  public Hotel() {
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