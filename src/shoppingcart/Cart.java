package shoppingcart;

import java.util.*;
import java.io.*;

public class Cart {
    public static void main(String[] args) {

        System.out.println("Welcome to your shopping cart!");

        boolean stop = false;

        Console cons = System.console();

        List<String> itemsInCart = new ArrayList<>();

        while (!stop) {

            String[] command = cons.readLine("What would you like to do? ").trim().split("[\\s,]+");

            switch (command[0].toLowerCase()) {
                case ("list"):
                    if (!itemsInCart.isEmpty()) {  
                        System.out.println("Your cart contains:"); 
                        for (int i = 0; i < itemsInCart.size(); i++) {
                            System.out.printf("%d. %s\n", i+1, itemsInCart.get(i));
                        }
                    } else {System.out.println("Your cart is empty!");}
                    break;
                    
                case ("add"):
                    for (int idx = 1; idx < command.length; idx++) {
                        if (itemsInCart.toString().contains(command[idx])) {
                            {System.out.println("Item already in cart!");}
                        } else {
                            itemsInCart.add(command[idx]);
                            System.out.printf("%s added to cart\n", command[idx]);
                        }
                    }
                    break;

                case ("delete"):
                    try {
                    System.out.printf("%s removed from cart\n", itemsInCart.get(Integer.parseInt(command[1])-1));
                    itemsInCart.remove(Integer.parseInt(command[1])-1);
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Incorret item index!");
                    }
                    break;

                case ("stop"):
                    stop = true;
                    break;
            }
        }
    }
}
    