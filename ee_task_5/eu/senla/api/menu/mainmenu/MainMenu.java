package eu.senla.api.menu.mainmenu;

import eu.senla.api.menu.guestmenu.GuestMenu;
import eu.senla.api.menu.hotelmenu.HotelMenu;
import eu.senla.api.menu.informationmenu.InformationMenu;
import eu.senla.model.hotel.Hotel;
import eu.senla.utils.userinput.ProcessUserInput;

public class MainMenu {

  private boolean isRight = false;
  private int userChoice;

  public void mainMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {
    showMainMenu();
    while (!isRight) {
      userChoice = processUserInput.processUserChoice();
      if ((userChoice <= 3) && (userChoice >= 0)) {
        switch (userChoice) {
          case 0: {
            System.out.println("You have chosen leave the system");
            System.out.println("Leaving...");
            isRight = true;
            break;
          }
          case 1: {
            GuestMenu guestMenu = new GuestMenu();
            guestMenu.guestMenuActivity(hotel, processUserInput);
            isRight = false;
            showMainMenu();
            break;
          }
          case 2: {
            HotelMenu hotelMenu = new HotelMenu();
            hotelMenu.hotelMenuActivity(hotel, processUserInput);
            isRight = false;
            showMainMenu();
            break;
          }
          case 3: {
            InformationMenu informationMenu = new InformationMenu();
            informationMenu.informationMenuActivity(hotel, processUserInput);
            isRight = false;
            showMainMenu();
            break;
          }
        }
      } else {
        System.out.println("You have entered wrong number");
        userChoice = processUserInput.processUserChoice();
      }
    }
  }

  private void showMainMenu() {
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Main menu **********");
    System.out.println("1 - Work with guests");
    System.out.println("2 - Work with hotel");
    System.out.println("3 - Information");
    System.out.println("0 - Exit");
    System.out.println();
  }

  public int getUserChoice() {
    return userChoice;
  }
}