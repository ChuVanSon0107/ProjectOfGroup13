package game_world;

import entity.AD;
import entity.Enemy;
import entity.Item;
import entity.Monster;
import entity.Obstacle;
import entity.Player;
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
			new Room(new byte[][] {
				{77,78,79,80,77,78,77,93,94,78,79,80,77,78,79,80},
				{78,77,51,53,53,52,54,95,96,51,52,52,53,54,85,86},
				{79,77,55,57,60,61,58,97,98,55,56,57,60,58,87,88},
				{80,81,59,57,60,61,69,52,53,70,56,57,60,62,89,90},
				{78,77,55,57,60,61,56,57,60,61,56,57,60,58,81,77},
				{79,82,59,57,60,61,56,57,60,61,56,57,60,62,82,77},
				{80,77,55,57,60,61,56,57,60,61,56,57,60,58,77,77},
				{79,84,63,65,64,65,64,65,64,65,64,65,64,66,77,77},
				{77,78,79,80,77,78,79,80,77,78,79,80,77,78,79,80},
				}),
				new Room(new byte[][] {
					{77,78,79,80,77,78,77,93,94,78,79,80,77,78,79,80},
					{78,77,51,53,53,52,54,95,96,51,52,52,53,54,85,86},
					{79,77,55,57,60,61,58,97,98,55,56,57,60,58,87,88},
					{80,81,59,57,60,61,69,52,53,70,56,57,60,62,89,90},
					{78,77,55,57,60,61,56,57,60,61,56,57,60,58,81,77},
					{79,82,59,57,60,61,56,57,60,61,56,57,60,62,82,77},
					{80,77,55,57,60,61,56,57,60,61,56,57,60,58,77,77},
					{79,84,63,65,64,68,56,57,67,65,64,65,64,66,77,77},
					{77,78,79,80,77,55,56,57,58,78,79,80,77,78,79,80},
					}),
	       };
	       
		System.out.print("Init World_1\n");
		this.player = player;
		for(Room room : rooms) {
			room.SetPlayer(player);
		}
		player.SetRoom(rooms[0]);
		if(MainMenu.getLevel() == 0) {
			 // room 0
			rooms[0].GetEntities().add(new Enemy(3,7, Vector.Up,0,0,Resources.UFO, 0, rooms[0]));
	    	   rooms[0].GetEntities().add(new Monster(4, 2, Vector.Up, 2, 2, Resources.MONSTER1,Resources.MONSTER_ATTACK, 1, rooms[0], 40, false, 1, 20));
	    	   rooms[0].GetEntities().add(new Monster(10, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[0], 40, true, 1, 20));
	    	   // room 1
	    	   //rooms[1].GetEntities().add(new Monster(3, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 2, rooms[1], 10, true, 1, 20));
	    	   /*rooms[1].GetEntities().add(new AD(12, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[1], 20, true, 0, 25));
	    	   rooms[1].GetEntities().add(new AD(13, 3, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[1], 20, false, 0, 25));
	    	   rooms[1].GetEntities().add(new Item(14, 3, 0, 0, Resources.ITEM, 0, rooms[1]));
	    	   // room 2
	    	   
	    	   rooms[2].GetEntities().add(new AD(5, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 20, true, 0, 50));
	    	   rooms[2].GetEntities().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[2], 20, false, 0, 50));
	    	   rooms[2].GetEntities().add(new AD(12, 3, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[2], 20, false, 0, 50));
	    	   rooms[2].GetEntities().add(new AD(10, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 20, true, 0, 50));
	    	   rooms[2].GetEntities().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[2], 40, false, 1, 20));
	    	   // room 3
	    	   
	    	   //rooms[3].GetEntities().add(new Ghost(2, 3, Vector.Up, 2, 2, Resources.GHOST,Resources.GHOST_ATTACK, 2, rooms[3], 10, false, 1, 200));
	    	   rooms[3].GetEntities().add(new AD(9, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[3], 20, false, 0, 50));
	    	   rooms[3].GetEntities().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[3], 20, false, 0, 100));
	    	   rooms[3].GetEntities().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[3], 40, false, 1, 20));
	    	   rooms[3].GetEntities().add(new Monster(10, 3, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[3], 40, true, 1, 20));
	    	   rooms[3].GetEntities().add(new Item(2, 6, 0, 0, Resources.ITEM, 0, rooms[3]));
	    	   //room 4
	    	   
	   	    rooms[4].GetEntities().add(new Obstacle(11,5,Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
	    			   new Vector(rooms[4].GetTile(3, 3).x,rooms[4].GetTile(3, 3).y), 
	    			   new Vector(rooms[4].GetTile(3, 14).x,rooms[4].GetTile(3, 14).y), 
	    	    	   10));
	    	   
	    	   
	    	   rooms[4].GetEntities().add(new Obstacle(11,5,Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
	    			   new Vector(rooms[4].GetTile(4, 11).x,rooms[4].GetTile(4, 11).y), 
	    			   new Vector(rooms[4].GetTile(7, 11).x,rooms[4].GetTile(7, 11).y), 
	    	    	   10));
	    	    //public Enemy(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room)	   
	    	   rooms[4].GetEntities().add(new Enemy(3,3, Vector.Up,0,0,Resources.AD, 0, rooms[4]));
	    	   rooms[4].GetEntities().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[4], 20, false, 0, 100));
	    	   //rooms[4].GetEntities().add(new Ghost(5, 3, Vector.Up, 2, 2, Resources.GHOST,Resources.GHOST_ATTACK, 5, rooms[4], 10, false, 1, 20));
		/* */
		}
		else {
			 // room 0
			/*rooms[0].GetEntities().add(new Enemy(3,7, Vector.Up,0,0,Resources.UFO, 0, rooms[0]));
	    	   rooms[0].GetEntities().add(new Monster(4, 2, Vector.Up, 2, 2, Resources.MONSTER1,Resources.MONSTER_ATTACK, 1, rooms[0], 40, false, 1, 20));
	    	   rooms[0].GetEntities().add(new Monster(10, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[0], 40, true, 1, 20));
	    	   // room 1
	    	   //rooms[1].GetEntities().add(new Monster(3, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 2, rooms[1], 10, true, 1, 20));
	    	   rooms[1].GetEntities().add(new AD(12, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[1], 20, true, 0, 25));
	    	   rooms[1].GetEntities().add(new AD(13, 3, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[1], 20, false, 0, 25));
	    	   rooms[1].GetEntities().add(new Item(14, 3, 0, 0, Resources.ITEM, 0, rooms[1]));
	    	   // room 2
	    	   
	    	   rooms[2].GetEntities().add(new AD(5, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 20, true, 0, 50));
	    	   rooms[2].GetEntities().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[2], 20, false, 0, 50));
	    	   rooms[2].GetEntities().add(new AD(12, 3, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[2], 20, false, 0, 50));
	    	   rooms[2].GetEntities().add(new AD(10, 3, Vector.Up, 2, 2, Resources.AD, 0, rooms[2], 20, true, 0, 50));
	    	   rooms[2].GetEntities().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[2], 40, false, 1, 20));
	    	   // room 3
	    	   
	    	   //rooms[3].GetEntities().add(new Ghost(2, 3, Vector.Up, 2, 2, Resources.GHOST,Resources.GHOST_ATTACK, 2, rooms[3], 10, false, 1, 200));
	    	   rooms[3].GetEntities().add(new AD(9, 1, Vector.Up, 2, 2, Resources.AD, 0, rooms[3], 20, false, 0, 50));
	    	   rooms[3].GetEntities().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[3], 20, false, 0, 100));
	    	   rooms[3].GetEntities().add(new Monster(11, 2, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[3], 40, false, 1, 20));
	    	   rooms[3].GetEntities().add(new Monster(10, 3, Vector.Up, 2, 2, Resources.MONSTER, Resources.MONSTER_ATTACK, 1, rooms[3], 40, true, 1, 20));
	    	   rooms[3].GetEntities().add(new Item(2, 6, 0, 0, Resources.ITEM, 0, rooms[3]));
	    	   //room 4
	    	   
	   	    rooms[4].GetEntities().add(new Obstacle(11,5,Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
	    			   new Vector(rooms[4].GetTile(3, 3).x,rooms[4].GetTile(3, 3).y), 
	    			   new Vector(rooms[4].GetTile(3, 14).x,rooms[4].GetTile(3, 14).y), 
	    	    	   10));
	    	   
	    	   
	    	   rooms[4].GetEntities().add(new Obstacle(11,5,Vector.Up, 2, 1, Resources.OBSTACLE, 5, rooms[4],
	    			   new Vector(rooms[4].GetTile(4, 11).x,rooms[4].GetTile(4, 11).y), 
	    			   new Vector(rooms[4].GetTile(7, 11).x,rooms[4].GetTile(7, 11).y), 
	    	    	   10));
	    	   rooms[4].GetEntities().add(new Enemy(3,3, Vector.Up,0,0,Resources.AD, 0, rooms[4]));
	    	   rooms[4].GetEntities().add(new AD(13, 5, Vector.Up, 2, 2, Resources.GHOST, 0, rooms[4], 20, false, 0, 100));
		/* */
			   }
		
	}
	public void ChangeRoom() {
		if (player.getCenterY() < rooms[curRoom].GetTile(0, 0).y) {
			curRoom++;
			if(curRoom==count) {	
				return;
			}
			player.SetCenterY(Tile.size*Room.Ysize - player.height);
			player.SetRoom(rooms[curRoom]);
			player.GetRPos().SetExistTime(0);
		}
		if (player.getCenterY() > rooms[curRoom].GetTile(Room.Ysize-1, 0).y + Tile.size) {
			curRoom--;
			player.SetCenterY(player.height);
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
