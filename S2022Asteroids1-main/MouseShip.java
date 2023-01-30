import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MouseShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MouseShip extends Ship
{
    MouseInfo mouse;
    
    public MouseShip(){
        super();
        //cooldown = 10;
    }
    
    public void act(){
        super.act();
        mouse = Greenfoot.getMouseInfo();
        if (mouse != null){
            if(mouse.getButton() == 1 && shotTimer > cooldown){
                mousefire();
            }
        }
    }
    
    void mousefire(){
            Bullet temp = new Bullet(this);

            world.addObject(temp, getX(), getY());
            temp.turnTowards(mouse.getX(), mouse.getY());
            shotTimer = 0;
    }
}
