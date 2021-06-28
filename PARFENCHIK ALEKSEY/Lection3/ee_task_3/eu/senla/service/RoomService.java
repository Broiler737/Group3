package eu.senla.service;

import eu.senla.dao.RoomsDao;
import eu.senla.model.guest.Guest;
import eu.senla.model.hotel.Hotel;
import eu.senla.model.room.Room;

import java.time.LocalDate;
import java.util.ArrayList;

public class RoomService {

    private final RoomsDao roomsDao;

    public RoomService(RoomsDao roomsDao) {
        this.roomsDao = roomsDao;

    }

    public Room[] getFreeInFutureRooms(Hotel informationToProcessing, LocalDate dateToCheck) {
        Room[] listOfFreeInFutureRooms;
        ArrayList<Room> tempListOfFreeInFutureRooms = new ArrayList<>(0);
        for (int i = 0; i < informationToProcessing.getRoomsDao().getRoomsList().size(); i++) {
            boolean isAllGuestCheckOut = false;
            for (int j = 0;
                 j < informationToProcessing.getRoomsDao().getRoomsList().get(i).getRoomCurrentGuest()
                         .size();
                 j++) {
                isAllGuestCheckOut = informationToProcessing.getRoomsDao().getRoomsList().get(i).getRoomCurrentGuest().get(j)
                        .getGuestCheckOutDate()
                        .isBefore(dateToCheck);
            }
            if (isAllGuestCheckOut) {
                tempListOfFreeInFutureRooms.add(informationToProcessing.getRoomsDao().getRoomsList().get(i));
            }
        }
        listOfFreeInFutureRooms = tempListOfFreeInFutureRooms.toArray(new Room[]{});
        return listOfFreeInFutureRooms;
    }

    public int getFreeRooms() {
        int numberOfFreeRooms = 0;
        Room[] tempHotelRoom = new Room[roomsDao.getRoomsList().size()];
        for (int i = 0; i < roomsDao.getRoomsList().size(); i++) {
            tempHotelRoom[i] = roomsDao.getRoomsList().get(i);
        }
        for (Room roomToCount : tempHotelRoom
        ) {
            if (roomToCount.isFree()) {
                numberOfFreeRooms++;
            }
        }
        return numberOfFreeRooms;
    }

    public Room findRoomByNumber(int roomNumber) {
        Room tempRoom = null;
        for (Room hotelRoom : roomsDao.getRoomsList()) {
            if (hotelRoom.getRoomNumber() == roomNumber) {
                tempRoom = hotelRoom;
            }
        }
        return tempRoom;
    }

    public void changeRoomPrice(Room room, double roomPrice) {
        room.setRoomPrice(roomPrice);
        System.out.println("Now room #" + room.getRoomNumber() + " costs " + roomPrice + "$ per night");
    }

    public void changeRoomState(Room room) {
        room.setInService();
        if (room.isInService()) {
            System.out.println("Now room #" + room.getRoomNumber() + " is in service");
        } else {
            System.out.println("Now room #" + room.getRoomNumber() + " is out of service");
        }
    }

    public final void changeRoomRating(Room room, int newRating) {
        room.setRoomRating(newRating);
    }

    public final void changeRoomCapacity(Room room, int newCapacity) {
        room.setRoomMaxCapacity(newCapacity);
    }

    public void processingArchivedGuests(Room roomToCheckOut, Guest[] currentRoomGuest) {
        Guest[][] tempArchivedGuest = new Guest[Room.getHistoryDepth()
                + 1][roomToCheckOut.getRoomMaxCapacity()];
        for (int i = 0; i < roomToCheckOut.getRoomArchivedGuest().length; i++) {
            if (roomToCheckOut.getRoomArchivedGuest()[i] != null) {
                tempArchivedGuest[i + 1] = roomToCheckOut.getRoomArchivedGuest()[i];
            }
        }
        tempArchivedGuest[0] = currentRoomGuest;
        System.out.println();
        for (int i = 0; i < roomToCheckOut.getRoomArchivedGuest().length; i++) {
            roomToCheckOut.getRoomArchivedGuest()[i] = tempArchivedGuest[i];
        }
    }

    public Room selectRoomByNumber(RoomsDao roomsDao, int roomNumber) {
        Room tempRoom = null;
        for (Room rooms : roomsDao.getRoomsList()
        ) {
            if (rooms.getRoomNumber() == roomNumber) {
                tempRoom = rooms;
                break;
            }
        }
        return tempRoom;
    }

    public Room selectSuitableRoom(RoomsDao roomsDao, int countOfGuests, int roomRating) {
        try {
            Room tempRoom = null;
            Room[] tempHotelRoom = new Room[roomsDao.getRoomsList().size()];
            for (int i = 0; i < roomsDao.getRoomsList().size(); i++) {
                tempHotelRoom[i] = roomsDao.getRoomsList().get(i);
            }
            for (Room room : tempHotelRoom) {
                if ((room.getRoomMaxCapacity() >= countOfGuests) && (room.isInService())
                        && (room.isFree()) && (room.getRoomRating() >= roomRating)) {
                    tempRoom = room;
                    System.out.println();
                    System.out.println("The suitable room was found");
                    break;
                } else {
                    if ((room.getRoomMaxCapacity() < countOfGuests)) {
                        System.out.println(
                                "Room #" + room.getRoomNumber() + " has only " + room.getRoomMaxCapacity()
                                        + " places. It's not suitable for " + countOfGuests + " guests");
                        System.out.println("The system try to found another room");
                        System.out.println();
                    }
                    if ((room.getRoomRating() < roomRating)) {
                        System.out.println(
                                "Room #" + room.getRoomNumber() + " has only " + room.getRoomRating()
                                        + "-star rating. It's not suitable for guests, who want to live in " + roomRating
                                        + "-star rating room");
                        System.out.println("The system try to found another room");
                        System.out.println();
                    }
                    if (!room.isFree()) {
                        System.out.println(
                                "Room #" + room.getRoomNumber() + " is not free. You could't check-in guests inside");
                        System.out.println("The system try to found another room");
                        System.out.println();
                    }
                    if (!room.isInService()) {
                        System.out.println(
                                "Room #" + room.getRoomNumber()
                                        + " is out-of-service. You could't check-in guests inside");
                        System.out.println("The system try to found another room");
                        System.out.println();
                    }
                }
            }
            return tempRoom;
        } catch (NullPointerException e) {
            System.out.println("System couldn't find any suitable room ");
            return null;
        }
    }

    public Room findGuestRoom(Hotel informationToProcessing, int guestHash) {
        Room tempRoom = null;
        for (int i = 0; i < informationToProcessing.getRoomsDao().getRoomsList().size(); i++) {
            if (!informationToProcessing.getRoomsDao().getRoomsList().get(i)
                .getRoomCurrentGuest()
                .isEmpty()) {
                for (int j = 0;
                    j < informationToProcessing.getRoomsDao().getRoomsList().get(i)
                        .getRoomCurrentGuest().size();
                    j++) {
                    if (informationToProcessing.getRoomsDao().getRoomsList().get(i).getRoomCurrentGuest()
                        .get(j).hashCode()==guestHash) {
                        tempRoom  = informationToProcessing.getRoomsDao().getRoomsList().get(i);
                        break;
                    }
                }
            }
        }
        return tempRoom;
    }
}