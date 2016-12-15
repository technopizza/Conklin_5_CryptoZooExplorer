package conklin_5_cryptozoo;
//
/*******************************************************************************
* Filename: ZooAnimal.java
* 
* Author: Conklin, Jason Date: November 30, 2016
* 
* Description: An Interface which provides the abstract methods for Animal and its children
* 
* Input: none
* 
* Output: none
*******************************************************************************/
public interface ZooAnimal {
     void setFoodType(String food);

     String getFoodType();

     void setFoodAmt(int amt);

     int getFoodAmt();
}
