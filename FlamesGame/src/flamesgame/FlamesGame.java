package flamesgame;

import java.util.Scanner;

public class FlamesGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to FLAMES created by Madhura S N using JAVA!");
        System.out.println("Check the relationship between you and your crush right now!!! 🙌❤️");
        
        String userChoice;

        do {
            System.out.println("Type 'play' to play the game or 'end' to end the game.\n");
            userChoice = scanner.nextLine().toLowerCase(); // .nextLine() used read the entire line until the newline character (\n) is encountered.

            if (userChoice.equals("play")) { // .equals() method is used to compare two strings for content equality.
                System.out.print("Enter your name : \n");
                String name1 = scanner.nextLine().toLowerCase();

                System.out.print("Enter your crush's name: \n");
                String name2 = scanner.nextLine().toLowerCase();

                int count = getRemainingLetterCount(name1, name2);
                String result = getFlamesResult(count);

                System.out.println("Relationship Status: " + result + "\n");

            } else if (!userChoice.equals("end")) {
                System.out.println("Invalid choice. Please type 'play' or 'end'.\n");
            }
        } while (!userChoice.equals("end"));

        System.out.println("Thank you for playing FLAMES! Have a good day Buddyyyyy!!!! \n");
        scanner.close();
    }

    private static int getRemainingLetterCount(String name1, String name2) {
        StringBuilder n1 = new StringBuilder(name1);
        StringBuilder n2 = new StringBuilder(name2);

        /*This means you don't need to declare or define it yourself—you 
         * can use it directly in your code without needing any additional 
         * imports */
        
        //StringBuilder is an in-built class in Java;
        
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                if (n1.charAt(i) == n2.charAt(j)) {
                    n1.deleteCharAt(i);
                    n2.deleteCharAt(j);
                    i--;
                    break;
           // removes common characters between two strings, n1 and n2
                }
            }
        }
        return n1.length() + n2.length();
    }

    private static String getFlamesResult(int count) {
        String flames = "FLAMES";
        StringBuilder flamesBuilder = new StringBuilder(flames);

        int index = 0;
        while (flamesBuilder.length() > 1) {
            index = (index + count - 1) % flamesBuilder.length();
            flamesBuilder.deleteCharAt(index);
        }
//the getFlamesResult method, and it implements a loop that continues until only one character remains in the flamesBuilder
        char resultChar = flamesBuilder.charAt(0);

        switch (resultChar) {
            case 'F': return "Friendship";
            case 'L': return "Love";
            case 'A': return "Affection";
            case 'M': return "Marriage";
            case 'E': return "Enemies";
            case 'S': return "Siblings";
            default: return "Unknown";
        }
    }
}
