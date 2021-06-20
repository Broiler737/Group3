package eu.senla.api.menu.hotelmenu;

import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;
import eu.senla.model.service.Service;
import eu.senla.utils.userinput.ProcessUserInput;

public class WorkWithServices {

  private boolean isRight = false;
  private int userChoice;

  public void workWithServicesActivity(Hotel hotel, ProcessUserInput processUserInput) {
    do {
      while (!isRight) {
        showWorkWithServicesMenu();
        userChoice = processUserInput.processUserChoice();
        if ((userChoice <= 3) && (userChoice >= 0)) {
          isRight = true;
          switch (userChoice) {
            case 0: {
              break;
            }

            case 1: {
              System.out.println("Adding new service");
              Service serviceToAdd = null;
              String serviceToAddName;
              double serviceToAddPrice;
              String serviceToAddType;
              boolean isServiceToAddPerDay;

              do {
                System.out.println("Please enter name of new service");
                serviceToAddName = processUserInput.processUserStringInput();
                boolean isExist = false;
                for (int i = 0; i < hotel.getServices().getServices().size(); i++) {
                  isExist = false;
                  if (hotel.getServices().getServices()
                      .get(hotel.getProcessingServices().countServiceId(i)).getServiceName()
                      .toLowerCase().equals(serviceToAddName.toLowerCase())) {
                    isExist = true;
                    break;
                  }
                }
                if (isExist) {
                  System.out
                      .println("Service with name " + serviceToAddName + " is exist in hotel");
                  isRight = false;
                } else {
                  break;
                }

              } while (!isRight);
              System.out.println("Please enter price of new service");
              serviceToAddPrice = processUserInput.processUserDoubleNumericInput();
              System.out.println("Please select type of service");
              System.out.println("Is new service InHouse?");
              System.out.println("Please enter Y or N");
              if (processUserInput.processUserBooleanInput()) {
                serviceToAddType = "InHouse";
              } else {
                serviceToAddType = "Outdoor";
              }
              System.out.println("Is new service could use whole day?");
              System.out.println("Please enter Y or N");
              isServiceToAddPerDay = processUserInput.processUserBooleanInput();
              serviceToAdd = new Service(serviceToAddName, serviceToAddPrice, serviceToAddType,
                  isServiceToAddPerDay);
              hotel.getProcessingServices().addService(serviceToAdd);
              System.out.println("Service successful added:");
              hotel.getPrintInformation().getPrintServiceDetails()
                  .printServiceDetails(serviceToAdd);
              processUserInput.makingPauseAfterActivity();
              isRight = false;
              break;
            }

            case 2: {
              String serviceToChangeName;
              double serviceToChangePrice;
              do {
                System.out.println("Please enter name of service");
                serviceToChangeName = processUserInput.processUserStringInput();
                boolean isExist = false;
                for (int i = 0; i < hotel.getServices().getServices().size(); i++) {
                  isExist = false;
                  if (hotel.getServices().getServices()
                      .get(hotel.getProcessingServices().countServiceId(i)).getServiceName()
                      .toLowerCase().equals(serviceToChangeName.toLowerCase())) {
                    isExist = true;
                    break;
                  }
                }
                if (!isExist) {
                  System.out
                      .println("Service with name " + serviceToChangeName + " is not exist in hotel");
                  isRight = false;
                } else {
                  System.out.println("Please enter new price of service");
                  serviceToChangePrice = processUserInput.processUserDoubleNumericInput();
                 hotel.getProcessingServices().selectServiceByName(serviceToChangeName).changeServicePrice(serviceToChangePrice);
                }

              } while (!isRight);
              processUserInput.makingPauseAfterActivity();
              isRight = false;
              break;
            }
             case 3: {
               do {
               String serviceToChangeName;
                 System.out.println("Please enter name of service");
                 serviceToChangeName = processUserInput.processUserStringInput();
                 boolean isExist = false;
                 for (int i = 0; i < hotel.getServices().getServices().size(); i++) {
                   isExist = false;
                   if (hotel.getServices().getServices()
                       .get(hotel.getProcessingServices().countServiceId(i)).getServiceName()
                       .toLowerCase().equals(serviceToChangeName.toLowerCase())) {
                     isExist = true;
                     break;
                   }
                 }
                 if (!isExist) {
                   System.out
                       .println("Service with name " + serviceToChangeName + " is not exist in hotel");
                   isRight = false;
                 } else {
                   hotel.getProcessingServices().selectServiceByName(serviceToChangeName).changeServiceAvailability();
                   break;
                 }

               } while (!isRight);
               processUserInput.makingPauseAfterActivity();
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

  public void showWorkWithServicesMenu() {
    System.out.println();
    System.out.println("********** Welcome to hotel management system **********");
    System.out.println();
    System.out.println("********** Work with services menu **********");
    System.out.println("1 - Adding service");
    System.out.println("2 - Change service price");
    System.out.println("3 - Change service availability");
    System.out.println("0 - Exit to previous level");
    System.out.println();

  }
}
