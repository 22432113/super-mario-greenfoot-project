import greenfoot.*;  

public class Ground extends Actor
{
    public Ground()
    {
        GreenfootImage img = new GreenfootImage(50, 30);
        img.setColor(Color.GREEN);
        img.fill();
        setImage(img);
    }
}
