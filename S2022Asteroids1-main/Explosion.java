import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Explosion class plays the frames of animation for an explosion and removes itself
 * when completed.
 * 
 * @author Nathan Rowbottom 
 * @version Mar 1 2022
 */
public class Explosion extends Actor
{
    static private GifImage templateGif = new GifImage("explosion.gif");//template 
    GifImage gifImg;
    int width;
    int height;
    
    boolean done = false;//lets us know the animation is complete
    
    public Explosion(Actor a){ 
      gifImg = new GifImage(templateGif);
        
      width = a.getImage().getWidth()*2;
      height = a.getImage().getHeight()*2;
            setImage(gifImg);
    }
    
    
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(gifImg.getCurrentImage() != gifImg.getLastImage()){
            //set the image to the gif current image
            setImage(gifImg);     
        }
        else{
            //remove the explosion from the world
            getWorld().removeObject(this);
        }
    }
    
    private void setImage(GifImage g){
        //set the image to the gif current image
        setImage(g.getCurrentImage());
        //scale it to the sze of the owner
        getImage().scale(width,height);
    }
    
}
