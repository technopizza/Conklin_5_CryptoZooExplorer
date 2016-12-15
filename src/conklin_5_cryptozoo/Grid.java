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
public class Grid {
    

    public static final char gridBkgndChar = '□';
    private int base;
    private int height;
    
    private char[][] grid;

    public Grid(int base, int height) {
        this.base = base;
        this.height = height;
        grid = new char[base][height];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = gridBkgndChar;
            }
            
        }
    }
    
     
    void draw(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    
    public void setCharAt(int x, int y, char gridChar){
        grid[x][y] = gridChar;
    }
    
    public char getCharAt(int x, int y){
        return grid[x][y];
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }
    
    
}
