import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen1 extends World
{

    /**
     * Constructor for objects of class StartScreen1.
     * 
     */
    public StartScreen1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
    }
    public void act(){
   {
    
   if(Greenfoot.isKeyDown("enter"))
   {  
       
       MyWorld.BGM.playLoop();
       
        Greenfoot.setWorld(new LevelSelector1());
   }
     

   
}



}

}
