package game_state;

import java.awt.Graphics;

import main.WindowManager;
import resources.Resources;

public class GuideMenu  extends GameState {

    int timeChangeMenu = 150;

    public GuideMenu(GameStateManager state){
        super(state);
    }

    @Override
    public void Loop() {
        timeChangeMenu --;
        if(timeChangeMenu <= 0){
            gameStateManager.setGameStates(7, new StoryMenu(gameStateManager));
			gameStateManager.setCurState(7);
        }
    }

    @Override
    public void Render(Graphics graphics) {
		graphics.drawImage(Resources.TEXTURES.get(Resources.GUIDEMENU), 0,0 , WindowManager.WIDTH, WindowManager.HEIGHT, null);
    }

    @Override
    public void KeyPressed(int keyCode) {
        
    }

    @Override
    public void KeyReleased(int keyCode) {
        
    }
    
}
