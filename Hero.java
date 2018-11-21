

import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private int teller = 0;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }
    private GreenfootImage run1 = new GreenfootImage("p1_walk01.png");
    private GreenfootImage run2 = new GreenfootImage("p1_walk02.png");
    private GreenfootImage run3 = new GreenfootImage("p1_walk03.png");
    private GreenfootImage run4 = new GreenfootImage("p1_walk04.png");
    private GreenfootImage run5 = new GreenfootImage("p1_walk05.png");
    private GreenfootImage run6 = new GreenfootImage("p1_walk06.png");
    private GreenfootImage run7 = new GreenfootImage("p1_walk07.png");
    private GreenfootImage run8 = new GreenfootImage("p1_walk08.png");
    private GreenfootImage run9 = new GreenfootImage("p1_walk09.png");
    private GreenfootImage run10 = new GreenfootImage("p1_walk10.png");
    private GreenfootImage run11 = new GreenfootImage("p1_walk11.png");

    @Override
    public void act() {
        handleInput();
        
        velocityX *= drag;
        velocityY += acc;
        System.out.println(getX());
        System.out.println(getY());
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
if (getWorld().getObjects(Hero.class).size() != 0){
        for (Actor snail : getIntersectingObjects(Snail.class)) {
                if (snail != null) {
                    if (isTouching(Tile.class)) {
                       

                        
                        
                        setLocation(300, 200);

                        
                    } else {
                        getWorld().removeObject(snail);
                        continue;

                    }
                }}}
        for (Actor enemy : getIntersectingObjects(Snail.class)) {
            if (enemy != null) {
                
                getWorld().removeObject(this);
                break;
            }
        }
        if (getWorld().getObjects(Hero.class).size() != 0){
        for (Actor slime : getIntersectingObjects(Slime.class)) {
                if (slime != null) {
                    if (isTouching(Tile.class)) {
                       

                        
                        
                        setLocation(300, 200);

                        
                    } else {
                        getWorld().removeObject(slime);
                        continue;

                    }
                }}}
        
                for (Actor actor : getIntersectingObjects(Tile.class)) {
                    Tile tile = (Tile)actor;
            if (tile.getImage().toString().contains("Water"))

            {
                getWorld().removeObject(this);
                return;
            }
        }
        
    }
    
    boolean onGround(){
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
        return under != null;
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space") && (onGround() == true)) {
            velocityY = -15;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -5;
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
        }
    }
    

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

private void animationRight() {


            switch (teller) {
                
                case 1:
                    setImage(run1);
                    teller++;
                    break;
                case 2:
                    setImage(run2);
                    teller++;
                    break;
                case 3:
                    setImage(run3);
                    teller++;
                    break;
                case 4:
                    setImage(run4);
                    teller++;
                    break;
                case 5:
                    setImage(run5);
                    teller++;
                    break;
                case 6:
                    setImage(run6);
                    teller++;
                    break;
                case 7:
                    setImage(run7);
                    teller++;
                    break;
                case 8:
                    setImage(run8);
                    teller++;
                    break;
                case 9:
                    setImage(run9);
                    teller++;
                    break;
                case 10:
                    setImage(run10);
                    teller++;
                    break;

                default:
                    teller = 1;
            }}}
        
    
