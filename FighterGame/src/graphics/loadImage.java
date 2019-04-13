/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author lenovo
 */
public class loadImage 
{
    public static BufferedImage image;
    public static BufferedImage player;
    public static BufferedImage enemy;
    public static BufferedImage knife;
    public static void init()
    {
        try
        {
            image = imageLoader("/background.png");
            player = imageLoader("/player.jpg");
            enemy = imageLoader("/enemy.jpg");
            knife = imageLoader("/knife.jpg");
            
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }
    
    public static BufferedImage imageLoader(String path)
    {
        try
        {
            return ImageIO.read(loadImage.class.getResource(path));
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
    
    
    
}
