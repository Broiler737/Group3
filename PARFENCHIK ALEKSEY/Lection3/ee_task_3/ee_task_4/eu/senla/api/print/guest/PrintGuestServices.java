package eu.senla.api.print.guest;

import eu.senla.model.guest.Guest;
import eu.senla.model.guest.OrderedService;
import eu.senla.model.hotel.Hotel;

public class PrintGuestServices {

    public void printGuestServices(Hotel informationToProcessing, Guest guest) {
        for (OrderedService orderedService : guest.getOrderedServices()) {
            informationToProcessing.printInformation.getPrintServiceDetails()
                    .printServiceSimple(orderedService.getOrderedService());
            if (orderedService.getOrderedService().isPerDay()) {
                System.out.println(
                        "The guest use this service " + orderedService.getDurationOfUseService() + " days");
            } else {
                System.out.println(
                        "The guest use this service " + (orderedService.getCountOfOrderingService())
                                + " times");
            }
        }
    }
}