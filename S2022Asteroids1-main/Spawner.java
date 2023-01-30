import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Spawner class spawns in Asteroids, Powerups and Enemies.
 * 
 * @author Nathan Rowbottom 
 * @version Feb 14, 2022
 */
public class Spawner extends Actor
{   public static int [] probabilities = {3, 14};
    public static int [] xLocations = {300, 600, 900, 300, 600, 900, -500, -500, 1700, 1700};
    public static int [] yLocations = {-500, -500, -500, 1300, 1300, 1300, 250, 550, 250, 550};
    int spawnTimer = 0;
    int spawnCooldown = 200;
    int minCooldown = 150;
    int maxCooldown = 1600;
    int spread = 15;
    
    World world;
    
    /**
     * Act - do whatever the Spawner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(world == null){
            world = getWorld();
            spawnCooldown = Util.random(minCooldown, maxCooldown);
        }
        //increment the timer
        spawnTimer ++;
        //if timer > cooldown 
        if (spawnTimer > spawnCooldown){
            int randNum = Util.random(0, 101);
            if(randNum > 100 - probabilities[0]){//spawn an enemy
                Enemy temp = new Enemy();
                world.addObject(temp, getX(), getY());//starts off the screen then flies towards the screen
                
            }
            else if (randNum > 100 - probabilities[1]){//health power up
                HealthPowerUp temp = new HealthPowerUp();
                world.addObject(temp, Util.random(0, world.getWidth()),
                Util.random(0, world.getHeight()) );
            }
            else{
                //spawn in asteroid at location
                    //construct the asteroid
                Asteroid temp = new Asteroid();
                world.addObject(temp, getX(), getY());
                
                //aim at the center of the world
                temp.turnTowards(world.getWidth()/2, world.getHeight()/2);
                //turn a random amount away fro the center
                temp.turn(Util.random(-spread, spread));

            }
            //get a new random cooldown
            spawnCooldown = Util.random(minCooldown, maxCooldown);
            //reset the timer
            spawnTimer = 0;            
        }
            
    }
}
