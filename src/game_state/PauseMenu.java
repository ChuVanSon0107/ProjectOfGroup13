package game_state;

import main.WindowManager;
import resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;


public class PauseMenu extends GameState{

	private static final String CONTINUE_GAME = "CONTINUE";
	private static final String QUIT_GAME = "QUIT";
	private static final String LABEL = "PAUSE";
	private String[] optionsMenu = {};
	private int selected;

	public PauseMenu(GameStateManager gameStateManager){
		super(gameStateManager);
		this.optionsMenu = new String[]{ CONTINUE_GAME, QUIT_GAME};
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
		graphics.drawString(LABEL, 340, 120);
		
		for (int i = 0; i < this.optionsMenu.length; i++) {
			graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON_1), 0, 180 + 80 * i, 400, 80, null);
			if(i == this.selected) {
				graphics.setColor(Color.BLACK);
				graphics.drawImage(Resources.TEXTURES.get(Resources.BUTTON_1), 0, 180 + 80 * i, 500, 80, null);
			}
			else graphics.setColor(Color.WHITE);
			
			graphics.drawString(this.optionsMenu[i], 10, 235 + i * 80);
		}
	}
	@Override
	public void KeyPressed(int keyCode) {

		switch (keyCode) {
			case KeyEvent.VK_UP:
				if(this.selected > 0) this.selected --;
				break;
			case KeyEvent.VK_DOWN:
				if(this.selected < this.optionsMenu.length - 1) this.selected ++;
				break;
			case KeyEvent.VK_ENTER:
				switch (this.optionsMenu[selected]){
					case CONTINUE_GAME:
						gameStateManager.setCurState(3);
						System.out.print("Continue\n");
						break;
					case QUIT_GAME:
						gameStateManager.setCurState(0);
						System.out.print("BackToMenu");
						break;
				}
				break;
		}
	}

	@Override
	public void KeyReleased(int keyCode) {
		
		
	}
}
