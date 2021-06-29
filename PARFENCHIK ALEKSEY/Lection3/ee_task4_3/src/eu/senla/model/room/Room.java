package eu.senla.model.room;

import eu.senla.model.guest.Guest;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private final int roomNumber;
    private double roomPrice;
    private int roomMaxCapacity;
    private int roomRating;
    private boolean isFree;
    private boolean isInService;
    private static final int HISTORY_DEPTH = 3;
    private List<Guest> roomCurrentGuest = new ArrayList<>();
    private Guest[][] roomArchivedGuest = new Guest[HISTORY_DEPTH][roomMaxCapacity];


    public Room(int roomNumber, int roomMaxCapacity, int roomRating, double roomPrice) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomMaxCapacity = roomMaxCapacity;
        this.roomRating = roomRating;
        this.isFree = true;
        this.isInService = true;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setRoomMaxCapacity(int roomMaxCapacity) {
        this.roomMaxCapacity = roomMaxCapacity;
    }

    public List<Guest> getRoomCurrentGuest() {
        return roomCurrentGuest;
    }

    public void setRoomRating(int roomRating) {
        this.roomRating = roomRating;
    }

    public void setInService() {
        isInService = !this.isInService;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public static int getHistoryDepth() {
        return HISTORY_DEPTH;
    }

    public Guest[][] getRoomArchivedGuest() {
        return roomArchivedGuest;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public int getRoomRating() {
        return roomRating;
    }

    public boolean isFree() {
        return isFree;
    }

    public boolean isInService() {
        return isInService;
    }

    public int getRoomMaxCapacity() {
        return roomMaxCapacity;
    }
}