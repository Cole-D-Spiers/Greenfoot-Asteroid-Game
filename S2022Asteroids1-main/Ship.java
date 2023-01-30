import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends SmoothMover
{
    double speed = 0; //current speed
    int maxSpeed = 10;
    double thrust = 0.5;
    int turnSpeed = 4;
    int cooldown = 20;//this is for shooting
    int shotTimer = 0;
    
    World world;
    GreenfootImage img;
    HealthBar healthBar;
    
    int maxHealth = 600;
    
    GreenfootSound shot;
    
    public Ship(){
        img = getImage();
        shot = new GreenfootSound("laser.mp3");
        healthBar = new HealthBar(this);
    }
    
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (world == null){
            world = getWorld();
            world.addObject(healthBar, 310, 40);
        }
        checkKeys();
        checkBounds();
        move(speed);
        Asteroid temp = (Asteroid)getOneIntersectingObject(Asteroid.class);
        if (temp != null){
            healthBar.setHealth(healthBar.getHealth() - temp.size);
            world.removeObject(temp);
        }
        
        shotTimer++;
    }

    void checkBounds(){
        //if the x is too big then put on other side
        if (getExactX()>world.getWidth()+img.getWidth()/2){
            setLocation(-img.getWidth()/2, getExactY());
        }
        //if x is too small put it at the width
        if (getExactX()< -img.getWidth()/2){
            setLocation(world.getWidth()+img.getWidth()/2, getExactY());
        }
        if (getExactY()>world.getHeight()+img.getHeight()/2){
            setLocation(getExactX(), -img.getHeight()/2);
        }
        if (getExactY()< -img.getHeight()/2){
            setLocation(getExactX()+img.getHeight()/2, world.getHeight());
        }
    }
    
    void checkKeys(){
        //speeding up
        if (Greenfoot.isKeyDown("w")&& speed < maxSpeed){
           speed += thrust; 
        }
        //slowing down
        if (Greenfoot.isKeyDown("s")&&speed > 0){
           speed -= 0.5*thrust; 
        }
        //turning left and right
        if (Greenfoot.isKeyDown("a")){
            turn(-turnSpeed);
        }
        if (Greenfoot.isKeyDown("d")){
            turn(turnSpeed);
        }
        if (Greenfoot.isKeyDown("space")&& shotTimer > cooldown){
            
            fire();
        }
        
    }
    
    void fire(){
        Bullet temp = new Bullet(this);
        if(!shot.isPlaying()){
         shot.play();
        }
        else{
          shot.stop();
          shot.play();
        }
        world.addObject(temp, getX(), getY());
        temp.move(img.getWidth()/2);
        
        shotTimer = 0;
    }
}
