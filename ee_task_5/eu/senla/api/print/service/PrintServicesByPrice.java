package eu.senla.api.print.service;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.service.Service;
import eu.senla.utils.comparator.service.ComparatorServiceByPriceAscending;
import eu.senla.utils.comparator.service.ComparatorServiceByPriceDescending;
import java.util.Arrays;

public class PrintServicesByPrice {

  public void printServicesByPriceAscending(Hotel hotelInformationToPrint) {
    Service[] tempServiceArray = hotelInformationToPrint.getProcessingServices()
        .prepareCurrentServices(hotelInformationToPrint.getServices().getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByPriceAscending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByPriceDescending(Hotel hotelInformationToPrint) {
    Service[] tempServiceArray = hotelInformationToPrint.getProcessingServices()
        .prepareCurrentServices(hotelInformationToPrint.getServices().getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByPriceDescending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }
}
