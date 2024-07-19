package Controller;

import Helper.MessageHelper;
import Model.Hotel;
import Model.Room;
import View.DisplayManager;
import View.MainView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The HotelReservationSystem class manages the operations related to hotel reservations.
 * This allows creating hotels, viewing hotel details, managing hotel properties, and simulating bookings.
 */
public class HRSController {
  private ArrayList<Hotel> hotels;

  /**
   * Constructs a new HotelReservationSystem with an empty list of hotels.
   */
  public HRSController() {
    this.hotels = new ArrayList<>();
  }

  /**
   * Creates a new hotel with the specified name and number of rooms.
   *
   * @param hotelName is the of the hotel to be created
   * @param numOfRooms is number of rooms of the newly created hotel (minimum is 1, maximum is 50)
   */
  public void createHotel(String hotelName, int numOfRooms) {
    for (Hotel hotel : hotels) {
      if (hotel.getName().equals(hotelName)) {
        MessageHelper.showErrorMessage(String.format("Hotel name '%s' already exists.", hotelName));
        return;
      }
    }
    if (numOfRooms < 1 || numOfRooms > 50)
      MessageHelper.showErrorMessage(String.format("Hotel name '%s' already exists.", hotelName));
    else {
      hotels.add(new Hotel(hotelName, numOfRooms));
      MessageHelper.showMessage("Success", String.format("Hotel '%s' successfully created with %d rooms.", hotelName, numOfRooms));
    }
  }

  /**
   * Displays the list of all hotels.
   */
  public void viewAllHotels() {
    // TODO: refactor, return the list of all hotels (as String[]? or something that the view can render)
    if (this.hotels.isEmpty()) {
      System.out.printf("No hotels found.\n");
    }
    else {
      DisplayManager.displayAllHotels(this.hotels); // remove
    }
  }

  /**
   * Displays detailed information about a specific hotel.
   *
   * @param hotelName the name of the hotel to view
   */
  public void viewSpecificHotel(String hotelName) {
    Scanner scanner = new Scanner(System.in);
    if (this.hotels.isEmpty()) {
      System.out.printf("No hotels found.\n");
      return;
    }

    Hotel hotel = findHotelByName(hotelName);
    if (hotel == null) {
      System.out.printf("Hotel name '%s' not found.\n", hotelName);
      return;
    }

    DisplayManager.displayHotelGeneralInfo(hotel);
    System.out.printf("\n0 - Go back to main menu");
    System.out.printf("\n1 - View all room details");
    System.out.printf("\n2 - View available rooms by provided check-in and check-out dates");
    System.out.printf("\n3 - View reservation details by provided guest name");
    System.out.printf("\nChoose your action: ");
    String choice = scanner.nextLine();
    if (choice.equals("0")) {
      System.out.printf("\nGoing back...\n");
      return;
    } 
    else if (choice.equals("1")) {
      System.out.printf("\n===========LOW-LEVEL INFORMATION==============\n");
      // maybe display ALL reservation first here with details
      DisplayManager.displayAllRoomsInHotel(hotel);
      System.out.printf("\nSelect a room to view in detail: ");
      String roomName = scanner.nextLine();
      DisplayManager.displaySpecificRoomInfo(hotel, roomName);

      Room selectedRoom = hotel.getRoom(roomName);
      if (selectedRoom != null) {
        System.out.printf("\n0 - Go back to main menu");
        System.out.printf("\n1 - View reservation details in the selected room '%s'", roomName);
        System.out.printf("\nChoose your action: ");
        String subChoice = scanner.nextLine();
        if (subChoice.equals("0")) {
          System.out.printf("\nGoing back...\n");
          return;
        }
        else if (subChoice.equals("1")) {
          DisplayManager.displayReservationInfoByRoom(hotel, selectedRoom);
        }
        else
          System.out.printf("\nInvalid choice.\n");
      }
    }
    else if (choice.equals("2")) {
      System.out.printf("\nSelect a date to view available and booked rooms\n");
      System.out.printf("Enter check-in date: ");
      int checkInDate = scanner.nextInt();
      scanner.nextLine();
      System.out.printf("Enter check-out date: ");
      int checkOutDate = scanner.nextInt();
      scanner.nextLine();
      DisplayManager.displayRoomsOnDate(hotel, checkInDate, checkOutDate);
    }
    else if (choice.equals("3")) {
      System.out.printf("\nEnter a guest name to view their reservations in detail: ");
      String guestName = scanner.nextLine();
      DisplayManager.displayReservationsByGuestName(hotel, guestName);
    }
    else
      System.out.printf("\nInvalid choice.\n");
  }

  /**
   * Manages the properties of a specific hotel, allowing changes to its details, rooms, and reservations.
   *
   * @param hotelName the name of the hotel to manage
   */
  public void manageHotel(String hotelName) {
    Scanner scanner = new Scanner(System.in);

    Hotel chosenHotel = findHotelByName(hotelName);

    if (chosenHotel == null) {
      System.out.printf("Hotel name '%s' not found. Exiting...\n", hotelName);
    }
    else {
      while (true) {
        DisplayManager.displayManageHotelUI();

        System.out.printf("Choose your action (Enter 0 to exit): ");
        int choice = scanner.nextInt();
        scanner.nextLine();        
          
        switch (choice) {
          case 0: // go back to previous          
            System.out.printf("Exiting...\n");
            return;          
          case 1:// change name of hotel (name must still be unique)
            System.out.printf("Set new name: ");
            // System.out.printf("Set new name (Enter 0 to exit): ");
            String newHotelName = scanner.nextLine();
            if (findHotelByName(newHotelName) == null) {
              chosenHotel.setName(newHotelName);
              System.out.printf("Successfully changed name to %s!\n", newHotelName);
              return;
            }
            else
              System.out.printf("%s already exists. Going back...\n", newHotelName);
            break;
          case 2: // add room(s)
            chosenHotel.addRoom("Standard"); // TODO: ask for input for roomType in View GUI
            System.out.printf("Successfully added a new room to %s!\n", chosenHotel.getName());
            break;
          case 3: // remove room(s)
            DisplayManager.displayAllRoomsInHotel(chosenHotel);
            System.out.printf("Enter room name to remove: ");
            String removeRoomName = scanner.nextLine();
            Room roomToRemove = chosenHotel.getRoom(removeRoomName);
            if (roomToRemove != null && roomToRemove.getReservations().isEmpty()) {
              chosenHotel.removeRoom(removeRoomName);
              System.out.printf("Successfully removed Room %s from hotel %s!\n", removeRoomName, chosenHotel.getName());
            }
            else
              System.out.printf("Cannot remove rooms since there are some reservations existing or room doesn't exist at all.\n");
            break;
          case 4: // update base price of rooms
            if (chosenHotel.areEmptyReservations()) {
              System.out.printf("Enter new base price for rooms: ");
              double newBasePrice = scanner.nextDouble();
              while (newBasePrice < 100.0) {
                System.out.printf("Base price must be at least 100.0. Please try again.\n");
                newBasePrice = scanner.nextDouble();
              }
              chosenHotel.setBasePrice(newBasePrice);
              System.out.printf("Base price updated to %.2f for hotel '%s'.\n", newBasePrice, chosenHotel.getName());
            }
            else
              System.out.printf("There are some reservations in rooms. Cannot update new base price.\n");
            break;
          case 5: // remove reservation
            DisplayManager.displayAllRoomsInHotel(chosenHotel);
            System.out.printf("Enter room to remove a reservation from: ");
            String roomName = scanner.nextLine();
            Room room = chosenHotel.getRoom(roomName);
            
            if (room != null && !room.getReservations().isEmpty()) {
              DisplayManager.displayReservationInfoByRoom(chosenHotel, room);
              System.out.printf("Enter guest name to remove reservation: ");
              String guestName = scanner.nextLine();
              room.removeReservation(guestName);
            }
            else
              System.out.printf("Room '%s' not found.\n", roomName);
            break;
          case 6: // remove hotel
            if (chosenHotel.areEmptyReservations()) {
              hotels.remove(chosenHotel);
              System.out.printf("Successfully removed hotel '%s'!\n", chosenHotel.getName());
              return;
            }
            else
              System.out.printf("Cannot remove hotel since there are some reservations left.\n");
            break;
          default:
            System.out.printf("Invalid choice. Please try again.\n");
        }
      }
    }
  }

  /**
   * Simulates the booking of a room in a specified hotel for a guest within a date range.
   *
   * @param hotelName the name of the hotel
   * @param guestName the name of the guest
   * @param checkInDate the check-in date
   * @param checkOutDate the check-out date
   */
  public void simulateBooking(String hotelName, String guestName, int checkInDate, int checkOutDate) {
    Hotel chosenHotel = findHotelByName(hotelName);
    
    if (chosenHotel != null) {
      ArrayList<Room> availableRooms = chosenHotel.getAvailableRoomsOnDate(checkInDate, checkOutDate);
      if (availableRooms.isEmpty())
        System.out.printf("No rooms available from day %d to day %d in hotel '%s'.\n", checkInDate, checkOutDate, hotelName);
      else {
        System.out.printf("Available rooms from day %d to day %d in hotel '%s':\n", checkInDate, checkOutDate, hotelName);
        for (Room room : availableRooms)
          System.out.printf("%s\n", room.getName());

        // automated booking of room - get first available room
        Room roomToBook = availableRooms.getFirst();
        roomToBook.addReservation(guestName, checkInDate, checkOutDate);
        System.out.printf("Booking successful for room '%s'.\n", roomToBook.getName());
      }
    }
    else
      System.out.printf("Hotel '%s' not found.\n", hotelName);
  }

  /**
   * Finds a hotel by its name.
   *
   * @param hotelName the name of the hotel to find
   * @return the Hotel object if found, otherwise null
   */
  public Hotel findHotelByName(String hotelName) {
    for (Hotel hotel : hotels) {
      if (hotel.getName().equals(hotelName)) 
        return hotel;
    }
    return null;
  }

  /**
   * Gets the list of all hotels.
   *
   * @return the list of hotels
   */
  public ArrayList<Hotel> getHotels() {
    return this.hotels;
  }
}
