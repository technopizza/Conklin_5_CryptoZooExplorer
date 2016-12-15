package conklin_5_cryptozoo;
 
/*******************************************************************************
* Filename: Animal.java
* 
* Author: Conklin, Jason Date: November 30, 2016
* 
* Description: An abstract class that defines some basic variables and methods for its children
* 
* Input: ZooAnimal interface
* 
* Output: none
*******************************************************************************/
public abstract class Animal implements ZooAnimal {
    private String name;
    private String origin;
    private char gridChar;
    private int dangerRating;
    private GridEntity gridEntity;
    private boolean onTour;
    
   public Animal(String name, String origin, int dngr){
       this.name = name;
       this.origin = origin;
       this.dangerRating = dngr;
       
       onTour = false;
       
   }
    
    public String toString(){
        return "Name: " + name + " \nOrigin: " + origin + "\nDanger Rating: " + dangerRating;
    }
    
    

    abstract int foodPerWeek();

    public String tourStatus(){
        String tmp;
        if(onTour){
            tmp = "On tour";
        }
        else{
            tmp = "Not on tour";
        }
        return tmp;
    }
    
    public boolean isOnTour() {
        return onTour;
    }

    public void setOnTour(boolean onTour) {
        this.onTour = onTour;
    }

    public String getName() {
        return name;
    }

    public GridEntity getGridEntity() {
        return gridEntity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public char getGridChar() {
        return gridChar;
    }

    public void setGridChar(char gridChar) {
        this.gridChar = gridChar;
    }

    public int getDangerRating() {
        return dangerRating;
    }

    public void setDangerRating(int dangerRating) {
        this.dangerRating = dangerRating;
    }

    public void setGridEntity(GridEntity gridEntity) {
        this.gridEntity = gridEntity;
    }
    
    
     
}
