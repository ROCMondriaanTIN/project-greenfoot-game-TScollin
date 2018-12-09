        import greenfoot.*;
        
        /**
         *
         * @author R. Springer
         */
        public class Hero extends Mover {
        
            private final double gravity;
            private final double acc;
            private final double drag;
            public int animationCounter = 0;
            private int frame = 1;
            private static int teller = 1;
            public static int coins;
            public static boolean newCoin;
            public static boolean isVoltooid;
            public boolean isDood;
            public int counter;
            public int counter2;
            public static String richting;
            public static boolean mirrored;
            public static boolean isSneller;
            public static boolean isPowered;
            public boolean powerUp;
            public Hero() {
                super();
                gravity = 9.8;
                acc = 0.6;
                drag = 0.8;
                setImage("p1_walk02.png");
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
            private GreenfootImage run12 = new GreenfootImage("p1_walk01.1.png");
            private GreenfootImage run13 = new GreenfootImage("p1_walk02.1.png");
            private GreenfootImage run14 = new GreenfootImage("p1_walk03.1.png");
            private GreenfootImage run15 = new GreenfootImage("p1_walk04.1.png");
            private GreenfootImage run16 = new GreenfootImage("p1_walk05.1.png");
            private GreenfootImage run17 = new GreenfootImage("p1_walk06.1.png");
            private GreenfootImage run18 = new GreenfootImage("p1_walk07.1.png");
            private GreenfootImage run19 = new GreenfootImage("p1_walk08.1.png");
            private GreenfootImage run20 = new GreenfootImage("p1_walk09.1.png");
            private GreenfootImage run21 = new GreenfootImage("p1_walk10.1.png");
            private GreenfootImage run22 = new GreenfootImage("p1_walk11.1.png");
            private GreenfootImage jump1 = new GreenfootImage("p1_jump.png");
        
            public void kill() {
                Greenfoot.playSound("dood.wav");
                isDood = true;
            }
            //if ...{
            //Greenfoot.setWorld(BeginLevel);}
            @Override
            public void act () {
                System.out.print(counter2);
                if (isPowered == true)
                {
                    lekkerWachten();
                }
                System.out.println(mirrored);
                if ( isDood == true) {
                    velocityX = 0;
                    velocityY = 0;
                    getImage().setTransparency(0);
                    
                    counter++;
                    
                    if(counter > 100) {
                        if (LevelSelector1.level == 2){
                        Greenfoot.setWorld(new MyWorld());
                    }
                    else if (LevelSelector1.level == 1){
                    Greenfoot.setWorld(new BeginLevel());}
                    else if (LevelSelector1.level == 3){
                    Greenfoot.setWorld(new Level2());}
                        
                    }
                    return;
                    
                }
                
                       
                handleInput();
                
                velocityX *= drag;
                velocityY += acc;
                //System.out.println(getX());
                //System.out.println(getY());
                if (velocityY > gravity) {
                    velocityY = gravity;
                }
                applyVelocity();
                
        if (getWorld().getObjects(Hero.class).size() != 0){
                for (Actor snail : getIntersectingObjects(Snail.class)) {
                        if (snail != null) {
                            if (isTouching(Tile.class)) {
                               
        
                                kill();
                                isVoltooid = true;
                                
        
                                
                            } else {
                                Greenfoot.playSound("enemydood.wav");
                                getWorld().removeObject(snail);
                                continue;
        
                            }
                        }}}
                 
                
                        
        
        
                for (Actor enemy : getIntersectingObjects(Enemy.class)) { 
                    if (enemy != null) {
                        isVoltooid = true;
                        kill();
                    break;
                }
            }
            if (getWorld().getObjects(Hero.class).size() != 0){
            for (Actor slime : getIntersectingObjects(Slime.class)) {
                    if (slime != null) {
                        if (isTouching(Tile.class)) {
                           
                       kill();
                        isVoltooid = true;
                        
                        
                        

                        
                    } else {
                        Greenfoot.playSound("enemydood.wav");
                        getWorld().removeObject(slime);
                        continue;

                    }
                }}}
                
               
        
                for (Actor actor : getIntersectingObjects(Tile.class)) {
                    Tile tile = (Tile)actor;
            if (tile.getImage().toString().contains("Water"))

            {
                isVoltooid = true;
                kill();
                
                return;
   
            }
            if (tile.getImage().toString().contains("signExit")){
                
                Greenfoot.setWorld(new LevelSelector1());
            }
        }
        for (Actor actor : getIntersectingObjects(Tile.class)) {
                    Tile tile = (Tile)actor;
            if (tile.getImage().toString().contains("coinBronze"))

            {
                getWorld().removeObject(tile);
                Greenfoot.playSound("coin.wav");
                newCoin = true;
                isPowered = true;
                
                
                return;
            }
        }
        for (Actor actor : getIntersectingObjects(Tile.class)) {
                    Tile tile = (Tile)actor;
            if (tile.getImage().toString().contains("boxCoin"))

            {
                //hier komt de code van wat je wilt doen
            }
        }
        
    }
    
    boolean onGround(){
        Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Tile.class);
        return under != null;
    }
    
                   // public class dood {
                    
                   // public int dood(boolean isDood, int sound) {
                    //    isDood = true;
                    //    return isDood;
                   // }
               // }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space") && (onGround() == true)|| Greenfoot.isKeyDown("Up") && (onGround() == true)) {
            velocityY = -15;
            //System.out.print("hoi");
            Greenfoot.playSound("jump.wav");
                        
        }

        if (Greenfoot.isKeyDown("a")|| Greenfoot.isKeyDown("Left")) {
            velocityX = -5;
            animationCounter = animationCounter + 1;
           mirrored = true;
            if (onGround() == false) {
             setImage("jumpM.png");
            }
            if (animationCounter % 6 == 0) {
                animationLeft();
            }
        } else if (Greenfoot.isKeyDown("d")|| Greenfoot.isKeyDown("Right")) {
            velocityX = 5;
            animationCounter = animationCounter + 1;
            mirrored = false;
             if (onGround() == false) {
             setImage("p1_jump.png");
            }
            //else {
            //setImage("p1_stand.png");            }
            if (animationCounter % 6 == 0) {
                animationRight();
            }
            

        }
        if (velocityY == 0 && velocityX == 0) {
                 setImage("p1_front.png");
                }
                if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("Down")){
                    setImage("p1_duck.png");
                }

    }
    
    

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

private void animationRight() {
if (onGround() == false) {
    
                            //System.out.print("hoi");
                //if(mirrored == false){
               // setImage("p1_jump.png");}
                //else{
                //setImage ("p1_jump.png");
           // setImage("jumpM.png");}
            }
            else{

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
            private void animationLeft() {


            switch (teller) {
                
                case 1:
                    setImage(run12);
                    teller++;
                    break;
                case 2:
                    setImage(run13);
                    teller++;
                    break;
                case 3:
                    setImage(run14);
                    teller++;
                    break;
                case 4:
                    setImage(run15);
                    teller++;
                    break;
                case 5:
                    setImage(run16);
                    teller++;
                    break;
                case 6:
                    setImage(run17);
                    teller++;
                    break;
                case 7:
                    setImage(run18);
                    teller++;
                    break;
                case 8:
                    setImage(run19);
                    teller++;
                    break;
                case 9:
                    setImage(run20);
                    teller++;
                    break;
                case 10:
                    setImage(run21);
                    teller++;
                    break;

                default:
                    teller = 1;
            }}
        public void waiting() throws InterruptedException{
        Thread.sleep(2000);}
    public void lekkerWachten(){
    while (counter2 < 50)
                {
                    isSneller = true;
                    counter2 ++;
                }isPowered = false;
            counter2 = 0;}
            }
            
