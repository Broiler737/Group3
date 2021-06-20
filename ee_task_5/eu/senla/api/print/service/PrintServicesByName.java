package eu.senla.api.print.service;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.service.Service;
import eu.senla.dao.Services;
import eu.senla.utils.comparator.service.ComparatorServiceByNameAscending;
import java.util.Arrays;

public class PrintServicesByName {

  public void printServicesByNameAscending(Hotel hotelInformationToPrint) {
    hotelInformationToPrint.getProcessingServices().prepareCurrentServices(hotelInformationToPrint.getServices().getServices());
    Service[] tempServiceArray = hotelInformationToPrint.getProcessingServices().prepareCurrentServices(hotelInformationToPrint.getServices().getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByNameAscending());
    for (Service sortedService : tempServiceArray) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(sortedService);
      System.out.println();
    }
  }

  public void printServicesByNameDescending(Hotel hotelInformationToPrint) {
    Service[] tempServiceArray = hotelInformationToPrint.getProcessingServices().prepareCurrentServices(hotelInformationToPrint.getServices().getServices());
    Arrays.sort(tempServiceArray, 0, tempServiceArray.length,
        new ComparatorServiceByNameAscending());
    for (int i = 0; i < tempServiceArray.length; i++) {
      hotelInformationToPrint.printInformation.getPrintServiceDetails()
          .printServiceDetails(tempServiceArray[tempServiceArray.length - 1 - i]);
    }
  }
}
