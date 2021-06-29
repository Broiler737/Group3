package eu.senla;


import eu.senla.model.hotel.Hotel;

public class Main {

  public static void main(String[] args) {

    Hotel hotel = new Hotel();


    initMenu.initMainMenu(hotel);
    System.out.println(hotel);

  }


}
