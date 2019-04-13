/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;



/**
 *
 * @author lenovo
 */
public class FighterGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        //new Display("Game Time",500,600);
        GameSetUp game = new GameSetUp("Game Time",500,600);
        game.start();
    }
    
}
