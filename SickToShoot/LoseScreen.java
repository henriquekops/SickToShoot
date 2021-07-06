import greenfoot.*;

public class LoseScreen extends World
{
    private GreenfootSound sound;
    private Text scoreText;
    private exit exit;
    
    public LoseScreen()
    {    
        super(1000, 600, 1);
        this.sound = new GreenfootSound("pDead.wav");
        this.sound.setVolume(70);
        this.scoreText = new Text();
        addObject(this.scoreText, 500, 300);
    }
    
    public void trigger(int currentScore, int bestScore) {
        GreenfootImage bestScoreImg = this.scoreText.createText("Best score: " + bestScore, 35);
        GreenfootImage currentScoreImg = this.scoreText.createText("Current Score: " + currentScore, 45);
        this.scoreText.addTitleText(currentScoreImg, 500, 430);
        this.scoreText.addTitleText(bestScoreImg, 500, 465);
        this.scoreText.draw();
        this.exit = new exit();
        addObject(this.exit, 80, 50);
        sound.play();
    }
}
