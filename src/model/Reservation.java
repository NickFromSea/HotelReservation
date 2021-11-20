package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    Customer customer;
    IRoom room;
    Date checkInDate;
    Date checkOutdate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutdate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutdate = checkOutdate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutdate() {
        return checkOutdate;
    }

    public void setCheckOutdate(Date checkOutdate) {
        this.checkOutdate = checkOutdate;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return "Reservation  - " +
                " " + customer +
                ", " + room +
                ", chekInDate - " + dateFormat.format(checkInDate) +
                ", checkOutdate - " + dateFormat.format(checkOutdate);
    }
}
