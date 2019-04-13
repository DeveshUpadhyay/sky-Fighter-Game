/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bullet;

import graphics.loadImage;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author lenovo
 */
public class bullet 
{
    private int x;
    private int y;
    private int speed;
    
    public bullet(int x,int y)
    {
        this.x=x;
        this.y=y;
        speed=10;
    }
    
    public int gety()
    {
        return y;
    }
    
    public int getx()
    {
        return x;
    }
    
    public void tick()
    {
        y -= speed;
        
    }
    
    public void render(Graphics g)
    {
        //g.setColor(Color.blue);
        g.drawImage(loadImage.knife, x, y, 19, 19, null);
    }
}
