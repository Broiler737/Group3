package eu.senla.api.menu.informationmenu;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.utils.userinput.ProcessUserInput;

public class GuestInformationActivity {

  private boolean isRight = false;
  private int userChoice;

  public void guestInformationMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {
    do {
      while (!isRight) {
        showGuestInformationMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 9) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }
            case 1: {
              System.out.println("Please enter guest name");
              try {
                String tempGuestName = processUserInput.processUserStringInput();
                Guest guestToPrint = hotel.getSelectGuest().selectGuestByName(hotel, tempGuestName);
                hotel.getPrintInformation().getPrintGuestCard().printGuestCard(hotel, guestToPrint);
              } catch (NullPointerException e) {
                System.out.println("Couldn't find this guest");
              }
              isRight = false;
              break;
            }
            case 2: {
              System.out.println("Please enter guest name");
              try {
                String tempGuestName = processUserInput.processUserStringInput();
                System.out.println(
                    "View information ordered, by guest, services, sorted by name (Ascending)");
                Guest guestToPrint = hotel.getSelectGuest().selectGuestByName(hotel, tempGuestName);
                hotel.getPrintInformation().getPrintGuestServicesByName()
                    .printGuestServicesByNameAscending(hotel, guestToPrint.hashCode());
              } catch (NullPointerException e) {
                System.out.println("Couldn't find this guest");
              }
              isRight = false;
              break;
            }
            case 3: {
              System.out.println("Please enter guest name");
              try {
                String tempGuestName = processUserInput.processUserStringInput();
                System.out.println(
                    "View information ordered, by guest, services, sorted by name (Descending)");
                Guest guestToPrint = hotel.getSelectGuest().selectGuestByName(hotel, tempGuestName);
                hotel.getPrintInformation().getPrintGuestServicesByName()
                    .printGuestServicesByNameDescending(hotel, guestToPrint.hashCode());
              } catch (NullPointerException e) {
                System.out.println("Couldn't find this guest");
              }
              isRight = false;
              break;
            }
            case 4: {
              System.out.println("Please enter guest name");
              try {
                String tempGuestName = processUserInput.processUserStringInput();
                System.out.println(
                    "View information ordered, by guest, services, sorted by price (Ascending)");
                hotel.getPrintInformation().getPrintGuestServicesByPrice()
                    .printGuestByNameServicesByPriceAscending(hotel, tempGuestName);
              } catch (NullPointerException e) {
                System.out.println("Couldn't find this guest");
              }
              isRight = false;
              break;
            }
            case 5: {
              System.out.println("Please enter guest name");
              try {
                String tempGuestName = processUserInput.processUserStringInput();
                System.out.println(
                    "View information ordered, by guest, services, sorted by price (Descending)");
                hotel.getPrintInformation().getPrintGuestServicesByPrice()
                    .printGuestByNameServicesByPriceAscending(hotel, tempGuestName);
              } catch (NullPointerException e) {
                System.out.println("Couldn't find this guest");
              }
              isRight = false;
              break;
            }
            case 6: {
              System.out.println("List of guests, sorted by name (Ascending)");
              hotel.getPrintInformation().getPrintGuestsByName().printGuestsByNameAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 7: {
              System.out.println("List of guests, sorted by name (Descending)");
              hotel.getPrintInformation().getPrintGuestsByName().printGuestsByNameDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 8: {
              System.out.println("List of guests, sorted by check-out date (Ascending)");
              hotel.getPrintInformation().getPrintGuestsByCheckOutDate()
                  .printGuestsByCheckOutDateAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 9: {
              System.out.println("List of guests, sorted by check-out date (Descending)");
              hotel.getPrintInformation().getPrintGuestsByCheckOutDate()
                  .printGuestsByCheckOutDateDescending(hotel);
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

  public void showGuestInformationMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Guest information menu **********");
    System.out.println("1 - View information about one of guests");
    System.out
        .println("2 - View information ordered, by guest, services, sorted by name (Ascending)");
    System.out
        .println("3 - View information ordered, by guest, services, sorted by name (Descending)");
    System.out
        .println("4 - View information ordered, by guest, services, sorted by price (Ascending)");
    System.out
        .println("5 - View information ordered, by guest, services, sorted by price (Descending)");
    System.out.println("6 - List of guests, sorted by name (Ascending)");
    System.out.println("7 - List of guests, sorted by name (Descending)");
    System.out.println("8 - List of guests, sorted by check-out date (Ascending)");
    System.out.println("9 - List of guests, sorted by check-out date (Descending)");
    System.out.println("0 - Exit to previous level");
    System.out.println();
  }
}
