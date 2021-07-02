package eu.senla.model.room;

import eu.senla.model.guest.Guest;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private final int number;
    private double price;
    private int maxCapacity;
    private int rating;
    private boolean isFree;
    private boolean isInService;
    private static final int HISTORY_DEPTH = 3;
    private List<Guest> currentGuest = new ArrayList<>();
    private Guest[][] archivedGuest = new Guest[HISTORY_DEPTH][maxCapacity];


    public Room(int number, int maxCapacity, int rating, double price) {
        this.number = number;
        this.price = price;
        this.maxCapacity = maxCapacity;
        this.rating = rating;
        this.isFree = true;
        this.isInService = true;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Guest> getCurrentGuest() {
        return currentGuest;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public Guest[][] getArchivedGuest() {
        return archivedGuest;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }

    public boolean isFree() {
        return isFree;
    }

    public boolean isInService() {
        return isInService;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
