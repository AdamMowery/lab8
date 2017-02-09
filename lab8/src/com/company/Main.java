package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scnr = new Scanner(System.in);


    public static void main(String[] args) {

        try {
            int players;
            String loop = "yes";

            while (loop.equals("yes")) {

                System.out.print("Enter the number of players on the team:");
                players = scnr.nextInt();

                int[][] ar1 = arraybulder(players);

                calculation(ar1);

                System.out.println("\nDo you want to continue? (yes/no)");

                loop = scnr.nextLine();
            }


        } catch (Exception e) {
            System.out.println("oops something went wrong!");
        }

    }


    //                  Getting all the variables for the array
    private static int[][] arraybulder(int players) {
        int atBat;
        int[][] ar1 = new int[players][];

        for (int i = 0; i < ar1.length; i++) {
            System.out.printf("Please provide the number of times player %d was at bat: ", i + 1);
            atBat = getValidInteger(1, 1000);
            ar1[i] = new int[atBat];
        }
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar1[i].length; j++) {
                System.out.printf("Was player %d's hit %d a: \n0. Out \n1. Single \n2. Double \n3. Triple \n4. Home run", i + 1, j + 1);
                System.out.println();
                ar1[i][j] = getValidInteger(0, 4);
            }
        }
        return ar1;
    }


    //              Batting and slugging calculations
    private static void calculation(int[][] ar1) {

        int atBat = 0;
        double sum = 0;
        double counter = 0;
        double average;
        double percent;

        for (int i = 0; i < ar1.length; i++) {

            for (int j = 0; j < ar1[i].length; j++) {
                sum = sum + ar1[i][j];
                atBat += 1;
                if (ar1[i][j] > 0) {
                    counter = counter + ar1[i][j];


                }
            }
            average = counter / atBat;
            percent = sum / atBat;

            System.out.printf("batting avg for player %d is: %.3f", i + 1, average);
            System.out.println();
            System.out.printf("slugging percentage for %d is: %.3f", i + 1, percent);
            System.out.println();

        }

    }

    private static int getValidInteger() {

        //validation for numbers
        while (!scnr.hasNextInt()) {
            scnr.nextLine(); //clears the buffer
            System.out.println("Please enter an integer! "); //tells user to enter number

        }
        return scnr.nextInt(); //takes the correct integer
    }

    private static boolean checkRange(int input, int min, int max) {
        return !(input <= min || input >= max);
    }

    private static int getValidInteger(int min, int max) {
        int userInput = getValidInteger();
        while (!checkRange(userInput, min, max)) {
            System.out.println("Please provide a number within range!");
            userInput = getValidInteger();
        }
        return userInput;
    }


}

