package game_world;

import javax.swing.text.html.parser.Entity;

import entity.AD;
import entity.Enemy;
import entity.Item;
import entity.Monster;
import entity.Obstacle;
import entity.Player;
import entity.Princess;
import game_state.MainMenu;
import resources.Resources;

public class World {
	public static final int count = 6;
	private Room[] rooms;
	private Player player;
	private int curRoom = 0;
	public World(Player player) {
		System.out.print("Init World\n");
		
		rooms = new Room[] {
				new Room(new int[][] {
				{68, 69, 70, 71, 68, 69, 68, 84, 85, 69, 70, 71, 68, 69, 70, 71},
				 {69, 68, 47, 49, 49, 48, 50, 86, 87, 47, 48, 48, 49, 50, 76, 77},
				 {70, 68, 51, 53, 56, 57, 54, 88, 89, 51, 52, 53, 56, 54, 78, 79},
				 {71, 72, 55, 53, 56, 57, 65, 48, 49, 66, 52, 53, 56, 58, 80, 81},
				 {69, 68, 51, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 54, 72, 68},
				 {70, 73, 55, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 58, 73, 68},
				 {71, 68, 51, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 54, 68, 68},
				 {70, 75, 59, 61, 60, 61, 60, 61, 60, 61, 60, 61, 60, 62, 68, 68},
				 {68, 69, 70, 71, 68, 69, 70, 71, 68, 69, 70, 71, 68, 69, 70, 71},
			   }),
			  	new Room(new int[][] {
				{68, 69, 70, 71, 68, 69, 68, 84, 85, 69, 70, 71, 68, 69, 70, 71},
				{69, 68, 47, 49, 49, 48, 50, 86, 87, 47, 48, 48, 49, 50, 76, 77},
				{70, 68, 51, 53, 56, 57, 54, 88, 89, 51, 52, 53, 56, 54, 78, 79},
				{71, 72, 55, 53, 56, 57, 65, 48, 49, 66, 52, 53, 56, 58, 80, 81},
				{69, 68, 51, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 54, 72, 68},
				{70, 73, 55, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 58, 73, 68},
				{71, 68, 51, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 54, 68, 68},
				{70, 75, 59, 61, 60, 64, 52, 53, 63, 61, 60, 61, 60, 62, 68, 68},
				{68, 69, 70, 71, 68, 51, 52, 53, 54, 69, 70, 71, 68, 69, 70, 71},
				  }),
				new Room(new int[][]{
						{68, 94, 95, 98, 95, 96, 68, 69, 70, 71, 68, 70, 68, 71, 68, 71},
						{70, 97, 95, 104, 105, 106, 91, 92, 91, 92, 91, 92, 91, 92, 93, 70},
						{68, 94, 95, 106, 107, 95, 98, 95, 98, 95, 104, 105, 98, 95, 96, 68},
						{70, 97, 98, 95, 95, 95, 98, 95, 98, 95, 106, 107, 98, 95, 96, 70},
						{68, 94, 95, 98, 95, 104, 101, 102, 101, 102, 101, 102, 105, 95, 96, 68},
						{70, 97, 95, 98, 95, 99, 68, 69, 70, 69, 69, 90, 107, 95, 99, 69},
						{68, 100, 101, 102, 101, 103, 69, 90, 92, 91, 92, 107, 95, 98, 96, 68},
						{68, 69, 70, 71, 69, 68, 69, 94, 98, 95, 98, 104, 101, 102, 103, 68},
						{68, 69, 70, 71, 69, 68, 68, 94, 98, 95, 104, 103, 68, 69, 70, 71},
					}),
				new Room(new int[][]{
						{68, 69, 68, 70, 68, 69, 68, 70, 68, 69, 68, 70, 51, 54, 68, 70},
						{68, 73, 47, 48, 49, 48, 49, 48, 48, 50, 76, 77, 55, 58, 68, 70},
						{68, 69, 51, 63, 60, 61, 64, 52, 53, 54, 78, 79, 51, 54, 68, 75},
						{68, 69, 55, 54, 68, 69, 51, 63, 60, 62, 80, 81, 55, 58, 69, 71},
						{68, 71, 51, 58, 70, 71, 55, 58, 68, 69, 70, 71, 51, 54, 70, 71},
						{70, 71, 59, 65, 50, 70, 51, 65, 48, 50, 68, 69, 55, 58, 69, 70},
						{73, 69, 47, 52, 54, 68, 59, 60, 64, 65, 48, 49, 66, 54, 71, 69},
						{68, 47, 66, 52, 58, 68, 69, 70, 59, 60, 61, 61, 60, 62, 68, 69},
						{69, 51, 52, 63, 68, 69, 70, 74, 69, 70, 68, 69, 70, 69, 69, 70},
					}),
				new Room(new int[][] {
						{68, 69, 70, 71, 68, 69, 68, 84, 85, 69, 70, 71, 68, 69, 70, 71},
						 {69, 68, 47, 49, 49, 48, 50, 86, 87, 47, 48, 48, 49, 50, 76, 77},
						 {70, 68, 51, 53, 56, 57, 54, 88, 89, 51, 52, 53, 56, 54, 78, 79},
						 {71, 72, 55, 53, 56, 57, 65, 48, 49, 66, 52, 53, 56, 58, 80, 81},
						 {69, 68, 51, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 54, 72, 68},
						 {70, 73, 55, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 58, 73, 68},
						 {71, 68, 51, 53, 56, 57, 52, 53, 56, 57, 52, 53, 56, 54, 68, 68},
						 {70, 75, 59, 61, 60, 61, 60, 61, 60, 61, 60, 61, 60, 62, 68, 68},
						 {68, 69, 70, 71, 68, 69, 70, 71, 68, 69, 70, 71, 68, 69, 70, 71},
					   }),
				new Room(new int[][] {
						{68, 69, 70, 71, 68, 108, 109, 110, 109, 110, 109, 111, 68, 69, 70, 71},
						{68, 69, 70, 71, 68, 112, 72, 47, 48, 50, 72, 113, 69, 69, 70, 71},
						{68, 69, 70, 71, 68, 114, 73, 55, 52, 54, 73, 115, 69, 69, 70, 71},
						{68, 69, 70, 71, 68, 112, 74, 51, 56, 58, 74, 113, 69, 69, 70, 71},
						{68, 69, 70, 71, 68, 112, 75, 55, 52, 54, 75, 115, 69, 69, 70, 71},
						{68, 69, 70, 71, 68, 114, 72, 51, 56, 58, 72, 113, 69, 69, 70, 71},
						{68, 69, 70, 71, 68, 112, 73, 55, 52, 54, 73, 115, 69, 69, 70, 71},
						{68, 69, 70, 71, 68, 114, 74, 51, 56, 58, 74, 113, 69, 69, 70, 71},
						{68, 69, 70, 71, 68, 116, 117, 59, 60, 62, 117, 119, 68, 69, 70, 71},
				})

	       };
	       
	       
		System.out.print("Init World_1\n");

		this.player = player;
		for(Room room : rooms) {
			room.SetPlayer(player);
		}
		player.SetRoom(rooms[0]);
		// ADDING PRINCESS
		rooms[5].getPrincesses().add(new Princess(8,2,640,1,Resources.PRINCESS1,0));
		if(MainMenu.getLevel() == 0) {
			 // room 0
			//rooms[0].getEnemies().add(new Enemy(3,7, Vector.Up,0,0,Resources.UFO, 0, rooms[0]));
	    	   //rooms[0].getEnemies().add(new Monster(4, 2, Vector.Up, 2, 2, Resources.MONSTER1,Resources.MONSTER_ATTACK, 1, rooms[0], 40, false, 1, 20));
	    	   //rooms[0].getEnemies().add(new Monster(10, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[0], 40, true, 1, 20));
	    	   // room 1
	    	   //rooms[1].getEnemies().add(new Monster(3, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 2, rooms[1], 10, true, 1, 20));
	    	   //rooms[1].getEnemies().add(new AD(12, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[1], 20, true, 0, 25));
	    	   rooms[1].getEnemies().add(new AD(13, 3, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[1], 20, false, 0, 25));
	    	   //rooms[1].getEnemies().add(new Item(14, 3, 0, 0, Resources.ITEM, 0, rooms[1]));
	    	   // room 2
	    	   /* 
	    	   rooms[2].getEnemies().add(new AD(5, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 20, true, 0, 50));
	    	   rooms[2].getEnemies().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[2], 20, false, 0, 50));
	    	   rooms[2].getEnemies().add(new AD(12, 3, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[2], 20, false, 0, 50));
	    	   rooms[2].getEnemies().add(new AD(10, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 20, true, 0, 50));
	    	   rooms[2].getEnemies().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[2], 40, false, 1, 20));
	    	   // room 3
	    	   
	    	   //rooms[3].getEnemies().add(new Ghost(2, 3, Vector.Up, 2, 2, Resources.GHOST,Resources.GHOST_ATTACK, 2, rooms[3], 10, false, 1, 200));
	    	   rooms[3].getEnemies().add(new AD(9, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[3], 20, false, 0, 50));
	    	   rooms[3].getEnemies().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[3], 20, false, 0, 100));
	    	   rooms[3].getEnemies().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[3], 40, false, 1, 20));
	    	   rooms[3].getEnemies().add(new Monster(10, 3, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[3], 40, true, 1, 20));
	    	   rooms[3].getEnemies().add(new Item(2, 6, 0, 0, Resources.ITEM, 0, rooms[3]));
	    	   //room 4 */
	   	    /*rooms[4].getEnemies().add(new Obstacle(11,5,Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
	    			   new Vector(rooms[4].GetTile(3, 3).x,rooms[4].GetTile(3, 3).y), 
	    			   new Vector(rooms[4].GetTile(3, 14).x,rooms[4].GetTile(3, 14).y), 
	    	    	   10));
	    	   
	    	   
	    	/*rooms[4].getEnemies().add(new Obstacle(11,5,Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
	    			   new Vector(rooms[4].GetTile(4, 11).x,rooms[4].GetTile(4, 11).y), 
	    			   new Vector(rooms[4].GetTile(7, 11).x,rooms[4].GetTile(7, 11).y), 
	    	    	   10));
	    	    //public Enemy(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room)	   
	    	   rooms[4].getEnemies().add(new Enemy(3,3, Vector.Up,0,0,Resources.AD, 0, rooms[4]));
	    	   rooms[4].getEnemies().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[4], 20, false, 0, 100));
	    	   //rooms[4].getEnemies().add(new Ghost(5, 3, Vector.Up, 2, 2, Resources.GHOST,Resources.GHOST_ATTACK, 5, rooms[4], 10, false, 1, 20));
		/* */

		}
		else {
			 // room 0
			/*rooms[0].getEnemies().add(new Enemy(3,7, Vector.Up,0,0,Resources.UFO, 0, rooms[0]));
	    	   rooms[0].getEnemies().add(new Monster(4, 2, Vector.Up, 2, 2, Resources.MONSTER1,Resources.MONSTER_ATTACK, 1, rooms[0], 40, false, 1, 20));
	    	   rooms[0].getEnemies().add(new Monster(10, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[0], 40, true, 1, 20));
	    	   // room 1
	    	   //rooms[1].getEnemies().add(new Monster(3, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 2, rooms[1], 10, true, 1, 20));
	    	   rooms[1].getEnemies().add(new AD(12, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[1], 20, true, 0, 25));
	    	   rooms[1].getEnemies().add(new AD(13, 3, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[1], 20, false, 0, 25));
	    	   rooms[1].getEnemies().add(new Item(14, 3, 0, 0, Resources.ITEM, 0, rooms[1]));
	    	   // room 2
	    	   
	    	   rooms[2].getEnemies().add(new AD(5, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 20, true, 0, 50));
	    	   rooms[2].getEnemies().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[2], 20, false, 0, 50));
	    	   rooms[2].getEnemies().add(new AD(12, 3, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[2], 20, false, 0, 50));
	    	   rooms[2].getEnemies().add(new AD(10, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 20, true, 0, 50));
	    	   rooms[2].getEnemies().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[2], 40, false, 1, 20));
	    	   // room 3
	    	   
	    	   //rooms[3].getEnemies().add(new Ghost(2, 3, Vector.Up, 2, 2, Resources.GHOST,Resources.GHOST_ATTACK, 2, rooms[3], 10, false, 1, 200));
	    	   rooms[3].getEnemies().add(new AD(9, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[3], 20, false, 0, 50));
	    	   rooms[3].getEnemies().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[3], 20, false, 0, 100));
	    	   rooms[3].getEnemies().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[3], 40, false, 1, 20));
	    	   rooms[3].getEnemies().add(new Monster(10, 3, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[3], 40, true, 1, 20));
	    	   rooms[3].getEnemies().add(new Item(2, 6, 0, 0, Resources.ITEM, 0, rooms[3]));
	    	   //room 4
	    	   
	   	    rooms[4].getEnemies().add(new Obstacle(11,5,Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
	    			   new Vector(rooms[4].GetTile(3, 3).x,rooms[4].GetTile(3, 3).y), 
	    			   new Vector(rooms[4].GetTile(3, 14).x,rooms[4].GetTile(3, 14).y), 
	    	    	   10));
	    	   
	    	   
	    	   rooms[4].getEnemies().add(new Obstacle(11,5,Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
	    			   new Vector(rooms[4].GetTile(4, 11).x,rooms[4].GetTile(4, 11).y), 
	    			   new Vector(rooms[4].GetTile(7, 11).x,rooms[4].GetTile(7, 11).y), 
	    	    	   10));
	    	   rooms[4].getEnemies().add(new Enemy(3,3, Vector.Up,0,0,Resources.AD, 0, rooms[4]));
	    	   rooms[4].getEnemies().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[4], 20, false, 0, 100));
		/* */
			   }
		
	}
	public void ChangeRoom() {
		int x = (int) player.getX() / 50;
		int y = (int) player.getY() / 50;
		//System.out.println(x + " " + y);
		//System.out.println(player.getSpeed());
		//System.out.println(rooms[curRoom].GetTile(y,x).getID());
		//System.out.println(player.getPrevPositionX() + " " + player.getPrevPositionY());
		if ((rooms[curRoom].GetTile(y,x).getID() >= Resources.CAVE1 &&  rooms[curRoom].GetTile(y,x).getID() <= Resources.CAVE6)
			|| player.getCenterY() < rooms[curRoom].GetTile(0, 0).y) {
			curRoom++;
			player.savePrevPosition(x, y + 1);
			if(curRoom == count) {	
				return;
			}
			switch (curRoom) {
				case 1: player.setPosition(7*50, 8*50);
					break;
				case 2: player.setPosition(7*50, 8*50);
					break;
				case 3: player.setPosition(2*50, 8*50);
					break;
				case 4: player.setPosition(7*50, 6*50);
					break;
				case 5: player.setPosition(7*50, 8*50);
					break;
			}
			player.SetRoom(rooms[curRoom]);
			player.GetRPos().SetExistTime(0);
		}
		else if (player.getCenterY() > rooms[curRoom].GetTile(Room.Ysize-1, 0).y + Tile.size) {
			curRoom--;
			player.setPosition(player.getPrevPositionX()*50, player.getPrevPositionY()*50);
			player.SetRoom(rooms[curRoom]);
			player.GetRPos().SetExistTime(0);
		}
	}
	public Room GetCurrentRoom() {
		return rooms[curRoom];
	}
	public Room[] GetRooms() {
		return rooms;
	}
	public int GetCur() {
		return curRoom;
	}
	
}
