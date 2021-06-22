package eu.senla.utils.userinput;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Scanner;

public class ProcessingUserInput {

  public int processUserChoice() {
    int tempUserChoice = 0;
    boolean isRight = false;
    Scanner readInput = new Scanner(System.in);
    do {
      try {
        System.out.print("Please make your choice:");
        System.out.println();
        tempUserChoice = Integer.parseInt(readInput.nextLine());
        isRight = true;
      } catch (NumberFormatException e) {
        System.out.println();
        System.out.println("You have made wrong choice");
        System.out.println("Please re-enter:");
      }
    } while (!isRight);
    return tempUserChoice;
  }

  public int processUserIntegerNumericInput() {
    int tempUserNumericInput = 0;
    boolean isRight = false;
    Scanner readInput = new Scanner(System.in);
    do {
      try {
        tempUserNumericInput = Integer.parseInt(readInput.nextLine());
        isRight = true;
      } catch (NumberFormatException e) {
        System.out.println();
        System.out.println("You have enter non-numeric value");
        System.out.println("Please re-enter:");
      }
    } while (!isRight);
    return tempUserNumericInput;
  }

  public int processUserIntegerNonZeroNumericInput() {
    int tempUserNumericInput = 0;
    boolean isRight = false;
    Scanner readInput = new Scanner(System.in);
    do {
      try {
        tempUserNumericInput = Integer.parseInt(readInput.nextLine());
        isRight = true;
        if (tempUserNumericInput <= 0) {
          isRight = false;
          System.out.println("You have to enter non-zero positive value");
        }
      } catch (NumberFormatException e) {
        System.out.println();
        System.out.println("You have enter non-numeric value");
        System.out.println("Please re-enter:");
      }
    } while (!isRight);
    return tempUserNumericInput;
  }

  public String processUserStringInput() {
    String tempUserStringInput;
    boolean isRight = false;
    Scanner readInput = new Scanner(System.in);
    do {
      tempUserStringInput = readInput.nextLine();
      if (tempUserStringInput.length() != 0) {
        isRight = true;
      } else {
        System.out.println("You have to enter non-zero value");
      }
    } while (!isRight);
    return tempUserStringInput;
  }

  public double processUserDoubleNumericInput() {
    double tempUserNumericInput = 0.0;
    boolean isRight = false;
    Scanner readInput = new Scanner(System.in);
    do {
      try {
        tempUserNumericInput = Double.parseDouble(readInput.nextLine());
        isRight = true;
        if (tempUserNumericInput <= 0) {
          isRight = false;
          System.out.println("You have to enter non-zero positive value");
        }
      } catch (NumberFormatException e) {
        System.out.println();
        System.out.println("You have enter non-numeric value");
        System.out.println("Please re-enter:");
      }
    } while (!isRight);
    return tempUserNumericInput;
  }
  public boolean processUserBooleanInput() {
    boolean tempUserBooleanInput = false;
    Character tempUserCharInput;
    boolean isRight = false;
    Scanner readInput = new Scanner(System.in);
    do {
      tempUserCharInput = readInput.nextLine().toUpperCase().charAt(0);
      if ((tempUserCharInput =='Y') || (tempUserCharInput =='N') ){
        if (tempUserCharInput =='Y'){
          tempUserBooleanInput=true;
        }
        isRight = true;
      } else {
        System.out.println("You have to enter wrong value");
      }
    } while (!isRight);
    return tempUserBooleanInput;
  }

  public void makingPauseAfterActivity() {
    System.out.println("Press Enter");
    String tempUserStringInput;
    boolean isRight = false;
    Scanner readInput = new Scanner(System.in);
    do {
      tempUserStringInput = readInput.nextLine();
      if (tempUserStringInput.length() == 0) {
        isRight = true;
      } else {
        System.out.println("Just press Enter");
      }
    } while (!isRight);
  }

  public LocalDate processUserDateInput() {
    LocalDate tempUserDateInput;
    boolean isRight = false;
    Scanner readInput = new Scanner(System.in);
    int year;
    int month;
    int day;
    do {
      System.out.println("Please enter year");
      year = processUserIntegerNumericInput();
      if (year >= LocalDate.now().getYear()) {
        isRight = true;
      } else {
        System.out.println("You have to enter right value");
      }
    } while (!isRight);
    isRight = false;
    do {
      System.out.println("Please enter month");
      month = processUserIntegerNumericInput();
      if (year >= LocalDate.now().getYear() && ((month >= LocalDate.now().getMonthValue()) || (Year
          .of(year).isAfter(
              Year.of(LocalDate.now().getYear()))))
          && month <= 12) {
        isRight = true;
      } else {
        System.out.println("You have to enter right value");
      }
    } while (!isRight);
    isRight = false;
    do {
      System.out.println("Please enter day");
      day = processUserIntegerNumericInput();
      if ((LocalDate.now().isBefore(LocalDate.of(year, month, day).plusDays(1))) && (day <= Month
          .of(month).maxLength())) {
        isRight = true;
      } else {
        System.out.println("You have to enter right value");
      }
    } while (!isRight);
    tempUserDateInput = LocalDate.of(year, month, day);
    return tempUserDateInput;
  }
}
