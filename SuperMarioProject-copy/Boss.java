import greenfoot.*;

public class Boss extends Actor
{
    private int speed = 2;      // horizontal movement speed
    private int direction = 1;  // 1 = right, -1 = left
    private int fireDelay = 0;  // cooldown for shooting fireballs

    public Boss()
    {
        // Simple dark gray rectangle for boss
        GreenfootImage img = new GreenfootImage(50, 50);
        img.setColor(Color.DARK_GRAY);
        img.fill();
        setImage(img);
    }

    public void act()
    {
        moveSideToSide();
        shootFireballsDown();
    }

    private void moveSideToSide()
    {
        setLocation(getX() + speed * direction, getY());

        // Change direction at edges
        if (getX() < 50 || getX() > getWorld().getWidth() - 50)
        {
            direction *= -1;
        }
    }

    private void shootFireballsDown()
    {
        fireDelay++;
        if (fireDelay > 100) // fire every 100 acts
        {
            getWorld().addObject(new FireballDown(), getX(), getY());
            fireDelay = 0;
        }
    }
}
