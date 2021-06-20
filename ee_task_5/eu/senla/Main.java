package eu.senla;

import eu.senla.api.menu.InitMenu;
import eu.senla.model.hotel.Hotel;

public class Main {

  public static void main(String[] args) {
    Hotel hotel = new Hotel();
    InitMenu initMenu = new InitMenu();
    initMenu.initMainMenu(hotel);
    System.out.println(hotel);

  }


}
