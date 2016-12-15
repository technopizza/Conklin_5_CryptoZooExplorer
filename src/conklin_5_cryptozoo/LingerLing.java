//s
package conklin_5_cryptozoo;

/*******************************************************************************
* Filename: LingerLing.java
* 
* Author: Conklin, Jason Date: November 30, 2016
* 
* Description: A class that defines some basic variables and methods for a LingerLing object
*               different from siblings in it methods
* 
* Input: none
* 
* Output: none
*******************************************************************************/
public class LingerLing extends Animal {
   
    private String foodType;
    private int foodAmt;
    
    LingerLing(String name, String origin, int dngr){
        super(name, origin, dngr);
        this.setGridChar('L');
    }

    @Override
    public String getFoodType() {
        return "none";
    }

    @Override
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public int getFoodAmt() {
        return 0;
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
