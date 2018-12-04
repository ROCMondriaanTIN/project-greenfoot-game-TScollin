import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends Mover 
{


         public void act(){
   {
    setImage("StartScreen.png");
   if(Greenfoot.isKeyDown("enter")){
       MyWorld.BGM.playLoop();
   getWorld().removeObject(this);}
   //set new 
}



}

}
    
