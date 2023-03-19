package javaChallenge;

import java.util.ArrayList;

public class ManageContact {
    private String name;
    private String email;
    private String number;
    private ArrayList<Messages> messages;

    public ManageContact(String name, String email, String number, ArrayList<Messages> messages) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.messages = messages;
    }

    public ManageContact(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.messages = new ArrayList<>();
    }

    public void getDetails(){
        System.out.println("Name: "+ this.name +
                "\nPhone number: " + this.number +
                "\nEmail: "+ this.email);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Messages> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Messages> messages) {
        this.messages = messages;
    }
}
