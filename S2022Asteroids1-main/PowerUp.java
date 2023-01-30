import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerUp extends Actor
{
    protected Ship player;
    
    public void act(){
        //detect touching aplayer ship
        detectTouching();
        
        if(player!= null){
        //apply an effect on that ship
            applyEffect(player);
        //remove yourself
            getWorld().removeObject(this);
        }
        
    }
    
    protected void applyEffect(Ship p){
        //left deliberately blank.  Meant to be overridden
        System.out.println("OVERRIDE THIS");
    }
    
    protected void detectTouching(){
        player = (Ship)getOneIntersectingObject(Ship.class);
        if (player instanceof Enemy){
            player = null;
        }
    }
    
    
}
