package eu.senla.api.menu.guestmenu;

import eu.senla.model.guest.Guest;
import eu.senla.model.guest.OrderedService;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.service.Service;
import eu.senla.utils.userinput.ProcessUserInput;
import java.time.LocalDate;

public class GuestServiceMenuActivity {

  String guestName;
  Guest guest = null;
  String serviceName;
  Service serviceToAdd = null;
  LocalDate orderingDate;
  LocalDate endingDate;
  private boolean isRight = false;

  public void addServiceToGuest(Hotel hotel, ProcessUserInput processUserInput) {
    boolean isGuestRegistered = false;
    boolean isServiceAvailable = false;
    do {
      System.out.println("Please enter guest name");
      guestName = processUserInput.processUserStringInput();
      guest = hotel.getSelectGuest().selectGuestByName(hotel, guestName);
      if (guest != null) {
        isGuestRegistered = true;
      } else {
        System.out.println("Guest with name " + guestName + " is not registered in hotel");
      }
      if (isGuestRegistered) {
        System.out.println("Please enter service name to add");
        serviceName = processUserInput.processUserStringInput();
        serviceToAdd = hotel.getProcessingServices().selectServiceByName(serviceName);
        if (serviceToAdd != null) {
          isServiceAvailable = true;
        } else {
          System.out.println("Service with name " + serviceName + " is not available in hotel");
        }
        if (isServiceAvailable) {
          System.out.println("Please enter date of ordering service");
          orderingDate = processUserInput.processUserDateInput();
          do {
            System.out.println("Please enter date of ending use service");
            endingDate = processUserInput.processUserDateInput();
          } while (endingDate.isBefore(orderingDate));
          guest.getOrderedServices()
              .add(new OrderedService(hotel, serviceName, orderingDate, endingDate));
          System.out.println("Service with name " + serviceName + " successful added to guest:");
          hotel.getPrintInformation().getPrintGuestCard().printGuestCard(hotel, guest);
          isRight = true;
        }
      } else {
        break;
      }
    } while (!isRight);
  }
}
