package entity;



import game_world.Room;
import game_world.Vector;

public class Enemy extends Entity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Room room;
	protected Player player;
	private boolean alive = true;
	public Enemy(int x, int y, Vector facing, int delayTime, int frameCount, int imgID, float speed, Room room) {
		super(x, y, facing, delayTime, frameCount, imgID, speed);

		this.room = room;
		this.player = room.GetPlayer();
	}
	

	public void SetAlive(boolean alive) {
		this.alive = alive;
	}
	public boolean GetAlive() {
		return alive;
	}

	public void CollisionPlayer() {
		
	}
	public void CollisionQ() {
		
	}
	public void CollisionR() {
		
	}
	public void CollisionE() {
		
	}
	
}