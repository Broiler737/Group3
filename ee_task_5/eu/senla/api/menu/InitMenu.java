package eu.senla.api.menu;

import eu.senla.api.menu.mainmenu.MainMenu;
import eu.senla.model.hotel.Hotel;
import eu.senla.utils.userinput.ProcessUserInput;

public class InitMenu {

  // private final MainMenu mainMenu;

 /* public InitMenu(MainMenu mainMenu) {
    this.mainMenu = mainMenu;
  }*/

  public InitMenu() {

  }

  public void initMainMenu(Hotel hotel) {
    MainMenu mainMenu = new MainMenu();
    do {
      ProcessUserInput processUserInput = new ProcessUserInput();
      mainMenu.mainMenuActivity(hotel, processUserInput);
    } while (mainMenu.getUserChoice() != 0);
  }
}