package eu.senla.api.print.service;

import eu.senla.hotel.Hotel;
import eu.senla.service.Service;
import eu.senla.service.Services;
import eu.senla.utils.comparator.service.ComparatorServiceByNameAscending;
import java.util.Arrays;

public class PrintServicesByName {

  public void printServicesByNameAscending(Hotel hotelInformationToPrint,
      Services services) {
    services.prepareCurrentServices(services.getServices());
    Service[] tempServiceArray = services.prepareCurrentServices(services.getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByNameAscending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByNameDescending(Hotel hotelInformationToPrint,
      Services services) {
    Service[] tempServiceArray = services.prepareCurrentServices(services.getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByNameAscending());
    for (int i = 0; i < tempServiceArray.length; i++) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(tempServiceArray[tempServiceArray.length - 1 - i]);
    }
  }
}
