import greenfoot.World;
import greenfoot.GreenfootSound;

public class menu extends World {
    public GreenfootSound sound;
    private playOff playoff;
    private control control;
    private developers developers;
    private World dev, controls;
    
    public menu() {
        super(1000, 600, 1);
        this.dev = new dev(this);
        this.controls = new controls(this);
        this.sound = new GreenfootSound("menu.wav");
        this.sound.setVolume(15);
        this.playoff = new playOff();
        this.control = new control(new controls(this));
        this.developers = new developers(new dev(this));
        prepare();
    }

    private void prepare() {
        this.sound.playLoop();
        addObject(playoff, 670, 220);
        addObject(control, 707, 270);
        addObject(developers, 723, 320);
    }
}