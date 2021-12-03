import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class GameWindow extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Timer frameDraw;
	CommanderCody cody = new CommanderCody(250, 700, 50, 50);

	GameWindow() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		g.fillRect(10, 10, 100, 100);
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
			
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	void updateMenuState() {
	}

	void updateGameState() {
	}

	void updateEndState() {
	}

	void drawMenuState(Graphics g) {

	}

	void drawGameState(Graphics g) {
		cody.draw(g);
		System.out.println("draw");
		
	}

	void drawEndState(Graphics g) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		repaint();
		//System.out.println("action");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println(currentState);
			if (currentState == MENU) {
				currentState = GAME;
			}
	
			if (currentState == END) {
				currentState = MENU;
			} 
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("UP");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}