import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.MouseInfo;
import greenfoot.World;

class control extends Actor {
  private GreenfootImage on = new GreenfootImage("controlOn.png");
  private GreenfootImage off = new GreenfootImage("controlOff.png");
  private World w;
  private int mousex;
  private int mousey;
  private int x;
  private int y;
  
  public control (World w) {
      this.w = w;
  }

  public void act() {
    if (Greenfoot.mouseMoved(null)) {
      MouseInfo mouse = Greenfoot.getMouseInfo();
      int mousex = mouse.getX();
      int mousey = mouse.getY();
      int x = getX();
      int y = getY();
      if (mousex > x - 70 && mousex < x + 70 && mousey > y - 20 && mousey < y + 20) {
        setImage(this.on);
      } else {
        setImage(this.off);
      } 
    } 
    if (Greenfoot.mouseClicked(this))
      Greenfoot.setWorld(w); 
  }
}