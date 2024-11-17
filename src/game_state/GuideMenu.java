package game_state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import main.WindowManager;
import resources.Resources;

public class GuideMenu  extends GameState {

    public GuideMenu(GameStateManager state){
        super(state);
    }

    @Override
    public void Loop() {

    }

    @Override
    public void Render(Graphics graphics) {
		graphics.drawImage(Resources.TEXTURES.get(Resources.GUIDEMENU), 0,0 , WindowManager.WIDTH, WindowManager.HEIGHT, null);
    }

    @Override
    public void KeyPressed(int keyCode) {
        if(keyCode == KeyEvent.VK_ENTER){
            gameStateManager.setGameStates(3, new PlayingState(gameStateManager));
            gameStateManager.setCurState(3);
        }
    }

    @Override
    public void KeyReleased(int keyCode) {
        
    }
    
}