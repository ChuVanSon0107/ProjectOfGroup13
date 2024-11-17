package game_state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game_world.Tile;
import main.WindowManager;
import resources.Resources;

public class DaoLyMenu extends GameState{

	int time;
	String daoly = "Chiến tranh sẽ chỉ sinh ra chiến tranh";
	protected DaoLyMenu(GameStateManager state) {
		super(state);
		time = 300;
	}

	@Override
	public void Loop() {

		time--;
		if(time >= 200)daoly = "Chiến tranh sẽ chỉ sinh ra chiến tranh";
		else if(time >= 100) daoly = "Thù hận sẽ chỉ sinh ra thù hận";
		else daoly = "Hãy kết thúc mọi thứ trong hòa bình";
		if(time == 0)
			gameStateManager.setCurState(0);
	}

	@Override
	public void Render(Graphics graphics) {

		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial", Font.BOLD, 20));
		graphics.drawString(daoly, 250, WindowManager.HEIGHT/2);
		graphics.drawImage(Resources.TEXTURES.get(Resources.PLAYER_RIGHT),WindowManager.WIDTH/2-Tile.size
				,WindowManager.HEIGHT/3 , Tile.size, Tile.size, null);
		
		graphics.drawImage(Resources.TEXTURES.get(Resources.HEART),WindowManager.WIDTH/2
				,WindowManager.HEIGHT/3 , Tile.size, Tile.size, null);
		graphics.drawImage(Resources.TEXTURES.get(Resources.AD),WindowManager.WIDTH/2+Tile.size
				,WindowManager.HEIGHT/3 , Tile.size, Tile.size, null);
	}

	@Override
	public void KeyPressed(int keyCode) {

	}

	@Override
	public void KeyReleased(int keyCode) {

	}

}