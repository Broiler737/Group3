package eu.senla.api.menu.hotelmenu;

import eu.senla.model.hotel.Hotel;
import eu.senla.utils.userinput.ProcessUserInput;

public class HotelMenu {

  private boolean isRight = false;
  private int userChoice;

  public void hotelMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {

    do {
      while (!isRight) {
        showHotelMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 2) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }
            case 1: {
              WorkWithRooms workWithRooms = new WorkWithRooms();
              workWithRooms.workWithRoomsActivity(hotel, processUserInput);
              isRight = false;
              break;
            }
            case 2: {
              WorkWithServices workWithServices = new WorkWithServices();
              workWithServices.workWithServicesActivity(hotel, processUserInput);
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

  public void showHotelMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Hotel menu **********");
    System.out.println("1 - Work with rooms");
    System.out.println("2 - Work with services");
    System.out.println("0 - Exit to previous level");
    System.out.println();

  }
}
