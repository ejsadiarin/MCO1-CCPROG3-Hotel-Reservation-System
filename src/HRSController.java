import Model.Hotel;
import Model.Room;
import java.util.ArrayList;
import java.util.Scanner;

public class HRSController {
  private ArrayList<Hotel> hotels;
  
  public HRSController() {
    this.hotels = new ArrayList<>();
  }
  
  // By default, hotel should have 50 maxRooms
  public void createHotel(String hotelName) {
    for (Hotel hotel : hotels) {
      if (hotel.getName().equals(hotelName)) {
        System.out.printf("Hotel name '%s' already exists.\n", hotelName);
        return;
      }
    }
    hotels.add(new Hotel(hotelName, 50)); // TODO: should i change default maxRooms?
  }

  public void viewAllHotels() {
    if (this.hotels.isEmpty()) {
      System.out.printf("No hotels found.\n");
    }
    else {
      System.out.printf("\nHotels Created:\n");
      for (Hotel hotel : hotels) {
        System.out.printf("%s\n", hotel.getName());
      }
    }
  }
  
  public void viewSpecificHotel(String hotelName) {
    if (this.hotels.isEmpty()) {
      System.out.printf("No hotels found.\n");
    }
    else {
      for (Hotel hotel : hotels) {
        if (findHotelByName(hotelName) != null) {
          // TODO: display all hotel information
          System.out.printf("\n=========================================\n");
          System.out.printf("Hotel Name: %s\n", hotel.getName());
          System.out.printf("Estimated Earnings: %s\n", hotel.getEstimatedEarnings());
          System.out.printf("\n=========ROOM DETAILS=========\n");
          System.out.printf("Number of Rooms: %s\n", hotel.getMaxRooms());
          System.out.printf("Available Rooms: %s\n", hotel.getAvailableRooms());
          System.out.printf("Base Price per Room: %s\n", hotel.getBasePrice());
          System.out.printf("\n=====RESERVATION DETAILS======\n");
          System.out.printf("Base Price per Room: %s\n", hotel.getBasePrice());
          System.out.printf("\n=====See room names======\n");
          for (Room room : hotel.getRooms()) {
            System.out.printf("%s\n", room.getName());
          }
          System.out.printf("=========================================\n");
        }
        else
          System.out.printf("Hotel name '%s' not found.\n", hotelName);
      }
    }
  }
  
  public void manageHotel(String hotelName) {
    Scanner scanner = new Scanner(System.in);
    
    int choice = scanner.nextInt();
    scanner.nextLine();    
    
    switch (choice) {
      case 1:// change name of hotel (name must still be unique)
        Hotel chosenHotel = findHotelByName(hotelName);
        if (chosenHotel != null) {
          System.out.printf("Set new name: ");
          String newHotelName = scanner.nextLine();
          chosenHotel.setName(newHotelName);
        }
        break;
      case 2: // add room(s)
        break;
      case 3: // remove room(s)
        break;
      case 4: // update base price of rooms
        break;
      case 5: // remove reservation
        break;
      case 6: // remove hotel
        break;
      case 7: // go back to previous
        System.out.printf("Exiting...\n");
        scanner.close();
        return;
      default:
        System.out.printf("Invalid choice. Please try again.\n");
    }
  }

  public void simulateBooking() {
    // select specific hotel
    // specify check-in and check-out dates (1-31) - automate
    // creates a new reservation
    // update room's status (setAvailable)
    // store reservation details
    // --> should be viewable in View Hotel
  }

  private Hotel findHotelByName(String hotelName) {
    for (Hotel hotel : hotels) {
      if (hotel.getName().equals(hotelName)) 
        return hotel;
    }
    return null;
  }
  
  public ArrayList<Hotel> getHotels() {
    return this.hotels;
  }
}
