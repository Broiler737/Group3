package eu.senla.api.print.hotel;

import eu.senla.model.hotel.Hotel;

public class PrintCountOfHotelGuests {

  public void printCountOfHotelGuests(Hotel informationToProcessing) {
    int counter;
    counter = informationToProcessing.getProcessingGuests()
        .getCountOfRegisteredGuests(informationToProcessing);
    System.out
        .println("In hotel has been registered and living " + counter + " guests at this moment");
  }
}
