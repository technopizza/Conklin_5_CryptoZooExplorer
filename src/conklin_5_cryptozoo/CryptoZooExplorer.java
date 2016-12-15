/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conklin_5_cryptozoo;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jason
 */
public class CryptoZooExplorer {

    private Grid grid;
    private Zoo wild;
    ArrayList<Animal> caught;
    boolean stealth;
    GridEntity trap;
    boolean trapSet;
    GridEntity player;
    int score;
    String choice;
    String message;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    private ListIterator<Animal> lI;

    public CryptoZooExplorer(int gridSide) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        grid = new Grid(gridSide, gridSide);
        wild = new Zoo(5);
        wild.list();
        stealth = false;
        score = 0;
        trapSet = false;
        trap = new GridEntity(-1, -1, 'X');
        player = new GridEntity(0, 0, '◆');
caught = new ArrayList();
    }
    
    
    
    public void spawn(Animal animal) {
        
        int tryX, tryY;
        boolean exit = false;
        do {
            tryX = random.nextInt(grid.getBase());
            tryY = random.nextInt(grid.getHeight());

            if (grid.getCharAt(tryX, tryY) == Grid.gridBkgndChar) {
                exit = true;
                grid.setCharAt(tryX, tryY, animal.getGridChar());
                animal.setGridEntity(new GridEntity(tryX, tryY, animal.getGridChar()));
                
            }
        } while (!exit);

    }

    public void explore() {
        
        boolean exit = false;
        
        wild.list();
        grid.setCharAt(0, 0, player.getGridChar());
        lI = wild.getZooList().listIterator();
            while (lI.hasNext()) {
                spawn(lI.next());
            }
        do {
            for (int i = 0; i < 100; i++) {
                System.out.println("");

            }
            
            System.out.println("1. Toggle Stealth Mode");
        System.out.println("2. Set Trap");
        System.out.println("3. Return to Zoo");
        System.out.println("Or use W, A, S, and D to move");
            
            System.out.println("\n" + message);
                       

            
            grid.draw();

            lI = wild.getZooList().listIterator();
            while (lI.hasNext()) {
                wander(lI.next());
            }
            
            choice = scanner.next(); //get user input
            int j; //used as a tmp variable in for loops
            message ="";
            switch (choice) { //only checks against the presented choices

                case "1":
                    stealth = !stealth;
                    if (stealth) {
                        grid.setCharAt(player.getPosX(), player.getPosY(), Grid.gridBkgndChar);
                    } else {
                        grid.setCharAt(player.getPosX(), player.getPosY(), player.getGridChar());
                    }
                    break;
                case "2":
                    if (stealth) {
                        System.out.println("You're hidden!");
                        break;
                    }
                    if (!trapSet) {
                        trap = new GridEntity(player.getPosX(), player.getPosY(), 'X');
                        grid.setCharAt(trap.getPosX(), trap.getPosY(), trap.getGridChar());
                        trapSet = true;
                    } else {
                        System.out.println("Trap already set!");
                    }
                    break;
                case "3": //exit loop
                    exit = true;
                    break;
                case "w":
                    if (stealth) {
                        System.out.println("You're hidden!");
                        break;
                    }
                    playerMove(-1, 0);
                    break;
                case "a":
                    if (stealth) {
                        System.out.println("You're hidden!");
                        break;
                    }
                    playerMove(0, -1);
                    break;
                case "s":
                    if (stealth) {
                        System.out.println("You're hidden!");
                        break;
                    }
                    playerMove(1, 0);
                    break;
                case "d":
                    if (stealth) {
                        System.out.println("You're hidden!");
                        break;
                    }
                    playerMove(0, 1);
                    break;
                default: //error handling
                    System.out.println("Bad Input.");
                    break;
            }
message = "Score: " + score + "      " +message + "\n";
        } while (!exit);
    }

    void wander(Animal animal) {
        int posX, posY, moveX, moveY, newX, newY;
        boolean check = false;
        do {
            posX = animal.getGridEntity().getPosX();
            posY = animal.getGridEntity().getPosY();
            moveX = (random.nextInt(3) - 1);
            moveY = (random.nextInt(3) - 1);
            newX = posX + moveX;
            newY = posY + moveY;

            if (((newX >= 0) && (newX < (grid.getBase())))
                    && ((newY >= 0) && (newY < (grid.getHeight() )))) {

                if ((grid.getCharAt(newX, newY) == Grid.gridBkgndChar) || (grid.getCharAt(newX, newY) == trap.getGridChar())) {
                    check = false;
                    animal.getGridEntity().setPosX(newX);
                    animal.getGridEntity().setPosY(newY);
                    grid.setCharAt(posX, posY, Grid.gridBkgndChar);
                    if ((grid.getCharAt(newX, newY) == trap.getGridChar())) {
                        caught.add(animal);
                        wild.getZooList().remove(animal);
                        grid.setCharAt(newX, newY, Grid.gridBkgndChar);
                        message += animal.getName() + " was caught by the trap!\n";
                        score += animal.getDangerRating();

                    } else {
                        grid.setCharAt(newX, newY, animal.getGridEntity().getGridChar());
                    }

                }
            }

        } while (check);

    }

     void playerMove(int moveX, int moveY) {
        int posX, posY, newX, newY;
        boolean check = false;
        do {
           posX = player.getPosX();
            posY = player.getPosY();
            newX = posX + moveX;
            newY = posY + moveY;

            if (((newX >= 0) && (newX < (grid.getBase()) ))
                    && ((newY >= 0) && (newY < (grid.getHeight() )))) {
                check = false;
                    player.setPosX(newX);
                    player.setPosY(newY);
                    grid.setCharAt(posX, posY, Grid.gridBkgndChar);
                if (!((grid.getCharAt(newX, newY) == Grid.gridBkgndChar) || (grid.getCharAt(newX, newY) == trap.getGridChar()))) {
                    lI = wild.getZooList().listIterator();
                    int j = -1; //same process here, but looking through only zooList instead
                    for (int i = 0; i < wild.getZooList().size(); i++) {
                        if ((wild.getZooList().get(i).getGridEntity().getPosX() == newX) && (wild.getZooList().get(i).getGridEntity().getPosY() == newY)) {
                            j = i;
                        }
                    }
                    if (j > -1) { // same check for j change
                        caught.add(wild.getZooList().get(j));
                        message += (wild.getZooList().get(j).getName() + " was caught!");
                        score += wild.getZooList().get(j).getDangerRating();
                        wild.getZooList().remove(wild.getZooList().get(j));
                        
                        
                    }
                    
                }
                grid.setCharAt(newX, newY, player.getGridChar());
            }

        } while (check);

    }
    
    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public ListIterator getlI() {
        return lI;
    }

    public void setlI(ListIterator lI) {
        this.lI = lI;
    }

    public Zoo getWild() {
        return wild;
    }

    public void setWild(Zoo wild) {
        this.wild = wild;
    }

}
