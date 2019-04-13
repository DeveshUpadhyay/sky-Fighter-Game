/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import bullet.bullet;
import enemy.Enemy;
import entity.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lenovo
 */
public class GameManager implements KeyListener
{
    private Player player;
    public static ArrayList<bullet> bullet;
    private ArrayList<Enemy> enemies;
    private long current;
    private long delay;
    private int health;
    private int score;
    private boolean start;
    public GameManager()
    {
        
    }
    
    public void init()
    {
        Display.frame.addKeyListener(this);
        player=new Player((GameSetUp.gameWidth/2)+50,(GameSetUp.gameHeight-30)+50);
        player.init();
        bullet=new ArrayList<bullet>();
        enemies = new ArrayList<Enemy>();
        current=System.nanoTime();
        delay = 2000;
        health = player.getHealth();
        //start=true;
    }
    
    public void tick()
    {
        if(start)
        {
            player.tick();
            for(int i = 0; i<bullet.size(); i++)
            {
                bullet.get(i).tick();
            }
            long breaks = (System.nanoTime()-current)/1000000;
            if(breaks > delay)
            {
                for(int i=0; i<2; i++)
                {
                    Random rand=new Random();
                    int randx=rand.nextInt(450);
                    int randy = rand.nextInt(450);
                    if(health > 0)
                    {
                        enemies.add(new Enemy(randx,-randy));
                    }
                }
                current = System.nanoTime();
            }
        
            for(int i=0; i<enemies.size(); i++)
            {
                enemies.get(i).tick();
            }
        }
    }
    public void render(Graphics g)
    {
        if(start)
        {
        player.render(g);
        for(int i = 0; i<bullet.size(); i++)
        {
            bullet.get(i).render(g);
        }
        for(int i = 0; i<bullet.size(); i++)
        {
            if(bullet.get(i).gety()<=50)
            {
                bullet.remove(i);
                i--;
            } 
        }
        for(int i=0; i<enemies.size(); i++)
        {
            if(!(enemies.get(i).getx() <= 50 || enemies.get(i).getx() >= 450 - 50 || enemies.get(i).gety()>=450 - 50))
            {
                if(enemies.get(i).gety() >= 50)
                 {
                    enemies.get(i).render(g);
                }       
            }
                
        }
        for(int i=0; i<enemies.size(); i++)
        {
            
            int ex = enemies.get(i).getx();
            int ey = enemies.get(i).gety();
            
            int px = player.getx();
            int py = player.gety();
            if(px < ex + 45 && px + 45 > ex && py < ey + 45 && py + 45 > ey)
            {
                enemies.remove(i);
                i--;
                health--;
                System.out.println(health);
               if(health<=0)
               {
                   enemies.removeAll(enemies);
                   player.setHealth(0);
                   start = false;
               }
                
            }
            
            for(int j=0; j<bullet.size(); j++)
            {
                int bx = bullet.get(j).getx();
                int by = bullet.get(j).gety();
                
                if(ex < bx+ 19 && ex + 45 > bx && ey < by + 19 && ey + 45 > by)
                {
                   enemies.remove(i);
                   i--;
                   bullet.remove(j);
                   j--;
                   score=score + 5;
                }
            }
            g.setColor(Color.blue);
            g.setFont(new Font("arial",Font.BOLD,40));
            g.drawString( "Score :- " + score , 70 , 500 );
        }
             
    }
    else
    {
        g.setFont(new Font("arial",Font.PLAIN,33));
        g.drawString("Press enter to start ",100, (GameSetUp.gameHeight/2)+50);
    }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        int source = e.getKeyCode();
        if(source == KeyEvent.VK_ENTER)
        {
            start=true;
            init();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
