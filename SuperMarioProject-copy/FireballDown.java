import greenfoot.*;

public class FireballDown extends Actor
{
    private int speed = 4; // moves downward

    public FireballDown()
    {
        GreenfootImage img = new GreenfootImage(15, 15);
        img.setColor(Color.ORANGE);
        img.fill();
        setImage(img);
    }

    public void act()
    {
        setLocation(getX(), getY() + speed); // move downward

        // Remove if offscreen
        if (getY() > getWorld().getHeight())
        {
            getWorld().removeObject(this);
        }

        // Check collision with Mario
        Actor mario = getOneIntersectingObject(Mario.class);
        if (mario != null)
        {
            Greenfoot.stop(); // game over
        }
    }
}