package entity;

import java.awt.Rectangle;

import game_world.Room;

public class icebullet extends Enemy{
	private static final long serialVersionUID = 1L;
	public icebullet(int x,int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room, int damage) {
		super(x,y,facing, delayTime, frameCount, imgID, speed, room);
		// TODO Auto-generated constructor stub
		this.damage = damage;
	}
	private int damage;
	private int existTime=100;
	public void Move() {
		super.x += (int)(facing.x * speed);
		super.y += (int)(facing.y * speed);
	}
	public void DecreaseTime() {
		super.DecreaseTime();
		if(existTime>0)existTime--;
		else SetAlive(false);
	}
	public void CollisionPlayer() {
		Rectangle r= this.intersection(player);
		if(r.isEmpty())return;
		player.TakeHP(-damage);
		SetAlive(false);
	}
	
	public void OnLoop() {
		Move();
		DecreaseTime();
		CollisionPlayer();
	}public void SetExistTime(int time) {
		existTime= time;
	}
}
