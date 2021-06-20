package eu.senla.api.menu.hotelmenu;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.utils.userinput.ProcessUserInput;

public class WorkWithRooms {

  private boolean isRight = false;
  private int userChoice;

  public void workWithRoomsActivity(Hotel hotel, ProcessUserInput processUserInput) {
    do {
      while (!isRight) {
        showWorkWithRoomsMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 5) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }
            case 1: {
              System.out.println("Adding new room");
              Room roomToAdd;
              int roomToAddNumber;
              int roomToAddRating;
              int roomToAddMaxCapacity;
              double roomToAddPrice;
              do {
                System.out.println("Please enter number of new room");
                roomToAddNumber = processUserInput.processUserIntegerNonZeroNumericInput();
                boolean isExist = false;
                for (int i = 0; i < hotel.getRoomsList().getHotelRoom().size(); i++) {
                  isExist = false;
                  if (hotel.getRoomsList().getHotelRoom().get(i).getRoomNumber()
                      == roomToAddNumber) {
                    isExist = true;
                    break;
                  }
                }
                if (isExist) {
                  System.out.println("Room with #" + roomToAddNumber + " is exist in hotel");
                  isRight = false;
                } else {
                  break;
                }

              } while (!isRight);
              System.out.println("Please enter rating of new room");
              roomToAddRating = processUserInput.processUserIntegerNonZeroNumericInput();
              System.out.println("Please enter maximum quantity person in new room");
              roomToAddMaxCapacity = processUserInput.processUserIntegerNonZeroNumericInput();
              System.out.println("Please enter price of new room");
              roomToAddPrice = processUserInput.processUserDoubleNumericInput();
              roomToAdd = new Room(roomToAddNumber, roomToAddMaxCapacity, roomToAddRating,
                  roomToAddPrice);
              hotel.getRoomsList().getHotelRoom().add(roomToAdd);
              System.out.println("Room successful added:");
              hotel.getPrintInformation().getPrintRoomDetails().printRoomDetails(hotel, roomToAdd);
              System.out.println();

              processUserInput.makingPauseAfterActivity();
              isRight = false;
              break;
            }
            case 2: {
              System.out.println("Please enter room number");
              Room roomToChange = null;
              int roomNumberToChange = 0;
              do {
                System.out.println("Please enter number of room");
                roomNumberToChange = processUserInput.processUserIntegerNumericInput();
                boolean isExist = false;
                for (int i = 0; i < hotel.getRoomsList().getHotelRoom().size(); i++) {
                  isExist = false;
                  if (hotel.getRoomsList().getHotelRoom().get(i).getRoomNumber()
                      == roomNumberToChange) {
                    isExist = true;
                    break;
                  }
                }
                if (!isExist) {
                  System.out.println("Room with #" + roomNumberToChange + " is not exist in hotel");
                  isRight = false;
                } else {
                  roomToChange = hotel.getSelectRoom()
                      .selectRoomByNumber(hotel.getRoomsList(), roomNumberToChange);
                  System.out.println("Please enter new room's price");
                  roomToChange.changeRoomPrice(processUserInput.processUserDoubleNumericInput());
                  break;
                }
              } while (!isRight);
              isRight = false;
              break;
            }
            case 3: {
              System.out.println("Please enter room number");
              Room roomToChange = null;
              int roomNumberToChange = 0;
              do {
                System.out.println("Please enter number of room");
                roomNumberToChange = processUserInput.processUserIntegerNumericInput();
                boolean isExist = false;
                for (int i = 0; i < hotel.getRoomsList().getHotelRoom().size(); i++) {
                  isExist = false;
                  if (hotel.getRoomsList().getHotelRoom().get(i).getRoomNumber()
                      == roomNumberToChange) {
                    isExist = true;
                    break;
                  }
                }
                if (!isExist) {
                  System.out.println("Room with #" + roomNumberToChange + " is not exist in hotel");
                  isRight = false;
                } else {
                  roomToChange = hotel.getSelectRoom()
                      .selectRoomByNumber(hotel.getRoomsList(), roomNumberToChange);
                  roomToChange.changeRoomState();
                  break;
                }
              } while (!isRight);
              isRight = false;
              break;
            }
            case 4: {
              System.out.println("Please enter room number");
              Room roomToChange = null;
              int roomNumberToChange = 0;
              do {
                System.out.println("Please enter number of room");
                roomNumberToChange = processUserInput.processUserIntegerNumericInput();
                boolean isExist = false;
                for (int i = 0; i < hotel.getRoomsList().getHotelRoom().size(); i++) {
                  isExist = false;
                  if (hotel.getRoomsList().getHotelRoom().get(i).getRoomNumber()
                      == roomNumberToChange) {
                    isExist = true;
                    break;
                  }
                }
                if (!isExist) {
                  System.out.println("Room with #" + roomNumberToChange + " is not exist in hotel");
                  isRight = false;
                } else {
                  roomToChange = hotel.getSelectRoom()
                      .selectRoomByNumber(hotel.getRoomsList(), roomNumberToChange);
                  System.out.println("Please enter new value of maximum quantity person in room");
                  roomToChange.changeRoomCapacity(processUserInput.processUserIntegerNonZeroNumericInput());
                  break;
                }
              } while (!isRight);
              isRight = false;
              break;
            }
            case 5: {
              System.out.println("Please enter room number");
              Room roomToChange = null;
              int roomNumberToChange = 0;
              do {
                System.out.println("Please enter number of room");
                roomNumberToChange = processUserInput.processUserIntegerNumericInput();
                boolean isExist = false;
                for (int i = 0; i < hotel.getRoomsList().getHotelRoom().size(); i++) {
                  isExist = false;
                  if (hotel.getRoomsList().getHotelRoom().get(i).getRoomNumber()
                      == roomNumberToChange) {
                    isExist = true;
                    break;
                  }
                }
                if (!isExist) {
                  System.out.println("Room with #" + roomNumberToChange + " is not exist in hotel");
                  isRight = false;
                } else {
                  roomToChange = hotel.getSelectRoom()
                      .selectRoomByNumber(hotel.getRoomsList(), roomNumberToChange);
                  System.out.println("Please enter new value of rating room");
                  roomToChange.changeRoomRating(processUserInput.processUserIntegerNonZeroNumericInput());
                  break;
                }
              } while (!isRight);
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

  public void showWorkWithRoomsMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Work with rooms menu **********");
    System.out.println("1 - Adding room");
    System.out.println("2 - Change room price");
    System.out.println("3 - Change room availability (in-service/out-of-service)");
    System.out.println("4 - Change room capacity");
    System.out.println("5 - Change room rating");
    System.out.println("0 - Exit to previous level");
    System.out.println();

  }
}
