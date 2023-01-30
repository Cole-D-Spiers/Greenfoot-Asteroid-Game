import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class EnemyBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyBullet extends Bullet
{
    Enemy owner;
    //a range variable which sets how far the enemy can "see"
    int range = 400;
    List<Actor> targets;
    //targetX, targetY variables to aim us in the right direction;
    int targetX = -2000;
    int targetY = -2000;
    
    public EnemyBullet(Ship enemy){
        super(enemy);
        speed = 8;
        owner = (Enemy)enemy;//store the enemy owner cast as an Enemy type object
    }
    
    /**
     * Act - do whatever the EnemyBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        if(getWorld() == null){
            return;
        }
        //if we don't ahve a target, get one
        if(targetX == -2000){
            targets = getObjectsInRange(range, Actor.class);//This gets EVERYTHING (bullets and such)
            //check to see if the list is empty
            if (targets.size()<=1){
                //yes aim at center
                targetX = world.getWidth()/2;
                targetY = world.getHeight()/2;
                turnTowards(targetY, targetX);
                return;
            }
            //go through all the targets
            for (Actor a : targets){
                //if a target is an instance of a ship or asteroid
               if ((a instanceof Ship && !(a instanceof Enemy))
                       ||(a instanceof Asteroid)){
                   //is the distance to that closer than targetX and targetY
                   double targetDistance = Util.distance(getX(), getY(), targetX, targetY);
                   double aDistance = Util.distance(getX(), getY(), a.getX(), a.getY());
                   if(aDistance < targetDistance){
                       //if so set target X and targetY to the target position
                       targetX = a.getX();
                       targetY = a.getY();
                   }
               }
            }
            
            //turn towards the target
            turnTowards(targetX, targetY);        

        }
        
    }
    
    protected void inflictDamage(Ship v){
        if(v == null){return;}//guard statement preventing a null pointer exception
        v.healthBar.setHealth(v.healthBar.getHealth()-damage);
        world.removeObject(this);
    }
    
}
