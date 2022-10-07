import java.util.*;
import java.io.*;

public class EncodeDecodeMain {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            // System.out.println("Array Size: " + strArr.length);
            int choice = -1;
            while (true) {

                System.out.println("Would you to decode or encode? (Please enter 1 or 2)");
                System.out.println("1) Encode");
                System.out.println("2) Decode");
                System.out.println();
                System.out.print("Please enter your choice: ");

                String choiceStr = br.readLine();
                try {
                    choice = Integer.valueOf(choiceStr);
                    if (choice > 2) {
                        System.err.println("You have entered an incorrect choice. Please try again!");
                    } else {
                        break;
                    }
                } catch (NumberFormatException ex) {
                    System.err.println("You have entered an incorrect choice. Please try again!");
                    System.out.println();
                } catch (Exception ex) {
                    System.err.println("An unknown error has occured. Please try again!");
                    System.out.println();
                }

            }

            System.out.println("Your choice is: " + choice);
            System.out.print("Please enter the string: ");
            String inputStr = br.readLine().toUpperCase();

            EncodeDecodeRunner runner = new EncodeDecodeRunner();

            if (choice == 2) {
                String decodedStr = runner.decode(inputStr, sb);
                System.out.println("Your decoded string: " + decodedStr);
            } else {
                String encodedStr = runner.encode(inputStr, sb);
                System.out.println("Your encoded string: " + encodedStr);
            }
        } catch (Exception ex) {
            System.err.println("Error with system. Please restart system.");
        }

    }
}
