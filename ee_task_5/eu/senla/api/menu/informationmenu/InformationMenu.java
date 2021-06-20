package eu.senla.api.menu.informationmenu;

import eu.senla.api.menu.guestmenu.CheckInMenuActivity;
import eu.senla.api.menu.guestmenu.CheckOutMenuActivity;
import eu.senla.model.hotel.Hotel;
import eu.senla.utils.userinput.ProcessUserInput;

public class InformationMenu {
  private boolean isRight = false;
  private int userChoice;

  public void informationMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {

    do {
      while (!isRight) { showInformationMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 4) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }
            case 1: {
              GuestInformationActivity guestInformationActivity = new GuestInformationActivity();
              guestInformationActivity.guestInformationMenuActivity(hotel,processUserInput);
              isRight=false;
              break;
            }
            case 2: {
              HotelInformationActivity hotelInformationActivity =new HotelInformationActivity();
              hotelInformationActivity.hotelInformationMenuActivity(hotel, processUserInput);
              isRight=false;
              break;
            }
            case 3: {
              RoomInformationActivity roomInformationActivity = new RoomInformationActivity();
              roomInformationActivity.roomInformationMenuActivity(hotel, processUserInput);
              isRight=false;
              break;
            }
            case 4: {
              ServiceInformationActivity serviceInformationActivity = new ServiceInformationActivity();
              serviceInformationActivity.serviceInformationMenuActivity(hotel, processUserInput);
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

  public void showInformationMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Information menu **********");
    System.out.println("1 - View information about guests");
    System.out.println("2 - View information about hotel");
    System.out.println("3 - View information about rooms");
    System.out.println("4 - View information about services");
    System.out.println("0 - Exit to previous level");
    System.out.println();

  }
}
