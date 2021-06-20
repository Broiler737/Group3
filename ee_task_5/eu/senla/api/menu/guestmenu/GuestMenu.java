package eu.senla.api.menu.guestmenu;

import eu.senla.utils.userinput.ProcessUserInput;
import eu.senla.model.hotel.Hotel;

public class GuestMenu {

  private boolean isRight = false;
  private int userChoice;

  public void guestMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {

    do {
      while (!isRight) { showGuestMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 4) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }
            case 1: {
              CheckInMenuActivity checkInMenuActivity = new CheckInMenuActivity();
              checkInMenuActivity.checkInMenuActivity(hotel, processUserInput);
              isRight=false;
              break;
            }
            case 2: {
              CheckOutMenuActivity checkOutMenuActivity=new CheckOutMenuActivity();
              checkOutMenuActivity.checkOutMenuActivity(hotel, processUserInput);
              isRight=false;
              break;
            }
            case 3: {
             GuestServiceMenuActivity guestServiceMenuActivity=new GuestServiceMenuActivity();
             guestServiceMenuActivity.addServiceToGuest(hotel, processUserInput);
              isRight=false;
              break;
            }
            case 4: {
             GuestInformationActivity guestInformationActivity=new GuestInformationActivity();
             guestInformationActivity.guestInformationActivity(hotel, processUserInput);
              isRight=false;
              break;
            }
          }
        } else {
          System.out.println("You have entered wrong number");
        }
      }
    } while (userChoice != 0);

  }

  public void showGuestMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Guest menu **********");
    System.out.println("1 - Check-in guests");
    System.out.println("2 - Check-out guests");
    System.out.println("3 - Adding service to guest");
    System.out.println("4 - Show information about guest");
    System.out.println("0 - Exit to previous level");
    System.out.println();

  }

}
