package model;


import display.MainMenu;

public class Customer {


    private String firstName;
    private String lastName;
    private String email;
    private String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        //boolean b = email.matches(regex);
        if (email.matches(regex)){
            this.email = email;
        }else {
            System.out.println("INCORRECT SYNTAX EMAIL. PLEASE TRY AGAIN.");
            System.out.println("");
            throw new IllegalArgumentException ();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "CUSTOMER {" +
                "firstName - " + firstName +
                ", lastName - " + lastName +
                ", email - " + email +
                '}';
    }



}
