package resources;


import java.awt.image.BufferedImage;

//import java.io.File;


import javax.imageio.ImageIO;

public class Loader {
	public void load(){
        try {  
        	BufferedImage image = ImageIO.read(getClass().getResource("/image/gentle forest v03.png"));
            BufferedImage image1 = ImageIO.read(getClass().getResource("/image/missprincess_0.png"));
            
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
            Resources.TEXTURES.add(Resources.BULLET, ImageIO.read(getClass().getResource("/image/Bullet.png")));
            Resources.TEXTURES.add(Resources.MISSILE, ImageIO.read(getClass().getResource("/image/missile.png")));
            Resources.TEXTURES.add(Resources.MONSTER, ImageIO.read(getClass().getResource("/image/monster.png")));
            Resources.TEXTURES.add(Resources.MONSTER_2, ImageIO.read(getClass().getResource("/image/monster_2.png")));
            Resources.TEXTURES.add(Resources.MONSTER_ATTACK, ImageIO.read(getClass().getResource("/image/monster_attack.png")));
            Resources.TEXTURES.add(Resources.GHOST, ImageIO.read(getClass().getResource("/image/ghost.png")));
            Resources.TEXTURES.add(Resources.GHOST_2, ImageIO.read(getClass().getResource("/image/ghost_2.png")));
            Resources.TEXTURES.add(Resources.GHOST_ATTACK, ImageIO.read(getClass().getResource("/image/ghost_attack.png")));
            Resources.TEXTURES.add(Resources.GHOST_INVISIBLE, ImageIO.read(getClass().getResource("/image/ghost_invi.png")));
            Resources.TEXTURES.add(Resources.GHOST_VISIBLE_2, ImageIO.read(getClass().getResource("/image/ghost_invi2.png")));
            Resources.TEXTURES.add(Resources.ITEM, ImageIO.read(getClass().getResource("/image/item.png")));
            Resources.TEXTURES.add(Resources.OBSTACLE, ImageIO.read(getClass().getResource("/image/obstacel.png")));
            Resources.TEXTURES.add(Resources.OBSTACLE_2, ImageIO.read(getClass().getResource("/image/obstacel_2.png")));
            //Resources.TEXTURES.add(Resources.BACKGROUND, ImageIO.read(getClass().getResource("/image/anh_nen.jpg")));
            Resources.TEXTURES.add(Resources.BACKGROUND, ImageIO.read(getClass().getResource("/image/background.jpg")));

            Resources.TEXTURES.add(Resources.PLAYER_ICE, ImageIO.read(getClass().getResource("/image/ice.png")));
            Resources.TEXTURES.add(Resources.F_MONSTER, ImageIO.read(getClass().getResource("/image/f_monster.png")));
            Resources.TEXTURES.add(Resources.F_MONSTER_2, ImageIO.read(getClass().getResource("/image/f_monster_2.png")));
            Resources.TEXTURES.add(Resources.Q, ImageIO.read(getClass().getResource("/image/Q.png")));
            Resources.TEXTURES.add(Resources.R, ImageIO.read(getClass().getResource("/image/R.png")));
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

            //Resources.TEXTURES.add(Resources.BUTTON_1, ImageIO.read(getClass().getResource("/image/Button_1.png")));
            //Resources.TEXTURES.add(Resources.BUTTON, ImageIO.read(getClass().getResource("/image/Button_2.png")));
            Resources.TEXTURES.add(Resources.BUTTON_1, ImageIO.read(getClass().getResource("/image/Button_01.png")));
            Resources.TEXTURES.add(Resources.BUTTON, ImageIO.read(getClass().getResource("/image/Button_02.png")));

            Resources.TEXTURES.add(Resources.UFO, ImageIO.read(getClass().getResource("/image/ufo.png")));
            Resources.TEXTURES.add(Resources.PLANET, ImageIO.read(getClass().getResource("/image/planet.png")));
            Resources.TEXTURES.add(Resources.UNIVERSE, ImageIO.read(getClass().getResource("/image/universe.jpg")));
            Resources.TEXTURES.add(Resources.WALL1, image.getSubimage(16*0,16*0,16,16));
            Resources.TEXTURES.add(Resources.WALL2, image.getSubimage(16*1, 16*0, 16, 16));
            Resources.TEXTURES.add(Resources.WALL3, image.getSubimage(16*2, 16*0, 16, 16));
            Resources.TEXTURES.add(Resources.WALL4, image.getSubimage(16*3, 16*0, 16, 16));
            Resources.TEXTURES.add(Resources.WALL5, image.getSubimage(16*0, 16*1, 16, 16));
            Resources.TEXTURES.add(Resources.WALL6, image.getSubimage(16*1, 16*1, 16, 16));
            Resources.TEXTURES.add(Resources.WALL7, image.getSubimage(16*2, 16*1, 16, 16));
            Resources.TEXTURES.add(Resources.WALL8, image.getSubimage(16*3, 16*1, 16, 16));
            Resources.TEXTURES.add(Resources.WALL9, image.getSubimage(16*0, 16*2, 16, 16));
            Resources.TEXTURES.add(Resources.WALL10, image.getSubimage(16*1, 16*2, 16, 16));
            Resources.TEXTURES.add(Resources.WALL11, image.getSubimage(16*2, 16*2, 16, 16));
            Resources.TEXTURES.add(Resources.WALL12, image.getSubimage(16*3, 16*2, 16, 16));
            Resources.TEXTURES.add(Resources.WALL13, image.getSubimage(16*0, 16*3, 16, 16));
            Resources.TEXTURES.add(Resources.WALL14, image.getSubimage(16*1, 16*3, 16, 16));
            Resources.TEXTURES.add(Resources.WALL15, image.getSubimage(16*2, 16*3, 16, 16));
            Resources.TEXTURES.add(Resources.WALL16, image.getSubimage(16*3, 16*3, 16, 16));
            Resources.TEXTURES.add(Resources.WALL17, image.getSubimage(16*4, 16*0, 16, 16));
            Resources.TEXTURES.add(Resources.WALL18, image.getSubimage(16*5, 16*0, 16, 16));
            Resources.TEXTURES.add(Resources.WALL19, image.getSubimage(16*4, 16*1, 16, 16));
            Resources.TEXTURES.add(Resources.WALL20,image.getSubimage(16*5, 16*1, 16, 16));
            Resources.TEXTURES.add(Resources.WALL21,image.getSubimage(16*3, 16*4, 16, 16));
            Resources.TEXTURES.add(Resources.BLOOD_FALL, ImageIO.read(getClass().getResource("/image/blood_fall.png")));
            Resources.TEXTURES.add(Resources.MONSTER1, ImageIO.read(getClass().getResource("/image/Monster1.png")));
            Resources.TEXTURES.add(Resources.MONSTER1_2, ImageIO.read(getClass().getResource("/image/Monster1_2.png")));
            Resources.TEXTURES.add(Resources.MONSTER1_ATTACK, ImageIO.read(getClass().getResource("/image/Monster1_attack.png")));
            Resources.TEXTURES.add(Resources.E, ImageIO.read(getClass().getResource("/image/E.png")));

            Resources.TEXTURES.add(Resources.GRASS1,image.getSubimage(16*1, 16*5, 16, 16));
            Resources.TEXTURES.add(Resources.GRASS2,image.getSubimage(16*2, 16*5, 16, 16));
            Resources.TEXTURES.add(Resources.GRASS3,image.getSubimage(16*1, 16*6, 16, 16));
            Resources.TEXTURES.add(Resources.GRASS4,image.getSubimage(16*2, 16*6, 16, 16));

            Resources.TEXTURES.add(Resources.FLOWER1,image.getSubimage(16*10, 16*5, 16, 16));
            Resources.TEXTURES.add(Resources.FLOWER2,image.getSubimage(16*8, 16*6, 16, 16));
            Resources.TEXTURES.add(Resources.FLOWER3,image.getSubimage(16*9, 16*6, 16, 16));
            Resources.TEXTURES.add(Resources.FLOWER4,image.getSubimage(16*10, 16*6, 16, 16));

            
            Resources.TEXTURES.add(Resources.TREE1,image.getSubimage(16*6, 16*0, 16, 16));
            Resources.TEXTURES.add(Resources.TREE2,image.getSubimage(16*7, 16*0, 16, 16));
            Resources.TEXTURES.add(Resources.TREE3,image.getSubimage(16*6, 16*1, 16, 16));
            Resources.TEXTURES.add(Resources.TREE4,image.getSubimage(16*7, 16*1, 16, 16));
            Resources.TEXTURES.add(Resources.TREE5,image.getSubimage(16*6, 16*2, 16, 16));
            Resources.TEXTURES.add(Resources.TREE6,image.getSubimage(16*7, 16*2, 16, 16));
            
            Resources.TEXTURES.add(Resources.HOLE1,image.getSubimage(16*8, 16*2, 16, 16));
            Resources.TEXTURES.add(Resources.HOLE2,image.getSubimage(16*9, 16*2, 16, 16));
            
            Resources.TEXTURES.add(Resources.CAVE1,image.getSubimage(16*1, 16*12, 16, 16));
            Resources.TEXTURES.add(Resources.CAVE2,image.getSubimage(16*2, 16*12, 16, 16));
            Resources.TEXTURES.add(Resources.CAVE3,image.getSubimage(16*1, 16*13, 16, 16));
            Resources.TEXTURES.add(Resources.CAVE4,image.getSubimage(16*2, 16*13, 16, 16));
            Resources.TEXTURES.add(Resources.CAVE5,image.getSubimage(16*1, 16*14, 16, 16));
            Resources.TEXTURES.add(Resources.CAVE6,image.getSubimage(16*2, 16*14, 16, 16));
            
            // WATER
            Resources.TEXTURES.add(Resources.WATER1,image.getSubimage(0, 16*8, 16, 16));
            Resources.TEXTURES.add(Resources.WATER2,image.getSubimage(16*1, 16*8, 16, 16));
            Resources.TEXTURES.add(Resources.WATER3,image.getSubimage(16*2, 16*8, 16, 16));
            Resources.TEXTURES.add(Resources.WATER4,image.getSubimage(16*3, 16*8, 16, 16));

            Resources.TEXTURES.add(Resources.WATER5,image.getSubimage(16*0, 16*9, 16, 16));
            Resources.TEXTURES.add(Resources.WATER6,image.getSubimage(16*1, 16*9, 16, 16));
            Resources.TEXTURES.add(Resources.WATER7,image.getSubimage(16*3, 16*9, 16, 16));

            Resources.TEXTURES.add(Resources.WATER8,image.getSubimage(16*0, 16*10, 16, 16));
            Resources.TEXTURES.add(Resources.WATER9,image.getSubimage(16*1, 16*10, 16, 16));
            Resources.TEXTURES.add(Resources.WATER10,image.getSubimage(16*3, 16*10, 16, 16));

            Resources.TEXTURES.add(Resources.WATER11,image.getSubimage(16*0, 16*11, 16, 16));
            Resources.TEXTURES.add(Resources.WATER12,image.getSubimage(16*1, 16*11, 16, 16));
            Resources.TEXTURES.add(Resources.WATER13,image.getSubimage(16*2, 16*11, 16, 16));
            Resources.TEXTURES.add(Resources.WATER14,image.getSubimage(16*3, 16*11, 16, 16));

            Resources.TEXTURES.add(Resources.WATER15,image.getSubimage(16*4, 16*6, 16, 16));
            Resources.TEXTURES.add(Resources.WATER16,image.getSubimage(16*5, 16*6, 16, 16));
            Resources.TEXTURES.add(Resources.WATER17,image.getSubimage(16*4, 16*7, 16, 16));
            Resources.TEXTURES.add(Resources.WATER18,image.getSubimage(16*5, 16*7, 16, 16));
            // GATE
            for(int i = 4;i < 8;i++){
                for(int j = 0;j < 4;j++){
                    if((i == 5 || i == 6) && (j == 1 || j == 2)) continue;
                    Resources.TEXTURES.add(image.getSubimage(16*j, 16*i, 16, 16));
                }
            }
            // PRINCESS 
            Resources.TEXTURES.add(image1.getSubimage(0, 0, 16, 16));
            //GUIDEMENU
            Resources.TEXTURES.add(Resources.GUIDEMENU, ImageIO.read(getClass().getResource("/image/guideMenu.jpg")));

            //STORYMENU
            Resources.TEXTURES.add(Resources.STORYMENU, ImageIO.read(getClass().getResource("/image/storyMenu.jpg")));


        }catch (Exception e) {
        		System.out.print("Load Failed\n");
                e.printStackTrace();
        }
}
}
