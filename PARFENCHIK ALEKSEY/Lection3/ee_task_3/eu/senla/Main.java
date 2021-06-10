package eu.senla;

import eu.senla.hotel.Hotel;

public class Main {

    public static void main(String[] args) {
  /*
	Программа должна предоставлять возможность:
	 Действия
	  Поселить в номер
	  Выселить из номера
	  Изменить статус номера на ремонтируемый/обслуживаемый
	  Изменить цену номера или услуги
	  Добавить номер или услугу
	*/
        Hotel hotel = new Hotel();
        hotel.makingActions();
        System.out.println(hotel);

    }

}
