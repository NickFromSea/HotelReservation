package model;
/**
 * Программа для резервирования номеров в гостинице
 * позволяет:
 * - создание комнат
 * - создание аккаунта гостя
 * - поиск и резервирование комнаты
 * - просмотр своей резервации
 * - просмотр всех аккаунтов
 * - просмотр всех резерваций
 *
 * @author Nikolai Streletc (n.streletc@gmail.com) *
 */


import display.MainMenu;
import service.CustomerService;
import service.ReservationService;

public class Tester {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();

        /*Room room1 = new Room("100",150.5, RoomType.SINGLE);
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

        Customer customer1 = new Customer("Tom", "Smith", "mailtom@email.com");
        CustomerService.customerCollection.add(customer1);
        Customer customer2 = new Customer("Bob", "Maersk", "mailbob@email.ca");
        CustomerService.customerCollection.add(customer2);
        Customer customer3 = new Customer("Natali", "Ivanova", "mailnatali@email.ru");
        CustomerService.customerCollection.add(customer3);*/
    }
}
