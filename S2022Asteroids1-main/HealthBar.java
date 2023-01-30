import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    protected int health;
    Ship owner;
    GreenfootImage img;
    
    public HealthBar(int h){
        health = h;
        img = getImage();
        img.scale(health, img.getHeight());
    }
    
    public HealthBar(Ship s){
        this(s.maxHealth);
        owner = s;
    }
    
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //check to see if the health is too small
        if (health < 1){
            //yes then signal dead
            if (owner != null){//if the owner exists
               owner.world.removeObject(this);//use the owner world ref to remove the health bar
               owner.world.removeObject(owner);//remove the owner
                
            }
            return;    
        }
        else{
            //no set image width to heath 
            img.scale(health, img.getHeight()); 
            setLocation(10+health/2, getY());
        }
           
    }
    
    public int getHealth(){ //a helath getter method
        return health;
    }
    
    public void setHealth(int h){//a health setter method
        health = h;
        if (health > owner.maxHealth){
            health = owner.maxHealth;
        }
    }
}
