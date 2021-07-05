import greenfoot.World;

public class dev extends World {
  public dev() {
    super(1000, 600, 1);
    back back = new back();
    addObject(back, 45, 30);
  }
}