package entity;

import java.util.Random;
import java.awt.Graphics;
import game_world.Room;
import game_world.Vector;
import resources.Resources;

public class Boss extends Monster{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Boss(int x, int y, Vector facing, int delayTime, int frameCount, byte imgID, byte attackID, float speed, Room room, int hp,
			boolean freeze, int damage, int attackTime) {
		super(x,y,facing, delayTime, frameCount, imgID, attackID, speed, room, hp, freeze, damage, attackTime);
		// TODO Auto-generated constructor stub
		invisibleTime = 200;
		b = new firebullet(this.x, this.y, this.facing, 20, 1, Resources.FIREBULLET, 5, room, 2);
		m = new icebullet(this.x, this.y, this.facing, 20, 1, Resources.ICEBULLET, 5,  room, 2);
		b.SetAlive(false);
		m.SetAlive(false);
		
	}
	private firebullet b;
	private icebullet m;
	private int invisibleTime;
	public void DecreaseTime() {
		super.DecreaseTime();
		if(invisibleTime>0)
		invisibleTime--;
		else invisibleTime=200;
		// 0- 100 mà 100-200 thường
	}
	public void DecreaseTimeAd() {
		if(super.curATime>0)
		super.curATime--;
		else {
			AttackAd();
			curATime=AttackTime;
		}
	}
	protected void AttackAd() {
		Random r = new Random();
		int ran = r.nextInt(2);
		if(ran==0) {
			Vector v = new Vector(player.x-this.x, player.y-this.y);
			v= v.Nomalize();
			b.SetFacing(v);
			b.x = this.x;
			b.y = this.y;
			b.SetAlive(true);
			b.SetExistTime(300);
		}else {
			m.x=this.x;
			m.y=this.y;
			m.SetAlive(true);
			m.SetExistTime(300);
		}
	}
	public void Render(Graphics g) {
		super.Render(g);
		if(b.GetAlive())b.Render(g);
		if(m.GetAlive())m.Render(g);
	}
	public void OnLoop() {
		AnimationDisplay();
		DecreaseTime();
		DecreaseTimeAd();
		super.CollisionPlayer();
		super.Move();
		if(invisibleTime > 100) {
			super.CollisionQ();
			super.CollisionE();
			super.CollisionR();
			for(int i=0;i<Room.Ysize;i++) {
				for(int j=0;j<Room.Xsize;j++) {
					super.CollisionWall(room.GetTile(i, j));
				}
			}	
		}else {
			imgID = Resources.AD;
			frameCount = 1;
		}
		if(b.GetAlive())b.OnLoop();
		if(m.GetAlive())m.OnLoop();
	}
}