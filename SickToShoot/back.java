import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;

public class back extends Actor {
  private GreenfootImage on = new GreenfootImage("backOn.png");

  private GreenfootImage off = new GreenfootImage("backOff.png");

  private int mousex;

  private int mousey;

  private int x;

  private int y;

  public void act() {
    if (Greenfoot.mouseMoved(null)) {
      MouseInfo mouse = Greenfoot.getMouseInfo();
      int mousex = mouse.getX();
      int mousey = mouse.getY();
      int x = getX();
      int y = getY();
      if (mousex > x - 40 && mousex < x + 40 && mousey > y - 20 && mousey < y + 20) {
        setImage(this.on);
      } else {
        setImage(this.off);
      } 
    } 
    if (Greenfoot.mouseClicked(this))
      Greenfoot.setWorld(new menu()); 
  }
}