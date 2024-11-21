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
    public void Render(Graphics g) {
        if(cntFrame > delayTime){cntFrame = 0;}
        if(cntFrame > 0 && cntFrame <= delayTime/2){cntImage = 0;}
        if(cntFrame > delayTime/2 && cntFrame <= delayTime){cntImage = 1;}
		g.drawImage(Resources.TEXTURES.get(imgID + cntImage), x, y, width + 12, height + 12, null);
        cntFrame++;
	}
}
