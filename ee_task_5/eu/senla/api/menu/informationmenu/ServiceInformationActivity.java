package eu.senla.api.menu.informationmenu;

import eu.senla.model.hotel.Hotel;
import eu.senla.utils.userinput.ProcessUserInput;

public class ServiceInformationActivity {
  private boolean isRight = false;
  private int userChoice;
  public void serviceInformationMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {
    do {
      while (!isRight) {
        showServiceInformationMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 8) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }
            case 1: {
              String serviceNameToPrint = null;
              System.out.println("Please enter service name");
              try {
                System.out.println("View service detail");
                serviceNameToPrint = processUserInput.processUserStringInput();
                hotel.getPrintInformation().getPrintServiceDetails().printServiceDetails(
                    hotel.getProcessingServices().selectServiceByName(serviceNameToPrint));
              } catch (NullPointerException e) {
                System.out.println(
                    "Service with name: " + serviceNameToPrint + " not available in hotel");
              }
              System.out.println();
              isRight = false;
              break;
            }
            case 2: {
              int serviceNumberToPrint = 0;
              System.out.println("Please enter service name");
              try {
                System.out.println("View service detail");
                serviceNumberToPrint = processUserInput.processUserIntegerNumericInput();
                hotel.getPrintInformation().getPrintServiceDetails().printServiceDetails(
                    hotel.getProcessingServices().selectServiceByCounter(serviceNumberToPrint));
              } catch (NullPointerException e) {
                System.out.println(
                    "Service with number: " + serviceNumberToPrint + " not available in hotel");
              }
              System.out.println();
              isRight = false;
              break;
            }
            case 3: {
              System.out.println("List of services, sorted by name (Ascending)");
              hotel.getPrintInformation().getPrintServicesByName().printServicesByNameAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 4: {
              System.out.println("List of services, sorted by name (Descending)");
              hotel.getPrintInformation().getPrintServicesByName().printServicesByNameDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 5: {
              System.out.println("List of services, sorted by price (Ascending)");
              hotel.getPrintInformation().getPrintServicesByPrice().printServicesByPriceAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 6: {
              System.out.println("List of services, sorted by price (Descending)");
              hotel.getPrintInformation().getPrintServicesByPrice().printServicesByPriceDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 7: {
              System.out.println("List of services, sorted by type (Ascending)");
              hotel.getPrintInformation().getPrintServicesByType().printServicesByTypeAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 8: {
              System.out.println("List of services, sorted by type (Descending)");
              hotel.getPrintInformation().getPrintServicesByType().printServicesByTypeDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
          }
        } else {
          System.out.println("You have entered wrong number");
        }
      }
    } while (userChoice != 0);

  }

  public void showServiceInformationMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Service information menu **********");
    System.out.println("1 - View information about one of services by name");
    System.out.println("2 - View information about one of services by number");
    System.out.println("3 - List of services, sorted by name (Ascending)");
    System.out.println("4 - List of services, sorted by name (Descending)");
    System.out.println("5 - List of services, sorted by price (Ascending)");
    System.out.println("6 - List of services, sorted by price (Descending)");
    System.out.println("7 - List of services, sorted by type (Ascending)");
    System.out.println("8 - List of services, sorted by type (Descending)");
    System.out.println("0 - Exit to previous level");
    System.out.println();

  }
}
