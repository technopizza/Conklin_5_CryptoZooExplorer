/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conklin_5_cryptozoo;

/**
 *
 * @author Jason
 */
public class GridEntity {
    private int posX;
    private int posY;
    private char gridChar;

    public GridEntity(int posX, int posY, char gridChar) {
        this.posX = posX;
        this.posY = posY;
        this.gridChar = gridChar;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosY() {
        return posY;
    }

    public void setGridChar(char gridChar) {
        this.gridChar = gridChar;
    }

    public char getGridChar() {
        return gridChar;
    }
}
