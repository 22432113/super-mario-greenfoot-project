import greenfoot.*;

public class Mario extends Actor
{
    private int ySpeed = 0;        // current vertical speed
    private int jumpStrength = -10; // negative = up
    private int gravity = 1;       // pulls Mario down
    private boolean onGround = false;

    public Mario()
    {
        GreenfootImage img = new GreenfootImage(20, 30);
        img.setColor(Color.RED);
        img.fill();
        setImage(img);
    }

    public void act()
    {
        moveLeftRight();
        applyGravity();
        jump();
    }

    private void moveLeftRight()
    {
        if (Greenfoot.isKeyDown("left")) setLocation(getX() - 3, getY());
        if (Greenfoot.isKeyDown("right")) setLocation(getX() + 3, getY());
    }

    private void jump()
    {
        if (Greenfoot.isKeyDown("space") && onGround)
        {
            ySpeed = jumpStrength; // start moving up
            onGround = false;
        }
    }

    private void applyGravity()
    {
        // Move vertically
        setLocation(getX(), getY() + ySpeed);

        // Apply gravity
        ySpeed += gravity;

        // Check for collision with ground
        Actor ground = getOneIntersectingObject(Ground.class);
        if (ground != null)
        {
            // Place Mario on top of ground
            setLocation(getX(), ground.getY() - ground.getImage().getHeight()/2 - getImage().getHeight()/2);
            ySpeed = 0;
            onGround = true;
        }
    }
}