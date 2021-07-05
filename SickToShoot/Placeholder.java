import greenfoot.*;

public class Placeholder extends Actor
{
        public Placeholder() {
            GreenfootImage img = getImage();
            img.scale(img.getWidth()-350, img.getHeight()-200);
            img.setTransparency(90);
            setImage(img);
        }
}
