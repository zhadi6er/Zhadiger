package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Scanner;

public class MyApplication extends User{
    // users - a list of users
    private Scanner sc = new Scanner(System.in);
    private User signedUser;
    private LinkedList<User> userLinkedList;
    private Object String;

    private void addUser(User user) {
        userLinkedList.add(user);
    }

    public MyApplication() {
        userLinkedList = new LinkedList<>();
    }

    private void menu() throws FileNotFoundException, UnsupportedEncodingException {
        while (true) {
            if (signedUser == null) {
                System.out.println("You are not signed in.");
                System.out.println("1. Authentication");
                System.out.println("2. Exit");
                int choice = sc.nextInt();
                if (choice == 1) authentication();
                else break;
            }
            else {
                userProfile();
            }
        }
    }

    private void userProfile() throws FileNotFoundException, UnsupportedEncodingException {
        while(true){
            System.out.println("1.Log off");
            int choice = sc.nextInt();
            if(choice == 1) logOff();
        }
    }

    private void logOff() throws FileNotFoundException, UnsupportedEncodingException {
        signedUser = null;
        start();
    }

    private void authentication() {
        while (true) {
            System.out.println("1.Sign in");
            System.out.println("2.Sign up");
            int choice =sc.nextInt();
            if(choice == 1) signIn();
            else signUp();
        }
    }

    private void signIn() {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.next();
        String password = scanner.next();
        Password password1 = new Password(password);
        for(User user : userLinkedList){
            if(username.equals(user.getUsername()) && password1.equals(user.getPassword())){
                signedUser = user;

            }
        }
    }
//
//    private String username,name,surname;
//    private static int id =0;
//    private Password password;

    private void signUp() {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.next();
        String username = scanner.next();
        String name = scanner.next();
        String surname =scanner.next();
        if(password != null && username != null && name != null &&surname != null){
            User user = new User();
            user.setName(name);
            user.setSurname(surname);
            user.setUsername(username);
            Password password1 = new Password(password);
            user.setPassword(password1);
            if(password1.passwordChecker((java.lang.String) String)){
                addUser(user);
                authentication();
            }
        }
    }

    public void start() throws FileNotFoundException, UnsupportedEncodingException {
        File file = new File("C:\\Users\\77479\\Desktop\\allFiles\\IdeaProjects\\OOpp\\src\\com\\company\\db.txt");
        Scanner fileScanner = new Scanner(file);
        // fill userlist from db.txt

        while (true) {
            System.out.println("Welcome to my application!");
            System.out.println("Select command:");
            System.out.println("1. Menu");
            System.out.println("2. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                menu();
            } else {
                break;
            }
        }

        saveUserList();
    }

    private void saveUserList() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("db.txt","UTF-8");
        for(User user : userLinkedList){
            printWriter.println("Username "+user.getUsername() + ",name" + user.getName() + ",surname" + user.getSurname()
                    + ",password" + user.getPassword());
        }
        printWriter.close();
    }

    @Override
    public java.lang.String toString() {
        return "MyApplication{" +
                "sc=" + sc +
                ", signedUser=" + signedUser +
                ", userLinkedList=" + userLinkedList +
                ", String=" + String +
                '}';
    }
}