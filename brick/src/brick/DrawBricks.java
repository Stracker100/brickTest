package brick;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;



public class DrawBricks {

	public int map[][];
    public int brickWIDTH;
    public int brickHEIGHT;
    private Rectangle brick;
    private int brickX, brickY, count;
    public Rectangle[] rect;

    public DrawBricks() {
    	brickWIDTH = 50;
        brickHEIGHT = 20;
        brickX = 50;
        brickY = 100;

        rect = new Rectangle[13*3];
        map = new int[13][3];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;
            }
        }
    }
    public void draw(Graphics2D g){
        count = 0;
        for (int i = 0; i < map.length;i++){
            for (int j = 0; j < map[0].length;j++){
                if(map[i][j] > 0){
                	g.setColor(Color.WHITE);
                	brick = new Rectangle(brickX + i * brickWIDTH, brickY + j * brickHEIGHT, brickWIDTH, brickHEIGHT);
                	
                	
                	//rect[count] = brick;
                	//count ++;
                	g.draw(brick);
                	
                
                	
                	if(Loop.getBall().intersects(brick)) {
                		map[i][j] = 0;
                		
                		if(Loop.getBallY() + 19 <= brickY + j * brickHEIGHT && Loop.getBallX() + 20 > brickX + i * brickWIDTH && Loop.getBallX() < brickX + i * brickWIDTH + brickWIDTH) {
                			Loop.setyDirNeg();
                			System.out.println("1");
                			}
                		if(Loop.getBallY() >= brickY + j * brickHEIGHT + brickHEIGHT - 1  && Loop.getBallX() + 20 > brickX + i * brickWIDTH && Loop.getBallX() < brickX + i * brickWIDTH + brickWIDTH) {
                			Loop.setyDirPos();					
                			System.out.println("2");
                			}
                		if(Loop.getBallX() >= brickX + i * brickWIDTH + brickWIDTH - 1 && Loop.getBallY()  <= brickY + j * brickHEIGHT + brickHEIGHT && Loop.getBallY() >=  brickY + j * brickHEIGHT) {
                			Loop.setxDirPos();
                			System.out.println("3");
                			}
                		if(Loop.getBallX() + 20 <= brickX + i * brickWIDTH - 1 && Loop.getBallY() + 10 <= brickY + j * brickHEIGHT + brickHEIGHT  && Loop.getBallY() + 10 >=  brickY + j * brickHEIGHT) {
                			Loop.setxDirNeg();
                			System.out.println("4");
                			}
                		// + brickWIDTH && Loop.getBallY() + 20 > brickY + j * brickHEIGHT && Loop.getBallY() < brickY + j * brickHEIGHT + brickHEIGHT 
                		               			
                	}
                	
                }
            }
        }
    }
}
