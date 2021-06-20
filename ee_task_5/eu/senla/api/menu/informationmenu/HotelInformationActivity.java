package eu.senla.api.menu.informationmenu;

import eu.senla.model.hotel.Hotel;
import eu.senla.utils.userinput.ProcessUserInput;
import java.time.LocalDate;

public class HotelInformationActivity {

  private boolean isRight = false;
  private int userChoice;

  public void hotelInformationMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {
    do {
      while (!isRight) {
        showHotelInformationMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 4) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }
            case 1: {
              System.out.println("Quantity free rooms in hotel:");
              hotel.getPrintInformation().getPrintCountOfFreeRoomsInHotel()
                  .printCountOfFreeRoomsInHotel(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 2: {
              System.out.println("List rooms, which will be free at date in the future:");
              System.out.println("Please enter date in the future to check");
              LocalDate dateToCheck = processUserInput.processUserDateInput();
              hotel.getPrintInformation().getPrintListOfFreeInFutureRoomsInHotel()
                  .printListOfFreeInFutureRoomsInHotel(hotel, dateToCheck);
              System.out.println();
              isRight = false;
              break;
            }
            case 3: {
              System.out.println("Quantity guests have been registered in hotel at this moment:");
              hotel.getPrintInformation().getPrintCountOfHotelGuests()
                  .printCountOfHotelGuests(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 4: {
              System.out.println("Guests have been registered in hotel, sorted by room number");
              hotel.getPrintInformation().getPrintAllHotelGuestsByRoomNumber()
                  .printAllHotelGuestsByRoomNumber(hotel);
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

  public void showHotelInformationMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Hotel information menu **********");
    System.out.println("1 - Show quantity free rooms in hotel");
    System.out.println("2 - Show list rooms, which will be free at date in the future");
    System.out.println("3 - Show quantity guests have been registered in hotel at this moment");
    System.out.println("4 - View information about all guests in hotel, sorted by room number");
    System.out.println("0 - Exit to previous level");
    System.out.println();
  }
}
