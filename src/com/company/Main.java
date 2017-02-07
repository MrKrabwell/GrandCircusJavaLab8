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

        // Prompt user and get input
        System.out.print("Enter how many players stats you want to enter: ");

        int userInput = getValidInteger(1,100000);

        // Return the scanned value
        return userInput;

    }


    /**
     * This method returns the number of at bats for a certain player
     * @param playerIndex
     * @return
     */
    public static int getNumOfAtBats(int playerIndex) {

        // Prompt user
        System.out.printf("Enter number of times at bat for batter #%d: ", playerIndex + 1);

        // Call the get Valid integer, max number is static... Is this okay?
        int userInput = getValidInteger(1,10000);

        // Return the scanned value
        return userInput;
    }


    /**
     *
     * @param atBatIndex
     * @return
     */
    public static int getAtBatResult(int atBatIndex) {
        //Prompt user
        System.out.printf("Result for at-bat %d: ", atBatIndex + 1);

        int userInput = getValidInteger(0,4);

        // Return user Input
        return userInput;

    }

    /****************************************************************
     * getValidInteger function to validate that it is an int value *
     ****************************************************************/
    public static int getValidInteger() {

        // This keeps looping until integer input is received.
        while (!scnr.hasNextInt()) {
            scnr.nextLine();         // clear the buffer
            System.out.println("Please enter an integer!");
        }

        return scnr.nextInt();
    }


    /*****************************************************************************
     * This is a method to determine whether the integer is within min/max range *
     * Use with checkRangeMethod                                                 *
     *****************************************************************************/
    public static int getValidInteger(int min, int max) {

        int userInput = getValidInteger();
        while (checkRange(userInput,min,max) == false) {
            System.out.println("Please provide a number within range!");
            userInput = getValidInteger();
        }
        return userInput;
    }


    /**
     * This is the method that checks the range
     */
    public static boolean checkRange(long input, long min, long max) {

        if (input >= min && input <= max) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * This is the method to get the batting average for a player
     * @param batterStat
     * @return
     */
    public static double getBattingAverage(int[] batterStat) {
        // Variable declaration
        int numHits = 0;          // number of hits, i.e. non-zero value

        // Count the numer of hits per element
        for (int i = 0; i < batterStat.length; i++) {
            if (batterStat[i] != 0) {
                ++numHits;
            }
        }

        // return the batting average = non-zero/numatbats
        return (double)numHits / (double)batterStat.length;
    }


    /**
     * This is the method to get the slugging percentage for a player
     * @param batterStat
     * @return
     */
    public static double getSluggingPercentage(int[] batterStat) {
        int sum = 0;        // sum of all the at bat values

        for (int element : batterStat) {
            sum = sum + element;
        }

        // return the slugging percentage sum/numatbats
        return (double)sum / (double)batterStat.length;
    }

    /*************************************************************************
     * This method asks the user if they want to continue the program or not *
     *************************************************************************/
    public static boolean askUserToContinue() {
        // Variable declarations
        String userInput = "";                  // User input string
        Scanner scan = new Scanner(System.in);  // Scanner object for user input

        // Prompt user to enter yes or no
        System.out.print("Do you want to continue? (y/n): ");
        userInput = scan.nextLine();
        System.out.println("");

        // Validate whether user input is ok, and continue asking until right
        while (!userInput.equalsIgnoreCase("y") &&
                !userInput.equalsIgnoreCase("yes") &&
                !userInput.equalsIgnoreCase("n") &&
                !userInput.equalsIgnoreCase("no")) {
            System.out.println("That is not a valid input.  Please try again. ");
            System.out.print("Do you want to continue? (y/n): ");
            userInput = scan.nextLine();
            System.out.println("");
        }

        // Return true if user says yes, and false if user says no
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This is the main method
     * @param args
     */
    public static void main(String[] args) {
	    // Variable declarations
        int numBatters = 0;               // holds how many batters there are to store data
        int[][] batterStats;              // Array to hold the array of batter stats
        boolean continueProgram = true;   // boolean to keep the program running

        // Welcome message
        System.out.println("Welcome to the Batting Average Calculator!\n");

        // Continue the program until user decides to quit
        while (continueProgram) {

            // create the batter stats matrix, with number of players of rows
            batterStats = new int[getNumBatters()][];
            System.out.println();

            // Fill out the player stats for each player
            for (int i = 0; i < batterStats.length; i++) {
                // Create the number of columns per player index i
                batterStats[i] = new int[getNumOfAtBats(i)];
                System.out.println();

                // Heading for results
                System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");

                // Fill out the columns i.e. at bats results
                for (int j = 0; j < batterStats[i].length; j++) {
                    batterStats[i][j] = getAtBatResult(j);
                }
                System.out.println();
            }
            System.out.println();

            // Now you have the jagged array batterStats that holds the stats for each player
            /* Testing delete later
            System.out.println("This is the jagged matrix");
            for (int i = 0; i < batterStats.length; i++) {
                for (int j = 0; j < batterStats[i].length; j++) {
                    System.out.printf("%-5d", batterStats[i][j]);
                }
                System.out.println();
            }*/

            // Print results for each batter
            for (int i = 0; i < batterStats.length; i++) {
                System.out.printf("Batter %5d average: %-10.3f slugging percentage: %-10.3f", i+1,
                        getBattingAverage(batterStats[i]), getSluggingPercentage(batterStats[i]));
                System.out.println();
            }
            System.out.println();

            // Ask the user if they want to continue
            continueProgram = askUserToContinue();
        }

    }
}
