package game_world;

import java.awt.Graphics;
import java.util.ArrayList;

import entity.*;
import resources.Resources;

public class Room {
	public static final int Xsize = 16;
	public static final int Ysize = 9;
	private Tile[][] tiles;
	private ArrayList<Enemy> enemies;
	private ArrayList<Princess> princesses;
	private Player player;
	public Player GetPlayer() {
		return player;
	}
	public void SetPlayer(Player player) {
		this.player = player;
	}
	public Room(int[][] ids) {

		tiles = new Tile[Ysize][Xsize];
		
		enemies = new ArrayList<Enemy>();
		princesses = new ArrayList<Princess>();
		for(int i = 0; i < Ysize; i++){
			for(int j = 0; j < Xsize; j++) {
		        tiles[i][j] = new Tile(ids[i][j], j, i);
			}
		}
	}
	public Tile GetTile(int i, int j) {
		return tiles[i][j];
	}
	
	public void Render(Graphics g) {
		
		for(int i = 0; i < Ysize; i++) {
			for(int j = 0; j < Xsize; j++) {
				g.drawImage(Resources.TEXTURES.get(tiles[i][j].getID()), tiles[i][j].x, tiles[i][j].y, tiles[i][j].width, tiles[i][j].height, null);
			}
		}
		for(Enemy entity: enemies) {
			if(entity.GetAlive())
			entity.Render(g);
		}
		for(Princess princess : princesses){
			princess.Render(g);
		}
	}
	public void Loop() {
		for(Enemy enemy : enemies) {
			if(enemy.GetAlive())
			enemy.OnLoop();
			
		}
	}
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	public ArrayList<Princess> getPrincesses(){
		return princesses;
	}
	
	public Tile[][] GetTiles(){
		return tiles;
	}
}
