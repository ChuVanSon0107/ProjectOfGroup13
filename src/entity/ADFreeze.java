package entity;

import java.awt.Graphics;
import java.util.Random;

import game_world.Room;
import game_world.Tile;
import resources.Resources;

public class ADFreeze extends Monster{
	
	private static final long serialVersionUID = 1L;

	public ADFreeze(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room, int hp, boolean freeze, int damage, int attackTime) {
		super(x,y,facing, delayTime, frameCount, imgID, (byte)0, speed, room, hp, true, damage, attackTime);
		b= new icebullet(this.x, this.y, this.facing, 20, 1, Resources.ICEBULLET, 5, room, 2);
		//m = new Missile(this.x, this.y, this.facing, 20, 1, Resources.MISSILE, 5,  room, 2);
		b.SetAlive(false);
	}
	boolean freeze=true;
	private icebullet b;
	public void OnLoop() {
		AnimationDisplay();
		super.CollisionR();
		super.CollisionE();
		for(int i=0;i<Room.Ysize;i++) {
			for(int j=0;j<Room.Xsize;j++) {
				super.CollisionWall(room.GetTile(i, j));
			}
		}
		DecreaseTime();
		if(b.GetAlive())b.OnLoop();
		Escape();
	}
	
	public void DecreaseTime() {
		if(super.curATime>0)
		super.curATime--;
		else {
			Attack();
			curATime=AttackTime;
		}
	}
	
	protected void Attack() {
			Vector v = new Vector(player.x-this.x, player.y-this.y);
			v= v.Nomalize();
			b.SetFacing(v);
			b.x = this.x;
			b.y = this.y;
			b.SetAlive(true);
			b.SetExistTime(200);
		}
	public void Render(Graphics g) {
		super.Render(g);
		if(b.GetAlive())b.Render(g);
	}
	public void Escape() {
		float escapeDistance = 150; // Tăng khoảng cách né tránh để hoạt động ở mọi độ khó
		if(super.x % Tile.size == 0 && super.y % Tile.size == 0) {
			facing = new Vector(0, 0);
			Vector d = new Vector((float) player.x - (float) super.x, (float) player.y - (float) super.y);
			
			// Chỉ kích hoạt né tránh khi ở trong phạm vi xác định
			if(d.Length() < escapeDistance) {
				System.out.println("Escape triggered at distance: " + d.Length());
				int i = super.y / Tile.size;
				int j = super.x / Tile.size;
				Vector bestDirection = null;
				float maxEscapeDistance = d.Length();
				
				// Kiểm tra hướng lên
				if(i > 0) {
					Tile tile = room.GetTile(i - 1, j);
					if(tile.GetProperty() != 1) {
						Vector d1 = new Vector(player.x - tile.x, player.y - tile.y);
						if(d1.Length() > maxEscapeDistance) {
							maxEscapeDistance = d1.Length();
							bestDirection = Vector.Up;
						}
					}
				}
				// Kiểm tra hướng xuống
				if(i < Room.Ysize - 1) {
					Tile tile = room.GetTile(i + 1, j);
					if(tile.GetProperty() != 1) {
						Vector d1 = new Vector(player.x - tile.x, player.y - tile.y);
						if(d1.Length() > maxEscapeDistance) {
							maxEscapeDistance = d1.Length();
							bestDirection = Vector.Down;
						}
					}
				}
				// Kiểm tra hướng trái
				if(j > 0) {
					Tile tile = room.GetTile(i, j - 1);
					if(tile.GetProperty() != 1) {
						Vector d1 = new Vector(player.x - tile.x, player.y - tile.y);
						if(d1.Length() > maxEscapeDistance) {
							maxEscapeDistance = d1.Length();
							bestDirection = Vector.Left;
						}
					}
				}
				// Kiểm tra hướng phải
				if(j < Room.Xsize - 1) {
					Tile tile = room.GetTile(i, j + 1);
					if(tile.GetProperty() != 1) {
						Vector d1 = new Vector(player.x - tile.x, player.y - tile.y);
						if(d1.Length() > maxEscapeDistance) {
							maxEscapeDistance = d1.Length();
							bestDirection = Vector.Right;
						}
					}
				}
				
				// Chọn hướng né tốt nhất
				if(bestDirection != null) {
					facing = bestDirection;
				} else {
					// Chọn ngẫu nhiên nếu không có hướng tốt hơn
					facing = RandomDirection();
				}
			}
		}
		super.x = (int) (super.x + facing.x * speed);
		super.y = (int) (super.y + facing.y * speed);
		if(super.y < 0) super.y = 0;
		if(super.y > (Room.Ysize - 1) * Tile.size) super.y = (Room.Ysize - 1) * Tile.size;
	}
	
	private Vector RandomDirection() {
		Random random = new Random();
		switch(random.nextInt(4)) {
			case 0: return Vector.Up;
			case 1: return Vector.Down;
			case 2: return Vector.Left;
			default: return Vector.Right;
		}
	}
}	
	