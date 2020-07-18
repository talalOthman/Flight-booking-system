
/**
 * flight
 */

import java.util.*;

public class flight {

    public static void main(String[] args) {
        System.out.println("What's your name: ");

        String name;
        Scanner input = new Scanner(System.in);

        name = input.nextLine();

        System.out.println("\nYour name is: " + name + "\n");

        input.close();
    }
}