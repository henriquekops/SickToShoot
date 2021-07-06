import greenfoot.World;

public class controls extends World {
  private World w;
  public controls(World w) {
    super(1000, 600, 1);
    this.w = w;
    back back = new back(w);
    addObject(back, 45, 30);
  }
}