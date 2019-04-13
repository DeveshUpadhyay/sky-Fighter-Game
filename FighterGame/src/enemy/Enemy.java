/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy;

import graphics.loadImage;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author lenovo
 */
public class Enemy 
{
    private int x;
    private int y;
    
    public Enemy(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public void tick()
    {
        y += 1;
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
    public void render(Graphics g)
    {
        //g.setColor(Color.blue);
        g.drawImage(loadImage.enemy, x, y, 45, 45, null);
    }
}
