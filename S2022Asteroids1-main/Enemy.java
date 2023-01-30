import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Ship
{
    private int moveCooldown = 300;//make a variable to act as a cooldown to drive towards a random point for 300 frames / 5 seconds
    private int moveTimer = 0;//make a variable to act as a timer to drive towards a random point for 5 seconds
    private double moveX = 0;//make 2 variables to store the random x and y the Enemy is driving towards
    private double moveY = 0;
    
    public Enemy(){
        img = getImage();
        healthBar = new HealthBar(this);
        speed = 3;    
        cooldown = 90;
    }
    
    public void act()
    {
        
        if (world == null){
            world = getWorld();
            getRandomLocation();
        }
        
        //increment the timer to drive at a random point
        moveTimer++;
        checkBounds();//make sure the Enemy teleports to the other side just like the ship does
        move(speed);
        if (shotTimer > cooldown){
            fire();
        }
        shotTimer++;
    }
    
    void fire(){
        EnemyBullet temp = new EnemyBullet(this);
        //look at ship shot sounds code
        world.addObject(temp, getX(), getY());
        temp.move(img.getWidth()/2);
        
        shotTimer = 0;
    }
    
    public void move(double speed){
        //check to see if we are at our move x and move y
        if(Util.distance(moveX, moveY, getExactX(), getExactY())<speed){
            //yes, get new random location
            getRandomLocation();
        }
        else{
        //else
            //turn towards moveX and moveY
            turnTowards((int)moveX, (int)moveY);
            //call super.move(speed);    
            super.move(speed);
        }
            
    }
    
    private void getRandomLocation(){
        
        //get a random moveX
        moveX = Util.random(0, world.getWidth());
        //get a random moveY
        moveY = Util.random(0, world.getHeight());
        //reset the moveTimer
        moveTimer = 0;
    }
}
