package game_state;

import java.awt.Graphics;

import main.WindowManager;
import resources.Resources;

public class StoryMenu extends GameState {
    int timeChangeMenu = 150;

    public StoryMenu(GameStateManager state){
        super(state);
    }

    @Override
    public void Loop() {
        timeChangeMenu --;
        if(timeChangeMenu <= 0){
            gameStateManager.setGameStates(1, new PlayingState(gameStateManager));
			gameStateManager.setCurState(1);
        }
    }

    @Override
    public void Render(Graphics graphics) {
		graphics.drawImage(Resources.TEXTURES.get(Resources.STORYMENU), 0,0 , WindowManager.WIDTH, WindowManager.HEIGHT, null);
    }

    @Override
    public void KeyPressed(int keyCode) {
        
    }

    @Override
    public void KeyReleased(int keyCode) {
        
    }
    
}
