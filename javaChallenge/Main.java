package javaChallenge;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ManageContact> contacts;
    static int id = 0;
    public static Scanner scanner = new Scanner(System.in);
    private static void showInitialOption() {
        System.out.println("Select one of the following options: "+
                "\n1. Manage Contacts"+
                "\n2. Messages" +
                "\n3. Quit");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                manageContact();
                break;
            case 2:
                messages();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to my humble world of programming ");
        contacts=new ArrayList<>();
        showInitialOption();
    }
    private static void messages() {
        System.out.println("Select one of the following options: "+
                "\n1. Show all messages"+
                "\n2. Send a new message" +
                "\n3. Go back to previous menu");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendNewMessage();
                break;
            case 3:
                showInitialOption();
                break;
            default:
                System.out.println("Invalid input");
                messages();
                break;
        }
    }

    private static void sendNewMessage() {
        System.out.println("Enter recipient name: ");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter required input: ");
            sendNewMessage();
        }
        else{
            boolean doesExist = false;
            for (ManageContact c:contacts) {
                if(name.equals(c.getName())){
                    doesExist=true;
                }
            }
            if(doesExist){
                System.out.println("What would you like to send to recipient: ");
                String text =scanner.next();
                if(text.equals("")){
                    System.out.println("Please enter required field: ");
                    sendNewMessage();
                }else{
                    id++;
                    Messages message = new Messages(text,name,id);
                    for (ManageContact c:contacts) {
                        if(name.equals(c.getName())){
                            ArrayList<Messages> newMessages = new ArrayList<>();
                            newMessages.add(message);
                          /*ManageContact currentContact = c;
                            //currentContact.setMessages(newMessages);
                          // contacts.remove(c);
                           // contacts.add(currentContact);**/
                            c.setMessages(newMessages);
                        }
                    }
                    System.out.println("Message sent successfully");
                    messages();
                }
            }else{
                System.out.println("Recipient does not exist on Contact");
                messages();
            }
        }
    }

    private static void showAllMessages() {
        ArrayList <Messages> allMessages = new ArrayList<>();
        for (ManageContact c:contacts) {
            allMessages.addAll(c.getMessages());
        }
        if (allMessages.size() > 0){
            for (Messages m:allMessages) {
                m.getDetails();
                System.out.println("************");
            }
        }else{
            System.out.println("Message is empty");
        }
        messages();
    }

    private static void deleteContact() {
        System.out.println("Enter name of contact to delete: ");
        String deleteName = scanner.next();
        if(deleteName.equals("")){
            System.out.println("Please enter a name ");
            deleteContact();
        }else{
            boolean doesExist = false;
            for (ManageContact c:contacts) {
                if(c.getName().equals(deleteName)){
                    doesExist=true;
                    contacts.remove(c);
                }
            }
            if (!doesExist){
                System.out.println("Contact does not exist");
            }
            manageContact();
            }
        }

    private static void searchContact() {
        System.out.println("Enter name of contact: ");
        String searchName = scanner.next();
        if(searchName.equals("")){
            System.out.println("Please enter a name ");
            searchContact();
        }else{
            boolean doesExist = false;
            for (ManageContact c:contacts) {
                if(c.getName().equals(searchName)){
                    doesExist=true;
                    c.getDetails();
                }
            }
            if (!doesExist){
                System.out.println("Contact does not exist");
            }
            manageContact();
        }
        }

    private static void addNewContacts() {
        System.out.println("        NEW CONTACT \nName: ");
        String name = scanner.next();
        System.out.println("Email: ");
        String email = scanner.next();
        System.out.println("Phone Number: ");
        String number = scanner.next();

        if (name.equals("")||email.equals("")||number.equals("")){
            System.out.println("Please input all required field.");
            addNewContacts();
        }
        boolean doesExist = false;
        for (ManageContact c: contacts) {
            if(c.getName().equals(name)){
                doesExist =true;
                System.out.println("Contact already exist!!");
                addNewContacts();
            }
        }
        if(!doesExist){
            ManageContact manageContact = new ManageContact(name, email, number);
            contacts.add(manageContact);
            System.out.println(name+ " has been added successfully");
        } manageContact();

    }

    private static void showAllContacts() {
        if(contacts.size() >0){
            for (ManageContact c:contacts) {
                c.getDetails();
                System.out.println("*******************");
            }
        }else{
            System.out.println("Contact is empty");
        }

        showInitialOption();
    }

    private static void manageContact() {
        System.out.println("Select one of the following options: "+
                "\n\t1. Show all Contacts"+
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back to previous menu");
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContacts();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            case 5:
                showInitialOption();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
