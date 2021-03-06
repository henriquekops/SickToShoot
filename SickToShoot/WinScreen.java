import greenfoot.*;

public class WinScreen extends World
{
    private Text scoreText;
    private GreenfootSound sound;
    private exit exit;
    
    public WinScreen()
    {
        super(1000, 600, 1);
        this.sound = new GreenfootSound("winner.wav");
        this.sound.setVolume(50);
        this.scoreText = new Text();
        addObject(this.scoreText, 500, 300);
    }
    
    public void trigger(int currentScore, int bestScore) {
        GreenfootImage currentScoreImg = this.scoreText.createText("Last best score: " + bestScore, 35);
        GreenfootImage bestScoreImg = this.scoreText.createText("Current best score: " + currentScore, 45);
        this.scoreText.addTitleText(currentScoreImg, 500, 430);
        this.scoreText.addTitleText(bestScoreImg, 500, 465);
        this.scoreText.draw();
        this.exit = new exit();
        addObject(this.exit, 80, 50);
        this.sound.play();
    }
}
