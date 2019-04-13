/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import bullet.bullet;
import fightergame.Display;
import fightergame.GameManager;
import graphics.loadImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author lenovo
 */
public class Player implements KeyListener
{
    private int x;
    private int y;
    private boolean left;
    private boolean right;
    private boolean fire;
    private long current;
    private long delay;
    private int health;
    
    public Player(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    
    public void init()
    {
        Display.frame.addKeyListener(this);
        current = System.nanoTime();
        delay = 100;
        health=3;
    }
    
    
    public void tick()
    {
        if(!(health <= 0))
        {
            if(left)
            {
                if(x>=50)
                {
                    x -= 5;
                }
            }
            if(right)
            {
                if(x<=440-30)
                {
                    x += 5;
                }   
            }
            if(fire)
            {
                long breaks = (System.nanoTime()-current)/1000000;
                if(breaks > delay)
                {
                    GameManager.bullet.add(new bullet(x+15,y));
                    
                }
                current = System.nanoTime();
     
            }
        }
    }
    public void render(Graphics g)
    {
        if(!(health <= 0))
        {
            //g.setColor(Color.red);
            g.drawImage(loadImage.player,x,y-4,45,45,null);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_LEFT)
        {
            left=true;
        }
        if(source == KeyEvent.VK_RIGHT)
        {
            right=true;
        }
        if(source == KeyEvent.VK_B)
        {
            fire=true;
        }
    }
    
    public void keyReleased(KeyEvent e)
    {
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_LEFT)
        {
            left=false;
        }
        if(source == KeyEvent.VK_RIGHT)
        {
            right=false;
        }
        if(source == KeyEvent.VK_B)
        {
            fire=false;
        }
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public void setHealth(int health)
    {
        this.health=health;
    }
}
