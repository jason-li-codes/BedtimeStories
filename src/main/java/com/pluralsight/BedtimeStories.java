package com.pluralsight;

import java.io.*;
import java.util.Scanner;

public class BedtimeStories {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("""
                    Which bedtime story would you like to read?
                    (1) Goldilocks
                    (2) Hansel & Gretel
                    (3) Mary had a Little Lamb
                    (4) I'm tired, let's say good night
                    """);

            int storyNum = getValidNumber();

            switch (storyNum) {
                case 1:
                    printStory("goldilocks.txt");
                    break;
                case 2:
                    printStory("hansel_and_gretel.txt");
                    break;
                case 3:
                    printStory("mary_had_a_little_lamb.txt");
                    break;
                case 4:
                    System.out.println("Good night!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Oh no, I don't know that one! Let's try another one.");
            }

        }

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
                System.out.println("Sorry I don't know what you mean, let's try again.");
                badInput = true;
            }
            // eats buffer
            input.nextLine();
            // conditional checks badInput boolean
        } while (badInput);

        // returns the correct inputNumber as an int
        return inputNumber;

    }

    public static void printStory(String storyName) throws FileNotFoundException {

        try (BufferedReader bufReader = new BufferedReader(new FileReader(storyName))) {

            String storyLine;
            int storyLineCounter = 0;

            while ((storyLine = bufReader.readLine()) != null) {
                System.out.println(++storyLineCounter + ". " + storyLine);
            }

        } catch (Exception e) {

            System.out.println("Sorry, I'm having trouble reading this one, let's try another.");
        }

    }

}
