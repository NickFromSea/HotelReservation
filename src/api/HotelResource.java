
package api;

import model.*;
import service.CustomerService;
import service.ReservationService;
import java.util.*;

public class HotelResource {
    public static HotelResource hotelresource = new HotelResource();
    public static final ReservationService reservationService = ReservationService.getInstance();
    public static final CustomerService customerService = CustomerService.getInstance();
    public static final AdminResource adminResource = AdminResource.getInstance();

    public static HotelResource getInstance() {
        if (null == hotelresource) {
            hotelresource = new HotelResource();
        }
        return hotelresource;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void createACustomer(String firstName, String lastName, String email) {
        customerService.addCustomer(firstName, lastName, email);
    }

    public IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        if (customerService.getCustomer(customerEmail) == null) {
            return null; // need to make a account
        }
        return reservationService.reserveARoom(customerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail) {

        return reservationService.getCustomersReservation(customerService.getCustomer(customerEmail));
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationService.findRooms(checkIn, checkOut);
    }

    public void listRoomsForReservation(RoomType roomType) {
        String typeOfRoom = roomType.toString();
        System.out.println(typeOfRoom + " this type was selected");
        System.out.println("LIST ROOMS");
        for (IRoom room : ReservationService.listOfRoom) {
            System.out.println(room);
        }

        System.out.println("LIST FOR YOUR CHOICE");

    }

}


