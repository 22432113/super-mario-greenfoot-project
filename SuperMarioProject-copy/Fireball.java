import greenfoot.*;

public class Fireball extends Actor
{
    private int speed;

    public Fireball(int dir)
    {
        speed = 4 * dir; // moves in the direction of the boss
        GreenfootImage img = new GreenfootImage(15, 15);
        img.setColor(Color.ORANGE);
        img.fill();
        setImage(img);
    }

    public void act()
    {
        setLocation(getX() + speed, getY());

        // Remove if offscreen
        if (getX() < 0 || getX() > getWorld().getWidth())
        {
            getWorld().removeObject(this);
        }

        // Optional: check for collision with Mario
        Actor mario = getOneIntersectingObject(Mario.class);
        if (mario != null)
        {
            Greenfoot.stop(); // stop the game if hit
        }
    }
}