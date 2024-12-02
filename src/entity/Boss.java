package entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import game_world.Room;
import game_world.Tile;
import game_world.Vector;
import resources.Resources;

public class Boss extends Monster {
    private firebullet fire;
    private icebullet ice;

    public Boss(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room, int hp, boolean freeze, int damage, int attackTime){
        super(x, y, facing, delayTime, frameCount, imgID, (byte)0, speed, room, hp, false, damage, attackTime);

        fire = new firebullet(this.x, this.y, this.facing, 20, 1, Resources.FIREBULLET, 5, room, 10);
        fire.SetAlive(false);

        ice = new icebullet(this.x, this.y, this.facing, 20, 1, Resources.ICEBULLET, 5, room, 5);
        ice.SetAlive(false);


		//set the size of the Boss
		this.width = Tile.size * 3;
		this.height = Tile.size * 3;
    }

    @Override
    public void CollisionQ() {
		
		if(stunTime == 0) {
			Rectangle r = this.intersection(player.GetQPos());
			if(r.isEmpty())return;
			bloodTime = 20;
			stunTime = 20;
			TakeDamage(-player.GetQPos().GetDamage());
		}
	}

    @Override
    public void CollisionE() {
		
		if(stunTime == 0) {
			Rectangle r = this.intersection(player.GetQPos());
			if(r.isEmpty())return;
			bloodTime = 20;
			stunTime = 20;
			TakeDamage(-player.GetQPos().GetDamage());
		}
	}

    @Override
    public void CollisionR() {
		
		if(stunTime == 0) {
			Rectangle r = this.intersection(player.GetQPos());
			if(r.isEmpty())return;
			bloodTime = 20;
			stunTime = 20;
			TakeDamage(-player.GetQPos().GetDamage());
		}
	}

    public void OnLoop(){
        AnimationDisplay();
        CollisionQ();
        CollisionR();
        CollisionE();


		for(int i = 0; i < Room.Ysize; i++) {
			for(int j = 0; j < Room.Xsize; j++) {
				super.CollisionWall(room.GetTile(i, j));
			}
		}
		DecreaseTime();
		if(fire.GetAlive() == true){
            fire.OnLoop();
        }
        if(ice.GetAlive() == true){
            ice.OnLoop();
        }
        Escape();
    }

    @Override
    public void DecreaseTime() {
		if(super.curATime > 0)
		super.curATime--;
		else {
			Attack();
			curATime = AttackTime;
		}
	}

    @Override
    public void Attack(){
        Vector v = new Vector(player.x - this.x, player.y - this.y);
        v = v.Nomalize();


        fire.SetFacing(v);
        fire.x = this.x;
        fire.y = this.y + Tile.size;
        fire.SetAlive(true);
        fire.SetExistTime(120);


        ice.SetFacing(v);
        ice.x = this.x;
        ice.y = this.y + Tile.size * 3;
        ice.SetAlive(true);
        ice.SetExistTime(120);
    }

    @Override
    public void Render(Graphics g){

        g.drawImage(Resources.TEXTURES.get(imgID + curFrame), x, y, width, height, null);

        if(fire.GetAlive() == true){
            fire.Render(g);
        }
        if(ice.GetAlive() == true){
            ice.Render(g);
        }
    }

    public void Escape() {
		if(super.x % Tile.size == 0 && super.y % Tile.size == 0) {
		facing = new Vector(0,0);
		Vector d = new Vector((float)player.x - (float)super.x, (float)player.y - (float)super.y);
		if(d.Length() < 90) {
			System.out.println("Escape");
			int i = super.y / Tile.size;
			int j = super.x / Tile.size;
			if(i > 0) {
				Tile tile = room.GetTile(i - 1, j);
				if(tile.GetProperty() != 1) {
					Vector d1 = new Vector((float)player.x- (float)tile.x, (float)player.y- (float)tile.y);
					if(d1.Length() > d.Length()) {
						d = d1;
					facing = Vector.Up;
					}
				}
			}
			if(i < Room.Ysize - 1) {
				Tile tile = room.GetTile(i + 1, j);
				if(tile.GetProperty() != 1) {
					Vector d1 = new Vector((float)player.x- (float)tile.x, (float)player.y- (float)tile.y);
					if(d1.Length()>d.Length()) {
						d = d1;
					facing = Vector.Down;
					}
				}
			}
			if(j > 0) {
				Tile tile = room.GetTile(i, j - 1);
				if(tile.GetProperty()!=1) {
					Vector d1 = new Vector((float)player.x - (float)tile.x, (float)player.y - (float)tile.y);
					if(d1.Length()>d.Length()) {
						d = d1;
					facing = Vector.Left;
					}
				}
			}
			if(j < Room.Xsize - 1) {
				Tile tile = room.GetTile(i, j + 1);
				if(tile.GetProperty()!=1) {
					Vector d1 = new Vector((float)player.x - (float)tile.x, (float)player.y - (float)tile.y);
					if(d1.Length()>d.Length()) {
						d = d1;
					facing = Vector.Right;
					}
				}
			}
			
		}
		
		}
		super.x = (int)(super.x + facing.x * speed);
		super.y = (int)(super.y + facing.y * speed);
		if(super.y < 0)super.y = 0;
		if(super.y > (Room.Ysize - 1) * Tile.size)super.y = (Room.Ysize - 1) * Tile.size;
	}

}
