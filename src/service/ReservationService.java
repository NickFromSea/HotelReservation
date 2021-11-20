package service;

import api.AdminResource;
import display.AdminMenu;
import display.MainMenu;
import model.*;

import java.util.*;

public class ReservationService {
    public static Collection<IRoom> listOfRoom = new HashSet<>();
    private static ReservationService reservationService;
    private static CustomerService customerService;
    Scanner scanner = new Scanner(System.in);

    private Collection<Reservation> reservationsList = new HashSet<>();

    private Reservation reserveARoom;

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (null == reservationService) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public IRoom getARoom(String roomID) {
        for (IRoom room : listOfRoom) {
            if (roomID.equals(room.getRoomNumber())) {
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservationsList.add(reservation);
        return reserveARoom;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> displayRooms = ReservationService.listOfRoom;
        if (reservationsList.isEmpty()) {
            System.out.println("This is available rooms");
            System.out.println("_______________________");
            getListOfRoom();
        } else {
            for (Reservation checkInOut : reservationsList) {
                if ((checkInOut.getCheckInDate().after(checkInDate) && checkInOut.getCheckOutdate().before(checkOutDate)) ||
                        (checkInOut.getCheckInDate().before(checkInDate) && checkInOut.getCheckOutdate().after(checkOutDate)) ||
                        (checkInOut.getCheckInDate().before(checkInDate) && checkInOut.getCheckOutdate().before(checkOutDate) && checkInOut.getCheckOutdate().after(checkInDate)) ||
                        (checkInOut.getCheckInDate().after(checkInDate) && checkInOut.getCheckOutdate().after(checkOutDate) && checkInOut.getCheckInDate().before(checkOutDate))) {
                    IRoom currentRoom = checkInOut.getRoom();
                    displayRooms.remove(currentRoom);
                }
            }
            System.out.println("Available rooms:");
            for (IRoom room : displayRooms) {
                System.out.println(room);
            }
        }
        return displayRooms;
    }

    public void bookRoom(Date checkInDate, Date checkOutDate) {
        System.out.println("Please enter a room number");
        String roomNumber = scanner.nextLine();
        System.out.println("Please enter email");
        String customerEmail = scanner.nextLine();
        reserveARoom(AdminResource.getCustomer(customerEmail), getARoom(roomNumber), checkInDate, checkOutDate);
        System.out.println("Room is booked");
        MainMenu mainMenu = new MainMenu();
    }

    public static Collection<IRoom> getListOfRoom() {
        for (IRoom iRoom : ReservationService.listOfRoom) {
            System.out.println(iRoom);
        }
        return listOfRoom;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        Collection<Reservation> reservations = new HashSet<>();
        try {
            for (Reservation customerReservation : reservationsList) {
                if (customerReservation.getCustomer().equals(customer)) {
                    reservations.add(customerReservation);
                    System.out.println(reservations);
                } else {
                    System.out.println("Reservation not found");
                }
                return reservations;
            }
        } catch (NullPointerException e) {
            System.out.println("This reservation not exist");
        }
        return reservations;
    }

    public static void addRooms() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room number");
        String roomNumber = scanner.nextLine();
        System.out.println("Enter price of room");
        Double price = Double.valueOf(scanner.nextLine());
        System.out.println("Enter type of room");
        boolean selectTypeOfRoom = true;
        RoomType typeOfRoom = null;
        while (selectTypeOfRoom) {
            System.out.println("......1 Single");
            System.out.println("......2 Double");
            int type = Integer.parseInt(scanner.nextLine());
            if (type == 1) {
                typeOfRoom = RoomType.SINGLE;
                selectTypeOfRoom = false;
            } else if (type == 2) {
                typeOfRoom = RoomType.DOUBLE;
                selectTypeOfRoom = false;
            } else {
                System.out.println("Please enter 1 or 2");
            }
        }

        IRoom room = null;
        boolean freeCostRoom = true;
        while (freeCostRoom) {
            System.out.println("This room is free? Y/N");
            String freeCost = scanner.nextLine();
            if (freeCost.equals("Y") || freeCost.equals("y")) {
                room = new FreeRoom(roomNumber, typeOfRoom);
                freeCostRoom = false;
            } else if (freeCost.equals("N") || freeCost.equals("n")) {
                room = new Room(roomNumber, price, typeOfRoom);
                freeCostRoom = false;
            } else {
                System.out.println("Please enter N or Y");
            }
        }

        ReservationService.listOfRoom.add(room);

        boolean oneMore = true;
        while (oneMore) {
            System.out.println("Enter one more room? N/Y");
            String oneMoreRoom = scanner.nextLine();
            if (oneMoreRoom.equals("Y") || oneMoreRoom.equals("y")) {
                addRooms();
                oneMore = false;
            } else if (oneMoreRoom.equals("N") || oneMoreRoom.equals("n")) {
                AdminMenu adminMenu = new AdminMenu();
                oneMore = false;
            } else {
                System.out.println("Please enter N or Y");
            }
        }
    }

    public void printAllReservation() {
        for (Reservation reservation : reservationsList) {
            System.out.println(reservation);
        }
    }
}
