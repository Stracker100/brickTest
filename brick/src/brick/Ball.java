package brick;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private int ballWidth, ballHeight, ballX, ballY;
	private Graphics g;
	
	public Ball(int ballX, int ballY, int ballWidth, int ballHeight) {
		this.ballHeight = ballHeight;
		this.ballWidth = ballWidth;
		this.ballX = ballX;
		this.ballY = ballY;
		
		
 
		//g.fillOval(ballX, ballY, ballWidth, ballHeight);
		render(ballX, ballY, ballWidth, ballHeight);
		//createBall(ballX, ballY, ballWidth, ballHeight);
		System.out.println("Ball Class");
		
		
	}
	
	public void render(int ballX, int ballY, int ballWidth, int ballHeight) {
		g.fillOval(ballX, ballY, ballWidth, ballHeight);
	}
	
	private void createBall(int ballX, int ballY, int ballWidth, int ballHeight) {
		g.setColor(Color.green);
		g.fillOval(ballX, ballY, ballWidth, ballHeight);
		System.out.println("Create Ball Class");
	}
	
}
