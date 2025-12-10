import greenfoot.*;

public class Level1World extends World
{
    private int fireballTimer = 0;

    public Level1World()
    {    
        super(600, 400, 1);

        int tileSize = 50;

        // Ground row
        for (int i = 0; i < 12; i++)
        {
            addObject(new Ground(), i * tileSize + tileSize/2, 380);
        }

        // Mario
        addObject(new Mario(), 100, 350);

        // Boss higher up
        addObject(new Boss(), 500, 150);
    }

    public void act()
    {
        fireballTimer++;

        // Spawn a side fireball every 150 acts
        if (fireballTimer % 150 == 0)
        {
            // Fireball from left
            addObject(new SideFireball(true), 0, 355); // slightly above ground
            // Fireball from right
            addObject(new SideFireball(false), getWidth(), 355);
        }
    }
}