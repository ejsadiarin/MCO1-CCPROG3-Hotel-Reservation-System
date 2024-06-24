package Model;

import java.util.ArrayList;
    
public class Hotel {
  private String name;
  private ArrayList<Room> rooms;
  private ArrayList<Reservation> reservations;
  private double basePrice;
  private final int maxRooms; // always 50
  private int numOfRooms; // actual number of rooms (initialized rooms)
  
  public Hotel(String name, int numOfRooms) {
    this.name = name; // must be unique
    this.rooms = new ArrayList<>();
    this.reservations = new ArrayList<>();
    this.basePrice = 1299.0;
    this.maxRooms = 50;
    this.setNumOfRooms(numOfRooms);
    this.initializeRooms(numOfRooms);
  }

  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public ArrayList<Room> getRooms() {
    return rooms;
  }
  
  private void initializeRooms(int numOfRooms) {
    // automated unique naming of room names until maxRooms
    int roomNumber = 1;
    while (roomNumber <= numOfRooms) {
      String roomName = "Room-" + roomNumber;
      addRoom(roomName);
      roomNumber++;
    }
  }
  
  public Room getRoom(String roomName) {
    for (Room room : rooms) {
      if (room.getName().equals(roomName))
        return room;
    }
    return null;
  }
  
  public void addRoom(String roomName) {
    for (Room room : rooms) {
      if (room.getName().equals(roomName)) {
        System.out.printf("Room name already exists.\n");
        return;
      }
    }
    if (getNumOfRooms() > getMaxRooms()) {
      System.out.printf("Limit reached (%d). Cannot add more rooms.\n", getMaxRooms());
      return;
    }
    rooms.add(new Room(roomName, this.basePrice));
  }
  
  public void addRoom() {
    String roomName = "Room-" + getNumOfRooms();
    for (Room room : rooms) {
      if (room.getName().equals(roomName)) {
        System.out.printf("Room name already exists.\n");
        return;
      }
    }
    if (getNumOfRooms() > getMaxRooms()) {
      System.out.printf("Limit reached (%d). Cannot add more rooms.\n", getMaxRooms());
      return;
    }
    rooms.add(new Room(roomName, this.basePrice));
  }
  
  public void removeRoom(String roomName) {
    rooms.removeIf(room -> room.getName().equals(roomName) && room.isAvailable());
  }
  
  public int getNumOfRooms() {
    return rooms.size();
  }

  public void setNumOfRooms(int numOfRooms) {
    if (numOfRooms > getMaxRooms() || numOfRooms < 1) {
      System.out.printf("Cannot set max rooms to %d (minimum is 1, maximum is 50). Defaulting to 50.\n", numOfRooms);
    }
    this.numOfRooms = numOfRooms;
  }
  
  public int getMaxRooms() {
    return this.maxRooms;
  }
  
  public int getAvailableRooms() {
    int sum = 0;
    for (Room room : rooms) {
      if (room.isAvailable())
        sum++;
    }
    return sum;
  }

  public ArrayList<Reservation> getReservations() {
    return reservations;
  }
  
  public Reservation getReservation(String guestName) {
    for (Reservation reservation : reservations) {
      if (reservation.getGuestName().equals(guestName))
        return reservation;
    }
    return null;
  }
  
  public void addReservation(Reservation reservation) {
    reservations.add(reservation);
  }
  
  public void removeReservation(String guestName) {
    reservations.removeIf(reservation -> reservation.getGuestName().equals(guestName));
  }

  public double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(double basePrice) {
    if (reservations.isEmpty() && basePrice >= 100.0) {
      this.basePrice = basePrice;
      for (Room room : rooms) {
        room.setPricePerNight(basePrice);
      }
    }
  }
  
  public double getEstimatedEarnings() {
    double totalEarnings = 0;
    for (Reservation reservation : reservations) {
      totalEarnings += reservation.getTotalPrice();
    }
    return totalEarnings;
  }
}
