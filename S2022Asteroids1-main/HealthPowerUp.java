     import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthPowerUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthPowerUp extends PowerUp
{
    private int health = 100;//how much health to give
    
    protected void applyEffect(Ship p){
        p.healthBar.setHealth(p.healthBar.getHealth()+health);
    }
}
