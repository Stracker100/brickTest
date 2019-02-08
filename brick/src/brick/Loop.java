package brick;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;



public class Loop implements Runnable{
	
	private Thread thread;
	private boolean running = false;
	private static int width;
	private int height;
	private static int playerX;
	private int playerY;
	private float ballX, ballY;
	private static float ballYdir, ballXdir;
	private String title;
	private display display;
	private Graphics2D g;
	private BufferStrategy bs;
	private DrawBricks drawBricks;
	//private Ball ball;
	private Rectangle player;
	private static Rectangle ball;


	public Loop(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		

		
		ballX = 500;
		ballY = 200;
		ballYdir = -0.2f;
		ballXdir = -0.2f;
		playerX = 400;
		playerY = 500;
		
	}
	
	private void init() {
		display = new display(800, 600, "hejsa");
		drawBricks = new DrawBricks();
		player = new Rectangle(playerX, playerY, 75, 5);
		ball = new Rectangle((int)ballX,(int)ballY,20,20);
		System.out.println("init " + ballY);
	}

	private void tick() {
		ballY = ballY + ballYdir;
		ballX = ballX + ballXdir;
		//System.out.println("tick " + ballY);
		if(player.intersects(ball)) {
			ballYdir = -0.2f;
			if(ballXdir > 0) {
				ballXdir = 0.2f;
			}else {
				ballXdir = -0.2f;
			}
		}
		
		if(ball.y == 0)
			ballYdir = 0.2f;
		if(ball.x == width)
			ballXdir = -0.2f;
		if(ball.x == 0)
			ballXdir = 0.2f;
		
		

	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		player.x = (int)playerX;
		player.y = (int)playerY;
		g.draw(player);
		g.setColor(Color.WHITE);
		//System.out.println("render " + ballY);
		ball.y = (int)ballY;
		ball.x = (int)ballX;
		g.draw(ball);
		drawBricks.draw(g);
		//
		bs.show();
		g.dispose();
		
	}


	public void run() {
		init();
		while(running) {
			tick();
			render();
		}
		stop();
	}
	
	public synchronized void start() {
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void setGoRight(){
		if(playerX + 60 > width)
			playerX = 740;
		playerX += 15; 
		
	}
	public static void setGoLeft(){
		if(playerX < 10)
			playerX = 10;
		playerX -= 15; 	
	}
	
	public static Rectangle getBall() {
		return ball;
	}
	
	public static void setyDirPos() {
		ballYdir = 0.2f;
	}
	public static void setyDirNeg() {
		ballYdir = -0.2f;
	}
	public static void setxDirPos() {
		ballXdir = 0.2f;
		//System.out.println("bliver dy kaldt?");
	}
	public static void setxDirNeg() {
		ballXdir = -0.2f;
	}
	
	public static int getBallX() {
		return ball.x;
	}
	
	public static int getBallY() {
		return ball.y;
	}

}
