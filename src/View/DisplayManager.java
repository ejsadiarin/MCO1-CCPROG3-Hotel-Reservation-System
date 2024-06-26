package View;

import Model.Hotel;
import Model.Reservation;
import Model.Room;

import java.util.ArrayList;

/**
 * The DisplayManager class provides static methods to display various pieces of information about hotels, rooms, and reservations.
 */
public class DisplayManager {

  /**
   * Displays high-level information about the specified hotel.
   *
   * @param hotel the hotel to display high-level information
   */
  public static void displayHotelGeneralInfo(Hotel hotel) {
    // display high-level information about the hotel
    System.out.printf("\n===========HIGH-LEVEL INFORMATION==============\n");
    System.out.printf("Hotel Name: %s\n", hotel.getName());
    System.out.printf("Base Price Per Room: %.2f\n", hotel.getBasePrice());
    System.out.printf("Estimated Earnings: %s\n", hotel.getEstimatedEarnings());
    System.out.printf("Number of Rooms: %s\n", hotel.getNumOfRooms());
  }

  /**
   * Displays the total number of available and booked rooms for the specified date range.
   *
   * @param hotel the hotel to check room availability
   * @param checkInDate the check-in date
   * @param checkOutDate the check-out date
   */
  public static void displayRoomsOnDate(Hotel hotel, int checkInDate, int checkOutDate) {
    ArrayList<Room> availableRooms = hotel.getAvailableRoomsOnDate(checkInDate, checkOutDate);
    int bookedRooms = hotel.getNumOfRooms() - availableRooms.size();
    
    System.out.printf("Total number of available rooms from day %d to %d: %d\n", checkInDate, checkOutDate, availableRooms.size());
    System.out.printf("Total number of booked rooms from day %d to %d: %d\n", checkInDate, checkOutDate, bookedRooms);
  }

  /**
   * Displays information about the specified room in the hotel.
   *
   * @param hotel the hotel containing the room
   * @param roomName the name of the specific room to be displayed
   */
  public static void displaySpecificRoomInfo(Hotel hotel, String roomName) {
    Room selectedRoom = hotel.getRoom(roomName);
    
    if (selectedRoom != null) {
      System.out.printf("\n===========ROOM INFORMATION==============\n");
      System.out.printf("Room Name: %s\n", selectedRoom.getName());
      System.out.printf("Price per Night: %.2f\n", selectedRoom.getPricePerNight());
      System.out.printf("Room Earnings: %.2f\n", selectedRoom.getTotalEarnings());
      System.out.printf("Number of Reservations: %d\n", selectedRoom.getReservations().size());
      System.out.printf("\n-----Availability for the entire month:-----\n");
      for (int i = 1; i < 32; i++) {
        System.out.printf("Day %d: %s\n", i, selectedRoom.isAvailable(i, i) ? "Available" : "Booked");
      }
      
    } 
    else
      System.out.printf("\nRoom '%s' not found.\n", roomName);
  }

  /**
   * Displays information about all reservations for the specified room.
   *
   * @param hotel the hotel containing the room
   * @param room the room containing the reservations to be displayed
   */
  public static void displayReservationInfoByRoom(Hotel hotel, Room room) {
    if (room.getReservations().isEmpty()) {
      System.out.printf("No reservations found for room '%s'.\n", room.getName());
    } else {
      System.out.printf("\n-------RESERVATIONS for room '%s' (%d in total)-------\n", room.getName(), room.getReservations().size());
      
      // shows the reservations in the selected room separated by guest name
      for (Reservation reservation : room.getReservations()) {
        System.out.printf("\n======================================\n");
        System.out.printf("Guest: %s, Check-in: %d, Check-out: %d\n", reservation.getGuestName(), reservation.getCheckInDate(), reservation.getCheckOutDate());
        System.out.printf("Total Price: %.2f\n", reservation.getTotalPrice());
        System.out.printf("Price Breakdown per Night:\n");
        for (int i = reservation.getCheckInDate(); i <= reservation.getCheckOutDate(); i++) {
          System.out.printf("Day %d: %.2f\n", i, reservation.getRoom().getPricePerNight());
        }
        System.out.printf("======================================\n");
      }
    }
  }

  /**
   * Displays information about all reservations for the specified guest name.
   *
   * @param hotel the hotel to search for reservations
   * @param guestName the name of the guest to search for reservations
   */
  public static void displayReservationsByGuestName(Hotel hotel, String guestName) {
    boolean hasReservation = false; // false, bc assume that there is no reservation for guest yet
    
    for (Room room : hotel.getRooms()) {
      Reservation selectedReservation = room.getReservation(guestName);
      if (selectedReservation != null) {
        hasReservation = true;
        System.out.printf("\n===========RESERVATION INFORMATION==============\n");
        System.out.printf("Guest Name: %s\n", selectedReservation.getGuestName());
        System.out.printf("Room Name: %s\n", selectedReservation.getRoom().getName());
        System.out.printf("Check-in Date: %d\n", selectedReservation.getCheckInDate());
        System.out.printf("Check-out Date: %d\n", selectedReservation.getCheckOutDate());
        System.out.printf("Total Price: %.2f\n", selectedReservation.getTotalPrice());

        System.out.printf("Price Breakdown per Night:\n");
        for (int i = selectedReservation.getCheckInDate(); i < selectedReservation.getCheckOutDate(); i++) {
          System.out.printf("Day %d: %.2f\n", i, selectedReservation.getRoom().getPricePerNight());
        }
      }
    }
      
    // if no reservation for guest 
    if (!hasReservation) {
      System.out.printf("\nReservation for guest '%s' not found.\n", guestName);
    }

    System.out.printf("=========================================\n");
  }

  /**
   * Displays the main user interface options.
   */
  public static void displayMainUI() {
    System.out.printf("\n==============================================\n");
    System.out.printf("1 - Create a new hotel\n");
    System.out.printf("2 - View all hotels\n");
    System.out.printf("3 - Manage a hotel\n");
    System.out.printf("4 - Simulate booking\n");
    System.out.printf("0 - Exit the program\n");
    System.out.printf("==============================================\n");
  }

  /**
   * Displays the user interface options for managing a hotel.
   */
  public static void displayManageHotelUI() {
    System.out.printf("\n==============================================\n");
    System.out.printf("1 - Change name of the hotel\n");
    System.out.printf("2 - Add a room\n");
    System.out.printf("3 - Remove a room\n");
    System.out.printf("4 - Update the base price of the rooms\n");
    System.out.printf("5 - Remove a reservation\n");
    System.out.printf("6 - Remove hotel\n");
    System.out.printf("0 - Go back to previous menu\n");
    System.out.printf("==============================================\n");
  }

  /**
   * Displays the names of all hotels in the specified list.
   *
   * @param hotels the list of hotels to be displayed
   */
  public static void displayAllHotels(ArrayList<Hotel> hotels) {
    System.out.printf("\n-----ALL HOTELS------\n");
    for (Hotel hotel : hotels) {
      System.out.printf("%s\n", hotel.getName());
    }
  }

  /**
   * Displays the names and number of reservations for all rooms in the specified hotel.
   *
   * @param hotel the hotel of the rooms to be displayed
   */
  public static void displayAllRoomsInHotel(Hotel hotel) {
    System.out.printf("\n-----ALL ROOMS in Hotel %s------\n", hotel.getName());
    for (Room room : hotel.getRooms()) {
      System.out.printf("%s - %d total booked reservations\n", room.getName(), room.getReservations().size());
    }
  } 
}
