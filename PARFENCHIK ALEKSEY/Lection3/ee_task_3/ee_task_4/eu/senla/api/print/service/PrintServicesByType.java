package eu.senla.api.print.service;

import eu.senla.hotel.Hotel;
import eu.senla.service.Service;
import eu.senla.service.Services;
import eu.senla.utils.comparator.service.ComparatorServiceByTypeAscending;
import java.util.Arrays;

public class PrintServicesByType {

  public void printServicesByTypeAscending(Hotel hotelInformationToPrint,
      Services services) {
    services.prepareCurrentServices(services.getServices());
    Service[] tempServiceArray = services.prepareCurrentServices(services.getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByTypeAscending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByTypeDescending(Hotel hotelInformationToPrint,
      Services services) {
    services.prepareCurrentServices(services.getServices());
    Service[] tempServiceArray = services.prepareCurrentServices(services.getServices());
    Service[] tempServiceReverseArray = new Service[tempServiceArray.length];
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByTypeAscending());
    for (int i = 0; i < tempServiceArray.length; i++) {
      tempServiceReverseArray[i] = tempServiceArray[tempServiceArray.length - 1 - i];
    }
    for (Service sortedService : tempServiceReverseArray) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }
}
