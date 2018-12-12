import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;
/**
 * Write a description of class LevelSelector1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelector1 extends World
{
   public static int level;
   public static String woord;
   public static int huidigLevel;
   public static boolean level2A;
   public static boolean level3A;
   public static boolean woordA;
   public static boolean heeftT;
   public static boolean heeftO;
   public static boolean heeftP;
   

    /**
     * Constructor for objects of class LevelSelector1.
     * 
     */
    public LevelSelector1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
    
     
     
    }
    public void act(){
        if(Greenfoot.isKeyDown("1") )
     {
         //System.out.print("ja");
         //MyWorld.BGM.playLoop();
         //getWorld().removeObject(this);
         level = 1;
         huidigLevel = 1;
         Greenfoot.setWorld(new BeginLevel());
         
        }
        if(Greenfoot.isKeyDown("2") )
     {
         if (level2A == true){
         //System.out.print("ja");
         //MyWorld.BGM.playLoop();
         //getWorld().removeObject(this);
         level = 2;
         huidigLevel = 2;
         Greenfoot.setWorld(new MyWorld());
         
        }
    else{JOptionPane.showMessageDialog(null, "Level nog niet beschikbaar.");}}
           if(Greenfoot.isKeyDown("3") )
     {
         if (level3A == true){
         //System.out.print("ja");
         //MyWorld.BGM.playLoop();
         //getWorld().removeObject(this);
         level = 3;
         huidigLevel = 3;
         
         Greenfoot.setWorld(new Level2());
         
        }else{JOptionPane.showMessageDialog(null, "Level nog niet beschikbaar.");}}
        if(Greenfoot.isKeyDown("9"))
        {
            if (woordA == true && heeftT == true && heeftO == true && heeftP == true){
            woord = JOptionPane.showInputDialog("Dit zijn de letters: P, T, O. Welk woord is dit?");
            if (woord.contains("top") || (woord.contains("Top")))
            {
                JOptionPane.showMessageDialog(null, "Goedzo! dat is het juiste woord.");


            }
            else{
                JOptionPane.showMessageDialog(null, "Dat is niet het juiste woord.");


            }} else{JOptionPane.showMessageDialog(null, "Level nog niet beschikbaar.");}
        }
    }
}
