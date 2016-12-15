package conklin_5_cryptozoo;
//
/*******************************************************************************
* Filename: Paranormal.java
* 
* Author: Conklin, Jason Date: November 30, 2016
* 
* Description: A class that  defines some basic variables and methods for a Paranormal object
*               different from siblings in its constructor
* 
* Input: none
* 
* Output: none
*******************************************************************************/
public class Paranormal extends Animal {
   private String foodType;
    private int foodAmt;
    
    Paranormal(String name, String origin, int dngr){
        super(name, origin, dngr);
        foodType = "meat";
        foodAmt = 5;
        this.setGridChar('P');
    }

    @Override
    public String getFoodType() {
        return foodType;
    }

    @Override
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public int getFoodAmt() {
        return foodAmt;
    }

    @Override
    public void setFoodAmt(int foodAmt) {
        this.foodAmt = foodAmt;
    }
    @Override
    int foodPerWeek(){
        return 1;
    }
}
