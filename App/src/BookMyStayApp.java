import java.util.*;

abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public double getPricePerNight() { return pricePerNight; }
}

class SingleRoom extends Room {
    public SingleRoom() { super(1, 250, 1500.0); }
}

class Service {
    private String serviceName;
    private double cost;

    public Service(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() { return serviceName; }
    public double getCost() { return cost; }
}

class BookingConfirmationService {
    public void confirmBooking(String guestName, String reservationId, Room room, double addonCost) {
        double roomPrice = room.getPricePerNight();
        double totalBill = roomPrice + addonCost;

        System.out.println("Final Booking Confirmation");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Room Charges: " + roomPrice);
        System.out.println("Add-on Charges: " + addonCost);
        System.out.println("Total Bill: " + totalBill);
        System.out.println("\nBooking Successful!");
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        BookingConfirmationService confirmationService = new BookingConfirmationService();

        String guestName = "Abhi";
        String resId = "Single-1";
        Room selectedRoom = new SingleRoom();
        double totalAddons = 1500.0;

        confirmationService.confirmBooking(guestName, resId, selectedRoom, totalAddons);
    }
}