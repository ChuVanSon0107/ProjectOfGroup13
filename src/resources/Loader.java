package resources;


import java.awt.image.BufferedImage;

//import java.io.File;


import javax.imageio.ImageIO;

public class Loader {
	public void load(){
        try {  
            // LOAD TILESET IMAGE
            BufferedImage image = ImageIO.read(getClass().getResource("/image/gentle forest v03.png"));
            // LOAD PRINCESS IMAGE
            BufferedImage image1 = ImageIO.read(getClass().getResource("/image/missprincess_0.png"));
            // ADDING TILE
        	Resources.TEXTURES.add(Resources.TILE,image.getSubimage(16*1, 16*5, 16, 16));
    		Resources.TEXTURES.add(Resources.WALL, ImageIO.read(getClass().getResource("/image/wall.png")));
    		Resources.TEXTURES.add(Resources.WATER, ImageIO.read(getClass().getResource("/image/water.png")));
    		Resources.TEXTURES.add(Resources.DIRT, ImageIO.read(getClass().getResource("/image/dirt.png")));
            Resources.TEXTURES.add(Resources.TREE, ImageIO.read(getClass().getResource("/image/tree.png")));
            Resources.TEXTURES.add(Resources.STONE, ImageIO.read(getClass().getResource("/image/stone.png")));
            Resources.TEXTURES.add(Resources.GRASS, ImageIO.read(getClass().getResource("/image/stone.png")));              
            Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(getClass().getResource("/image/player.png")));
            Resources.TEXTURES.add(Resources.PLAYER_2, ImageIO.read(getClass().getResource("/image/player_2.png")));
            Resources.TEXTURES.add(Resources.PLAYER_BACK, ImageIO.read(getClass().getResource("/image/player_back.png")));
            Resources.TEXTURES.add(Resources.PLAYER_BACK_2, ImageIO.read(getClass().getResource("/image/player_back_2.png")));
            Resources.TEXTURES.add(Resources.PLAYER_LEFT, ImageIO.read(getClass().getResource("/image/player_left.png")));
            Resources.TEXTURES.add(Resources.PLAYER_LEFT_2, ImageIO.read(getClass().getResource("/image/player_left_2.png")));
            Resources.TEXTURES.add(Resources.PLAYER_RIGHT, ImageIO.read(getClass().getResource("/image/player_right.png")));
            Resources.TEXTURES.add(Resources.PLAYER_RIGHT_2, ImageIO.read(getClass().getResource("/image/player_right_2.png")));
            Resources.TEXTURES.add(Resources.AD, ImageIO.read(getClass().getResource("/image/AD.png")));
            Resources.TEXTURES.add(Resources.AD_2, ImageIO.read(getClass().getResource("/image/AD_2.png")));
            Resources.TEXTURES.add(Resources.GHOST, ImageIO.read(getClass().getResource("/image/ghost.png")));
            Resources.TEXTURES.add(Resources.GHOST_2, ImageIO.read(getClass().getResource("/image/ghost_2.png")));
            Resources.TEXTURES.add(Resources.BULLET, ImageIO.read(getClass().getResource("/image/Bullet.png")));
            Resources.TEXTURES.add(Resources.MISSILE, ImageIO.read(getClass().getResource("/image/missile.png")));
            Resources.TEXTURES.add(Resources.MONSTER, ImageIO.read(getClass().getResource("/image/monster.png")));
            Resources.TEXTURES.add(Resources.MONSTER_2, ImageIO.read(getClass().getResource("/image/monster_2.png")));
            Resources.TEXTURES.add(Resources.MONSTER_ATTACK, ImageIO.read(getClass().getResource("/image/monster_attack.png")));
            Resources.TEXTURES.add(Resources.MONSTER1, ImageIO.read(getClass().getResource("/image/Monster1.png")));
            Resources.TEXTURES.add(Resources.MONSTER1_2, ImageIO.read(getClass().getResource("/image/Monster1_2.png")));
            Resources.TEXTURES.add(Resources.MONSTER1_ATTACK, ImageIO.read(getClass().getResource("/image/Monster1_attack.png")));
            Resources.TEXTURES.add(Resources.ITEM, ImageIO.read(getClass().getResource("/image/item.png")));
            
            //Resources.TEXTURES.add(Resources.BACKGROUND, ImageIO.read(getClass().getResource("/image/anh_nen.jpg")));
            Resources.TEXTURES.add(Resources.BACKGROUND, ImageIO.read(getClass().getResource("/image/background.jpg")));

            Resources.TEXTURES.add(Resources.PLAYER_ICE, ImageIO.read(getClass().getResource("/image/ice.png")));
            Resources.TEXTURES.add(Resources.F_MONSTER, ImageIO.read(getClass().getResource("/image/f_monster.png")));
            Resources.TEXTURES.add(Resources.F_MONSTER_2, ImageIO.read(getClass().getResource("/image/f_monster_2.png")));
            Resources.TEXTURES.add(Resources.Q, ImageIO.read(getClass().getResource("/image/Q.png")));
            Resources.TEXTURES.add(Resources.R, ImageIO.read(getClass().getResource("/image/R.png")));
            Resources.TEXTURES.add(Resources.E, ImageIO.read(getClass().getResource("/image/E.png")));
            Resources.TEXTURES.add(Resources.BLOOD, ImageIO.read(getClass().getResource("/image/blood.png")));
            Resources.TEXTURES.add(Resources.DARK, ImageIO.read(getClass().getResource("/image/dark.png")));        
            Resources.TEXTURES.add(Resources.HEART, ImageIO.read(getClass().getResource("/image/heart.png")));
            Resources.TEXTURES.add(Resources.MANA, ImageIO.read(getClass().getResource("/image/mana.png")));
            Resources.TEXTURES.add(Resources.ARMOR, ImageIO.read(getClass().getResource("/image/armor.png")));
            Resources.TEXTURES.add(Resources.ULTI, ImageIO.read(getClass().getResource("/image/ulti.png")));
            Resources.TEXTURES.add(Resources.HEARTB, ImageIO.read(getClass().getResource("/image/HPBar.png")));
            Resources.TEXTURES.add(Resources.MANAB, ImageIO.read(getClass().getResource("/image/MPBar.png")));
            Resources.TEXTURES.add(Resources.ARMORB, ImageIO.read(getClass().getResource("/image/DefBar.png")));
            Resources.TEXTURES.add(Resources.ULTIB, ImageIO.read(getClass().getResource("/image/RBar.png")));
            
            Resources.TEXTURES.add(Resources.BUTTON_1, ImageIO.read(getClass().getResource("/image/Button_01.png")));
            Resources.TEXTURES.add(Resources.BUTTON, ImageIO.read(getClass().getResource("/image/Button_02.png")));
            // ADDING ROAD TILE
            for (int i = 1; i <= 21; i++) {
                int x = (i - 1) % 4;  // Determines the x-coordinate
                int y = (i - 1) / 4;  // Determines the y-coordinate
                if (i > 16) { // Adjust coordinates for indices greater than 16
                    x = (i - 17) % 2 + 4; // Use columns 4 and 5
                    y = (i - 17) / 2;
                }
                if (i == 21) { // Special case for ROAD21
                    x = 3;
                    y = 4;
                }
                Resources.TEXTURES.add(Resources.class.getField("ROAD" + i).getInt(null),image.getSubimage(16 * x, 16 * y, 16, 16));
            }
            // ADDING GRASS TILES
            int tileIndex = 1; // Start from GRASS1
            for(int y = 5;y < 7;y++){
                for(int x = 1;x < 3;x++){ 
                    Resources.TEXTURES.add(Resources.class.getField("GRASS" + tileIndex).getInt(null),image.getSubimage(16*x,16*y,16,16));
                    tileIndex++;
                }
            }
            // ADDING FLOWER TILES
            tileIndex = 1; // Start from FLOWER1
            for (int y = 5;y <= 6;y++) {
                for(int x = 8;x <= 10;x++){
                    if(y == 5) x = 10;
                    Resources.TEXTURES.add(Resources.class.getField("FLOWER" + tileIndex).getInt(null),image.getSubimage(16*x,16*y,16,16));
                    tileIndex++;
                }
            }
            // ADDING TREE TILES;
            tileIndex = 1; // Start from TREE1
            for(int y = 0;y <= 2;y++){
                for(int x = 6;x <= 7;x++){
                    Resources.TEXTURES.add(Resources.class.getField("TREE" + tileIndex).getInt(null),image.getSubimage(16*x,16*y,16,16));
                    tileIndex++;
                }
            }
            // ADDING HOLE TILE
            Resources.TEXTURES.add(Resources.HOLE1,image.getSubimage(16*8, 16*2, 16, 16));
            Resources.TEXTURES.add(Resources.HOLE2,image.getSubimage(16*9, 16*2, 16, 16));
            // ADDING CAVE TILE
            tileIndex = 1; // Start from CAVE1
            for(int y = 12;y <= 14;y++){
                for(int x = 1;x <= 2;x++){
                    Resources.TEXTURES.add(Resources.class.getField("CAVE" + tileIndex).getInt(null),image.getSubimage(16*x,16*y,16,16));
                    tileIndex++;
                }
            }            
            // ADDING WATER INDEX
            tileIndex = 1; // Start from WATER1
            for (int y = 8; y <= 11; y++) {
                for (int x = 0; x <= 3; x++) {
                    // Skip specific coordinates where textures are not defined
                    if ((y == 9 && x == 2) || (y == 10 && x == 2)) continue;
                    Resources.TEXTURES.add(Resources.class.getField("WATER" + tileIndex).getInt(null),image.getSubimage(16 * x, 16 * y, 16, 16));
                    tileIndex++;
                }
            }
            tileIndex = 15; // Start from WATER15
            for (int y = 6; y <= 7; y++) {
                for (int x = 4; x <= 5; x++) {
                    Resources.TEXTURES.add(Resources.class.getField("WATER" + tileIndex).getInt(null),image.getSubimage(16 * x, 16 * y, 16, 16));
                    tileIndex++;
                }
            }
            // ADDING GATE TILE
            for(int i = 4; i < 8;i++){
                for(int j = 0;j < 4;j++){
                    if((i == 5 || i == 6) && (j == 1 || j == 2)) continue;
                    Resources.TEXTURES.add(image.getSubimage(16 * j, 16 * i, 16, 16));
                }
            }
            // ADDING GUIDEMENU
            Resources.TEXTURES.add(Resources.GUIDEMENU, ImageIO.read(getClass().getResource("/image/guideMenu.jpg")));

            // ADDING STORYMENU
            Resources.TEXTURES.add(Resources.STORYMENU, ImageIO.read(getClass().getResource("/image/storyMenu.jpg")));
            // ADDING PRINCESS
            Resources.TEXTURES.add(image1.getSubimage(0,0,16,16));
        }catch (Exception e) {
        		System.out.print("Load Failed\n");
                e.printStackTrace();
        }
}
}
