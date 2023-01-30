import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{
    boolean DEBUG = false;
    
    //GifImage templateGif = new GifImage("explosion.gif");//template 
    TitleScreen title;
    Ship ship;
    private int lives = 3;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Game()
    {    
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false);
        
        ship = new Ship();
        addObject(ship, getWidth()/2, getHeight()/2);//add the ship to the world at its midpoint
        
        for(int i = 0; i < Spawner.xLocations.length; i++){
            Spawner temp = new Spawner();
            addObject(temp, Spawner.xLocations[i], Spawner.yLocations[i]);
        }
        addObject(new Enemy(), 200,200);  //to do 
        setPaintOrder(Ship.class, Bullet.class, Asteroid.class);
        if (DEBUG == false){
            title = new TitleScreen();
            title.setGame(this);
            Greenfoot.setWorld(title);
        }
    }
    
    public void act(){
        //display the lives remaining
        if (lives>0){
            showText("Lives: "+lives, 100,100);
        }
        else{
            //else
            showText("", 100,100);
            showText("Game Over", getWidth()/2,getHeight()/2);
            return;        
        }
        //check if to see if a ship is in world
        int numShips = getObjects(Ship.class).size() - getObjects(Enemy.class).size();
        if(numShips<=0){
            
            //decrease lives
            lives--;
            //if lives > 0
            if(lives>0){
                //create a new ship 
                //add it into the world
                addObject(new Ship(), getWidth()/2, getHeight()/2);
            }
            
        }
    }
    
}
