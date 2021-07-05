import greenfoot.*;
import java.util.HashMap;

public class Text extends Actor
{
    private Color color;
    private GreenfootImage space;
    
    public Text() {
        this.color = new Color(240, 231, 231);
        this.space = new GreenfootImage(1000, 600);
    }
    
    public void draw() {
        setImage(this.space);
    }

    public void clear() {
        this.space.clear();
    }
    
    public GreenfootImage createText(String text, int size) {
        return new GreenfootImage(text, size, color, null);
    }
    
    public void addText(GreenfootImage image, int x, int y) {
        this.space.drawImage(image, x, y-(image.getHeight()/2));
    }
    
    public void addTitleText(GreenfootImage image, int x, int y) {
        this.space.drawImage(image, x-(image.getWidth()/2), y-(image.getHeight()/2));
    }
}