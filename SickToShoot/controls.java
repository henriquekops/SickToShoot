import greenfoot.World;

public class controls extends World {
  public controls() {
    super(1000, 600, 1);
    back back = new back();
    addObject(back, 45, 30);
  }
}