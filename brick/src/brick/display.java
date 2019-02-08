package brick;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class display implements KeyListener {

	private JFrame frame;
	private int height, width;
	private String title;
	private Canvas canvas;
	
	public display(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;	
		
		
		
		createDisplay(width, height, title);
	}
	
	private void createDisplay(int width, int height, String title) {
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.addKeyListener(this);
		canvas.setFocusable(true);
		
		frame.add(canvas);
		frame.pack();
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Loop.setGoRight();
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			Loop.setGoLeft();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
