package behavioural;

import java.util.Scanner;

public class HotelCheckIn {
    public static String decide(String booking, String identity, int rooms, String arrival) {
        if (booking.equals("CANCELLED"))
            return "Booking Cancelled";
        if (booking.equals("PENDING"))
            return "Booking Pending";
        if (identity.equals("UNVERIFIED"))
            return "Verify Identity";
        if (rooms < 1 || rooms >= 3)
            return "Invalid Room Count";
        if (arrival.equals("EARLY"))
            return "Standard Check-in Approved";
        if (arrival.equals("LATE"))
            return "Late Arrival Check-in";
        return "Standard Check-in Approved";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Booking: ");
        String booking = sc.nextLine().trim().toUpperCase();
        System.out.print("Identity: ");
        String identity = sc.nextLine().trim().toUpperCase();
        System.out.print("Rooms requested: ");
        String rawRooms = sc.nextLine().trim();
        System.out.print("Arrival: ");
        String arrival = sc.nextLine().trim().toUpperCase();
        try {
            int rooms = Integer.parseInt(rawRooms);
            System.out.println("RESULT: " + decide(booking, identity, rooms, arrival));
        } catch (NumberFormatException e) {
            System.out.println("RESULT: Invalid Numeric Input");
        }
        sc.close();
    }
}
