import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    private Game game;
    Label titleLabel;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        
        super(1200, 800, 1); 
        titleLabel = new Label("Asteroids!", 80);
        addObject(titleLabel, getWidth()/2, getHeight()/2);
        
        addObject(new Label("Click Anywhere to Continue", 40),getWidth()/2, (int)(getHeight()*0.7));
    }
    
    public void act(){
        if(Greenfoot.mouseClicked(this)){
           Greenfoot.setWorld(game); 
        }
    
    }
    
    
    public void setGame(Game g){
        this.game = g;
    }
}
