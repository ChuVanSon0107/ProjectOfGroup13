package game_state;

import java.awt.*;
import java.awt.event.KeyEvent;

import main.WindowManager;
import resources.Resources;

public class GameOverMenu extends GameState{
	public static boolean result ;
	protected String[] gameoverMenu = {};
	private static final String WIN = "YOU WIN";
	private static final String LOSE = "YOU LOSE";
	private static final String RESTART = "RESTART";
	private static final String MAINMENU = "MAIN MENU";
	private String[] optionsMenu;
	private int selected;

	public GameOverMenu(GameStateManager gameStateManager){
		super(gameStateManager);
		this.gameoverMenu = new String[]{WIN, LOSE};
		this.optionsMenu = new String[]{RESTART, MAINMENU};
		result = false;
		this.selected = 0;
	}

	

	@Override
	public void Loop() {

		
	}

	@Override
	public void Render(Graphics graphics) {

		graphics.drawImage(Resources.TEXTURES.get(Resources.BACKGROUND),0, 0, WindowManager.WIDTH, WindowManager.HEIGHT, null);
		
		graphics.setFont(new Font("Arial", Font.BOLD, 40));
		graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON), 0, 0, 800, 200, null);
		
		graphics.setColor(Color.BLACK);
		
		if(result == true){
			graphics.drawString(this.gameoverMenu[0], 300, 120);
		}
		else{
			graphics.drawString(this.gameoverMenu[1], 300, 120);
		}

		for (int i = 0; i < this.optionsMenu.length; i++) {
			graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON_1), 0, 180 + 80 * i, 400, 80, null);
			if(i == this.selected) {
				graphics.setColor(Color.BLACK);
				graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON_1), 0, 180 + 80 * i, 500, 80, null);
			}
			else graphics.setColor(Color.WHITE);
			
			graphics.drawString(this.optionsMenu[i], 50, 235 + i * 80);
		}
		
	}

	@Override
	public void KeyPressed(int keyCode) {
		switch (keyCode){
			case KeyEvent.VK_UP:
				if(this.selected > 0) this.selected --;
				break;
			case KeyEvent.VK_DOWN:
				if(this.selected < this.optionsMenu.length - 1) this.selected ++;
				break;
			case KeyEvent.VK_ENTER:
				switch (this.optionsMenu[selected]){
					case RESTART:
						gameStateManager.setGameStates(3, new PlayingState(gameStateManager));
						gameStateManager.setCurState(3);
						break;
					case MAINMENU:
						gameStateManager.setCurState(0);
						break;
				}
				break;
		}
		}


	@Override
	public void KeyReleased(int keyCode) {

		
	}
}