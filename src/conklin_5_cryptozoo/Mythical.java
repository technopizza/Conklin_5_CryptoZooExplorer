package conklin_5_cryptozoo;
//
/*******************************************************************************
* Filename: Mythical.java
* 
* Author: Conklin, Jason Date: November 30, 2016
* 
* Description: A class that defines some basic variables and methods for a mythical object
* 
* Input:
* 
* Output: none
*******************************************************************************/
public class Mythical extends Animal{
    private String foodType;
    private int foodAmt;
    
    Mythical(String name, String origin, int dngr,  String fdtp, int fdamt){
        super(name, origin, dngr);
        foodType = fdtp;
        foodAmt = fdamt;
        this.setGridChar('M');
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
