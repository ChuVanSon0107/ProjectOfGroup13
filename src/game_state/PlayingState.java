// package game_state;

// import java.awt.Color;
// import java.awt.Font;
// import java.awt.Graphics;
// import java.awt.event.KeyEvent;

// import conversation.Conversation;
// import entity.Player;
// import game_world.*;
// import main.WindowManager;
// import resources.Resources;

// public class PlayingState extends GameState{

// 	private World world;
// 	private Player player;
// 	private int timeToGameOver = 50;
// 	boolean p = true;
// 	boolean inConversation = false;
// 	Conversation conversation;

// 	public PlayingState(GameStateManager gameStateManager) {
// 		super(gameStateManager);
// 		player = new Player(7, 7, 2, 2, Resources.PLAYER, 1);
// 		world = new World(player);
// 		p = true;

// 		if(gameStateManager.blood_fall > 0) {
// 			this.inConversation = true;
// 			String[] sentences = new String[]{
// 				"Chuyện gì vừa xảy ra vậy ???",
// 				"Sao mình lại về chỗ này ???"
// 			};
// 			byte[] imgIDs = new byte[] {
// 				Resources.PLAYER,
// 				Resources.PLAYER
// 			};
// 			this.conversation = new Conversation(150, imgIDs, sentences);
// 		}
// 		else {
// 			this.inConversation = true;
// 			String[] sentences = new String[]{
// 				"Ta đã từng nương tay cho các ngươi một con đường sống",
// 				"Nhưng các ngươi không biết trân trọng cơ hội khiến hôm nay ta phải diệt cỏ tận gốc",
// 				"Pháp sư song hệ tiêu diệt hết phe Hắc ám và cứu được con gái mình trả lại bình yên cho Hành tinh Closeup mãi mãi về sau."
// 			};
// 			byte[] imgIDs = new byte[] {
// 					Resources.PLAYER,
// 					Resources.PLAYER,
// 					Resources.PLAYER
// 			};
// 			this.conversation = new Conversation(150, imgIDs, sentences);
// 		}
// 	}
// 	@Override
// 	public void Loop() {

// 		if(!inConversation) {

// 			world.ChangeRoom();

// 			if(world.GetCur() == World.count - 1) {
// 				if(p) {
// 					if(!GameOverMenu.result) {
// 						gameStateManager.blood_fall = 0;
						
// 						if(player.x <= Tile.size * 4) {
// 							this.inConversation = true;
// 							String[] sentences = new String[]{
// 								"Sao ngươi không tấn công bọn ta",
// 								"Tôi không muốn ai phải đổ máu nữa",
// 								"Cuộc chiến này quá phi nghĩa",
// 								"Chúng ta làm hòa nhé",
// 								"Hi hi, mình đồng ý",
// 								"Mãi bên nhau bạn nhé <3"
// 							};
// 							byte[] imgIDs = new byte[] {
// 								Resources.AD,
// 								Resources.PLAYER,
// 								Resources.PLAYER,
// 								Resources.PLAYER,
// 								Resources.AD,
// 								Resources.AD
// 							};
// 							this.conversation = new Conversation(150, imgIDs, sentences);
// 							GameOverMenu.result = true;
// 						}
// 					}
// 					else {
// 						gameStateManager.setCurState(6);
// 					}
// 				}
// 				else {
// 					gameStateManager.blood_fall ++;
// 					gameStateManager.setGameStates(3, new PlayingState(gameStateManager));
// 					gameStateManager.setCurState(3);
// 					return;
// 				}
// 			}
// 			if(player.getHp() > 0) {
// 				Room room = world.GetCurrentRoom();
// 				room.Loop();
// 				player.OnLoop();
// 			}
// 			else {
// 				timeToGameOver--;
// 				if(timeToGameOver == 0) {
// 					GameOverMenu.result = false;
// 					gameStateManager.blood_fall = 0;
// 					gameStateManager.setCurState(5);
// 				}
// 			}
// 		}
// 		else {
// 			if(conversation != null) {
// 				conversation.OnLoop();
// 				if(conversation.GetState() == 3) this.inConversation = false;
// 			}
// 		}
// 	}

// 	@Override
// 	public void Render(Graphics g) {
// 		world.GetCurrentRoom().Render(g);
		
// 		if(MainMenu.getLevel() == 2){
// 			g.drawImage(Resources.TEXTURES.get(Resources.DARK),(int)player.getCenterX() - 1000, 
// 				(int)player.getCenterY() - 1000, 2000, 2000, null);
// 		}

// 		player.Render(g);

// 		if(gameStateManager.blood_fall > 0 && world.GetCur() < World.count - 1) {
// 			if(gameStateManager.blood_fall <= 5){
// 				g.drawImage(Resources.TEXTURES.get(Resources.BLOOD_FALL), 0,
// 				gameStateManager.blood_fall * 60 - 300 , WindowManager.WIDTH, WindowManager.HEIGHT, null);
// 			}
// 			else {
// 				g.drawImage(Resources.TEXTURES.get(Resources.BLOOD_FALL), 0, 0 , WindowManager.WIDTH, WindowManager.HEIGHT, null);
// 			}
// 		}
		
// 		if(this.inConversation) {
// 			if(conversation != null) conversation.Display(g);
// 		}

// 		g.setColor(Color.WHITE);
// 		g.setFont(new Font("arial", Font.PLAIN, 15));
// 		g.drawImage(Resources.TEXTURES.get(Resources.HEART), 10, 0, Tile.size * 2/5, Tile.size * 2/5, null);
// 		g.drawImage(Resources.TEXTURES.get(Resources.MANA), 10, 25, Tile.size * 2/5, Tile.size*2/5, null);
// 		g.drawImage(Resources.TEXTURES.get(Resources.ARMOR), 10, 50, Tile.size * 2/5, Tile.size*2/5, null);
// 		g.drawImage(Resources.TEXTURES.get(Resources.ULTI), 10, 75, Tile.size * 2/5, Tile.size*2/5, null);
// 		g.drawImage(Resources.TEXTURES.get(Resources.HEARTB), 40, 5, player.getHp() * 5, Tile.size*1/5, null);
// 		g.drawImage(Resources.TEXTURES.get(Resources.MANAB), 40, 30, player.getMp() * 5, Tile.size*1/5, null);
// 		g.drawImage(Resources.TEXTURES.get(Resources.ARMORB), 40, 55, player.getDef() * 5, Tile.size*1/5, null);
// 		g.drawImage(Resources.TEXTURES.get(Resources.ULTIB), 40, 80, player.getRTime()/5, Tile.size*1/5, null);
// 	}

// 	@Override
// 	public void KeyPressed(int keyCode) {

// 		switch(keyCode) {
		
// 		case KeyEvent.VK_DOWN:
// 			if(this.inConversation == false) {
// 				player.SetMove(true);
// 				player.SetFacing(Vector.Down);
// 			}
// 			break;
// 		case KeyEvent.VK_LEFT:
// 			if(this.inConversation == false) {
// 				player.SetMove(true);
// 				player.SetFacing(Vector.Left);
// 			}
// 			break;
// 		case KeyEvent.VK_RIGHT: 
// 			if(this.inConversation == false) {
// 				player.SetMove(true);
// 				player.SetFacing(Vector.Right);
// 			}
// 			break;
// 		case KeyEvent.VK_UP:
// 			if(this.inConversation == false) {
// 				player.SetMove(true);
// 				player.SetFacing(Vector.Up);
// 			}
// 			break;
// 		case KeyEvent.VK_Q: 
// 			if(this.inConversation == false) {
// 				p = false;
// 				player.AttackQ();
// 			}
// 			break;
// 		case KeyEvent.VK_R:
// 			if(this.inConversation == false) {
// 				p = false;
// 				player.AttackR();
// 			}
// 			break;
// 		case KeyEvent.VK_E:
// 			if(this.inConversation == false) {
// 				p = false;
// 				player.AttackE();
// 			}
// 			break;
// 		case KeyEvent.VK_P:	
// 			gameStateManager.setCurState(4);
// 			break;
// 		case KeyEvent.VK_ENTER:
// 			if(this.inConversation) {
// 				if(conversation != null)conversation.ChangeSentence();
// 			}
// 			break;
// 		}
		
// 	}

// 	@Override
// 	public void KeyReleased(int keyCode) {
// 		switch(keyCode) {
// 		case KeyEvent.VK_UP:
// 			player.SetMove(false);
// 			break;
// 		case KeyEvent.VK_DOWN:
// 			player.SetMove(false);
// 			break;
// 		case KeyEvent.VK_LEFT:
// 			player.SetMove(false);
// 			break;
// 		case KeyEvent.VK_RIGHT:
// 			player.SetMove(false);
// 			break;
// 		}
// 	}

// }




package game_state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import conversation.Conversation;
import entity.Player;
import game_world.*;
import resources.Resources;

public class PlayingState extends GameState{

	private World world;
	private Player player;
	private int timeToGameOver = 50;
	boolean p = true;
	boolean inConversation = false;
	Conversation conversation;

	public PlayingState(GameStateManager gameStateManager) {
		super(gameStateManager);
		player = new Player(7, 7, 2, 2, Resources.PLAYER, 1);
		world = new World(player);
		p = true;


		this.inConversation = true;

		String[] sentences = new String[]{
			"Ta đã từng tha cho các ngươi một mạng",
			"Vậy mà còn không biết hối lỗi hả?",
			"Hôm nay ta sẽ diệt trừ tận gốc",
			"Cứu lấy con gái của ta",
			"Đem lại hòa bình cho hành tinh Closeup"
		};
		byte[] imgIDs = new byte[] {
				Resources.PLAYER,
				Resources.PLAYER,
				Resources.PLAYER,
				Resources.PLAYER,
				Resources.PLAYER
		};
		this.conversation = new Conversation(150, imgIDs, sentences);
	}
	@Override
	public void Loop() {
		if(this.inConversation == false){
			world.ChangeRoom();
			//meet my daughter when defeat all of the monsters and enemies
			if(world.GetCur() == World.count - 1){	
				if(GameOverMenu.result == false){
					if(player.x <= Tile.size * 4){
						this.inConversation = true;
						String[] sentences = new String[]{
							"Ôi con gái của ta, ta đến cứu con đây",
							"Ta đã tiêu diệt hoàn toàn bọn hắc ám kia rồi",
							"Ta sẽ bảo vệ con bằng cả tính mạng của mình",
							"Huhuuu Cha ơi, con sợ lắm ạ.",
							"May mà có cha đến cứu con, con sợ lắm.",
							"Thôi về nhà thôi con",
							"Cùng nhau xây dựng hành tinh Closeup nào!!"
						};

						byte[] imgIDs = new byte[] {
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PLAYER,
							Resources.PLAYER
						};

						this.conversation = new Conversation(150, imgIDs, sentences);
						GameOverMenu.result = true;
					}
				}
				else{
					gameStateManager.setCurState(6);
				}
			}

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
			if(this.inConversation) {
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