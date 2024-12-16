package game_state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import entity.Vector;
import conversation.Conversation;
import entity.Player;
import game_world.*;
import resources.Resources;

public class PlayingState extends GameState{

	private World world;
	private Player player;
	private int timeToGameOver = 50;
	boolean inConversation = false;
	Conversation conversation;

	public PlayingState(GameStateManager gameStateManager) {
		super(gameStateManager);
		player = new Player(7, 7, 2, 2, Resources.PLAYER, 1);
		world = new World(player);

		this.inConversation = true;

		String[] sentences = new String[]{
			"Các người dám bắt cóc công chúa",
			"Hôm nay ta sẽ tiêu diệt các ngươi",
			"Để xem các ngươi làm được trò trống gì",
			"Ta sẽ quét sạch các ngươi!!"
		};
		byte[] imgIDs = new byte[] {
				Resources.PLAYER,
				Resources.PLAYER,
				Resources.PLAYER,
				Resources.PLAYER
		};
		this.conversation = new Conversation(150, imgIDs, sentences);


		bossConversation = false;//add
	}


	private boolean bossConversation = false;//add


	@Override
	public void Loop() {
		if(this.inConversation == false){
			world.ChangeRoom();
			//meet my princess when defeat all of the monsters and enemies
			if(world.GetCur() == World.count - 1){	
				if(GameOverMenu.result == false){
					if(this.player.y <= 4 * Tile.size){
						this.inConversation = true;
						String[] sentences = new String[]{
							"Ta đã đến đây cứu công chúa đây",
							"Công chúa đừng sợ, có ta ở đây rồi",
							"Ta đã tiêu diệt hết tất cả bọn chúng",
							"Chúng ta hãy về nhà thôi",
							"Cảm ơn ngươi ta đến cứu ta",
							"Ta sẽ dâng nguyện yêu ngươi suốt đời",
							"Hãy đồng ý lấy ta làm chồng nhá <3 <3",
							"Dạ, ta đồng ý"
						};

						byte[] imgIDs = new byte[] {
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PRINCESS1,
							Resources.PRINCESS1,
							Resources.PLAYER,
							Resources.PRINCESS1
						};

						this.conversation = new Conversation(150, imgIDs, sentences);
						GameOverMenu.result = true;
					}
				}
				else{
					gameStateManager.setGameStates(6, new EndGame(gameStateManager));
					gameStateManager.setCurState(6);
				}
			}

			//ADD
			else if(world.GetCur() == World.count - 2 && bossConversation == false){
				this.inConversation = true;
				this.inConversation = true;
				String[] sentences = new String[]{
					"Hiệp sĩ ơi, cíu taaaaaaaaaa!!!!!!!",
					"Với sức mạnh đó cũng đòi đánh bọn ta sao",
					"Ngươi nghĩ ta không chuẩn bị gì sao",
					"Thứ vũ khí dùng để khắc chế các ngươi"
				};

				byte[] imgIDs = new byte[] {
					Resources.PRINCESS1,
					Resources.BOSS,
					Resources.PLAYER,
					Resources.PLAYER
				};

				this.conversation = new Conversation(150, imgIDs, sentences);
				bossConversation = true;
			}

			//ADD
if(player.getHp() > 0) {
				Room room = world.GetCurrentRoom();
				room.Loop();
				player.OnLoop();
			}
			else {
				timeToGameOver--;
				if(timeToGameOver == 0) {
					GameOverMenu.result = false;
					gameStateManager.setCurState(5);
				}
			}
		}



		else{
			if(conversation != null) {
				conversation.OnLoop();
				if(conversation.GetState() == 3) this.inConversation = false;
			}
		}
	}

	@Override
	public void Render(Graphics g) {
		world.GetCurrentRoom().Render(g);
		
		//HARD LEVEL
		if(MainMenu.getLevel() == 2){
			g.drawImage(Resources.TEXTURES.get(Resources.DARK),(int)player.getCenterX() - 1000, 
				(int)player.getCenterY() - 1000, 2000, 2000, null);
		}

		player.Render(g);
		
		if(this.inConversation) {
			if(conversation != null) conversation.Display(g);
		}

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawImage(Resources.TEXTURES.get(Resources.HEART), 10, 0, Tile.size * 2/5, Tile.size * 2/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.MANA), 10, 25, Tile.size * 2/5, Tile.size*2/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ARMOR), 10, 50, Tile.size * 2/5, Tile.size*2/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ULTI), 10, 75, Tile.size * 2/5, Tile.size*2/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.HEARTB), 40, 5, player.getHp() * 5, Tile.size*1/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.MANAB), 40, 30, player.getMp() * 5, Tile.size*1/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ARMORB), 40, 55, player.getDef() * 5, Tile.size*1/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ULTIB), 40, 80, player.getRTime()/5, Tile.size*1/5, null);
		g.drawImage(Resources.TEXTURES.get(Resources.ULTIB), 40, 80, player.getETime()/5, Tile.size*1/5, null);
	}

	@Override
	public void KeyPressed(int keyCode) {

		switch(keyCode) {
		
		case KeyEvent.VK_DOWN:
			if(this.inConversation == false) {
				player.SetMove(true);
				player.SetFacing(Vector.Down);
			}
			break;
		case KeyEvent.VK_LEFT:
			if(this.inConversation == false) {
				player.SetMove(true);
				player.SetFacing(Vector.Left);
			}
			break;
		case KeyEvent.VK_RIGHT: 
			if(this.inConversation == false) {
				player.SetMove(true);
				player.SetFacing(Vector.Right);
			}
			break;
		case KeyEvent.VK_UP:
			if(this.inConversation == false) {
				player.SetMove(true);
				player.SetFacing(Vector.Up);
			}
			break;
		case KeyEvent.VK_Q: 
			if(this.inConversation == false) {
				player.AttackQ();
			}
			break;
		case KeyEvent.VK_R:
			if(this.inConversation == false) {
				player.AttackR();
			}
			break;
		case KeyEvent.VK_E:
			if(this.inConversation == false) {
				player.AttackE();
			}
			break;
		case KeyEvent.VK_P:	
			gameStateManager.setCurState(4);
			break;
		case KeyEvent.VK_ENTER:
			if(this.inConversation == true) {
				if(conversation != null) conversation.ChangeSentence();
			}
			break;
		}
		
	}

	@Override
	public void KeyReleased(int keyCode) {
		switch(keyCode) {
		case KeyEvent.VK_UP:
			player.SetMove(false);
			break;
		case KeyEvent.VK_DOWN:
player.SetMove(false);
			break;
		case KeyEvent.VK_LEFT:
			player.SetMove(false);
			break;
		case KeyEvent.VK_RIGHT:
			player.SetMove(false);
			break;
		}
	}

}