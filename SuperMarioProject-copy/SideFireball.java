import greenfoot.*;

public class SideFireball extends Actor
{
    private int speed; // speed and direction of the fireball

    public SideFireball(boolean fromLeft)
    {
        // Orange circle for fireball
        GreenfootImage img = new GreenfootImage(15, 15);
        img.setColor(Color.ORANGE);
        img.fill();
        setImage(img);

        // Set speed direction: positive = right, negative = left
        speed = fromLeft ? 4 : -4;
    }

    public void act()
    {
        setLocation(getX() + speed, getY());

        // Remove if offscreen
        if (getX() < 0 || getX() > getWorld().getWidth())
        {
            getWorld().removeObject(this);
        }

        // Collision with Mario = Game Over
        Actor mario = getOneIntersectingObject(Mario.class);
        if (mario != null)
        {
            Greenfoot.stop();
        }
    }
}