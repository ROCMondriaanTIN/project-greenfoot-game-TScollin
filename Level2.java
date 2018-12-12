import javax.swing.JOptionPane;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class Level2 extends World {
    public static String levelstring;
    public static int level = 1;
    public static boolean firstStart = true;
    public static boolean gameoverWorld;
    public static int coinX = 50;
    static GreenfootSound BGM = new GreenfootSound("bgm.wav");
 
    private CollisionEngine ce;

    /**
     * Constructor for objects of class Level2.
     *
     */
    public Level2() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        
        this.setBackground("bg.png");
        coinX = 50;
       // levelstring = JOptionPane.showInputDialog("Kies een "
       //         + "level (1 of 2)");
      //  level = Integer.parseInt(levelstring);

        int[][] map = {
        {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,15,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,3,3,3},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,3,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,-1,-1,-1,-1,15,-1,-1,3,-1,-1,-1,-1,-1,-1,},
{-1,-1,-1,9,3,3,3,3,3,3,-1,-1,3,3,3,3,3,3,3,3,3,3,3,3,3,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,16,-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{3,3,3,3,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,15,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,15,12},
{-1,-1,-1,-1,3,3,3,3,3,-1,-1,3,3,3,3,3,3,3,3,3,3,-1,-1,3,-1,-1,3,-1,-1,3,3,3},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
};

        
if (level == 1){
        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero();
        Greenfoot.playSound("bgm.wav");
      

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 374, 2412);
        
        addObject(hero, 100, 100);
        addObject(new Slime(), 600, 2412);
        
        //addObject(new Snail(), 3616, 3345 );
        addObject(new Snail(), 3616, 3407 );
        addObject(new Enemy(), 130, 1428       );
       // if (firstStart == true)
        //{//addObject(new StartScreen(), 500, 400);
           
        //firstStart = false;}
        //addObject(new LevelSelector(), 500, 400);
        addObject(new Slime(), 3300, 3407);
       
        

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
        prepare();
    }
    
    }

    @Override
    public void act() {
        ce.update();
        if (Hero.newCoin == true)
        {
            addObject(new CoinHUD(), coinX, 50);
            coinX += 50;
            Hero.newCoin = false;
        }
       
       if (LevelSelector1.heeftT == true){addObject (new THUD(), 300,50);}
        if (LevelSelector1.heeftO == true){addObject (new OHUD(), 350,50);}
        if (LevelSelector1.heeftP == true){addObject (new PHUD(), 400,50);}
    }

    /**
     * Prepare the world for the  kopkpjrpklmrmpkmpkldstart of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
