package com.alejandro.Java.Final.Challange;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner;

    public static void main(String[] args) {
        contacts = new ArrayList<>();

        System.out.println("Welcome User");
        showInitialOption();
    }



    private static void showInitialOption(){
        System.out.println("Please select one: " +
                "\n\t1. Manage Contacts" +
                "\n\t2. Messages" +
                "\n\t3. Quit");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
            default:
                break;
        }
    } //Met Done

    public static void manageContacts(){
        System.out.println("Please select one:" +
                "\n\t1. Show all contacts" +
                "\n\t2. Add a new contact" +
                "\n\t3. Search for a contact" +
                "\n\t4. Delete a contact" +
                "\n\t5. Go back");

        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addNewContact();
                break;
            case 3:
                searchForContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showInitialOption();
                break;
        }
    }//MAIN METHOD #1

    public static void manageMessages(){

    }//MAIN METHOD #2


    private static void deleteContact(){
        System.out.println("Please enter the contact you want to delete:");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter a name:");
            deleteContact();
        }else{
            boolean doesExist = false;

            for (Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if(!doesExist) {
                System.out.println("There is no such contact");
            }
            showInitialOption();
        }
    }

    private static void searchForContact(){
        System.out.println("Please enter the contact name:");
        String name = scanner.next();
        if(name.equals("")){
            System.out.println("Please enter the name: ");
            searchForContact();
        }else{
            boolean doesExist = false;
            for(Contact c:contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                    c.getDetails();
                }
            }

            if(!doesExist){
                System.out.println("There is no such contact");

            }
        }

        showInitialOption();
    }

    private static void addNewContact() {
        System.out.println("Adding a new Contact..." +
                "Please enter the contact's name: ");
        String name = scanner.next();
        System.out.println("Please enter contact's number: ");
        String number = scanner.next();
        System.out.println("Please enter contact's email: ");
        String email = scanner.next();

        if (name.equals("") || number.equals("")  || email.equals("")){
            System.out.println("Please enter all of the information");
            addNewContact();
        }else{

            boolean doesExist = false;
            for(Contact c: contacts){
                if(c.getName().equals(name)){
                    doesExist = true;
                }
            }

            if(doesExist){
                System.out.println("We have a contact named " + name + " saved on this device");
                addNewContact();
            }else{
                Contact contact = new Contact(name , email,number);
                contacts.add(contact);
                System.out.println(name + " added succesfully!");
            }


        }
        showInitialOption();
    }//met done

    private static void showAllContacts() {
        for(Contact c:contacts){
            c.getDetails();
        }
        showInitialOption();
    }


}
