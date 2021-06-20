package eu.senla.api.menu.informationmenu;

import eu.senla.model.hotel.Hotel;
import eu.senla.utils.userinput.ProcessUserInput;

public class RoomInformationActivity {

  private boolean isRight = false;
  private int userChoice;

  public void roomInformationMenuActivity(Hotel hotel, ProcessUserInput processUserInput) {
    do {
      while (!isRight) {
        showRoomInformationMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 14) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }
            case 1: {
              System.out.println("Information about room");
              System.out.println("Please enter room number");
              int roomToPrint = 0;
              try {
                roomToPrint = processUserInput.processUserIntegerNumericInput();
                hotel.getPrintInformation().getPrintRoomDetails().printRoomDetails(hotel,
                    hotel.getSelectRoom().selectRoomByNumber(hotel.getRoomsList(), roomToPrint));
              } catch (NullPointerException e) {
                System.out.println("Room #" + roomToPrint + " not found in hotel");
              }
              System.out.println();
              isRight = false;
              break;
            }
            case 2: {
              System.out.println("Room's archived guests");
              System.out.println("Please enter room number, to show list of archived guest");
              int roomToPrint = 0;
              try {
                roomToPrint = processUserInput.processUserIntegerNumericInput();
                hotel.getPrintInformation().getPrintRoomArchivedGuests()
                    .printRoomArchivedGuests(hotel,
                        hotel.getSelectRoom()
                            .selectRoomByNumber(hotel.getRoomsList(), roomToPrint));
              } catch (NullPointerException e) {
                System.out.println("Room #" + roomToPrint + " not found in hotel");
              }
              System.out.println();
              isRight = false;
              break;
            }
            case 3: {
              System.out.println("List of rooms, sorted by rating (Ascending)");
              hotel.getPrintInformation().getPrintHotelRoomsByRating()
                  .printHotelRoomsByRatingAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 4: {
              System.out.println("List of rooms, sorted by rating (Descending)");
              hotel.getPrintInformation().getPrintHotelRoomsByRating()
                  .printHotelRoomsByRatingDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 5: {
              System.out.println("List of rooms, sorted by price (Ascending)");
              hotel.getPrintInformation().getPrintHotelRoomsByPrice()
                  .printHotelRoomsByPriceAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 6: {
              System.out.println("List of rooms, sorted by price (Descending)");
              hotel.getPrintInformation().getPrintHotelRoomsByPrice()
                  .printHotelRoomsByPriceDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 7: {
              System.out.println("List of rooms, sorted by capacity (Ascending)");
              hotel.getPrintInformation().getPrintHotelRoomsByCapacity()
                  .printHotelRoomsByCapacityAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 8: {
              System.out.println("List of rooms, sorted by capacity (Descending)");
              hotel.getPrintInformation().getPrintHotelRoomsByCapacity()
                  .printHotelRoomsByCapacityDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 9: {
              System.out.println("List of free rooms, sorted by rating (Ascending)");
              hotel.getPrintInformation().getPrintHotelFreeRoomsByRating()
                  .printHotelFreeRoomsByRatingAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 10: {
              System.out.println("List of free rooms, sorted by rating (Descending)");
              hotel.getPrintInformation().getPrintHotelFreeRoomsByRating()
                  .printHotelFreeRoomsByRatingDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 11: {
              System.out.println("List of free rooms, sorted by price (Ascending)");
              hotel.getPrintInformation().getPrintHotelFreeRoomsByPrice()
                  .printHotelFreeRoomsByPriceAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 12: {
              System.out.println("List of free rooms, sorted by price (Descending)");
              hotel.getPrintInformation().getPrintHotelFreeRoomsByPrice()
                  .printHotelFreeRoomsByPriceDescending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 13: {
              System.out.println("List of free rooms, sorted by capacity (Ascending)");
              hotel.getPrintInformation().getPrintHotelFreeRoomsByCapacity()
                  .printHotelFreeRoomsByCapacityAscending(hotel);
              System.out.println();
              isRight = false;
              break;
            }
            case 14: {
              System.out.println("List of free rooms, sorted by capacity (Descending)");
              hotel.getPrintInformation().getPrintHotelFreeRoomsByCapacity()
                  .printHotelFreeRoomsByCapacityDescending(hotel);
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

  public void showRoomInformationMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Rooms information menu **********");
    System.out.println("1 - View information about one of rooms");
    System.out.println("2 - View information about room's archived guests");
    System.out.println("3 - List of rooms, sorted by rating (Ascending)");
    System.out.println("4 - List of rooms, sorted by rating (Descending)");
    System.out.println("5 - List of rooms, sorted by price (Ascending)");
    System.out.println("6 - List of rooms, sorted by price (Descending)");
    System.out.println("7 - List of rooms, sorted by capacity (Ascending)");
    System.out.println("8 - List of rooms, sorted by capacity (Descending)");
    System.out.println();
    System.out.println("9 - List of free rooms, sorted by rating (Ascending)");
    System.out.println("10 - List of free rooms, sorted by rating (Descending)");
    System.out.println("11 - List of free rooms, sorted by price (Ascending)");
    System.out.println("12 - List of free rooms, sorted by price (Descending)");
    System.out.println("13 - List of free rooms, sorted by capacity (Ascending)");
    System.out.println("14 - List of free rooms, sorted by capacity (Descending)");
    System.out.println("0 - Exit to previous level");
    System.out.println();
  }
}
