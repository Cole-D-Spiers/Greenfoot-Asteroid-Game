import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    int speed = 15;
    protected int damage = 50;
    Ship ship;
    World world;
    
    public Bullet(Ship s){
        ship = s;
        setRotation(ship.getRotation());
        
    }
    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
         if (world == null){
            world = getWorld(); 
         }
         move(speed);   
         //remove the bullet from teh world if it leaves the screen
         if (getX()>world.getWidth()||getX()<0){
             world.removeObject(this);
             return;
             //System.out.println("I removed myself!");
         }
         else if (getY()>world.getHeight()||getY()<0){
             //System.out.println("WTF");
             world.removeObject(this);
             return;
         }
         
         Ship victim = (Ship)getOneIntersectingObject(Ship.class);
         //prevent hitting shooter
         if(victim == ship){
             victim = null;
         }
             
         inflictDamage(victim);

    }
    
    protected void inflictDamage(Ship v){
        if(v == null){return;}//guard statement preventing a null pointer exception
        world.addObject(new Explosion(v), v.getX(), v.getY());
        world.removeObject(v);
        world.removeObject(this);
    }
}
