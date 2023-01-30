import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShotgunShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShotgunShip extends Ship
{
    int spread = 10;
    int numBullets = 6;
    GreenfootSound [] shots;
    public ShotgunShip(){
        super();
        shots = new GreenfootSound[numBullets];
        for (int i = 0; i < numBullets; i++){
           shots[i] = new GreenfootSound("click.mp3");  
        }
        cooldown = 50;
    }
    
    void fire(){
        for(int i = 0; i < numBullets;i++){
            Bullet temp = new Bullet(this);
            temp.turn(Util.random(-spread, spread+1));
            world.addObject(temp, getX(), getY());
            if(!shots[i].isPlaying()){
             shots[i].play();
            }
            else{
              shots[i].stop();
              shots[i].play();
            }
        }
        shotTimer = 0;
    }
}
