package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class BedtimeStories {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("""
                    Which bedtime story would you like to read?
                    (1) Goldilocks
                    (2) Hansel & Gretel
                    (3) Mary had a Little Lamb
                    (4) let's say good night
                    """);

            int storyNum = input.


        }


        try (BufferedReader bufReader = new BufferedReader(new FileReader("")))

    }

    public static int getValidNumber() {

        // initializes inputNumber and boolean badInput
        int inputNumber = 0;
        boolean badInput = false;

        // uses do/while loop
        do {

            // sets badInput to false first
            badInput = false;

            //tries to get an input
            try {
                inputNumber = input.nextInt();
                // if it can't read as int, throws exception with error message and sets badInput to true to try again
            } catch (Exception e) {
                System.out.println("I didn't understand, please try again.");
                badInput = true;
            }
            // eats buffer
            input.nextLine();
            // conditional checks badInput boolean
        } while (badInput);

        // returns the correct inputNumber as an int
        return inputNumber;

    }

}
