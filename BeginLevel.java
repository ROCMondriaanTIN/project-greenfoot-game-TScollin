import javax.swing.JOptionPane;

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class BeginLevel extends World {
    public static String levelstring;
    public static int level = 2;
    public static boolean firstStart = true;
    public static boolean gameoverWorld;
    public static int coinX = 50;
    public static boolean tIsEr;
    public static boolean oIsEr;
    
    public static boolean pIsEr;
    public static boolean jIsEr;
    public static boolean eIsEr;
    public static boolean daarIsDeT;
    public static boolean daarIsDeO;
    
    public static boolean daarIsDeP;
    public static boolean daarIsDeJ;
    public static boolean daarIsDeE;
    static GreenfootSound BGM = new GreenfootSound("bgm.wav");

    private CollisionEngine ce;

    /**
     * Constructor for objects of class BeginLevel.
     *
     */
    public BeginLevel() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("bg_gras.png");
        //this.setBackground("bg.png");
        coinX = 50;
       // levelstring = JOptionPane.showInputDialog("Kies een "
       //         + "level (1 of 2)");
      //  level = Integer.parseInt(levelstring);

        
        int[][]map2 ={{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,17,-1,-1,-1,12,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,9,3,3,3,3,3,3,3,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,2,-1,-1,-1,-1,-1,-1,-1,-1,-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,15,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,3,3,3,3,3,-1,-1,3,3,3,3,3,-1,-1,3,3,3,3,3,3,-1,-1,3,3,3,3,3,3,-1,-1,3,3,3,3,3,3,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11},
{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
};

    if (level == 2){
        System.out.println("level ==2");
        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map2);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero();
        
      

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 374, 2412);
        
        addObject(hero, 374, 612);
        
        //addObject(new Snail(), 3616, 3345 );
        addObject(new Snail(), 1145, 645 );
        addObject(new Enemy(), 130, 1428       );
        //addObject(new StartScreen(), 500, 400);
        

        // Force act zodat de camera op de juist plek staat.
        camera.act();
        hero.act();

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
        prepare();
        if (BeginLevel.daarIsDeT == true)
        {
            addObject (new THUD(), 300, 50);
        }
        if (BeginLevel.daarIsDeO == true)
        {
            addObject (new OHUD(), 350, 50);
        }
        if (BeginLevel.daarIsDeP == true)
        {
            addObject (new PHUD(), 400, 50);
        }
        if (BeginLevel.daarIsDeJ == true)
        {
            addObject (new JHUD(), 450, 50);
        }
        if (BeginLevel.daarIsDeE == true)
        {
            addObject (new EHUD(), 500, 50);
        }
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
        if (LevelSelector1.heeftT == true && tIsEr == false){addObject (new THUD(), 300,50);
        tIsEr = true; BeginLevel.daarIsDeT = true;}
        if (LevelSelector1.heeftO == true && oIsEr == false) {addObject (new OHUD(), 350,50);
        oIsEr = true; BeginLevel.daarIsDeO = true;}
        if (LevelSelector1.heeftP == true && pIsEr == false){addObject (new PHUD(), 400,50);
        pIsEr = true; BeginLevel.daarIsDeP = true;}
        if (LevelSelector1.heeftJ == true && jIsEr == false){addObject (new JHUD(), 450,50);
        jIsEr = true; BeginLevel.daarIsDeJ = true;}
        if (LevelSelector1.heeftE == true && eIsEr == false){addObject (new EHUD(), 500,50);
        eIsEr = true; BeginLevel.daarIsDeE = true;}
        
        
      
        
        
       
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
