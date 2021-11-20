package display;


import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Scanner;

public class AdminMenu {
    public static AdminMenu adminMenu;
    public static final CustomerService customerService = CustomerService.getInstance();
    public static final ReservationService reservationService = ReservationService.getInstance();

    public static AdminMenu getInstance(){
        if (null==adminMenu){
            adminMenu=new AdminMenu();
        }
        return adminMenu;
    }

    Scanner scanner = new Scanner(System.in);

    public AdminMenu() {
        boolean selectNumber = true;
        while (selectNumber) {
            try {
                System.out.println("1. See all Customers");// done
                System.out.println("2. See all Rooms"); // done
                System.out.println("3. See all Reservations");
                System.out.println("4. Add a Room");// done
                System.out.println("5. Back to Main Menu");// done
                int choiceNumber = Integer.parseInt(scanner.nextLine());

                if (choiceNumber == 1) {
                    System.out.println("----LIST OF CUSTOMERS----");
                    for (Customer customers: customerService.customerCollection){
                        System.out.println(customers);
                    }
                    System.out.println("------------------------");
                    System.out.println(" ");
                } else if (choiceNumber == 2) {
                    System.out.println("----ALL ROOMS----");
                    System.out.println("==============");
                    for (IRoom iRoom: ReservationService.listOfRoom){
                        System.out.println(iRoom);
                    }
                    System.out.println("==============");
                } else if (choiceNumber == 3) {
                    System.out.println("----ALL RESERVATIONS----");
                    reservationService.printAllReservation();
                    selectNumber = false;
                } else if (choiceNumber == 4) {
                    System.out.println("----ADD ROOMS----");
                    ReservationService.addRooms();
                    selectNumber = false;
                } else if (choiceNumber == 5) {
                    System.out.println("Main Menu");
                    MainMenu mainMenu = new MainMenu();
                    selectNumber = false;
                } else {
                    System.out.println("Please enter options 1-5");
                }
            } catch (Exception e) {
                System.out.println("Invalid number");
            }
        }
    }
}
