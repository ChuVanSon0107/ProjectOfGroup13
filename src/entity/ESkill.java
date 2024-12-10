package entity;


import game_world.Vector;


public class ESkill extends QSkill{
	/**
	 * 
	 */


	private static final long serialVersionUID = 1L;
	public ESkill(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed) {
		super(x,y,facing, delayTime, frameCount, imgID, speed);
		// TODO Auto-generated constructor stub
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