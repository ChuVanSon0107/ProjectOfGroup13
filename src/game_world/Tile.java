package game_world;

import java.awt.Rectangle;

import resources.Resources;

public class Tile extends Rectangle{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public static final int size = 50;
	private byte prop;
	public Tile(int ids,int x,int y) {
		super(x * size, y * size, size, size);
		this.id = ids;
		// prop = 0 -> pass
		// prop = 1 -> block
		// prop = 2 -> slow
		// prop = 3 -> change room 
		if(id == Resources.WALL || id == Resources.STONE || id == Resources.TREE) prop=1;
		else if((id >= Resources.GRASS1 && id <= Resources.GRASS4) || 
				(id >= Resources.TREE1 && id <= Resources.TREE6))prop = 1;
		else if(id >= Resources.ROAD1 && id <= Resources.ROAD21)prop = 0;
		else if(id >= Resources.WATER1 && id <= Resources.WATER18)prop=2;
		else if(id >= Resources.CAVE1 || id <= Resources.CAVE6) prop = 3;
		else prop = 0;
	}
	public byte GetProperty() {
		return prop;
	}
	public int getID() {
		return id;
	}
}
