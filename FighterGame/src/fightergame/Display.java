/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fightergame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author lenovo
 */
public class Display 
{
    private String title;
    private int width;
    private int height;
    
    public static JFrame frame;
    public static Canvas canvas;
    
    public Display(String title,int width, int height)
    {
        this.title=title;
        this.width=width;
        this.height=height;
        createDisplay();
    }
    public void createDisplay()
    {
        frame=new JFrame(title);
        frame.setSize(width,height);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas=new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setBackground(new Color(212,154,140));
        canvas.setFocusable(false);
        frame.add(canvas);
        frame.pack();
        
    }
    
    public Canvas getCanvas()
    {
        return canvas;
    }
}
