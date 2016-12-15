package conklin_5_cryptozoo;
//
import java.util.ArrayList;
import java.util.Random;
/*******************************************************************************
* Filename: Zoo.java
* 
* Author: Conklin, Jason Date: November 30, 2016
* 
* Description: includes all the necessary variables and methods for modifying and maintaining a zoo object.
*              Mostly used to manage the two ArrayLists 
* 
* Input: Mythical.java, FossilRelative.java, Animal.java, LingerLing.java, Paranormal.java
* 
* Output: Console
*******************************************************************************/
public class Zoo {
    
    private ArrayList<Animal> zooList; // a list of only the zoo animals
    private ArrayList<Animal> allList; // a list of all possible animal objects
    private final Random random = new Random(); //used to assign random animals to the initial zoo
    private int size; //used for intially adding animals to zoo
    
    /********************************************************************************
    * Method: Zoo (constructor)
    * 
    * Description: initializes variables, creates animal objects, and adds those objects to an arrayList 
    *  
    * Parameters: int s
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: ArrayList allList contains many different animal objects
    *******************************************************************************/
    Zoo(int s){
        size = s;
        zooList = new ArrayList();
        allList = new ArrayList();
        allList.add(new Mythical("Nemean_Lion", "Greece", 7, "meat", 2));
        allList.add(new Mythical("Kraken", "Denmark", 15, "ships", 2));
        allList.add(new Mythical("Cyclops", "Greece", 10, "meat", 1));
        allList.add(new Mythical("Manticore", "Greece", 7, "meat", 4));
        allList.add(new Mythical("Bigfoot", "North America", 5, "fruit", 1));
        allList.add(new Mythical("Dragon", "a cave", 10, "meat", 5));
        allList.add(new Mythical("Centaur", "Greece", 5, "fruit", 1));
        allList.add(new Paranormal("Ghost", "graveyard", 4));
        allList.add(new Paranormal("Gremlin", "Chinatown", 3));
        allList.add(new FossilRelative("Mastodon", "Siberia", 2));
        allList.add(new FossilRelative("Apatosaurus", "jungle", 3));
        allList.add(new FossilRelative("Velociraptor", "jungle", 7));
        allList.add(new LingerLing("Slenderman", "the woods", 4));
    }
    
    
    /********************************************************************************
    * Method: list
    * 
    * Description:  fills zooList with 10 random  animals from AllList
    *  
    * Parameters: none
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: ArrayList zooList contains 10 random animal objects
    *******************************************************************************/
    void list(){
        for (int i = 0; i < size; i++) {
            zooList.add(i, allList.get(random.nextInt(allList.size())));
            
        }
        
    }
    /********************************************************************************
    * Method: showAllAnimals (unused)
    * 
    * Description:  using a for loop, prints out the names of all animals
    *  
    * Parameters: none
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: none
    *******************************************************************************/
    void showAllAnimals(){
        for (int i = 0; i < allList.size(); i++) {
            System.out.println(allList.get(i).getName());
            System.out.println("__________");
        }
        
    }
    /********************************************************************************
    * Method: showZoo
    * 
    * Description:  prints out the names, food amount, and tour status of each animal in the zoo
    *  
    * Parameters: none
    * 
    * Pre-Conditions: none
    * 
    * Post-Conditions: none
    *******************************************************************************/
    void showZoo(){
        for (int i = 0; i < zooList.size(); i++) {
            System.out.println(zooList.get(i).toString());
            System.out.println("Food: " + zooList.get(i).getFoodType());
            System.out.println("Food Amount: " + zooList.get(i).getFoodAmt());
            System.out.println("Status: " + zooList.get(i).tourStatus());
            System.out.println("_________________________________");
        }
        
    }
    /********************************************************************************
    * Method: showNotOnTour
    * 
    * Description:  same as showZoo(), but only shows animals not on tour
    *  
    * Parameters: none
    * 
    * Pre-Conditions: will output same as showZoo if no animals have been sent on tour
    * 
    * Post-Conditions: none
    *******************************************************************************/
    void showNotOnTour(){
        for (int i = 0; i < zooList.size(); i++) {
            if(!zooList.get(i).isOnTour()){
            System.out.println(zooList.get(i).toString());
            System.out.println("Food: " + zooList.get(i).getFoodType());
            System.out.println("Food Amount: " + zooList.get(i).getFoodAmt());
            System.out.println("_________________________________");
            }
            
        }
        
    }

    
    //Getters and Setters for the ArrayLists in this class
    
    public ArrayList<Animal> getZooList() {
        return zooList;
    }

    public void setZooList(ArrayList<Animal> zooList) {
        this.zooList = zooList;
    }

    public ArrayList<Animal> getAllList() {
        return allList;
    }

    public void setAllList(ArrayList<Animal> allList) {
        this.allList = allList;
    }
    
}
