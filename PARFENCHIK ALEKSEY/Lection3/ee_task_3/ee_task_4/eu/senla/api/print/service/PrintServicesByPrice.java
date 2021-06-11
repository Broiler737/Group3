package eu.senla.api.print.service;

import eu.senla.hotel.Hotel;
import eu.senla.service.Service;
import eu.senla.service.Services;
import eu.senla.utils.comparator.service.ComparatorServiceByPriceAscending;
import eu.senla.utils.comparator.service.ComparatorServiceByPriceDescending;
import java.util.Arrays;

public class PrintServicesByPrice {

  public void printServicesByPriceAscending(Hotel hotelInformationToPrint,
      Services services) {
    Service[] tempServiceArray = services.prepareCurrentServices(services.getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByPriceAscending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByPriceDescending(Hotel hotelInformationToPrint,
      Services services) {
    Service[] tempServiceArray = services.prepareCurrentServices(services.getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByPriceDescending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }
}
