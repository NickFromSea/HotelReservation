package display;

import api.HotelResource;
import model.Customer;
import service.CustomerService;
import service.ReservationService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MainMenu {
    public static final ReservationService reservationService = ReservationService.getInstance();
    public static final CustomerService customerService = CustomerService.getInstance();
    public static final HotelResource hotelResource = HotelResource.getInstance();


    Scanner scanner = new Scanner(System.in);



    public MainMenu() {
        boolean selectNumber = true;
        while (selectNumber) {
            try {
                System.out.println("1. Find and reserve a room"); // done
                System.out.println("2. See my reservation");
                System.out.println("3. Create an account");// done
                System.out.println("4. Admin");// done
                System.out.println("5. Exit");// done
                int choiceNumber = Integer.parseInt(scanner.nextLine());

                if (choiceNumber == 1) {
                    System.out.println("----FIND A ROOM----");
                    System.out.println("Enter Check In date mm/dd/yyyy");
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
                    String checkIn = scanner.nextLine();
                    Date dateCheckIn = dateFormat1.parse(checkIn);
                    System.out.println("Enter Check Out date mm/dd/yyyy");
                    SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy");
                    String checkOut = scanner.nextLine();
                    Date dateCheckOut = dateFormat2.parse(checkOut);

                    reservationService.findRooms(dateCheckIn, dateCheckOut);
                    System.out.println("Would you like a book room? Y/N");
                    String bookRoom = scanner.nextLine();
                    switch (bookRoom.toUpperCase()) {
                        case "Y":
                            reservationService.bookRoom(dateCheckIn, dateCheckOut);
                            // code
                        case "N":
                            break;
                        default:
                            System.out.println("Please enter N or Y");
                    }


                    selectNumber = false;
                } else if (choiceNumber == 2) {
                    System.out.println("Please enter your email");
                    boolean correctEmail = true;
                    int count = 0;
                    while (correctEmail) {
                        String email = scanner.nextLine();
                        if ((customerService.getCustomer(email) == null) && count <= 1) {
                            System.out.println("Incorrect email, please try again");
                            count++;
                        } else if ((customerService.getCustomer(email) == null) && count > 1) {
                            System.out.println("Account not found. Please create account");
                            createAnAccount();
                            correctEmail = false;
                        } else if (customerService.getCustomer(email) != null) {
                            System.out.println("----YOUR RESERVATION----");
                            hotelResource.getCustomerReservations(email);
                            correctEmail = false;
                        }
                    }

                    System.out.println("2");
                    selectNumber = false;
                } else if (choiceNumber == 3) {
                    createAnAccount();
                } else if (choiceNumber == 4) {
                    System.out.println("Admin menu");
                    AdminMenu adminMenu = new AdminMenu();
                    selectNumber = false;
                } else if (choiceNumber == 5) {
                    System.out.println("EXIT");
                    break;
                } else {
                    System.out.println("Please enter options 1-5");
                }
            } catch (Exception e) {
            }
        }
    }

    public void createAnAccount() {
        System.out.println("CREATE AN ACCOUNT");
        System.out.println("________________");
        System.out.println("Please enter First Name");
        String firstname = scanner.nextLine();
        System.out.println("Please enter Last Name");
        String lasttname = scanner.nextLine();
        System.out.println("Please enter email");
        String email = scanner.nextLine();
        Customer customer = new Customer(firstname, lasttname, email);
        System.out.println(customer);
        customerService.customerCollection.add(customer);
    }

}