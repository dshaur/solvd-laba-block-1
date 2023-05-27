package com.solvd.block1.lab1;

public class UserInfo {


    public static void main(String[] args) {
        // Fetching user information from command line arguments
        String name = args[0];
        int age = Integer.parseInt(args[1]);
        String gender = args[2];

        // Printing user information
        System.out.println("User Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }
}
