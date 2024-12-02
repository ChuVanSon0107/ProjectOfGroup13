package entity;

import game_world.Vector;

public class RSkill extends QSkill{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RSkill(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed) {
		super(x,y,facing, delayTime, frameCount, imgID, speed);

		damage = 1;
		ExistTime = 0;
	}

	public void Move() {
		super.x += (int)facing.x * speed;
		super.y += (int)facing.y * speed;
	}
	
	public void OnLoop() {
		super.OnLoop();
		Move();
	}
	
}