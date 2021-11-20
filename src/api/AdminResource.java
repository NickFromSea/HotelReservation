package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;


public class AdminResource {
    public static AdminResource adminResource;
    public static final ReservationService reservationService = ReservationService.getInstance();
    public static final CustomerService customerService = CustomerService.getInstance();

    public AdminResource() {}

    public static AdminResource getInstance() {
        if (null == adminResource) {
            adminResource = new AdminResource();
        }
        return adminResource;
    }

    public static Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public Collection<IRoom> getAllRooms() {
        return reservationService.getListOfRoom();
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {
        reservationService.printAllReservation();

    }
}
