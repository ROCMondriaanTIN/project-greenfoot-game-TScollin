import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedBoost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

    /**
     * Act - do whatever the SpeedBoost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public class Player(){
    public void act() 
    {
        public class Player extends Actor
{
 
    private final int SPEED_BOOST_TIMER = 115;
    private int speedBoostTimeLeft = SPEED_BOOST_TIMER;
    private int mySpeed;
    private boolean gotSpeedBoost = false;
 
        public Player()
        {
        mySpeed = 5;
        //etc etc
        }
     
        public void act()
            {
            get(Speedboost.class);
            if (gotSpeedBoost)
            {
            speedBoostTimer();
            }
        }
 
        public void getSpeedBoost()
        {
            Actor actor = getOneObjectAtOffset(0, 0, SpeedBoost.class);
            if (actor != null) {
                getWorld().removeObject(actor);
            gotSpeedBoost = true;
            speed += 5;
            }
        }
    public void speedBoostTimer()
    {
        speedBoostTimeLeft--;
        if (speedBoostTimeLeft <= 0)
        {
        gotSpeedBoost = false;
        speed -= 5;
        speedboostTimeLeft = SPEED_BOOST_TIMER;
        }
    }
}
    }  
}
}
