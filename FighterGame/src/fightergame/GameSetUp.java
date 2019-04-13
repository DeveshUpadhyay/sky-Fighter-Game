/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import graphics.loadImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

/**
 *
 * @author lenovo
 */
public class GameSetUp implements Runnable
{
    private String title;
    private int width;
    private int height;
    private Thread thread;
    private boolean running;
    private BufferStrategy buffer;
    private Display display;
    private Graphics g;
    private int y;
    private GameManager manager;
    public static final int gameWidth = 400;
    public static final int gameHeight = 400;
    
    public GameSetUp(String title,int width,int height)
    {
        this.title=title;
        this.height=height;
        this.width=width;
    }
    
    public void init()
    {
        display=new Display(title,width,height);
        loadImage.init();
        manager=new GameManager();
        manager.init();
        //start = true;
    }
    
    public synchronized void start()
    {
        if(running)
            return ;
        running=true;
        if(thread==null)
        {
            thread=new Thread(this);
            thread.start();
        }
    }
    
    public synchronized void stop()
    {
        if(!(running))
            return ;
        running=false;
        try
        {
            thread.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public void tick()
    {
        manager.tick();
        
    }
    
    public void render()
    {
        buffer = display.getCanvas().getBufferStrategy();
        if(buffer==null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = buffer.getDrawGraphics();
        g.clearRect(0,1, width, height);
        //draw
        
       // g.setColor(Color.WHITE);
        g.drawImage(loadImage.image, 40, 40, gameWidth+20, gameHeight+20, null);
        manager.render(g);
        //end of draw
        buffer.show();
        g.dispose();
        
    }
    
    public void run()
    {
        init();
        int fps = 50;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long current = System.nanoTime();
        
        
        while(running)
        {
            delta = delta + (System.nanoTime()-current)/timePerTick;
            current = System.nanoTime();
            if(delta >= 1)
            {
                tick();
                render();
                delta--;
            }
            
            
        }
    }
}
