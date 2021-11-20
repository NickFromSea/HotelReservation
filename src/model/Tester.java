package model;



import display.MainMenu;
import service.CustomerService;
import service.ReservationService;

public class Tester {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();

        Room room1 = new Room("100",150.5, RoomType.SINGLE);
        ReservationService.listOfRoom.add(room1);
        Room room2 = new Room("101",140.5, RoomType.SINGLE);
        ReservationService.listOfRoom.add(room2);
        Room room3 = new Room("102",153.6, RoomType.SINGLE);
        ReservationService.listOfRoom.add(room3);
        Room room4 = new FreeRoom("103", RoomType.SINGLE);
        ReservationService.listOfRoom.add(room4);
        Room room5 = new Room("200",245.4, RoomType.DOUBLE);
        ReservationService.listOfRoom.add(room5);
        Room room6 = new Room("201",276.48, RoomType.DOUBLE);
        ReservationService.listOfRoom.add(room6);
        Room room7 = new FreeRoom("202",RoomType.DOUBLE);
        ReservationService.listOfRoom.add(room7);

        Customer customer1 = new Customer("Nick", "Streletc", "mail@email.ru");
        CustomerService.customerCollection.add(customer1);
        Customer customer2 = new Customer("Bob", "Petrov", "petrov@email.ru");
        CustomerService.customerCollection.add(customer2);
        Customer customer3 = new Customer("Julia", "Strelets", "julia@email.ru");
        CustomerService.customerCollection.add(customer3);
    }
}
