import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends SmoothMover
{
    int size;
    int minSize = 20; 
    int maxSize = 150;
    double speed = 0;
    double minSpeed = 2;
    double maxSpeed = 8;
    
    GreenfootImage img;
    Game game;
    
    public Asteroid(){
        //get a random size 
        size = Util.random(5*minSize, maxSize);
        //set the image to the size
        img = getImage();
        img.scale(size, size);
        //get a random direction
        turn(Util.random(-180, 181));
        //get random speed
        speed = Util.random(minSpeed, maxSpeed);
    }
    
    public Asteroid (int s){
        size = s;
        img = getImage();
        img.scale(size, size);
        speed = Util.random(minSpeed, maxSpeed);
    }
    
    /**
     * Act - do whatever the Asteroid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (game == null){
            game = (Game)getWorld();
        }
        
        //move
        move(speed);
        //check  to see if hitting a bullet
            //yes ==> then spawn kids
        //check bounds
        //if outside 
        if (getX()> game.getWidth()+500||getX() < -500||getY()> game.getHeight()+500||getY() < -500){
            //yes ==>remove from world
            game.removeObject(this);
            return;
        }
      
        Actor temp = getOneIntersectingObject(Bullet.class);
        if (temp != null) {
            //spawn in some smaller asteroids
            int numKids = Util.random(2, 5);//this will spawn 2 to 4 kids of equal size
            int newSize = size/numKids;
            if (newSize <= minSize){
                return;
            }
            //for each one
            for (int i = 0; i < numKids;i++){
                Asteroid kid = new Asteroid(newSize);//make the child asteroid
                game.addObject(kid, getX(), getY());//add it to the world
                
                //turn the child towards the bullet
                kid.turnTowards(temp.getX(), temp.getY());
                //turn 180
                kid.turn(180+Util.random(-90 , 90));
                //move them half their size so they don't intersect with each other
                kid.move(kid.speed);
            }
            //add explosion
            game.addObject(new Explosion(temp), temp.getX(), temp.getY());
            //remove the bullet    
            game.removeObject(temp);
            //remove yourself
            game.removeObject(this);
                
        }
                
    }
    
    void collide(){
        
    }
    
    void split(){
       
    }
    
}
