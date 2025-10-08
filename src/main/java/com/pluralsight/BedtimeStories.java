package com.pluralsight;

// importing readers and Scanner
import java.io.*;
import java.util.Scanner;

public class BedtimeStories {

    // declares public Scanner
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // creates isRunning boolean to keep looping menu
        boolean isRunning = true;

        // while loop
        while (isRunning) {

            // prints out menu with bedtime story choices
            System.out.println("""
                    Which bedtime story would you like to read?
                    (1) Goldilocks
                    (2) Hansel & Gretel
                    (3) Mary had a Little Lamb
                    (4) I'm tired, let's say good night
                    """);

            // calls getValidNumber method to ensure that the input is an integer
            int storyNum = getValidNumber();

            // switch case leading to printStory method with different txt files, an exiting case, and a default
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

    // getValidNumber ensures correct integer input
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

    // used to print each story
    public static void printStory(String storyName) {

        // uses try/catch to avoid problems in case of something being wrong with the file
        try (BufferedReader bufReader = new BufferedReader(new FileReader(storyName))) {

            // creates a String called storyLine and a counter variable
            String storyLine;
            int storyLineCounter = 0;

            // uses while loop to go through file, printing out each line as it enters bufferedReader
            // numbers storyLines to the left
            while ((storyLine = bufReader.readLine()) != null) {
                System.out.println(++storyLineCounter + ". " + storyLine);
            }

        // has a catch block in case something is wrong with the file, printing out error message
        } catch (Exception e) {

            System.out.println("Sorry, I'm having trouble reading this one, let's try another.");
        }

    }

}
