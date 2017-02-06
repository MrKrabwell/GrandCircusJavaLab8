package com.company;

import java.util.Scanner;

public class Main {
    // Public fields
    static Scanner scnr = new Scanner(System.in);  // Scanner object for user input

    /**
     * This is the method to get the number of batters from the user
     * @return
     */
    public static int getNumBatters() {
        // Variable declarations
        int userInput = 0;                              // User input

        // Prompt user and get input
        System.out.print("Enter how many players stats you want to enter: ");

        // This keeps looping until integer input is received.
        while (!scnr.hasNextInt()) {
            scnr.nextLine();         // clear the buffer
            System.out.println("Please enter an integer!");
        }

        // TODO: validate whether it is a positive integer

        // Return the scanned value
        return scnr.nextInt();

    }


    /**
     * This method returns the number of at bats for a certain player
     * @param playerIndex
     * @return
     */
    public static int getNumOfAtBats(int playerIndex) {

        // Prompt user
        System.out.printf("Enter number of times at bat for batter #%d: ", playerIndex + 1);

        // This keeps looping until integer input is received.
        while (!scnr.hasNextInt()) {
            scnr.nextLine();         // clear the buffer
            System.out.println("Please enter an integer!");
        }

        // TODO: validate whether it is a positive integer

        // Return the scanned value
        return scnr.nextInt();
    }


    /**
     *
     * @param atBatIndex
     * @return
     */
    public static int getAtBatResult(int atBatIndex) {
        //Prompt user
        System.out.printf("Result for at-bat %d: ", atBatIndex + 1);

        // This keeps looping until integer input is received.
        while (!scnr.hasNextInt()) {
            scnr.nextLine();         // clear the buffer
            System.out.println("Please enter an integer!");
        }

        // TODO: validate whether it is a number between 0 and 4

        // Return the scanned value
        return scnr.nextInt();

    }


    /**
     * This is the main method
     * @param args
     */
    public static void main(String[] args) {
	    // Variable declarations
        int numBatters = 0;       // holds how many batters there are to store data
        int[][] batterStats;      // Array to hold the array of batter stats

        // Welcome message
        System.out.println("Welcome to the Batting Average Calculator!\n");

        // create the batter stats matrix, with number of players of rows
        batterStats = new int[getNumBatters()][];

        // Fill out the player stats for each player
        for (int i = 0; i < batterStats.length; i++) {
            // Create the number of columns per player index i
            batterStats[i] = new int[getNumOfAtBats(i)];

            // Heading for results
            System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");
            // Fill out the columns i.e. at bats
            for (int j = 0; j < batterStats[i].length; j++) {
                batterStats[i][j] = getAtBatResult(j);
            }
        }

        // Now you have the jagged array batterStats that holds the stats for each player
        // Testing delete later
        System.out.println("This is the jagged matrix");
        for (int i = 0; i < batterStats.length; i++) {
            for (int j = 0; j < batterStats[i].length; j++) {
                System.out.printf("%-5d", batterStats[i][j]);
            }
            System.out.println();
        }

        

    }
}
