package entity;

import java.awt.Graphics;

import game_world.Vector;
import resources.Resources;

public class Princess extends Entity{
    int cntFrame = 0;
    int cntImage = 0;
    public Princess(int x,int y,int delayTime, int frameCount, int imgID, float speed) {
        super(x, y, Vector.Up, delayTime, frameCount, imgID, speed);
    }
    @Override
    public void Render(Graphics g) {
		g.drawImage(Resources.TEXTURES.get(imgID + curFrame), x, y, width + 24, height + 24, null);
	}
}
