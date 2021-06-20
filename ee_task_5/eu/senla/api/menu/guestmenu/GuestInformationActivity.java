package eu.senla.api.menu.guestmenu;

import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.utils.userinput.ProcessUserInput;

public class GuestInformationActivity {
  private boolean isRight = false;
  private int userChoice;
  public void guestInformationActivity (Hotel hotel, ProcessUserInput processUserInput) {
    do {
      while (!isRight) {
        showGuestInformationMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 3) && (userChoice >= 0)) {
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
              System.out.println("Information about one of guests debt");
              System.out.println("Please enter guest name");
              try {
                String tempGuestName = processUserInput.processUserStringInput();
                Guest guestToPrint = hotel.getSelectGuest().selectGuestByName(hotel, tempGuestName);
                System.out.println("Guest debt is "+guestToPrint.getGuestDebt()+"$ at this moment");
              } catch (NullPointerException e) {
                System.out.println("Couldn't find this guest");
              }
              isRight = false;
              break;
            }
            case 3: {
              System.out.println("Information about one of guests debt for services");
              System.out.println("Please enter guest name");
              try {
                String tempGuestName = processUserInput.processUserStringInput();
                Guest guestToPrint = hotel.getSelectGuest().selectGuestByName(hotel, tempGuestName);
                System.out.println("Guest debt for services is "+guestToPrint.countDebtForServiceOfGuest()+"$ at this moment");
              } catch (NullPointerException e) {
                System.out.println("Couldn't find this guest");
              }
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
    System.out.println("2 - View information about one of guests debt ");
    System.out.println("3 - View information about one of guests debt for services ");
    System.out.println("0 - Exit to previous level");
    System.out.println();

  }

}
