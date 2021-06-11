package eu.senla.guest;

import eu.senla.hotel.Hotel;
import java.time.LocalDate;

public class AddingServiceToGuest {

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
}
