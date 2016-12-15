package conklin_5_cryptozoo;

import java.util.ArrayList;
import java.util.Scanner;
/*******************************************************************************
* Filename: CryptoZoo.java
* 
* Author: Conklin, Jason Date: November 30, 2016
* 
* Description: creates a Zoo object and allows the user to modify and view.
*               Runs in a menu  loop that must be exited by the user.
* 
* Input: Zoo
* 
* Output: Console
*******************************************************************************/
public class CryptoZoo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //input gathering
        boolean exit = false; //controls loop
        String choice; //input storage variable
        CryptoZooExplorer safari;
        Zoo menagerie = new Zoo(10); //zoo object
        ArrayList<Animal> caught = new ArrayList();
        
        menagerie.list(); //initialize animals

        while (!exit) { //user must exit
            
            //menu
            System.out.println("\n\n\n\n");
            System.out.println("What would you like to do?");
            System.out.println("1. List all creatures officially residing in my cryptozoo");
            System.out.println("2. List all creatures currently residing in my cryptozoo");
            System.out.println("3. Add a creature to my cryptozoo");
            System.out.println("4. Remove a creature from my cryptozoo");
            System.out.println("5. Send a creature out on tour.");
            System.out.println("6. Return a creature out on tour back to my cryptozoo.");
            System.out.println("7. Exit");
            System.out.println("8. Be an Explorer!");
            

            choice = scanner.next(); //get user input
            int j; //used as a tmp variable in for loops
            switch (choice) { //only checks against the presented choices

                case "1":
                    menagerie.showZoo(); //list all creatures in zoo
                    break;
                case "2": //list all creatures in zoo which are not on tour
                    menagerie.showNotOnTour();
                    break;
                case "3":
                    System.out.println(caught.toString());
                    System.out.println("Enter the name of a creature to add to your cryptozoo:");
                    choice = scanner.next().toLowerCase();
                    j = -1; //used to store found object index
                    for (int i = 0; i < caught.size(); i++) { //look for input match
                        if (choice.equals(caught.get(i).getName().toLowerCase())) {
                            j = i; //save the index
                        }
                    }
                    if (j > -1) { // j chnaged, so a match was found
                        menagerie.getZooList().add(caught.get(j));
                        caught.remove(j);
                        System.out.println(caught.get(j).getName() + " added.");
                        
                    } else { //no match found
                        System.out.println("That creature does not exist in your caught list.");
                    }
                    break;
                case "4":
                    System.out.println("Enter the name of a creature to remove from your cryptozoo:");
                    choice = scanner.next().toLowerCase();
                    j = -1; //same process here, but looking through only zooList instead
                    for (int i = 0; i < menagerie.getZooList().size(); i++) {
                        if (choice.equals(menagerie.getZooList().get(i).getName().toLowerCase())) {
                            j = i;
                        }
                    }
                    if (j > -1) { // same check for j change
                        System.out.println(menagerie.getZooList().get(j).getName() + " removed."); //prints first so the corect index is still there
                        menagerie.getZooList().remove(menagerie.getZooList().get(j));
                        
                    } else {
                        System.out.println("That creature does not exist.");
                    }
                    break;

                case "5":
                    System.out.println("Enter the name of the creature to send out on tour:");
                    choice = scanner.next().toLowerCase();
                    j = -1; //same process as above used to find match
                    for (int i = 0; i < menagerie.getZooList().size(); i++) {
                        if ((!menagerie.getZooList().get(i).isOnTour()) && choice.equals(menagerie.getZooList().get(i).getName().toLowerCase())) {
                            j = i;
                        }
                    }
                    if (j > -1) { // only changes onTour variable of creature
                        menagerie.getZooList().get(j).setOnTour(true);
                        System.out.println(menagerie.getZooList().get(j).getName() + " sent out on tour.");
                    } else { //no match found
                        System.out.println("That creature does not exist or is already on tour.");
                    }
                    break;
                case "6": //same procedure as before, but sets onTour to false
                    System.out.println("Enter the name of the creature to bring back from tour:");
                    choice = scanner.next().toLowerCase();
                    j = -1;
                    for (int i = 0; i < menagerie.getZooList().size(); i++) {
                        if ((menagerie.getZooList().get(i).isOnTour()) && (choice.equals(menagerie.getZooList().get(i).getName().toLowerCase()))) {
                            j = i;
                        }
                    }
                    if (j > -1) {
                        menagerie.getZooList().get(j).setOnTour(false);
                        System.out.println(menagerie.getZooList().get(j).getName() + " returned from tour.");
                    } else {
                        System.out.println("That creature does not exist or is not on tour.");
                    }
                    break;
                case "7": //exit loop
                    exit = true;
                    break;
                case "8":
                    safari = new CryptoZooExplorer(10);
                    safari.explore();
                    caught.addAll(safari.caught);
                    System.out.println("You caught: " + safari.caught.toString());
                                        
                default: //error handling
                    System.out.println("Bad Input.");
                    break;
            }
        }

    }
}
