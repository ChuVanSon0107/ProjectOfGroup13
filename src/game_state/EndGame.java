package game_state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import game_world.Tile;
import main.WindowManager;
import resources.Resources;

public class EndGame extends GameState{
	
	int time;
	String story = "Rừng Nguyên Sinh";

	public EndGame(GameStateManager state) {
		super(state);
		time = 300;
	}

	@Override
	public void Loop() {
		time--;

		if(time >= 200){
			story = "Hai người trở về vương quốc, Nữ hoàng đã đồng ý cho 2 người yêu nhau";
		}

		else if(time >= 100){
			story = "Họ đã xây dựng cho mình 1 mái ấm hạnh phúc với những đứa con thơ";
		}

		else if(time > 0){
			story = "Và vương quốc Rừng Nguyên Sinh thì yên bình, ngày càng hưng thịnh";
		}


		if(time == 0){
			gameStateManager.setCurState(5);
		}
	}

	@Override
	public void Render(Graphics graphics) {

		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, WindowManager.WIDTH, WindowManager.HEIGHT);
		graphics.setColor(Color.white);
		graphics.setFont(new Font("Arial", Font.BOLD, 20));
		graphics.drawString(story, 50, WindowManager.HEIGHT/2);
		graphics.drawImage(Resources.TEXTURES.get(Resources.PRINCESS1),WindowManager.WIDTH/2-Tile.size
				,WindowManager.HEIGHT/3 , Tile.size, Tile.size, null);
		
		graphics.drawImage(Resources.TEXTURES.get(Resources.HEART),WindowManager.WIDTH/2
				,WindowManager.HEIGHT / 3 , Tile.size, Tile.size, null);
		graphics.drawImage(Resources.TEXTURES.get(Resources.PLAYER),WindowManager.WIDTH/2+Tile.size
				,WindowManager.HEIGHT / 3 , Tile.size, Tile.size, null);
	}

	@Override
	public void KeyPressed(int keyCode) {
		
	}

	@Override
	public void KeyReleased(int keyCode) {

		
	}

}
