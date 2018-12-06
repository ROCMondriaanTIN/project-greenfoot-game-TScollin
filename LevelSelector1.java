import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelSelector1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelector1 extends World
{
   public static int level; 

    /**
     * Constructor for objects of class LevelSelector1.
     * 
     */
    public LevelSelector1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
    System.out.print("ja");
     
     
    }
    public void act(){
        if(Greenfoot.isKeyDown("1") )
     {
         //System.out.print("ja");
         //MyWorld.BGM.playLoop();
         //getWorld().removeObject(this);
         level = 1;
         Greenfoot.setWorld(new BeginLevel());
         
        }
        if(Greenfoot.isKeyDown("2") )
     {
         //System.out.print("ja");
         //MyWorld.BGM.playLoop();
         //getWorld().removeObject(this);
         level = 2;
         Greenfoot.setWorld(new MyWorld());
         
        }
           if(Greenfoot.isKeyDown("3") )
     {
         //System.out.print("ja");
         //MyWorld.BGM.playLoop();
         //getWorld().removeObject(this);
         level = 3;
         Greenfoot.setWorld(new Level2());
         
        }
    }
}
